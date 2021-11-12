package com.suellencolangelo.forum.service

import com.suellencolangelo.forum.model.domain.User
import org.springframework.stereotype.Service

@Service
class AuthorService {
    private val dummyAuthor: User = User(
        id = 1,
        name = "Fernanda",
        email = "fernanda@gmail.com.br"
    )

    private val authors: List<User> = listOf(dummyAuthor)

    fun searchById(id: Long): User = authors.firstOrNull { it.id == id } ?: dummyAuthor.copy(id = id)

}
