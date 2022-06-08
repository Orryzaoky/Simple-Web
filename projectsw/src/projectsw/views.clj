(ns projectsw.views
  (:require [hiccup.page :refer :all]
            [hiccup.form :as form]
            [ring.util.anti-forgery :refer (anti-forgery-field)]))

(defn page [& body]
  (html5
    [:head 
     [:title "Simple Web with Clojure"]]
     (include-css "resource/public/style.css")
   [:body
     (form/form-to
       [:post "/"]
       [:br]
       (form/label "note" "Input Text Here")
       [:br]
       (form/text-field "note")
       (anti-forgery-field)
       (form/submit-button "Enter"))
     [:hr]
     body]))

(defn index [notes]
  (page
    (for [note @notes]
      [:p note])))