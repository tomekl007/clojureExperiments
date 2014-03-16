(ns solutions.atom-cache
  (:refer-clojure :exclude [get]))

; START:create
(defn create
  []
  (atom {}))
; END:create

; START:get
(defn get
  [cache key]
  (@cache key))
; END:get

; START:put
(defn put
  ([cache value-map] (println "put value-map" cache value-map)
     (swap! cache merge value-map))
  ([cache key value] (println "put key-value" key value)
     (swap! cache assoc key value)))
; END:put
; START:usage
(def ac (create))
(put ac :quote "I'm your father, Luke.")
(put ac {:sth "sth string"})
(println (str "Cached item: " (get ac :quote)))
(println (str "Cached item: " (get ac :sth)))
; END:usage