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

(defn pythagorean [x y] (Math/sqrt (+ (* x x) (* y y))))   
(defmethod distance [:zero :zero] [x y] 0)
(defmethod distance [:any :zero]  [[x1 y1] y]  (pythagorean x1 y1))
(defmethod distance [:zero :any]  [x [x2 y2]]  (pythagorean x2 y2))
(defmethod distance :default [[x1 y1] [x2 y2]] (pythagorean (- x2 x1) (- y2 y1)))

(println (distance [0 0] [0 0]))
(println (distance [3 0] [0 0]))
(println (distance [0 0] [0 4]))
(println (distance [3 0] [0 4]))