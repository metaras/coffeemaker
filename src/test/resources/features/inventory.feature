Feature: Inventory feature

  Background: Initialize CoffeeMaker
    Given default inventory that contain 15 unit of each ingredient

  Scenario: Add coffee into the inventory
    When add amount of coffee
    Then the amount of coffee in the inventory increasing

  Scenario: Add sugar into the inventory
    When add amount of sugar
    Then the amount of coffee in the inventory increasing

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
    Given default inventory and recipe that use coffee 2 unit, milk 1 unit and sugar 1 unit
    When use the given recipe
    Then the amount of each ingredients is decrease

  Scenario:
    Given empty inventory and recipe in the recipe book
    When try to use the ingredients
    Then cannot use the ingredients