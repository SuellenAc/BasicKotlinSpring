package com.suellencolangelo.forum.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello") // endereço
class HelloController {

    @GetMapping // requisição do tipo get faz a chamada do metodo anotado com getMapping
    fun hello(): String = "Hello World! Alterado"
}