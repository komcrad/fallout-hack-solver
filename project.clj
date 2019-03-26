(defproject fallout-hack-solver "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :repl-options
  {:init (do (use '[clojure.tools.namespace.repl :only (refresh)])
             (clojure.tools.namespace.repl/refresh)
             (use 'fallout-hack-solver.core)
             (require '[fallout-hack-solver.core :as c]))}
  :main ^:skip-aot fallout-hack-solver.core
  :plugins [[komcrad/lein-autoreload "0.1.3-SNAPSHOT"]]
  :profiles {:uberjar {:aot :all}})
