package com.example.quizapp.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quizapp.domain.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.example.quizapp.R
import com.example.quizapp.ui.vm.QuizIntent
import com.example.quizapp.ui.vm.QuizViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(viewModel: QuizViewModel) {
    val state by viewModel.viewState.collectAsState()
    val currentQuestion = state.questions.getOrNull(state.currentQuestionIndex)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.quiz_title)) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AnimatedContent(
                        targetState = currentQuestion,
                        transitionSpec = {
                            (slideInHorizontally(animationSpec = tween(300)) { fullWidth -> fullWidth } + fadeIn(
                                animationSpec = tween(300)
                            )).togetherWith(slideOutHorizontally(animationSpec = tween(300)) { fullWidth -> -fullWidth } + fadeOut(
                                animationSpec = tween(300)
                            ))
                        }, label = ""
                    ) { question ->
                        if (question != null) {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                shape = MaterialTheme.shapes.medium
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(
                                        text = question.questionText,
                                        style = MaterialTheme.typography.headlineSmall,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    when (question) {
                                        is TrueFalseQuestion -> TrueFalseQuestionContent()
                                        is SingleChoiceQuestion -> SingleChoiceQuestionContent(question)
                                        is MultipleChoiceQuestion -> MultipleChoiceQuestionContent(question)
                                        is TextQuestion -> TextQuestionContent()
                                    }
                                }
                            }
                        } else {
                            CircularProgressIndicator()
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = { viewModel.processIntent(QuizIntent.NextQuestion) },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = stringResource(id = R.string.next_button))
                    }
                }
            }
        }
    )
}

@Composable
fun TrueFalseQuestionContent() {
    var selected by remember { mutableStateOf<Boolean?>(null) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected == true, onClick = { selected = true })
        Text(text = "True", modifier = Modifier
            .padding(start = 8.dp)
            .clickable { selected = true })
        Spacer(modifier = Modifier.width(16.dp))
        RadioButton(selected = selected == false, onClick = { selected = false })
        Text(text = "False", modifier = Modifier
            .padding(start = 8.dp)
            .clickable { selected = false })
    }
}

@Composable
fun SingleChoiceQuestionContent(question: SingleChoiceQuestion) {
    var selectedOption by remember { mutableStateOf<String?>(null) }
    Column {
        question.options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { selectedOption = option }
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { selectedOption = option }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option)
            }
        }
    }
}

@Composable
fun MultipleChoiceQuestionContent(question: MultipleChoiceQuestion) {
    val selectedOptions = remember { mutableStateListOf<String>() }
    Column {
        question.options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable {
                        if (selectedOptions.contains(option))
                            selectedOptions.remove(option)
                        else
                            selectedOptions.add(option)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = selectedOptions.contains(option),
                    onCheckedChange = { checked ->
                        if (checked) selectedOptions.add(option) else selectedOptions.remove(option)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option)
            }
        }
    }
}

@Composable
fun TextQuestionContent() {
    var textResponse by remember { mutableStateOf("") }
    OutlinedTextField(
        value = textResponse,
        onValueChange = { textResponse = it },
        label = { Text(text = stringResource(id = R.string.your_answer_hint)) },
        modifier = Modifier.fillMaxWidth()
    )
}
