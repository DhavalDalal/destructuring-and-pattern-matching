#!/usr/bin/env escript

-record (name, {first = "", last = "", salutation = ""}).

capitalize(#name {first = FName, last = LName}) ->
	string:to_upper(FName) ++ " " ++ string:to_upper(LName).

mid(A1, A2) -> (A1 + A2) / 2.

% This version checks equality (P, P) - neat :)
midpoint(P, P) -> P;
midpoint(P1, {0, 0}) -> P1;
midpoint({0, 0}, P2) -> P2;
midpoint({X1, Y1}, {X2, Y2}) -> {mid(X1, X2), mid(Y1, Y2)}.

main([]) ->
  Name = #name {first = "Dhaval", last = "Dalal", salutation = "Mr."},
  io:format("~p~n", [Name]),
  io:format("~p~n", [capitalize(Name)]),
  io:format("~p~n", [midpoint({0,0}, {0,0})]),
  io:format("~p~n", [midpoint({2,3}, {0,0})]),
  io:format("~p~n", [midpoint({0,0}, {4,5})]),
  io:format("~p~n", [midpoint({2,3}, {4,5})]).
  