data Shape = Cylinder {
  baseRadius :: Double,
  height :: Double
} | Sphere {
  radius :: Double
} | CompositeShape { 
  shapes :: [Shape] 
} deriving (Show)

volume :: Shape -> Double
volume (Cylinder baseRadius height) = pi * baseRadius ^^ 2 * height
volume (Sphere radius) = 4.0 / 3.0 * pi * radius ^^ 3
volume (CompositeShape ss) = sum $ map volume ss

surfaceArea :: Shape -> Double
surfaceArea (Cylinder baseRadius height) = 2 * baseArea + baseCircumference * height
  where
    baseArea = pi * baseRadius ^^ 2
    baseCircumference = 2 * pi * baseRadius

surfaceArea (Sphere radius) = 4.0 * pi * radius ^^ 2
surfaceArea (CompositeShape ss) = sum $ map surfaceArea ss

main :: IO ()
main = do
  let cylinder = Cylinder 10 10
  let sphere = Sphere 10
  print $ "Volume of Cylinder " ++ show (volume cylinder)
  print $ "Volume of Sphere " ++ show (volume sphere)
  let composite = CompositeShape [cylinder,sphere]
  print $ "Volume of CompositeShape " ++ show (volume composite)
  print $ "Surface Area of Cylinder " ++ show (surfaceArea cylinder)
  print $ "Surface Area of Sphere " ++ show (surfaceArea sphere)
  print $ "Surface Area of CompositeShape " ++ show (surfaceArea composite)
