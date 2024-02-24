package com.example.crudapplication.service

import com.example.crudapplication.dto.NotesDTO

interface NotesService {
  fun createNotes(notesDTO: NotesDTO): NotesDTO
  fun getAllNotes(): List<NotesDTO>
  fun getNoteByID(id : Long): NotesDTO
  fun deleteNoteByID(id : Long)
  fun updateNoteByID(id : Long, notesDTO: NotesDTO): NotesDTO
}