(ns stats.state
  (:require [reagent.core :as r]
            [stats.classes :refer [classes name->class]]))

(defonce character (r/atom {:class (-> classes first meta :name)
                            :level 1
                            :str 8
                            :dex 8
                            :con 8
                            :int 8
                            :wis 8
                            :cha 8}))

(defn change-level
  [new-level]
  (let [new-level (js/parseInt new-level)]
    (when (<= 1 new-level 10)
      (swap! character assoc :level new-level))))

(defn change-class
  [new-class]
  (when (name->class new-class)
    (swap! character assoc :class new-class)))

(defn valid-stat? [stat] (some #{stat} [:str :dex :con :int :wis :cha]))

(defn change-stat
  [stat new-val]
  (let [new-val (js/parseInt new-val)]
    (when (and (valid-stat? stat)
               (<= 8 new-val 24))
      (swap! character assoc stat new-val))))
