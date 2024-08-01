(ns user
  (:require [clojure.tools.namespace.repl :refer [refresh set-refresh-dirs]]
            [com.bhlie.qwiki.server :as server]))

(set-refresh-dirs "src/dev" "src/main")

(defn start []
  (server/start))

(defn restart
  "Stop the server, reload all source code, then restart the server.

  See documentation of tools.namespace.repl for more information."
  []
  (server/stop)
  (refresh :after 'user/start))

(comment
  (start)
  (restart))