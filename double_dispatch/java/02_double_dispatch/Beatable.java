public interface Beatable {
	public abstract boolean beats(Beatable beatable);
	public abstract boolean loseAgainst(Rock rock);
	public abstract boolean loseAgainst(Paper paper);
	public abstract boolean loseAgainst(Scissor scissor);
}
