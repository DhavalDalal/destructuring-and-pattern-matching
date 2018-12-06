public class Cylinder implements Element {
	private final double baseRadius;
	private final double height;

	public Cylinder(final double baseRadius, final double height) {
		this.baseRadius = baseRadius;
		this.height = height;
	}

	public double area() {
		return 2 * baseArea() + baseCircumference() * height;
	}

	private double baseCircumference() {
		return 2 * Math.PI * baseRadius;
	}

	private double baseArea() {
		return Math.PI * Math.pow(baseRadius, 2);
	}

	public double capacity() {
		return baseArea() * height;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public static void main(String[] args) {
		Cylinder c = new Cylinder(10, 10);
		System.out.println(c.area());
		System.out.println(c.capacity());
	}

}
