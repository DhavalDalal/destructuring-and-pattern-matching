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
		Sphere sphere = new Sphere(10);
		Cylinder cylinder = new Cylinder(10, 10);
		OpenGLVisitor openGL = new OpenGLVisitor();
    CompositeShape composite = new CompositeShape(cylinder, sphere);
		composite.accept(openGL);
	}
}
