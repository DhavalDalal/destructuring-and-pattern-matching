public class Direct3DVisitor implements Visitor {
	
	@Override
	public void visit(Sphere sphere) {
    System.out.println("Direct3D: rendering sphere");
	}

	@Override
	public void visit(Cylinder cylinder) {
    System.out.println("Direct3D: rendering cylinder");
	}
	
	public static void main(String[] args) {
		Sphere sphere = new Sphere(10);
		Cylinder cylinder = new Cylinder(10, 10);
		Direct3DVisitor direct3D = new Direct3DVisitor();
    CompositeShape composite = new CompositeShape(cylinder, sphere);
		composite.accept(direct3D);
	}
}
