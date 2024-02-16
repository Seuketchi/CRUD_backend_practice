package com.example.crudapplication.controllers

import com.example.crudapplication.model.Notes
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.util.ArrayList

@RestController
@RequestMapping("/api/")
class NotesController {

    @GetMapping("notes")
    fun getNotes(): ResponseEntity<List<Notes>> {
        val listOfNotes = ArrayList<Notes>()
        listOfNotes.add(Notes(1,"Title", "content"))
        listOfNotes.add(Notes(2,"Title2", "content2"))
        return ResponseEntity.ok(listOfNotes);
    }
}