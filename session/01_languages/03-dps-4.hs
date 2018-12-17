distance :: (Double, Double) -> (Double, Double) -> Double
distance (0,0) (0,0) = 0
distance p1@(x1,y1) p2@(x2,y2)
  | p1 == (0,0) || p2 == (0,0) = (let (x,y) = if p1 == (0,0) then p2 else p1 in sqrt (square x + square y))
  | otherwise = sqrt $ square (x2 - x1) + square (y2 - y1)
 where
    square n = n ^^ 2

main :: IO ()
main = do
  print $ distance (0,0) (0,0)
  print $ distance (3,0) (0,0)
  print $ distance (0,0) (0,4)
  print $ distance (3,0) (0,4)
  print "DONE"