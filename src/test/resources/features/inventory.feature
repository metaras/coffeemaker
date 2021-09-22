Feature: Inventory feature

  Background: Initialize CoffeeMaker
    Given default inventory

  Scenario: Add coffee into the inventory
    When add amount of coffee
    Then the amount of coffee in the inventory increasing

  Scenario: Add sugar into the inventory
    When add amount of sugar
    Then the amount of sugar in the inventory increasing

  Scenario: Add milk into the inventory
    When add amount of milk
    Then the amount of milk in the inventory increasing

  Scenario: Add chocolate into the inventory
    When add amount of chocolate
    Then the amount of chocolate in the inventory increasing

  Scenario: Add negative amount of sugar into the inventory
    When add negative amount of sugar
    Then the amount of sugar in the inventory will not increasing

  Scenario: Add negative amount of milk into the inventory
    When add negative amount of milk
    Then the amount of milk in the inventory will not increasing

  Scenario: Add negative amount of coffee into the inventory
    When add negative amount of coffee
    Then the amount of coffee in the inventory will not increasing

  Scenario: Add negative amount of chocolate into the inventory
    When add negative amount of chocolate
    Then the amount of chocolate in the inventory will not increasing

  Scenario: Using the ingredients
    When use the given recipe
    Then the amount of each ingredients is decrease

  Scenario:
    Given the empty inventory
    Then cannot use the ingredients