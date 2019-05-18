(ns stats.core
  (:require [reagent.core :as r]
            [stats.components.app :refer [app]]))

(defn init []
  (r/render [app] (.getElementById js/document "app")))
