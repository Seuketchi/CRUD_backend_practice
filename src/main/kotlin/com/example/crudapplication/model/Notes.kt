package com.example.crudapplication.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
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
        var title: String,
        var content: String
)
