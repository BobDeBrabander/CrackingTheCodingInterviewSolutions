package chapter5

object Problem8 {

    //Given w is divisible by 8
    class Screen(w: Int, h: Int) {
        var screen = MutableList<Byte>((w / 8) * h) { 0 }
        val bytesPerRow = w / 8
        val byteMask = ((1 shl 8) - 1)

        fun drawLine(x1: Int, x2: Int, y: Int) {
            val startByte = bytesPerRow * y + x1 / 8
            val startPixel = x1 % 8

            val endByte = bytesPerRow * y + x2 / 8
            val endPixel = (x2 % 8) + 1 //Inclusive

            //Middle of the line
            for (i in startByte + 1 until endByte) screen[i] = -1

            if (startByte == endByte) {
                screen[startByte] =
                    ((((-1 shr (startPixel + 24)) and byteMask) and
                            ((-1 shl (8 - endPixel))) and byteMask)).toByte()
            } else {
                //Start of the line
                screen[startByte] = ((-1 ushr (startPixel + 24)) and byteMask).toByte()

                //End of the line
                screen[endByte] = ((-1 shl (8 - endPixel)) and byteMask).toByte()
            }

        }
    }
}