public class Scissor : Beatable {
	public string Beats(Beatable other) {
		if (other.GetType() == typeof(Rock)) {
			return "scissor loses";
		}

		if (other.GetType() == typeof(Paper)) {
			return "scissor wins";
		}
		return "draw";
	}
}
