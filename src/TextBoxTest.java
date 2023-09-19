import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTest  extends Page{
	public static void main(String[] args) {
		TextBoxTest testCases = new TextBoxTest();
		testCases.doTC01();
		
	}
	
	/**
	 * TextBox - TC01
	 */
	@Test
	public void doTC01() {
		//Open HomePage
		System.setProperty("webdriver.chrome.driver", "D:\\Automeation Class\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		//Click vào phần tử
		HomePage homePage = new HomePage(driver);
		
		ElementsPage elementsPage = homePage.clickElements();
		TextBoxPage textBoxPage = elementsPage.clickTextBoxMenu();
		
		String inputFullName = "Cong";
		String inputEmail = "abcd@gmail.com";
		String inputCurrentAddress = "Ha Noi";
		String inputPermanentAddress = "Ha Noi";
		
		textBoxPage.inputFullName(inputFullName);
		textBoxPage.inputEmail(inputEmail);
		textBoxPage.inputCurrentAddress(inputCurrentAddress);
		textBoxPage.inputPermanentAddress(inputPermanentAddress);
		
		textBoxPage.clickSubmitButton();
		
		String actualFullName = textBoxPage.getTextResult(textBoxPage.lbName);
		String actualEmail = textBoxPage.getTextResult(textBoxPage.lbEmail);
		String actualCurrentAddress = textBoxPage.getTextResult(textBoxPage.lbCurrentAddress);
		String actualPermanentAddress = textBoxPage.getTextResult(textBoxPage.lbPermanentAddress);
		
		// Assert - TestNG : Compare actual vs expect
		Assert.assertEquals(actualFullName, inputFullName); 
		Assert.assertEquals(actualEmail, inputEmail);
		Assert.assertEquals(actualCurrentAddress, inputCurrentAddress);
		Assert.assertEquals(actualPermanentAddress, inputPermanentAddress);
	}
	
	@Test
	public void doTC02() {
		//Open HomePage
		System.setProperty("webdriver.chrome.driver", "D:\\Automeation Class\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		
		//Click vào phần tử
		HomePage homePage = new HomePage(driver);
		
		ElementsPage elementsPage = homePage.clickElements();
		TextBoxPage textBoxPage = elementsPage.clickTextBoxMenu();
		
		String inputFullName = "Cong";
		String inputEmail = "abcdgmail.com";
		String inputCurrentAddress = "Ha Noi";
		String inputPermanentAddress = "Ha Noi";
		
		textBoxPage.inputFullName(inputFullName);
		textBoxPage.inputEmail(inputEmail);
		textBoxPage.inputCurrentAddress(inputCurrentAddress);
		textBoxPage.inputPermanentAddress(inputPermanentAddress);
		
		textBoxPage.clickSubmitButton();
		
		String actualErrorColorEmail = textBoxPage.getErrorColor(textBoxPage.clTextBoxEmail);
		
		String errorColor = "#b30000";
		
		// Assert - TestNG : Compare actual vs expect
		Assert.assertEquals(actualErrorColorEmail.toUpperCase(), errorColor.toUpperCase());
	}
	
	
}
