type Point = (Int, Int)
// Pattern Matching
def midpoint(p1: Point, p2: Point): Point = {
  def mid(a1: Int, a2: Int) = (a1 + a2) / 2
  (p1, p2) match {
    case (p1, (0, 0)) => p1
    case ((0, 0), p2) => p2
    case (p1, p2) if p1 == p2 => p1
    case ((x1, y1), (x2, y2)) => (mid(x1, x2), mid(y1, y2))
  }
}

println(midpoint((2,3), (4,5)))
println(midpoint((2,3), (0,0)))
println(midpoint((0,0), (4,5)))
println(midpoint((0,0), (0,0)))