package ir.wordpress.model

data class VerificationRequest(
    val phoneNumber: String,
    val action: String

)
