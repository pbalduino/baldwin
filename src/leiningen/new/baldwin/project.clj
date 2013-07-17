(def {{name}} :foo)

(defproject {{sanitized}} "0.1.0-SNAPSHOT"
  :description "FIXME: please write a nice description"
  :url "FIXME: http://www.{{sanitized}}.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[ring "1.2.0"]]
  :plugins [[lein-ring "0.8.5"]]
  :min-lein-version "2.0.0"
  :dependencies
    [[org.clojure/clojure "1.5.1"]
     [compojure "1.1.5"]
     [com.taoensso/timbre "2.1.2"]
     [com.postspectacular/rotor "0.1.0"]
     [com.taoensso/tower "1.7.1"]
     [lib-noir "0.6.6"]
     [log4j "1.2.17"
        :exclusions
          [javax.mail/mail
           javax.jms/jms
           com.sun.jdmk/jmxtools
           com.sun.jmx/jmxri]]
     [korma "0.3.0-RC5"]]
  :ring 
    {:handler bootstrap/war-handler
     :init    bootstrap/init
     :destroy bootstrap/destroy})
