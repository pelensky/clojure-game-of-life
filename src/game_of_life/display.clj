(ns game-of-life.display)

(defn format-rows [coordinates grid x y]
  (if (empty? coordinates)
    grid
    (let [highest-x (max x (apply max (map #(get % 0) coordinates)))
          highest-y (max y (apply max (map #(get % 1) coordinates)))]
      (if (= grid [])
        (recur coordinates (into [] (conj (repeat (inc highest-y) (into [] (repeat (inc highest-x) " " ))))) highest-x highest-y )
        (let [current-coordinate (first coordinates)
              updated-coordinates (into [] (rest coordinates))
              current-x (get current-coordinate 0)
              current-y (get current-coordinate 1)
              updated-grid (assoc-in grid [current-y current-x] "*")]
          (recur updated-coordinates updated-grid x y)) ))))

(defn display [coordinates]
  (format-rows coordinates [] 0 0 ))

