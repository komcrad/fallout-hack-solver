(ns fallout-hack-solver.core)

(def sample ["fanatic" "discuss" "natural" "fertile" "dealing" "recruit" "blasted" "bedroom" "records" "regular" "defense" "ceiling" "becomes" "durable"])
(def sample2 ["guns" "golf" "roof" "juke" "uses" "move" "doom" "busy" "late" "born"])

(defn likeness?
  [s1 s2]
  (loop [original s1 compared s2 likeness 0]
    (if (not (empty? original))
      (recur (rest original) (rest compared)
             (if (= (first original) (first compared))
               (inc likeness)
               likeness))
      likeness)))

(defn find-likeness
  "filters words in coll that have likeness of x to s"
  [x s coll]
  (filter #(and (= x (likeness? s %)) (not (= s %))) coll))

(defn find-similar
  ([s coll]
   (loop [likeness (count s) m {}]
     (if (< -1 likeness)
       (let [similars (find-likeness likeness s coll)]
         (recur (dec likeness) (if (empty? similars)
                                 m
                                 (merge m {(keyword (str likeness)) similars}))))
       m)))
  ([coll]
   (loop [words coll result {}]
     (if (not (empty? words))
       (let [similars (find-similar (first words) coll)]
         (recur (rest words) (merge result {(keyword (first words))
                                             (find-similar (first words) coll)})))
       result))))

;largest group that has the smallest number of words

(defn largest-number-of-groups
  [m]
  (loop [m m largest-group 0]
    (if (not (empty? m))
      (let [group-num (count (val (first m)))]
        (if (>= group-num largest-group)
          (recur (rest m) group-num)
          (recur (rest m) largest-group)))
      largest-group)))

; I don't think I need this.... I got confused for a bit
(defn largest-groups
  [m]
  (let [n (largest-number-of-groups m)]
    (loop [m m qualified {}]
      (if (not (empty? m))
        (let [group (first m)]
          (if (= n (count (val group)))
            (recur (rest m) (merge qualified group))
            (recur (rest m) qualified)))
        qualified))))

(defn tiniest-hugest-child
  [m]
  (loop [m m smallest-largest-child 28 result {}]
    (if (not (empty? m))
      (let [largest-child (largest-number-of-groups (val (first m)))]
        (if (< largest-child smallest-largest-child)
          (recur (rest m) largest-child (merge {} (first m)))
          (recur (rest m) smallest-largest-child result)))
      result)))
