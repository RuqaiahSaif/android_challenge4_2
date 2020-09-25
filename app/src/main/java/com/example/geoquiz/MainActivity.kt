package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class  MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var preButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
            Question(R.string.question_text, true),
            Question(R.string.question_sanaa, true),
            Question(R.string.question_taiz, false))

    private var currentIndex = 0

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        preButton = findViewById(R.id.pre_button)
        questionTextView = findViewById(R.id.quest_text)



        trueButton.setOnClickListener {
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
            checkAnswer(false)



            nextButton.setOnClickListener {

                currentIndex = (currentIndex + 1) % questionBank.size

                updateQuestion()
            }

            updateQuestion()


            preButton.setOnClickListener {

                currentIndex = (currentIndex + 1) % questionBank.size

                updateQuestion()
            }
        }
    }
}