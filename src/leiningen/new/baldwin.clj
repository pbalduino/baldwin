(ns leiningen.new.baldwin
  (:use [leiningen.new.templates :only [renderer name-to-path ->files slurp-resource]])
  (:import [java.io File]))

(defn baldwin
  "Creates a Baldwin web application"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}
        render #((renderer "baldwin") % data)]
    (println (str "Generating Baldwin project: " (data :sanitized)))
    (->files data
             ["project.clj"                            (render "project.clj")]
             ["src/bootstrap.clj"                      (render "bootstrap.clj")]
             ["src/app/controllers/application.clj"    (render "app/controllers/application.clj")]
             ["src/app/controllers/home.clj"           (render "app/controllers/home.clj")]
             ["src/config/routes.clj"                  (render "config/routes.clj")]
             ["resources/public/images/baldwin299.jpg" (File. "src/leiningen/new/baldwin/public/images/baldwin299.jpg")]
             "resources/public/javascripts"
             "resources/public/stylesheets"
             ))
    (println "Done\n"))
