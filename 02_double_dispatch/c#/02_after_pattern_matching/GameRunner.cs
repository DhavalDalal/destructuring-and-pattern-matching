using System;

public class GameRunner {
  public static void Main(string[] args) {
    var paper = new Paper();
    var rock = new Rock();
    var scissor = new Scissor();

    Console.WriteLine("paper.Beats(paper) = " + paper.Beats(paper));
    Console.WriteLine("paper.Beats(scissor) = " + paper.Beats(scissor));
    Console.WriteLine("paper.Beats(rock) = " + paper.Beats(rock));
    Console.WriteLine("scissor.Beats(paper) = " + scissor.Beats(paper));
    Console.WriteLine("scissor.Beats(scissor) = " + scissor.Beats(scissor));
    Console.WriteLine("scissor.Beats(rock) = " + scissor.Beats(rock));
    Console.WriteLine("rock.Beats(paper) = " + rock.Beats(paper));
    Console.WriteLine("rock.Beats(scissor) = " + rock.Beats(scissor));
    Console.WriteLine("rock.Beats(rock) = " + rock.Beats(rock));
  }
}
