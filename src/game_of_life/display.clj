(ns game-of-life.display)

(defn display [grid]
  (println (clojure.string/join "\n" grid)))

