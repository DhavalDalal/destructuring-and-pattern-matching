type Point = (Double, Double)
// Pattern Matching
def distance(p1: Point, p2: Point): Double = {
  def pythagorean(x: Double, y: Double): Double = Math.sqrt(x * x + y * y)
  (p1, p2) match {
    case (p1, p2) if p1 == p2 => 0
    case (p1, p2) if p1 == (0,0) || p2 == (0,0) => 
      val (x,y) = if (p1 == (0,0)) p2 else p1 
      pythagorean(x, y)
    case ((x1, y1), (x2, y2)) => pythagorean(x2 - x1, y2 - y1)
  }
}

println(distance((0,0), (0,0)))
println(distance((3,0), (0,0)))
println(distance((0,0), (0,4)))
println(distance((3,0), (0,4)))