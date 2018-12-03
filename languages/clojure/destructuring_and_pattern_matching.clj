(def a-list [1,2,3,4,5])

(println a-list)

; Destructuring a list
(println (let [[first second] a-list]
     [first, second]))
     
(let [
      [first second & rest] a-list
     ]
     (println [first, second, rest]))


; Destructuring a map (Associative Destructuring)
; Tuple can be represented using a Map
(def a-name {:first "Dhaval" :last "Dalal" :salutation "Mr."})

(println a-name)

(let [
      {fname :first lname :last salutation :salutation} a-name
     ]
  (println fname lname))
    


