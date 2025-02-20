<h1>Personal Quiz App</h1>

<p>
  A simple single-screen quiz application built using Jetpack Compose, Material3, and a structured architecture that leverages <strong>MVVM</strong> with <strong>MVI</strong>, <strong>Clean Architecture</strong> principles, and <strong>Koin</strong> for dependency injection. This project demonstrates a minimal yet well-organized approach to building a Compose app with animated transitions between personal-style quiz questions.
</p>

<h2>Features</h2>
<ul>
  <li><strong>Personal Quiz Questions:</strong> Explore personal-style questions including preferences and personality insights.</li>
  <li><strong>Multiple Question Types:</strong> Supports True/False, Single Choice, Multiple Choice, and Text Input questions.</li>
  <li><strong>Animated Transitions:</strong> Enjoy smooth, animated transitions between questions using Compose's <code>AnimatedContent</code>.</li>
  <li><strong>Clean Architecture:</strong> Organized into domain, data, and presentation layers to ensure a clear separation of concerns.</li>
  <li><strong>MVVM with MVI Pattern:</strong> Implements a simple MVI approach within an MVVM architecture for efficient state management.</li>
  <li><strong>Dependency Injection with Koin:</strong> Uses Koin to manage dependencies, making the codebase modular and testable.</li>
  <li><strong>Material3 UI:</strong> Uses Material3 components for a modern, responsive design.</li>
</ul>

<h2>Tech Stack</h2>
<ul>
  <li><strong>Kotlin</strong></li>
  <li><strong>Jetpack Compose</strong> – For building the UI.</li>
  <li><strong>Material3</strong> – For modern UI components.</li>
  <li><strong>MVVM Architecture</strong> – For separation of UI and business logic.</li>
  <li><strong>MVI Pattern</strong> – For unidirectional data flow and state management.</li>
  <li><strong>Clean Architecture</strong> – To structure the code into distinct layers (domain, data, and presentation).</li>
  <li><strong>Koin</strong> – For dependency injection, enabling easy testing and modularity.</li>
</ul>

<h2>Project Structure</h2>
<pre>
QuizApp/
└── app/
    ├── src/
    │   └── main/
    │       ├── java/
    │       │   └── com/
    │       │       └── example/
    │       │           └── quizapp/
    │       │               ├── MainActivity.kt         // App entry point
    │       │               ├── QuizApplication.kt        // Application class (Koin setup)
    │       │               ├── di/
    │       │               │   └── AppModule.kt            // Dependency Injection modules
    │       │               ├── data/
    │       │               │   └── QuizRepository.kt       // Data layer implementation
    │       │               ├── domain/
    │       │               │   └── Question.kt             // Domain models for questions
    │       │               └── presentation/
    │       │                   ├── QuizScreen.kt           // Compose UI screen with animations
    │       │                   └── QuizViewModel.kt        // ViewModel with MVVM/MVI logic
    │       └── res/
    │           └── values/
    │               └── strings.xml                        // Centralized string resources
    └── build.gradle                                         // App-level Gradle file
</pre>

<h2>Getting Started</h2>
<ol>
  <li>
    <p><strong>Clone the Repository:</strong></p>
    <pre><code>git clone https://github.com/KareemMansy123/Quiz-App.git</code></pre>
  </li>
  <li>
    <p><strong>Open in Android Studio:</strong></p>
    <ul>
      <li>Launch Android Studio and select <em>Open an existing project</em>.</li>
      <li>Navigate to the cloned repository and open it.</li>
    </ul>
  </li>
  <li>
    <p><strong>Build and Run:</strong></p>
    <ul>
      <li>Ensure you have the latest version of Android Studio and the required SDKs.</li>
      <li>Build the project and run it on an emulator or a physical device.</li>
    </ul>
  </li>
</ol>

<h2>Architectural Decisions</h2>
<ul>
  <li><strong>Clean Architecture:</strong> The app is divided into distinct layers (Domain, Data, and Presentation) to enhance maintainability and testability.</li>
  <li><strong>MVVM with MVI Pattern:</strong> The <code>QuizViewModel</code> processes user actions (intents) such as loading questions and navigating to the next question, updating the UI state in a unidirectional flow.</li>
  <li><strong>Dependency Injection:</strong> Koin is utilized to manage dependencies (e.g., Repository, ViewModel), decoupling components and simplifying testing.</li>
</ul>

<h2>Contributing</h2>
<p>
  Contributions are welcome! Please fork the repository and open a pull request with your changes.
</p>

<h2>License</h2>
<p>
  This project is licensed under the MIT License. See the <a href="LICENSE">LICENSE</a> file for details.
</p>
