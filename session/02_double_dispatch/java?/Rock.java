public class Rock implements Beatable {
	@Override
	public String beats(Beatable other) {
		if (other.getClass() == Paper.class) {
			return "rock loses";
		}

		if (other.getClass() == Scissor.class) {
			return "rock wins";
		}
		return "draw";
	}
}
