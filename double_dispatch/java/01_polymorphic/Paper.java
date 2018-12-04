public class Paper implements Beatable {
	@Override
	public boolean beats(Beatable other) {
		if (other.getClass() == Rock.class) {
			return true;
		}

		if (other.getClass() == Scissor.class) {
			return false;
		}
		return false;
	}
}
