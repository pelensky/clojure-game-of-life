(ns game-of-life.core
  (:require [game-of-life.app-runner :as app-runner]))

(defn -main [& args]
  (app-runner/start))
