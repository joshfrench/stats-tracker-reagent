(ns stats.state-test
  (:require [stats.state :as s]
            [cljs.test :refer [deftest is use-fixtures]]))

(defn reset-state [f]
  (reset! s/character {:class "Barbarian"
                       :level 1
                       :str 8
                       :dex 8
                       :con 8
                       :int 8
                       :wis 8
                       :cha 8})
  (f))

(use-fixtures :each reset-state)

(deftest it-changes-level
  (s/change-level 2)
  (is (= 2 (:level @s/character))))

(deftest it-bounds-lower-level
  (s/change-level 0)
  (is (= 1 (:level @s/character))))

(deftest it-bounds-upper-level
  (s/change-level 11)
  (is (= 1 (:level @s/character))))

(deftest it-changes-class
  (s/change-class "Wizard")
  (is (= "Wizard" (:class @s/character))))

(deftest it-does-not-change-invalid-class
  (s/change-class "Bugbear")
  (is (= "Barbarian" (:class @s/character))))

(deftest it-changes-stat
  (s/change-stat :dex 10)
  (is (= 10 (:dex @s/character))))

(deftest it-bounds-lower-stat
  (s/change-stat :str 7)
  (is (= 8 (:str @s/character))))

(deftest it-bounds-upper-stat
  (s/change-stat :wis 25)
  (is (= 8 (:wis @s/character))))
