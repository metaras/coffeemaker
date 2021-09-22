package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class CoffeeMakerStepdefs {

    private CoffeeMaker coffeeMaker;
    private Inventory inventory;
    private Inventory emptyInventory;
    private RecipeBook recipeBook;
    private Recipe[] recipes;
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe clearRecipe;

    private int moneyInPocket;
    private int beveragePrice;

    public Recipe createRecipe(String name, int coffee, int chocolate, int milk, int sugar, int price) throws RecipeException {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setAmtCoffee(Integer.toString(coffee));
        recipe.setAmtChocolate(Integer.toString(chocolate));
        recipe.setAmtMilk(Integer.toString(milk));
        recipe.setAmtSugar(Integer.toString(sugar));
        recipe.setPrice(Integer.toString(price));
        return recipe;
    }

    @Given("default inventory that contain {int} unit of each ingredient")
    public void defaultInventoryThatContainUnitOfEachIngredient(int arg0) {
        coffeeMaker = new CoffeeMaker();
    }

    @And("{int} in my pocket")
    public void inMyPocket(int money) {
        moneyInPocket = money;
    }

    @And("{int} recipe in the recipe book")
    public void recipeInTheRecipeBook() throws RecipeException {
        //Set up for recipe1
        recipe1 = createRecipe("Coffee", 2, 3, 1, 1, 50);

        //Set up for recipe2
        recipe2 = createRecipe("Mocha", 20, 3, 1, 1, 75);

        //Set up for recipe3
        recipe3 = createRecipe("Latte", 0, 3, 3, 1, 100);

        // Set up for clear inventory recipe
        clearRecipe = createRecipe("Clear", 15, 15, 15, 15, 0);

        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(clearRecipe);
    }

    @Given("the empty inventory")
    public void theEmptyInventory() {
        emptyInventory = new Inventory();
        emptyInventory.setCoffee(0);
        emptyInventory.setSugar(0);
        emptyInventory.setMilk(0);
        emptyInventory.setChocolate(0);
    }

    @When("purchase {int} for the beverage from recipe in the recipe book")
    public void purchaseForTheBeverageFromRecipeInTheRecipeBook(int price) {
        assertEquals(moneyInPocket, price);
        beveragePrice = price;
    }

    @Then("get the beverage with out return")
    public void getTheBeverageWitheOutReturn(int change) {
        assertEquals(0, change);
    }

    @When("purchase {int} for the beverage from the recipe in the recipe book")
    public void purchaseForTheBeverageFromTheRecipeInTheRecipeBook(int price) {
        assertTrue(moneyInPocket >= price);
        beveragePrice = price;
    }

    @Then("get the beverage and return")
    public void getTheBeverageAndReturn(int change) {
        assertEquals(moneyInPocket-beveragePrice, change);
    }

    @When("purchase {int} the beverage from recipe in the recipe book")
    public void purchaseTheBeverageFromRecipeInTheRecipeBook(int price) {
        beveragePrice = price;
    }

    @Then("cannot purchase the beverage with return {int}")
    public void cannotPurchaseTheBeverageWithReturn(int change) {
        assertEquals(beveragePrice, change);
    }


    @When("purchase beverage")
    public void purchaseBeverage() {
        coffeeMaker.makeCoffee(2, 100);
    }

    @Then("cannot purchase the beverage")
    public void cannotPurchaseTheBeverage() {
        assertEquals(moneyInPocket, coffeeMaker.makeCoffee(0, moneyInPocket));
    }

    @Given("default inventory")
    public void defaultInventory() {
        inventory = new Inventory();
    }


    @When("add amount of coffee")
    public void addAmountOfCoffee() throws InventoryException {
        inventory.addCoffee("1");
    }

    @Then("the amount of coffee in the inventory increasing")
    public void theAmountOfCoffeeInTheInventoryIncreasing() {
        assertEquals(16, inventory.getCoffee());
    }

    @When("add amount of sugar")
    public void addAmountOfSugar() throws InventoryException {
        inventory.addSugar("1");
    }

    @Then("the amount of sugar in the inventory increasing")
    public void theAmountOfSugarInTheInventoryIncreasing() {
        assertEquals(16, inventory.getSugar());
    }

    @When("add amount of milk")
    public void addAmountOfMilk() throws InventoryException {
        inventory.addMilk("1");
    }

    @Then("the amount of milk in the inventory increasing")
    public void theAmountOfMilkInTheInventoryIncreasing() {
        assertEquals(16, inventory.getMilk());
    }

    @When("add amount of chocolate")
    public void addAmountOfChocolate() throws InventoryException {
        inventory.addChocolate("1");
    }

    @Then("the amount of chocolate in the inventory increasing")
    public void theAmountOfChocolateInTheInventoryIncreasing() {
        assertEquals(16, inventory.getChocolate());
    }

    @When("add negative amount of sugar")
    public void addNegativeAmountOfSugar() throws InventoryException {
        inventory.addSugar("-1");
    }

    @Then("the amount of sugar in the inventory will not increasing")
    public void theAmountOfSugarInTheInventoryWillNotIncreasing() {
        assertEquals(15, inventory.getSugar());
    }

    @When("add negative amount of milk")
    public void addNegativeAmountOfMilk() throws InventoryException {
        inventory.addMilk("-1");
    }

    @Then("the amount of milk in the inventory will not increasing")
    public void theAmountOfMilkInTheInventoryWillNotIncreasing() {
        assertEquals(15, inventory.getMilk());
    }

    @When("add negative amount of coffee")
    public void addNegativeAmountOfCoffee() throws InventoryException {
        inventory.addCoffee("-1");
    }

    @Then("the amount of coffee in the inventory will not increasing")
    public void theAmountOfCoffeeInTheInventoryWillNotIncreasing() {
        assertEquals(15, inventory.getCoffee());
    }

    @When("add negative amount of chocolate")
    public void addNegativeAmountOfChocolate() throws InventoryException {
        inventory.addChocolate("-1");
    }

    @Then("the amount of chocolate in the inventory will not increasing")
    public void theAmountOfChocolateInTheInventoryWillNotIncreasing() {
        assertEquals(15, inventory.getChocolate());
    }

    @When("use the given recipe")
    public void useTheGivenRecipe() {
        assertTrue(inventory.useIngredients(recipe1));
    }

    @Then("the amount of each ingredients is decrease")
    public void theAmountOfEachIngredientsIsDecrease() {
        assertEquals(13, inventory.getCoffee());
        assertEquals(12, inventory.getChocolate());
        assertEquals(14, inventory.getSugar());
        assertEquals(14, inventory.getMilk());
    }

    @Then("cannot use the ingredients")
    public void cannotUseTheIngredients() {
        assertFalse(emptyInventory.useIngredients(recipe2));
    }

    @Given("empty recipe book and default inventory")
    public void emptyRecipeBookAndDefaultInventory() {
        recipeBook = new RecipeBook();
    }

    @And("the recipe in the recipe book")
    public void theRecipeInTheRecipeBook() {
        recipeBook.addRecipe(recipe1);
    }

    @When("add the recipe above to the recipe book")
    public void addTheRecipeAboveToTheRecipeBook() {
        recipes = new Recipe[]{recipe1, null, null, null};
        recipeBook.addRecipe(recipe1);
    }

    @Then("the recipe is ready to use in the recipe book")
    public void theRecipeIsReadyToUseInTheRecipeBook() {
        assertArrayEquals(recipes, recipeBook.getRecipes());
    }

    @When("edit the first recipe in the recipe book")
    public void editTheFirstRecipeInTheRecipeBook() {
        recipeBook.editRecipe(0, recipe3);
    }

    @Then("the first recipe in the recipe book will change")
    public void theFirstRecipeInTheRecipeBookWillChange() {
        assertEquals(recipe3, recipeBook.getRecipes()[0]);
    }


    @When("delete the first recipe")
    public void deleteTheFirstRecipe() {
        recipeBook.deleteRecipe(0);
    }

    @Then("the recipe book is empty")
    public void theRecipeBookIsEmpty() {
        Recipe[] emptyRecipe = {null, null, null, null};
        assertArrayEquals(emptyRecipe, recipeBook.getRecipes());
    }
}
