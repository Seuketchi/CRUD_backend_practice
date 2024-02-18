package com.example.crudapplication.controllers

import com.example.crudapplication.dto.NotesDTO
import com.example.crudapplication.model.Notes
import com.example.crudapplication.service.NotesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import java.util.ArrayList

@RestController
@RequestMapping("/api/")
class NotesController @Autowired constructor(
        private val noteService: NotesService

){

    @GetMapping("notes")
    fun getListOfNotes(): ResponseEntity<List<Notes>> {
        val notes = ArrayList<Notes>()
        notes.add(Notes(1, "Title", "content"))
        notes.add(Notes(2, "Title2", "content2"))
        return ResponseEntity.ok(notes);
    }

    @GetMapping("notes/{id}")
    fun getNote(@PathVariable id: Long): Notes {
        return Notes(id, "Title", "content")
    }

    @PostMapping("notes/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createNote(@RequestBody notesDTO: NotesDTO): ResponseEntity<NotesDTO> {
        return ResponseEntity(noteService.createNotes(notesDTO), HttpStatus.CREATED)
    }

    @PutMapping("notes/{id}/update")
    fun updateNote(@RequestBody note: Notes, @PathVariable("id") notesId: Long): ResponseEntity<Notes> {
        println(note.title)
        println(note.content)
        return ResponseEntity.ok(note)
    }

    @DeleteMapping("notes/{id}/delete")
    fun deleteNote(@PathVariable("id") notesId: Long):ResponseEntity<String> {
        println(notesId)
        return ResponseEntity.ok("Pokemon deleted successfully")
    }
}