package com.example.crudapplication.service

import com.example.crudapplication.dto.NotesDTO
import com.example.crudapplication.dto.NotesResponse

interface NotesService {
  fun createNotes(notesDTO: NotesDTO): NotesDTO
  fun getAllNotes(pageNo : Int, pageSize : Int): NotesResponse
  fun getNoteByID(id : Long): NotesDTO
  fun deleteNoteByID(id : Long)
  fun updateNoteByID(id : Long, notesDTO: NotesDTO): NotesDTO

}