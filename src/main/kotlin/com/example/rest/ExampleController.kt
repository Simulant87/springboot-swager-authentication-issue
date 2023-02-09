package com.example.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class ExampleController {

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/hello/{id}"],
        produces = ["application/json"]
    )
    fun hello(@PathVariable id: String): ResponseEntity<String> {
        println("received request with ID: $id")
        return ResponseEntity.ok("hello $id")
    }
}
