import Data.Char (toUpper)

data Name = Name { 
  first :: String, 
  last :: String,
  salutation :: String
} deriving (Show)

capitalize :: Name -> String
capitalize (Name fName lName _) = (upper fName) ++ " " ++ (upper lName)
  where
    upper cs = [toUpper c | c <- cs]

midpoint :: (Double, Double) -> (Double, Double) -> (Double, Double)
-- show second the two special cases
midpoint p1 (0, 0) = p1
midpoint (0, 0) p2 = p2
-- show first generic implementation
-- midpoint (x1, y1) (x2, y2) = (mid x1 x2, mid y1 y2)
--   where
--     mid a1 a2 = (a1 + a2) / 2
  
-- evolve from first, the third implementation of generic
midpoint p1@(x1, y1) p2@(x2, y2) 
  | p1 == p2 = p1
  | otherwise = (mid x1 x2, mid y1 y2)  
                where
                  mid a1 a2 = (a1 + a2) / 2
  
main :: IO ()
main = do
  let name = Name "Dhaval" "Dalal" "Mr."
  print $ name
  print $ capitalize name
  print $ midpoint (0,0) (0,0)
  print $ midpoint (2,3) (0,0)
  print $ midpoint (0,0) (4,5)
  print $ midpoint (2,3) (4,5)
  print "DONE"
