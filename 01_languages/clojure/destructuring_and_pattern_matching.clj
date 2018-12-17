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
(defmulti distance
  ; Dispatcher Function
  ; Out-of-box Clojure has case - but it does exact match and
  ; hence resorted to cond.  Other option is to use core.match
  ; library (not a part of standard distribution).
  (fn [x y] 
    (cond (= x y [0 0]) [:zero :zero]
          (= x [0 0])   [:zero :any]
          (= y [0 0])   [:any :zero]
          :else [x y])))
          
(defn dist [x y] (Math/sqrt (+ (* x x) (* y y))))   
(defmethod distance [:zero :zero] [x y] 0)
(defmethod distance [:any :zero]  [[x1 y1] y] (dist x1 y1))
(defmethod distance [:zero :any]  [x [x2 y2]] (dist x2 y2))
(defmethod distance :default [[x1 y1] [x2 y2]] (dist (- x2 x1) (- y2 y1)))

(println (distance [0 0] [0 0]))
(println (distance [3 0] [0 0]))
(println (distance [0 0] [0 4]))
(println (distance [3 0] [0 4]))
