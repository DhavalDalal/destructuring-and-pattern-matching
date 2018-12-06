#!/usr/bin/env escript

-record (name, {first, last, salutation}).

main([]) ->
  % if a variable doesn't have a value already, 
  % if it isn't bound, then equality gives it a value.
  A = 10,
  io:format("~p~n", [A]),
  % But if it is already bound,  then equality is a 
  % check on its value.  it's a match to see:  
  % is this thing  on the left equal to this thing on the right?
  % A = 20,
  
  % Destructuring List
  List = [1,2,3,4,5,6],
  [First,Second|Rest] = List,
  io:format("~p, ~p, ~p~n", [First, Second, Rest]),

  % Destructuring n-Tuples
  {X, Y} = {10, 20}, 
  io:format("~p, ~p~n", [X, Y]),

  % Destructuring Map (skip this)
  Map = #{ "a" => 2, "b" => 4, "c" => 8 },
  #{ "a" := V1, "c" := V3 } = Map,
  io:format("~p, ~p~n", [V1, V3]),

  % Destructuring records
  Name = #name { first = "Dhaval", last = "Dalal", salutation = "Mr."},
  io:format("~p~n", [Name]),
  #name{ first = FName, last = LName} = Name,
  io:format("~p ~p~n", [FName, LName]).  
