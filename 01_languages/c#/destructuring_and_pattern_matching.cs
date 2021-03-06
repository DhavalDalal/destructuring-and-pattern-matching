using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

// In FP, Destructuring is about extracting data from the innards of any structure.
class destructuring_and_pattern_matching {
  public static void Main(string[] args) {
    // Named tuples.
    // var left = (a: 5, b: 10);
    // var right = (a: 5, b: 10);
    // Console.WriteLine(left == right);
    // Console.WriteLine(left != right);
    
    // Destructuring nTuples
    var (l, m) = (20, 30);
    Console.WriteLine(l);
    Console.WriteLine(m);

    // var (q, r, s) = (20, 30, 40);
    // Console.WriteLine(q);
    // Console.WriteLine(r);
    // Console.WriteLine(s);

    // Considering first and last, Discarding (with _ ) others
    // var (a, _, _, d) = (10, 20, 30, 40);
    // Console.WriteLine(a);
    // Console.WriteLine(d);

    // Destructuring list
    // It turns out not only tuples can be deconstructed but any type 
    // which has Deconstruct instance (or extension) method with matching 
    // signature. 
    // Look at IEnumerableExtensions below for Deconstruction of IEnumerables.
    var list = new List<int> { 1, 2, 3, 4, 5, 6 };

    // Destructuring gives us a short-hand way of naming parts of the data-structure.
    var (first, rest) = list;
    Console.WriteLine(first);
    Console.WriteLine(rest);

    var empty = new List<int> {};
    // var (fst, remaining) = empty; // InvalidOperationException: Sequence contains no elements.

    // var (first, second, rest) = list;
    // Console.WriteLine(first);
    // Console.WriteLine(second);
    // Console.WriteLine(rest);
    //
    // var (first, second, third, rest) = list;
    // Console.WriteLine(first);
    // Console.WriteLine(second);
    // Console.WriteLine(third);
    // Console.WriteLine(rest);

    // De-structuring a custom type
    // Look at the Name class below for Deconstruction.
    var name = new Name("Dhaval", "Dalal", "Mr.");
    Console.WriteLine(name);
    var (firstName, lastName) = name;
    Console.WriteLine(firstName);
    Console.WriteLine(lastName);
    
    string Capitalize(Name n) {
      var (fName, lName) = n;
      return fName.ToUpper() + " " + lName.ToUpper();
    }
    Console.WriteLine(Capitalize(new Name("Dhaval", "Dalal", "Mr.")));

    // Deconstructing and Pattern Matching 
    // Look at the Point class below for Deconstruction.
    double Distance(ValueTuple<int, int> p1, ValueTuple<int, int> p2) {
      double Pythagorean(double x, double y) => Math.Sqrt(x * x + y * y);
      
      var origin = (0, 0);
      switch ((p1, p2)) {
        case var p when p.Item1 == p.Item2:
          return 0;
        case var p when (p.Item1 == origin) || (p.Item2 == origin):
          var (x,y) = (p.Item1 == origin)? p.Item2 : p.Item1;
          return Pythagorean(x, y);
        default: 
          var (x1, y1) = p1;
          var (x2, y2) = p2; 
          return Pythagorean(x2 - x1, y2 - y1);
      }
    }
    Console.WriteLine(Distance((0,0), (0,0)));
    Console.WriteLine(Distance((3,0), (0,0)));
    Console.WriteLine(Distance((0,0), (0,4)));
    Console.WriteLine(Distance((3,0), (0,4)));    
  }
}

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
