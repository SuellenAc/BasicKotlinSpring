package com.suellencolangelo.forum.controller

import com.suellencolangelo.forum.mapper.CourseToViewMapper
import com.suellencolangelo.forum.model.form.CourseForm
import com.suellencolangelo.forum.model.view.CourseView
import com.suellencolangelo.forum.service.CourseService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/courses")
class CourseController(
    private val courseService: CourseService,
    private val courseToViewMapper: CourseToViewMapper,
) {
    @GetMapping
    fun list() : List<CourseView> {
        return courseService.list().map { courseToViewMapper.mapFrom(it) }
    }

    @PostMapping
    fun register(@RequestBody @Valid dto: CourseForm) {
        courseService.register(dto)
    }
}