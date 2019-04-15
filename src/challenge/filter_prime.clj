(ns challenge.filter-prime)

(defn find-factors
  "To find their known factors."
  [n factor facs]
  (update-in facs [(+ n factor)] conj factor))

(defn generate-primes
  ([] (generate-primes 2 {}))
  ([n facs]
    (if-let [factors (get facs n)]
      (recur (inc n)
             (reduce #(find-factors n %2 %1) (dissoc facs n) factors))
      (lazy-seq
        (cons n (generate-primes (inc n) (assoc facs (* n n) (list n))))))))

(def l-primes (generate-primes))
