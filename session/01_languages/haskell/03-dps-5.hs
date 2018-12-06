import Data.Char (toUpper)

data Name = Name {
  first::String,
  last::String,
  salutation::String
} deriving (Show)

capitalize :: Name -> String
capitalize (Name fname lname _) = (toUpperCase fname) ++ " " ++ (toUpperCase lname)
  where
    toUpperCase cs = [toUpper c | c <- cs]

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
  let list = [1..4]
  let (first:second:rest) = list
  print $ first
  print $ second
  print $ rest
  let (x,y,z) = (10, 20, 30)
  print $ x
  print $ y
  print $ z
  let name = Name "Toto" "Mookey" "Mr."
  print $ name
  print $ capitalize name
  print $ mid_point (2,3) (4,5)
  print $ mid_point (2,3) (0,0)
  print $ mid_point (0,0) (4,5)
  print $ mid_point (0,0) (0,0)
  print "DONE"