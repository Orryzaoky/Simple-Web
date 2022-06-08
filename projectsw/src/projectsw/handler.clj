(ns projectsw.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as response]
            [projectsw.views :as view]
            [projectsw.file :as file]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (view/index file/txt))
  (POST "/" [note] 
      (do (file/add note)
          (response/redirect "/")))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
