package com.example.crudapplication.service

import com.example.crudapplication.dto.NotesDTO
import com.example.crudapplication.model.Notes

interface NotesService {
  fun createNotes(notesDTO: NotesDTO): NotesDTO
}