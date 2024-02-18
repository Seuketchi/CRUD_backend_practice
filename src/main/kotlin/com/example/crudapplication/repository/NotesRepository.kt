package com.example.crudapplication.repository

import com.example.crudapplication.model.Notes
import org.springframework.data.jpa.repository.JpaRepository

interface NotesRepository : JpaRepository<Notes, Long>{
}