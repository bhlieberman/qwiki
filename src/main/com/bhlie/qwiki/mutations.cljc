(ns com.bhlie.qwiki.mutations
  (:require #?(:clj [com.wsscode.pathom.connect :as pc])
            [com.fulcrologic.fulcro.mutations :as m :refer [defmutation]]
            [taoensso.timbre :as log]))