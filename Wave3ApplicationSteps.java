package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

//import com.google.common.collect.Lists;

import junit.framework.Assert;

import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;

import wave3CoreAutomation.Wave3AutomationObjects;
import wave3CoreAutomation.Wave3SeleniumEvents;
import wave3CoreAutomation.UtilityClasses.UtilTestData;
import wave3GenericAutomation.Wave3GenericApplicationSteps;
import wave3GenericAutomation.Wave3GenericFunctions;

public class Wave3ApplicationSteps extends Wave3GenericApplicationSteps {

	Wave3SeleniumEvents objSeleniumEvents = new Wave3SeleniumEvents();
	public Wave3AutomationObjects obAutomationObjects;
	Wave3GenericFunctions objGenericFunctions = new Wave3GenericFunctions(obAutomationObjects);
	List<String> breadCrumb = new ArrayList<>();

/* <---------------------GM Application Steps-------------------------------> */
///////////////////////////////////////////////////Methods to Get Values From Config////////////////////////////////////////////////////////////////////////////////
	
	public String[] getNavigationLevelAfterVINDecodeForPartIndex(Wave3AutomationObjects objAutomationObjects) throws Exception // Method to get navigation level after VIN decode
	{
		String strNavConfig = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Application") + "." + Wave3AutomationObjects.objAutomationConfig.getConfigValues("ActiveDataset").toUpperCase() + "." + "VINNavigation.PartIndex";
		return Wave3AutomationObjects.objAutomationConfig.getConfigValues("Major Group").split("\\|");
	}

	public String[] getBroadcastSheetNavigationLevelMap(Wave3AutomationObjects objAutomationObjects) throws Exception 
	{
		String strNavConfig = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Application").toUpperCase() + "." + Wave3AutomationObjects.objAutomationConfig.getConfigValues("ActiveDataset").toUpperCase() + "." + "BrdcstSheet.Column.Header.TestDataHeaderMap";
		return Wave3AutomationObjects.objAutomationConfig.getConfigValues(strNavConfig).split("\\|");
	}
	

	///////////////////////////////////////////////////////////////// Methods for Functionality////////////////////////////////////////////////////////////////////////
	
	public void enterUserId(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strUserID) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			objDriver.switchTo().parentFrame();
			objDriver.switchTo().frame("index_2");
			String strTextToWrite = null;
			String strXpathForUser = strApplication + "." + "Login.UserId.TextBox";
			WebElement objElement = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator(strXpathForUser), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clearTextBox(objElement);
			objSeleniumEvents.writeToTextBox(objElement, strUserID.trim());
			objDriver.switchTo().defaultContent(); 
			} 
		catch (Exception e) {
//			objAutomationObjects.objLogger.logErrorWithException(e); 
//			throw new Exception("FAIL: User Unable to enter User ID");
			}
		}
	
	public void enterMailId(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strUserEmailID) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			String strXpathForUser = strApplication + "." + "Login.Mail.TextBox";
			WebElement objElement = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator(strXpathForUser), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clearTextBox(objElement);
			objSeleniumEvents.writeToTextBox(objElement, strUserEmailID.trim());
			objDriver.switchTo().defaultContent(); 
			} 
		catch (Exception e) {
		//	objAutomationObjects.objLogger.logErrorWithException(e); 
		//	throw new Exception("FAIL: User Unable to enter User ID");
			}
		}
	
	public void clickLaunchButton(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			objDriver.switchTo().parentFrame();
			objDriver.switchTo().frame("index_Launch_id");
			String strXpathForLoginBtn = (Wave3AutomationObjects.objAutomationConfig.getConfigValues("Application").toUpperCase()) + "." + "Login.Launch.Button";
			WebElement objElement = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator(strXpathForLoginBtn), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objElement);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XXS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to Launch Application");
			} 
		}
	
	public void chooseDeploymentAddress(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			objDriver.switchTo().parentFrame();
			objDriver.switchTo().frame("index_2_id");
			WebElement objDeploymentAdd = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("GMHTML5.Login.DeploymentAdd.Button"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objDeploymentAdd); 
			WebElement objDropdownText = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("GMHTML5.Login.DeploymentAdd.DropDown.Text"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_ZERO);
			objSeleniumEvents.clickButton(objDropdownText); 
			objDriver.switchTo().defaultContent(); 
			} 
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e); 
			throw new Exception("FAIL: Unable to select Deployment Address");
			} 
		}

	public void selectWEBEPCCheckBox(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, boolean isRelogin) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			objDriver.switchTo().parentFrame();
			objDriver.switchTo().frame("index_Portal_id");
			WebElement objWEBEPCCheckbox = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("GMHTML5.Login.WEBEPC.CheckBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XS);
			if (!isRelogin)				
		     	objWEBEPCCheckbox.click(); 
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to Select EPC Checkbox"); 
			} 
		}
	
	public void selectWEBAdminCheckBox(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strUserRoles) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			objDriver.switchTo().parentFrame();
			objDriver.switchTo().frame("index_Portal_id");
			if (!(strUserRoles.equals("")) && strUserRoles !=null&& !(strUserRoles.equals("Non-Admin")) && (strUserRoles.equals("GM ADMIN") )) 
			{ 
				String strRoles[] = strUserRoles.split("\\,");
				for (int intRoleCount = 0; intRoleCount < strRoles.length; intRoleCount++) 
				{ 
					String strRole = strRoles[intRoleCount];
					if (!strRole.equalsIgnoreCase("null")) {
//						String strCheckboxXpath = objAutomationObjects.objObjectMAP.getConfigValues("GMHTML5.Login.WEBAdmin.CheckBox.Pre") + strRoles[intRoleCount] + objAutomationObjects.objObjectMAP.getConfigValues("GMHTML5.Login.WEBAdmin.CheckBox.Suc"); 
//						WebElement objWEBEPCCheckbox = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getXpathFromString(strCheckboxXpath), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XS);
						WebElement objWEBEPCCheckbox = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("GMHTML5.Login.WEBAdmin.CheckBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XS);
						if (!(objWEBEPCCheckbox.isSelected()))
							objWEBEPCCheckbox.click();
						} 
					}
					
				}
			} 
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
//			throw new Exception("FAIL: Unable to select User Roles");
			} 
		} 
	
	public void selectGMAVCheckBox(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strUserRoles) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			objDriver.switchTo().parentFrame();
			objDriver.switchTo().frame("index_Portal_id");
			if (!(strUserRoles.equals("")) && strUserRoles !=null&& !(strUserRoles.equals("Non-Admin")) && strUserRoles.equals("GM AV"))
			{ 
				String strRoles[] = strUserRoles.split("\\,");
				for (int intRoleCount = 0; intRoleCount < strRoles.length; intRoleCount++) 
				{ 
					String strRole = strRoles[intRoleCount];
					if (!strRole.equalsIgnoreCase("null")) {
//						String strCheckboxXpath = objAutomationObjects.objObjectMAP.getConfigValues("GMHTML5.Login.WEBAdmin.CheckBox.Pre") + strRoles[intRoleCount] + objAutomationObjects.objObjectMAP.getConfigValues("GMHTML5.Login.WEBAdmin.CheckBox.Suc"); 
//						WebElement objWEBEPCCheckbox = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getXpathFromString(strCheckboxXpath), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XS);
						WebElement objWEBEPCCheckbox = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("GMHTML5.Login.GMAV.CheckBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XS);
						if (!(objWEBEPCCheckbox.isSelected()))
							objWEBEPCCheckbox.click();
						} 
					}
					
				}
			} 
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
//			throw new Exception("FAIL: Unable to select User Roles");
			} 
		} 
	
	public void choosePortalFromDropDown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strPortalSource) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false); 
			objDriver.switchTo().parentFrame();
			objDriver.switchTo().frame("index_2_id");
			WebElement objPortal = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("GMHTML5.Login.Portal.Button"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objPortal); 
			String strPortalXpath = (objAutomationObjects.objObjectMAP.getConfigValues("GMHTML5.Login.Portal.DropDown.Pre")).trim() + strPortalSource + objAutomationObjects.objObjectMAP.getConfigValues("GMHTML5.Login.Portal.DropDown.Suc");
			WebElement objDropdownText = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getXpathFromString(strPortalXpath), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_ZERO);
			objSeleniumEvents.clickButton(objDropdownText); 
			objDriver.switchTo().defaultContent(); 
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to select Portal at Launcher Page");
			} 
		}

	public void switchToNewWindow(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try{
			objAutomationObjects.objLogger.logInfo("", false);
			String parent = objDriver.getWindowHandle();
			Set<String> s1 = objDriver.getWindowHandles(); 
			Iterator<String> I1 = s1.iterator(); 
			while (I1.hasNext())
			{ 
				String child_window = I1.next(); 
				if (!parent.equals(child_window)) { 
					objDriver.switchTo().window(child_window);
					}  
				} 
			Thread.sleep(60000); 
			String strHomeBtn = "GMHTML5.NavigationBar.Home.Button"; 
			WebElement objElement = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator(strHomeBtn), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS); 
			if (objElement != null) 
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Application Is Launched");  
				} 
			else 
			{ 
				WebElement objAcceptBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("GMHTML5.Launch.LicensePage.AcceptButton"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_ZERO); 
				if (objAcceptBtn != null) 
					Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Application Is Launched"); 
				else  
					throw new Exception("FAIL: Application Is Not Launched");  
				}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Application is not Launched");
			} 
		} 
	
	public void userPerformSearch(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objWebElement = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.HomePage.Search.TextBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.writeToTextBox(objWebElement, "Selenium");
			 Actions acc = new Actions(objDriver);
		     acc.sendKeys(Keys.ENTER).build().perform();
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to Perform Search");
			} 
		}
	
	
	public void validateSearchResult(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
	//		String strJobToBeDeleted = objAutomationObjects.objObjectMAP.getConfigValues(strApplication + ".Jobs.Tab.List") + "1]" + objAutomationObjects.objObjectMAP.getConfigValues(strApplication + ".Jobs.Tab.CloseBtn");
			String strSearchTermXpath = objAutomationObjects.objObjectMAP.getConfigValues("DNS.HomePage.Search.Result");
			WebElement objWebElement = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getXpathFromString(strSearchTermXpath), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objWebElement != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Search Result is Displayed"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Search Result is NOT Displayed");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to Perform Search");
			} 
		}
	
	public void userIsAtSearchWindow(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			String strSearchTermXpath = objAutomationObjects.objObjectMAP.getConfigValues("DNS.HomePage.Search.Result");
			WebElement objWebElement = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getXpathFromString(strSearchTermXpath), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objWebElement != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Search Result is Displayed"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Search Result is NOT Displayed");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to Perform Search");
			} 
		}
	
	
	public void loginPageImage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objloginPageImage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.LoginPage.Image"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objloginPageImage != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Login Page image is Displayed"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Login Page image is NOT Displayed");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL:Unable to find login page image");
			} 
		}
	
	public void loginPageView(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objloginPageImage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.LoginPage.Image"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);

			if(objloginPageImage != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Login Page is available to use"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Login Page is not visible");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL:Unable to find login page image");
			} 
		}
	
	public void helpAndSupportbtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objHelpBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.ContactBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objHelpBtn); 
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to Support link");
			} 
		}
	
	public void switchToChildWindow(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false); 
			String currentWindow = objDriver.getWindowHandle();
			objDriver.close();
			
			Set<String> windows = objDriver.getWindowHandles();
			for(String window : windows) {
				if(!window.equals(currentWindow)) {
					objDriver.switchTo().window(window);
				}
			}
			
			//objDriver.switchTo().window(parentWindow);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Driver not move back to child window");
			throw new Exception();
			} 
		}
	public void switchToParentWindow(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false); 
			String currentWindow = objDriver.getWindowHandle();
			objDriver.close();
			
			Set<String> windows = objDriver.getWindowHandles();
			for(String window : windows) {
				if(!window.equals(currentWindow)) {
					objDriver.switchTo().parentFrame();
				}
			}
			
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Driver not move back to parent window");
			throw new Exception();
			} 
		}
	
	
	public void supportCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objHelpCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.HelpCloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objHelpCloseBtn); 
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to Support Page close btn");
			} 
		}
	
	public void dashboardPageLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDashboardPageLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.DashboardPageLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objDashboardPageLabel != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Dashbaord Page Label is Displayed"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Dashbaord Page Label is NOT Displayed");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to find Dashboard page Label");
			} 
		}
	
	public void dashboardPageLabelNotAppear(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDashboardPageLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.DashboardPageLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objDashboardPageLabel != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Map is view at full page"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Map is not view at full page");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: able to find Dashboard page Label");
			} 
		}
	
	public void enterUserName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strUserName) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objUsername = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.UsernameField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clearTextBox(objUsername);
			objSeleniumEvents.writeToTextBox(objUsername, strUserName);
			
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Username WebElemen");
			throw new Exception();
			}
		}
	public void enterUserName1(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strStellUsername) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objUsername = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Login.UsernameBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clearTextBox(objUsername);
			objSeleniumEvents.writeToTextBox(objUsername, strStellUsername);
			
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Username WebElemen");
			throw new Exception();
			}
		}
 

	public void enterPassword(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strPassword) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objPassword = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Login.PasswordBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clearTextBox(objPassword);
			objSeleniumEvents.writeToTextBox(objPassword, strPassword);
			
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Password WebElement not found");
			throw new Exception();
			}
		}
	
	public void enterPassword1(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strPassword) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objPassword = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PasswordField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clearTextBox(objPassword);
			objSeleniumEvents.writeToTextBox(objPassword, strPassword);
			
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Password WebElement not found");
			throw new Exception();
			}
		}
	
	public void clicksOnSignInBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objSignInBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.SignInBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objSignInBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find SignIn Btn WebElement");
			throw new Exception();
			}
	}
	public void clickOnDashboardDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDashboardDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.DashboardDropBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objDashboardDropdown);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Dashboard Dropdown WebElement");
			throw new Exception();
			}
	}
	public void clickOnSelectedNetwork(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objSelectedNetwork = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.SelectedNetwork"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objSelectedNetwork);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Dashboard network WebElement");
			throw new Exception();
			}
	}
	public void clickOnFilterExpandBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objFilterExpandbtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Filter.Dropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objFilterExpandbtn);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Filter Expand Btn WebElement");
			throw new Exception();
			}
	}
	public void clickOnFilterExpandBtnForOpportunity(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objFilterExpandbtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Filter.Dropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor jseElement = (JavascriptExecutor)objDriver;
			jseElement.executeScript("scroll(0, -250);");
			objSeleniumEvents.clickButton(objFilterExpandbtn);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Filter Expand Btn WebElement");
			throw new Exception();
			}
	}
	public void clickOnNetworkDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.DealerNetwork.Dropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objNetworkDropdown);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Filter Network Dropdown WebElement");
			throw new Exception();
			}
	}
	public void clickOnForecastNetworkDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.NetworkDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objNetworkDropdown);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Forecast Network Dropdown WebElement");
			throw new Exception();
			}
	}
	public void clickOnNetworkDropdownForKpiPerforanceChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Dealer.Dropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor jseElement = (JavascriptExecutor)objDriver;
			jseElement.executeScript("scroll(0, -250);");
			objSeleniumEvents.clickButton(objNetworkDropdown);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Filter Network Dropdown WebElement");
			throw new Exception();
			}
	}
	public void clickOnNetworkListDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkListDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.DealerList.Dropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			//JavascriptExecutor jseElement = (JavascriptExecutor)objDriver;
			//jseElement.executeScript("arguments[0].click()", objNetworkListDropdown);
			objSeleniumEvents.clickButton(objNetworkListDropdown);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Filter Network List Dropdown WebElement");
			throw new Exception();
			}
	}
	public void clickOnNetworkListDropdownForPlDispersionChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkListDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.DealerList.Dropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor jseElement = (JavascriptExecutor)objDriver;
			jseElement.executeScript("scroll(0, -250);");
			//jseElement.executeScript("arguments[0].click()", objNetworkListDropdown);
			objSeleniumEvents.clickButton(objNetworkListDropdown);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Filter Network List Dropdown WebElement");
			throw new Exception();
			}
	}
	
	public void clickOnNetworkListDropdownForKpiPerformance(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkListDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.DealerList.Dropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor jseElement = (JavascriptExecutor)objDriver;
			jseElement.executeScript("scroll(0, -250);");
			//jseElement.executeScript("arguments[0].click()", objNetworkListDropdown);
			objSeleniumEvents.clickButton(objNetworkListDropdown);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Filter Network List Dropdown WebElement");
			throw new Exception();
			}
	}
	public void clickOnNetworkTree(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkListDropdownFirst = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkTreeSingle"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objNetworkListDropdownFirst);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			/*
			WebElement objNetworkListDropdownTwo = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkTreeTwo"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objNetworkListDropdownTwo.getText()!=null) {
				objSeleniumEvents.clickButton(objNetworkListDropdownTwo);
			}
			else {
				objSeleniumEvents.clickButton(objNetworkListDropdownFirst);
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
			*/
			
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Network Tree name WebElement");
			throw new Exception();
			}
	}
	public void clickOnMapViewBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMapBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.MapBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objMapBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find MapView Btn WebElement");
			throw new Exception();
			}
	}
	public void vlaidateUserAtMapViewPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objFullPageLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.FullPageBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objFullPageLabel != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Map view is Displayed"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Map view is NOT Displayed");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to find Map view page label WebElement");
			} 
		}
	
	public void clickOnFilterBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objFilterBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.FilterBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objFilterBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Filter Btn WebElement");
			throw new Exception();
			}
	}
	public void clickOnMapFilterBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMapFilterBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.FilterBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objMapFilterBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find MapFilter Btn WebElement");
			throw new Exception();
			}
	}
	
	public void clickOnNetworkSearch(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkSearch = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkSearch"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objNetworkSearch);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find FNetwork Search Btn WebElement");
			throw new Exception();
			}
	}
	
	public void enterNetworkName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkNameField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkNameField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clearTextBox(objNetworkNameField);
			String MarketName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Dash.MarketName");
			objSeleniumEvents.writeToTextBox(objNetworkNameField, MarketName);
			 Actions acc = new Actions(objDriver);
		     acc.sendKeys(Keys.ENTER).build().perform();
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to Perform Network market Search");
			} 
		}
	
	public void selectName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> NetworkResult = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkSearchNames"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement option: NetworkResult) {
				String MarketName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Dash.MarketName");
				if(option.getText().equals(MarketName)) {
					option.click();
			        objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
					break;
				}
			}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Network Market name in search result not found");
			throw new Exception();
			} 
		}

	public void selectNetworkName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> NetworkResult = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.NetworkSearchNames"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement option: NetworkResult) {
				String MarketName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Dash.MarketName");
			if(option.getText().contains(MarketName)) {
				//	if(option.getText().contains("UK")) {
					option.click();
					break;
				}
			}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Network Market name in search result not found");
			throw new Exception();
			} 
		}
	public void enterDealerNetworkName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkNameField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkNameField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clearTextBox(objNetworkNameField);
			String DealerName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Dash.DealerName");
			String DealerNameNew = DealerName.replaceAll("\\s+","");
			objSeleniumEvents.writeToTextBox(objNetworkNameField, DealerNameNew);
			// Actions acc = new Actions(objDriver);
		   //  acc.sendKeys(Keys.ENTER).build().perform();
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to Perform Network Search for dealer");
			} 
		}
	
	public void enterDealerNameForForecast(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkNameField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkNameField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clearTextBox(objNetworkNameField);
			String DealerName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Dash.Forecast.DealerName");
			String DealerNameNew = DealerName.replaceAll("\\s+","");
			objSeleniumEvents.writeToTextBox(objNetworkNameField, DealerNameNew);
			// Actions acc = new Actions(objDriver);
		   //  acc.sendKeys(Keys.ENTER).build().perform();
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to Perform Network Search for dealer");
			} 
		}
	
	public void selectDealerName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
		/*	objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> NetworkResult = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkSearchNames"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement option: NetworkResult) {
				if(option.getText().contains("L10045")) {
					option.click();
					break;
				}
			}
			}
		*/
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> DealersList = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Dealer.DealersList"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
		if(DealersList.size()<2){
		WebElement objSelectOnlyDealer = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Dealer.SingleDealer"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSelectOnlyDealer);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
		else {
			WebElement objSelectOtherDealer = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Dealer.MultiDealer"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objSelectOtherDealer);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
		}
		
		
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Network dealer name in search result not found");
			throw new Exception();
			} 
		}
	public void selectForecastDealerName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
		/*	objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> NetworkResult = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkSearchNames"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement option: NetworkResult) {
				if(option.getText().contains("L10045")) {
					option.click();
					break;
				}
			}
			}
		*/
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> DealersList = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Dealer.DealersList"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
		if(DealersList.size()<2){
		WebElement objSelectOnlyDealer = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Dealer.SingleDealer"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSelectOnlyDealer);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
		else {
			WebElement objSelectOtherDealer = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Dealer.SingleDealer"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objSelectOtherDealer);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
		}
		
		
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Network dealer name in search result not found");
			throw new Exception();
			} 
		}
	public void vlaidateMapAvailableInDashboardPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMapBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.MapBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objMapBtn != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Map view is Displayed for Dealer"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Map view is NOT Displayed for Dealer selection");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to find Map view page label WebElement");
			} 
		}
	

	public void vlaidateUserAtMapPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkSearch = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkSearch"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objNetworkSearch);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find FNetwork Search Btn WebElement");
			throw new Exception();
			}
	}
	
	public void clickOnMapFullPageBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objFullPage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.FullPageBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objFullPage);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Full Page Map Btn WebElement");
			throw new Exception();
			}
	}
	public void clickOnMapDepartmentDropDown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objFullPage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.DeptSelectionDropdwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objFullPage);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Map department dropdown Btn WebElement");
			throw new Exception();
			}
	}
	public void clickOnMapDepartmentName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> DeptNamaes = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.DeptSelectionNames"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement option: DeptNamaes) {
				if((option.getText().contains("Summary") || (option.getText().contains("VEHICLES")))) {
					option.click();
					break;
				}
			}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Map Dept name not found");
			throw new Exception();
			} 
		}
	public void validateDepartmentName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMapBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.DeptSelectionName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objMapBtn != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Selected Dept is Displayed In map"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Selected Dept is not Displayed In map");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to find map dept name WebElement");
			} 
		}
	
	public void clickOnMapDepartmentKpiDropDown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objFullPage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.KPISelectionDropDwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objFullPage);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find map dept kpi dropdown WebElement");
			throw new Exception();
			}
	}
	public void clickOnMapDepartmentKpiName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> DeptNamaes = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.KPISelectionNames"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement option: DeptNamaes) {
				if(option.getText().contains("Profit Before Tax (PBT) %") || option.getText().contains ("PROFIT BEFORE TAX - % Net Sales")) {
					option.click();
					break;
				}
			}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Map Dept name not found");
			throw new Exception();
			} 
		}
	public void validateDepartmentKpiName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMapBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.DeptSelectionName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objMapBtn != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Selected Dept kpi is Displayed In map"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Selected Dept kpi is not Displayed In map");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to find map dept kpi name WebElement");
			} 
		}
	
	public void validateNetworkSelectorFilterClose(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMapBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Dealer.Dropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objMapBtn != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Network selector filter closed up"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Network selector filter not closed up");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to find map dept kpi name WebElement");
			} 
		}
	public void moveToCountry(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			//WebElement objFullPage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.KPISelectionDropDwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			Actions acc = new Actions(objDriver);
		    // acc.sendKeys(Keys.ENTER).build().perform();
		     acc.moveByOffset(194, 222).click().build().perform();
		     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		     Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Country map is selected");
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find country cordinates WebElement");
			throw new Exception();
			}
	}
	
	public void moveToDealer(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			//WebElement objFullPage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.KPISelectionDropDwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			Actions acc = new Actions(objDriver);
		    // acc.sendKeys(Keys.ENTER).build().perform();
		     acc.moveByOffset(212, 190).click().build().perform();
		 	objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		    Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Dealer map is selected");
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find dealer cordinates WebElement");
			throw new Exception();
			}
	}
	public void clickOnCountry(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objFullPage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.KPISelectionDropDwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objFullPage);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find map dept kpi dropdown WebElement");
			throw new Exception();
			}
	}
	
	public void clickOnMapZoomInBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMapZoomIn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.ZoomIn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objMapZoomIn);
			Actions acc = new Actions(objDriver);
			acc.doubleClick(objMapZoomIn);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Map Zoomed In");
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find map zoom In WebElement");
			throw new Exception();
			}
	}
	
	public void clickOnMapZoomOutBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objZoomOut = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.ZoomOut"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objZoomOut);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Map Zoomed Out");
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find map Zoom Out WebElement");
			throw new Exception();
			}
	}
	
	public void clickOnLevelUpBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objLevelUp = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Map.LevelUp"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objLevelUp);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find map level up WebElement");
			throw new Exception();
			}
	}
	public void validateNetworkDispersionChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkDispersionChartName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkDisprsnChart"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objNetworkDispersionChartName != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Network Dispersion Chart Displayed"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Network Dispersion Chart is not Displayed");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to find Network Dispersion Chart name WebElement");
			} 
		}
	public void dealershipValue(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMarketBubble = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Market.Bubble"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			//WebElement element = objDriver.findElement(By.id("logo"));

			//((JavascriptExecutor)objDriver).executeScript("var mouseEvent = document.createEvent('MouseEvents');mouseEvent.initEvent('mouseover', true, true); arguments[0].dispatchEvent(mouseEvent);", element);
			
			Actions acc = new Actions(objDriver); 
			acc.moveToElement(objMarketBubble).perform(); 
			
		        
		        
			 String hoverText1 = objMarketBubble.getAttribute("title");
			System.out.println("Text of hover values" + hoverText1);
			 String hovergettext = objMarketBubble.getText();
				System.out.println("Text of hover values" + hovergettext);
			 Dimension hoverText2 = objMarketBubble.getSize();
			System.out.println("SIZE of hover values" + hoverText2);
			
			WebElement objBubbleHover = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Market.Bubble.Hover"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		/*	
			WebElement objHidden = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Market.BubbleHidden"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		       ((JavascriptExecutor) objDriver).executeScript("arguments[0].setAttribute('style','visibility:visible;');",
		      		objHidden);
		       */
			   
			 String hoverText3 = objBubbleHover.getText();
			System.out.println("Text of hover values" + hoverText3);
			 Dimension hoverText4 = objBubbleHover.getSize();
			System.out.println("SIZE of hover values" + hoverText4);
			
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Market bubble WebElement");
			throw new Exception();
			}
	}

	public void clickOnZoomInBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objZoomIn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetDisprsnZoomIn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objZoomIn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find network dispersion Zoom In WebElement");
			throw new Exception();
			}
	}
	public void clickOnZoomOutBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objZoomOut = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetDisprsnZoomOut"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objZoomOut);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Network Dispersion Zoom Out WebElement");
			throw new Exception();
			}
	}
	
	public void validateNetworkDispersionZoomInAndZoomOutOptions(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objSize = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetDisprsnSize"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			String SizeBeforeZoomIn = objSize.getText();
			
		System.out.println("Size before......." + SizeBeforeZoomIn);
			WebElement objZoomIn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetDisprsnZoomIn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objZoomIn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			WebElement objSizeAfter = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetDisprsnSize"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			String SizeAfterZoomIn = objSizeAfter.getText();
			
			System.out.println("Size After......." + SizeAfterZoomIn);
		if (SizeBeforeZoomIn!= SizeAfterZoomIn) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Bubble size changed after re-sizing");
		} else {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Bubble size not change after re-sizing");
		}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Network Dispersion Size WebElement");
			throw new Exception();
			}
	}
	public void clickOnNetworkDispersionDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetDisprsnDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objDownloadBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Network Dispersion Download btn WebElement");
			throw new Exception();
			}
	}
	public void validateNetworkDispersionDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkDispersionDownload = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetDisprsnDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objNetworkDispersionDownload != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Network Dispersion Excel Downloaded"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Network Dispersion Excel not Download");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to find Network Dispersion Download WebElement");
			} 
		}
	public void validateMarketDispersionChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMarketDispersionLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.MarketDisprsnlabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objMarketDispersionLabel != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Market Dispersion chart is Displayed"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Market Dispersion chart NOT Displayed");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to find Market Dispersion label WebElement");
			} 
		}
	
	public void clickOnMarketDispersionDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.MarketDisprsnDwnload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objDownloadBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Market Dispersion Download btn WebElement");
			throw new Exception();
			}
	}
	public void validateMarketDispersionDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkDispersionDownload = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.MarketDisprsnDwnload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			if(objNetworkDispersionDownload != null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Market Dispersion Excel Downloaded"); 
			}
			else
			{
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Market Dispersion Excel not Download");
				throw new Exception();
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception("FAIL: Unable to find Market Dispersion Download WebElement");
			} 
		}
	
	public void readDispersionChartValues(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMarketBubbleHover = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Market.BubbleHover"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			Actions acc = new Actions(objDriver); 
			acc.moveToElement(objMarketBubbleHover).perform(); 
			WebElement objMarketName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.MarketDispersion.Name"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			String marketNameApp = objMarketName.getText();
			WebElement objPBTValue = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.MarketDisprsn.PBT.Value"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			String PBTValue = objPBTValue.getText();
			WebElement objNetSales = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.MarketDisprsn.Sale.value"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			String NetSales = objNetSales.getText();
			
			Map<String, String> m = new LinkedHashMap<>();

			m.put("MarketName", marketNameApp);

			m.put("PBT Value", PBTValue);

			m.put("NetSales", NetSales);
			
			System.out.println("String of data"  + m);
			
			String Market = Wave3AutomationObjects.objAutomationConfig.getConfigValues("MarkeName");
			String PBT = Wave3AutomationObjects.objAutomationConfig.getConfigValues("PBTValue");
			String Sales = Wave3AutomationObjects.objAutomationConfig.getConfigValues("NetSales");
			
			System.out.println("Stored value" + Market );
			
     	if (marketNameApp == Market && PBTValue == PBT && NetSales == Sales) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Market details are matched");
			}else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Market details are not matched");
			}
			
			FileInputStream fs = new FileInputStream("D:\\Automation\\Automation Data validation\\Cnh-DispersionChart.xlsx"); //

			// Creating a workbook

			XSSFWorkbook workbook = new XSSFWorkbook(fs);

			XSSFSheet sheet = workbook.getSheetAt(0);
			
			for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {

				Object d = sheet.getRow(1).getCell(i);

				String s2 = String.valueOf(sheet.getRow(0).getCell(i));
				
				System.out.println( "Value of cell 0" + s2);

				String s1 = m.get(s2);
				
				System.out.println( "Value of M and S " + s1);

				/* checking excel value and UI extracted value is null */

				if (d == null && s1.isEmpty()) {

				System.out.println(sheet.getRow(0).getCell(i) + "field value is empty");

				} else if (((d == null) && !(s1.isEmpty())) || (!(d == null) && (s1.isEmpty()))) {
					
					throw new Exception("Exported records mismatch with UI");

				}

				else {

				String s = d.toString();

				Assert.assertEquals(s1, s, "Value not matching" + sheet.getRow(1).getCell(i));

				System.out.println(sheet.getRow(1).getCell(i));

				}

				}

				fs.close();

				Path filePath = Paths.get(System.getProperty("user.home") + "/Downloads/Messages.xlsx");
				
				Files.delete(filePath);

		}

		catch (Exception e) {

		System.out.println(e.getStackTrace());

		}

		}

	
	//Existing components
	
	
	public void validateNetworkHierarchyField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkHierachyField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Dashboard.NetworkHierarchy"), objGenericFunctions.WAITFORPRESENCE_M, objGenericFunctions.SLEEP_S);
			if(objNetworkHierachyField!= null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:User is at Dashboard page");
			}else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: User not at Dashboard page as network Hiearchy filed is not Displayed");
				throw new Exception("FAIL:  User not at Dashboard page as network Hiearchy filed is not Displayed");
			}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception();
			} 
		}
	public void enterDealer(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Dashboard.NetworkHierarchy"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clearTextBox(objNetworkField);
			//objSeleniumEvents.writeToTextBox(objNetworkField, "A50011"); //NissanGB
			//objSeleniumEvents.writeToTextBox(objNetworkField, "B40192"); //NissanGB Test
			//objSeleniumEvents.writeToTextBox(objNetworkField, "A11108"); //FordIT
			objSeleniumEvents.writeToTextBox(objNetworkField, "H37177"); //Stellantis STG IT - D21404, PT test - H37177
			
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Network hierarchy field WebElement not found");
			throw new Exception();
			} 
		}
	public void enterDealerForPublishedReport(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Dashboard.NetworkHierarchy"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clearTextBox(objNetworkField);
			//objSeleniumEvents.writeToTextBox(objNetworkField, "Nissan GB Core"); //NissanGB
			//objSeleniumEvents.writeToTextBox(objNetworkField, "B40192"); //NissanGB Test
			//objSeleniumEvents.writeToTextBox(objNetworkField, "A11108"); //FordIT
			objSeleniumEvents.writeToTextBox(objNetworkField, "H37177"); //Stellantis STG IT - D21404, PT test - H37177
			
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Network hierarchy field WebElement not found");
			throw new Exception();
			} 
		}
	public void selectDealer(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> DealersList = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Dashboard.DealersList"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
			if(DealersList.size()<2){
			WebElement objSelectOnlyDealer = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Dashboard.SingleDealer"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objSelectOnlyDealer);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
			else {
				WebElement objSelectOtherDealer = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Dashboard.DealersOption"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
				objSeleniumEvents.clickButton(objSelectOtherDealer);
				objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Network hierarchy field WebElement not found");
			throw new Exception();
			} 
		}
	
	public void selectDealerMore(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> DealersList = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Dashboard.DealersList"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
			if(DealersList.size()<2){
			WebElement objSelectOnlyDealer = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Dashboard.SingleDealer"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objSelectOnlyDealer);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
			else {
				WebElement objSelectOtherDealer = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Dashboard.DealersOptionM"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
				objSeleniumEvents.clickButton(objSelectOtherDealer);
				objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Network hierarchy field WebElement not found");
			throw new Exception();
			} 
		}
	public void DealerDashboardPanelHeading(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDealerDashboardPanelHeading = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDashboard.Panel"), objGenericFunctions.WAITFORPRESENCE_M, objGenericFunctions.SLEEP_S);
			if(objDealerDashboardPanelHeading!= null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Selected Dealer dashboard is appearing successfully");
			}else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Dealer dashboard is not appeared as its panel heading is not Displayed");
				throw new Exception("FAIL: Dealer dashboard is not appeared as its panel heading is not Displayed");
			}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception();
			} 
		}
	public void clickOnPeriodCalenderBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objCalenderBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.PeriodCalenderBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objCalenderBtn);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Period Calender btn WebElement not found");
			throw new Exception();
			} 
		}
	public void selectPeriod1(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> PeriodOptions = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.PeriodYear"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			System.out.println(PeriodOptions);
			for(WebElement period: PeriodOptions) {
				String PeriodValue= period.getText();
				if(PeriodValue.contains("Mar 2025")) {
					period.click();
					break;
				}
			}
			
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Year Dropdown WebElement not found");
			throw new Exception();
			} 
		}
	public void selectMonth(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> MonthOptions = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.PeriodMonth"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement Month: MonthOptions) {
				if(Month.getText().contains("Mar 2025")) {
					Month.click();
					break;
				}
			}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Month Dropdown WebElement not found");
			throw new Exception();
			} 
		}
	
	public void selectYear(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objPeriodSelector = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.Period"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objPeriodSelector);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Period field WebElement not found");
			throw new Exception();
			} 
		}
	
	public void validatePeriodName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objPeriodName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.PeriodName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			if(objPeriodName.getText().contains("Jan 2022")) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Period is selected successfully");
			}
			else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Period is not selected");
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Period name field WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnMeasureDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMeasureDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.MeasureBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objMeasureDropdownBtn);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Measure dropdown btn WebElement not found");
			throw new Exception();
			} 
		}
	public void selectMeasureMTD(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> MeasureOptions = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.MeasureDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement Measure: MeasureOptions) {
				if(Measure.getText().contains("MTD") || Measure.getText().contains("Month") ) {
					Measure.click();
					break;
				}
				
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Measures WebElement in measure dropdown are not found");
			throw new Exception();
			} 
		}
	public void validateMeasureName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objMeasureName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.MeasureName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			if(objMeasureName.getText().contains("MTD") || objMeasureName.getText().contains("Month")) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Measure is selected successfully");
			}
			else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Measure is not selected");
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Measure name field WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnKPISettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objKPISettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPI.Setting"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objKPISettingBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Setting btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnSelectAllItemBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objSelectAllItemBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPI.SelectAll"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objSelectAllItemBtn);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:All KPI items are selected successfully");
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Select all WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnSelectAndDeselectAllItemBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			try {
			WebElement objSelectAllItemBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPI.SelectAll"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objSelectAllItemBtn);
			}
			catch (Exception e) {
				WebElement objKPIDeselectAllBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPI.Deselect"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
				objSeleniumEvents.clickButton(objKPIDeselectAllBtn);
				WebElement objSelectAllItemBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPI.DefaultItem"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objSelectAllItemBtn);
			}
			//objSeleniumEvents.clickButton(objSelectAllItemBtn);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:All KPI items are selected successfully");
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Select all WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objKPISaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPI.SaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objKPISaveBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI items save WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnSubmissionsBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objSubmissionsBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.SubmissionBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objSubmissionsBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Submissions btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnDefaultItemBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			try {
			WebElement objSelectDefaultItemBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPI.DefaultItem"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objSelectDefaultItemBtn);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Default KPI items are selected successfully");
			}
			catch (Exception e) {
			//	WebElement objKPIDeselectAllBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPI.Deselect"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
			//	objSeleniumEvents.clickButton(objKPIDeselectAllBtn);
				WebElement objSelectAllItemBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPI.SelectAll"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objSelectAllItemBtn);
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:select default items WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnKPIItem(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> KpiItemsOnSlider = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPISliderName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement KPIItem: KpiItemsOnSlider) {
				if(KPIItem.getText().contains("Profit Before Tax £")) {
					KPIItem.click();
					break;
				}
				
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI Item not found in Slider");
			throw new Exception();
			} 
		}
	public void clickOnSliderBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objSliderBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.SliderKPIBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objSliderBtn);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Slider btn not found");
			throw new Exception();
			} 
		}
	public void clickOnSliderKPIItem(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objKPiName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPIName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objKPiName);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI in slider not found");
			throw new Exception();
			} 
		}
	public void ValidateSelectedItemGraphSection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objItemBarGraphSection = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPIItemGraph"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			if(objItemBarGraphSection!= null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Item Bar Graph is appearing for KPI");
			}
			else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Item Bar Graph is not appearing for KPI");
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Item Bar Graph webelement is not appearing for KPI");
			throw new Exception();
			} 
		}
	
	public void ValidateSelectedItemCalcSection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objItemCalcHeader = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPIItemCalc"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			if(objItemCalcHeader.getText().contains("Calculation")) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Item Calculation is appearing for KPI");
			}
			else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Item Calculation is not appearing for KPI");
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Item Calculation webelement is not appearing for KPI");
			throw new Exception();
			} 
		}
	public void closeKPIItemPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objKPiItemPageCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPIItemPageClose"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objKPiItemPageCloseBtn);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI items close page WebElement not found");
			throw new Exception();
			} 
		}
	public void selectGridSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objGridBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPIGridBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objGridBtn);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Grid view Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void validateKpiInGrid(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> KpiItemsOnGrid = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPIGridName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement KPIItem: KpiItemsOnGrid) {
				if(KPIItem.getText().contains("Service Retail Net Sales")) {
					KPIItem.click();
					break;
				}
				
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: KPI's are appearig fine in Grid view");
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI Item not found in Grid");
			throw new Exception();
			} 
		}
	public void clickOnGridKpi(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objGridkpi = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.GridKPIName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objGridkpi);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Grid kpi WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnDeptOverviewSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDeptKPISettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.DeptKPISettingBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objDeptKPISettingBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dept KPI Setting btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnDeptBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDeptBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.DeptInDeptOverview"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objDeptBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dept btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnAnotherDept(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDeptBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.SelectDept"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objDeptBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dept btn WebElement not found");
			throw new Exception();
			} 
		}
	public void validateSumaryDeptKpi(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objSummaryDeptKPI = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.SummaryDeptKpi"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			if(objSummaryDeptKPI.getText().contains("Profit Before Tax £")) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: KPI is appearing in Summary dept overview");
			}
			else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI is not appearing in Summary dept overview");
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Summary dept KPI in dept overview webelement is not found");
			throw new Exception();
			} 
		}
	public void validateDeptKpi(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			try {
			WebElement objDefaultDeptKPI = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.DefaultDeptKpiNiss"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			String DefaultDeptKPIName = objDefaultDeptKPI.getText();
			if(objDefaultDeptKPI!= null) {
			}else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Default Dept kpi's not found");
			}
			}
			catch (Exception e) {
				WebElement objDefaultSystemKpi = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.DefaultDeptKpiStel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
				String AlternateDefaultDeptKPIName = objDefaultSystemKpi.getText();
				if(objDefaultSystemKpi!= null) {
				}else {
					Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Default Dept kpi's not found");
			}	
		}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Default Dept kpi's not found");
			throw new Exception();
			} 
		}
	public void validateVehicleSaleDeptKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objWehicleSaleDeptKPI = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.VehicleSaleDeptKpi"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			if(objWehicleSaleDeptKPI.getText().contains("Total New Retail Car Units")) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: KPI is appearing in Vehicle sale dept overview");
			}
			else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI is not appearing in Vehicle sale dept overview");
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Vehicle sale KPI in dept overview webelement is not found");
			throw new Exception();
			} 
		}
	
	public void clickOnDeptDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDeptDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.DeptDropdownBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objDeptDropdownBtn);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dept dropdown btn WebElement not found");
			throw new Exception();
			} 
		}
	
	public void clickOnAnotherDeptInDeptDropDown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objAnotherDept = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.DeptDropdownMenu"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
			objSeleniumEvents.clickButton(objAnotherDept);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Dept name not found in Dept dropdown");
			throw new Exception();
			} 
		}
	public void ClickOnCalculationBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objcalcBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.CalculationBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objcalcBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Calculation btn WebElement not found");
			throw new Exception();
			} 
		}
	public void ClickOnCalculationPageCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objcalcCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.CalcPageCloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objcalcCloseBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Calculation tab open successfully");
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Calculation close btn WebElement not found");
			throw new Exception();
			} 
		}
	public void validateKPIGraphLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver,String DefaultDeptKPIName,String AlternateDefaultDeptKPIName) throws Exception {
		try {
			
			objAutomationObjects.objLogger.logInfo("", false);
			try {
			WebElement objKPIGraphLabelOne = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPIGraphLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			if(objKPIGraphLabelOne.getText().contains(DefaultDeptKPIName) ||objKPIGraphLabelOne.getText().contains(AlternateDefaultDeptKPIName)) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: KPI Graph Label is appearing in bar Graph");
			}
			else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI Graph Label is not appearing in bar Graph");
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
				WebElement objKPIGraphLabelTwo = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPIGraphLabelTwo"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
				if(objKPIGraphLabelTwo.getText().contains(DefaultDeptKPIName) ||objKPIGraphLabelTwo.getText().contains(AlternateDefaultDeptKPIName)) {
					Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: KPI Graph Label is appearing in bar Graph");
				}
				else {
					Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI Graph Label is not appearing in bar Graph");
				}
				objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}	
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI Graph Label webelement is not found");
			throw new Exception();
			} 
		}
	
	public void validateSecondKPIGraphLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver,String SecondDeptKPIName, String SecondAlternateDeptKPIName) throws Exception {
		try {
			
			objAutomationObjects.objLogger.logInfo("", false);
			try {
			WebElement objKPIGraphLabelOne = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPIGraphLabelOne"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			if(objKPIGraphLabelOne.getText().contains(SecondDeptKPIName) ||objKPIGraphLabelOne.getText().contains(SecondAlternateDeptKPIName)) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: KPI Graph Label is appearing in bar Graph");
			}
			else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI Graph Label is not appearing in bar Graph");
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
			catch (Exception e) {
				WebElement objKPIGraphLabelTwo = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPIGraphLabelTwo"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
				if(objKPIGraphLabelTwo.getText().contains(SecondDeptKPIName) ||objKPIGraphLabelTwo.getText().contains(SecondAlternateDeptKPIName)) {
					Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: KPI Graph Label is appearing in bar Graph");
				}
				else {
					Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI Graph Label is not appearing in bar Graph");
				}
				objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI Graph Label webelement is not found");
			throw new Exception();
			} 
		}
	public void slectDifferentKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			try {
			WebElement objAnotherDeptKPI = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.DeptKpiNiss"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objAnotherDeptKPI);
			String SecondDeptKPIName = objAnotherDeptKPI.getText();
			}
			catch (Exception e) {
				WebElement objAnotherDeptKpi1 = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.DeptKpiStel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objAnotherDeptKpi1);
				String SecondAlternateDeptKPIName = objAnotherDeptKpi1.getText();	
		}
		}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Default Dept kpi's not found");
			throw new Exception();
			} 
		}
	public void clickOnDefaultDeptInDeptDropDown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDefaultDeptInDeptOverview = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.DefltDeptInDeptOver"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objDefaultDeptInDeptOverview);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Default dept not found in Dept dropdown");
			throw new Exception();
			} 
		}
	public void clickOnSummaryDeptKpi(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objsummaryDeptKpiBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.SummaryDeptKpi"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objsummaryDeptKpiBtn);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:summary Dept Kpi btn WebElement not found");
			throw new Exception();
			} 
		}
	public void validateSecondKPIGraphLabel1(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objSecondKPIGraphLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.KPIGraphLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			if(objSecondKPIGraphLabel.getText().contains("Absorption %")) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: KPI Graph Label is appearing in bar Graph");
			}
			else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI Graph Label is not appearing in bar Graph");
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI Graph Label webelement is not found");
			throw new Exception();
			} 
		}
	public void clickOnSliderDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objSliderDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.SliderDownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor jseElement = (JavascriptExecutor)objDriver;
			jseElement.executeScript("arguments[0].click()", objSliderDownloadBtn);	
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			//objSeleniumEvents.clickButton(objSliderDownloadBtn);
			//objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Slider download btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnGraphDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objGraphDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.GraphDOwnloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objGraphDownloadBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Graph Download Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnReportDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objReportDownloadExcelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.ReportDownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objReportDownloadExcelBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report Download Excel Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnReportPdfDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objReportDownloadPdfBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.ReportPdfDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objReportDownloadPdfBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report Download Pdf Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void switchToPdfReportPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false); 
			String parentWindow = objDriver.getWindowHandle();
			
			Set<String> windows = objDriver.getWindowHandles();
			
			for(String window : windows) {
				if(!window.equals(parentWindow)) {
					objDriver.switchTo().window(window);
				}
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Driver is not moved to authorise page");
			throw new Exception();
			} 
		}
	public void switchToDealerDashboardPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false); 
			String currentWindow = objDriver.getWindowHandle();
			objDriver.close();
			
			Set<String> windows = objDriver.getWindowHandles();
			for(String window : windows) {
				if(!window.equals(currentWindow)) {
					objDriver.switchTo().window(window);
				}
			}
			
			//objDriver.switchTo().window(parentWindow);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Downloading Functionality works fine");
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Driver move back to VHC Page");
			throw new Exception();
			} 
		}
	public void selectMarket(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Dashboard.NetworkHierarchy"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clearTextBox(objNetworkField);
			objSeleniumEvents.writeToTextBox(objNetworkField, "Nissan Italy");
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			objNetworkField.sendKeys(Keys.ENTER);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Network hierarchy field WebElement not found for Market Selection");
			throw new Exception();
			} 
		}
	public void validateNscDashboardPanelHeading(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNscDashboardPanelHeading = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.PanelHeading"), objGenericFunctions.WAITFORPRESENCE_M, objGenericFunctions.SLEEP_S);
			if(objNscDashboardPanelHeading!= null) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Market Nsc dashboard appearing successfully");
			}else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Market Nsc dashboard not appeared as its panel heading is not Displayed");
				throw new Exception("FAIL:Market Nsc dashboard not appeared as its panel heading is not Displayed");
			}
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception();
			} 
		}
	public void clickOnActionMenuBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objActionMenuBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.ActionMenuBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objActionMenuBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Action menu Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnDashboardPageBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDashboardBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.DashboardBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objDashboardBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer Dashboard Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnNetworkDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkDropBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.NetworkDropBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objNetworkDropBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Network Dropdown Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnSelectedMarket(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objNetworkDropBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.Market"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objNetworkDropBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Market name WebElement not found");
			throw new Exception();
			} 
		}

	public void clickOnDealerSubmissionBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			List<WebElement> objActionMenuOption = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.ActionMenuOptions"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement MenuName: objActionMenuOption) {
				if(MenuName.getText().contains("Dealer Dashboard")) {
					MenuName.click();
					break;
				}
				
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Deaaler submission name not found in Dept dropdown");
			throw new Exception();
			} 
		}
	public void clickOnInputFormDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objInputFormDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.InputDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objInputFormDownloadBtn);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Input Form Downloaded successfully");
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Input Form Download Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnSubmissionHistoryBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objSubmissionHistoryDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.SubHistory"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objSubmissionHistoryDownloadBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Submission History Download Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnActionBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objActionBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActionBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			//objSeleniumEvents.clickButton(objActionBtn);
			
			JavascriptExecutor executor = (JavascriptExecutor)objDriver;
			executor.executeScript("arguments[0].click();", objActionBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Action Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void enterActionTitle(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objActionTitleField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActionTitle"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clearTextBox(objActionTitleField);
			objSeleniumEvents.writeToTextBox(objActionTitleField, "Test Action");
			
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Action Title field WebElement not found");
			throw new Exception();
			} 
		}
	public void enterActionConcern(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objActionConcernBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActionConcern"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clearTextBox(objActionConcernBtn);
			objSeleniumEvents.writeToTextBox(objActionConcernBtn, "Test Action");
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Action Concern Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnStartDate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objStartDateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActnStartDate"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objStartDateBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Start Date Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void selectStartDate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objstartDate = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActnFirstDate"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objstartDate);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Start Date WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnTargetDate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objTargetDateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActnTargetdate"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objTargetDateBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Target Date Btn WebElement not found");
			throw new Exception();
			} 
		}
	/*public void selectTargetDate1(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
		/*
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date today = Calendar.getInstance().getTime();
			LocalDateTime.from(today.toInstant()).plusDays(1);
			String date = dateFormat.format(today);
			System.out.println(date);
		*/
			//Date dt = new Date();
			//LocalDateTime.from(dt.toInstant()).plusDays(1);
			//String date1 = dateFormat.format(dt);
			
			/*
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDate dt = LocalDate.parse("20140218", formatter).plusDays(1);
			String date = formatter.format(dt);
			/*
			List<WebElement> DateDays =objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActionCalender"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement DateDay: DateDays) {
				if(DateDay.getText().equals(date)) {
					DateDay.click();
					break;
				}
			}
		
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Target date WebElement not found");
			throw new Exception();
			} 
		}
	*/
	public void selectTargetDate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objTargetDate = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActnTodaydate"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objTargetDate);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Target Date WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnActionCreateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objActionCreateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.CreateAction"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objActionCreateBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Action Create Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnEditBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objActionEditBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActionEditBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			//objSeleniumEvents.clickButton(objActionEditBtn);
			JavascriptExecutor executor = (JavascriptExecutor)objDriver;
			executor.executeScript("arguments[0].click();", objActionEditBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Action Edit Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void enterActionSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objActionSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActionSaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objActionSaveBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Action Save Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void selectActionStatus(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objActionStatusBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActionStatus"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objActionStatusBtn);
			List<WebElement>ActionStatusOptions = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActnStatusOptn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement Status: ActionStatusOptions) {
				if(Status.getText().contains("Completed")) {
					Status.click();
					break;
				}
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Action Status Webelement not found in Dept dropdown");
			throw new Exception();
			} 
		}
	public void clickOnCloseDate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objConfirmSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActionSaveClose"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objConfirmSaveBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Save Confirm Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void selectActionDeleteBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objActionDeleteBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActionDelete"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objActionDeleteBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Action Delete Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnConfirmBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objConfirmDeleteBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerSubManag.ActionDelOkBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objConfirmDeleteBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Confirm Delete Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnAverageDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objAverageDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.AverageBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objAverageDropdownBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Average Dropdown Btn WebElement not found");
			throw new Exception();
			} 
		}
	public void selectAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objAverage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.AverageName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objAverage);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Selected Average WebElement not found");
			throw new Exception();
			} 
		}
	public void clickOnGraphSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objGraphSettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.GraphSettingBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objGraphSettingBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Graph Setting Btn WebElement not found");
			throw new Exception();
			} 
		}

public void validateAverageNameAppearingOnDeptOverview(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		try {
		WebElement objSelectAllItemBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.AverageNameOne"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		if(objSelectAllItemBtn.getText().contains("National Average")) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Selected Average name is appearing on Dashboard");
		}
		else {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Selected Average name is not appearing on Dashboard");
		}
		}
		catch (Exception e) {
			WebElement objKPIDeselectAllBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.AverageNameTwo"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
			if(objKPIDeselectAllBtn.getText().contains("National Average")) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Selected Average name is appearing on Dashboard");
			}
			else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Selected Average name is appearing on Dashboard");
			}
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Average column header WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnChartType(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objChartTypeBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.GraphBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objChartTypeBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Graph Chart Type Btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectBarChartType(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objBarChartType = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.GraphBarType"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objBarChartType);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Bar Chart Type Btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectLineChartType(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLineChartType = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DealerDash.GraphLineType"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objLineChartType);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Line Chart Type Btn WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnKPITableSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiTaleSettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.KPITableSettingBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objKpiTaleSettingBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Table Setting Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAverageSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		try {
		WebElement objSelectAllAverages = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.AvgSelectAllUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objSelectAllAverages);
		}
		catch (Exception e) {
			WebElement objUnselectAllAverages = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.AvgSelectAllCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objUnselectAllAverages);	
			WebElement objselectSingleAverage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.SingleAvgUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objselectSingleAverage);
	}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Averages selelct all checkbox not found");
		throw new Exception();
		} 
	}

public void clickOnSingleAverageSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		try {
		WebElement objSelectAllAverages = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.AvgSelectAllUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objSelectAllAverages);
		}
		catch (Exception e) {
			WebElement objUnselectAllAverages = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.AvgSelectAllCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objUnselectAllAverages);	
			WebElement objselectSingleAverage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.SingleAvgUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objselectSingleAverage);
	}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Averages selelct all checkbox not found");
		throw new Exception();
		} 
	}
public void clickOnDealerSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		try {
		WebElement objSelectAllDealers = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.DealerSelAllUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		JavascriptExecutor executor = (JavascriptExecutor)objDriver;
		executor.executeScript("arguments[0].click();", objSelectAllDealers);
		}
		catch (Exception e) {
			WebElement objUnselectAllDealers = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.DealerSelectAllCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor executor = (JavascriptExecutor)objDriver;
			executor.executeScript("arguments[0].click();", objUnselectAllDealers);
			WebElement objselectSingleDealer = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.SingleDealerUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor executor1 = (JavascriptExecutor)objDriver;
			executor1.executeScript("arguments[0].click();", objselectSingleDealer);
	}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer selelct all checkbox not found");
		throw new Exception();
		} 
	}
public void clickOnSingleDealerSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		try {
		WebElement objSelectAllDealers = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.DealerSelAllUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		JavascriptExecutor executor = (JavascriptExecutor)objDriver;
		executor.executeScript("arguments[0].click();", objSelectAllDealers);
		
		}
		catch (Exception e) {
			WebElement objUnselectAllDealers = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.DealerSelectAllCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor executor = (JavascriptExecutor)objDriver;
			executor.executeScript("arguments[0].click();", objUnselectAllDealers);
			WebElement objselectSingleDealer = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.SingleDealerUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor executor1 = (JavascriptExecutor)objDriver;
			executor1.executeScript("arguments[0].click();", objselectSingleDealer);
	}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealers selelct all checkbox not found");
		throw new Exception();
		} 
	}
public void clickOnKPISelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		try {
		WebElement objSelectAllKPIs = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.KPISelectAllUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		JavascriptExecutor executor = (JavascriptExecutor)objDriver;
		executor.executeScript("arguments[0].click();", objSelectAllKPIs);
		}
		catch (Exception e) {
			WebElement objUnselectAllKPIs = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.KPISelectAllCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor executor = (JavascriptExecutor)objDriver;
			executor.executeScript("arguments[0].click();", objUnselectAllKPIs);
			WebElement objselectSingleKPI = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.SingleKPIUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor executor1 = (JavascriptExecutor)objDriver;
			executor1.executeScript("arguments[0].click();", objselectSingleKPI);
	}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI's selelct all checkbox not found");
		throw new Exception();
		} 
	}
public void clickOnSingleKPISelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		try {
		WebElement objSelectAllKPIs = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.KPISelectAllUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objSelectAllKPIs);
		JavascriptExecutor executor = (JavascriptExecutor)objDriver;
		executor.executeScript("arguments[0].click();", objSelectAllKPIs);
		}
		catch (Exception e) {
			WebElement objUnselectAllKPIs = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.KPISelectAllCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor executor = (JavascriptExecutor)objDriver;
			executor.executeScript("arguments[0].click();", objUnselectAllKPIs);
			WebElement objselectSingleKPI = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NscDash.SingleKPIUnCheck"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			JavascriptExecutor executor1 = (JavascriptExecutor)objDriver;
			executor1.executeScript("arguments[0].click();", objselectSingleKPI);
	}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI's selelct all checkbox not found");
		throw new Exception();
		} 
	}
public void clickOnDNSSubmitBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDnsSubmitBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.DnsSubmit"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDnsSubmitBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS submit WebElement not found");
		throw new Exception();
		} 
	}
public void validateCloseDatesBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objViewCloseDatesBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmitViewCloseDateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objViewCloseDatesBtn.getText() != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: DNS submit page is Displayed"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: View Close Dates Btn is not found");
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL: Unable to Perform Search");
		} 
	}
public void clickOnPeriodSelectorBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDnsSubmitPeriodBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmitPeriodDropdownBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDnsSubmitPeriodBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS submit period selector Btn WebElement not found");
		throw new Exception();
		} 
	}
public void SelectPeriod(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSelectperiod = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmitPeriodInDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSelectperiod);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Selected period WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPeriodSelectorOKBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPeriodSelectorOKBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmitPeriodSelectOKBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPeriodSelectorOKBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Period Selector is working fine");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Period Selector OK Btn WebElement not found");
		throw new Exception();
		} 
	}


public void clickOnViewCloseDatesBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objViewCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmitViewCloseDateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objViewCloseBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: View Close Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnViewDatesCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objViewDatesCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmitViewDateCloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objViewDatesCloseBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: View Close Dates are appearing fine");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: View Dates Close Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnInputOptionsBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objInputOptionsBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.InputOptionsBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objInputOptionsBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Input Options Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDealerSelectionBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDalerSelectionBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.DealerSelectBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDalerSelectionBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Daler Selection Btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectDealerForInputOptions(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDalerSelection = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.DealerSelection"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDalerSelection);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Daler for input options WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnOkBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerSelectionOkBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmitPeriodSelectOKBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDealerSelectionOkBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Dealer select Ok Btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectInputOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objselectInputOption = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.InputOptionCheckBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objselectInputOption);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Input Options Selected Successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Input Option checkbox WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCarryforwardBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCarryforwardBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.CarryForwardBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCarryforwardBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Carry forward Btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectCarryforwardItem(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCarryforwardItemBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.CarryForwardCheckBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCarryforwardItemBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Carry forward item checkbox selected successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Carry forward item checkbox WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDNSSubmitSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDNSSubmitSavBtnBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.SaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDNSSubmitSavBtnBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Input form saved successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS submit save btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDNSSubmitInputFormCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objInputCLoseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.InputCLoseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objInputCLoseBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XL);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Input Form Close btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnEditInputFormBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objEditInputBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.Start&EditBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objEditInputBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Start & Edit WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnNextDeptBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNextDeptBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.DeptForwardBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNextDeptBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Next dept WebElement not found");
		throw new Exception();
		} 
	}
public void enterUnitValue(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUnitBox = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.InputUnitBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objUnitBox);
		objSeleniumEvents.writeToTextBox(objUnitBox, "1");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unit box WebElement not found");
		throw new Exception();
		} 
	}
public void enterSalesValue(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSalesBox = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.InputSalesBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objSalesBox);
		objSeleniumEvents.writeToTextBox(objSalesBox, "42000");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Sales box WebElement not found");
		throw new Exception();
		} 
	}
public void enterCostValue(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCostBox = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.InputCostBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objCostBox);
		objSeleniumEvents.writeToTextBox(objCostBox, "40500");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Cost box WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnReleaseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objReleaseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.InputReleaseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objReleaseBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Input form released successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Release btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnpublishBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception { 
	
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		try {
		WebElement objNscPublishBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.InputPublishBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objNscPublishBtn);
		}
		catch (Exception e) {
			WebElement objDealerPublishBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSSubmit.InputDealerPublish"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
			objSeleniumEvents.clickButton(objDealerPublishBtn);
		}
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Dealer published successfully");
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Publish btn WebElement not found");
		throw new Exception();
		} 
	
	}
public void switchDriverToFrame(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {

        // objDriver.switchTo().frame(0);
         
        WebElement objSwitchToIframe = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Analysis.Iframe"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
        objDriver.switchTo().frame(objSwitchToIframe);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:driver doesnot switch to iframe");
		throw new Exception();
		}
	}
public void switchDriverToDefaultFrame(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {

		objDriver.switchTo().defaultContent();
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:driver doesnot switch to Default frame");
		throw new Exception();
		} 
	}
public void clickOnDealerProfileBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerProfileBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Admin.Profile"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDealerProfileBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer Profile btn WebElement not found");
		throw new Exception();
		} 
	}
public void validateDealerProfilePanelHeading(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objProfilePanelHeadingText = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSProfile.PanelHeading"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objProfilePanelHeadingText != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Dealer Profile is Displayed"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Dealer Profile Panel Heading Text not found");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL: Dealer profile Panel heading webelement not found");
		} 
	}
public void clickOnDealerDetailsUpdateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerDetailsUpdateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.ProfileSummaryUpdate"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDealerDetailsUpdateBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer summary Update Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnProfileSectionExtendBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objProfileSectionExtendBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Admin.ProfileExpandBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objProfileSectionExtendBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Profile Section Extend Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCheckBoxBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		try {
		WebElement objCheckBox = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSProfile.CheckBoxBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objCheckBox);
		}
		catch (Exception e) {
			WebElement objProfileUpdateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSProfile.UpdateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objProfileUpdateBtn);	
			WebElement objUpdateCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSProfile.UpdateCloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objUpdateCloseBtn);
	}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:checkbox not found");
		throw new Exception();
		} 
	}
public void clickOnUpdateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUpdateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.ProfileDetailUpdate"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUpdateBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Update Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnUpdateCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUpdateCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Maps.successCloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUpdateCloseBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Update close Btn WebElement not found");
		throw new Exception();
		} 
	}
public void MoveBackToDealerPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerPageBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.DNSProfile.DealerPage"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDealerPageBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer page Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAccountMapsBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccountMapsBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.AccountMaps"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAccountMapsBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Account Maps Btn WebElement not found");
		throw new Exception();
		} 
	}
public void validateAccountMapsLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccountMapsPanelHeadingText = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.AccountMap.AccountmapLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objAccountMapsPanelHeadingText != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Account maps page is Displayed"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Account maps page Panel Heading Text not found");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL: Account maps page Panel heading webelement not found");
		} 
	}
public void clickOnNewChartAccountsBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewChartAccountBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.AccountMap.NewChartBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewChartAccountBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:New Chart Account Btn WebElement not found");
		throw new Exception();
		} 
	}
public void enterChartName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewChartName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.AccountMap.ChartNameField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objNewChartName);
		objSeleniumEvents.writeToTextBox(objNewChartName, "Test_COA");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:New chart account field WebElement not found");
		throw new Exception();
		} 
	}
public void selectCOAFile(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		JavascriptExecutor jse = (JavascriptExecutor) objDriver;	
	    jse.executeScript("document.getElementsByTagName('input')[1].style.display = 'block'");
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objselectCOAFile = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.ChartFile"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.writeToTextBox(objselectCOAFile, "D:\\\\Test Cases\\\\COA file\\\\TEST_coa.prn");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:COA file WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnChartOfAccountOkBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewChartAccountOKBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.AccountMap.ChartOKBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewChartAccountOKBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:New Chart Account is created");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:New Chart Account OK Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNewMapBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewMapBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.AccountMap.NewMapBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewMapBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:New Map Btn WebElement not found");
		throw new Exception();
		} 
	}
public void enterMapName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewMapName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.AccountMap.NewMapNameField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objNewMapName);
		objSeleniumEvents.writeToTextBox(objNewMapName, "Test_Map");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:New map name field WebElement not found");
		throw new Exception();
		} 
	}
public void selectCOAName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCoaSelectField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.AccountMap.CoASelectField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objCoaSelectField);
		
		List<WebElement> CoaFilesName = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.AccountMap.CoAFileNames"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement file: CoaFilesName) {
			if(file.getText().contains("Test_COA")) {
				file.click();
				break;
			}
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Coa file name WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnNewMapCreateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewMapCreateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.NewMapCreateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewMapCreateBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:New Map created successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:New Map create Btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnAccountMapName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccountMapName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.MapActionBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAccountMapName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Account Map name WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnIgniteAccountMapName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);

	List<WebElement> AccountMapRows = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.MapsRows"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	for(WebElement   Row:AccountMapRows ) {
	    System.out.println("Account maps row name......................" + Row);
			
			List<WebElement> MapNameColumn = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.MapRowColumn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			for(WebElement Name:MapNameColumn ) {
				System.out.println("Account maps Column name......................" + Name);
				if(Name.getText().contains("Test_Map")) {
					System.out.println("Text of column..........................." + Name);
					WebElement MapName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.ActionBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
					MapName.click();
					objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
					System.out.println("Clicked btn of map..........................." + MapName);
					break;
			}
				break;
		}
		}
	}

	
	
	
	
	//////////////////////////////////////
	/*
	public void validateAbbreviationInformationAtInformationWindow(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver,String strColumnOneInFeatureFile, String strSecondColumnInFeatureFile) throws Exception
	{
	 try {
	 	 objAutomationObjects.objLogger.logInfo("", false);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XXS);
	     boolean  foundMatchingPartInfo=false;
	     List<WebElement> ObjRows=objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("EPC5H.Abbreviation.Information.Window.Rows"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			 if(ObjRows.size()==0) 
			 {
				objAutomationObjects.objTestResult.prepareResultCollection("Fail: SOA Information Window has no row.");
			 }
			 else
			 {
				for (WebElement objrow : ObjRows)
				 {
					try {
					WebElement objWEPartNumber= objrow.findElement(objAutomationObjects.objObjectMAP.getLocator("EPC5H.Abbreviation.Information.First.Column")); 	
					if (objWEPartNumber.getText().equalsIgnoreCase(strColumnOneInFeatureFile))
					 {	

						 WebElement objWEPartDescription= objrow.findElement(objAutomationObjects.objObjectMAP.getLocator("EPC5H.Abbreviation.Information.Second.Column")); 	
						 if (objWEPartDescription.getText().replaceAll("\\s","").replaceAll("\"", "").equalsIgnoreCase(strSecondColumnInFeatureFile.replaceAll("\\s","").replaceAll("\"", "")))
						 {
							 objAutomationObjects.objTestResult.prepareResultCollection("Pass: [V] Matching Abbreviation in first column: "+strColumnOneInFeatureFile+" and second column :"+strSecondColumnInFeatureFile+" found in Information window");
							 foundMatchingPartInfo=true;
							 break;
						 } 
					 }
					}catch(Exception e)
					{
						//do nothing
					}
				 }
				if(!foundMatchingPartInfo)
				{
					 objAutomationObjects.objTestResult.prepareResultCollection("Fail: [V] Matching Abbreviation in first column: "+strColumnOneInFeatureFile+" or second column :"+strSecondColumnInFeatureFile+" not found in Information window");
				}
			 }
		}
	
	
	*/
	/////////////////////////////////////////
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Coa file name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAccountMapEditBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccountMapEditBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.EditBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAccountMapEditBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Account Map opened for edit");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Account Map Edit btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnAccountMapEditCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccountMapEditCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.AccountMap.EditCloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAccountMapEditCloseBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Account Map Closed successfully");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Account Map Edit close btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnAccountMapDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccountMapDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.DownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAccountMapDownloadBtn);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Account Map download btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnAccountInputOrderBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccountInputOrderBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.InputOrder"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAccountInputOrderBtn);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Account input order btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnAccountMapDownloadOKBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccountMapDownloadOKBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.OKBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAccountMapDownloadOKBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Account Map Downloaded");
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Account Map Download ok btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnAccountMapDeleteBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccountMapDeleteBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.DeleteBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAccountMapDeleteBtn);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Account Map delete btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnAccountDeleteOkBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccountMapDeleteOkBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.DeleteOKBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAccountMapDeleteOkBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Account Map deleted Successfully");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Account Map delete ok btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnPublishedReportBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNissanPublishedReportBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Reports.PublishReportsBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objNissanPublishedReportBtn);
	
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Published report Btn not found");
		throw new Exception();
		} 
	}
public void ValidatePublishedReportLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPublishedReportText = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.PageLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objPublishedReportText != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Published Report is Displayed"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Published Report Text not found");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Published report Panel heading webelement not found");
		} 
	}
public void ClickOnReportDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objReportDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.ReportDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objReportDropdownBtn);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report Dropdown Btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectReport(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> reportName = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.PublishReportOptions"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement report: reportName) {
			if(report.getText().contains("All Dealer Reports") || report.getText().contains("All Reports")) {
				report.click();
		
				break;
			}
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: published report name WebElement not found");
		throw new Exception();
		} 
	}

public void ClickOnPeriodDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPeriodDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.PeriodDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPeriodDropdownBtn);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Period Dropdown Btn WebElement not found");
		throw new Exception();
		} 
	}
public void SelectPeriodSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> PeriodName = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.PeriodTypes"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement period: PeriodName) {
			if(period.getText().contains("All Periods")) {
				period.click();
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Period Selected successfully");
				break;
			}
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Periods name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPdfBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPdfBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.PdfDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPdfBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Pdf download Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnExlBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objExlBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.XLDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objExlBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Report Exl format downloaded");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Exl download Btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectPdfReportForZip(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPdfSelectionBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.PdfUnSelect"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPdfSelectionBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Report Pdf format downloaded");
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Pdf Selection Btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectExlReportForZip(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objExlSelectionBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.XLUnSelect"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objExlSelectionBtn);	
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:xl selection Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnZipBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objZipBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.ZipDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objZipBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Report Zip folder downloaded");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Zip Btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnFlexibleReportBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objFlexibleReportBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Reports.FlexibleReportsBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objFlexibleReportBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Flexible report Btn not found");
		throw new Exception();
		} 
	}
public void ValidateFlexibleReportLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objFlexibleReportText = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.PageLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objFlexibleReportText != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Flexible Report is Displayed"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Flexible Report Text not found");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Flexible report Panel heading webelement not found");
		} 
	}
public void ClickOnFlexibleReporDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objFlexibleReportDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.ReportDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objFlexibleReportDropdownBtn);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Flexible Report Dropdown Btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectSuperflexReport(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> ReportsName = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.ReportsName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement Report: ReportsName) {
			if(Report.getText().contains("SUPERFLEX")) {
				Report.click();
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Superflex report selected successfully");
				break;
			}
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Reports name WebElement not found");
		throw new Exception();
		} 
}
public void DealerEditBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerEditBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.DealerEdit1"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDealerEditBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: First Dealer selection edit btn WebElement not found");
		throw new Exception();
		} 
	}
public void SelectDealerForSuperflex(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.FlexReportDealerField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objDealerField);
		objSeleniumEvents.writeToTextBox(objDealerField, "A50011");
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Dealer field WebElement not found");
		throw new Exception();
		} 
	}
public void SelectMeasureForSuperflex(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMeasureBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.MeasureField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
		objSeleniumEvents.clickButton(objMeasureBtn);
		List<WebElement> MeasureDropdown = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.MeasureTypes"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement Measure: MeasureDropdown) {
			if(Measure.getText().contains("MTD") || Measure.getText().contains("Month") ) {
				Measure.click();
				break;
			}
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Measures WebElement in measure dropdown are not found");
		throw new Exception();
		} 
	}
public void SelectPeriodForSuperflex(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPeriodBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.PeriodField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
		objSeleniumEvents.clickButton(objPeriodBtn);
		List<WebElement> PeriodName = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.PeriodName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement period: PeriodName) {
			if(period.getText().contains("Use application setting")) {
				period.click();
				break;
			}
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Periods name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnFlexibleSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objFlexibleOKBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.SaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objFlexibleOKBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Selection saved successfully");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_M);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Flexible ok btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnConfirmOkBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objConfirmOKBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Analysis.DeleteConfirm"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objConfirmOKBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Confirm Btn WebElement not found");
		throw new Exception();
		} 
	}

public void DealerCancelBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerCancelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.DealerDelete"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDealerCancelBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer cancel btn WebElement not found");
		throw new Exception();
		} 
	}

public void validateDealerColumnText(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerColumnLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.BlankDealer"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objDealerColumnLabel.getText().contains("Column")) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Dealer Remove successfully");
		}
		else {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer not Remove");
		}
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer column webelement is not found");
		throw new Exception();
		} 
	}
public void clickOnSuperflexDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSuperflexDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.DeptDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSuperflexDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Superflex Dropdown btn WebElement not found");
		throw new Exception();
		} 
	}

public void selectSuperflexDept(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> DeptName = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.DeptNames"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement dept: DeptName) {
			if(dept.getText().contains("Summary")) {
				dept.click();
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Report page selected");
				break;
			}
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report page name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnSuperflexReportDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSuperflexDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.DownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSuperflexDownloadBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Superflex report downloaded successfully");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Superflex download btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnSecondDealerEditBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSecondDealerEditBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.DealerEdit2"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSecondDealerEditBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Second Dealer selection edit btn WebElement not found");
		throw new Exception();
		} 
	}
public void SelectSecondDealerForSuperflex(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSecondDealerField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.FlexReportDealerField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objSecondDealerField);
		objSeleniumEvents.writeToTextBox(objSecondDealerField, "A12345");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Second Dealer field WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDnsAnalysisBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAnalysisBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.DNSanalysis"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAnalysisBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Analysis btn WebElement not found");
		throw new Exception();
		} 
	}
public void DnsAnalysisPageLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAnalysisLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AnalysisPageLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objAnalysisLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Analysis page label is Displayed"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Analysis page label not found");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Analysis Panel heading webelement not found");
		} 
	}
public void clickOnAnalysisMarketDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMarketDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AnalysisMarketDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMarketDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Market dropdown btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectAnalysisMarket(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMarketSelection = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.MarketName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMarketSelection);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Market selected successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Market name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAnalysisToolsDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objToolsSelection = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.ToolsDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objToolsSelection);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Tools dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAnalysisToolsName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objToolsSelection = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Analysis.SelectionTool"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objToolsSelection);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Analysis Selection Tool selected");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Selection Tool name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnGridBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objGridBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.GridBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objGridBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Grid Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnGridName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objGridType = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.GridName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objGridType);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Grid Type WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCreateGridBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objGridCreateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.GridCreateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objGridCreateBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Grid selected for Analysis");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Grid Create WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnItemRowBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objItemBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Analysis.ItemDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objItemBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Item row WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAddByNameBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAddByNameBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.AddByName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAddByNameBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Add by name WebElement not found");
		throw new Exception();
		} 
	}
public void enterItemName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAddNameField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.NameField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objAddNameField);
		String ItemName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("ItemNameInAnalysis");
		objSeleniumEvents.writeToTextBox(objAddNameField, ItemName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Add name field WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnItemAddBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAddBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.ItemAddBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAddBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Add WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnAddRnumBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objItemAddByRnumBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.Rnum"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objItemAddByRnumBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Add item By Rnum WebElement not found");
		throw new Exception();
		} 
	}
public void enterRnum(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		//objSeleniumEvents.enter
		WebElement objAddRnumField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.RnumField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAddRnumField);
		objSeleniumEvents.writeToTextBox(objAddRnumField, "102");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Add Rnum field WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAnalysisUpdateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAddRnumField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.UpdateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAddRnumField);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Grid Updated Successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Analysis Update WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAddByReportPickerBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAddReportPicker = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.AddByPicker"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAddReportPicker);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Add By report picker WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPickerDeptDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objReportPickerDeptDropdownOne = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Analysis.ReportPickDept"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objReportPickerDeptDropdownOne);	
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report picker dept dropdown Btn not found");
		throw new Exception();
		} 
	}
public void clickOnPickerDeptName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objReportPickerDeptName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.PickDeptName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objReportPickerDeptName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report picker dept name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPickerItem(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objReportPickerItem = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.PickerItem"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objReportPickerItem);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report picker item WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPeriodDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPeriodDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Period.Dropdwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPeriodDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Period dropdown WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnAnalysisPeriodDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPeriodDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Analysis.PeriodDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPeriodDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Analysis Period dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAddByHierarchyBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAddByHierarchyBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Period.Hierarchy"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAddByHierarchyBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Add By Hierarchy WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnYearDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objYearDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Period.YearDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objYearDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Year dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnMonthBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMonthBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Period.Month"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMonthBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Month WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNetworkDropdown1(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNetworkDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.NetworkDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNetworkDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Network Dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void enterDealerName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNameField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.NetworkField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objNameField);
		String AnalysisDealerName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("DealerNameInAnalysis");
		objSeleniumEvents.writeToTextBox(objNameField, AnalysisDealerName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Add name field WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnMeasureDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMeasureDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.MeasureDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMeasureDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Measure Dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnMeasureType(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMeasureType = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.MeasureType"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMeasureType);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Measure type WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnGridExcelBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objExcelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.ExcelDownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objExcelBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Excel WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDataBulkExcelBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objExcelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.BulkDataExcelBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objExcelBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Excel WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnSelectionsExcelBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSelectionsExcelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.SelectionsExcelBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSelectionsExcelBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Analysis selection downloaded in excel file");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Excel WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnBulkDataExcelBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSelectionsExcelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.BulkDataExcelBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSelectionsExcelBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Analysis Bulk data selection downloaded in excel file");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Excel WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnSubsetsBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSubsetsBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.SubSetBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSubsetsBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Subsets Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnSubsetsItem(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSubsetsItem = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.SubSettem"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSubsetsItem);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Subsets item WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPickerItemAddBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPickerItemAddBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.PickerAddBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPickerItemAddBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Picker item add btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPeriodAddBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPeriodItemAddBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.Item.PeriodAddBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPeriodItemAddBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Period item add btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCustomCompositeToolBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCustomCompositeBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.CustomComposite"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCustomCompositeBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Custom composite tool btn WebElement not found");
		throw new Exception();
		} 
	}
public void enterCompositeName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCustomCompositeNameBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.CustomCompName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCustomCompositeNameBtn);
		objSeleniumEvents.clearTextBox(objCustomCompositeNameBtn);
		String CustomCompositeName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("CustomCompositeName");
		objSeleniumEvents.writeToTextBox(objCustomCompositeNameBtn, CustomCompositeName);
		
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Custom composite name field WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCompositeStartDateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCompositeStartDateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.CustomStartDateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCompositeStartDateBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Custom composite start date btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectCompositeStartDate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCompositeStartDate = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.CustomStartDate"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCompositeStartDate);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Custom composite start date WebElement not found");
		throw new Exception();
		} 
	}
public void selectCompositeEndDate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCompositeEndDate = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.CustomEndDate"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCompositeEndDate);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Custom composite end date WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCompositeEndDateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCompositeEndDateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.CustomEndDateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCompositeEndDateBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Custom composite end date btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCustomCompositeDealerBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCompositeDealerBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.CustomDealerBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCompositeDealerBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Custom composite dealer btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCreateCustomCompositeBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCreateCustomCompositeBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.CustomCreateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCreateCustomCompositeBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Create Custom composite btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCalculateCustomCompositeBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCalculateCustomCompositeBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.CustomAvgCreateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCalculateCustomCompositeBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Calculate Custom composite btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCompositeShareBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCompositeShareBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.CustomShareBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCompositeShareBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Custom composite share btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCustomCompositeDeleteBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCompositeDeleteBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.CustomDeleteBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCompositeDeleteBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Custom composite Deleted successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Custom composite Delete btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDataBulkToolsName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDataBulktoolBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.BulkDataToolBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDataBulktoolBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Data bulk tool selected successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Data bulk tool btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDataBulkMeasureBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDataBulkMeasureBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.BulkDataMeasureDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDataBulkMeasureBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Data bulk measure btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPageFormatBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPageFormatBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.BulkDataDealerRowBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPageFormatBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Page Format btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectColumnBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPageColumnBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.BulkDataColumnBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPageColumnBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Column btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectColumnFormatBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> PageFormatList = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.BulkDataRowOption"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement Type: PageFormatList) {
			if(Type.getText().contains("Column(s)")) {
				Type.click();
				break;
			}
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:column option webelement not found");
		throw new Exception();
		} 
	}
public void clickOnDataBulkDealerBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement DataBulkDealerBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.BulkDataDealerBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(DataBulkDealerBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Data Bulk Dealer Btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectRowFormatBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> PageFormatList = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.BulkDataRowOption"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement Type: PageFormatList) {
			if(Type.getText().contains("Row")) {
				Type.click();
				break;
			}
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Row option webelement not found");
		throw new Exception();
		} 
	}
public void clickOnDataBulkItemBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement DataBulkItemBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.BulkDataItemBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(DataBulkItemBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Data Bulk item Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDataBulkPeriodBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement DataBulkPeriodBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.BulkDataPeriodBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(DataBulkPeriodBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Data Bulk Period Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnBmServiceOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement BMServiceOption = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Login.BMAppSelection"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(BMServiceOption);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:BMService Option WebElement not found");
		throw new Exception();
		} 
	}
public void validateDashboardLandingPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Dashboard.UserSetting"), objGenericFunctions.WAITFORPRESENCE_M, objGenericFunctions.SLEEP_S);
		if(objLabel!= null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:User Successfully Login into application dashboard");
		}else {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: User not at Dashboard page as its label is not Displayed");
			throw new Exception("FAIL: User not at Dashboard page as its label is not Displayed");
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception();
		} 
	}
public void clickOnSubmissionManagerBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNscSubmissionManagerBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.SubmissionManager"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNscSubmissionManagerBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NscSubmission ManagerBtn WebElement not found");
		throw new Exception();
		} 
	}
public void validateSubmissionManagerPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNSCSubmissionManagerPageText = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerNSCDownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objNSCSubmissionManagerPageText != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Submission Manager Page is open"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Submission Manager Page text not found");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Submission Manager Page heading webelement not found");
		} 
	}
public void clickOnNscSubmissionMarketDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNscSubmissionManagerMarketDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerMarketSelectBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNscSubmissionManagerMarketDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NscSubmission Manager market dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void selectNSCSubmissionMarket(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> NSCManagerMarkets = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerMarkets"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement market: NSCManagerMarkets) {
			if((market.getText().contains("ITALY"))||(market.getText().contains("Italy"))) {
				market.click();
				break;
			}
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NSCSubmission Market list webelement not found");
		throw new Exception();
		} 
	}
public void clickOnSubmissionManagerUpdateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNscSubmissionManagerUdateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerUpdateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNscSubmissionManagerUdateBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Market/Period selected successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NscSubmission Manager update btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNscSubmissionPeriodDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNscSubmissionManagerPeriodDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerPeriodBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNscSubmissionManagerPeriodDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NscSubmission Manager period dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void selectNSCSubmissionPeriod(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> NSCManagerPeriods = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerMarketPeriods"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement period: NSCManagerPeriods) {
			if(period.getText().contains("01-2024")) {
				period.click();
				break;
			}
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NSCSubmission period list webelement not found");
		throw new Exception();
		} 
	}
public void clickOnNscSubmissionDealerDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNscSubmissionManagerDealerDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerDealerSelection"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNscSubmissionManagerDealerDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NscSubmission Manager Dealer dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnSubmissionDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSubmissionDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerNSCDownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSubmissionDownloadBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NscSubmission download btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectNSCSubmissionDealer(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> NSCManagerDealers = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerDealers"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement dealer: NSCManagerDealers) {
			try {
			dealer.click();
			WebElement objDealerPeriodWebElement = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerPeriodSelection"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
			if(objDealerPeriodWebElement != null) {
				break;
			}
			}
			catch(Exception e) {
			//	continue;
				break;
			}
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NSCSubmission period list webelement not found");
		throw new Exception();
		} 
	}
public void selectNSCSubmissionDealerForDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> DealerSubmission = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerDealers"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement dealer: DealerSubmission) {
			if(dealer.getText().contains("F10032")) {
				dealer.click();
				break;
			}
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NSCSubmission Dealer list webelement not found");
		throw new Exception();
		} 
	}
public void selectDealerSubmissionPeriod(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerPeriodWebElement = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerPeriodSelection"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objDealerPeriodWebElement);
		List<WebElement> DealerSubmissionPeriods = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerDealerPeriods"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		int TotalPeriodCount = DealerSubmissionPeriods.size(); 
		System.out.println("Total dealer count" + TotalPeriodCount);
		int PeriodCount = DealerSubmissionPeriods.indexOf(DealerSubmissionPeriods);
		System.out.println("dealer count" + PeriodCount);
		for(WebElement period: DealerSubmissionPeriods) {
		 if(TotalPeriodCount-14 == PeriodCount) {
			//if(period.getText().contains("Jan 2023")) {
				period.click();
				break;
			}
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer Submission period list webelement not found");
		throw new Exception();
		} 
	}
public void clickOnDealerSubmissionDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerExcelDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NSCSubManagerDealerDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDealerExcelDownloadBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Selected Dealer input form downloaded");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer Submission excel btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastToolBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDNSForecastBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.forecastBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDNSForecastBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNSForecast btn WebElement not found");
		throw new Exception();
		} 
	}
public void validateDNSForecastPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDNSForecastPageText = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Filter.Dropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objDNSForecastPageText != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:DNS Forecast Page is open"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS Forecast Page text not found");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:DNS Forecast Page heading webelement not found");
		} 
	}
public void clickOnForecastBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.CreateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNSForecast create btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserNameField= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.NameField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objUserNameField);
		String UserName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Forecast.Name");
		objSeleniumEvents.writeToTextBox(objUserNameField, UserName);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNSForecast name btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnHistoryDataDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastHistoryDataDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.HistoryDataDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastHistoryDataDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast History Data Dropdown btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectHistoryData(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastHistoryData = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.HistoryDataPeriod"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastHistoryData);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast History Data btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectCurrencyType(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCurrencyType = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.LocalCurrencyBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCurrencyType);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Local currency btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectForecastPrivate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastType = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.PrivateForecastBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastType);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Private forecast btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnSeasonality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastSeasonalityDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.SeasonalityDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastSeasonalityDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast Seasonality Dropdown btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectSeasonality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastSeasonality = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.SeasonalityPeriod"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastSeasonality);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast Seasonality btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCreateForecastBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCreateForecastBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.CreateForecastBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCreateForecastBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Create Forecast btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.ClosetBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastCloseBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast close btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastOpenBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objOpenForecastBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.OpenBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objOpenForecastBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Open Forecast btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.SaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastSaveBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast Save btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnSaveOKBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastSaveOkBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.SaveOkBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastSaveOkBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast Save Ok btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastSaveASBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastSaveASBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.SaveAsBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastSaveASBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast Save AS btn WebElement not found");
		throw new Exception();
		} 
	}
public void enterForecastNewName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewName= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.SaveAsNameField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objNewName);
		String Name = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Forecast.SaveAsName");
		objSeleniumEvents.writeToTextBox(objNewName, Name);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	    objAutomationObjects.objLogger.logErrorWithException(e);
        Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Forecast new name field");
        throw new Exception();
	}  
}
public void clickOnForecastNewNameSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastNameSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.NameSaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastNameSaveBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast Name Save btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastResetBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastResetBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.ResetBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastResetBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast Reset btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastExcelBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastExcelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.ExcelBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastExcelBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast excel btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastExitBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastExitBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Forecast.ForecastExitBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastExitBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast exit btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastNextYearBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastNextYearBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.NextYearBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastNextYearBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast next year WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNextYearForecastNameBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewName= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.NextForecastName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objNewName);
		String Name = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Forecast.NextForecastName");
		objSeleniumEvents.writeToTextBox(objNewName, Name);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	    objAutomationObjects.objLogger.logErrorWithException(e);
        Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Forecast new name field");
        throw new Exception();
	}  
	}

public void clickOnDNSPlanBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDNSPlanBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.PlanBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDNSPlanBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS Plan btn WebElement not found");
		throw new Exception();
		} 
	}
public void validateDNSPlanPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDNSPlanPageText = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.PlanPageTitle"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objDNSPlanPageText != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:DNS plan Page is open"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS plan Page text not found");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:DNS plan Page heading webelement not found");
		} 
	}
public void clickOnDNSPlanYearSelectionDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDNSPlanYearDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.PlanTypeDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDNSPlanYearDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS Plan year dropdown btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectPlanYear(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDNSPlanYearBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.PlanTypeBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDNSPlanYearBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS Plan year btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanYearSelectionOKBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDNSPlanOkBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.PlanYearOKBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDNSPlanOkBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS Plan year ok btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCreateNewPlanBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCreateNewPlanBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.CreateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCreateNewPlanBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Create New Plan btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnDisclaimerBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDisclaimerBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.DisclaimerAceptBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDisclaimerBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS Plan Disclaimer accept btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDealerSeedingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerSeedingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.DealerSeedingDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDealerSeedingBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer seeding btn WebElement not found");
		throw new Exception();
		} 
	}
public void SelectDealerSeedingPeriod(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDealerSeedingPeriodBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.DealerSeedingPeriod"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDealerSeedingPeriodBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer Seeding Period Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanStartingMonthBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanStartingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.StartMonthDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanStartingBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan Starting month btn WebElement not found");
		throw new Exception();
		} 
	}
public void SelectPlanStartingMonth(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanStartingPeriod = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.StartMonthPeriod"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanStartingPeriod);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan Starting month WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanStartingYearBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanStartingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.StartYearDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanStartingBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan Starting month btn WebElement not found");
		throw new Exception();
		} 
	}
public void SelectPlanStartingYear(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanStartingPeriod = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.StartYearPeriod"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanStartingPeriod);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan Starting month WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAversgeSeedingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAverageSeedingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.AvgSeedingDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAverageSeedingBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Average Seeding btn WebElement not found");
		throw new Exception();
		} 
	}
public void SelectAverageSeedingPeriod(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAverageSeedingPeriod = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.AvgSeedingPeriod"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAverageSeedingPeriod);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Average seeding Period WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanMenuBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanMenuBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.MenuBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanMenuBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan menu btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.Menu.SaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanSaveBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan savce btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanNameSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanNameSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.SaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanNameSaveBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan Name save WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanSaveOkBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanSaveOkBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.SaveOkBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanSaveOkBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan save ok WebElement not found");
		throw new Exception();
		} 
	}
public void enterPlanName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.NameField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objPlanName);
		String PlanName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("DNSplanNewName");
		objSeleniumEvents.writeToTextBox(objPlanName, PlanName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan name field WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnScreenForwardBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objScreenForwardBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.PlanScreenForwardBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objScreenForwardBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Screen forward btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectAverageForPlan(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAVerageDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.ScrrenAvgDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAVerageDropdown);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		WebElement objAVerageName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.ScreenAVgSelect"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAVerageName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Screen Average WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnScreenBackwardBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objScreenBackwardBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.PlanScreenBackBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objScreenBackwardBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Screen Backward btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnScreenSelectBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objScreenSelectBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.PlanSelectScreenBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objScreenSelectBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Screen select btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnFirstScreenNameBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objScreenNameBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.PlanScreenNameBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objScreenNameBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Screen name btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanExcelBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanExcelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.ExcelBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanExcelBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan excel btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanPdfBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanPdfBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.PdfBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanPdfBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan Pdf btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanCLoseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.CLoseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanCLoseBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan close btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanLockBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanLockBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.LockBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanLockBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan lock btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPlanSubmitBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanSubmitBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Plan.SubmitBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanSubmitBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan submit btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNewFlashManagerBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashManagerBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Admin.Newsflashmanager"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashManagerBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash Manager btn WebElement not found");
		throw new Exception();
		} 
	}
public void validateNewsFlashPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashPageText = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlash.PageLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objNewsFlashPageText != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:NewsFlash Manager Page is open"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash Manager text not found");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:NewsFlash Manager Page heading webelement not found");
		} 
	}
public void clickOnNewsFlashCreateStartBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashCreateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlashCreateStart"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashCreateBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash Create btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNewsFlashStartDateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashStartDateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlashStartDateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashStartDateBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash Start date btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNewsFlashEndDateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashEndDateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlashEndDateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashEndDateBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash End date btn WebElement not found");
		throw new Exception();
		} 
	}
public void enterNewsFlashHeading(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashHeadingName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NewsFlash.CreateHeadingField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objNewsFlashHeadingName);
		//objSeleniumEvents.writeToTextBox(objNewsFlashHeadingName, "Test QA NewsFLash");
		String NewsFlashHeading = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.NewFlash.Heading");
		objSeleniumEvents.writeToTextBox(objNewsFlashHeadingName, NewsFlashHeading);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash Heading field WebElement not found");
		throw new Exception();
		} 
	}
public void enterNewsFlashContent(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashContentField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlashContentField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objNewsFlashContentField);
		String NewsFlashContent = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.NewFlash.Content");
		objSeleniumEvents.writeToTextBox(objNewsFlashContentField, NewsFlashContent);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash content field WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNewsFlashCreateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashCreateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NewsFlash.NewsFlashCreateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashCreateBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:NewsFlash created successfully");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash create btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNewsFlashCreateCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashCreateCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NewsFlash.CreateCloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashCreateCloseBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash create close btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNewsFlashSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NewsFlash.CreateSaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashSaveBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:NewsFlash updated successfully");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash Save btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectNewsFlashStartDate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashTodayDateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NewsFlash.TodayDateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashTodayDateBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash today save btn WebElement not found");
		throw new Exception();
		} 
	}

public void selectNewsFlashDate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
	/*	DateFormat dateFormat = new SimpleDateFormat("dd");
		Date today = Calendar.getInstance().getTime();
		System.out.println("Today date is....................." +  today);
		LocalDateTime.from(today.toInstant()).plusDays(1);
		String date = dateFormat.format(today);
		System.out.println("Today plus one day.........." +date);
		*/
		 
		
		   ZoneId zoneId = ZoneId.of("Asia/Kolkata");
	        int dayOfMonth = ZonedDateTime.now(zoneId).getDayOfMonth();
	        int dayOfMonthAdd = ZonedDateTime.now(zoneId).getDayOfMonth();
	        System.out.println("Today date............................" + dayOfMonth);
	
		List<WebElement> DateDays =objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlashCalenderDays"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement DateDay: DateDays) {
			int cellDate = Integer.parseInt(DateDay.getText().trim());
			System.out.println("Date of calender....................." + cellDate);
			if(cellDate == dayOfMonth) {
				DateDay.click();
				break;
			}
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash date btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectNewsFlashEndDate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashTodayDateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.NewsFlash.TodayDateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashTodayDateBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash today save btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNewsFlashEditBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashEditBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlash.EditBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashEditBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash edit btn WebElement not found");
		throw new Exception();
		} 
	}
public void clicktoUpdateNewsFlashContentField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashContentField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlashContentField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objNewsFlashContentField);
		String NewsFlashContentUpdate = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.NewFlash.ContentUpdate");
		objSeleniumEvents.writeToTextBox(objNewsFlashContentField, NewsFlashContentUpdate);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash content field WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNewsFlashDeleteBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashDeleteBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlash.DeleteBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashDeleteBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash delete btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnNewsFlashDeleteConfirmBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNewsFlashDeleteConfirmBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlash.DeleteConfirmBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNewsFlashDeleteConfirmBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:NewsFlash deleted successfully");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NewsFlash delete confirm btn WebElement not found");
		throw new Exception();
		} 
	}

public void validateLogoOnReport(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLogoColor = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.SuperFlexBrandLogo"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
/*
		String rgbFormat = objLogoColor.getCssValue("color");  // background-color, outline-color
		System.out.println(rgbFormat);     //In RGB Format the value will be print => rgba(254, 189, 105, 1)
		String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
		System.out.println(hexcolor);// Output of Hex code will be  => #febd69
		*/
		
        System.out.println("Image-Height = "+objLogoColor.getSize().getHeight());
        System.out.println("Image-Width = "+objLogoColor.getSize().getWidth());
		
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Brand Logo WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnPageExpandBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objReportExpandBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.SuperFlexRExpandBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objReportExpandBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Page Expand btn WebElement not found");
		throw new Exception();
		} 
	}

public void validateLogoOnReportAfterExpand(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLogoColor = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.SuperFlexBrandLogo"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
		int LogoHeight = objLogoColor.getSize().getHeight();
		int LogoWidth = objLogoColor.getSize().getWidth();
		if(LogoHeight > 258 && LogoWidth> 248) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Logo size appears fine after page expand"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Logo size not appears fine after page expand");
			throw new Exception();
		}
		
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Brand Logo WebElement not found");
		throw new Exception();
		} 
	}

public void validateLogoOnReportAfterCompress(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLogoColor = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.SuperFlexBrandLogo"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
		int LogoHeight = objLogoColor.getSize().getHeight();
		int LogoWidth = objLogoColor.getSize().getWidth();
		if(LogoHeight > 258 && LogoWidth> 248) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Logo size appears fine after page expand"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Logo size not appears fine after page expand");
			throw new Exception();
		}
		
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Brand Logo WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnUserSaveSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSaveUserSettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.Flex.userSettingBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSaveUserSettingBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Save User setting btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnUserSettingNameField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserSettingNameField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.FlexUserSettingName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUserSettingNameField);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:User setting name field WebElement not found");
		throw new Exception();
		} 
	}
public void enterUserSettingName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserSettingNameField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.FlexUserSettingName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objUserSettingNameField);
		objSeleniumEvents.writeToTextBox(objUserSettingNameField, "Test User Setting");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:User setting name field field WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnSavedSettingCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserSettingCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.FlexSettingCloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUserSettingCloseBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:User setting Close Btn WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnSettingSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSettingSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.FlexSettingSaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSettingSaveBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:setting save Btn WebElement not found");
		throw new Exception();
		} 
	}

public void clickONSavedSelectionName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objselectionName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.FlexSettingCloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objselectionName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Saved setting Name WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnLoadSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLoadSettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.FlexSavedSettingLoad"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objLoadSettingBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Load setting Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDeleteSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDeleteSettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Reports.FlexSettingDelete"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDeleteSettingBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Delete setting Btn WebElement not found");
		throw new Exception();
		} 
	}

public void validateOpsSystemSelectionPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSystemSelection = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.SelectSystemPage"), objGenericFunctions.WAITFORPRESENCE_M, objGenericFunctions.SLEEP_S);
		if(objSystemSelection!= null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:User Successfully move to system selection page");
		}else {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:System selection page is not displayed");
			throw new Exception("FAIL: User not at system selection page as its label is not Displayed");
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception();
		} 
	}
public void clickOnSystemDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSystemDropDownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.SystemDropDownBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSystemDropDownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:System dropdown Btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectOpsSytem(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSystemName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.SystemName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSystemName);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:System name WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnEnterSystemBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objEnterSystemBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.EnterSystemBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objEnterSystemBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:System selected successfully");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Enter System WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnGlobalBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objGlobalBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.GlobalDropBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objGlobalBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Global WebElement not found");
		throw new Exception();
		}
	}

public void clickOnSetMarketBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSetMarketBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.SetMarketBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSetMarketBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Set market btn WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnOpsMarketDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMarketDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.MarketDropDownBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMarketDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Market dropdown WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnOpsMarket(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMarketName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.MarketName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMarketName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Market name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnOpsSetMarketBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSetMarketBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.MarketNameSetBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSetMarketBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Market selected successfully");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Set market WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCloseProcedure(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCloseProcedureBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.CloseProcedureBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCloseProcedureBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Close Procedure Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnEditSuppression(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objEditSuppressionBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.EditSuppressionBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objEditSuppressionBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Edit Suppression Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnOpsPeriodDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objOpsPeriodDropBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.SuppressionPeriodBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objOpsPeriodDropBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Ops Period Drop WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnOpsPeriod(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objOpsPeriodName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.SuppressionPeriodName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objOpsPeriodName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Ops Period Name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnOpsPeriodNextBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objOpsPeriodName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.SuppressionPeriodNextBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objOpsPeriodName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Ops Period Name WebElement not found");
		throw new Exception();
		} 
	}
public void switchDriverToOpsFrame(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {

        // objDriver.switchTo().frame(0);
         
       WebElement objSwitchToIframe = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.OpsIFrame"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
        objDriver.switchTo().frame(objSwitchToIframe);
        //objDriver.switchTo().frame(4);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:driver doesnot switch to iframe");
		throw new Exception();
		}
	}
public void readSuppressionFile(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		
		objAutomationObjects.objLogger.logInfo("", false);
		//WebElement BMCodeList = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.MarketNameSetBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
		//FileInputStream file = new FileInputStream("D:\\DemoFile.xlsx");
     	//XSSFWorkbook workbook = new XSSFWorkbook(file);
		//XSSFSheet sheet = workbook.getSheetAt(0);
		
		/*
		Workbook workbook = WorkbookFactory.create(new FileInputStream("D:\\Checks\\BmCode.xlsx"));
		 XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
		
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
           Row row = sheet.getRow(i);
           for (int j = 0; j < row.getLastCellNum() + 1; j++) {
              Cell cell = row.getCell(j);
            	List<WebElement> DealersRow = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.Suppression.DealersRow"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
        		for(WebElement Drow: DealersRow) {
        			List<WebElement> BMCodeList = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.Suppression.BmCodeCell"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
        			for(WebElement BMcode: BMCodeList) {
        			if(BMcode.getText().equals(cell) ) {
        				WebElement SuppYTD = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.Suppression.SuppYTD"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
        				objSeleniumEvents.clickButton(SuppYTD);
        				WebElement FinCum = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.Suppression.FinCum"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
        				objSeleniumEvents.clickButton(FinCum);
        				WebElement RollingCum = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.Suppression.RollingCum"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
        				objSeleniumEvents.clickButton(RollingCum);
        				WebElement SuppQTD = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Ops.Suppression.SuppQTD"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);	
        				objSeleniumEvents.clickButton(SuppQTD);
        				break;
        			}
        			}
        		}
		    }
		}
		workbook.close();
		//file.close();
		///
		///
		 */
	/*	
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(1);
		System.out.println(sheet.getRow(0).getCell(1));
		Row row2 = sheet.getRow(1);
		Cell cell2 = row2.getCell(1);
		System.out.println(sheet.getRow(1).getCell(0));
		Row row3 = sheet.getRow(1);
		Cell cell3 = row3.getCell(1);
		System.out.println(sheet.getRow(1).getCell(1));
		//String cellval = cell.getStringCellValue();
		//System.out.println(cellval);
		 * *?
		 * 
		 */
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Market name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnMatrixAnalysisBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMatrixAnalysisBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.MatrixBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMatrixAnalysisBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Matrix Analysis btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnMarketDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMarketDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.MarketDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMarketDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Market dropdown btn WebElement not found");
		throw new Exception();
		} 
	}
public void validateMatrixAnalysisPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMatrixFilterBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.FilterBtn"), objGenericFunctions.WAITFORPRESENCE_M, objGenericFunctions.SLEEP_S);
		if(objMatrixFilterBtn!= null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:User Successfully move to Matrix analysis page");
		}else {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:User not move to Matrix analysis page");
			throw new Exception("FAIL:Matrix analysis page filter btn webelement not found");
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception();
		} 
	}
public void clickOnMarketName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMarketName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.MarketName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMarketName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Market name btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPeriodDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPeriodDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.PeriodDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPeriodDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Period Dropdown btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnPeriodName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPeriodName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.PeriodName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPeriodName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Period name btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnXAxixKpiDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objXAxisKpiDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.XAxisKPIDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objXAxisKpiDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:X-Axis Kpi Dropdown btn WebElement not found");
		throw new Exception();
		} 
	}

public void EnterKpiInSearchField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSearchField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.KpiSearchField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objSearchField);
		objSeleniumEvents.writeToTextBox(objSearchField, "CPI");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI search field btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnKpiName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.KpiName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objKpiName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Kpi name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnKpiSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.KpiSaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objKpiSaveBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Kpi Save btn WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnYAxisKpiDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objYAxisKpiDrop = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.YAxisKPIDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objYAxisKpiDrop);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Y axis kpi dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnKpiDeptName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiDept = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.KpiDeptName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objKpiDept);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Kpi dept name WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnSelectionFilterBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objFilterBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.FilterBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objFilterBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Filter Btn WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnExcelDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objXlBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.MatrixAnalysis.XlDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objXlBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:XL btn WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnOverallSummaryBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement obOverallSummaryBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.SATBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(obOverallSummaryBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Overall Summary btn WebElement not found");
		throw new Exception();
		} 
	}
public void validateOverallSummaryLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSummaryLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.OverallSummaryLabel"), objGenericFunctions.WAITFORPRESENCE_M, objGenericFunctions.SLEEP_S);
		if(objSummaryLabel!= null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:User Successfully move to Overall summary page");
		}else {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:User not move to Overall summary page");
			throw new Exception("FAIL:Overall summary btn webelement not found");
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception();
		} 
	}

public void clickOnSATaverageDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAvgDropdownbBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.AvgDropdownBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAvgDropdownbBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Average dropdown btn WebElement not found");
		throw new Exception();
		} 
	}
public void selectAverageForSAT(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAvgName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.AvgName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAvgName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Average name WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDeptChartBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDeptChartBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.DeptChartDwnldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDeptChartBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dept chart btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnKpiChartBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAvgName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.KpiChartDwnldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAvgName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Kpi chart btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDeptViewBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDeptViewBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.DeptViewBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDeptViewBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dept view btn WebElement not found");
		throw new Exception();
		} 
	}
public void enterNvTargetVolume(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNvTargetVolumneField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.NvTargetValueField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objNvTargetVolumneField);
		objSeleniumEvents.writeToTextBox(objNvTargetVolumneField, "250");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:NV Target volume field btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOkOnNvTargetVolume(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNvTargetOkBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.NvTargetValueOkBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNvTargetOkBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Nv target volumne ok btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDetailedViewBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDeatiledViewBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.DeptDetailedViewBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDeatiledViewBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Deatiled View btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDetailedViewExcelBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDeatiledViewExcelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.DetailedViewDownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDeatiledViewExcelBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Deatiled View Excel btn WebElement not found");
		throw new Exception();
		} 
	}

public void storedItemsValue(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objItemsValue = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.ItemsValueToValidate"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		String storedValue= objItemsValue.getText();
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Items value btn WebElement not found");
		throw new Exception();
		} 
	}
public void validateStoredValue(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objItemsValue = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.SAT.ItemsValueToValidate"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		String ItemsValue= objItemsValue.getText();
		if((ItemsValue)==("£6110047")) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Items value matched with stored value");	
		}else {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("Fail:Items value not matched with stored value");		
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Items value btn WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnAnalysisNetworkDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNetworkDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.BM.Analysis.NetworkDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objNetworkDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Network Dropdown WebElement not found");
		throw new Exception();
		} 
	}

// Existing functions end

public void clickOnAnalysisDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAnalysisDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.AnalysisDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAnalysisDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS Analysis dropdown WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnSubmissionsDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSubmissionsDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.SubmissionsDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSubmissionsDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Submissions Dropdown WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnSubmissionManagerDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSubmissionsManagerDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.SubManagerDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSubmissionsManagerDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Submission manager Dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAssignBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAssignBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.AssignBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAssignBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Account map Assign Btn webelement not found");
		throw new Exception();
		} 
	}
public void clickOnAssignPlusBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAssignPlusBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.AssignPlusBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAssignPlusBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Assign plus WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnAssignCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objReplaceOkbtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.AssignReplaceOk"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if (objReplaceOkbtn.getText()!=null){
			objSeleniumEvents.clickButton(objReplaceOkbtn);
		}
		else {
			objReplaceOkbtn.getText();
		}
		WebElement objClosebtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.AccountMap.CloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objClosebtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Account map assigned to dealer successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Assign close btn WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnAdministrationDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAdminbtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.AdminDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAdminbtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Adminisitration dropdown btn WebElement not found");
		throw new Exception();
		} 
	}

public void validateDnsprofileLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objProfilelabelText = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Admin.ProfilePagelabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objProfilelabelText != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:DNS Profile Page open successfully"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS Profile Page is open successfully");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:DNS profile Page heading webelement not found");
		} 
	}

public void clickOnNewsFlashMarketDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMarketDrop = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlashMarketDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMarketDrop);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Market dropdown btn WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnNewsFlashMarket(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMarketName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.NewsFlashMarketName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objMarketName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Market name WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnReportsDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objReportsDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.ReportsDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objReportsDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Reports Dropdown WebElement not found");
		throw new Exception();
		} 
	}

public void validateSelectedReport(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> reportNames = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.ReportName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement report: reportNames) {
			if(report.getText().contains("Management Accounts") || report.getText().contains("National Summary")) {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Reports are appearing as per selection");
				break;
			}
			else {
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Reports are not appearing as per selection");
				break;
			}
		}
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Reports type name field webelement not found");
		throw new Exception();
		} 
	}
public void clickOnSetDefaultBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSetDefaultBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.DefaultBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSetDefaultBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Set Default selection are saved");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Set Default Btn WebElement not found");
		throw new Exception();
		} 
	}
public void SuccessCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.CloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCloseBtn);

		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Success Close Btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnFixedReportFilterHideBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objFilterCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.FilterHide"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objFilterCloseBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Report Filter Hidden successfully");

		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Filter Hide Btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnFixedReportFilterShowBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objFilterShowBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.FilterShow"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objFilterShowBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Report Filter appeared successfully");

		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Filter Show Btn WebElement not found");
		throw new Exception();
		} 
	}

public void ClickOnPDFSelectAllBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objPDFSelectAllBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.PdfSelectAll"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
	objSeleniumEvents.clickButton(objPDFSelectAllBtn);

	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:PDF SelectAll Btn WebElement not found");
	throw new Exception();
	} 
}

public void ClickOnXlSelectAllBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objXLSelectAllBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.XlSelectAll"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
	objSeleniumEvents.clickButton(objXLSelectAllBtn);

	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:XL SelectAll Btn WebElement not found");
	throw new Exception();
	} 
}

public void ClickOnPDFDeSelectAllBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objPDFDeSelectAllBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.PdfDeSelect"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
	objSeleniumEvents.clickButton(objPDFDeSelectAllBtn);

	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:PDF De-SelectAll Btn WebElement not found");
	throw new Exception();
	} 
}

public void ClickOnXlDeSelectAllBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objXLDeSelectAllBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.XlDeSelect"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
	objSeleniumEvents.clickButton(objXLDeSelectAllBtn);

	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:XL De-SelectAll Btn WebElement not found");
	throw new Exception();
	} 
}
public void validateReportGetSelected(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objReportSelected = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.PdfSelect"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objReportSelected != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Report Get selected"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report not get selected");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Selected Report btn webelement not found");
		} 
	}
public void validateReportGetUnSelected(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUnselectedReport = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.PublishReport.PdfUnSelect"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objUnselectedReport != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Reports Get un-selected"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report not get un-selected");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Un-Selected Report btn webelement not found");
		} 
	}

public void clickOnDealerField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objDealerField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.DealerField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
	objSeleniumEvents.clickButton(objDealerField);

	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Flexible dealer field WebElement not found");
	throw new Exception();
	} 
}
public void clickOnNextPageBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objReportNextpage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.NextPage"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
	objSeleniumEvents.clickButton(objReportNextpage);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Next report page opened successfully");
	objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);

	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report Next page Btn WebElement not found");
	throw new Exception();
	} 
}
public void ClickOnPreviousPageBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objReportPreviousPage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.PreviousPage"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
	objSeleniumEvents.clickButton(objReportPreviousPage);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Report moved to previous page successfully");
	objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);

	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report Previous Page Btn WebElement not found");
	throw new Exception();
	} 
}

public void clickOnReportZoomInBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMapZoomIn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.ZommInBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objMapZoomIn);
		Actions acc = new Actions(objDriver);
		acc.doubleClick(objMapZoomIn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Report size increased");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Report zoom In WebElement");
		throw new Exception();
		}
}

public void clickOnReportZoomOutBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objZoomOut = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.ZoomOutBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objZoomOut);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Report size decreased");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Report Zoom Out WebElement");
		throw new Exception();
		}
}
public void clickOnReportSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.ReportSave"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objSaveBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Report save Btn WebElement");
		throw new Exception();
		}
}

public void EnterFlexibleReportName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNameField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.FlexibleReport.RportNameBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objNameField);
		String FlexibleReportName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("FlexibleReportName");
		objSeleniumEvents.writeToTextBox(objNameField, FlexibleReportName);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Flexible report name field WebElement not found");
		throw new Exception();
		} 
	}
public void netOperatingChartLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNetOperatingLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetProfitChartLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objNetOperatingLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Net Operating Pie Chart appearing"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Net Operating Pie Chart not appearing");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Net Operating chart label webelement not found");
		} 
	}
public void netSalesChartLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUnselectedReport = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetSalesChartLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objUnselectedReport != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Net sales Pie Chart appearing"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Net sales Pie Chart not appearing");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Net Operating chart label webelement not found");
		} 
	}
public void clickOnNetOperatingNVLegendToHide(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNVLegend = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetSalesNVLegend"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objNVLegend);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Net operating NV legend Btn WebElement");
		throw new Exception();
		}
}
public void clickOnNetOperatingUVLegendToHide(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUVLegend = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetSalesUVLegend"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objUVLegend);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Net operating UV Legend Btn WebElement");
		throw new Exception();
		}
}

public void clickOnNetSalesNVLegendToHide(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNVLegend = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetProfitNVLegend"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objNVLegend);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Net sales NV legend Btn WebElement");
		throw new Exception();
		}
}
public void clickOnNetSalesUVLegendToHide(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUVLegend = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetProfitUVLegend"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objUVLegend);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Net Sales UV Legend Btn WebElement");
		throw new Exception();
		}
}
public void clickOnHiddenNVLegendToAppear(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNVLegend = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PieChartNVLegendHide"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objNVLegend);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find hidden Net operating NV legend Btn WebElement");
		throw new Exception();
		}
}
public void clickOnHiddenUVLegendToAppear(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUVLegend = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PieChartUVLegendHide"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objUVLegend);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Hidden Net operating UV Legend Btn WebElement");
		throw new Exception();
		}
}

public void clickOnNetProfitChartDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetProfitDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objDownloadBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Net Profit Download Btn WebElement");
		throw new Exception();
		}
}
public void clickOnNetSalesChartDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetSalesDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objDownloadBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Net Sales Download Btn WebElement");
		throw new Exception();
		}
}

public void selectDepartment(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDeptNameBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.DeptName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objDeptNameBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Dept Name Btn WebElement");
		throw new Exception();
		}
}
public void clickOnPeriodListDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPeriodListBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PeriodList.DropDwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objPeriodListBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find period list dropdown Btn WebElement");
		throw new Exception();
		}
}

public void selectPeriod(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDeptNameBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Period.Year.Month"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objDeptNameBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Period Month Btn WebElement");
		throw new Exception();
		}
}

public void clickOnPeriodYearDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objYearBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.Period.Year.DropDwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objYearBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Period year Btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiAnalaysisAverageDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisAverageDropBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.AvgDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisAverageDropBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis Average Dropdown Btn WebElement");
		throw new Exception();
		}
}

public void clickOnKpiAnalysisAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisAverageBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.AvgName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisAverageBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis Average name Btn WebElement");
		throw new Exception();
		}
}

public void clickOnKpiAnalysisAverageSwitchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisAverageSwitch = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.AvgBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisAverageSwitch);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI analysis average enable and disable working fine");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis Average switch Btn WebElement");
		throw new Exception();
		}
}
public void validateKpiAnalysisChartLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisChartLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnalysisLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiAnalysisChartLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Analysis Chart appearing"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Analysis Chart not appearing");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:KPI analysis chart label webelement not found");
		} 
	}

public void validateKpiAnalysisAverageLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisAverageLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.AvgDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiAnalysisAverageLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Analysis average selected"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Analysis average not selected");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:KPI analysis average name webelement not found");
		} 
	}
public void clickOnKpiAnalysisSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisSettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.SettingBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisSettingBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis Setting Btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiAnalysisSelectAllKpiBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisSelectAllBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.SelectAll"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisSelectAllBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:All KPI selected successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis Select all KPI Btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiAnalysisDeSelectAllKpiBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisDeSelectAllBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.DeSelectAll"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisDeSelectAllBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:All KPI Deselected successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis DeSelect all KPI Btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiAnalysisSelectDefaultKpiBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisSelectDefaultBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.Default"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisSelectDefaultBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Default KPI selected successfully");
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis Select default KPI Btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiAnalysisSettingSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisSettingSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPISave"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisSettingSaveBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis Setting save Btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiAnalysisDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.DownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisDownloadBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis download Btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiAnalysisMaximizeBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisMaxBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MaxBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	//	objSeleniumEvents.clickButton(objKpiAnalysisMaxBtn);
		JavascriptExecutor executor = (JavascriptExecutor)objDriver;
		executor.executeScript("arguments[0].click();", objKpiAnalysisMaxBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis max Btn WebElement");
		throw new Exception();
		}
}
public void validateKPIAnalysisDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.DownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiAnalysisDownloadBtn != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Analysis Chart Downloaded"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Analysis Chart not downloaded");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:KPI analysis download webelement not found");
		} 
	}

public void validateKPIAnalysisMaxScreen(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisMaxScreenLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MaxScreenLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiAnalysisMaxScreenLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Analysis maximize screen appear"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Analysis maximize screen appear");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:KPI analysis max screen webelement not found");
		} 
	}
public void clickOnKpiAnalaysisMaxAverageDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisAverageDropBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MaxAvgDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisAverageDropBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis max Average Dropdown Btn WebElement");
		throw new Exception();
		}
}

public void clickOnMaxKpiSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiSettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MaxSettingBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiSettingBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Max screen Kpi Setting Btn WebElement");
		throw new Exception();
		}
}

public void clickOnKpiAnalysisMaxAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisAverageBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MaxAvgName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisAverageBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis max Average name Btn WebElement");
		throw new Exception();
		}
}

public void clickOnKpiAnalysisMaxAverageSwitchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisAverageSwitch = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MaxAvgBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisAverageSwitch);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Analysis average enabled and diabled for Maximize screen");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis Average max switch Btn WebElement");
		throw new Exception();
		}
}

public void validateKpiAnalysisMaxAverageLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisAverageLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MaxAvgDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiAnalysisAverageLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Maximize screen KPI Analysis average selected"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Maximize screen KPI Analysis average not selected");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Maximize screen KPI analysis average name webelement not found");
		} 
	}
public void clickOnKpiAnalysisMaxDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MaxDwnldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisDownloadBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis max download Btn WebElement");
		throw new Exception();
		}
}
public void validateKPIAnalysisMaxDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MaxDwnldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiAnalysisDownloadBtn != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Max screen KPI Analysis Chart Downloaded"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Max screen KPI Analysis Chart not downloaded");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Maximize screen KPI analysis download btn webelement not found");
		} 
	}

public void clickOnkpiAnalysisMaxItem(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisMaxItem = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MaxItemDrill"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisMaxItem);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis max item Btn WebElement");
		throw new Exception();
		}
}
public void validateKPIAnalysisItemDrillDown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.DrillPageLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiAnalysisDownloadBtn != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Analysis Item Drill down page appear"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Analysis Item Drill down page not appear");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:KPI Analysis Item Drill down page btn webelement not found");
		} 
	}
public void clickOnKPIAnalysisItemDrillDownPageCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objItemDrillClose = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MaxDrillClose"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objItemDrillClose);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis Item Drill down page close WebElement");
		throw new Exception();
		}
}
public void clickOnKPIAnalysisItemPageCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objItemPageClose = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.DrillPageClose"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objItemPageClose);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis Item page close WebElement");
		throw new Exception();
		}
}
public void clickOnkpiAnalysisItem(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiAnalysisItem = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.ItemDrill"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiAnalysisItem);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Analysis item Btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiAnalysisKpiDataDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiDataDownload = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPIDataDwnldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiDataDownload);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Data Download btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiAnalysisCalcDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiCalcDownload = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPICalcDwnldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiCalcDownload);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Calc Download btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiAnalysisCalcBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiCalcBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPICalcBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiCalcBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Calc btn WebElement");
		throw new Exception();
		}
}
public void validateKPIAnalysisKpiDataDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiDataDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPIDataDwnldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiDataDownloadBtn != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Analysis KPI Data Downloaded"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Analysis KPI Data not Download");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:KPI Analysis KPI Data Download btn webelement not found");
		} 
	}
public void validateKPIAnalysisCalcDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiCalcDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPICalcDwnldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiCalcDownloadBtn != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Analysis KPI calc Downloaded"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Analysis KPI calc not Download");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:KPI Analysis Kpi Calc download btn webelement not found");
		} 
	}

public void clickOnKpiTrendFirstAverageDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiTrendFirstAverageDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPITrendAvg1Drop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiTrendFirstAverageDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Trend First Average Dropdown btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiTrendFirstAverageBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiTrendFirstAverageBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPITrendAvg1Name"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiTrendFirstAverageBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Trend First Average btn WebElement");
		throw new Exception();
		}
}

public void clickOnKpiTrendSecondAverageDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiTrendSecondAverageDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPITrendAvg2Drop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiTrendSecondAverageDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Trend Second Average Dropdown btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiTrendSecondAverageBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiTrendSecondAverageBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPITrendAvg2Name"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiTrendSecondAverageBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Trend Second Average btn WebElement");
		throw new Exception();
		}
}

public void clickOnKpiTrendFirstAverageSwitchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiTrendFirstAverageSwitchBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPITrendAvg1Btn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiTrendFirstAverageSwitchBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Trend  and Market trend average enable and disabled works fine");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Trend First Average Switch Btn WebElement");
		throw new Exception();
		}
}

public void clickOnKpiTrendSecondAverageSwitchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiTrendSecondAverageSwitchBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPITrendAvg2Btn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiTrendSecondAverageSwitchBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Trend Second average enable and disabled works fine");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Trend Second Average Switch Btn WebElement");
		throw new Exception();
		}
}
public void clickOnKpiTrendDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiTrendDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPITrendDwnldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiTrendDownloadBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Kpi Trend Download Btn WebElement");
		throw new Exception();
		}
}
public void clickOnMarketTrendBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objMarketTrendBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.MarketTrendBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objMarketTrendBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Market Trend btn WebElement");
		throw new Exception();
		}
}

public void validateKpiTrendFirstAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiTrendFirstAverage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPITrendAvg1Drop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiTrendFirstAverage != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Kpi Trend First Average selected"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Kpi Trend First Average not selected");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Kpi Trend First Average webelement not found");
		} 
	}
public void validateKpiTrendSecondAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiTrendSecondAverage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPITrendAvg2Drop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiTrendSecondAverage != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Kpi Trend Second Average selected"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Kpi Trend Second Average not selected");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Kpi Trend Second Average webelement not found");
		} 
	}
public void validateKpiTrendDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiTrendDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIAnlysis.KPITrendDwnldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKpiTrendDownloadBtn != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Trend chart Downloaded"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Trend chart not Download");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:KPI Trend chart download btn webelement not found");
		} 
	}

public void clickOnPerformanceVariationDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPerformanceVariationDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PerformanceVar.DownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objPerformanceVariationDownloadBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Performance Variation Download Btn WebElement");
		throw new Exception();
		}
}
public void validatePerformanceVariationChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPerformanceVariationChartLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PerformanceVar.ChartLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objPerformanceVariationChartLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Performance Variation Chart appear"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Performance Variation Chart not appear");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Performance Variation Chart label webelement not found");
		} 
	}

public void validatePerformanceVariationDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPerformanceVariationDonloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PerformanceVar.DownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objPerformanceVariationDonloadBtn != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Performance Variation Chart downloaded"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Performance Variation Chart not downloaded");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Performance Variation Chart download btn webelement not found");
		} 
	}

public void clickOnUserSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserSettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.UserSettingBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objUserSettingBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find User setting Btn WebElement");
		throw new Exception();
		}
}

public void enterUserInImitateField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objImitateField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Imitate.UserField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clearTextBox(objImitateField);
		String ImitateUsername = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Imitate.UserName");
		objSeleniumEvents.writeToTextBox(objImitateField, ImitateUsername);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Imitate User field WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnUserImitateOkBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserImitateOkBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Imitate.Enteruser"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objUserImitateOkBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		objDriver.navigate().refresh();
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find user imitate ok Btn WebElement");
		throw new Exception();
		}
}
public void clickOnImitateUserRemoveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserImitateRemoveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Imitate.RemoveUserBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objUserImitateRemoveBtn);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:User removed from imitate successfully");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find user imitate remove Btn WebElement");
		throw new Exception();
		}
}

public void validateImitateUserField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objImitateFieldBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Imitate.UserField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objImitateFieldBtn != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Imitate field is appearing"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Imitate field is not appearing");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Imitate field webelement not found");
		} 
	}
public void validateuserImitateSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objImitateUserSelectBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Imitate.RemoveUserBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objImitateUserSelectBtn != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:User Imitated successfully"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:User not Imitated");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL:Imitate user select btn webelement not found");
		} 
	}
public void clickOnPLDispersionMaxBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPLDisMaxBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PLDispersion.MaximizeBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objPLDisMaxBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find PL Dispersion maximize Btn WebElement");
		throw new Exception();
		}
}

public void clickOnPLDispersionDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPLDisDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PLDispersion.DownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objPLDisDownloadBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find PL Dispersion download Btn WebElement");
		throw new Exception();
		}
}
public void clickOnPLDispersionMaxDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPLDisMaxDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PLDispersion.MaxDonloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objPLDisMaxDownloadBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find PL Dispersion max download Btn WebElement");
		throw new Exception();
		}
}

public void clickOnPLDispersionSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPLDisSettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PLDispersion.SettingBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objPLDisSettingBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find PL Dispersion setting Btn WebElement");
		throw new Exception();
		}
}
public void clickOnPLDispersionMaxSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPLDisMaxSettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PLDispersion.MaxSettingBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objPLDisMaxSettingBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find PL Dispersion max setting Btn WebElement");
		throw new Exception();
		}
}
public void validatePLDispersionChartLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPLDisLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PLDispersion.Label"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objPLDisLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:PL dispersion chart appearing"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:PL dispersion chart not appearing");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL::PL dispersion chart label webelement not found");
		} 
	}
public void validatePLDispersionDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPLDisDownload = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PLDispersion.DownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objPLDisDownload != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:PL dispersion chart downloaded"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:PL dispersion chart not download");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL::PL dispersion download btn webelement not found");
		} 
	}
public void validatePLDispersionMaximizeScreen(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPLDisMaxLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PLDispersion.MaxLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objPLDisMaxLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:PL dispersion chart is visible in max screen"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:PL dispersion chart is not visible in max screen");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL::PL dispersion max screen label webelement not found");
		} 
	}

public void validatePLDispersionMaxDownlodBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPLDisMaxDownload = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.PLDispersion.MaxDonloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objPLDisMaxDownload != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:PL dispersion chart is downloaded in max screen"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:PL dispersion chart is not download in max screen");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL::PL dispersion max download btn webelement not found");
		} 
	}
public void clickOnKPIPerformanceSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiPerformanceSettingBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIPerformance.SettingBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiPerformanceSettingBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find KPI Performance setting Btn WebElement");
		throw new Exception();
		}
}

public void clickOnKPIPerformanceDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiPerformanceDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIPerformance.DownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiPerformanceDownloadBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find KPI Performance download Btn WebElement");
		throw new Exception();
		}
}
public void clickOnKPIPerformanceDealerDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKpiPerformanceDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIPerforDealer.DownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objKpiPerformanceDownloadBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find KPI Performance dealer download Btn WebElement");
		throw new Exception();
		}
}
public void validateKPIPerformanceLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKPIPerformanceLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIPerformance.Label"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKPIPerformanceLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Performance chart appearing fine"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Performance chart not appearing fine");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL::KPI Performance chart label webelement not found");
		} 
	}

public void validateKPIPerformanceDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKPIPerformanceDownload = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPIPerformance.DownloadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objKPIPerformanceDownload != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:KPI Performance chart downloaded"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:KPI Performance chart not download");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL::KPI Performance chart download btn webelement not found");
		} 
	}

public void clickOnDNSLibrarydropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLibDropdown= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.Dropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objLibDropdown);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find DNS library dropdown webelement");
    throw new Exception();
	}  
}	




public void SelectLibrary(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLibBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.LibraryBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objLibBtn);
		}
	 catch (Exception e) {
	 objAutomationObjects.objLogger.logErrorWithException(e);
     Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to select library Btn");
     throw new Exception();
	}  
}	

public void validateLibraryPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLibraryLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.PageLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objLibraryLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:DNS Library page appearing fine"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:DNS Library page not appearing fine");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL::DNS Library page label webelement not found");
		} 
	}

public void clickOnLibUploadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUploadBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.UploadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objUploadBtn);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find upload doc btn");
    throw new Exception();
	}  
}	
public void clickOnFolderAddBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objFolderAddBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.FolderAddBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objFolderAddBtn);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Folder add btn");
    throw new Exception();
	}  
}
public void clickOnAddFolderName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objFolderAddBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.FolderNameAdd"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objFolderAddBtn);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Folder name add btn");
    throw new Exception();
	}  
}
	
public void selectFolderName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objClickonFolderNameDrop= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.FolderNameField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objClickonFolderNameDrop);
		WebElement objClickonFolderName= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.FolderName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objClickonFolderName);
		/*
		List<WebElement> FolderName = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.FolderNameFieldList"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		for(WebElement name: FolderName) {
			if(name.getText().contains("Test")) {
				System.out.println("Folder name........................" + name);
				Actions acc = new Actions(objDriver); 
				acc.moveToElement(name).perform(); 
				//name.click();
				break;
			}
		}
		*/
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Folder name WebElement not found");
		throw new Exception();
		} 
	}

public void EnterDescription(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDescription= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.DocDescription"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objDescription);
		String DescriptionName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Library.Description");
		objSeleniumEvents.writeToTextBox(objDescription, DescriptionName);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to enter description");
    throw new Exception();
	}  
}	
public void addFolderName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objFolderField= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.FolderNameFieldAdd"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objFolderField);
		String FoderName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Library.FolderName");
		objSeleniumEvents.writeToTextBox(objFolderField, FoderName);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to folder name field");
    throw new Exception();
	}  
}	

public void Choosefile(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		//JavascriptExecutor jse = (JavascriptExecutor) objDriver;	
	    //jse.executeScript("document.getElementsByTagName('input')[1].style.display = 'block'");
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAddfiles = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.ChoseFileBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.writeToTextBox(objAddfiles, "D:\\\\Automation\\\\Ignite Automation\\\\LibraryFile\\\\TestFile.pdf");
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to choose file");
    throw new Exception();
	}  
}	



public void Securitydrpdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSecurityDropdown= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.SecurityClassDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objSecurityDropdown);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to select security dropdown");
    throw new Exception();
	}  
}	



public void SelectSecurity(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.Security.Everybody"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objClickonMaxsave);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to select security");
   throw new Exception();
	}  
}	



public void Networkentitydrpdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLinNetworkDrop= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.NetworkDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objLinNetworkDrop);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to select networkentity drpdown");
    throw new Exception();
	}  
}	
public void clickOnLibraryNetwokSearchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLinNetworkSearchBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.NetworkSearchBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objLinNetworkSearchBtn);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Network search btn");
    throw new Exception();
	}  
}




public void Savenetworkentity(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.NetworkSaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		Actions acc = new Actions(objDriver); 
		acc.moveToElement(objSave).perform(); 
		objSeleniumEvents.clickButton(objSave);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to save networkentity");
    throw new Exception();
	}  
}	


public void Savedoc(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSaveBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.UploadSaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		Actions acc = new Actions(objDriver); 
		acc.moveToElement(objSaveBtn).perform(); 
		objSeleniumEvents.clickButton(objSaveBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:File is Uploaded");
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to save document");
    throw new Exception();
	}  
}	




public void clickonfolderdrpdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
objAutomationObjects.objLogger.logInfo("", false);
WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.FolderExpandBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
objSeleniumEvents.clickButton(objClickonMaxsave);
}
catch (Exception e) {
objAutomationObjects.objLogger.logErrorWithException(e);
Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on folder dropdown");
throw new Exception();
}  
}	



public void Selectfile(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
objAutomationObjects.objLogger.logInfo("", false);
WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.UploadedFile"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
objSeleniumEvents.clickButton(objClickonMaxsave);
}
catch (Exception e) {
objAutomationObjects.objLogger.logErrorWithException(e);
Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on file");
throw new Exception();
}  
}	



public void Selectview(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
objAutomationObjects.objLogger.logInfo("", false);
WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.ViewBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
objSeleniumEvents.clickButton(objClickonMaxsave);
objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Uploaded file is viewable");
}
catch (Exception e) {
objAutomationObjects.objLogger.logErrorWithException(e);
Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to select view");
throw new Exception();
}  
}


public void Selectdelete(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
objAutomationObjects.objLogger.logInfo("", false);
WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.DeleteBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
objSeleniumEvents.clickButton(objClickonMaxsave);
}
catch (Exception e) {
objAutomationObjects.objLogger.logErrorWithException(e);
Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to select delete");
throw new Exception();
}  
}	


public void SelectOK(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
objAutomationObjects.objLogger.logInfo("", false);
WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dnslibrary.ConfirmOkBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
objSeleniumEvents.clickButton(objClickonMaxsave);
Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Uploaded file is Deleted");
}
catch (Exception e) {
objAutomationObjects.objLogger.logErrorWithException(e);
Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to select ok");
throw new Exception();
}  
}	

public void clickOnAlertButton(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.AlertBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertBtn);
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find alert btn webelement");
         throw new Exception();
         }  
}
public void clickOnAlertNameBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertNameBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.NewsFlashName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertNameBtn);
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find news flash name btn webelement");
         throw new Exception();
         }  
}
public void clickOnAlertReadMarkBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertReadBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.MarkRead"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertReadBtn);
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Alert mark read btn webelement");
         throw new Exception();
         }  
}
public void clickOnAlertReadFlagBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertFlagBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.Markflag"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertFlagBtn);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Alert mark Flag btn webelement");
         throw new Exception();
         }  
}
public void clickOnAlertCriticalMarkBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertCriticalBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.MarkCritical"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertCriticalBtn);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Alert mark critical btn webelement");
         throw new Exception();
         }  
}

public void clickOnAlertDeleteMarkBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertDeleteBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.MarkDelete"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertDeleteBtn);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Alert mark delete btn webelement");
         throw new Exception();
         }  
}
public void clickOnAlertUnReadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertUnreadBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.UnreadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertUnreadBtn);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Alert UnRead btn webelement");
         throw new Exception();
         }  
}
public void clickOnAlertSearchField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAlertSearchField= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.SearchField"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objAlertSearchField);
		String AlertName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.Alert.SearchAlert");
		objSeleniumEvents.writeToTextBox(objAlertSearchField, AlertName);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	    objAutomationObjects.objLogger.logErrorWithException(e);
        Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find alert search field");
        throw new Exception();
	}  
}	
public void clickOnAlertStartUpPopUpBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertPopUpBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.StartUpSlider"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertPopUpBtn);
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Alert StartUp PopUp btn webelement");
         throw new Exception();
         }  
}

public void validateAlertPageLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAlertLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.AlertLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objAlertLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Alert page appearing fine"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Alert page not appearing");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL::Alert page label webelement not found");
		} 
	}
public void clickOnAlertPageCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertPageCloseBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.PageCloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertPageCloseBtn);
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Alert page close btn webelement");
         throw new Exception();
         }  
}
public void validateNewsFlashMessage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAlertMessage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.AlertsDes"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objAlertMessage != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:News Flash message is appearing"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:News Flash message is not appearing");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL::News flash message webelement not found");
		} 
	}
public void clickOnReadAlertBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertReadBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.ReadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertReadBtn);
     	Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Alert moved to Read section"); 
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find readed alerts btn webelement");
         throw new Exception();
         }  
}
public void clickOnUnReadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertUnReadBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.UnreadBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertUnReadBtn);
     	Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Unread alert is appearing"); 
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Unreaded alerts btn webelement");
         throw new Exception();
         }  
}
public void clickOnFlaggedAlertBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertFlaggedBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.FlaggedBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertFlaggedBtn);
     	Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:News Flash moved to flagged section"); 
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Flagged alerts btn webelement");
         throw new Exception();
         }  
}
public void clickOnCriticalAlertBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertCriticalBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.CriticalBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertCriticalBtn);
     	Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Alert moved to critical section"); 
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Critical alerts btn webelement");
         throw new Exception();
         }  
}
public void clickOnDeletedAlertBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAlertDeletedBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Alert.Alert.DeletedBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAlertDeletedBtn);
     	Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Alert moved to deleted section"); 
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Deleted alerts btn webelement");
         throw new Exception();
         }  
}

public void clickOnOpportunityAverageDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAvgDropdown= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Opportunity.AvgDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAvgDropdown);
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find average dropdown btn webelement");
         throw new Exception();
         }  
}
public void selectOpportunityAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objAvgName= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Opportunity.AvgName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objAvgName);
     	Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Opportunity Average selected"); 
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find average name btn webelement");
         throw new Exception();
         }  
}

public void validateTotalOpportunityLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAlertMessage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Opportunity.TotalOpportunity"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objAlertMessage != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Opportunity details are appearing"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Opportunity details are not appearing");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL::News flash message webelement not found");
		} 
	}

public void launchNewBrowser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strApplication_URL) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
        // String strURLTestData=objAutomationObjects.objTestData.getTestData("strStellURL");
    //    String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
	//	 objDriver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
    //   JavascriptExecutor jseElement = (JavascriptExecutor)objDriver;
    //   objDriver.ExecuteScript("window.open('your url','_blank');");
       
       for (String tab : objDriver.getWindowHandles()) {

    	    objDriver.switchTo().window(tab);
 }
     	String Url = Wave3AutomationObjects.objAutomationConfig.getConfigValues("StellURL");
   	 objDriver.get(objAutomationObjects.objAutomationConfig.getConfigValues(Url));;
		// objDriver.get(objAutomationObjects.objTestData.getTestData(Url));;
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_S);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to launch browser");
         throw new Exception();
         }  
}
public void clickOnUser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objUserBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.UserBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objUserBtn);
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find user setting btn webelement");
         throw new Exception();
         }  
}

public void clickOnLogoutBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objLogOutBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.UserLogoutBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objLogOutBtn);
     	Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:User Logout Successfully"); 
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Logout btn webelement");
         throw new Exception();
         }  
}

public void enterSystemUsername(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strUserName) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		String strUserNameTestData=objAutomationObjects.objTestData.getTestData("UserName");
		
		WebElement objUserName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Login.UsernameBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		
		objSeleniumEvents.clearTextBox(objUserName);
	    objSeleniumEvents.writeToTextBox(objUserName, strUserNameTestData);
			
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Username WebElement not found");
		throw new Exception();
		} 
	}

public void enterSystemPassword(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strPassword) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		String strPasswordTestData=objAutomationObjects.objTestData.getTestData("Password");
		
		WebElement objPassword = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Login.PasswordBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		
		objSeleniumEvents.clearTextBox(objPassword);
	    objSeleniumEvents.writeToTextBox(objPassword, strPasswordTestData);
			
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Password WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnSystemSignInBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
         objAutomationObjects.objLogger.logInfo("", false);
         WebElement objSignInBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Login.SignInBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
         objSeleniumEvents.clickButton(objSignInBtn);
     	Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:User SignIn Successfully"); 
         objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
         }
    catch (Exception e) {
         objAutomationObjects.objLogger.logErrorWithException(e);
         Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find sign In btn webelement");
         throw new Exception();
         }  
}

public void clickOnPlanningAndForecastingDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPlanForecastDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Plan.PlanDropdownBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPlanForecastDropdownBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Plan and Forecast dropdown WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnUserManagementBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserManagementBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.DelegateBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUserManagementBtn);
		objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:UserManagement btn WebElement not found");
		throw new Exception();
		} 
	}

public void validateUserManagementPageLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAlertMessage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.DelegatePagelabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		if(objAlertMessage != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:User Management page is appearing"); 
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:User Management page is not appearing");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL::User Management page webelement not found");
		} 
	}

public void clickOnUserManagementSearchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserSearchBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.SearchBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUserSearchBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:UserManagement Search btn WebElement not found");
		throw new Exception();
		} 
	}

public void enterUserInSearchBar(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserSearchField= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.SearchBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objUserSearchField);
		String UserName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.UserManag.UserSearch");
		objSeleniumEvents.writeToTextBox(objUserSearchField, UserName);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	    objAutomationObjects.objLogger.logErrorWithException(e);
        Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find User search field");
        throw new Exception();
	}  
}	
public void UpdateUserName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserNameField= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.FullNameBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objUserNameField);
		String UserName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.UserManag.UserIDUpdate");
		objSeleniumEvents.writeToTextBox(objUserNameField, UserName);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	    objAutomationObjects.objLogger.logErrorWithException(e);
        Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find User name field");
        throw new Exception();
	}  
}	
public void selectSearchedUser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUsersBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.SearchedUserBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUsersBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:UserManagement Searched user list WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnUserRemoveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserRemoveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.SearchedRemoveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUserRemoveBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:UserManagement Searched user remove WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnUserManagementCreateBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserCreateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.CreateUserBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUserCreateBtn);
		 objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:UserManagement create Button WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnAccessChannelDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccessChannelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.AccesschannelDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAccessChannelBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Access Channel Dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void enterUserNameForCreateUser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserNameField= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.FullNameBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objUserNameField);
		String UserName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.UserManag.UserName");
		objSeleniumEvents.writeToTextBox(objUserNameField, UserName);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	    objAutomationObjects.objLogger.logErrorWithException(e);
        Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find User name field");
        throw new Exception();
	}  
}	

public void enterUserIdForCreateUser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserIdField= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.UserIdBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objUserIdField);
		String UserName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.UserManag.UserId");
		objSeleniumEvents.writeToTextBox(objUserIdField, UserName);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	    objAutomationObjects.objLogger.logErrorWithException(e);
        Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find User Id field");
        throw new Exception();
	}  
}

public void enterUserNameForCloneUser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserNameField= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.FullNameBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objUserNameField);
		String UserName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.UserManag.UserNameClone");
		objSeleniumEvents.writeToTextBox(objUserNameField, UserName);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	    objAutomationObjects.objLogger.logErrorWithException(e);
        Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find User name field");
        throw new Exception();
	}  
}	

public void enterUserIdForCloneUser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserIdField= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.UserIdBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objUserIdField);
		String UserName = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.UserManag.UserIdClone");
		objSeleniumEvents.writeToTextBox(objUserIdField, UserName);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	    objAutomationObjects.objLogger.logErrorWithException(e);
        Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find User Id field");
        throw new Exception();
	}  
}
public void selectAccessChannel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAccessChannelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.AccesschannelOpt"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAccessChannelBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Access Channel Option WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnCountryDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCountryDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.CountryDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCountryDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Country Dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void selectCountry(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objCountryDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.CountryName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objCountryDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Country name WebElement not found");
		throw new Exception();
		} 
	}

public void enterEmailForCreateUser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objEmail= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.EmailAddressBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clearTextBox(objEmail);
		String UserEmail = Wave3AutomationObjects.objAutomationConfig.getConfigValues("Ignite.UserManag.Email");
		objSeleniumEvents.writeToTextBox(objEmail, UserEmail);
	     objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
	    objAutomationObjects.objLogger.logErrorWithException(e);
        Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find User Email field");
        throw new Exception();
	}  
}

public void clickOnLanguageDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLangDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.LanguageBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objLangDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Language dropdown WebElement not found");
		throw new Exception();
		} 
	}

public void selectLanguage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objLanguageNameBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.LanguageName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objLanguageNameBtn);
		   objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Language name WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnNetworkAccessBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objNetworkAccessBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.NetworkBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		//objSeleniumEvents.clickButton(objNetworkAccessBtn);
		Actions acc = new Actions(objDriver); 
		acc.moveToElement(objNetworkAccessBtn).perform(); 
		objSeleniumEvents.clickButton(objNetworkAccessBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Network Access WebElement not found");
		throw new Exception();
		} 
	}

public void clickOnHomeNetworkEntityDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objHomeNetworkEntityDropBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.HomeNetworkDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objHomeNetworkEntityDropBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Home Network Entity Dropdown WebElement not found");
		throw new Exception();
		} 
	}


public void selectNetworkEntity(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objHomeNetIdBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.HomeNetworkId"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objHomeNetIdBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Home Net Id WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnUserAppRolesBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserAppBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.AppRolesDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUserAppBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Application roles dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnBasicUserRole(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objBasicRoleBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.BasicRoleBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objBasicRoleBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Basic Role btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnSubmitterRole(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objSubmitterBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.SubmitterBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objSubmitterBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Submitter Role WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDataRolesBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDataRoleDropBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.DataRolesDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDataRoleDropBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Data Role Dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnReportRolesBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objReportRoleDropBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.ReportRolesDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objReportRoleDropBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Report Role Dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnDataAllRole(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDataAllRoleBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.DataAllBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objDataAllRoleBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Data All role btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnAllDealerReportRole(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objAllDealerReportBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.AllDealerReportBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objAllDealerReportBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:All Dealer Report Role Btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnUserSaveChanges(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserSaveChangeBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.SaveChnagesBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUserSaveChangeBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:User Save changes btn WebElement not found");
		throw new Exception();
		} 
	}
public void ClickOnSaveCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserSaveCloseBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.Save.CloseBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUserSaveCloseBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:User Save close btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnUserManagementCloneBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objUserCloneBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Delegate.CloneUserBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objUserCloneBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:User Clone btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastModelDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objModelDropdownBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.ModelDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objModelDropdownBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Model dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnModelListDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objModelListBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.ModelListDrop"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objModelListBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Model list dropdown WebElement not found");
		throw new Exception();
		} 
	}
public void selectModelName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objModelNameBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.ModelName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objModelNameBtn);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Model Name btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastPrivateCheckboxBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPrivateBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.PrivateCheckBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPrivateBtn);
		   objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast Private btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastPublishedCheckboxBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objPublishedBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.PublishedBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objPublishedBtn);
		   objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast Publish btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastDeleteBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		List<WebElement> DeleteBtn = objGenericFunctions.getListOfWebElementsFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.DeleteAllBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		int Forecast = DeleteBtn.size();
		System.out.println("All forecast entries..................." + Forecast);
		
	for(int i=0; i<Forecast;i++) {
		WebElement objForecastDeleteBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.DeleteBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objForecastDeleteBtn);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			WebElement objForecastDeleteYesBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.DeleteYesBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
			objSeleniumEvents.clickButton(objForecastDeleteYesBtn);
		    objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		                          }
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast Delete btn WebElement not found");
		throw new Exception();
		} 
	}
public void clickOnForecastDeleteYesBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objForecastDeleteYesBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Forecast.DeleteYesBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
		objSeleniumEvents.clickButton(objForecastDeleteYesBtn);
		   objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Forecast Delete Yes btn WebElement not found");
		throw new Exception();
		} 
	}


//**//                        Anushka's Code Start                                //**//


public void Dashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDashboardPageLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.DashboardPageLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		if(objDashboardPageLabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Dashbaord Page Label is Displayed");
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Dashbaord Page Label is NOT Displayed");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL: Unable to find Dashboard page Label");
		}
	}

public void NavigateToDashboard(Wave3AutomationObjects objAutomationObjects, WebDriver driver) throws Exception {
    try {
        objAutomationObjects.objLogger.logInfo("", false);
        WebElement dashboardLink = driver.findElement(By.id("DNS.Ignite.Dashboard"));
        dashboardLink.click();
        objAutomationObjects.objLogger.logInfo("", false);
    } catch (Exception e) {
        objAutomationObjects.objLogger.logErrorWithException(e);
        throw new Exception("Failed to navigate to Dashboard" );
    }
}

public void KPIAnalysis(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objKPIAnalysislabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.KPIAnalysis"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		if(objKPIAnalysislabel != null) {
			Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: KPI Analysis is Displayed");
		}
		else
		{
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: KPI Analysis is NOT Displayed");
			throw new Exception();
		}
	}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		throw new Exception("FAIL: Unable to find KPI Analysis");
		}
	}


public void clickOnNetworkDropdownA(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver)  throws Exception {
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objNetworkDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.DashboardDealer/Network"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objNetworkDropdown);
	objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Network dropdown WebElement");
	throw new Exception();
	} 
}

public void clickOnNetworkDropdownAC(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objNetworkDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.NetworkDropdwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objNetworkDropdown);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Network dropdown WebElement");
	throw new Exception();
	} 
}

public void clickOnNetworkListDropdownAC(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objNetworkListDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkListDropdwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objNetworkListDropdown);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Network List dropdown WebElement");
	throw new Exception();
	} 
}
public void clickOnSearchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objSearchBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.NetworkSearchBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objSearchBtn);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find search btn WebElement");
	throw new Exception();
	} 
}	

public void selectNetwork(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objNetworkName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.DashboardDealer.Globalbtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objNetworkName);
	objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find network name WebElement");
	throw new Exception();
	} 
}	

public void clickOnFilterDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objFilterDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.FilterDropdwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objFilterDropdown);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Filter dropdown WebElement");
	throw new Exception();
	} 
}	

public void clickOnBrandDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objBrandDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.BrandDropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objBrandDropdown);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Brand dropdown WebElement");
	throw new Exception();
	} 
}	

public void clickOnBrandListDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objBrandListDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.BrandListDropdwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objBrandListDropdown);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Brand list dropdown WebElement");
	throw new Exception();
	} 
}	

public void selectBrand(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objBrandSelection = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.BrandName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objBrandSelection);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to select name WebElement");
	throw new Exception();
	} 
}	

public void clickOnAverageDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objAverageDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.AverageDrpdwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objAverageDropdown);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Average dropdown WebElement");
	throw new Exception();
	} 
}	

public void clickOnAverageListDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objAverageDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.Averagelistdrpdwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objAverageDropdown);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Average list dropdown WebElement");
	throw new Exception();
	} 
}	


public void selectAverageIgnite(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objAverageName = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.Averagename"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objAverageName);
	}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to find Average name WebElement");
	throw new Exception();
	} 
}	


public void LabelNetworkDispersionOnGraph(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objNetworkDispersionLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphNetLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	if(objNetworkDispersionLabel != null) {
		Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Network Dispersion Label is Displayed");
	}
	else
	{
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Network Dispersion Label is NOT Displayed");
		throw new Exception();
	}
}
catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	throw new Exception("FAIL: Unable to find Network Dispersion Label");
	}
}

public void clickOnDownloadGraph(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDownloadNetGraph = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphNetDownldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objDownloadNetGraph);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Download WebElement");
		throw new Exception();
		} 
	

}

public void clickOnDepartmentDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objDepartmentDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.DeptDropdwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objDepartmentDropdown);
		}
	catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
		Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Dept WebElement");
		throw new Exception();
		} 
}

	public void clickOnDepartmentListDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDepartmentlistDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.DeptListDrpdwn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objDepartmentlistDropdown);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Click on List WebElement");
			throw new Exception();
			} 
	}
	public void clickOnDepartmentListDropdownForDealer(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objDepartmentlistDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.DeptListDrpDealer"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objDepartmentlistDropdown);
			objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
			}
		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Click on Dept List WebElement");
			throw new Exception();
			} 
	}
		
		public void selectdept(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objDepartmentlistDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.DeptnName"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objDepartmentlistDropdown);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to select Dept WebElement");
				throw new Exception();
				} 
		}
		
		public void selectdeptForDealer(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objDepartmentlistDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.DeptNameDealer"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objDepartmentlistDropdown);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to select Dept WebElement");
				throw new Exception();
				} 
		}
			
		public void clickOnPeriodDropdownAC(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objPeriodDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.PeriodDrpdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objPeriodDropdown);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Period Dropdown WebElement");
				throw new Exception();
				} 
		}	
		public void clickOnPeriodType(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objPeriodTypeBTN = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.PeriodTyoeBTN"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objPeriodTypeBTN);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Period Type BTN WebElement");
				throw new Exception();
				} 
		}
			
		public void ClickOnMonth(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objMonthBTN = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.Period.MonthBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objMonthBTN);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Month BTN WebElement");
				throw new Exception();
				} 
		}	
		public void ClickOnYearDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objYearDropdown = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.Period.YRDrpdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objYearDropdown);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click Year Dropdown WebElement");
				throw new Exception();
				} 
		}		
		public void ClickOnSelectedPeriod(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objSelectPeriod = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dashboard.Period.BTNMar24"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objSelectPeriod);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to select Period WebElement");
				throw new Exception();
				} 
		}	
		public void clickOnKPIPerfSettings(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objKPIerfSettings = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphKPISettingBTN"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objKPIerfSettings);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Setting"
						+ " BTN WebElement");
				throw new Exception();
				} 
		}
		public void SelectKPICheckbox1(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objKPICheckbox1 = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphKPICheckbox1"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objKPICheckbox1);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Checkbox1"
						+ " BTN WebElement");
				throw new Exception();
				} 
		}	
		public void SelectKPICheckbox2(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objKPICheckbox2 = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphKPICheckbox2"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objKPICheckbox2);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Checkbox2"
						+ " BTN WebElement");
				throw new Exception();
				} 
		}	
		public void SelectKPICheckbox3(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objKPICheckbox3 = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphKPICheckbox3"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objKPICheckbox3);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Checkbox3"
						+ " BTN WebElement");
				throw new Exception();
				} 
		}
		public void SelectKPICheckbox4(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objKPICheckbox4 = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphKPICheckbox4"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objKPICheckbox4);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Checkbox4"
						+ " BTN WebElement");
				throw new Exception();
				} 
		}			
		public void clickOnDashSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objSaveBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphKPISaveBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objSaveBtn);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Save"
						+ " BTN WebElement");
				throw new Exception();
				} 
		}	
		public void clickOnKPIGraphDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphKPIDwnldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objDownloadBtn);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Download"
						+ " BTN WebElement");
				throw new Exception();
				} 
		}			
		public void clickOnDelsectAll(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objDelselectAll = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphKPIDeselectBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objDelselectAll);
				}
			catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Deselect Btn"
						+ " BTN WebElement");
				throw new Exception();
				} 
		}	
public void clickOnSelectAll(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objselectAll = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphKPISlctAllBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objselectAll);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on select All Btn"
						+ " BTN WebElement");
throw new Exception();
	} 
}
	
public void clickOnDefaultKPIBTN(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objselectAll = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.KPISlctDefaultAllBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objselectAll);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on DefaultkPI Btn"
						+ " BTN WebElement");
throw new Exception();
	} 
}		
	public void clickOnPLdispersionSettings(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objPlsetting = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLSettingBTN"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objPlsetting);
			}
		catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
        Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on select All Btn"
							+ " BTN WebElement");
	throw new Exception();
		} 
	}	
		public void clickOnSelectKPI1(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objselectedKPI = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLKPICheckbox1"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objselectedKPI);
				}
			catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
            Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on KPI1 Btn"
								+ " BTN WebElement");
		throw new Exception();
			}  
}			
		public void clickOnSelectKPI2(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objselectedKPI2 = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLKPICheckbox2"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objselectedKPI2);
				}
			catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
            Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click KPI2 Btn"
								+ " BTN WebElement");
		throw new Exception();
			}  
		}
			
			public void clickOnSaveBTN1(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
				try {
					objAutomationObjects.objLogger.logInfo("", false);
					WebElement objsaveBTN = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLSaveBTN1"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
					objSeleniumEvents.clickButton(objsaveBTN);
					}
				catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
                Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on save Btn"
									+ " BTN WebElement");
			throw new Exception();
				}  
}



public void clickOnPLGraphDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
objAutomationObjects.objLogger.logInfo("", false);
WebElement objPLGraphDownload = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLDownload"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
objSeleniumEvents.clickButton(objPLGraphDownload);
}
catch (Exception e) {
objAutomationObjects.objLogger.logErrorWithException(e);
Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Download PL graph"
		+ " BTN WebElement");
throw new Exception();
}  

}

public void SelectAllKPIbtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
objAutomationObjects.objLogger.logInfo("", false);
WebElement objPLAllKPI = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLALLKPIBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
objSeleniumEvents.clickButton(objPLAllKPI);
}
catch (Exception e) {
objAutomationObjects.objLogger.logErrorWithException(e);
Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click On all Btn"
			+ " BTN WebElement");
throw new Exception();
}  
}



public void ClickOnDefaultKPIbtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
objAutomationObjects.objLogger.logInfo("", false);
WebElement objPLDefaultKPI = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLDefaultKPIBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
objSeleniumEvents.clickButton(objPLDefaultKPI);
}
catch (Exception e) {
objAutomationObjects.objLogger.logErrorWithException(e);
Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click On Default Btn"
				+ " BTN WebElement");
throw new Exception();
}  
}



public void clickOnPLMaxBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
try {
	objAutomationObjects.objLogger.logInfo("", false);
	WebElement objClickonMax = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLMaxBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
	objSeleniumEvents.clickButton(objClickonMax);
	}
catch (Exception e) {
objAutomationObjects.objLogger.logErrorWithException(e);
Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click On Max Btn"
					+ " BTN WebElement");
throw new Exception();
}  

}

public void ClickOnDownloadMaxBTN(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objClickonMaxDowload = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLMaxDownldBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objClickonMaxDowload);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click On Max download Btn"
						+ " BTN WebElement");
throw new Exception();
	}  
}



public void ClickOnSettingMaxBTN(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
	try {
		objAutomationObjects.objLogger.logInfo("", false);
		WebElement objClickonmaxSetting= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLMaxsetting"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
		objSeleniumEvents.clickButton(objClickonmaxSetting);
		}
	catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click On Max setting Btn"
						+ " BTN WebElement");
throw new Exception();
	}  
}
	
	
	public void ClickOnCheckbox1(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
		try {
			objAutomationObjects.objLogger.logInfo("", false);
			WebElement objClickoncheck1= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLMaxCheck1"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
			objSeleniumEvents.clickButton(objClickoncheck1);
			}
		catch (Exception e) {
		objAutomationObjects.objLogger.logErrorWithException(e);
	    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click On check1 Btn"
							+ " BTN WebElement");
	throw new Exception();
		}  
	}
	
		public void ClickOnCheckbox2(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
			try {
				objAutomationObjects.objLogger.logInfo("", false);
				WebElement objClickoncheck2= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLMaxCheck2"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
				objSeleniumEvents.clickButton(objClickoncheck2);
				}
			catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
		    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click On check2 Btn"
								+ " BTN WebElement");
		throw new Exception();
			}  
		}		
			public void ClickOnMaxSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
				try {
					objAutomationObjects.objLogger.logInfo("", false);
					WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLMaxSave"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
					objSeleniumEvents.clickButton(objClickonMaxsave);
					}
				catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
			    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click On save maxBtn"
									+ " BTN WebElement");
			throw new Exception();
				}  }		
				public void ClickMaxAllKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
					try {
						objAutomationObjects.objLogger.logInfo("", false);
						WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLMaxAllKPI"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
						objSeleniumEvents.clickButton(objClickonMaxsave);
						}
					catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
				    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click On All KPI Max"
				    		+ "Btn"
										+ " BTN WebElement");
				throw new Exception();
					}  
				}	
				public void ClickOnDefaultKPIMaxbtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
					try {
						objAutomationObjects.objLogger.logInfo("", false);
						WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Dash.GraphPLMaxDefaultKPI"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
						objSeleniumEvents.clickButton(objClickonMaxsave);
						}
					catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
				    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click On Default KPI Max"
				    		+ "Btn"
										+ " BTN WebElement");
				throw new Exception();
					}  
				}

					
			
			
		//****//                           Anushka's Code End	                                //**//
			
			
//**//                           Geo Generator                                              //**//
				
				
				public void clickonAdminitration(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
					try {
						objAutomationObjects.objLogger.logInfo("", false);
						WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.Geo.Admin.Dropdown"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
						objSeleniumEvents.clickButton(objClickonMaxsave);
						}
					catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
				  Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Administration BTN WebElement");
				  throw new Exception();
					}  
				}	
	
				public void clickonGeogenerator(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
					try {
						objAutomationObjects.objLogger.logInfo("", false);
						WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.Geo.Select.Geogenerator"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
						objSeleniumEvents.clickButton(objClickonMaxsave);
						}
					catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
				  Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on GeoGenerator BTN WebElement");
				  throw new Exception();
					}  
				}	
				 
				 
				public void clickonfetchlocations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
					try {
						objAutomationObjects.objLogger.logInfo("", false);
						WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.Geo.Click.FetchLocation"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
						objSeleniumEvents.clickButton(objClickonMaxsave);
						}
					catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
				  Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to click on Fetchlocations BTN WebElement");
				throw new Exception();
					}
				}
				 
				 
				public void clickonSave(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
					try {
						objAutomationObjects.objLogger.logInfo("", false);
						WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.Geo.savelocation.btn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
						objSeleniumEvents.clickButton(objClickonMaxsave);
						}
					catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
				  Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to save locations BTN WebElement");
				throw new Exception();
				}
				}
				 
				public void clickonreload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
					try {
						objAutomationObjects.objLogger.logInfo("", false);
						WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.Geo.Reload.Btn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
						objSeleniumEvents.clickButton(objClickonMaxsave);
						}
					catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
				  Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to reload BTN WebElement");
				 throw new Exception();
				                }
				}
				 
				public void validatereload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
					try {
						objAutomationObjects.objLogger.logInfo("", false);
						WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.Geo.Reload.Text"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
						objSeleniumEvents.clickButton(objClickonMaxsave);
						}
					catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
				  Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to reload BTN WebElement");
			     	throw new Exception();
			                  	}
				}
				 
					public void validatesavepage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.Geo.Save.Status.Btn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objClickonMaxsave);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					  Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to validate save BTN WebElement");
					throw new Exception();
					}
				}
					
					public void validateGeoGeneratorPageLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objNetworkDispersionLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.Geo.Label"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							if(objNetworkDispersionLabel != null) {
								Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Geo generator page Displayed");
							}
							else
							{
								Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Geo generator page Label is NOT Displayed");
								throw new Exception();
							}
						}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception("FAIL: Unable to find Network Geo generator Label web element");
							}
						}
					
					public void validateDealerReloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objDealerReloadLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.Geo.Reload.Btn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							if(objDealerReloadLabel != null) {
								Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Dealers reload successfully");
							}
							else
							{
								Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealers not reload");
								throw new Exception();
							}
						}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception("FAIL: Unable to find Dealer reload Btn web element");
							}
						}
					
					public void validateLatAndLongDetails(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objNetworkDispersionLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.Geo.Lat&LongEntry"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							if(objNetworkDispersionLabel != null) {
								Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Latitude and longitude generated");
							}
							else
							{
								Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Latitude and longitude not generated");
								throw new Exception();
							}
						}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception("FAIL: Unable to find Latitude and longitude web element");
							}
						}
					
					public void validateCoordinateTickBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objSaveTickBtnLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.Geo.Save.Status.Btn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							if(objSaveTickBtnLabel != null) {
								Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Dealer coordinates saved");
							}
							else
							{
								Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Dealer coordinates not saved");
								throw new Exception();
							}
						}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception("FAIL: Unable to find saved tick btn web element");
							}
						}
					
	 //**//                  Quick Reports                                     //**//
					
					public void scrollondashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.QuickReports.section"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objClickonMaxsave);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to scroll BTN WebElement");
					     throw new Exception();
					                  }
					}
					 
					public void clickonexceldownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.QuickReports.downloadexcel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objClickonMaxsave);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to download BTN WebElement");
					   throw new Exception();
					                  }
						}
					 
					public void clickonPDFdownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objClickonMaxsave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.QuickReports.downloadpdf"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objClickonMaxsave);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to download BTN WebElement");
				      	throw new Exception();
				                     	}
					}	
					
					public void verifyquickreport(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objQuickReportsLabel = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.QuickReports.section"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							if(objQuickReportsLabel != null) {
								Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Quick Reports section appearing");
							}
							else
							{
								Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Quick Reports section not appearing");
								throw new Exception();
							}
						}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception("FAIL: Unable to find Quick Report label web element");
							}
						}
					
					public void verifyQuikReportDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objQuickReportsDownloadBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ign.QuickReports.downloadexcel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							if(objQuickReportsDownloadBtn != null) {
								Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Quick Report Dowmloaded");
							}
							else
							{
								Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Quick Reports not download");
								throw new Exception();
							}
						}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception("FAIL: Unable to find Quick Report Download Btn web element");
							}
						}
					
					//**                     Validation Rule                                 //**//
					
					
					
					public void ClickOnValidationRuleEditor(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objClickOnValidationRuleEditor= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidationBtn"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objClickOnValidationRuleEditor);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to open ValidationRule Editor WebElement");
					throw new Exception();
						}  
					}
					 
					public void ValidationPageshouldBeVisible(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objValidationPage = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidationLabel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							if(objValidationPage != null) {
								Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Validation Page appearing");
							}
							else
							{
								Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Validation page not appearing");
								throw new Exception();
							}
						}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception("FAIL: Unable to find Validation Rule Editor Label");
							}
					}
					 
					 
					 
					public void ClickonEdit(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objEditBtn= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.EditButton"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objEditBtn);
							objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Edit WebElement");
					throw new Exception();
						}  
					}
					 
					public void clickOnMinimumError(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objMinError = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.MinimumError"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
							objSeleniumEvents.clickButton(objMinError);
							
							}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Min error field WebElement not found");
							throw new Exception();
							}
						}
					 
					 
					public void EnterMinimumError(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objMinErrorField = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.EnterMinimumError"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
							objSeleniumEvents.clearTextBox(objMinErrorField);
							objSeleniumEvents.writeToTextBox(objMinErrorField, "100");
							}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Min error field btn WebElement not found");
							throw new Exception();
							}
						}
					 
					public void clickOnMinimumWarning(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objMinError= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.MinimumWarning"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objMinError);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Edit Minimum Warning WebElement");
					throw new Exception();
						}  
					}
					 
					 
					public void EnterMinimumWarning(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objMinWaring = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.EnterMinimumWarning"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
							objSeleniumEvents.clearTextBox(objMinWaring );
							objSeleniumEvents.writeToTextBox(objMinWaring , "100");
							}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Min Warning field btn WebElement not found");
							throw new Exception();
							}
						}
					 
					 
					public void clickOnRule(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objRule= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidationRule"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objRule);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Rule WebElement not found");
					throw new Exception();
						}  
					}
					 
					 
					public void EnterRule(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objRule = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.EnterRule"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
							objSeleniumEvents.clearTextBox(objRule);
							objSeleniumEvents.writeToTextBox(objRule , "100");
							}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Rule field  WebElement not found");
							throw new Exception();
							}
						}
					 
					 
					public void clickOnMaxWarning(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objMaxWrning= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.MaxWarning"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objMaxWrning);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Edit Maximum Warning WebElement");
					throw new Exception();
						}  
					}
					 
					 
					public void EnterMaxWarning(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objMaxWarning = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.EnterMaxWarning"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
							objSeleniumEvents.clearTextBox(objMaxWarning);
							objSeleniumEvents.writeToTextBox(objMaxWarning , "300");
							}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Max Warning field  WebElement not found");
							throw new Exception();
							}
						}
					 
					 
					public void ClickonMaxError(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objMaxError= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.MaxError"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objMaxError);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Click Max Error WebElement");
					throw new Exception();
						}  
					}
					 
					public void EnterMaxError(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objMaxError = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.EnterMaxError"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
							objSeleniumEvents.clearTextBox(objMaxError);
							objSeleniumEvents.writeToTextBox(objMaxError , "200");
							}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Max Warning field  WebElement not found");
							throw new Exception();
							}
						}
					 
					public void ClickOnEditHistory(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objEditHistory= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.EditHistory"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objEditHistory);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Edit History WebElement not found");
					throw new Exception();
						}  
					}
					 
					public void CloseEditHistory(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objCloseHistory= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.CloseHistory"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objCloseHistory);
							 Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Validation Rule is editable");
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Close Edit History WebElement not found");
					throw new Exception();
						}  
					}
					 
					public void ValidateEditField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objEditFileds= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidationFields"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objEditFileds);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to validate Fields WebElement");
					throw new Exception();
						}  
					}
					 
					 
					 
					public void ClickonSearchBox(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objSearchBox= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidationSearch"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objSearchBox);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Search Validation WebElement");
					throw new Exception();
						}  
					}
					 
					public void EnterValidation(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objValidationValue = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidationSearchBox"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
							objSeleniumEvents.clearTextBox(objValidationValue);
							objSeleniumEvents.writeToTextBox(objValidationValue, "A15");
							}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Validation Value  WebElement not found");
							throw new Exception();
							}
						}
					 
					public void SearchResult(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strPassword) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objValidatesearch = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidateSearchResult"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);		
							objSeleniumEvents.clearTextBox(objValidatesearch);
							objSeleniumEvents.writeToTextBox(objValidatesearch, "A15");
							
							}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Search Rule  WebElement not found");
							throw new Exception();
							}
						}
					 
					 
					public void ClickOnDownloadValidation(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objDownloadValidation= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.DownloadValidation"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objDownloadValidation);
							objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
							 Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Validation rules downloaded");
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Downlaod WebElement");
					throw new Exception();
						}  
					}
					 
					public void ValidateSearchResult(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objDownload = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidateSearchResult"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							if(objDownload != null) {
								Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Validation Rule searched successfully");
							}
							else
							{
								Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Validation Rule not searched");
								throw new Exception();
							}
						}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception("FAIL: Unable to Download");
							}
					}
					public void ClickoValidationSaveBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objSave= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidationSave"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objSave);
							objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
							 Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Validation rules saved");
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Save WebElement");
					throw new Exception();
						}  
					}
					 
					 
					public void ClickoValidationCancelBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objCancel= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidationCancel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objCancel);
							objGenericFunctions.sleepSome(objAutomationObjects, objGenericFunctions.SLEEP_XS);
							 Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS:Validation rules edit canceled");
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Cancel WebElement");
					throw new Exception();
						}  
					}
					 
					public void ValidateCancelRules(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objCancelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidationCancel"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							if(objCancelBtn != null) {
								Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Validation Cancel");
							}
							else
							{
								Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Validation Not Cancel");
								throw new Exception();
							}
						}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception("FAIL: Unable to find save Button");
							}
					}
					 
					public void ClickonValidationFilter(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception{
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objFilter= objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidationFilter"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							objSeleniumEvents.clickButton(objFilter);
							}
						catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
					    Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL:Unable to Filter WebElement");
					throw new Exception();
						}  
					}
					 
					 
					public void ValidateUserAbletoFilter(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", false);
							WebElement objCancelBtn = objGenericFunctions.getWebElementFromLocator(objAutomationObjects, objDriver, objAutomationObjects.objObjectMAP.getLocator("DNS.Ignite.Validation.ValidationFilter"), objGenericFunctions.WAITFORPRESENCE_XS, objGenericFunctions.SLEEP_XXS);
							if(objCancelBtn != null) {
								Wave3AutomationObjects.objTestResult.prepareResultCollection("PASS: Validate Filter");
							}
							else
							{
								Wave3AutomationObjects.objTestResult.prepareResultCollection("FAIL: Not Validate Filter");
								throw new Exception();
							}
						}
						catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception("FAIL: Unable to find save Button");
							}
					}
	
}
	
