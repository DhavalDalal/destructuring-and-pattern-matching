sealed trait Element {
  def beats(other: Element): Boolean
}

case object Paper extends Element {
  def beats(other: Element): Boolean = other match {
    case Scissor => false
    case Rock => true
    case _ => false
  }
}

case object Scissor extends Element {
  def beats(other: Element): Boolean = other match {
    case Paper => true
    case Rock => false
    case _ => false
  }
}

case object Rock extends Element {
  def beats(other: Element): Boolean = other match {
    case Paper => false
    case Scissor => true
    case _ => false
  }
}

println("paper beats paper? "    + Paper.beats(Paper))
println("paper beats scissor? "  + Paper.beats(Scissor))
println("paper beats rock? "     + Paper.beats(Rock))
println("scissor beats paper? "  + Scissor.beats(Paper))
println("scissor beats scissor? "+ Scissor.beats(Scissor))
println("scissor beats rock? "   + Scissor.beats(Rock))
println("rock beats paper? "     + Rock.beats(Paper))
println("rock beats scissor? "   + Rock.beats(Scissor))
println("rock beats rock? "      + Rock.beats(Rock))
