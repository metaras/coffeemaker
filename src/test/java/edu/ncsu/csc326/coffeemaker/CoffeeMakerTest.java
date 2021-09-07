/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 * 
 * Permission has been explicitly granted to the University of Minnesota 
 * Software Engineering Center to use and distribute this source for 
 * educational purposes, including delivering online education through
 * Coursera or other entities.  
 * 
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including 
 * fitness for purpose.
 * 
 * 
 * Modifications 
 * 20171114 - Ian De Silva - Updated to comply with JUnit 4 and to adhere to 
 * 							 coding standards.  Added test documentation.
 */
package edu.ncsu.csc326.coffeemaker;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import static org.junit.Assert.*;

/**
 * Unit tests for CoffeeMaker class.
 * 
 * @author Sarah Heckman
 */
public class CoffeeMakerTest {
	
	/**
	 * The object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	// Sample recipes to use in testing.
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;

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

	/**
	 * Initializes some recipes to test with and the {@link CoffeeMaker} 
	 * object we wish to test.
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {
		coffeeMaker = new CoffeeMaker();
		
		//Set up for recipe1
		recipe1 = createRecipe("Coffee", 0, 3, 1, 1, 50);
		
		//Set up for recipe2
		recipe2 = createRecipe("Mocha", 20, 3, 1, 1, 75);
		
		//Set up for recipe3
		recipe3 = createRecipe("Latte", 0, 3, 3, 1, 100);
		
		//Set up for recipe4
		recipe4 = createRecipe("Hot Chocolate", 4, 0, 1, 1, 65);
	}
	
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then we do not get an exception trying to read the inventory quantities.
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 *
	 * @testcase T1
	 */
	@Test
	public void testAddInventory() throws InventoryException {
		coffeeMaker.addInventory("4","7","1","9");
	}
	/**
	 * Given a coffee maker with the default inventory
	 * When we add coffee with malformed quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 *
	 * @testcase T2
	 */
	@Test(expected = InventoryException.class)
	public void testAddNegativeToCoffeeInventory() throws InventoryException {
		coffeeMaker.addInventory("-1", "0", "0", "0");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add milk with malformed quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 *
	 * @testcase T3
	 */
	@Test(expected = InventoryException.class)
	public void testAddNegativeToMilkInventory() throws InventoryException {
		coffeeMaker.addInventory("0", "-1", "0", "0");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add sugar with malformed quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 *
	 * @testcase T4
	 */
	@Test(expected = InventoryException.class)
	public void testAddNegativeToSugarInventory() throws InventoryException {
		coffeeMaker.addInventory("0", "0", "-1", "0");
	}
	/**
	 * Given a coffee maker with the default inventory
	 * When we add Chocolate with malformed quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 *
	 * @testcase T5
	 */
	@Test(expected = InventoryException.class)
	public void testAddNegativeToChocolateInventory() throws InventoryException {
		coffeeMaker.addInventory("0", "0", "0", "-1");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add coffee with malformed quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 *
	 * @testcase T6
	 */
	@Test(expected = InventoryException.class)
	public void testAddStringToCoffeeInventory() throws InventoryException {
		coffeeMaker.addInventory("a", "0", "0", "0");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add milk with malformed quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 *
	 * @testcase T7
	 */
	@Test(expected = InventoryException.class)
	public void testAddStringToMilkInventory() throws InventoryException {
		coffeeMaker.addInventory("0", "a", "0", "0");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add sugar with malformed quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 *
	 * @testcase T8
	 */
	@Test(expected = InventoryException.class)
	public void testAddStringToSugarInventory() throws InventoryException {
		coffeeMaker.addInventory("0", "0", "a", "0");
	}
	/**
	 * Given a coffee maker with the default inventory
	 * When we add chocolate with malformed quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 *
	 * @testcase T9
	 */
	@Test(expected = InventoryException.class)
	public void testAddStringToChocolateInventory() throws InventoryException {
		coffeeMaker.addInventory("0", "0", "0", "a");
	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than 
	 * 		the coffee costs
	 * Then we get the correct change back.
	 *
	 * @testcast T10
	 */
	@Test
	public void testMakeCoffee() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(25, coffeeMaker.makeCoffee(0, 75));
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When check the ingredients in the inventory
	 * Then the inventory quantities must set as default.
	 * @testcase T11
	 */
	@Test
	public void testCheckInventory() {
		String expectedBegin = "Coffee: 15\n" + "Milk: 15\n" + "Sugar: 15\n" + "Chocolate: 15\n";
		assertEquals(expectedBegin, coffeeMaker.checkInventory());
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add recipe with the same name with the one that in the list
	 * Then ignore it.
	 *
	 * @throws RecipeException if there are same name in the recipe list
	 * @testcase T12
	 */
	@Test
	public void testSameRecipeName() throws RecipeException{
		Recipe recipe5 = createRecipe("Coffee", 0, 3, 1, 1, 50);
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe5);
		Recipe[] forTest = {recipe1, null, null};
		assertArrayEquals(forTest, coffeeMaker.getRecipes());
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When the recipe already full
	 * Then cannot add any more recipe.
	 *
	 * @testcase T13
	 */
	@Test
	public void testLimitRecipeList() throws RecipeException{
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);

		Recipe recipe6 = createRecipe("for test", 0, 3, 1, 1, 50);

		Recipe[] limit = {recipe1, recipe2, recipe3};

		coffeeMaker.addRecipe(recipe6);

		assertArrayEquals(limit, coffeeMaker.getRecipes());
	}

	/**
	 * Given nothing
	 * When the recipe has set in double
	 * Then cannot set that value to the recipe.
	 *
	 * @throws RecipeException if any value was not integer
	 *
	 * @testcase T14
	 */
	@Test(expected = RecipeException.class)
	public void testAmountAndPriceNotInInteger() throws RecipeException {
		Recipe testRecipe = new Recipe();
		testRecipe.setName("for test");
		testRecipe.setAmtChocolate("1.40");
		testRecipe.setAmtCoffee("3.00");
		testRecipe.setAmtMilk("1.5");
		testRecipe.setAmtSugar("1.0");
		testRecipe.setPrice("50.0");
	}

	/**
	 * Given nothing
	 * When the recipe has set in negative integer
	 * Then cannot set that value to the recipe.
	 *
	 * @throws RecipeException if any value was not positive integer
	 *
	 * @testcase T15
	 */
	@Test(expected = RecipeException.class)
	public void testAmountAndPriceInNegativeInteger() throws RecipeException{
		Recipe forTest = createRecipe("for test", -1, -3, -1, -1, -50);
	}

	/**
	 * Given nothing
	 * When the recipe has set in malformed
	 * Then cannot set that value to the recipe.
	 *
	 * @throws RecipeException if any value was not positive integer
	 *
	 * @testcase T16
	 */
	@Test(expected = RecipeException.class)
	public void testAmountAndPriceMalformed() throws RecipeException{
		Recipe forTest = new Recipe();
		forTest.setName("for test");
		forTest.setAmtChocolate("ab");
		forTest.setAmtCoffee("-3");
		forTest.setAmtMilk("a");
		forTest.setAmtSugar("-1");
		forTest.setPrice("-50");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When the recipe in the recipe list and try to add the recipe
	 * Then recipe deleted.
	 *
	 * @testcase T17
	 */
	@Test
	public void testAddRecipe() {
		Recipe[] recipes = {recipe1, null, null};
		coffeeMaker.addRecipe(recipe1);
		assertArrayEquals(recipes, coffeeMaker.getRecipes());
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When the recipe in the recipe list and try to delete the recipe
	 * Then recipe deleted.
	 *
	 * @testcase T18
	 */
	@Test
	public void testDeleteRecipeFromList() {
		coffeeMaker.addRecipe(recipe1);

		assertEquals(recipe1, coffeeMaker.getRecipes()[0]);

		coffeeMaker.deleteRecipe(0);

		assertEquals(null, coffeeMaker.getRecipes()[0]);
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When the recipe in the recipe list and try to delete the recipe
	 * Then nothing happen.
	 *
	 * @testcase T19
	 */
	@Test
	public void testDeleteRecipeOutOfList() {
		Recipe[] emptyList = {null, null, null};

		assertArrayEquals(emptyList, coffeeMaker.getRecipes());

		coffeeMaker.deleteRecipe(1);

		assertArrayEquals(emptyList, coffeeMaker.getRecipes());
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When the recipe in the recipe list and try to edit the recipe
	 * Then recipe edited.
	 *
	 * @testcase T20
	 */
	@Test
	public void testEditRecipe() throws RecipeException {
		coffeeMaker.addRecipe(recipe1);

		Recipe editRecipe = createRecipe("Coffee", 3, 2, 3, 0, 100);

		coffeeMaker.editRecipe(1, editRecipe);

		Recipe editedRecipe = coffeeMaker.getRecipes()[0];

		assertEquals("Coffee", editedRecipe.getName());
		assertEquals(3, editedRecipe.getAmtChocolate());
		assertEquals(2, editedRecipe.getAmtCoffee());
		assertEquals(3, editedRecipe.getAmtMilk());
		assertEquals(0, editedRecipe.getAmtSugar());
		assertEquals(100, editedRecipe.getPrice());
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When the recipe book is empty and try to edit the recipe
	 * Then nothing happen.
	 *
	 * @throws NullPointerException if there are nothing in the recipe biik.
	 *
	 * @testcase T21
	 */
	@Test(expected = NullPointerException.class)
	public void testEditRecipeOutOfList() throws RecipeException {
		Recipe editRecipe = createRecipe("Coffee", 3, 2, 3, 0, 100);

		coffeeMaker.editRecipe(1, editRecipe);

		Recipe editedRecipe = coffeeMaker.getRecipes()[0];

		assertEquals("Coffee", editedRecipe.getName());
		assertEquals(3, editedRecipe.getAmtChocolate());
		assertEquals(2, editedRecipe.getAmtCoffee());
		assertEquals(3, editedRecipe.getAmtMilk());
		assertEquals(0, editedRecipe.getAmtSugar());
		assertEquals(100, editedRecipe.getPrice());
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then the ingredients in the inventory must be increase
	 *
	 * @testcase T22
	 */
	@Test
	public void testAddInventoryResult() throws InventoryException {
		coffeeMaker.addInventory("4","7","3","9");

		String expected = "Coffee: 19\n" +
				"Milk: 22\n" +
				"Sugar: 18\n" +
				"Chocolate: 24\n";
		assertEquals(expected, coffeeMaker.checkInventory());
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then the ingredients in the inventory must be increase
	 *
	 * @testcase T23
	 */
	@Test (expected = InventoryException.class)
	public void testAddNegativeInventory() throws InventoryException {
		coffeeMaker.addInventory("-4","-7","-3","-9");
	}

	/**
	 * When check the default inventory.
	 * Then any exception should not be raises
	 *
	 * @testcase T24
	 */
	@Test
	public void testDefaultInventory() throws InventoryException {
		Inventory inventory = new Inventory();
		assertEquals(15, inventory.getCoffee());
		assertEquals(15, inventory.getChocolate());
		assertEquals(15, inventory.getMilk());
		assertEquals(15, inventory.getSugar());
	}

	/**
	 * Given nothing
	 * When inventory is empty
	 * Then cannot use the ingredients.
	 *
	 * @testcase T25
	 */
	@Test
	public void testInventoryEmpty() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.setCoffee(0);
		inventory.setChocolate(0);
		inventory.setMilk(0);
		inventory.setSugar(0);
		assertFalse(inventory.useIngredients(recipe1));
	}

	/**
	 * Given nothing
	 * When inventory has not enough ingredients
	 * Then cannot use the ingredients.
	 *
	 * @testcase T26
	 */
	@Test
	public void testNotEnoughIngredient() throws RecipeException {
		Recipe recipe = createRecipe("test", 3, 3, 3, 3, 30);
		Inventory inventory = new Inventory();
		inventory.setCoffee(2);
		inventory.setChocolate(1);
		inventory.setMilk(1);
		inventory.setSugar(1);
		assertFalse(inventory.useIngredients(recipe));
	}

	/**
	 * Given nothing
	 * When inventory is ready to use
	 * Then the ingredients must decrease.
	 *
	 * @testcase T27
	 */
	@Test
	public void testUseIngredients() {
		Inventory inventory = new Inventory();
		inventory.setCoffee(15);
		inventory.setChocolate(15);
		inventory.setMilk(15);
		inventory.setSugar(15);

		assertEquals(15, inventory.getCoffee());
		assertEquals(15, inventory.getChocolate());
		assertEquals(15, inventory.getMilk());
		assertEquals(15, inventory.getSugar());

		inventory.useIngredients(recipe1);

		assertEquals(12, inventory.getCoffee());
		assertEquals(15, inventory.getChocolate());
		assertEquals(14, inventory.getMilk());
		assertEquals(14, inventory.getSugar());
	}

	/**
	 * Given nothing
	 * When add the ingredients to the inventory
	 * Then the ingredients in inventory must increases and any exception should not be raised.
	 *
	 * @testcase T28
	 */
	@Test
	public void testAmountInventory() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addCoffee("2");
		inventory.addChocolate("2");
		inventory.addMilk("2");
		inventory.addSugar("2");

		assertEquals(17, inventory.getCoffee());
		assertEquals(17, inventory.getChocolate());
		assertEquals(17, inventory.getMilk());
		assertEquals(17, inventory.getSugar());
	}

	/**
	 * Given nothing
	 * When add string to the inventory
	 * Then the ingredients in inventory must increases and any exception should not be raised.
	 *
	 * @testcase T29
	 */
	@Test(expected = InventoryException.class)
	public void testAddStringCoffee() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addCoffee("coffee");
	}

	/**
	 * Given nothing
	 * When add string to the inventory
	 * Then the ingredients in inventory must increases and any exception should not be raised.
	 *
	 * @testcase T30
	 */
	@Test(expected = InventoryException.class)
	public void testAddStringSugar() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addSugar("sugar");
	}

	/**
	 * Given nothing
	 * When add string to the inventory
	 * Then the ingredients in inventory must increases and any exception should not be raised.
	 *
	 * @testcase T31
	 */
	@Test(expected = InventoryException.class)
	public void testAddStringMilk() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addMilk("milk");
	}

	/**
	 * Given nothing
	 * When add string to the inventory
	 * Then the ingredients in inventory must increases and any exception should not be raised.
	 *
	 * @testcase T32
	 */
	@Test(expected = InventoryException.class)
	public void testAddStringChocolate() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addChocolate("chocolate");
	}

	/**
	 * Given nothing
	 * When add negative value to the inventory
	 * Then the ingredients in inventory must increases and any exception should not be raised.
	 *
	 * @testcase T33
	 */
	@Test(expected = InventoryException.class)
	public void testAddNegativeCoffee() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addCoffee("-1");
	}

	/**
	 * Given nothing
	 * When add string to the inventory
	 * Then the ingredients in inventory must increases and any exception should not be raised.
	 *
	 * @testcase T34
	 */
	@Test(expected = InventoryException.class)
	public void testAddNegativeSugar() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addSugar("-1");
	}

	/**
	 * Given nothing
	 * When add string to the inventory
	 * Then the ingredients in inventory must increases and any exception should not be raised.
	 *
	 * @testcase T35
	 */
	@Test(expected = InventoryException.class)
	public void testAddNegativeMilk() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addMilk("-1");
	}

	/**
	 * Given nothing
	 * When add string to the inventory
	 * Then the ingredients in inventory must increases and any exception should not be raised.
	 *
	 * @testcase T36
	 */
	@Test(expected = InventoryException.class)
	public void testAddNegativeChocolate() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addChocolate("-1");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When purchase by negative money
	 * Then the returns must equals to the purchase money.
	 *
	 * @testcase T37
	 */
	@Test
	public void testNoNegativeMoney() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(-100, coffeeMaker.makeCoffee(1, -100));
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When the recipe that want to purchase not in the recipe book
	 * Then the returns must equals to the purchase money.
	 *
	 * @testcase T38
	 */
	@Test
	public void testNoRecipeInBook() {
		assertEquals(100, coffeeMaker.makeCoffee(1, 100));
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When the inventory is empty
	 * Then the customer cannot buy the coffee.
	 *
	 * @testcase T39
	 */
	@Test
	public void testEmptyInventory() throws RecipeException {
		Recipe clearInventory = createRecipe("clear inventory", 15, 15, 15, 15, 100);

		coffeeMaker.addRecipe(clearInventory);
		coffeeMaker.addRecipe(recipe1);
		assertEquals(0, coffeeMaker.makeCoffee(0, 100));

		assertEquals(100, coffeeMaker.makeCoffee(1, 100));
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When the inventory is not enough
	 * Then the customer cannot buy the coffee.
	 *
	 * @testcase T40
	 */
	@Test
	public void testNotEnoughInventory() throws RecipeException {
		Recipe clearInventory = createRecipe("clear inventory", 15, 14, 15, 15, 100);

		coffeeMaker.addRecipe(clearInventory);
		coffeeMaker.addRecipe(recipe1);
		assertEquals(0, coffeeMaker.makeCoffee(0, 100));

		assertEquals(100, coffeeMaker.makeCoffee(1, 100));
	}


	/**
	 * Given a coffee maker with the default inventory
	 * When the money is not enough
	 * Then the customer cannot buy the coffee.
	 *
	 * @testcase T41
	 */
	@Test
	public void testNotEnoughMoney() throws RecipeException {
		coffeeMaker.addRecipe(recipe1);

		assertEquals(2, coffeeMaker.makeCoffee(0, 2));
	}
}
