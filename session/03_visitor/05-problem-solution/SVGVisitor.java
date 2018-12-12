public class SVGVisitor implements Visitor {
	
	@Override
	public void visit(Sphere sphere) {
    System.out.println("SVG: rendering sphere");
	}

	@Override
	public void visit(Cylinder cylinder) {
    System.out.println("SVG: rendering cylinder");
	}
	
	public static void main(String[] args) {
		Sphere sphere = new Sphere(10);
		Cylinder cylinder = new Cylinder(10, 10);
		Visitor svg = new SVGVisitor();
    CompositeShape composite = new CompositeShape(cylinder, sphere);
		composite.accept(svg);
	}
}
