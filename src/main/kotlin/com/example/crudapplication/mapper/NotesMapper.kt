package com.example.crudapplication.mapper

import com.example.crudapplication.dto.NotesDTO
import com.example.crudapplication.model.Notes
import org.mapstruct.Mapping


interface NotesMapper {

    @Mapping(target = "id", source = "id")
    fun mapToDTO(notesDTO: Notes) : NotesDTO // Converting from Notes to NotesDTO
    @Mapping(target = "id", source = "id")
    fun mapToModel(notes: NotesDTO) : Notes // Converting from NotesDTO to Notes
}