package az.isfan.test3205.general

sealed class Cavab<out T> {
    data object StandBy: Cavab<Nothing>()

    data object Loading: Cavab<Nothing>()

    data class Success<out T>(
        val data: T
    ): Cavab<T>() {
        override fun toString(): String {
            return "Success = $data"
        }
    }

    data class Error(
        val e: String
    ): Cavab<Nothing>() {
        override fun toString(): String {
            return "Failure = $e"
        }
    }
}