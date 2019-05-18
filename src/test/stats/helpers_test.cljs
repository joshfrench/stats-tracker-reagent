(ns stats.helpers-test
  (:require [cljs.test :refer [deftest is are]]
            [stats.helpers :as h]))

(deftest middle
  (is (= 5
         (h/middle 10 0 5)
         (h/middle 5 10 0))))

(deftest modifier
  (are [x y] (every? #(= x (h/modifier %)) y)
      -1 [8 9]
       0 [10 11]
       1 [12 13]
       2 [14 15]
       3 [16 17]
       4 [18 19]
       5 [20 21]
       6 [22 23]))

(deftest hp-multipler
  (is (= '(3 4 5 6 8 10 12 16 20 24)
          (map h/hp-multiplier (range 1 11)))))

(deftest tier
  (are [x y] (every? #(= y (h/tier x)))
       1  1
       2  1
       3  1
       4  1
       5  2
       6  2
       7  2
       8  3
       9  3
       10 3))

(deftest +-
  (do (is (= "- 1" (h/+- -1)))
      (is (= "+ 1" (h/+-  1)))))
