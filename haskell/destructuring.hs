data Shape = Circle Int | Rectangle Int Int

main :: IO ()
main = do
  -- Destructuring Lists
  let list = 1:2:3:4:5:6:[]
  let first:second:rest = list
  print first
  print second
  print rest

  -- Destructuring n-Tuples
  let (x,y) = (3,4)
  print x
  print y
  
  let (x,y,z) = (3,4,5)
  print x
  print y
  print z
  
  -- Destructuring ADTs
  let circle = Circle 10
  let (Circle radius) = circle
  print $ "Radius = " ++ show radius

  let rect = Rectangle 20 30  
  let (Rectangle len bre) = rect
  print $ "Length = " ++ show len ++ ", Breadth = " ++ show bre

