(ns config.routes
  (:use compojure.core)
  (:require [app.controllers.home :as home]))

(defroutes app-routes
  (GET "/"      [] (home/index))
  (GET "/about" [] (home/about)))
