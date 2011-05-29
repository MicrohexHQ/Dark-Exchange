(ns test.darkexchange.model.actions.get-open-offers
  (:require [test.fixtures.offer :as offer-fixture]
            [darkexchange.model.actions.action-keys :as action-keys] 
            [darkexchange.model.peer :as peer-model]
            [test.darkexchange.util :as test-util]) 
  (:use clojure.test
        darkexchange.model.actions.get-open-offers))

(use-fixtures :once offer-fixture/fixture)

(deftest test-action
  (try
    (test-util/login) 
    (let [response-map (action {})
          open-offers (:data response-map)]
      (is open-offers "There are no offers in the system.")
      (is (= 1 (count open-offers)) "Expected only one offer in the system.")
      (is (= (first offer-fixture/records) (first open-offers)) "Unexpected offer returned."))
    (finally
      (test-util/logout))))

(deftest test-action-key
  (is (= action-key action-keys/get-open-offers-action-key)))