package com.suellencolangelo.forum.service

import com.suellencolangelo.forum.model.domain.Course
import org.springframework.stereotype.Service

@Service
class CourseService {

    private val dummyCourse: Course = Course(
        id = 1,
        name = "Kotlin",
        category = "Programação"
    )

    private val courses: List<Course> = listOf(dummyCourse)

    fun searchById(id: Long): Course = courses.firstOrNull { it.id == id } ?: dummyCourse.copy(id = id)
}
