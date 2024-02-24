package com.example.crudapplication.mapper.impl

import com.example.crudapplication.dto.NotesDTO
import com.example.crudapplication.mapper.NotesMapper
import com.example.crudapplication.model.Notes
import org.mapstruct.Mapper
import org.springframework.stereotype.Component


@Component
@Mapper
class NotesMapperImpl : NotesMapper {

    override fun mapToDTO(notesDTO: Notes): NotesDTO {
        return NotesDTO(
            id = notesDTO.id, title = notesDTO.title, content = notesDTO.content
        )
    }

    override fun mapToModel(notes: NotesDTO): Notes {
        return Notes(
            id = notes.id, title = notes.title, content = notes.content
        )
    }
}