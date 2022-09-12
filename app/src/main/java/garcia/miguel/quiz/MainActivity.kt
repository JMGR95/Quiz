package garcia.miguel.quiz

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import garcia.miguel.quiz.databinding.ActivityMainBinding


private const val TAG = "MainActivity"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quizViewModel: QuizViewModel by viewModels()

    //private lateinit var trueButton: Button
    //private lateinit var falseButton: Button

    /*
    private val questionBank = listOf(
        Pregunta(R.string.pregunta, true),
        Pregunta(R.string.pregunta2, false),
        Pregunta(R.string.pregunta3, true),
        Pregunta(R.string.pregunta4, false)
    )

    private var currentIndex:Int = 0
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //trueButton = findViewById(R.id.true_button)
        //falseButton = findViewById(R.id.false_button)

        binding.trueButton.setOnClickListener { view: View ->
            /*val mySnack= Snackbar.make(view, R.string.correct_toast, Snackbar.LENGTH_LONG)
            mySnack.setBackgroundTint(resources.getColor(R.color.verde))
            mySnack.show()*/
            /*Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT
            ).show()*/
            checkAnswer(true, view)
        }

        binding.falseButton.setOnClickListener { view: View ->
            /*val mySnack= Snackbar.make(view, R.string.incorrect_toast, Snackbar.LENGTH_LONG)
            mySnack.setBackgroundTint(resources.getColor(R.color.rojo))
            mySnack.show()*/
            /*Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT
            ).show()*/
            checkAnswer(false, view)
        }

        binding.nextButton.setOnClickListener {
            //currentIndex = (currentIndex + 1) % questionBank.size
            //val preguntaTextResId = questionBank[currentIndex].textoPregunta
            //binding.questionTextview.setText(preguntaTextResId)
            quizViewModel.moveToNext()
            updateQuestion()
        }

        //val preguntaTextResId = questionBank[currentIndex].textoPregunta
        //binding.questionTextview.setText(preguntaTextResId)
        updateQuestion()
    }

    override fun onStart(){
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    private fun updateQuestion(){
        //val preguntaTextResId = questionBank[currentIndex].textoPregunta
        val preguntaTextResId = quizViewModel.currentQuestionText
        binding.questionTextview.setText(preguntaTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean, view : View){
        //val correctAnswer = questionBank[currentIndex].respuesta
        val correctAnswer = quizViewModel.currentQuestionAnswer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast

        } else {
            R.string.incorrect_toast

        }
        val colorBackground = if(userAnswer == correctAnswer){
            R.color.verde
        } else {
            R.color.rojo
        }

        val mySnack= Snackbar.make(view, R.string.correct_toast, Snackbar.LENGTH_LONG)
        mySnack.setBackgroundTint(getColor(colorBackground))
        mySnack.show()
    }

}