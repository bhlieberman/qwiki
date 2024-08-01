(ns com.bhlie.qwiki.config.db
  (:require [next.jdbc :as jdbc]
            [honey.sql :as hsql]
            [donut.system :as ds]))

(def dbspec {:dbtype "duckdb"})

(defn get-duckdb-conn [dbspec]
  (jdbc/get-datasource dbspec))

;; TODO: add a signal handler to close the DB connection
(def Database #::ds{:start (fn [{:keys [ds/config]}]
                             (get-duckdb-conn (:dbspec config)))
                    :stop nil
                    :config dbspec})