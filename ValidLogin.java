package stepDefinition.CommonFeatures;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import stepDefinition.Wave3ApplicationFunctionLibrary;
import wave3CoreAutomation.*;


//Class hold glue code for valid login scenario -- "THE" only scenario in valid login feature
public class ValidLogin extends wave3CoreAutomation.Wave3AutomationBaseClass{
	public  static Wave3AutomationObjects objAutomationObjects = new Wave3AutomationObjects("D");
	
	public Wave3ApplicationFunctionLibrary objApplicationFunctionLibrary= new Wave3ApplicationFunctionLibrary();
	public Wave3GenericFunctionDefinition objGenericSteps = new Wave3GenericFunctionDefinition(objAutomationObjects); 
	
	//Feature:ValidLogin || Scenario:Valid Application Login --> START
		@Given("^Application Is Launched$")
		public void application_Is_Launched() throws Throwable 
		{
			setBrowser(objGenericSteps, objAutomationObjects); // This is will open the browser
			objApplicationFunctionLibrary.launchApplication(objAutomationObjects, Driver); //This will hit url and launch dns application
		}
		
		@Given("^User is At Home Page of Google Search$")
		public void user_is_At_Home_Page_of_Google_Search() throws Throwable {
//		    // Write code here that turns the phrase above into concrete actions
//		    throw new PendingException();
		}
		@Given("^User is at login page$")
		public void user_is_at_login_page() throws Throwable {
			objApplicationFunctionLibrary.loginPage(objAutomation, Driver);
		}

		
		//Method Call For Authentication whether from Config Properties File or From  Test Data For Credential Values
			@When("^User Authenticate$") 
			public void user_Authenticate() throws Throwable 
			{
				objApplicationFunctionLibrary.authenticateUser(objAutomationObjects, Driver, Wave3AutomationObjects.objAutomationConfig.getConfigValues(Wave3AutomationObjects.objAutomationConfig.getConfigValues("Application")+"UserID"), Wave3AutomationObjects.objAutomationConfig.getConfigValues(Wave3AutomationObjects.objAutomationConfig.getConfigValues("Application")+"Portal"),Wave3AutomationObjects.objAutomationConfig.getConfigValues(Wave3AutomationObjects.objAutomationConfig.getConfigValues("Application")+"MailId"), Wave3AutomationObjects.objAutomationConfig.getConfigValues(Wave3AutomationObjects.objAutomationConfig.getConfigValues("Application")+"UserRoles"), false);
			}
			
			@When("^User Authenticate to Relogin$") 
			public void user_Authenticate_to_Relogin() throws Throwable 
			{
				objApplicationFunctionLibrary.authenticateUser(objAutomationObjects, Driver, Wave3AutomationObjects.objTestData.getTestData("UserID"), Wave3AutomationObjects.objTestData.getTestData("Portal"),Wave3AutomationObjects.objTestData.getTestData("MailId"), Wave3AutomationObjects.objTestData.getTestData("UserRole"), true);
			}

			@When("^Initialize Application$")
			public void initialize_Application() throws Throwable 
			{
				if(Wave3AutomationObjects.objAUT.getConfigValues("IsExcel").equals("True"))
				{
					Wave3AutomationObjects.objTestResult.prepareMethodTrace("When Initialize Application");
				}
				//objApplicationFunctionLibrary.initializeApplication(objAutomation, Driver); 
			}
			@When("^User enter valid login credentials$")
			public void user_enter_valid_login_credentials() throws Throwable {
				
				String pass=Wave3AutomationObjects.objAutomationConfig.getPassword("DNSPassword");
				
				objApplicationFunctionLibrary.enterUserCredntials(objAutomationObjects,Driver, Wave3AutomationObjects.objAutomationConfig.getConfigValues(Wave3AutomationObjects.objAutomationConfig.getConfigValues("Application")+"UserName"),Wave3AutomationObjects.objAutomationConfig.getPassword("DNSPassword"));
		
			}
			
			@Given("^User logout from current system$")
			public void user_logout_from_current_system() throws Throwable {
				objApplicationFunctionLibrary.logoutFromApplication(objAutomationObjects,Driver);
				//objApplicationFunctionLibrary.launchBrowser(objAutomationObjects,Driver);
			}
			
			@When("^User enter stellantis system login credentials$")
			public void user_enter_stellantis_system_login_credentials() throws Throwable {
	           String pass=Wave3AutomationObjects.objAutomationConfig.getPassword("StellPassword");
				
				objApplicationFunctionLibrary.enterUserCredntials1(objAutomationObjects,Driver, Wave3AutomationObjects.objAutomationConfig.getConfigValues(Wave3AutomationObjects.objAutomationConfig.getConfigValues("Application")+"StellUsername"),Wave3AutomationObjects.objAutomationConfig.getPassword("StellPassword"));
		
			}
			//Wave3AutomationObjects.objAutomationConfig.getConfigValues(ColumnNameInFile);  //old method
			//Wave3AutomationObjects.objAutomationConfig.getPassword(ColumnNameInFile);   // new method for password encryption
			
			@Then("^Application Available For Use$")
			public void application_Available_For_Use() throws Throwable 
			{
				if(Wave3AutomationObjects.objAUT.getConfigValues("IsExcel").equals("True"))
				{
					Wave3AutomationObjects.objTestResult.prepareMethodTrace("Then Application Available For Use");
				}
			}
			
			@Then("^Login Page available to login$")
			public void login_Page_available_to_login() throws Throwable {
				objApplicationFunctionLibrary.loginPageScreen(objAutomationObjects, Driver);
			}

			@Then("^User should be able to login into application$")
			public void user_should_be_able_to_login_into_application() throws Throwable {
				objApplicationFunctionLibrary.validateUserAtDashboardPage(objAutomation, Driver);
			}
			//Feature:ValidLogin || Scenario:Valid Application Login --> END
			
			// ***** Generic Constructs ***** //
			@Before 	
			public void beforeHook(Scenario scenario) throws Exception	
			{  
				objGenericSteps.beforeHook(scenario);
			}
			
			@SuppressWarnings("static-access")
			@After 		
			public void afterHook(Scenario scenario) throws Exception	
			{ 
//				if(objGenericSteps.getNormalMethodExecutionFlag())
//			
//			{
//				objApplicationFunctionLibrary.closeAnyOpenedPopUp(objAutomation, Driver);
				objGenericSteps.afterHook(scenario);
				
			}		
		}
