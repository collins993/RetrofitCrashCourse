package io.github.collins993.retrofitcrashcourse

data class MyTodo(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)