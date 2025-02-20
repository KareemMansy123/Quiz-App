package com.example.quizapp.ui.vm

import androidx.lifecycle.ViewModel
import com.example.quizapp.data.QuizRepository
import com.example.quizapp.domain.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// UI state representing the current quiz status
data class QuizViewState(
    val currentQuestionIndex: Int = 0,
    val questions: List<Question> = emptyList()
)

sealed class QuizIntent {
    object LoadQuestions : QuizIntent()
    object NextQuestion : QuizIntent()
}

class QuizViewModel(
    private val repository: QuizRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(QuizViewState())
    val viewState: StateFlow<QuizViewState> = _viewState

    init {
        processIntent(QuizIntent.LoadQuestions)
    }

    fun processIntent(intent: QuizIntent) {
        when (intent) {
            QuizIntent.LoadQuestions -> loadQuestions()
            QuizIntent.NextQuestion -> nextQuestion()
        }
    }

    private fun loadQuestions() {
        val questions = repository.getQuestions()
        _viewState.value = QuizViewState(currentQuestionIndex = 0, questions = questions)
    }

    private fun nextQuestion() {
        val currentIndex = _viewState.value.currentQuestionIndex
        if (currentIndex < _viewState.value.questions.size - 1) {
            _viewState.value = _viewState.value.copy(currentQuestionIndex = currentIndex + 1)
        } else {
            _viewState.value = _viewState.value.copy(currentQuestionIndex = 0)
        }
    }
}
