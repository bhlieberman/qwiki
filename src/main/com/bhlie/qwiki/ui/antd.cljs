(ns com.bhlie.qwiki.ui.antd
  {:doc "Fulcro wrappers and other conveniences for Ant Design Components."}
  (:require ["antd" :refer [Alert]]
            [com.fulcrologic.fulcro.algorithms.react-interop :as interop]))

(def ant-alert (interop/react-factory Alert))