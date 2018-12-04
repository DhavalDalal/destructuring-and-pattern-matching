public class Scissor implements Beatable {
	public boolean beats(Beatable other) {
		return other.loseAgainst(this);
	}

	@Override
	public boolean loseAgainst(Rock rock) {
		return true;
	}

	@Override
	public boolean loseAgainst(Paper paper) {
		return false;
	}

	@Override
	public boolean loseAgainst(Scissor scissor) {
		return false;
	}
}
