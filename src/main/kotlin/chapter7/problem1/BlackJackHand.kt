package chapter7.problem1

class BlackJackHand {
    private val cards = mutableListOf<Card>()

    fun handValue() : BlackJackScore{
        val ranksGrouped = cards.map{it.rank.value}.groupBy { it is CardValue.SingleValue}
        val baseScore = ranksGrouped[true]?.map{(it as CardValue.SingleValue).value}?.sum() ?: 0
        val permutations = mutableListOf<Int>()
        generatePermutations(ranksGrouped[false]?.map{it as CardValue.MultipleValue} ?: emptyList(), permutations, 0, 0)
        val allScores = permutations.distinct()
            .map{it + baseScore}
            .map{
                if (it > 21) BlackJackScore.Dead(it)
                else BlackJackScore.Score(it)
            }
        val scoreScores = allScores.filter{it is BlackJackScore.Score}
        val deadScores = allScores.filter{it is BlackJackScore.Dead}

        return scoreScores.maxByOrNull { (it as BlackJackScore.Score).Score } ?:
        deadScores.minByOrNull { (it as BlackJackScore.Dead).Score } ?: BlackJackScore.Score(0)
    }

    private fun generatePermutations(lists: List<CardValue.MultipleValue>, result: MutableList<Int>, depth: Int, current: Int) {
        if (depth == lists.size) {
            result.add(current)
            return
        }
        for (i in lists[depth].values.indices) {
            generatePermutations(lists, result, depth + 1, current + lists[depth].values[i])
        }
    }
}