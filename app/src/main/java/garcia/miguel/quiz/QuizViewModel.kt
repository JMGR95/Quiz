package garcia.miguel.quiz

import android.util.Log
import androidx.lifecycle.ViewModel


private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {
    init {
        Log.d(TAG, "Se creó el viewModel")
    }
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "Se eliminó el viewModel")
    }

}
