package com.example.crudapplication.service.impl

import com.example.crudapplication.dto.NotesDTO
import com.example.crudapplication.dto.NotesResponse
import com.example.crudapplication.exceptions.NoteNotFoundException
import com.example.crudapplication.mapper.NotesMapper
import com.example.crudapplication.model.Notes
import com.example.crudapplication.repository.NotesRepository
import com.example.crudapplication.service.NotesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class NotesServiceImpl @Autowired constructor(
    private val notesRepository: NotesRepository,
    private val notesMapper: NotesMapper,
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

    override fun getAllNotes(pageNo: Int, pageSize : Int): NotesResponse {
        val pageable = PageRequest.of(pageNo, pageSize)
        val notes : Page<Notes> = notesRepository.findAll(pageable)
        val notesList : List<Notes> = notes.content
        val content : List<NotesDTO> = notesList.map { note -> notesMapper.mapToDTO(note) }.toList()

        val notesResponse : NotesResponse = NotesResponse(
            content = content,
            pageNumber = notes.number,
            pageSize = notes.size,
            totalPages = notes.totalPages,
            totalElements = notes.totalElements,
            last = notes.isLast
        )

        return notesResponse
    }

    override fun getNoteByID(id: Long): NotesDTO {
        notesRepository.findById(id).orElseThrow { NoteNotFoundException("Note with id $id not found") }.let {
            return notesMapper.mapToDTO(it)
        }
    }

    override fun deleteNoteByID(id: Long) {
        notesRepository.deleteById(id)
    }

    override fun updateNoteByID(id: Long, notesDTO: NotesDTO): NotesDTO {
        notesRepository.findById(id).orElseThrow { NoteNotFoundException("Note with id $id not found") }.let {
            it.title = notesDTO.title
            it.content = notesDTO.content
            notesRepository.save(it)
            return notesMapper.mapToDTO(it)
        }
    }
}