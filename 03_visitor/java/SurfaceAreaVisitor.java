public class SurfaceAreaVisitor implements Visitor {
	
	private double totalSurfaceArea = 0;

	@Override
	public void visit(Sphere sphere) {
		totalSurfaceArea += sphere.surfaceArea();
	}

	@Override
	public void visit(Cylinder cylinder) {
		totalSurfaceArea += cylinder.area();
	}
	
	public double getTotalSurfaceArea() {
		return totalSurfaceArea;
	}
	
	public static void main(String[] args) {
		Sphere sphere = new Sphere(10);
		Cylinder cylinder = new Cylinder(10, 10);
		SurfaceAreaVisitor surfaceAreaVisitor = new SurfaceAreaVisitor();
		sphere.accept(surfaceAreaVisitor);
		cylinder.accept(surfaceAreaVisitor);
		System.out.println(surfaceAreaVisitor.getTotalSurfaceArea());
	}
}
