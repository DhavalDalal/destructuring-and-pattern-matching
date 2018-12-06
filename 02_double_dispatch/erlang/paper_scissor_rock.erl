#!/usr/bin/env escript

% We’ll use  atoms  rock  paper scissor
% to represent the three choices.
beats(paper, scissor) -> "paper loses";
beats(paper, rock) -> "paper wins";
beats(scissor, paper) -> "scissor wins";
beats(scissor, rock) -> "scissor loses";
beats(rock, paper) -> "rock wins";
beats(rock, scissor) -> "rock loses";
beats(E, E) -> "draw".
  
main([]) ->
  io:format("~s ~s~n", ["paper beats paper =", beats(paper, paper)]),
  io:format("~s ~s~n", ["paper beats scissor =", beats(paper, scissor)]),
  io:format("~s ~s~n", ["paper beats rock =", beats(paper, rock)]),
  io:format("~s ~s~n", ["scissor beats paper =", beats(scissor, paper)]),
  io:format("~s ~s~n", ["scissor beats scissor =", beats(scissor, scissor)]),
  io:format("~s ~s~n", ["scissor beats rock =", beats(scissor, rock)]),
  io:format("~s ~s~n", ["rock beats paper =", beats(rock, paper)]),
  io:format("~s ~s~n", ["rock beats scissor =", beats(rock, scissor)]),
  io:format("~s ~s~n", ["rock beats rock =", beats(rock, rock)]).
  
