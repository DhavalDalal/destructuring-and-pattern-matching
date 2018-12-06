#!/usr/bin/env escript

-record (cylinder, {baseRadius = 0, height = 0}).
-record (sphere, {radius = 0}).

volume(#cylinder {baseRadius = BaseRadius, height = Height}) ->
	math:pi() * math:pow(BaseRadius, 2) * Height;
	
volume(#sphere {radius = Radius}) ->
	4.0 / 3.0 * math:pi() * math:pow(Radius, 3);
	
volume(_) -> 
    not_ok.

surfaceArea(#cylinder {baseRadius = BaseRadius, height = Height}) ->
	BaseArea = math:pi() * math:pow(BaseRadius, 2),
	BaseCircumference = 2 * math:pi() * BaseRadius,
	2 * BaseArea + BaseCircumference * Height;
	
surfaceArea(#sphere {radius = Radius}) ->
	4.0 * math:pi() * math:pow(Radius, 2);
	
surfaceArea(_) -> 
    not_ok.
	
main([]) ->
  Cylinder = #cylinder {baseRadius = 10, height = 10},
  Sphere = #sphere {radius = 10},
  io:format("Volume of Cylinder ~p~n", [volume(Cylinder)]),
  io:format("Volume of Sphere ~p~n", [volume(Sphere)]),
  io:format("Volume of 2 ~p~n", [volume(2)]),
  io:format("Surface Area of Cylinder ~p~n", [surfaceArea(Cylinder)]),
  io:format("Surface Area of Sphere ~p~n", [surfaceArea(Sphere)]),
  io:format("Surface Area of 2 ~p~n", [surfaceArea(2)]).