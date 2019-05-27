using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

// In FP, Destructuring is about extracting data from the innards of any structure.
class destructuring_and_pattern_matching {
  
  public static double ComputeArea_Version3(Point p1, Point p2)
  {
    var origin = new Point(0, 0);
    var points = new Tuple<Point, Point>(p1, p2);
    // var points = new ValueTuple<Point, Point>(pt1: p1, pt2: p2);
    Console.WriteLine(points.GetType());
    // var p = (p1, p2);
      switch (points)
      {
          case Tuple<Point, Point> p when ((p.Item1, p.Item2) == (origin, origin)): return 0;
          // case ValueTuple<Point, Point> p when ((p.pt1, p.pt2) == (origin, origin)): return 0;
          // case Square s when s.Side == 0:
          // case Circle c when c.Radius == 0:
          // case Triangle t when t.Base == 0 || t.Height == 0:
          // case Rectangle r when r.Length == 0 || r.Height == 0:
          //     return 0;
          // case Square s:
          //     return s.Side * s.Side;
          // case Circle c:
          //     return c.Radius * c.Radius * Math.PI;
          // case Triangle t:
          //     return t.Base * t.Height / 2;
          // case Rectangle r:
          //     return r.Length * r.Height;
          default:
              throw new ArgumentException(
                  message: "shape is not a recognized shape",
                  paramName: nameof(p1));
      }
  }
  
  public static void Main(string[] args) {
    // Named tuples.
    var left = (a: 5, b: 10);
    var right = (a: 5, b: 10);
    Console.WriteLine(left == right);
    Console.WriteLine(left != right);
    
    // // Destructuring nTuples
    // var (l, m) = (20, 30);
    // Console.WriteLine(l);
    // Console.WriteLine(m);
    //
    // var (p, q, r) = (20, 30, 40);
    // Console.WriteLine(p);
    // Console.WriteLine(q);
    // Console.WriteLine(r);
    //
    // // Considering first and last, Discarding (with _ ) others
    // var (a, _, _, d) = (10, 20, 30, 40);
    // Console.WriteLine(a);
    // Console.WriteLine(d);

    // // Destructuring list
    // var list = new List<int>{1, 2, 3, 4, 5, 6};
    //
    // // Destructuring gives us a short-hand way of naming parts of the data-structure.
    // // var (first, rest) = list;
    // // Console.WriteLine(first);
    // // Console.WriteLine(rest);
    //
    // // var empty = new List<int>{};
    // // var (first, rest) = empty; // InvalidOperationException: Sequence contains no elements.
    //
    // // var (first, second, rest) = list;
    // // Console.WriteLine(first);
    // // Console.WriteLine(second);
    // // Console.WriteLine(rest);
    //
    // var (first, second, third, rest) = list;
    // Console.WriteLine(first);
    // Console.WriteLine(second);
    // Console.WriteLine(third);
    // Console.WriteLine(rest);

    // // De-structuring a custom type
    // var name = new Name("Dhaval", "Dalal", "Mr.");
    // Console.WriteLine(name);
    // var (firstName, lastName) = name;
    // Console.WriteLine(firstName);
    // Console.WriteLine(lastName);

    // var (firstName, lastName, salutation) = new Name("");
    // Console.WriteLine(firstName);
    // Console.WriteLine(lastName);
    // Console.WriteLine(salutation);
    
    string Capitalize(Name n) {
      var (fName, lName) = n;
      return fName.ToUpper() + " " + lName.ToUpper();
    }
    Console.WriteLine(Capitalize(new Name("Dhaval", "Dalal", "Mr.")));

    // Pattern Matching
    double Distance(Point p1, Point p2) {
      double Pythagorean(double x, double y) => Math.Sqrt(x * x + y * y);
      
      var origin = new Point(0, 0);
      var points = (p1, p2);
      switch (points) {
        case ValueTuple<Point, Point> p when p.Item1 == p.Item2:
          return 0;
        case ValueTuple<Point, Point> p when (p.Item1 == origin) || (p.Item2 == origin):
          var (x,y) = (p.Item1 == origin)? p.Item2 : p.Item1;
          return Pythagorean(x, y);
        default: 
          var (x1, y1) = p1;
          var (x2, y2) = p2; 
          return Pythagorean(x2 - x1, y2 - y1);
      }
    }
    Console.WriteLine(Distance(new Point(0,0), new Point(0,0)));
    Console.WriteLine(Distance(new Point(3,0), new Point(0,0)));
    Console.WriteLine(Distance(new Point(0,0), new Point(0,4)));
    Console.WriteLine(Distance(new Point(3,0), new Point(0,4)));
  }
}

// It turns out not only tuples can be deconstructed but any type 
// which has Deconstruct instance (or extension) method with matching 
// signature. Doing deconstruction correctly for IEnumerable is not 
// trivial (see library suggested by David Arno in comments), so let's
public static class IEnumerableExtensions {
  public static void Deconstruct<T>(this IEnumerable<T> @this, out T first, out IEnumerable<T> rest) {
    if (@this == null) {
      throw new ArgumentException("Collection cannot be null!");
    }
    first = @this.First();
    rest =  @this.Skip(1);
  }
  
  public static void Deconstruct<T>(this IEnumerable<T> @this, out T first, 
                                    out T second, out IEnumerable<T> rest) => 
    (first, (second, rest)) = @this;
  
  // This is a pattern and we see that recursion can be used to
  // write generic code that can work on IEnumerables.
  public static void Deconstruct<T>(this IEnumerable<T> @this, out T first, 
                                    out T second, out T third, 
                                    out IEnumerable<T> rest) => 
    (first, second, (third, rest)) = @this;
}

public class Point : IEquatable<Point> {
  private readonly int x;
  private readonly int y;
  
  public Point(int x, int y) => (this.x, this.y) = (x, y);
  
  public void Deconstruct(out int x, out int y) => (x, y) = (this.x, this.y);  
  
  public bool Equals(Point other) => x == other.x && y == other.y;
  
  //Bring value semantics to class type
  public static bool operator == (Point left, Point right) {
      if (ReferenceEquals(left, null)) return false;
      if (ReferenceEquals(null, right)) return false;
      if (ReferenceEquals(left, right)) return true;
      return left.Equals(right);
  }

  //Bring value semantics to class type
  public static bool operator !=(Point left, Point right) => !(left == right);

  public override bool Equals(object obj) {
      if (ReferenceEquals(null, obj)) return false;
      if (ReferenceEquals(this, obj)) return true;
      if (obj.GetType() != this.GetType()) return false;
      return Equals((Point) obj);
  }

  public override int GetHashCode() {
    unchecked {
      return (x*397) ^ y;
    }
  }
  
  public override string ToString() => $"Point({x}, {y})";
}

class Name {
  private readonly string fName;
  private readonly string lName;
  private readonly string salutation;
  
  public Name(string fName, string lName, string salutation) => 
    (this.fName, this.lName, this.salutation) = (fName, lName, salutation);
  
  public void Deconstruct(out string fName, out string lName) {
    fName = this.fName;
    lName = this.lName;
  }
  
  public void Deconstruct(out string fName, out string lName, out string salutation) =>
    ((fName, lName), salutation) = (this, this.salutation);

  public override string ToString() {
    return $"Name({fName}, {lName}, {salutation})";
  }
}
