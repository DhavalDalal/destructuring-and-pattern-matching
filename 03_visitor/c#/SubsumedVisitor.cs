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
  
  public void Deconstruct(out double baseRadius, out double height) => 
    (baseRadius, height) = (this.baseRadius, this.height);
    
  private double BaseArea() => Math.PI * Math.Pow(baseRadius, 2);

  private double BaseCircumference() => 2 * Math.PI * baseRadius;

  public double SurfaceArea() => 2 * BaseArea() + BaseCircumference() * height;
  
  public double Volume() => BaseArea() * height;
  
  public override string ToString() { return $"{GetType().Name}"; }
}

class Sphere : Shape3d {
  private readonly double radius;
  
  public Sphere(double radius) => this.radius = radius;

  public void Deconstruct(out double radius) => radius = this.radius;
  
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
      case var vt when vt.Item1 is OpenGL && vt.Item2 is Cylinder: {
        var shape = vt.Item2;
        Console.WriteLine($"OpenGL: rendering cylinder {shape.SurfaceArea()}");
        return;
      }
      
      case var vt when vt.Item1 is OpenGL && vt.Item2 is Sphere: {
        var shape = vt.Item2;
        Console.WriteLine($"OpenGL: rendering sphere {shape.SurfaceArea()}");
        return;
      }

      case var vt when vt.Item1 is SVG && vt.Item2 is Cylinder: {
        var shape = vt.Item2;
        Console.WriteLine($"SVG: rendering cylinder {shape.SurfaceArea()}");
        return;
      }
      
      case var vt when vt.Item1 is SVG && vt.Item2 is Sphere: {
        var shape = vt.Item2;
        Console.WriteLine($"SVG: rendering sphere {shape.SurfaceArea()}");
        return;
      }

      case var vt when vt.Item2 is CompositeShape: {
        var compositeShape = vt.Item2 as CompositeShape;
        compositeShape.ForEach(shape => Render(vt.Item1, shape));
        return;
      }
        
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
