package com.example.quizapp.di

import com.example.quizapp.data.QuizRepository
import com.example.quizapp.data.QuizRepositoryImpl
import com.example.quizapp.ui.vm.QuizViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single<QuizRepository> { QuizRepositoryImpl(context = get()) }
    viewModel { QuizViewModel(get()) }
}
