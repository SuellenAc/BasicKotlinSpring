package com.suellencolangelo.forum.controller

import com.suellencolangelo.forum.model.form.TopicForm
import com.suellencolangelo.forum.model.view.AnswerView
import com.suellencolangelo.forum.model.view.TopicView
import com.suellencolangelo.forum.model.view.toView
import com.suellencolangelo.forum.service.TopicService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics") // URI
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        // Spring usa jackson para converter essa lista para o mediatype json
        return service.list().map { it.toView() }
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long): TopicView? {
        return service.searchById(id)?.toView()
    }

    @GetMapping("/{id}/answers")
    fun searchByAnswerFromTopic(@PathVariable id: Long): List<AnswerView> {
        return service.searchByAnswerFromTopic(id).map { it.toView() }
    }

    @PostMapping
    fun register(@RequestBody dto: TopicForm) {
        service.register(dto)
    }

}