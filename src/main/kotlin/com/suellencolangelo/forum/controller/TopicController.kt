package com.suellencolangelo.forum.controller

import com.suellencolangelo.forum.model.Topic
import com.suellencolangelo.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics") // URI
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<Topic> {
        // Spring usa jackson para converter essa lista para o mediatype json
        return service.list()
    }


}