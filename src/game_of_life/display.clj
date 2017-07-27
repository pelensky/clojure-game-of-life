(ns game-of-life.display)

(defn format-grid [coordinates grid x y]
  (let [highest-x (max x (apply max (map #(get % 0) coordinates)))
        highest-y (max y (apply max (map #(get % 1) coordinates)))]
      (if (= grid [])
        (let [updated-grid (conj (repeat (inc highest-y) (repeat (inc highest-x) " " )))]
          updated-grid))))

(defn display [coordinates]
  (format-grid coordinates [] 0 0 ))

