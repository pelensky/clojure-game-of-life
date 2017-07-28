(ns game-of-life.life)

(def neighbours
  [ [-1 1]  [0 1]   [1 1]
    [-1 0]          [1 0]
    [-1 -1] [0 -1]  [1 -1]])

(defn find-all-neighbours [cell]
   (let [x (get cell 0)
         y (get cell 1)]
      map #([(+ x (get % 0)) (+ y (get % 1))]) neighbours))

(defn count-live-neighbours [cell grid]
  (count (clojure.set/intersection (set grid) (set (find-all-neighbours cell)))))

(defn live-on? [cell grid]
   true)

(defn evolve [grid]
  [] )
