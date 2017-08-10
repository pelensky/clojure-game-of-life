(ns game-of-life.app-runner-spec
  (:require [speclj.core :refer :all]
            [game-of-life.app-runner :refer :all]))

(describe "App Runner"

         (it "gets a set of 10 random starting coordinates"
             (should= 10
                      (count (starting-coordinates #{})))))
