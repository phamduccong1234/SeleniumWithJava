import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class TextBoxPage extends Page {

	By txtFullName = By.id("userName");
	By txtEmail = By.id("userEmail");
	By txtCurrentAddress = By.id("currentAddress");
	By txtPermanentAddress = By.id("permanentAddress");
	By btnSubmit = By.id("submit");

	By lbName = By.id("name");
	By lbEmail = By.id("email");
	By lbCurrentAddress = By.xpath("//p[@id='currentAddress']");
	By lbPermanentAddress = By.xpath("//p[@id='permanentAddress']");

	By clTextBoxEmail = By.className("field-error");

	public void inputFullName(String fullName) {
		driver.findElement(txtFullName).sendKeys(fullName);
	}

	public void inputEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}

	public void inputCurrentAddress(String currentAddress) {
		driver.findElement(txtCurrentAddress).sendKeys(currentAddress);
	}

	public void inputPermanentAddress(String permanentAddress) {
		driver.findElement(txtPermanentAddress).sendKeys(permanentAddress);
	}

	public void clickSubmitButton() {
		driver.findElement(btnSubmit).click();
	}

	public String getTextResult(By element) {
		String result = "";
		String text = driver.findElement(element).getText();
		result = text.substring(text.indexOf(":") + 1);
		return result;
	}

	public String getErrorColor(By element) {
		String result = "";
		WebElement colorTextInputBox = driver.findElement(element);
		String color = colorTextInputBox.getCssValue("field-error");
		result = Color.fromString(color).asHex();
		return result;
	}

	public TextBoxPage(WebDriver dr) {
		driver = dr;
	}

}
