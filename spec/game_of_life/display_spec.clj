(ns game-of-life.display-spec
  (:require [speclj.core :refer :all]
            [game-of-life.display :refer :all]))

(describe "Displays"
          (it "an empty grid when passed an empty grid"
              (should-contain "          \n          \n          \n         "
                              (with-out-str (display ["          " "          " "          " "          "])))))
