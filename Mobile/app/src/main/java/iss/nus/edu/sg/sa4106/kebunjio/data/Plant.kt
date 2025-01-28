package iss.nus.edu.sg.sa4106.kebunjio.data

import java.io.Serializable

data class Plant(
    val plantId: Int,
    val ediblePlantSpeciesId: Int,
    val userId: Int,
    val name: String
) : Serializable
