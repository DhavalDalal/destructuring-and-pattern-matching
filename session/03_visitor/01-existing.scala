sealed trait Shape3d {
  def surfaceArea(): Double
  def volume(): Double
}

case class Cylinder(baseRadius: Double, height: Double) extends Shape3d {
  val baseArea = Math.PI * Math.pow(baseRadius, 2)
  val baseCircumference = 2 * Math.PI * baseRadius
  def surfaceArea(): Double = 2 * baseArea + baseCircumference * height
  def volume(): Double = baseArea * height
}

case class Sphere(radius: Double) extends Shape3d {
  def surfaceArea(): Double = 4 * Math.PI * Math.pow(radius, 2)
  def volume(): Double = 4.0 / 3.0 * Math.PI * Math.pow(radius, 3)
}

case class CompositeShape(shapes: List[Shape3d]) extends Shape3d {
  def surfaceArea(): Double = shapes.map(_.surfaceArea()).sum
  def volume(): Double = shapes.map(_.volume()).sum
}

val sphere = Sphere(10)
val cylinder = Cylinder(10, 10)
val composite = CompositeShape(List(cylinder, sphere))
println(composite.surfaceArea())
println(composite.volume())
