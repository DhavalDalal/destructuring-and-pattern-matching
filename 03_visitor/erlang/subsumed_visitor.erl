#!/usr/bin/env escript

-record (cylinder, {baseRadius = 0, height = 0}).
-record (sphere, {radius = 0}).

volume(#cylinder {baseRadius = BaseRadius, height = Height}) ->
	math:pi() * math:pow(BaseRadius, 2) * Height;
	
volume(#sphere {radius = Radius}) ->
	4.0 / 3.0 * math:pi() * math:pow(Radius, 3);

volume(List = [_|_]) -> 
  lists:foldl(fun(Shape, Acc) -> Acc + volume(Shape) end, 0, List);

volume([]) -> 0;
	
volume(_) -> 
    not_ok.

surfaceArea(#cylinder {baseRadius = BaseRadius, height = Height}) ->
  BaseArea = math:pi() * math:pow(BaseRadius, 2),
  BaseCircumference = 2 * math:pi() * BaseRadius,
  2 * BaseArea + BaseCircumference * Height;
  
surfaceArea(#sphere {radius = Radius}) ->
  4.0 * math:pi() * math:pow(Radius, 2);
  
surfaceArea(List = [_|_]) -> 
  lists:foldl(fun(Shape, Acc) -> Acc + surfaceArea(Shape) end, 0, List);

surfaceArea([]) -> 0;

surfaceArea(_) -> 
    not_ok.

renderOpenGL(#cylinder {}) ->
  io:format("~p~n", ["OpenGL: rendering cylinder"]);
  
renderOpenGL(#sphere {}) ->
  io:format("~p~n", ["OpenGL: rendering sphere"]);

renderOpenGL(List = [_|_]) -> 
  io:format("Rendering Composite...~n"),
  lists:foreach(fun(Shape) -> renderOpenGL(Shape) end, List);
  
renderOpenGL(_) -> 
    not_ok.

renderDirect3D(#cylinder {}) ->
  io:format("~p~n", ["Direct3D: rendering cylinder"]);
  
renderDirect3D(#sphere {}) ->
  io:format("~p~n", ["Direct3D: rendering sphere"]);

renderDirect3D(List = [_|_]) -> 
  io:format("Rendering Composite...~n"),
  lists:foreach(fun(Shape) -> renderDirect3D(Shape) end, List);
  
renderDirect3D(_) -> 
    not_ok.

main([]) ->
  Cylinder = #cylinder {baseRadius = 10, height = 10},
  Sphere = #sphere {radius = 10},
  Composite = [Cylinder, Sphere],
  io:format("Volume of Cylinder ~p~n", [volume(Cylinder)]),
  io:format("Volume of Sphere ~p~n", [volume(Sphere)]),
  io:format("Volume of Composite ~p~n", [volume(Composite)]),
  % io:format("Volume of 2 ~p~n", [volume(2)]),
  io:format("Surface Area of Cylinder ~p~n", [surfaceArea(Cylinder)]),
  io:format("Surface Area of Sphere ~p~n", [surfaceArea(Sphere)]),
  io:format("Surface Area of Composite ~p~n", [surfaceArea(Composite)]),
  % io:format("Surface Area of 2 ~p~n", [surfaceArea(2)]),
  io:format("~p~n", [renderOpenGL(Cylinder)]),
  io:format("~p~n", [renderOpenGL(Sphere)]),
  io:format("~p~n", [renderOpenGL(Composite)]),
  io:format("~p~n", [renderDirect3D(Cylinder)]),
  io:format("~p~n", [renderDirect3D(Sphere)]),
  io:format("~p~n", [renderDirect3D(Composite)]),
  io:format("DONE").
