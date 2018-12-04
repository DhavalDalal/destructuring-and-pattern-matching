public class Rock implements Beatable {
	@Override
	public boolean beats(Beatable other) {
		if (other.getClass() == Paper.class) {
			return false;
		}

		if (other.getClass() == Scissor.class) {
			return true;
		}
		return false;
	}
}
