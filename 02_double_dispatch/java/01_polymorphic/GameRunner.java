public class GameRunner {
	public static void main(String[] args) {
		Beatable paper = new Paper();
		Beatable rock = new Rock();
		Beatable scissor = new Scissor();
		
		System.out.println("paper.beats(paper)? " + paper.beats(paper));
		System.out.println("paper.beats(scissor)? " + paper.beats(scissor));
    System.out.println("paper.beats(rock)? " + paper.beats(rock));
		System.out.println("scissor.beats(paper)? " + scissor.beats(paper));
    System.out.println("scissor.beats(scissor)? " + scissor.beats(scissor));
    System.out.println("scissor.beats(rock)? " + scissor.beats(rock));
    System.out.println("rock.beats(paper)? " + rock.beats(paper));
    System.out.println("rock.beats(scissor)? " + rock.beats(scissor));
    System.out.println("rock.beats(rock)? " + rock.beats(rock));
	}
}
