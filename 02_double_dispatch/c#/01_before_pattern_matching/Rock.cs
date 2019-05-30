public class Rock : Beatable {
	public string Beats(Beatable other) {
		if (other.GetType() == typeof(Paper)) {
			return "rock loses";
		}

		if (other.GetType() == typeof(Scissor)) {
			return "rock wins";
		}
		return "draw";
	}
}
