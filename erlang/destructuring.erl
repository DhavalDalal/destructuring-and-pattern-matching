#!/usr/bin/env escript

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
  [First,Second|Rest] = [1,2,3,4,5,6],
  io:format("~p, ~p, ~p~n", [First, Second, Rest]),
  
  % Destructuring Map
  #{ K := V } = M
  [First,Second|Rest] = [1,2,3,4,5,6],
  io:format("~p, ~p, ~p~n", [First, Second, Rest]),
  
  % Destructuring n-Tuples
  {X, Y} = {10, 20}, 
  io:format("~p, ~p~n", [X, Y]).
