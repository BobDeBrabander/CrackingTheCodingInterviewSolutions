package chapter16

object Problem15 {

    data class GuessResult(val hits: Int, val pseudoHits: Int)

    //Chars of guess are only RYGB
    //Strings are always exactly of length 4
    fun guessResult(actual: String, guess: String) : GuessResult{
        val hitIndices = actual
            .mapIndexed{ index, c -> index to c}
            .filter { (index, c) -> guess[index] == c }
            .map { it.first }

        val remainingActual = actual.filterIndexed { index, c -> !hitIndices.contains(index) }.toMutableList()
        guess
            .filterIndexed { index, c -> !hitIndices.contains(index) }
            .forEach { remainingActual.remove(it) }

        val hits = hitIndices.size
        val pseudoHits = 4 - hits - remainingActual.size
        return GuessResult(hits, pseudoHits)
    }
}