package com.example.quizapp.data
import android.content.Context
import com.example.quizapp.R
import com.example.quizapp.domain.*

interface QuizRepository {
    fun getQuestions(): List<Question>
}

class QuizRepositoryImpl(private val context: Context) : QuizRepository {
    override fun getQuestions(): List<Question> = listOf(
        TrueFalseQuestion(context.getString(R.string.true_false_question)),
        SingleChoiceQuestion(
            context.getString(R.string.single_choice_question),
            listOf(
                context.getString(R.string.single_choice_option_1),
                context.getString(R.string.single_choice_option_2),
                context.getString(R.string.single_choice_option_3),
                context.getString(R.string.single_choice_option_4)
            )
        ),
        MultipleChoiceQuestion(
            context.getString(R.string.multiple_choice_question),
            listOf(
                context.getString(R.string.multiple_choice_option_1),
                context.getString(R.string.multiple_choice_option_2),
                context.getString(R.string.multiple_choice_option_3),
                context.getString(R.string.multiple_choice_option_4)
            )
        ),
        TextQuestion(context.getString(R.string.text_question))
    )
}
