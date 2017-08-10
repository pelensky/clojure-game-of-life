(ns game-of-life.app-runner
  (:require [game-of-life.display :as display]
            [game-of-life.life :as life]))

(defn start []
  (display/welcome))


