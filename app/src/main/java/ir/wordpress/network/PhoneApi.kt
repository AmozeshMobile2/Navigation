package ir.wordpress.network


import ir.wordpress.model.VerificationRequest
import retrofit.Call
import retrofit.Response
import retrofit.http.GET

interface PhoneApi {
    @GET("request")
  suspend fun getphone(): Response<VerificationRequest>
}