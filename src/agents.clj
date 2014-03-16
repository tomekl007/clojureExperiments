(defn twice [x] (* 2 x))
(def tribbles (agent 1))
(send tribbles twice)
(println  @tribbles)

(defn slow-twice [x]
  (do
    (Thread/sleep 5000)
    (* 2 x)))
(println  @tribbles)
(send tribbles slow-twice)
(println  @tribbles)    ;reads are non blocking
;if want to know value do (println @tribbles) five seconds later
(println await @tribbles)

(def finer-things (future (Thread/sleep 5000) "take time"))
@finer-things
