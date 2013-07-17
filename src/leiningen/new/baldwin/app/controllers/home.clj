(ns app.controllers.home
  [:require [app.controllers.application :as application]])

(defn index []
  "<img src='/images/baldwin299.jpg' height='350'><h3>Baldwin Web Framework</h3><p>Hello world!</p><p>It's so fucking awesome that I think I won't sleep.</p>")

(defn about []
  "About")