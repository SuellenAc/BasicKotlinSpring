package com.suellencolangelo.forum.mapper

interface Mapper<T, O> {
    fun mapFrom(from: T): O
}