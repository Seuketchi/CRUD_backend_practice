package com.example.crudapplication.repository

import com.example.crudapplication.dto.NotesDTO
import com.example.crudapplication.model.Notes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NotesRepository : JpaRepository<Notes, Long>{
}