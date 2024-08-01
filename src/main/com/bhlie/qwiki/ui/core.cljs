(ns com.bhlie.qwiki.ui.core
  (:require [com.fulcrologic.fulcro.components :as comp :refer [defsc]]
            [com.fulcrologic.fulcro.dom :as dom]))

(defsc Root [this props]
  {}
  (dom/div "Up on the root"))