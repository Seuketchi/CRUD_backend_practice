package com.example.crudapplication.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
data class Notes(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //handles generation of primary key
        val id: Long? = null,
        val title: String,
        val content: String
)
