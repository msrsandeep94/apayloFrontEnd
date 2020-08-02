package apayloPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import apayloDataproviders.ConfigFileReader;
import apayloPagesfactory.ApayloPageFactory;
import apayloUtilities.ApayloSeleniumHelper;
import apaylodrivermanager.WebDriverManager;

/**
 * @author Ramakrishna
 * @descripton Add book page locators
 *
 */
public class AddEBookPage extends ApayloSeleniumHelper {
	WebDriver driver = WebDriverManager.getDriver();
	ApayloPageFactory pagefactory=new ApayloPageFactory(driver);
	WebDriverWait wait=new WebDriverWait(driver,ConfigFileReader.getConfigFileReader().getWebDriverWait());

	/*** 
	* Constructor 
	* @param driver an instance of WebDriver 
	*/
	public AddEBookPage(WebDriver driver) {
		super(driver);
		//Initialize Elements
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//*********Web Elements by using Page Factory*********
	
	@FindBy(how = How.CSS, using = ".form-control.custom-file-input") 
	private WebElement uploadBook;
	
	@FindBy(how = How.CSS, using = "[placeholder='Description']") 
	private WebElement description;
	
	@FindBy(how = How.CSS, using = "#book_TechnologyId") 
	private WebElement technology;
	
	@FindBy(how = How.CSS, using = "[placeholder='Published Date (YYYY)']") 
	private WebElement publishedOn;
	
	@FindBy(how = How.CSS, using = "[placeholder='Author Name']") 
	private WebElement author;

	@FindBy(how = How.CSS, using = "[placeholder='Book Name']") 
	private WebElement bookName;
	
	@FindBy(how = How.CSS, using = "[type='submit']") 
	private WebElement addbutton;
	
	@FindBy(how = How.CSS, using = ".btn.btn-primary.m-1")
	private WebElement addBookButton;
	
	public void clickAddBook() {
		click(addBookButton, "click on Add Book");
	}
	
	//*********Page Methods*********
	
	/**
	 * @description We will use this enterEbookDetails for enter the book details
	 */
	public void enterEbookDetails(String bName,String authr,String pblshOn,String techvalue,String desc,String filePath) {
		enterText(author, bName, "Enter Book Name");
		enterText(bookName, authr, "Enter Author Name");
		enterText(publishedOn, pblshOn, "Enter Publish on Name");
		selectListValuebyIndex(technology, "Testing", 5);
		enterText(description, desc, "Enter description Name");
		uploadFile(uploadBook,filePath,"Click on browse and enter path of the book");
	}
	
	
	/**
	 * Click Add Button
	 */
	public void clickAdd() {
		click(addbutton, "click on add");
	}
	
	
	
}
