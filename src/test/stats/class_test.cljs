(ns stats.class-test
  (:require [cljs.test :refer [deftest is]])
  (:require-macros [stats.class :refer [class]]
                   [stats.test-helpers :refer [stat+level]]))

(deftest it-adds-meta
  (let [Wizard (class Wizard)]
    (is (= "Wizard" (-> Wizard meta :name)))))

(deftest it-adds-stats
  (let [Bard (class Bard stat+level 8)
        bard (Bard {:level 2})]
    (is (= 10 (:stat bard)))))
