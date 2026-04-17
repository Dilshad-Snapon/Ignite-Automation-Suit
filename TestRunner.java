package runnerPackage;
import org.junit.runner.RunWith;

import wave3CoreAutomation.UtilityClasses.UtilTestResult;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
//Essentials reference to support functionality of class and methods in it import org.junit.runner.RunWith; import cucumber.api.CucumberOptions; import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)

@CucumberOptions(   
		 features= {
//			 "D:\\Automation_Sceduled_Job\\Features",
				 "Features\\00-ValidLogin.feature",
				 "Features\\01-Map.feature",
				 "Features\\02-Dashboard.feature",
				 "Features\\03-Opportunity.feature",
				 "Features\\04-DNSAnalysis.feature",
				 "Features\\05-DNSSubmit.feature",
				 "Features\\06-SubmissionManager.feature",
				 "Features\\07-AccountMaps.feature",
				 "Features\\08-DNSProfile.feature",
				 "Features\\09-NewsflashManager.feature",
				 "Features\\10-PublishedReports.feature",
				 "Features\\11-FlexibleReports.feature",
				 "Features\\12-ImitateUser.feature",
				 "Features\\13-DNSLibrary.feature",
				 "Features\\14-Alerts.feature",
				 "Features\\15-UserSetting.feature",
				 "Features\\16-DnsPlan.feature",
				 "Features\\17-UserManagement.feature",
				 "Features\\18-Forecast.feature",
				 "Features\\19-GeoGenerator.feature",
				 "Features\\20-QucikReports.feature",
				 "Features\\21-ValidationRule.feature",
				 "Features\\25-SystemLoginCheck.feature",
  			     "Features\\zzz-TearDown.feature"
				 },
//				 glue = {"glueCode" }
		 glue = { "stepDefinition" }
		,tags = {"@Run0,@Run1A,@Run1,@Run2A,@Run2A!,@Run2,@Run3,@Run4,@Run5,@Run6,@Run7,@Run8,@Run9,@Run10,@Run11,@Run12,@Run13,@Run16,@Run17,@Run18,@Run19,@Run20,@Run21,@RunZ"}
		//,tags = {"@Run0,@Run21,@RunZ"}
		 //plugin = {"rerun:target/rerun.txt"}
		 )
// validateVININfoLink
 
// Main runner class from where automation execution start
public class TestRunner
{
	static UtilTestResult objResult = new UtilTestResult();
	@BeforeClass
    public static void setUp() throws Exception 
	{
		objResult.logsSessionStart();
    }

    @AfterClass
    public static void tearDown()throws Exception
    {
		objResult.logsSessionEnded();
    }
}

