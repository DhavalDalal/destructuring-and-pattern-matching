trait Shape3d {
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

// Creating Plaform Types
trait Platform
case object OpenGL extends Platform
case object SVG extends Platform

def render(p: Platform, s: Shape3d): Unit = (p, s) match {
  case (OpenGL, Cylinder(baseRadius, height)) => println("OpenGL: rendering cylinder")
  case (OpenGL, Sphere(radius)) => println("OpenGL: rendering sphere")
  case (SVG, Cylinder(baseRadius, height)) => println("SVG: rendering cylinder")
  case (SVG, Sphere(radius)) => println("SVG: rendering sphere")
  case (_, CompositeShape(shapes)) => shapes.foreach(render(p, _))
  case (_, _) => println()
}

render(OpenGL, composite)
render(SVG, composite)
println("DONE")
