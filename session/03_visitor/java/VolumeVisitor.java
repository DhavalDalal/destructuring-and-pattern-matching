public class VolumeVisitor implements Visitor {
	
	private double totalVolume = 0;

	@Override
	public void visit(Sphere sphere) {
		totalVolume +=  sphere.volume();
	}

	@Override
	public void visit(Cylinder cylinder) {
		totalVolume += cylinder.capacity();
	}
	
	public double getTotalVolume() {
		return totalVolume;
	}
	
	public static void main(String[] args) {
		Sphere sphere = new Sphere(10);
		Cylinder cylinder = new Cylinder(10, 10);
		VolumeVisitor volumeVisitor = new VolumeVisitor();
		sphere.accept(volumeVisitor);
		cylinder.accept(volumeVisitor);
		System.out.println(volumeVisitor.getTotalVolume());
	}
}
