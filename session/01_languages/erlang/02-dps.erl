#!/usr/bin/env escript

-record (name, {first, last, saluatation}).

capitalize(#name {first = FName, last = LName}) ->
	string:to_upper(FName) ++ " " ++ string:to_upper(LName).

mid(A1, A2) -> (A1 + A2) / 2.

mid_point(P, P) -> P;
mid_point({0,0}, P2) -> P2;
mid_point(P1, {0,0}) -> P1;
mid_point({X1,Y1}, {X2,Y2}) -> {mid(X1,X2), mid(Y1, Y2)}.

main([]) ->
	A = 1,
	io:format("~p~n", [A]),
  	List = [1,2,3,4],
  	io:format("~p ~n", [List]),
	[First,Second|Rest] = List,
  	io:format("~p ~p ~p ~n", [First, Second, Rest]),
	{X, Y, Z} = {10, 20, 30},
  	io:format("~p ~p ~p ~n", [X, Y, Z]),
	Name = #name {first = "Toto", last = "Mokey", saluatation = "Ms."},
	io:format("~p~n", [Name]),
	#name {first = FName, last = LName} = Name,
	io:format("~p ~p~n", [FName, LName]),
	io:format("~p ~n", [capitalize(Name)]),
	io:format("~p~n", [mid_point({2,3}, {4,5})]),
	io:format("~p~n", [mid_point({0,0}, {4,5})]),
	io:format("~p~n", [mid_point({2,3}, {0,0})]),
	io:format("~p~n", [mid_point({0,0}, {0,0})]).
