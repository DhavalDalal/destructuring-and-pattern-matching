public class Scissor implements Beatable {
	@Override
	public boolean beats(Beatable other) {
		if (other.getClass() == Rock.class) {
			return false;
		}

		if (other.getClass() == Paper.class) {
			return true;
		}
		return false;
	}
}
