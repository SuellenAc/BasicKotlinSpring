package com.suellencolangelo.forum.service

import com.suellencolangelo.forum.mapper.CourseFormToDomainMapper
import com.suellencolangelo.forum.model.domain.Course
import com.suellencolangelo.forum.model.form.CourseForm
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseFormToDomainMapper: CourseFormToDomainMapper) {

    private val dummyCourse: Course = Course(
        id = 1,
        name = "Kotlin",
        category = "Programação"
    )

    private val courses: MutableList<Course> = mutableListOf(dummyCourse)

    fun searchById(id: Long): Course = courses.firstOrNull { it.id == id } ?: dummyCourse.copy(id = id)

    fun list(): List<Course> = courses

    fun register(from: CourseForm): Course {
        val course = courseFormToDomainMapper.mapFrom(from)
        courses.add(course)
        return course
    }
}
