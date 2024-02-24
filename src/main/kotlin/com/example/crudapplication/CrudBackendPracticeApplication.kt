package com.example.crudapplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class CrudBackendPracticeApplication

fun main(args: Array<String>) {
    runApplication<CrudBackendPracticeApplication>(*args)
}
