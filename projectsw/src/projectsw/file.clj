(ns projectsw.file)

(def txt (atom []))

(defn add [note]
  (when (not (empty? note)) 
    (swap! txt conj note)))