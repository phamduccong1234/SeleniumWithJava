import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

	By menuElementsXpath = By.xpath("//h5[text()='Elements']");

	public ElementsPage clickElements() {
		// scroll down to end page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		// click vao Element item
		driver.findElement(menuElementsXpath).click();

		return new ElementsPage(driver);

	}

	// Dùng hàm khởi tạo (constructor) để truyền Driver
	public HomePage(WebDriver dr) {
		driver = dr;
	}

}
