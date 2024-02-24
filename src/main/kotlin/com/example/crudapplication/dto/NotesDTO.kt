package com.example.crudapplication.dto

import lombok.Data

//DTO is useful for getting only the necessary Data rather than the Model itself

@Data
data class NotesDTO(
        val id: Long?,
        var title: String,
        var content: String
)

@Data
data class UpdateNoteTitleDTO(
        val id: Long?,
        var title: String
)

@Data
data class UpdateNoteContentDTO(
        val id: Long?,
        var content: String
)