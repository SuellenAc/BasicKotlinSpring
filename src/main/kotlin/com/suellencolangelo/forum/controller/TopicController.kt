package com.suellencolangelo.forum.controller

import com.suellencolangelo.forum.mapper.AnswerToViewMapper
import com.suellencolangelo.forum.mapper.TopicToViewMapper
import com.suellencolangelo.forum.model.form.TopicForm
import com.suellencolangelo.forum.model.view.AnswerView
import com.suellencolangelo.forum.model.view.TopicView
import com.suellencolangelo.forum.service.TopicService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topics") // URI
class TopicController(
    private val service: TopicService,
    private val topicToViewMapper: TopicToViewMapper,
    private val answerToViewMapper: AnswerToViewMapper,
) {

    @GetMapping
    fun list(): List<TopicView> {
        // Spring usa jackson para converter essa lista para o mediatype json
        return service.list().map { topicToViewMapper.mapFrom(it) }
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long): TopicView? {
        return service.searchById(id)?.let { topicToViewMapper.mapFrom(it) }
    }

    @GetMapping("/{id}/answers")
    fun searchByAnswerFromTopic(@PathVariable id: Long): List<AnswerView> {
        return service.searchByAnswerFromTopic(id).map { answerToViewMapper.mapFrom(it) }
    }

    @PostMapping
    fun register(@RequestBody @Valid dto: TopicForm) {
        service.register(dto)
    }

}