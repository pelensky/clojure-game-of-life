(ns game-of-life.display)

(defn correct-coordinates [grid]
  (let [lowest-x (apply min (map #(get % 0) grid))
        lowest-y (apply min (map #(get % 1) grid))
        incremented-x (if (> 0 lowest-x)
                        (for [cell grid]
                          (update cell 0 #(+ (- lowest-x) %)))
                        grid)
        incremented-y (if (> 0 lowest-y)
                        (for [cell incremented-x]
                          (update cell 1 #(+ (- lowest-y) %)))
                          incremented-x)]
    (into #{} incremented-y)))

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
      (recur (correct-coordinates coordinates) (empty-grid-correct-size (correct-coordinates coordinates) grid x y) (highest x 0 (correct-coordinates coordinates)) (highest y 1 (correct-coordinates coordinates)) )
      (recur (remaining (correct-coordinates coordinates)) (updated grid (correct-coordinates coordinates)) x y) )) )

(defn display [coordinates]
  (println (create-grid coordinates [] 0 0)))

(defn welcome []
  (println "Game of Life"))

(defn game-over []
  (println "Game of Life Complete"))

