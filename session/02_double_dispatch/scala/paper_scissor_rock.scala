sealed trait Element {
  def beats(other: Element): String
}

case object Paper extends Element {
  def beats(other: Element): String = other match {
    case Scissor => "paper loses"
    case Rock => "paper wins"
    case Paper => "draw"
  }
}

case object Scissor extends Element {
  def beats(other: Element): String = other match {
    case Paper => "scissor wins"
    case Rock => "scissor loses"
    case Scissor => "draw"
  }
}

case object Rock extends Element {
  def beats(other: Element): String = other match {
    case Paper => "rock loses"
    case Scissor => "rock wins"
    case Rock => "draw"
  }
}

println("paper.beats(paper) = "    + Paper.beats(Paper))
println("paper.beats(scissor) = "  + Paper.beats(Scissor))
println("paper.beats(rock) = "     + Paper.beats(Rock))
println("scissor.beats(paper) = "  + Scissor.beats(Paper))
println("scissor.beats(scissor) = "+ Scissor.beats(Scissor))
println("scissor.beats(rock) = "   + Scissor.beats(Rock))
println("rock.beats(paper) = "     + Rock.beats(Paper))
println("rock.beats(scissor) = "   + Rock.beats(Scissor))
println("rock.beats(rock) = "      + Rock.beats(Rock))
