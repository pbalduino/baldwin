(ns bootstrap
  (:require [compojure.core :refer [defroutes]]            
            [config.routes :refer  [app-routes]]
            [noir.util.middleware :as middleware]
            [compojure.route :as route]
            [taoensso.timbre :as timbre]
            [com.postspectacular.rotor :as rotor]))

(defn init
  "init will be called once when
   app is deployed as a servlet on
   an app server such as Tomcat
   put any initialization code here"
  []
  (timbre/set-config!
    [:appenders :rotor]
    {:min-level :info
     :enabled? true
     :async? false ; should be always false for rotor
     :max-message-per-msecs nil
     :fn rotor/append})
  
  (timbre/set-config!
    [:shared-appender-config :rotor]
    {:path "logs/{{sanitized}}.log" :max-size (* 512 1024) :backlog 10})
  
  (timbre/info "{{sanitized}} started successfully"))

(defn destroy
  "destroy will be called when your application
   shuts down, put any clean up code here"
  []
  (timbre/info "{{sanitized}} is shutting down..."))

(def app (middleware/app-handler
           ;;add your application routes here
           [app-routes app-routes]
           ;;add custom middleware here           
           :middleware []
           ;;add access rules here
           ;;each rule should be a vector
           :access-rules []))

(def war-handler (middleware/war-handler app))