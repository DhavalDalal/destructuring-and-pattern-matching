import Data.Char (toUpper)

data Name = Name {
  first      :: String,
  last       :: String,
  salutation :: String
} deriving (Show)

capitalize :: Name -> String
capitalize (Name fname lname _) = (toUpperCase fname) ++ " " ++ (toUpperCase lname)
  where
    toUpperCase cs = [toUpper c | c <- cs]

main :: IO ()
main = do
  let name = Name "Toto" "Mookey" "Mr."
  print $ name
  print $ capitalize name
  print "DONE"