trait Beatable {
	def beats(other: Beatable): String
}

case object Paper extends Beatable {
	override def beats(other: Beatable): String = other match {
	  case Rock => "paper wins"
    case Scissor => "paper loses"
    case Paper => "draw"
	}
}

case object Rock extends Beatable {
	override def beats(other: Beatable): String = other match {
	  case Rock => "draw"
    case Scissor => "rock wins"
    case Paper => "rock loses"
	}
}
case object Scissor extends Beatable {
	override def beats(other: Beatable): String = other match {
	  case Rock => "scissor loses"
    case Scissor => "draw"
    case Paper => "scissor wins"
	}
}

val paper = Paper
val rock = Rock
val scissor = Scissor

println("paper.beats(paper) = " + paper.beats(paper))
println("paper.beats(scissor) = " + paper.beats(scissor))
println("paper.beats(rock) = " + paper.beats(rock))
println("scissor.beats(paper) = " + scissor.beats(paper))
println("scissor.beats(scissor) = " + scissor.beats(scissor))
println("scissor.beats(rock) = " + scissor.beats(rock))
println("rock.beats(paper) = " + rock.beats(paper))
println("rock.beats(scissor) = " + rock.beats(scissor))
println("rock.beats(rock) = " + rock.beats(rock))
