(ns game-of-life.display)

(defn- current-x [coordinates]
  (get (first coordinates) 0))

(defn- current-y [coordinates]
  (get (first coordinates) 1))

(defn- remaining [coordinates]
  into [] (rest coordinates))

(defn- updated [grid coordinates]
  (assoc-in grid [(current-y coordinates) (current-x coordinates)] "*"))

(defn- highest [letter position coordinates]
  (inc (max letter (apply max (map #(get % position) coordinates)))))

(defn- empty-grid-correct-size [coordinates grid x y]
  (into grid (conj (repeat (highest y 1 coordinates) (into grid (repeat (highest x 0 coordinates) " "))))))

(defn- format-rows [grid]
  (for [row grid]
    (clojure.string/join "" row)))

(defn- format-grid [grid]
  (clojure.string/join "\n" grid))

(defn create-grid [coordinates grid x y]
  (if (empty? coordinates)
    (format-grid (format-rows grid))
    (if (empty? grid)
        (recur coordinates (empty-grid-correct-size coordinates grid x y) (highest x 0 coordinates) (highest y 1 coordinates) )
        (recur (remaining coordinates) (updated grid coordinates) x y) )))

(defn display [coordinates]
  (println (create-grid coordinates [] 0 0)))

