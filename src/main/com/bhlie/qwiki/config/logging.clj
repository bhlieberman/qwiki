(ns com.bhlie.qwiki.config.logging
  (:require [com.fulcrologic.fulcro.server.config :refer [load-config!]]
            [taoensso.timbre :as log]
            [donut.system :as ds]))

(defn configure-logging! [config]
  (let [{:keys [taoensso.timbre/logging-config]} config]
    (log/info "Configuring Timbre with " logging-config)
    (log/merge-config! logging-config)))

(def Logger #::ds{:start (fn [{:keys [ds/config]}]
                           (let [configuration (load-config! {:config-path config})]
                             (configure-logging! configuration)))
                  :stop nil})