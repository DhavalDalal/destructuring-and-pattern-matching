public class Paper : Beatable {
	public string Beats(Beatable other) {
		if (other.GetType() == typeof(Rock)) {
			return "paper wins";
		}

		if (other.GetType() == typeof(Scissor)) {
			return "paper loses";
		}
		return "draw";
	}
}
