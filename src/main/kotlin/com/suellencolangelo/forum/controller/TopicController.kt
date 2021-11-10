package com.suellencolangelo.forum.controller

import com.suellencolangelo.forum.model.Answer
import com.suellencolangelo.forum.model.Topic
import com.suellencolangelo.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long): Topic? {
        return service.searchById(id)
    }

    @GetMapping("/{id}/answers")
    fun searchByAnswerFromTopic(@PathVariable id: Long) : List<Answer> {
        return  service.searchByAnswerFromTopic(id)
    }

}