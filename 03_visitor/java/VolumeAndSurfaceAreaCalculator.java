public class VolumeAndSurfaceAreaCalculator {
	public static void main(String[] args) {
		Sphere sphere = new Sphere(10);
		Cylinder cylinder = new Cylinder(10, 10);
		SurfaceAreaVisitor surfaceAreaVisitor = new SurfaceAreaVisitor();
		sphere.accept(surfaceAreaVisitor);
		cylinder.accept(surfaceAreaVisitor);
		System.out.println(surfaceAreaVisitor.getTotalSurfaceArea());
		
		VolumeVisitor volumeVisitor = new VolumeVisitor();
		sphere.accept(volumeVisitor);
		cylinder.accept(volumeVisitor);
		System.out.println(volumeVisitor.getTotalVolume());
	}
}
