; We’ll use record to represent the three choices.
(defrecord Paper [])
(defrecord Scissor [])
(defrecord Rock [])

; Multi-methods can be used to solve this problem
; Here is our dispatch function
(defmulti beats
  (fn [e1 e2] [(class e1) (class e2)]))

(defmethod beats [Paper   Scissor] [e1 e2] "paper loses")
(defmethod beats [Paper   Rock]    [e1 e2] "paper wins")
(defmethod beats [Scissor Paper]   [e1 e2] "scissor wins")
(defmethod beats [Scissor Rock]    [e1 e2] "scissor loses")
(defmethod beats [Rock    Paper]   [e1 e2] "rock loses")
(defmethod beats [Rock    Scissor] [e1 e2] "rock wins")
(defmethod beats :default          [e1 e2] "draw")

(println "paper beats paper = "     (beats (Paper.)   (Paper.)))
(println "paper beats scissor = "   (beats (Paper.)   (Scissor.)))
(println "paper beats rock = "      (beats (Paper.)   (Rock.)))
(println "scissor beats paper = "   (beats (Scissor.) (Paper.)))
(println "scissor beats scissor = " (beats (Scissor.) (Scissor.)))
(println "scissor beats rock = "    (beats (Scissor.) (Rock.)))
(println "rock beats paper = "      (beats (Rock.)    (Paper.)))
(println "rock beats scissor = "    (beats (Rock.)    (Scissor.)))
(println "rock beats rock = "       (beats (Rock.)    (Rock.)))