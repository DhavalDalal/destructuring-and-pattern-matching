// Destructuring list
// val list = 1::2::3::4::Nil
// Destructuring gives us a short-hand way of naming parts of the data-structure.
// val (first::second::rest) = list
// println(first)
// println(second)
// println(rest)

// Destructuring nTuples
val (x, _, z) = (10, 20, 30)
println(x)
println(z)
