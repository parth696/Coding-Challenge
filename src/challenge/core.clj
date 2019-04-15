(ns challenge.core
  (:require [clojure.pprint :as pp]
            [challenge.filter-prime :as fp])
  (:gen-class))

(defn print-multiplication-table
  "To Print multiplication table to stdout."
  [result]
  (pp/print-table
    (map #(into (sorted-map) %) result)))

(defn prime-generator
  "Returns a result of multiplying row to column.Structure is a list of list of maps.
   Since clojure.pprint/print-table requires collection of maps as an argument.
   Default value is taken 10 as per the requirments given."
  ([n]
    (let [prime-list (take n fp/l-primes)]
      (partition (inc n)
        (for [rw prime-list
              cl (cons 1 prime-list)]
          {cl (* rw cl)})))))

(defn -main 
  ([]
    (-> (prime-generator 10)
        print-multiplication-table))
  ([param]
    (try
      (-> (prime-generator (Long/parseLong param))
          print-multiplication-table)
    (catch Throwable e))))
