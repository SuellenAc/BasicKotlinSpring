package com.suellencolangelo.forum.controller

import com.suellencolangelo.forum.dto.TopicDto
import com.suellencolangelo.forum.model.Answer
import com.suellencolangelo.forum.model.Topic
import com.suellencolangelo.forum.service.TopicService
import org.springframework.web.bind.annotation.*

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
    fun searchByAnswerFromTopic(@PathVariable id: Long): List<Answer> {
        return service.searchByAnswerFromTopic(id)
    }

    @PostMapping
    fun register(@RequestBody dto: TopicDto) {
        service.register(dto)
    }

}