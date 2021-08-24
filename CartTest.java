package madisonIsland;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CartTest {

	WebDriver wd;

	public CartTest(WebDriver wd) {
		this.wd = wd;
	}

	// features
	By decor = By.xpath("//div[@id='header-nav']/nav/ol/li[4]/a");
	By books = By.xpath("//div[@id='header-nav']/nav/ol/li[4]/ul/li[2]/a");
	By book1 = By.xpath(
			"//a[@href='http://demo-store.seleniumacademy.com/home-decor/books-music/a-tale-of-two-cities.html'][text()='View Details']");
	By tick = By.xpath("//input[@id='links_20']");
	By addToCart = By.xpath("//button[@onclick='productAddToCartForm.submit(this)']");
	By search = By.id("search");
	By continue_shopping = By.xpath("//button[@title='Continue Shopping']");
	By emptyCart = By.xpath("//button[@title='Empty Cart']");
	

	// functions
	public void clickBook() {
		Actions action = new Actions(wd);

		// Hover to accessories
		action.moveToElement(wd.findElement(decor)).perform();

		// Click on Books&Music
		wd.findElement(books).click();

		// Click on first book
		wd.findElement(book1).click();

		// Tick the checkbox
		wd.findElement(tick).click();

		// Click on Add to Cart button
		wd.findElement(addToCart).click();
	}

	public void searchDress() {

		// send data to search field and press enter
		wd.findElement(search).sendKeys("dress");
		wd.findElement(search).sendKeys(Keys.ENTER);

	}

	public void continueShop() {

		// Add a book in cart
		clickBook();

		// Click on Continue Shopping
		wd.findElement(continue_shopping).click();
	}

	public void emptyCart() {

		// Add a book in cart
		clickBook();

		// Click on Empty Cart
		wd.findElement(emptyCart).click();
	}

}
