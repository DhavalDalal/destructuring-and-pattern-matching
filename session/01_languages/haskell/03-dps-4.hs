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

main :: IO ()
main = do
  -- let list = [1..4]
  let list = 1:2:3:4:[]  
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
  print "DONE"