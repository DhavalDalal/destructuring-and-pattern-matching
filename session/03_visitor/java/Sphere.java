public class Sphere implements Element {
	private final double radius;

	public Sphere(final double radius) {
		this.radius = radius;
	}
	
	public double surfaceArea() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}
	
	public double volume() {
		return 4.0 / 3.0 * Math.PI * Math.pow(radius, 3); 
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public static void main(String[] args) {
		Sphere s = new Sphere(10);
		System.out.println(s.surfaceArea());
		System.out.println(s.volume());
	}
}
