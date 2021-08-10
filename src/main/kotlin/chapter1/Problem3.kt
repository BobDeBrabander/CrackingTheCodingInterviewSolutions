package chapter1

object Problem3 {

    fun URLify(input: MutableList<Char>, inputLength: Int) : MutableList<Char>{
        var pointer = input.lastIndex
        for (i in inputLength-1 downTo 0){
            if (input[i] == ' '){
                input.pasteUpto("%20", pointer)
                pointer -= 3
            } else {
                input[pointer] = input[i]
                pointer--
            }
        }
        return input
    }

    private fun MutableList<Char>.pasteUpto(toPaste: String, uptoIndex: Int){
        var index = uptoIndex
        for (i in toPaste.lastIndex downTo 0){
            this[index] = toPaste[i]
            index--
        }
    }
}