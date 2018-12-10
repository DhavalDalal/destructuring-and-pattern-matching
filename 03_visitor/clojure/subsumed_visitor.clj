(defrecord Cylinder [baseRadius height])
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

(defrecord OpenGL [])
(defrecord SVG [])

(defmulti render 
  (fn [platform shape] [(class platform) (class shape)]))
  
(defmethod render [OpenGL Cylinder] [platform shape] (println "OpenGL: Rendering Cylinder"))
(defmethod render [OpenGL Sphere]   [platform shape] (println "OpenGL: Rendering Sphere"))
(defmethod render [SVG Cylinder] [platform shape] (println "SVG: Rendering Cylinder"))
(defmethod render [SVG Sphere]   [platform shape] (println "SVG: Rendering Sphere"))
(defmethod render [Object clojure.lang.IPersistentVector] [platform shapes] 
  (println "Rendering Composite...")
  (doall (map #(render platform %) shapes)))
(defmethod render :default [platform shape] nil)

(render (OpenGL.) composite)
(render (SVG.) composite)
(println "DONE")
