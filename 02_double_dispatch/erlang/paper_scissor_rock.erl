#!/usr/bin/env escript

% We’ll use  atoms  rock  paper scissor
% to represent the three choices.
beats(paper, scissor) -> false;
beats(paper, rock) -> true;
beats(scissor, paper) -> true;
beats(scissor, rock) -> false;
beats(rock, paper) -> false;
beats(rock, scissor) -> true;
beats(E, E) -> false.
  
main([]) ->
  io:format("~p ~p~n", ["paper beats paper?", beats(paper, paper)]),
  io:format("~p ~p~n", ["paper beats scissor?", beats(paper, scissor)]),
  io:format("~p ~p~n", ["paper beats rock?", beats(paper, rock)]),
  io:format("~p ~p~n", ["scissor beats paper?", beats(scissor, paper)]),
  io:format("~p ~p~n", ["scissor beats scissor?", beats(scissor, scissor)]),
  io:format("~p ~p~n", ["scissor beats rock?", beats(scissor, rock)]),
  io:format("~p ~p~n", ["rock beats paper?", beats(rock, paper)]),
  io:format("~p ~p~n", ["rock beats scissor?", beats(rock, scissor)]),
  io:format("~p ~p~n", ["rock beats rock?", beats(rock, rock)]).
  
