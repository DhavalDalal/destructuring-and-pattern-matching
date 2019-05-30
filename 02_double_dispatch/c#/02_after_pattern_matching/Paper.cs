public class Paper : Beatable {
	public string Beats(Beatable other) {
    switch (other) {
      case Rock r: 
        return "paper wins";
      case Scissor s: 
        return "paper loses";
      default:
		   return "draw";
    }
	}
}
