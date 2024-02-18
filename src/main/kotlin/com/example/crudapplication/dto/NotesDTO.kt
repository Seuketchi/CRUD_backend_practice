package com.example.crudapplication.dto

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Data

//DTO is useful for getting only the necessary Data rather than the Model itself

@Data
data class NotesDTO(
        val id: Long?,
        var title: String,
        var content: String
) {

}