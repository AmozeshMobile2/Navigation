package ir.wordpress.navigation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ir.wordpress.model.VerificationRequest
import ir.wordpress.network.PhoneApi
import ir.wordpress.network.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONArray
import retrofit.Callback
import retrofit.Response
import retrofit.Retrofit
import kotlin.math.log

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {

            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type=NavType.StringType
                    defaultValue="Amir"
                    nullable=true
                }
            )
        ){entry ->
            DetailScreen(name =entry.arguments?.getString("name") )
        }

    }
}


@Composable
fun MainScreen(navController: NavHostController) {
    var text by remember { mutableStateOf("") }
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp)
    ) {

        TextField(
            value = text, onValueChange = {

                text = it

            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
//                navController.navigate(Screen.DetailScreen.withArgs(text))

//        val retrofit=RetrofitHelper.getInstance().create(PhoneApi::class.java)
//                retrofit.gethone().enqueue(object : Callback<VerificationRequest>{
//                    override fun onResponse(
//                        response: Response<VerificationRequest>?,
//                        retrofit: Retrofit?
//                    ) {
//                        Log.d("tag",response.toString())
//                    }
//
//                    override fun onFailure(t: Throwable?) {
//                        Log.d("tag",t.toString())
//                    }
//
//
//                })
                        val retrofit=RetrofitHelper.getInstance().create(PhoneApi::class.java)

                GlobalScope.launch {
                    val result=retrofit.getphone()
                    if(result != null){
                        Log.e("result",result.body().toString())

                    }
                    Log.e("","")
                }


//  CoroutineScope(Dispatchers.IO).launch {
//
//      getDataFromApi(text)
//  }

            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To DetailScreen")
        }
    }
}


@Composable
fun DetailScreen(name: String?) {

    Box(contentAlignment = Alignment.Center, modifier =  Modifier.fillMaxSize()){

        Text(text = "Hello, $name")
    }

}


private suspend fun getDataFromApi(name : String?) : String{

    Log.d("TAG", "getDataFromApi: ")
    delay(2000)
    return "$name is not correct."


}