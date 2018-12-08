(defrecord Cylinder [baseRadius, height])
(defrecord Sphere [radius])

(defmulti volume class)

(defmethod volume Cylinder [{:keys [baseRadius height]}]
  (* (. Math PI) (Math/pow baseRadius 2) height))
  
(defmethod volume Sphere [{:keys [radius]}] 
  (* (double (/ 4 3)) (. Math PI) (Math/pow radius 3)))

(defmethod volume clojure.lang.IPersistentVector [shapes]
  (reduce + 0 (map volume shapes)))

(defmethod volume :default [s] nil)

(defmulti surface-area class)

(defmethod surface-area Cylinder [{:keys [baseRadius height]}]
	(let [base-area (* (. Math PI) (Math/pow baseRadius 2))
	    base-circumference (* 2 (. Math PI) baseRadius)]
	    (+ (* 2 base-area) (* base-circumference height))))
  
(defmethod surface-area Sphere [{:keys [radius]}] 
  (* 4 (. Math PI) (Math/pow radius 2)))

(defmethod surface-area clojure.lang.IPersistentVector [shapes]
  (reduce + 0 (map surface-area shapes)))

(defmethod surface-area :default [s] nil)

(def cylinder (Cylinder. 10 10))
(def sphere (Sphere. 10))
(def composite [cylinder sphere])

(println (volume cylinder)) ; 3141.59
(println (volume sphere)) ;4188.79
(println (volume composite)) 
(println (volume 2)) ;nil

(println (surface-area cylinder)) ;1256.63
(println (surface-area sphere)) ;1256.63
(println (surface-area composite)) 
(println (surface-area 2)) ;nil

(defmulti render-opengl class)
(defmethod render-opengl Cylinder [args] (println "OpenGL: Rendering Cylinder"))
(defmethod render-opengl Sphere [args] (println "OpenGL: Rendering Sphere"))
(defmethod render-opengl clojure.lang.IPersistentVector [shapes] 
  (println "Rendering Composite...")
  (doall (map render-opengl shapes)))
(defmethod render-opengl :default [s] nil)

(render-opengl composite)

(defmulti render-direct3d class)
(defmethod render-direct3d Cylinder [args] (println "Direct3d: Rendering Cylinder"))
(defmethod render-direct3d Sphere [args] (println "Direct3d: Rendering Sphere"))
(defmethod render-direct3d clojure.lang.IPersistentVector [shapes] 
  (println "Rendering Composite...")
  (doall (map render-direct3d shapes)))
(defmethod render-direct3d :default [s] nil)

(render-direct3d composite)
