import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends Page {
	/**
	 * TextBox - TC01
	 */
	@Test
	public void doTC01() {
		// Open HomePage
		System.setProperty("webdriver.chrome.driver", "D:\\Automeation Class\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");

		// Click vào phần tử
		HomePage homePage = new HomePage(driver);

		ElementsPage elementsPage = homePage.clickElements();
		CheckBoxPage checkBoxPage = elementsPage.clickCheckBoxMenu();

		Assert.assertTrue(checkBoxPage.isCheckBoxUnchecked(checkBoxPage.cbHome));

		checkBoxPage.clickHomeCheckBox();

		String expedtedHomeString = "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";
		String actualHomeString = checkBoxPage.getHomeString();

		Assert.assertEquals(actualHomeString, expedtedHomeString);

	}
}
