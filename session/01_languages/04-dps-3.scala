case class Name(fName: String, lName: String, salutation: String)

def capitalize(name: Name) = name match {
  case Name(firstName, lastName, _) => firstName.toUpperCase + " " + lastName.toUpperCase
}
println(Name("Toto", "Mookey", "Mr."))
println(capitalize(Name("Toto", "Mookey", "Mr.")))