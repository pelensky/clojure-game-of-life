(ns game-of-life.display)

(defn format-grid [coordinates grid x y]
  (let [highest-x (max x (apply max (map #(get % 0) coordinates)))
        highest-y (max y (apply max (map #(get % 1) coordinates)))]
      (println (str  highest-x highest-y))))

(defn display [coordinates]
  (println (format-grid coordinates [] 0 0)))

