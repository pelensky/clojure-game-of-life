(ns game-of-life.display)

(defn- current-x [coordinates]
  (get (first coordinates) 0))

(defn- current-y [coordinates]
  (get (first coordinates) 1))

(defn- remaining [coordinates]
  into [] (rest coordinates))

(defn- updated [grid coordinates]
  (assoc-in grid [(current-y coordinates) (current-x coordinates)] "*"))

(defn create-grid [coordinates grid x y]
  (if (empty? coordinates)
    grid
    (let [highest-x (max x (apply max (map #(get % 0) coordinates)))
          highest-y (max y (apply max (map #(get % 1) coordinates)))
          updated-grid (into grid (conj (repeat (inc highest-y) (into [] (repeat (inc highest-x) " " )))))]
      (if (empty? grid)
        (recur coordinates updated-grid highest-x highest-y )
        (recur (remaining coordinates) (updated grid coordinates) x y) ))))

(defn- format-rows [grid]
  (for [row grid]
    (clojure.string/join "" row)))

(defn- format-grid [grid]
  (clojure.string/join "\n" grid))

(defn display [coordinates]
  (let [formatted-grid (create-grid coordinates [] 0 0)
        formatted-rows (format-rows formatted-grid)]
    (println (format-grid formatted-rows))))

