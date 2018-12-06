main :: IO ()
main = do
  let list = [1..4]
  let (first:second:rest) = list
  print $ first
  print $ second
  print $ rest
  print "DONE"