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
volume (CompositeShape ss) = sum [ v | v <- map (\s -> volume s) ss ]

surfaceArea :: Shape -> Double
surfaceArea (Cylinder baseRadius height) = 2 * baseArea + baseCircumference * height
  where
    baseArea = pi * baseRadius ^^ 2
    baseCircumference = 2 * pi * baseRadius

surfaceArea (Sphere radius) = 4.0 * pi * radius ^^ 2
surfaceArea (CompositeShape ss) = sum [ v | v <- map (\s -> surfaceArea s) ss ]

renderOpenGL :: Shape -> IO ()
renderOpenGL (Cylinder baseRadius height) = print "OpenGL: rendering cylinder"
renderOpenGL (Sphere radius) = print "OpenGL: rendering sphere"
renderOpenGL (CompositeShape ss) = do
  sequence [renderOpenGL s | s <- ss]
  return ()

renderDirect3D :: Shape -> IO ()
renderDirect3D (Cylinder baseRadius height) = print "Direct3D: rendering cylinder"
renderDirect3D (Sphere radius) = print "Direct3D: rendering sphere"
renderDirect3D (CompositeShape ss) = do
  sequence [renderDirect3D s | s <- ss]
  return ()
  

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
  renderOpenGL composite
  renderDirect3D composite
