(ns challenge.filter-prime-test
  (:require [clojure.test :refer [deftest is run-all-tests]]
            [challenge.filter-prime :as fp]))

(def expected (list 2 3 5 7 11 13 17 19 23 29))

(deftest test-generate-primes
  (is (= expected (take 10 (fp/generate-primes)))))

(defn div? [x y]
  (zero? (mod x y)))

(defn prime? [n]
  (and (> n 1)
       (not-any? (partial div? n) (range 2 n))))

(deftest test-prime?
  (is (every? prime? (take 100 fp/l-primes))))

(run-all-tests)