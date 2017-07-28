(ns game-of-life.life)

(def neighbours
  [ [-1 1]  [0 1]   [1 1]
    [-1 0]          [1 0]
    [-1 -1] [0 -1]  [1 -1]])

(defn- update-coordinate [cell neighbour]
[(+ (get cell 0) (get neighbour 0)) (+ (get cell 1) (get neighbour 1))])

(defn find-all-neighbours [cell]
  (map #(update-coordinate cell %) neighbours))

(defn find-non-living-neighbours [cell grid]
  (clojure.set/difference  (set (find-all-neighbours cell)) (set grid)))

(defn find-all-non-living-neighbours [grid]
  (reduce into #{}
    (map #(find-non-living-neighbours % grid) grid)))

(defn count-live-neighbours [cell grid]
  (count (clojure.set/intersection (set grid) (set (find-all-neighbours cell)))))

(defn live-on? [cell grid]
  (let [live-neighbours (count-live-neighbours cell grid)]
    (if (and (> live-neighbours 1) (< live-neighbours 4))
      true
      false)))

(defn evolve [grid]
  [] )
