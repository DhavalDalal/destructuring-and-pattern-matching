public class Scissor implements Beatable {
	@Override
	public String beats(Beatable other) {
		if (other.getClass() == Rock.class) {
			return "scissor loses";
		}

		if (other.getClass() == Paper.class) {
			return "scissor wins";
		}
		return "draw";
	}
}
