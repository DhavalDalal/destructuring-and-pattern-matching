(def a-list [1,2,3,4,5])

(println a-list)

; Destructuring a list
; Tuple can be represented using a List
(println (let [[first second] a-list]
     [first, second]))
     
(let [
      [first second & rest] a-list
     ]
     (println [first, second, rest]))


; Destructuring a map (Associative Destructuring)
(def a-name {:first "Dhaval" :last "Dalal" :salutation "Mr."})

(println a-name)

(let [
      {fname :first lname :last salutation :salutation} a-name
     ]
  (println fname lname))

(require '[clojure.string :as string])

(defn capitalize [{fname :first lname :last}] (str (string/upper-case fname) " " (string/upper-case lname)))

(println (capitalize a-name))

; Idiomatic Clojure does not have pattern matching like that in Scala, 
; but we can use multi-methods to achieve that.
