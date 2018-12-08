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

def renderOpenGL(s: Shape3d): Unit = s match {
  case Cylinder(baseRadius, height) => println("OpenGL: rendering cylinder")
  case Sphere(radius) => println("OpenGL: rendering sphere")
  case CompositeShape(shapes) => shapes foreach renderOpenGL
}

def renderDirect3D(s: Shape3d): Unit = s match {
  case Cylinder(baseRadius, height) => println("Direct3D: rendering cylinder")
  case Sphere(radius) => println("Direct3D: rendering sphere")
  case CompositeShape(shapes) => shapes foreach renderDirect3D
}

val sphere = Sphere(10)
val cylinder = Cylinder(10, 10)
val composite = CompositeShape(List(cylinder, sphere))
println(composite.surfaceArea())
println(composite.volume())

renderOpenGL(composite)
renderDirect3D(composite)
