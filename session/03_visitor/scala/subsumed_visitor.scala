case class Cylinder(baseRadius: Double, height: Double)

case class Sphere(radius: Double)

def volume(o: Object): Option[Double] = o match {
  case Cylinder(baseRadius, height) => Some(Math.PI * Math.pow(baseRadius, 2) * height)
  case Sphere(radius) => Some(4.0 / 3.0 * Math.PI * Math.pow(radius, 3))
  case _ => None
}

println(volume(Sphere(10)))
println(volume(Cylinder(10, 10)))

def surfaceArea(o: Object): Option[Double] = o match {
  case Cylinder(baseRadius, height) => 
    val baseArea = Math.PI * Math.pow(baseRadius, 2)
    val baseCircumference = 2 * Math.PI * baseRadius
    Some(2 * baseArea + baseCircumference * height)
		
  case Sphere(radius) => Some(4 * Math.PI * Math.pow(radius, 2))
  case _ => None
}

println(surfaceArea(Sphere(10)))
println(surfaceArea(Cylinder(10, 10)))