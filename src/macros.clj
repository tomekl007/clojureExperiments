; To prevent premature execution, we’ll
; put a quote in front of the expression we want to expand
(defmacro unless [test body]
  (list 'if (list 'not test) body))
(println (macroexpand '(unless condition body)))
(unless true (println "No more danger, Will."))
(unless false (println "Now, THIS is The FORCE."))
