(def a-list [1 2 3 4])

(println a-list)

; Destructuring a list
; Tuple can be represented using a List
(let [[first second] a-list] 
  (println [first, second]))
     
(let [[first second & rest] a-list]
  (println [first, second, rest]))

; Destructuring a map (Associative Destructuring)
(def a-name {:first "Toto" :last "Mookey" :salutation "Mr."})

(println a-name)

(let [{fname :first lname :last salutation :salutation} a-name]
  (println fname lname))

(defn capitalize [{fname :first lname :last}] 
  (str (.toUpperCase fname) " " (.toUpperCase lname)))

(println (capitalize a-name))
