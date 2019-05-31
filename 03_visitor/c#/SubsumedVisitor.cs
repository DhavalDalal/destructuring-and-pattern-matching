using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

public interface Shape3d {
  double SurfaceArea();
  double Volume();
}

class Cylinder : Shape3d {
  private readonly double baseRadius;
  private readonly double height;

  public Cylinder(double baseRadius, double height) => 
    (this.baseRadius, this.height) = (baseRadius, height);
  
  private double BaseArea() => Math.PI * Math.Pow(baseRadius, 2);

  private double BaseCircumference() => 2 * Math.PI * baseRadius;

  public double SurfaceArea() => 2 * BaseArea() + BaseCircumference() * height;
  
  public double Volume() => BaseArea() * height;
  
  public override string ToString() { return $"{GetType().Name}"; }
}

class Sphere : Shape3d {
  private readonly double radius;
  
  public Sphere(double radius) => this.radius = radius;

  public double SurfaceArea() => 4 * Math.PI * Math.Pow(radius, 2);
  
  public double Volume() => 4.0 / 3.0 * Math.PI * Math.Pow(radius, 3);
}

class CompositeShape : Shape3d {
  private readonly IList<Shape3d> shapes;
  
  public CompositeShape(IList<Shape3d> shapes) => this.shapes = shapes;
  
  public double SurfaceArea() => shapes.Select(s => s.SurfaceArea()).Sum();
  
  public double Volume() => shapes.Select(s => s.Volume()).Sum();
  
  public void ForEach(Action<Shape3d> action) {
    foreach (var shape in shapes) action(shape);
  }
}

public interface Platform { }
public class OpenGL : Platform {}
public class SVG : Platform {}

public class SubsumedVisitor {
  public void Render(Platform p, Shape3d s) {
    switch ((p, s)) {
      case var _ when p is OpenGL && s is Cylinder:
        Console.WriteLine($"OpenGL: rendering cylinder {s.SurfaceArea()}");
        return;
      case var _ when p is OpenGL && s is Sphere:
        Console.WriteLine($"OpenGL: rendering sphere {s.SurfaceArea()}");
        return;
      case var _ when p is SVG && s is Cylinder: 
        Console.WriteLine($"SVG: rendering cylinder {s.SurfaceArea()}");
        return;
      case var _ when p is SVG && s is Sphere:
        Console.WriteLine($"SVG: rendering sphere {s.SurfaceArea()}");
        return;
      case var _ when s is CompositeShape: 
        var compositeShape = s as CompositeShape;
        compositeShape.ForEach(shape => Render(p, shape));
        return;
      default:
        Console.WriteLine();  
        return;
    }
  }
  
  public static void Main(string[] args) {
    var sphere = new Sphere(10);
    var cylinder = new Cylinder(10, 10);
    var composite = new CompositeShape(new List<Shape3d>{ cylinder, sphere });
    Console.WriteLine(composite.SurfaceArea());
    Console.WriteLine(composite.Volume());
    
    var sv = new SubsumedVisitor();
    sv.Render(new OpenGL(), composite);
    sv.Render(new SVG(), composite);
  } 
}
