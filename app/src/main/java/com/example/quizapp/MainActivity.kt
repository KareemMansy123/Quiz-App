package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.material3.MaterialTheme
import com.example.quizapp.ui.QuizScreen
import com.example.quizapp.ui.vm.QuizViewModel

class MainActivity : ComponentActivity() {

    // Inject the QuizViewModel via Koin
    private val quizViewModel: QuizViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                QuizScreen(viewModel = quizViewModel)
            }
        }
    }
}
