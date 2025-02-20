package com.example.quizapp.domain

sealed class Question {
    abstract val questionText: String
}

data class TrueFalseQuestion(
    override val questionText: String,
) : Question()

data class SingleChoiceQuestion(
    override val questionText: String,
    val options: List<String>
) : Question()

data class MultipleChoiceQuestion(
    override val questionText: String,
    val options: List<String>
) : Question()

data class TextQuestion(
    override val questionText: String,
) : Question()
