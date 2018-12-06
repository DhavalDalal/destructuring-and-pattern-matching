// Destructuring list
val list = 1::2::3::4::Nil
// Destructuring gives us a short-hand way of naming parts of the data-structure.
val (first::second::rest) = list
println(first)
println(second)
println(rest)

// Destructuring nTuples
val (p, q, r) = (10, 20, 30)
println(p)
println(q)
println(r)
