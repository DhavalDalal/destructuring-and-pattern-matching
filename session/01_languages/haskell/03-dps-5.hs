import Data.Char (toUpper)

mid_point :: (Double, Double) -> (Double, Double) -> (Double, Double)
mid_point (0,0) p2 = p2
mid_point p1 (0,0) = p1
mid_point p1@(x1,y1) p2@(x2,y2)
  | p1 == p2 = p2
  | otherwise = (mid x1 x2, mid y1 y2)
      where
        mid a1 a2 = (a1 + a2) / 2

main :: IO ()
main = do
  print $ mid_point (2,3) (4,5)
  print $ mid_point (2,3) (0,0)
  print $ mid_point (0,0) (4,5)
  print $ mid_point (0,0) (0,0)
  print "DONE"