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
		
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
	}
	
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then we do not get an exception trying to read the inventory quantities.
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 *
	 * @@testcaseT1
	 */
	@Test
	public void testAddInventory() throws InventoryException {
		coffeeMaker.addInventory("4","7","1","9");
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantities (i.e., a negative 
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 *
	 * @@testcaseT2
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryException() throws InventoryException {
		coffeeMaker.addInventory("4", "-1", "asdf", "3");
	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than 
	 * 		the coffee costs
	 * Then we get the correct change back.
	 *
	 * @testcast T3
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
	 * @testcase T4
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
	 * @testcase T5
	 */
	@Test
	public void testSameRecipeName() throws RecipeException{
		Recipe recipe5 = new Recipe();
		recipe5.setName("Coffee");
		recipe5.setAmtChocolate("0");
		recipe5.setAmtCoffee("3");
		recipe5.setAmtMilk("1");
		recipe5.setAmtSugar("1");
		recipe5.setPrice("50");
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
	 * @testcase T6
	 */
	@Test
	public void testLimitRecipeList() throws RecipeException{
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);

		Recipe recipe6 = new Recipe();
		recipe6.setName("for test");
		recipe6.setAmtChocolate("0");
		recipe6.setAmtCoffee("3");
		recipe6.setAmtMilk("1");
		recipe6.setAmtSugar("1");
		recipe6.setPrice("50");

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
	 * @testcase T7
	 */
	@Test(expected = RecipeException.class)
	public void testAmountAndPriceNotInInteger() throws RecipeException{
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
	 * @testcase T8
	 */
	@Test(expected = RecipeException.class)
	public void testAmountAndPriceInNegativeInteger() throws RecipeException{
		Recipe forTest = new Recipe();
		forTest.setName("for test");
		forTest.setAmtChocolate("0");
		forTest.setAmtCoffee("-3");
		forTest.setAmtMilk("-1");
		forTest.setAmtSugar("-1");
		forTest.setPrice("-50");
	}

	/**
	 * Given nothing
	 * When the recipe has set in malformed
	 * Then cannot set that value to the recipe.
	 *
	 * @throws RecipeException if any value was not positive integer
	 *
	 * @testcase T9
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
	 * When the recipe in the recipe list and try to delete the recipe
	 * Then recipe deleted.
	 *
	 * @testcase T10
	 */
	@Test
	public void testDeleteRecipeFromList() {
		Recipe[] listForTest = {recipe1, recipe2, recipe3};

		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);

		assertArrayEquals(listForTest, coffeeMaker.getRecipes());

		coffeeMaker.deleteRecipe(3);

		Recipe[] afterDelete = {recipe1, recipe2, null};

		assertArrayEquals(afterDelete, coffeeMaker.getRecipes());
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When the recipe in the recipe list and try to delete the recipe
	 * Then nothing happen.
	 *
	 * @testcase T11
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
	 * @testcase T12
	 */
	@Test
	public void testEditRecipe() throws RecipeException {
		coffeeMaker.addRecipe(recipe1);

		Recipe editRecipe = new Recipe();
		editRecipe.setName("Coffee");
		editRecipe.setAmtChocolate("3");
		editRecipe.setAmtCoffee("2");
		editRecipe.setAmtMilk("3");
		editRecipe.setAmtSugar("0");
		editRecipe.setPrice("100");

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
	 * @testcase T13
	 */
	@Test(expected = NullPointerException.class)
	public void testEditRecipeOutOfList() throws RecipeException {
		Recipe editRecipe = new Recipe();
		editRecipe.setName("Coffee");
		editRecipe.setAmtChocolate("3");
		editRecipe.setAmtCoffee("2");
		editRecipe.setAmtMilk("3");
		editRecipe.setAmtSugar("0");
		editRecipe.setPrice("100");

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
	 * @testcase T14
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
	 * When check the default inventory.
	 * Then any exception should not be raises
	 *
	 * @testcase T15
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
	 * @testcase T16
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
	 * When inventory is ready to use
	 * Then the ingredients must decrease.
	 *
	 * @testcase T17
	 */
	@Test
	public void testUseIngredients() throws InventoryException {
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
	 * @testcase T18
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
	 * Given a coffee maker with the default inventory
	 * When purchase by negative money
	 * Then the returns must equals to the purchase money.
	 *
	 * @testcase T19
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
	 * @testcase T20
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
	 * @testcase T21
	 */
	@Test
	public void testEmptyInventory() throws RecipeException {
		Recipe clearInventory = new Recipe();
		clearInventory.setName("clear inventory");
		clearInventory.setAmtCoffee("15");
		clearInventory.setAmtChocolate("15");
		clearInventory.setAmtMilk("15");
		clearInventory.setAmtSugar("15");
		clearInventory.setPrice("100");

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
	 * @testcase T22
	 */
	@Test
	public void testNotEnoughInventory() throws RecipeException {
		Recipe clearInventory = new Recipe();
		clearInventory.setName("clear inventory");
		clearInventory.setAmtCoffee("15");
		clearInventory.setAmtChocolate("14");
		clearInventory.setAmtMilk("15");
		clearInventory.setAmtSugar("15");
		clearInventory.setPrice("100");

		coffeeMaker.addRecipe(clearInventory);
		coffeeMaker.addRecipe(recipe1);
		assertEquals(0, coffeeMaker.makeCoffee(0, 100));

		assertEquals(100, coffeeMaker.makeCoffee(1, 100));
	}

}
