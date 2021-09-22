Feature: Using the coffee maker

  Background: Initialize CoffeeMaker
    Given default inventory that contain 15 unit of each ingredient
    And 100 in my pocket
    And 3 recipe in the recipe book

  Scenario: Purchase beverage
    When purchase 100 for the beverage from recipe in the recipe book
    Then get the beverage with out return

  Scenario: Purchase beverage with change
    When purchase 70 for the beverage from the recipe in the recipe book
    Then get the beverage and return

  Scenario: purchase the beverage with the empty inventory
    Given the empty inventory
    When purchase 100 the beverage from recipe in the recipe book
    Then cannot purchase the beverage with return 100

  Scenario: purchase the beverage when ingredients is not enough
    Given the empty inventory
    When purchase beverage
    Then cannot purchase the beverage
