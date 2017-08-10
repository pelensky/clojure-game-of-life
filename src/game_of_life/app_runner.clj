(ns game-of-life.app-runner
  (:require [game-of-life.display :as display]
            [game-of-life.life :as life]))

(defn generations [world]
  (let [next-generation (life/evolve world)]
  (display/display world)
  (if (>= 0 (count world))
    (display/game-over)
    (recur next-generation))))

(defn starting-coordinates [world]
  (let [updated-world (conj world [(rand-int 5) (rand-int 5)])]
    (if (<= 10 (count world))
      world
      (recur updated-world))))

(defn start []
  (display/welcome)
  (generations (starting-coordinates #{})))

