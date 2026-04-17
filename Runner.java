package runnerPackage;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import wave3CoreAutomation.*;

public class Runner extends Wave3AutomationBaseClass {
	
	static
	{
		System.setProperty("log4j.configurationFile", "file:/D:/Wave3/log4j2.properties");	//For log4j configuration file
	}

	static Wave3GenericFunctionDefinition objFunctionDefinition = new Wave3GenericFunctionDefinition(objAutomation);

	public static void main(String[] args) throws Exception {
		
		PropertiesConfiguration props = objFunctionDefinition.getPropertiesConfiguration();

		String strBrowserArray[] = objFunctionDefinition.getAllBrowserArray();
		String[] listOfDatasets = objFunctionDefinition.getAllDatasetArray();

		for (int intBrowserCount = 0; intBrowserCount < strBrowserArray.length; intBrowserCount++) {

			objFunctionDefinition.setActiveBrowser(props, strBrowserArray[intBrowserCount]);
			objFunctionDefinition.addDatasetIntoList();
			objFunctionDefinition.sendMailForAllDatasets(strBrowserArray[intBrowserCount], Wave3GenericFunctionDefinition.listOfAllDatasets);

			for (Wave3AutomationObjects.intDataSetCount = 0; Wave3AutomationObjects.intDataSetCount < listOfDatasets.length; Wave3AutomationObjects.intDataSetCount++) {
				
				objFunctionDefinition.setActiveDataset(props, listOfDatasets[Wave3AutomationObjects.intDataSetCount]);
				if (Wave3GenericFunctionDefinition.getStrIsExcel().equalsIgnoreCase("True")) 
				{
				
					// System.setProperty("cucumber.options","--tags"+ strAutomationProperty);
		//		objFunctionDefinition.updateFeatureFiles();
					
					runSuiteWithJunitUsingTestRunner();
					objFunctionDefinition.gettingSuiteReadyForExecution();
					runSuiteWithJunitUsingTestRunner();
					if(objFunctionDefinition.isSuiteReadyForSSOExecution(props)) {
						objFunctionDefinition.gettingSuiteReadyForExcel();
				        runSuiteWithJunitUsingTestRunner();
					    objFunctionDefinition.gettingSuiteReadyForExecution();
					    runSuiteWithJunitUsingTestRunner();}
				} 
				else {
					runSuiteWithJunitUsingTestRunner();
				}
			}
			objFunctionDefinition.resetDatasetCount();
		}
	}
		
	private static void runSuiteWithJunitUsingTestRunner() {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		junit.run(TestRunner.class);
	}

}
