public class Paper implements Beatable {
	@Override
	public String beats(Beatable other) {
		if (other.getClass() == Rock.class) {
			return "paper wins";
		}

		if (other.getClass() == Scissor.class) {
			return "paper loses";
		}
		return "draw";
	}
}
