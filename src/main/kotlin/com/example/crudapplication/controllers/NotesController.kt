package com.example.crudapplication.controllers

import com.example.crudapplication.dto.NotesDTO
import com.example.crudapplication.dto.NotesResponse
import com.example.crudapplication.service.NotesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/")
class NotesController @Autowired constructor(
    private val noteService: NotesService

) {

    @GetMapping("notes")
    fun getListOfNotes(
        @RequestParam(value = "pageNo", defaultValue = "0", required = false) pageNo: Int,
        @RequestParam(value = "pageSize", defaultValue = "10", required = false) pageSize: Int
    ): ResponseEntity<NotesResponse> {
        return ResponseEntity(noteService.getAllNotes(pageNo, pageSize), HttpStatus.OK)
    }

    @GetMapping("notes/{id}")
    fun getNote(@PathVariable id: Long): ResponseEntity<NotesDTO> {
        return ResponseEntity(noteService.getNoteByID(id), HttpStatus.OK)
    }

    @PostMapping("notes/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createNote(@RequestBody notesDTO: NotesDTO): ResponseEntity<NotesDTO> {
        return ResponseEntity(noteService.createNotes(notesDTO), HttpStatus.CREATED)
    }

    @PutMapping("notes/{id}/update")
    fun updateNote(@RequestBody note: NotesDTO, @PathVariable("id") notesId: Long): ResponseEntity<NotesDTO> {
        return ResponseEntity(noteService.updateNoteByID(notesId, note), HttpStatus.OK)
    }

    @DeleteMapping("notes/{id}/delete")
    fun deleteNote(@PathVariable("id") notesId: Long): ResponseEntity<Unit> {
        return ResponseEntity(noteService.deleteNoteByID(notesId), HttpStatus.OK)
    }
}