(def a-list [1 2 3 4 5])

(println a-list)

; Destructuring a list
; Tuple can be represented using a List
(let [[first second] a-list] 
  (println [first, second]))
     
(let [[first second & rest] a-list]
  (println [first, second, rest]))


; Destructuring a map (Associative Destructuring)
(def a-name {:first "Dhaval" :last "Dalal" :salutation "Mr."})

(println a-name)

(let [{fname :first lname :last salutation :salutation} a-name]
  (println fname lname))

(defn capitalize [{fname :first lname :last}] 
  (str (.toUpperCase fname) " " (.toUpperCase lname)))

(println (capitalize a-name))

; Idiomatic Clojure does not have pattern matching like that in Scala, 
; but we can use multi-methods to achieve that.
(defmulti mid-point 
  ; Dispatcher Function
  ; Out-of-box Clojure has case - but it does exact match and
  ; hence resorted to cond.  Other option is to use core.match
  ; library (not a part of standard distribution).
  (fn [x y] 
    (cond (= x y [0 0]) [:zero :zero]
          (= x [0 0])   [:zero :any ]
          (= y [0 0])   [:any  :zero]
          :else [x y])))
          
(defmethod mid-point [:zero :zero] [x y] [0 0])
(defmethod mid-point [:any :zero] [x y] x)
(defmethod mid-point [:zero :any] [x y] y)
(defmethod mid-point :default [[x1 y1] [x2 y2]] 
  (letfn [(mid [[a1 a2]]
    (double (/ (+ a1 a2) 2)))]
    [(mid [x1 x2]) (mid [y1 y2])]))


(println (mid-point [0 0] [0 0]))
(println (mid-point [2 3] [0 0]))
(println (mid-point [0 0] [4 5]))
(println (mid-point [2 3] [4 5]))
