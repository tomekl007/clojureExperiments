(defprotocol Something
  (doSth [s])
  (concatMy [s] )
  )

(defrecord SomethingImpl [field1, field2]
  Something
  (doSth [_] (println field1, field2))
  (concatMy [this] (str field1, ";", field2))
)

(def sthInstance (SomethingImpl. "field1- value", "field2- value"))
(doSth sthInstance)
(def stringFromInstance (concatMy sthInstance ) )
(println stringFromInstance)
