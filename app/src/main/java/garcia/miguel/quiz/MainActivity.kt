package garcia.miguel.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import garcia.miguel.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //private lateinit var trueButton: Button
    //private lateinit var falseButton: Button

    private val questionBank = listOf(
        Pregunta(R.string.pregunta, true),
        Pregunta(R.string.pregunta2, false),
        Pregunta(R.string.pregunta3, true),
        Pregunta(R.string.pregunta4, false)
    )

    private var currentIndex:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //trueButton = findViewById(R.id.true_button)
        //falseButton = findViewById(R.id.false_button)

        binding.trueButton.setOnClickListener { view: View ->
            val mySnack= Snackbar.make(view, R.string.correct_toast, Snackbar.LENGTH_LONG)
            mySnack.setBackgroundTint(resources.getColor(R.color.verde))
            mySnack.show()
            /*Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT
            ).show()*/
        }

        binding.falseButton.setOnClickListener { view: View ->
            // Haz algo en respuesta al hacer click aqui
            val mySnack= Snackbar.make(view, R.string.incorrect_toast, Snackbar.LENGTH_LONG)
            mySnack.setBackgroundTint(resources.getColor(R.color.rojo))
            mySnack.show()
            /*Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT
            ).show()*/
        }

        val preguntaTextResId = questionBank[currentIndex].textoPregunta
        binding.questionTextview.setText(preguntaTextResId)


    }
}