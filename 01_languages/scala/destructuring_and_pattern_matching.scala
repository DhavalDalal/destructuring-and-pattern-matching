// In FP, Destructuring is about extracting data from the innards of any structure.

// Destructuring list
val list = 1::2::3::4::5::6::Nil
// Destructuring gives us a short-hand way of naming parts of the data-structure.
val (first::second::rest) = list
println(first)
println(second)
println(rest)

// Destructuring nTuples
val (x, y) = (20, 30)
println(x)
println(y)

val (p, q, r) = (20, 30, 40)
println(p)
println(q)
println(r)

case class Name(fName: String, lName: String, salutation: String)

// Pattern Matching
def capitalize(name: Name) = name match {
  case Name(firstName, lastName, _) => firstName.toUpperCase + " " + lastName.toUpperCase
}

println(capitalize(Name("Dhaval", "Dalal", "Mr.")))

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
