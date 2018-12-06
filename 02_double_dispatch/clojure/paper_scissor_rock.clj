; Multi-methods can be used to solve this problem
; Here is our dispatch function
(defmulti beats
  (fn [e1 e2] [e1 e2]))

; We’ll use keys :rock  :paper and :scissor
; to represent the three choices.
(defmethod beats [:paper :scissor] [e1 e2] "paper loses")
(defmethod beats [:paper :rock] [e1 e2] "paper wins")
(defmethod beats [:scissor :paper] [e1 e2] "scissor wins")
(defmethod beats [:scissor :rock] [e1 e2] "scissor loses")
(defmethod beats [:rock :paper] [e1 e2] "rock loses")
(defmethod beats [:rock :scissor] [e1 e2] "rock wins")
(defmethod beats :default [e1 e2] "draw")

(println "paper beats paper = "     (beats :paper :paper))
(println "paper beats scissor = "   (beats :paper :scissor))
(println "paper beats rock = "      (beats :paper :rock))
(println "scissor beats paper = "   (beats :scissor :paper))
(println "scissor beats scissor = " (beats :scissor :scissor))
(println "scissor beats rock = "    (beats :scissor :rock))
(println "rock beats paper = "      (beats :rock :paper))
(println "rock beats scissor = "    (beats :rock :scissor))
(println "rock beats rock = "       (beats :rock :rock))