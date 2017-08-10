(ns game-of-life.app-runner
  (:require [game-of-life.display :as display]
            [game-of-life.life :as life]))

(defn start []
  (display/welcome))

(defn starting-coordinates [world]
  (let [updated-world (conj world [(rand-int 5) (rand-int 5)])]
    (if (<= 10 (count world))
      world
      (recur updated-world))))


