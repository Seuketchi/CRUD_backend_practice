package com.example.crudapplication.exceptions

import lombok.Data
import java.util.*

@Data
data class ErrorObject(
    private val statusCode : Int,
    private val message : String,
    private val timestamp : Date
)
