package garcia.miguel.quiz

/*class Pregunta {
}
 */

import androidx.annotation.StringRes

data class Pregunta(@StringRes val textoPregunta: Int, val respuesta: Boolean)