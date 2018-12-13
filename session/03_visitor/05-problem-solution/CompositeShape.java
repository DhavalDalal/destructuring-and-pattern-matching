import java.util.*;
import java.util.stream.*;

public class CompositeShape implements Shape3d, Element {
  private Shape3d [] shapes;
  
  public CompositeShape(Shape3d ...shapes) {
    this.shapes = shapes;
  }

  @Override
  public double surfaceArea() {
    return Stream.of(shapes).mapToDouble(Shape3d::surfaceArea).sum();
  }
  
  @Override
	public double volume() {
    return Stream.of(shapes).mapToDouble(Shape3d::volume).sum();
  }

  @Override
  public void accept(Visitor visitor) {
    Stream.of(shapes).forEach(shape -> ((Element) shape).accept(visitor));
  }
  
  public static void main(String[] args) {
    Shape3d cylinder = new Cylinder(10, 10);
    Shape3d sphere = new Sphere(10);
    Shape3d composite = new CompositeShape(cylinder, sphere);
    System.out.println(composite.surfaceArea());
    System.out.println(composite.volume());
	}
}