; START:protocol
(defprotocol Compass
  (direction [c])
  (left [c])
  (right [c]))
; END:protocol

; START:directions
(def directions [:north :east :south :west])
; END:directions

; START:turn
(defn turn
  [base amount]
  (rem (+ base amount) (count directions)))
; END:turn

; START:defrecord
(defrecord SimpleCompass [bearing]
  Compass
; END:defrecord
; START:directionfunction
  (direction [this] (directions bearing))   ;[this] equivalent of [_]
; END:directionfunction
; START:leftandright
  (left [_] (SimpleCompass. (turn bearing 3)))
  (right [_] (SimpleCompass. (turn bearing 1)))
; END:leftandright
; START:object
  Object
  (toString [this] (str "[" (directions this) "]")))
; END:object

(def c (SimpleCompass. 0))
(def turned (left c))
(println turned)
(println c)
(println :bearing c)
(println (get directions (:bearing c)) )
