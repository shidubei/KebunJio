package iss.nus.edu.sg.sa4106.kebunjio.data

data class User(
    val id: String,
    val username: String,
    val email: String,
    val phoneNumber: String,
    val isAdmin: Boolean
)
