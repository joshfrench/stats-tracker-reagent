(ns stats.test-helpers)

(defmacro stat+level [d]
  `{:stat (+ ~d ~'level)})
