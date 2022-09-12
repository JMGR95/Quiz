package garcia.miguel.quiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


private const val TAG = "QuizViewModel"

class QuizViewModel(private val savedStateHandle : SavedStateHandle) : ViewModel() {
    /*
    init {
        Log.d(TAG, "Se creó el viewModel")
    }
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "Se eliminó el viewModel")
    }
     */
    private val questionBank = listOf(
        Pregunta(R.string.pregunta, true),
        Pregunta(R.string.pregunta2, false),
        Pregunta(R.string.pregunta3, true),
        Pregunta(R.string.pregunta4, false)
    )

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].respuesta

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textoPregunta

    fun moveToNext(){
        currentIndex = (currentIndex +  1) % questionBank.size
    }

}
