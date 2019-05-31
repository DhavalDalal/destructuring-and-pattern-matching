public class Rock : Beatable {
	public string Beats(Beatable other) {
    switch (other) {
      case Paper p: return "rock loses";
      case Scissor s: return "rock wins";
      default: return "draw";
    }
	}
}
