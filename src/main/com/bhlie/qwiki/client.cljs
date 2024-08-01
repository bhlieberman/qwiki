(ns com.bhlie.qwiki.client
  #_{:clj-kondo/ignore [:unused-namespace]}
  (:require [com.bhlie.qwiki.ui.core :as ui]
            [com.bhlie.qwiki.ui.antd :as ant]
            [com.fulcrologic.fulcro.application :as app]
            [com.fulcrologic.fulcro.components :as comp]
            [com.fulcrologic.fulcro.networking.http-remote :as http]
            [com.fulcrologic.fulcro.data-fetch :as df]
            [com.fulcrologic.fulcro.dom :as dom]
            [com.fulcrologic.fulcro.react.version18 :refer [with-react18]]
            [com.fulcrologic.fulcro.react.error-boundaries :refer [*render-error*]]
            [taoensso.timbre :refer [info]]))

(defonce app (with-react18 (app/fulcro-app {:remotes {:remote (http/fulcro-http-remote {})}})))

(defn ^:export init []
  (set! *render-error* (fn [this cause]
                         (ant/ant-alert {:type "error"
                                         :message "Something went wrong"
                                         :description "This form is broken. Sorry."})))
  (app/mount! app ui/Root "app")
  (info "Loaded"))

(defn ^:export refresh []
  (app/mount! app ui/Root "app")
  (comp/refresh-dynamic-queries! app)
  (info "Hot reload"))