package chapter1


object Problem6 {

    fun compressString(input: String) : String {
        if (input.isEmpty()) return input
        val stringBuilder = StringBuilder()
        var curChar = input[0]
        var curCounter = 0

        input.forEachIndexed { i, c ->
            if (curChar == c) {
                curCounter++
            } else {
                stringBuilder.append(curChar)
                stringBuilder.append(curCounter)
                curChar = c
                curCounter = 1
            }
        }
        stringBuilder.append(curChar)
        stringBuilder.append(curCounter)

        val compressString = stringBuilder.toString()
        return if (compressString.length < input.length) compressString else input
    }
}