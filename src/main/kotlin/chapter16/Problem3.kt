package chapter16

object Problem3 {

    data class Point(val x: Double, val y: Double)

    data class LineSegment(val p1: Point, val p2: Point)

    fun calculateIntersection(lineSegment1: LineSegment, lineSegment2: LineSegment): Point? {
        val l1points = listOf(lineSegment1.p1, lineSegment1.p2).sortedBy { it.x }
        val l2points = listOf(lineSegment2.p1, lineSegment2.p2).sortedBy { it.x }

        val l1vertical = l1points[0].x == l1points[1].x
        val l2vertical = l2points[0].x == l2points[1].x

        if (l1vertical && l2vertical){
            //This case depends on if you see overlapping/touching as intersecting
            //I will choose for it not to be an intersection
            return null
        } else if (l1vertical) {
            //line 1 is vertical
            if (l1points[0].x in l2points[0].x..l2points[1].x) {
                val slope2 = (l2points[1].y - l2points[0].y) / (l2points[1].x - l2points[0].x)
                val y = l2points[0].y + slope2 * (l1points[0].x - l2points[0].x)
                if (y in l2points[0].y..l2points[1].y){
                    return Point(l1points[0].x, y)
                }
            }
            return null
        } else if (l2vertical) {
            //line 2 is vertical
            if (l2points[0].x in l1points[0].x..l1points[1].x) {
                val slope1 = (l1points[1].y - l1points[0].y) / (l1points[1].x - l1points[0].x)
                val y = l1points[0].y + slope1 * (l2points[0].x - l1points[0].x)
                if (y in l1points[0].y..l1points[1].y){
                    return Point(l2points[0].x, y)
                }
            }
            return null
        } else {
            val slope1 = (l1points[1].y - l1points[0].y) / (l1points[1].x - l1points[0].x)
            val slope2 = (l2points[1].y - l2points[0].y) / (l2points[1].x - l2points[0].x)
            //y1 = slope1*x + b
            val b = l1points[0].y - l1points[0].x*slope1
            //y2 = slope2*x + c
            val c = l2points[0].y - l2points[0].x*slope2

            if (slope1 == slope2) return null //parallel lines

            //intersection => x = (c - b) / (slope1 - slope2)
            val x = (c-b)/(slope1-slope2)
            return if (x in l1points[0].x..l1points[1].x && x in l2points[0].x..l2points[1].x) {
                val y = l1points[0].y + slope1 * (x - l1points[0].x)
                Point(x, y)
            } else {
                null
            }
        }
    }
}