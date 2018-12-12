public class OpenGLVisitor implements Visitor {

  @Override
  public void visit(Sphere sphere) {
    System.out.println("OpenGL: rendering sphere");
  }

  @Override
  public void visit(Cylinder cylinder) {
   System.out.println("OpenGL: rendering cylinder");
  }
	
  public static void main(String[] args) {
    Shape3d sphere = new Sphere(10);
    Shape3d cylinder = new Cylinder(10, 10);
    Visitor openGL = new OpenGLVisitor();
    Element composite = new CompositeShape(cylinder, sphere);
    composite.accept(openGL);
  }
}
