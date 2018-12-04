data Element = Paper | Scissor | Rock 
  deriving (Show) 

beats :: Element -> Element -> Bool
beats Paper Scissor = False
beats Paper Rock    = True
beats Scissor Paper = True
beats Scissor Rock  = False
beats Rock Paper    = False
beats Rock Scissor  = True
beats _ _       = False

main :: IO ()
main = do
  print $ "paper beats paper? "    ++ show (Paper `beats` Paper)
  print $ "paper beats scissor? "  ++ show (Paper `beats` Scissor)
  print $ "paper beats rock? "     ++ show (Paper `beats` Rock)
  print $ "scissor beats paper? "  ++ show (Scissor `beats` Paper)
  print $ "scissor beats scissor? "++ show (Scissor `beats` Scissor)
  print $ "scissor beats rock? "   ++ show (Scissor `beats` Rock)
  print $ "rock beats paper? "     ++ show (Rock `beats` Paper)
  print $ "rock beats scissor? "   ++ show (Rock `beats` Scissor)
  print $ "rock beats rock? "      ++ show (Rock `beats` Rock)
  
