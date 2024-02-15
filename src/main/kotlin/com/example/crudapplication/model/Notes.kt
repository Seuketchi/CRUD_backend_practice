package com.example.crudapplication.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor


@Entity
//@Table(name = "notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
data class Notes(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //handles generation of primary key
        var id: Long,
        val title: String,
        val content: String
)