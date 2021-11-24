package com.suellencolangelo.forum.controller

import com.suellencolangelo.forum.mapper.CourseToViewMapper
import com.suellencolangelo.forum.model.form.CourseForm
import com.suellencolangelo.forum.model.view.CourseView
import com.suellencolangelo.forum.service.CourseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/courses")
class CourseController(
    private val courseService: CourseService,
    private val courseToViewMapper: CourseToViewMapper,
) {
    @GetMapping
    fun list(): List<CourseView> {
        return courseService.list().map { courseToViewMapper.mapFrom(it) }
    }

    @PostMapping
    fun register(
        uriBuilder: UriComponentsBuilder,
        @RequestBody @Valid form: CourseForm
    ): ResponseEntity<CourseView> {
        return courseService.register(form).let { course ->
            val uri = uriBuilder.path("/courses").build().toUri()
            ResponseEntity.created(uri).body(courseToViewMapper.mapFrom(course))
        }
    }
}