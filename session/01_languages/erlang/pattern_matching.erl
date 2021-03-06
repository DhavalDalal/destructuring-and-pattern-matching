#!/usr/bin/env escript

-record (name, {first = "", last = "", salutation = ""}).

capitalize(#name {first = FName, last = LName}) ->
	string:to_upper(FName) ++ " " ++ string:to_upper(LName).

pythagorean(X, Y) -> math:sqrt(math:pow(X, 2) + math:pow(Y, 2)).

% This version checks equality (P, P) - neat :)
distance(P, P) -> 0;
distance(P1, P2) when P1 =:= {0,0}; P2 =:= {0,0} ->
  {X,Y} = if P1 =:= {0,0} -> P2;
             P2 =:= {0,0} -> P1
  end,
  pythagorean(X, Y);

distance({X1,Y1}, {X2,Y2}) ->
  pythagorean(X2 - X1, Y2 - Y1).

main([]) ->
  Name = #name {first = "Dhaval", last = "Dalal", salutation = "Mr."},
  io:format("~p~n", [Name]),
  io:format("~p~n", [capitalize(Name)]),
  io:format("~p~n", [distance({0,0}, {0,0})]),
  io:format("~p~n", [distance({3,0}, {0,0})]),
  io:format("~p~n", [distance({0,0}, {0,4})]),
  io:format("~p~n", [distance({3,0}, {0,4})]).
  