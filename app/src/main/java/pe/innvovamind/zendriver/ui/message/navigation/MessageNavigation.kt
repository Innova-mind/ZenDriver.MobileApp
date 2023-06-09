package pe.innvovamind.zendriver.ui.message.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStore

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.innvovamind.zendriver.ui.message.data.remote.MessageResponse
import pe.innvovamind.zendriver.ui.message.data.remote.MessagesClient
import pe.innvovamind.zendriver.ui.message.screens.MessageDetail
import pe.innvovamind.zendriver.ui.message.screens.Messages
import retrofit2.Call
import retrofit2.Callback

@Composable
fun MessageNavigation() {

    val viewModelStore = remember { ViewModelStore() } // Crea el ViewModelStore
    val navController = rememberNavController()
    navController.setViewModelStore(viewModelStore) // Establece el ViewModelStore

    NavHost(navController = navController,
        startDestination = "search",
    ) {
        composable("search") {

            Messages(
                selectMessage = { emitter,receiver ->
                    navController.navigate("message/${emitter}/${receiver}")
                }
            )
        }
        composable("message/{emitter}/{receiver}") { backStackEntry ->
            val emitter = backStackEntry.arguments?.getInt("emitter") as Int
            val receiver = backStackEntry.arguments?.getInt("receiver") as Int

            val messageService = MessagesClient.messageService
            val getMessage = messageService.getMessage(emitter,receiver)

            //create a mutable list of Message data type
            val message = remember {
                mutableStateListOf<MessageResponse>()
            }


            getMessage.enqueue(object : Callback<List<MessageResponse>>
            {
                override fun onResponse(
                    call: Call<List<MessageResponse>>,
                    response: retrofit2.Response<List<MessageResponse>>
                ) {
                    val messageResponse = response.body()?.get(0)
                    if (messageResponse != null) {
                        message.addAll(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<List<MessageResponse>>, t: Throwable) {
                    println("Error")
                }
            })
            message.add(MessageResponse(1,
                "Tenga buen día, al usar la aplicación, me he dado cuenta que usted cumple " +
                        "los requisitos que necesito. ¿Estaría de acuerdo en trabajar para el Grupo " +
                        "Gloria?","","",1,2))
            message.add(MessageResponse(2,
                "Buenos días, entiendo que necesita un conductor con experiencia en el manejo de " +
                        "camiones de carga pesada, con licencia AIIIB. Actualmente no está dentro de los " +
                        "planes de la empresa contratar a un nuevo conductor, pero si usted está " +
                        "interesado, podemos hacer una excepción.","","",2,1))
            message.add(MessageResponse(3,
                "Me gustaría recibir una actualización de su situación actual, para poder " +
                        "considerarlo en un futuro.","","",1,2))
            //Log.d("Message-Ni", message.toString())
            MessageDetail(messageList = message, onBack = {
                navController.popBackStack()
            })
        }
    }
}
