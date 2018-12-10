// Destructuring list
// val list = 1::2::3::4::Nil
// Destructuring gives us a short-hand way of naming parts of the data-structure.
// val (first::second::rest) = list
// println(first)
// println(second)
// println(rest)

// Destructuring nTuples
// val (p, q, r) = (10, 20, 30)
// println(p)
// println(q)
// println(r)

case class Name(fName: String, lName: String, salutation: String)

def capitalize(name: Name) = name match {
  case Name(firstName, lastName, _) => firstName.toUpperCase + " " + lastName.toUpperCase
}
println(Name("Toto", "Mookey", "Mr."))
println(capitalize(Name("Toto", "Mookey", "Mr.")))