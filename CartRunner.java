package madisonIsland;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartRunner extends Base {
	
	@Test(enabled = true, description = "To select an item from the books section and go till payment page")
	public void tc_book01() {
		CartTest cart = new CartTest(wd);
		cart.clickBook();
		Assert.assertTrue(wd.getCurrentUrl().contains("checkout"),"Checkout page not visible.");
		
	}

	@Test(enabled = true, description = "To type 'dress' in the search box input field and check if results are displayed")
	public void tc_search01() {
		new CartTest(wd).searchDress();
		Assert.assertTrue(wd.getCurrentUrl().contains("dress"), "Search field not working.");
		
	}

	@Test(enabled = true, description = "Check 'Continue Shopping' function")
	public void tc_cart01() {
		new CartTest(wd).continueShop();
		Assert.assertTrue(wd.getCurrentUrl().contains("books"),"Books page not visible.");
	}

	@Test(enabled = true, description = "Check 'Empty cart' function")
	public void tc_cart02() {
		new CartTest(wd).emptyCart();
		Assert.assertTrue(wd.findElement(By.linkText("here")).isDisplayed());
	}
}