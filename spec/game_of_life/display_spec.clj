(ns game-of-life.display-spec
  (:require [speclj.core :refer :all]
            [game-of-life.display :refer :all]))

(describe "Displays"
          (it "only the cell if it is in position 0 1"
              (should-contain "1010"
                              (with-out-str (display [[10 0] [0 10]])))))
