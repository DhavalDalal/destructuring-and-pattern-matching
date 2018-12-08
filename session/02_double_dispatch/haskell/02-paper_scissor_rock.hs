-- We’ll use ADT Element Rock  Paper Scissor
-- to represent the three choices.
data Element = Paper | Scissor | Rock 
  deriving (Show)

beats :: Element -> Element -> String
beats Paper   Scissor = "paper loses"
beats Paper   Rock    = "paper wins"
beats Scissor Paper   = "scissor wins"
beats Scissor Rock    = "scissor loses"
beats Rock    Paper   = "rock loses"
beats Rock    Scissor = "rock wins"
beats _       _       = "draw"

main :: IO ()
main = do
  print $ "paper beats paper = "    ++ (Paper   `beats` Paper)
  print $ "paper beats scissor = "  ++ (Paper   `beats` Scissor)
  print $ "paper beats rock = "     ++ (Paper   `beats` Rock)
  print $ "scissor beats paper = "  ++ (Scissor `beats` Paper)
  print $ "scissor beats scissor = "++ (Scissor `beats` Scissor)
  print $ "scissor beats rock = "   ++ (Scissor `beats` Rock)
  print $ "rock beats paper = "     ++ (Rock    `beats` Paper)
  print $ "rock beats scissor = "   ++ (Rock    `beats` Scissor)
  print $ "rock beats rock = "      ++ (Rock    `beats` Rock)
 
