public class Scissor : Beatable {
	public string Beats(Beatable other) {
    switch (other) {
      case Rock r:
			  return "scissor loses";
      case Paper p:
			  return "scissor wins";
      default:
		    return "draw";
    }
	}
}
