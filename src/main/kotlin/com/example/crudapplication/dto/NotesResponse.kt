package com.example.crudapplication.dto

import lombok.Data

@Data
data class NotesResponse (
    val content : List<NotesDTO>,
    val pageNumber : Int,
    val pageSize : Int,
    val totalPages : Int,
    val totalElements : Long,
    val last : Boolean,
    ){
}