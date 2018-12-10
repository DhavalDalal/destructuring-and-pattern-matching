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
