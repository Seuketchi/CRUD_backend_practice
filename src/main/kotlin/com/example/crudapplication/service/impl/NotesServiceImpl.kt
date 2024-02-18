package com.example.crudapplication.service.impl

import com.example.crudapplication.dto.NotesDTO
import com.example.crudapplication.model.Notes
import com.example.crudapplication.repository.NotesRepository
import com.example.crudapplication.service.NotesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NotesServiceImpl @Autowired constructor(
        private val notesRepository: NotesRepository
) : NotesService {
    override fun createNotes(notesDTO: NotesDTO): NotesDTO {
        val note = Notes(
                title = notesDTO.title,
                content = notesDTO.content
        )

        notesRepository.save(note)

        val noteResponse = NotesDTO(
                id = note.id,
                title = note.title,
                content = note.content
        )

        return noteResponse
    }

}