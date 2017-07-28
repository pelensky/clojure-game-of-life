(ns game-of-life.life-spec
  (:require [speclj.core :refer :all]
            [game-of-life.life :refer :all]))


(describe "Life"
          (it "An empty grid stays empty"
              (should= []
                       (evolve []))))
