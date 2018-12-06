(defrecord Cylinder [baseRadius, height])
(defrecord Sphere [radius])

(defmulti volume class)

(defmethod volume Cylinder [{:keys [baseRadius height]}]
  (* (. Math PI) (Math/pow baseRadius 2) height))
  
(defmethod volume Sphere [{:keys [radius]}] 
  (* (double (/ 4 3)) (. Math PI) (Math/pow radius 3)))

(defmethod volume :default [s] nil)


(defmulti surface-area class)

(defmethod surface-area Cylinder [{:keys [baseRadius height]}]
	(let [base-area (* (. Math PI) (Math/pow baseRadius 2))
	    base-circumference (* 2 (. Math PI) baseRadius)]
	    (+ (* 2 base-area) (* base-circumference height))))
  
(defmethod surface-area Sphere [{:keys [radius]}] 
  (* 4 (. Math PI) (Math/pow radius 2)))

(defmethod surface-area :default [s] nil)

(def cylinder (Cylinder. 10 10))
(def sphere (Sphere. 10))

(println (volume cylinder)) ; 3141.59
(println (volume sphere)) ; 4188.79
(println (volume 2)) ;nil

(println (surface-area cylinder)) ;1256.63
(println (surface-area sphere)) ;1256.63
(println (surface-area 2)) ;nil