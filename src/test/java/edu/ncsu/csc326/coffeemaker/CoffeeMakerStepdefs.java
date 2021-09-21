package edu.ncsu.csc326.coffeemaker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CoffeeMakerStepdefs {
    @Given("default inventory that contain {int} unit of each ingredient")
    public void defaultInventoryThatContainUnitOfEachIngredient(int arg0) {
    }

    @And("{int} in my pocket")
    public void inMyPocket(int arg0) {
    }

    @And("{int} recipe in the recipe book")
    public void recipeInTheRecipeBook(int arg0) {
    }

    @When("purchase {int} for the beverage from recipe in the recipe book")
    public void purchaseForTheBeverageFromRecipeInTheRecipeBook(int arg0) {
    }

    @Then("get the beverage withe out return")
    public void getTheBeverageWitheOutReturn() {
    }

    @When("purchase {int} for the beverage from the recipe in the recipe book")
    public void purchaseForTheBeverageFromTheRecipeInTheRecipeBook(int arg0) {
    }

    @Then("get the beverage and return")
    public void getTheBeverageAndReturn() {
    }

    @Given("the empty inventory")
    public void theEmptyInventory() {
    }

    @When("purchase {int} the beverage from recipe in the recipe book")
    public void purchaseTheBeverageFromRecipeInTheRecipeBook(int arg0) {
    }

    @Then("cannot purchase the beverage with return {int}")
    public void cannotPurchaseTheBeverageWithReturn(int arg0) {
    }

    @Then("cannot purchase the beverage")
    public void cannotPurchaseTheBeverage() {
    }

    @When("sugar in the inventory is {int}")
    public void sugarInTheInventoryIs(int arg0) {
    }

    @When("milk in the inventory is {int}")
    public void milkInTheInventoryIs(int arg0) {
    }

    @When("coffee in the inventory is {int}")
    public void coffeeInTheInventoryIs(int arg0) {
    }

    @When("chocolate in the inventory is {int}")
    public void chocolateInTheInventoryIs(int arg0) {
    }

    @Given("empty recipe book and default inventory")
    public void emptyRecipeBookAndDefaultInventory() {
    }

    @Given("the component of this recipe is {int} unit of coffee {int} unit of milk and {int} unit of sugar")
    public void theComponentOfThisRecipeIsUnitOfCoffeeUnitOfMilkAndUnitOfSugar(int arg0, int arg1, int arg2) {
    }

    @When("add the recipe above to the recipe book")
    public void addTheRecipeAboveToTheRecipeBook() {
    }

    @Then("the recipe is ready to use in the recipe book")
    public void theRecipeIsReadyToUseInTheRecipeBook() {
    }

    @Given("the recipe in the recipe book")
    public void theRecipeInTheRecipeBook() {
    }

    @When("edit the first recipe in the recipe book change from the {int} unit of coffee to {int} unit of the coffee")
    public void editTheFirstRecipeInTheRecipeBookChangeFromTheUnitOfCoffeeToUnitOfTheCoffee(int arg0, int arg1) {
    }

    @Then("the first recipe in the recipe book is {int} unit of coffee {int} unit of milk and {int} unit of sugar")
    public void theFirstRecipeInTheRecipeBookIsUnitOfCoffeeUnitOfMilkAndUnitOfSugar(int arg0, int arg1, int arg2) {
    }

    @Given("the recipe book that already have one recipe in the recipe book")
    public void theRecipeBookThatAlreadyHaveOneRecipeInTheRecipeBook() {
    }

    @When("delete the first recipe")
    public void deleteTheFirstRecipe() {
    }

    @Then("the recipe book is empty")
    public void theRecipeBookIsEmpty() {
    }

    @When("add amount of coffee")
    public void addAmountOfCoffee() {
    }

    @Then("the amount of coffee in the inventory increasing")
    public void theAmountOfCoffeeInTheInventoryIncreasing() {
    }

    @When("add amount of sugar")
    public void addAmountOfSugar() {
    }

    @When("add amount of milk")
    public void addAmountOfMilk() {
    }

    @Then("the amount of milk in the inventory increasing")
    public void theAmountOfMilkInTheInventoryIncreasing() {
    }

    @When("add amount of chocolate")
    public void addAmountOfChocolate() {
    }

    @Then("the amount of chocolate in the inventory increasing")
    public void theAmountOfChocolateInTheInventoryIncreasing() {
    }

    @When("add negative amount of sugar")
    public void addNegativeAmountOfSugar() {
    }

    @Then("the amount of sugar in the inventory will not increasing")
    public void theAmountOfSugarInTheInventoryWillNotIncreasing() {
    }

    @When("add negative amount of milk")
    public void addNegativeAmountOfMilk() {
    }

    @Then("the amount of milk in the inventory will not increasing")
    public void theAmountOfMilkInTheInventoryWillNotIncreasing() {
    }

    @When("add negative amount of coffee")
    public void addNegativeAmountOfCoffee() {
    }

    @Then("the amount of coffee in the inventory will not increasing")
    public void theAmountOfCoffeeInTheInventoryWillNotIncreasing() {
    }

    @When("add negative amount of chocolate")
    public void addNegativeAmountOfChocolate() {
    }

    @Then("the amount of chocolate in the inventory will not increasing")
    public void theAmountOfChocolateInTheInventoryWillNotIncreasing() {
    }

    @Given("default inventory and recipe that use coffee {int} unit, milk {int} unit and sugar {int} unit")
    public void defaultInventoryAndRecipeThatUseCoffeeUnitMilkUnitAndSugarUnit(int arg0, int arg1, int arg2) {
    }

    @When("use the given recipe")
    public void useTheGivenRecipe() {
    }

    @Then("the amount of each ingredients is decrease")
    public void theAmountOfEachIngredientsIsDecrease() {
    }

    @Given("empty inventory and recipe in the recipe book")
    public void emptyInventoryAndRecipeInTheRecipeBook() {
    }

    @When("try to use the ingredients")
    public void tryToUseTheIngredients() {
    }

    @Then("cannot use the ingredients")
    public void cannotUseTheIngredients() {
    }
}
