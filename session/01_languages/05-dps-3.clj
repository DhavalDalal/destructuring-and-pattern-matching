; Destructuring a map (Associative Destructuring)
(def a-name {:first "Toto" :last "Mookey" :salutation "Mr."})

(println a-name)

(let [{fname :first lname :last} a-name]
  (println fname lname))

(require '[clojure.string :refer [upper-case]])
  
(defn capitalize [{fname :first lname :last}] 
  (str (upper-case fname) " " (upper-case lname)))

(println (capitalize a-name))
