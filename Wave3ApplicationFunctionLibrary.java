package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import wave3GenericAutomation.Wave3GenericFunctionalLibrary;
//import wave3GenericAutomation.Exception;
import wave3CoreAutomation.Wave3AutomationObjects;
import wave3CoreAutomation.Wave3GenericFunctionDefinition;

//ApplicationFunctionLibrary class would call the methods of Action class
@SuppressWarnings("static-access")
//public class Wave3ApplicationFunctionLibrary<objAutomationObjects> extends Wave3GenericFunctionalLibrary {

public class Wave3ApplicationFunctionLibrary extends Wave3GenericFunctionalLibrary  {
	

	Wave3ApplicationSteps objApplicationSteps = new Wave3ApplicationSteps();
	Wave3AutomationObjects objAutomationObjects = new Wave3AutomationObjects("D");
	Wave3GenericFunctionDefinition objGenericFunction = new Wave3GenericFunctionDefinition(objAutomationObjects);

	public void authenticateUser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver,
			String strUserNameSource, String strPortalSource,String strUserMailID, String strUserRole, boolean isRelogin) throws Exception {
		try {
//        objAutomationObjects.objLogger.logInfo("",true);

			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.enterUserId(objAutomationObjects, objDriver, strUserNameSource);
				objApplicationSteps.choosePortalFromDropDown(objAutomationObjects, objDriver, strPortalSource);
				objApplicationSteps.chooseDeploymentAddress(objAutomationObjects, objDriver);
				objApplicationSteps.selectWEBEPCCheckBox(objAutomationObjects, objDriver, isRelogin);
				objApplicationSteps.enterMailId(objAutomationObjects, objDriver, strUserMailID);
				objApplicationSteps.selectWEBAdminCheckBox(objAutomationObjects, objDriver, strUserRole);
				objApplicationSteps.selectGMAVCheckBox(objAutomationObjects, objDriver, strUserRole);
				objApplicationSteps.clickLaunchButton(objAutomationObjects, objDriver);
				objApplicationSteps.switchToNewWindow(objAutomationObjects, objDriver);
		//		objApplicationSteps.checkLicensePage(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		}

		catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}

	}
	
	public void goToHome(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.gotoHome(objAutomationObjects, objDriver);
	//			objApplicationSteps.userCloseAllOpenedJob(objAutomationObjects, objDriver);
//				objGenericFunction.sleepSome(objAutomationObjects, objGenericFunction.SLEEP_S);	//commented by saurabh
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}

	}

	public void userPerformSearchAtHomePage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.userPerformSearch(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}

	}
	
	public void validatSearchResultAtHomePage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateSearchResult(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}

	}
	public void loginPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.loginPageImage(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}

	}
	
	public void loginPageScreen(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.loginPageView(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}

	}
	
	
	public void userClickOnHelpBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.helpAndSupportbtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}

	}
	
	public void validateUserAtHelpPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.switchToChildWindow(objAutomationObjects, objDriver);
				objApplicationSteps.supportCloseBtn(objAutomationObjects, objDriver);
				objApplicationSteps.switchToParentWindow(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}

	}
	
	public void enterUserCredntials(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strUserName, String strPassword) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.enterUserName(objAutomationObjects, objDriver, strUserName);
				objApplicationSteps.enterPassword(objAutomationObjects, objDriver, strPassword);
				objApplicationSteps.clicksOnSignInBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}

	}
	
	public void enterUserCredntials1(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strStellUsername, String strStellPassword) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.enterUserName1(objAutomationObjects, objDriver, strStellUsername);
				objApplicationSteps.enterPassword1(objAutomationObjects, objDriver, strStellPassword);
				objApplicationSteps.clicksOnSignInBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}

	}
	
	public void validateUserAtDashboardPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.dashboardPageLabel(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}

	}
	
	public void dashboardPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnDashboardDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSelectedNetwork(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	

	public void MapBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkTree(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnMapViewBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void validateUserNavigateToMapViewPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.vlaidateUserAtMapViewPage(objAutomationObjects, objDriver);
				//objApplicationSteps.clickOnMapFilterBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void mapForMarketSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				//objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);  // Enable this for single market system
				//objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);  // Enable this for single market system
 
				objApplicationSteps.clickOnFilterBtn(objAutomationObjects, objDriver);     // Disable this for single market system
				objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
				objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
				objApplicationSteps.selectName(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnMapViewBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void mapForDealerSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnFilterBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
				objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
				objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateMapBtnNotAvailableForDealerSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.vlaidateMapAvailableInDashboardPage(objAutomationObjects, objDriver);
				//objApplicationSteps.clickOnMapFilterBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void mapViewPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnDashboardDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSelectedNetwork(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnFilterBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnMapViewBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void fullPageMapView(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnMapFullPageBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateFullPageMapView(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.dashboardPageLabelNotAppear(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void mapViewdepartments(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnMapDepartmentDropDown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnMapDepartmentName(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateDepartmentSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateDepartmentName(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void mapViewDeptKpi(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnMapDepartmentKpiDropDown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnMapDepartmentKpiName(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateDepratmentKpiSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateDepartmentKpiName(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void clickOnMap(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.moveToCountry(objAutomationObjects, objDriver);
				//objApplicationSteps.clickOnCountry(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateMapSelectionDetails(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				//objApplicationSteps.validateDepartmentKpiName(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnLevelUpBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void MapZoomInAndOut(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnMapZoomInBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnMapZoomOutBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateMapSize(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnLevelUpBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void ClickOnDealerMap(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnLevelUpBtn(objAutomationObjects, objDriver);
				objApplicationSteps.moveToDealer(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void validateMapDealerSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnLevelUpBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void GlobalSelectionInNetwork(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				//objApplicationSteps.clickOnFilterBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkTree(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void clickOnDashboardPageBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnFilterBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void clickOnDashboardNetworkSelectorBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void clickOnDashboardNetworkSelectorBtnForKPIPerformanceChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnNetworkDropdownForKpiPerforanceChart(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void validateNetworkClose(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateNetworkSelectorFilterClose(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	
	public void GlobalSelectionInNetworkForPerformanceVariationChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkTree(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void GlobalSelectionInNetworkForNetworkDispersionChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkTree(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void GlobalSelectionInNetworkForPlDispersionChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkListDropdownForPlDispersionChart(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkTree(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateNetworkDispersionChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateNetworkDispersionChart(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void dealershipValueOfMarket(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.dealershipValue(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void bubbleSizeOfMarket(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateNetworkDispersionChart(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void networkDispersionZoomInAndZoomOut(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnZoomInBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnZoomOutBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateBubbleSizeAfterResize(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateNetworkDispersionZoomInAndZoomOutOptions(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void networkDispersionDownloadButton(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnNetworkDispersionDownloadBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void networkDispersionExcelDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateNetworkDispersionDownloadBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void dashboardMarketSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
				objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
				objApplicationSteps.selectName(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void dashboardMarketSelectionForKpiPerformance(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkListDropdownForKpiPerformance(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
				objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
				objApplicationSteps.selectName(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void dashboardDealerSelectionForKpiPerformance(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnFilterExpandBtnForOpportunity(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkListDropdownForKpiPerformance(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
				objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
				objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateMarketDispersionChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateMarketDispersionChart(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void marketDispersionDownloadButton(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnMarketDispersionDownloadBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void marketDispersionExcelDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateMarketDispersionDownloadBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void readChartValues(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.readDispersionChartValues(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void validateChartvalues(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnMarketDispersionDownloadBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	
	
	
	//Existing components functions
	
	
	
	public void validateUserLoginSuccesfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				//objApplicationSteps.validateDashboardPage(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	
	public void validateUserAtDashboardpage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				//objApplicationSteps.validateNetworkHierarchyField(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnDashboardPageBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	
	public void enterDealerInNetworkHierarchy(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.enterDealer(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void selectMarketFromNetworkHierarchy(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				//objApplicationSteps.enterDealerForPublishedReport(objAutomationObjects, objDriver);
				//objApplicationSteps.selectDealerMore(objAutomationObjects, objDriver);
				
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
				objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
				objApplicationSteps.selectName(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void selectGivenDealerInNetworkHierarchy(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.selectDealer(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateUserAtDealerDashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.DealerDashboardPanelHeading(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	
	public void validatePeriodSelector(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnPeriodCalenderBtn(objAutomationObjects, objDriver);
				objApplicationSteps.selectYear(objAutomationObjects, objDriver);
				objApplicationSteps.selectMonth(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateSelectedPeriodOnDashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				//objApplicationSteps.validatePeriodName(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateMeasureSelector(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnMeasureDropdownBtn(objAutomationObjects, objDriver);
				objApplicationSteps.selectMeasureMTD(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateSelectedMeasureOnDashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateMeasureName(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateKPISelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnKPISettingBtn(objAutomationObjects, objDriver);
				//objApplicationSteps.clickOnSelectAllItemBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSelectAndDeselectAllItemBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnKPISettingBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnDefaultItemBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateKPIOnSlider(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				//objApplicationSteps.clickOnKPIItem(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSliderBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSliderKPIItem(objAutomationObjects, objDriver);
				objApplicationSteps.ValidateSelectedItemCalcSection(objAutomationObjects, objDriver);
				objApplicationSteps.ValidateSelectedItemGraphSection(objAutomationObjects, objDriver);
				objApplicationSteps.closeKPIItemPage(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateKPIGridSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.selectGridSelection(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateKPIInGridView(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				//objApplicationSteps.validateKpiInGrid(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnGridKpi(objAutomationObjects, objDriver);
				objApplicationSteps.closeKPIItemPage(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	
	public void validateKPISelectionInDeptOverview(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnDeptOverviewSettingBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSelectAndDeselectAllItemBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnDeptOverviewSettingBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnDefaultItemBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnDeptOverviewSettingBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnAnotherDept(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSelectAndDeselectAllItemBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnDeptOverviewSettingBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnAnotherDept(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnDefaultItemBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateKPIInDeptOverView(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				//objApplicationSteps.validateSumaryDeptKpi(objAutomationObjects, objDriver);
				objApplicationSteps.validateDeptKpi(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnDeptDropdownBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnAnotherDeptInDeptDropDown(objAutomationObjects, objDriver);
				objApplicationSteps.validateDeptKpi(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateCalculationBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.ClickOnCalculationBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateCalculationOpens(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.ClickOnCalculationPageCloseBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void selectKpiInDeptOverview(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnDeptDropdownBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnDefaultDeptInDeptDropDown(objAutomationObjects, objDriver);
				objApplicationSteps.validateDeptKpi(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
		
	}
	public void validateKPIGraph(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String DefaultDeptKPIName, String AlternateDefaultDeptKPIName,String SecondDeptKPIName, String SecondAlternateDeptKPIName ) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateKPIGraphLabel(objAutomationObjects, objDriver,DefaultDeptKPIName,AlternateDefaultDeptKPIName);
				objApplicationSteps.slectDifferentKPI(objAutomationObjects, objDriver);
				objApplicationSteps.validateSecondKPIGraphLabel(objAutomationObjects, objDriver,SecondDeptKPIName,SecondAlternateDeptKPIName);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateDownloadOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnSliderDownloadBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnGraphDownloadBtn(objAutomationObjects, objDriver);
				//objApplicationSteps.clickOnReportDownloadBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void validateReportPdfDownloadOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnReportPdfDownloadBtn(objAutomationObjects, objDriver);
				objApplicationSteps.switchToPdfReportPage(objAutomationObjects, objDriver);
				objApplicationSteps.switchToDealerDashboardPage(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void selectMarketAndPeriod(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.selectMarket(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnPeriodCalenderBtn(objAutomationObjects, objDriver);
				//objApplicationSteps.selectYear(objAutomationObjects, objDriver);
				//objApplicationSteps.selectMonth(objAutomationObjects, objDriver);		
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}	
	}
	public void validateNscDashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateNscDashboardPanelHeading(objAutomationObjects, objDriver);	
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateUserAtDealerDashboardpage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
			//	objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
			//	objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
				objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
				objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void ValidateUserAtSubmissionManagerPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnSubmissionManagerDropdown(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSubmissionManagerBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void validateUserAtDealerSubmissionspage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnDealerSubmissionBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void selectDealerSubmissionManager(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnDealerSubmissionBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void validateDealerInputDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnInputFormDownloadBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSubmissionHistoryBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void actionCreation(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnActionBtn(objAutomationObjects, objDriver);
				objApplicationSteps.enterActionTitle(objAutomationObjects, objDriver);
				objApplicationSteps.enterActionConcern(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnStartDate(objAutomationObjects, objDriver);
				objApplicationSteps.selectStartDate(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnTargetDate(objAutomationObjects, objDriver);
				objApplicationSteps.selectTargetDate(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnActionCreateBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	
	public void actionEdit(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnEditBtn(objAutomationObjects, objDriver);
				objApplicationSteps.selectActionStatus(objAutomationObjects, objDriver);
				objApplicationSteps.enterActionSaveBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnCloseDate(objAutomationObjects, objDriver);
				objApplicationSteps.selectActionDeleteBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnConfirmBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnCloseDate(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void averageSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnDeptOverviewSettingBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnAverageDropdownBtn(objAutomationObjects, objDriver);
				objApplicationSteps.selectAverage(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnGraphSettingBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnAverageDropdownBtn(objAutomationObjects, objDriver);
				objApplicationSteps.selectAverage(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void validateAvailableOnDashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.validateAverageNameAppearingOnDeptOverview(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}	
	}
	public void GraphTypeSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnGraphSettingBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnChartType(objAutomationObjects, objDriver);
				objApplicationSteps.selectBarChartType(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
	public void validateChartSelectionAvailable(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				objApplicationSteps.clickOnGraphSettingBtn(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnChartType(objAutomationObjects, objDriver);
				objApplicationSteps.selectLineChartType(objAutomationObjects, objDriver);
				objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}
		public void averageSelectionInNscDashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnKPITableSettingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAverageSelection(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void SingleAverageSelectionInKPITable(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnKPITableSettingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSingleAverageSelection(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void DealerSelectionInNscDashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnKPITableSettingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDealerSelection(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void SingleDealerSelectionInKPITable(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnKPITableSettingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSingleDealerSelection(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void KPIsSelectionInNscDashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnKPITableSettingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnKPISelection(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void SingleKPISelectionInKPITable(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnKPITableSettingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSingleKPISelection(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void navigateToDnsSubmitPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				    objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
					objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
				    objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				    objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSubmissionsDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSSubmitBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void validateDnsSubmitPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.validateCloseDatesBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		
		public void ValidatePeriodVailableInPeriodSelector(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPeriodSelectorBtn(objAutomationObjects, objDriver);
					objApplicationSteps.SelectPeriod(objAutomationObjects, objDriver);
				    objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		
		public void validateSelectedPeriod(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPeriodSelectorOKBtn(objAutomationObjects, objDriver);
					 objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateViewCloseDatesBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnViewCloseDatesBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateCloseViewDates(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnViewDatesCloseBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		
		public void ValidateInputOptionsBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnInputOptionsBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateInputOptionsFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnDealerSelectionBtn(objAutomationObjects, objDriver);  //disable for dealer user
					//objApplicationSteps.selectDealerForInputOptions(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnOkBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectInputOption(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSSubmitSaveBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSubmissionsBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateCarrryForwardBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCarryforwardBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateCarryForwardScenarios(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnDealerSelectionBtn(objAutomationObjects, objDriver);  // disable for dealer user
					//objApplicationSteps.selectDealerForInputOptions(objAutomationObjects, objDriver); // disable for dealer user
					//objApplicationSteps.clickOnOkBtn(objAutomationObjects, objDriver); // disable for dealer user
					objApplicationSteps.selectCarryforwardItem(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSSubmitSaveBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSubmissionsBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}

		public void ValidateEditInputFromBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnEditInputFormBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateInputFormOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNextDeptBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterUnitValue(objAutomationObjects, objDriver);
					objApplicationSteps.enterSalesValue(objAutomationObjects, objDriver);
					//objApplicationSteps.enterCostValue(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSSubmitSaveBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnDNSSubmitInputFormCloseBtn(objAutomationObjects, objDriver);
					////objApplicationSteps.clickOnReleaseBtn(objAutomationObjects, objDriver);
					////objApplicationSteps.clickOnpublishBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateUserAtDnsSubmitPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnSubmissionsDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSSubmitBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDealerProfileBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
					objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAdministrationDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDealerProfileBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDealerProfile(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateDealerProfilePanelHeading(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void validateUserAtDealerProfilepage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAdministrationDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDealerProfileBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateProfileEditFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDealerDetailsUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUpdateCloseBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnProfileSectionExtendBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnCheckBoxBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateSaveProfileEditFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUpdateCloseBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.MoveBackToDealerPage(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void validateUserMoveToAccountMapsPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnSubmissionsDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAccountMapsBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateAccountMapsOpenSUccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateAccountMapsLabel(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void validateUserAtAccountMapsPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnSubmissionsDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAccountMapsBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateNewChartsOfAccountCreationOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnNewChartAccountsBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterChartName(objAutomationObjects, objDriver);
					objApplicationSteps.selectCOAFile(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateNewChartsOfAccountCreatedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnChartOfAccountOkBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUpdateCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}

		public void ValidateNewMapsCreationOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnNewMapBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterMapName(objAutomationObjects, objDriver);
					objApplicationSteps.selectCOAName(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateNewMapsCreatedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnNewMapCreateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUpdateCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateAccountMapEditBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnAccountMapName(objAutomationObjects, objDriver);
					//objApplicationSteps.ClickOnIgniteAccountMapName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAccountMapEditBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateAccountMapEditCloseBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnAccountMapEditCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateAccountMapDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnAccountMapName(objAutomationObjects, objDriver);
					//objApplicationSteps.ClickOnIgniteAccountMapName(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnAccountMapDownloadBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateAccountMapShouldDownloadSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnAccountInputOrderBtn(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnAccountMapDownloadOKBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateAccountMapDeleteBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnAccountMapName(objAutomationObjects, objDriver);
					//objApplicationSteps.ClickOnIgniteAccountMapName(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnAccountMapDeleteBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateAccountMapShouldDeletedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnAccountDeleteOkBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidatePublishedReportBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnReportsDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnPublishedReportBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidatePublishedReportPageOpenSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ValidatePublishedReportLabel(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateUserAtPublishedReportPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnReportsDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnPublishedReportBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidatePublishedReportsTypeDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnReportDropdownBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateReportsSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.selectReport(objAutomationObjects, objDriver);
					objApplicationSteps.validateSelectedReport(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidatePeriodSelectionDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnPeriodDropdownBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidatePeriodSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.SelectPeriodSelection(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidatePdfDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnPdfBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateExcelDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnExlBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidatePdfAndExcelReportSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.selectPdfReportForZip(objAutomationObjects, objDriver);
					objApplicationSteps.selectExlReportForZip(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateZipDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnZipBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateFlexibleReportBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnReportsDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnFlexibleReportBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateFlexibleReportPageOpenSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ValidateFlexibleReportLabel(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateUserAtFlexibleReportPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnReportsDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnFlexibleReportBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateFlexibleReportsTypeDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnFlexibleReporDropdownBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateFlexibleReportsSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.selectSuperflexReport(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDealerSelectionEditBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.DealerEditBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateSuperflexDealerSelectionOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDealerField(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
					objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
					//objApplicationSteps.SelectDealerForSuperflex(objAutomationObjects, objDriver);
					//objApplicationSteps.selectDealer(objAutomationObjects, objDriver);
					objApplicationSteps.SelectMeasureForSuperflex(objAutomationObjects, objDriver);
					objApplicationSteps.SelectPeriodForSuperflex(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFlexibleSaveBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDealerSelectionCancelBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.DealerCancelBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateBlankDealerColumn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateDealerColumnText(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateSuperflexDropdownBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnSuperflexDropdownBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateSuperflexDeptSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.selectSuperflexDept(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNextPageBtn(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnPreviousPageBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateSuperflexDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnSuperflexReportDownloadBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateSuperflexReportDownloaded(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.MoveBackToDealerPage(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateSecondDealerSelectionEditBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnSecondDealerEditBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateSecondSuperflexDealerSelectionOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDealerField(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
					objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
					//objApplicationSteps.SelectDealerForSuperflex(objAutomationObjects, objDriver);
					//objApplicationSteps.selectDealer(objAutomationObjects, objDriver);
					objApplicationSteps.SelectMeasureForSuperflex(objAutomationObjects, objDriver);
					objApplicationSteps.SelectPeriodForSuperflex(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFlexibleSaveBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDnsAnalysisBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAnalysisDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDnsAnalysisBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDnsAnalysisPagLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.DnsAnalysisPageLabel(objAutomationObjects, objDriver);
					//objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateUserAtDnsAnalysisPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAnalysisDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDnsAnalysisBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateAnalysisMarketDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisMarketDropdownBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateMarketSelectSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.selectAnalysisMarket(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateAnalysisToolsDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisToolsDropdownBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateToolsSelectSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAnalysisToolsName(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateAnalysisGridBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnGridBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateGridSelectSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnGridName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCreateGridBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateItemRowBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnItemRowBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateItemAdditionIntoGrid(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAddByNameBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterItemName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnItemAddBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnAddRnumBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.enterRnum(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnItemAddBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateItemSelectionInReportPicker(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnItemRowBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAddByReportPickerBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateItemSelectionFromPickerIntoGrid(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnPickerDeptDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPickerDeptName(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnPickerItem(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPickerItemAddBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnSubsetsBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnSubsetsItem(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnPickerItemAddBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidatePeriodSelectionForAnalysis(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisPeriodDropdown(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidatePeriodSelectionType(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAddByHierarchyBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnYearDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnMonthBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPeriodAddBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateNetworkSelectionForAnalysis(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisNetworkDropdown(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateNetworkSelectionType(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAddByNameBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterDealerName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnItemAddBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateMeasureSelectionForAnalysis(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnMeasureDropdown(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateMeasureSelectionType(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnMeasureType(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateGridExcelDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSelectionsExcelBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		
		public void ValidateBulkDataExcelDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnBulkDataExcelBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateExcelFileDwnloadedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateCustomCompositeTool(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisToolsDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCustomCompositeToolBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateCustomCompositeOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.enterCompositeName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCompositeStartDateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectCompositeStartDate(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCompositeEndDateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectCompositeEndDate(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCustomCompositeDealerBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAddByNameBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterDealerName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnItemAddBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCreateCustomCompositeBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnConfirmOkBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCalculateCustomCompositeBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnConfirmOkBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCompositeShareBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateCustomCompositeDeleteBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCustomCompositeDeleteBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnConfirmOkBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateCustomCompositeDeletedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDataBulkDumpTool(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDataBulkToolsName(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDataBulkMeasure(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDataBulkMeasureBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDealerSelectionInDataBulk(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnPageFormatBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.selectColumnFormatBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.selectRowFormatBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.selectColumnBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDealerSelectionOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {	
					objApplicationSteps.clickOnDataBulkDealerBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAddByNameBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterDealerName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnItemAddBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDataBulkItemBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnPageFormatBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.selectColumnBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.selectRowFormatBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateItemSelectionOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDataBulkItemBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAddByNameBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterItemName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnItemAddBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDataBulkPeriodBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnPageFormatBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.selectColumnFormatBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidatePeriodSelectionOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDataBulkPeriodBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAddByHierarchyBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnYearDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnMonthBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPeriodAddBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAnalysisUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateBMServiceSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnBmServiceOption(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void validateUserLoginIntoLandingPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateDashboardLandingPage(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
			
		}
		public void ValidateSubmissionManagerBtnBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnSubmissionManagerDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSubmissionManagerBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateSubmisionManagerPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.validateSubmissionManagerPage(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateNSCSubmissionMangerMarketSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNscSubmissionMarketDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectNSCSubmissionMarket(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateMarketSelectedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnSubmissionManagerUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateNSCSubmissionMangerPeriodSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNscSubmissionPeriodDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectNSCSubmissionPeriod(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidatePeriodSelectedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnSubmissionManagerUpdateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateNSCSubmissionDealerSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSubmissionDownloadBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNscSubmissionDealerDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectNSCSubmissionDealer(objAutomationObjects, objDriver);
					//objApplicationSteps.selectNSCSubmissionDealerForDownload(objAutomationObjects, objDriver);
					objApplicationSteps.selectDealerSubmissionPeriod(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateInputFormDownloadedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDealerSubmissionDownloadBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDNSForecastBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnPlanningAndForecastingDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastToolBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDNSForecastPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateDNSForecastPage(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateUserAtDNSForecastPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnPlanningAndForecastingDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastToolBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDNSForecastCreate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnForecastBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnHistoryDataDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.selectHistoryData(objAutomationObjects, objDriver);
					objApplicationSteps.selectCurrencyType(objAutomationObjects, objDriver);
					objApplicationSteps.selectForecastPrivate(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSeasonality(objAutomationObjects, objDriver);
					objApplicationSteps.selectSeasonality(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnCreateForecastBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDNSForecastCreatedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnCreateForecastBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDNSForecastExcelDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnForecastOpenBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastExcelBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDNSForecastDownloadedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
				//	objApplicationSteps.clickOnForecastExitBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDNSForecastCreateNextYearBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnForecastOpenBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastNextYearBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNextYearForecastNameBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCreateForecastBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDNSForecastNextYearCreatedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnForecastCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDNSPlanBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnPlanningAndForecastingDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSPlanBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateDNSPlanPageOpenSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.validateDNSPlanPage(objAutomationObjects, objDriver);
					//objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	}
		public void ValidateUserAtDNSPlanPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnPlanningAndForecastingDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSPlanBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDNSPlanYearSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSPlanYearSelectionDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectPlanYear(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanYearSelectionOKBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDNSPlanYearSelectSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDNSPlanCreation(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCreateNewPlanBtn(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnDisclaimerBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDNSPlanYCreatedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAversgeSeedingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.SelectAverageSeedingPeriod(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDealerSeedingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.SelectDealerSeedingPeriod(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanStartingMonthBtn(objAutomationObjects, objDriver);
					objApplicationSteps.SelectPlanStartingMonth(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanStartingYearBtn(objAutomationObjects, objDriver);
					objApplicationSteps.SelectPlanStartingYear(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanMenuBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanSaveBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterPlanName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanNameSaveBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanSaveOkBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateScreenSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSPlanBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnScreenForwardBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectAverageForPlan(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnScreenBackwardBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnScreenSelectBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFirstScreenNameBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateScreenSelectedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDownloadOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSPlanBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanExcelBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanPdfBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidatePlanDownloadSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnPlanCloseBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidatePlanSubmitOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSPlanBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanLockBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanSubmitBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidatePlanSubmitSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.switchDriverToDefaultFrame(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateNewsflashManagerBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
					objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAdministrationDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNewFlashManagerBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateNewflashPageOpenSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateNewsFlashPage(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void validateUserAtNewsflashManagerpage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAdministrationDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNewFlashManagerBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateNewNewsflashCreation(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnNewsFlashCreateStartBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNewsFlashMarketDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNewsFlashMarket(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNewsFlashStartDateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectNewsFlashDate(objAutomationObjects, objDriver);
					//objApplicationSteps.selectNewsFlashStartDate(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNewsFlashEndDateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectNewsFlashDate(objAutomationObjects, objDriver);
					//objApplicationSteps.selectNewsFlashEndDate(objAutomationObjects, objDriver);
					objApplicationSteps.enterNewsFlashHeading(objAutomationObjects, objDriver);
					objApplicationSteps.enterNewsFlashContent(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateNewflashCreatedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnNewsFlashCreateBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNewsFlashCreateCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateNewflashEditOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnNewsFlashEditBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clicktoUpdateNewsFlashContentField(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateNewflashEditedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnNewsFlashSaveBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNewsFlashCreateCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateNewflashDeleteOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnNewsFlashDeleteBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateNewflashDeletedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnNewsFlashDeleteConfirmBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNewsFlashCreateCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidatePageExpandBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateLogoOnReport(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPageExpandBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateReportPageColorAndLogo(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateLogoOnReport(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPageExpandBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateSaveUserSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnUserSaveSettingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserSettingNameField(objAutomationObjects, objDriver);
					objApplicationSteps.enterUserSettingName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSettingSaveBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSavedSettingCloseBtn(objAutomationObjects, objDriver);

				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateUserSavedSettingOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnUserSaveSettingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickONSavedSelectionName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnLoadSettingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserSaveSettingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickONSavedSelectionName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDeleteSettingBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSavedSettingCloseBtn(objAutomationObjects, objDriver);

				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateUserAtSystemSelectionPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.clickOnSystemDropdownBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnEnterSystemBtn(objAutomationObjects, objDriver);
					objApplicationSteps.validateOpsSystemSelectionPage(objAutomationObjects, objDriver);
					

				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateSystemAndMarketSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnOpsSetMarketBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		
		public void userPerformSuppressionOperation(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnCloseProcedure(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnEditSuppression(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnOpsPeriodDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnOpsPeriod(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnOpsPeriodNextBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateSuppressionOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.readSuppressionFile(objAutomationObjects, objDriver);

				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void selectSystemAndMarket(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnSystemDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectOpsSytem(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnEnterSystemBtn(objAutomationObjects, objDriver);
					objApplicationSteps.switchDriverToOpsFrame(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnGlobalBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSetMarketBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnOpsMarketDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnOpsMarket(objAutomationObjects, objDriver);

				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateMatrixAnalysisBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnMatrixAnalysisBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void validateUserAtMatrixAnalysispage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnMatrixAnalysisBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateMatrixAnalysisOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnMatrixAnalysisBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnMarketDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnMarketName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPeriodDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPeriodName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnXAxixKpiDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.EnterKpiInSearchField(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnKpiName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnKpiSaveBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnYAxisKpiDropdownBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnKpiDeptName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnKpiName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnKpiSaveBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateMatrixAnalysisPageOpenSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
					objApplicationSteps.validateMatrixAnalysisPage(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateMatrixAnalysisOperationsPerformSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnSelectionFilterBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnExcelDownloadBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateSATBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnOverallSummaryBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateSATOpensSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateOverallSummaryLabel(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void validateUserAtOverallSummaryPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnActionMenuBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnOverallSummaryBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateDealer_PeriodAndAverageForSAT(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.enterDealer(objAutomationObjects, objDriver);
					objApplicationSteps.selectDealer(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPeriodCalenderBtn(objAutomationObjects, objDriver);
					objApplicationSteps.selectYear(objAutomationObjects, objDriver);
					objApplicationSteps.selectMonth(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSATaverageDropdownBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDealer_PeriodAndAverageForSATselectedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.selectAverageForSAT(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateChartDownloadForSAT(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDeptChartBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateSATchartDownloadedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnKpiChartBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDeptView(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDeptViewBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateDeptViewOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.enterNvTargetVolume(objAutomationObjects, objDriver);
					objApplicationSteps.clickOkOnNvTargetVolume(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateDeptDeatiledView(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDetailedViewBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			} 
		}
		public void ValidateDeptDetailedViewOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDetailedViewExcelBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void validateStoredItemsValue(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.storedItemsValue(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateStoredItemsValue(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateStoredValue(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void readExcelSheet(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDetailedViewBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.readexcelsheetData(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void ValidateStoredItemsValueWithExelValues(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.storedItemsValue(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
	
		public void AccountMapAssignFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnAccountMapName(objAutomationObjects, objDriver);
					//objApplicationSteps.ClickOnIgniteAccountMapName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAssignBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAssignPlusBtn(objAutomationObjects, objDriver);

				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateAccountMapAssignFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAssignCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void ValidateDnsProfilePageopenSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateDnsprofileLabel(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void validateSetDefaultSetting(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnSetDefaultBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void validateDefaultSelectionAfterReopens(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.SuccessCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void validateFixedReportFilterHideBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnFixedReportFilterHideBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void validateFixedReportFilterShowBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnFixedReportFilterShowBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		
		public void validatePDFSelectAllOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnPDFSelectAllBtn(objAutomationObjects, objDriver);
					objApplicationSteps.validateReportGetSelected(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnPDFDeSelectAllBtn(objAutomationObjects, objDriver);
					objApplicationSteps.validateReportGetUnSelected(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
		public void validatePdfUnSelectAllOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.ClickOnXlSelectAllBtn(objAutomationObjects, objDriver);
					objApplicationSteps.validateReportGetSelected(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnXlDeSelectAllBtn(objAutomationObjects, objDriver);
					objApplicationSteps.validateReportGetUnSelected(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}	
			
			public void validateFlexibleReportSaveOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnReportSaveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
		}
		
			public void validateFlexibleReportZoomOptions(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnReportZoomInBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void ValidateFlexibleReportSavedSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.EnterFlexibleReportName(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnFlexibleSaveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void ValidateReportPageSizeChangesAccordingly(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnReportZoomOutBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void dealerSelectionInNetworkHierarchy(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
						objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
						objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void netOperatingChartLegends(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnNetOperatingNVLegendToHide(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnNetOperatingUVLegendToHide(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void netSalesChartLegends(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnNetSalesNVLegendToHide(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnNetSalesUVLegendToHide(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void netProfitDownloadButton(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnNetProfitChartDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void netSalesDownloadButton(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnNetSalesChartDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void ValidateNetOperatingChartVisibility(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.netOperatingChartLabel(objAutomationObjects, objDriver);
						objApplicationSteps.netSalesChartLabel(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			
			public void ValidateNetOperatingLegendsSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnHiddenNVLegendToAppear(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnHiddenUVLegendToAppear(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void ValidateNetSalesLegendsSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnHiddenNVLegendToAppear(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnHiddenUVLegendToAppear(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void ValidateNetOperatingChartDownloadOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void ValidateNetSalesChartDownloadOption(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void dashboardDepartmentSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnDepartmentDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnDepartmentListDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.selectDepartment(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnDepartmentDropdown(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void dashboardDepartmentSelectionForDealer(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnDepartmentDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnDepartmentListDropdownForDealer(objAutomationObjects, objDriver);
						objApplicationSteps.selectdeptForDealer(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnDepartmentDropdown(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void dashboardAverageSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnAverageDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnAverageListDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.selectAverage(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnAverageDropdown(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void dashboardPeriodSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnPeriodDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnPeriodListDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnPeriodYearDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.selectPeriod(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnPeriodDropdown(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void kpiAnalysisAverages(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalaysisAverageDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisAverage(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void kpiAnalysisAverageSwitch(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisAverageSwitchBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void validateKpiAnalysisChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKpiAnalysisChartLabel(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void validateKpiAnalysisAverages(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKpiAnalysisAverageLabel(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void validateKpiAnalysisSwitch(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisAverageSwitchBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void kpiAnalysisSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisSettingBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void kpiAnalysisSelectAllKpiBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisSelectAllKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void kpiAnalysisDeSelectAllKpiBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisDeSelectAllKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void kpiAnalysisSelectDefaultKpiBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisSelectDefaultKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void kpiAnalysisDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void kpiAnalysisMaximizeBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisMaximizeBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void validateKpiAnalysisDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKPIAnalysisDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void validateKpiAnalysisMaxScreen(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKPIAnalysisMaxScreen(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void kpiAnalysisMaximizeAverages(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisMaximizeBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalaysisMaxAverageDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisMaxAverage(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void maxScreenKpiSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						//objApplicationSteps.clickOnKpiAnalysisMaximizeBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnMaxKpiSettingBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void kpiAnalysisMaximizeAverageSwitchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisMaximizeBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisMaxAverageSwitchBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void validateKpiAnalysisMaximizeAverages(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKpiAnalysisMaxAverageLabel(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
						
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void validateKpiAnalysisMaximizeAverageSwitchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisMaxAverageSwitchBtn(objAutomationObjects, objDriver);
						//objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}		
			
			public void kpiAnalysisMaximizeScreenDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						//objApplicationSteps.clickOnKpiAnalysisMaximizeBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisMaxDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void validateKpiAnalysisMaximizeScreenDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKPIAnalysisMaxDownloadBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			
			public void kpiAnalysisMaximizeScreenItem(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisMaximizeBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnkpiAnalysisMaxItem(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			
			public void validatekpiAnalysisItemDrillDownFromMaximizeScreen(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKPIAnalysisItemDrillDown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemDrillDownPageCloseBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void kpiAnalysisDashboardItemDrill(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnkpiAnalysisItem(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			
			public void KpiAnalysisItemDrill(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnkpiAnalysisItem(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			
			public void validatekpiAnalysisItemDrillDownFromDashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKPIAnalysisItemDrillDown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void kpiAnalysisKpiDataDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisKpiDataDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void validatekpiAnalysisKpiDataDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKPIAnalysisKpiDataDownloadBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void kpiAnalysisKpiCalculationDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisCalcBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisCalcDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			
			public void kpiAnalysisKpiCalculationDownloadBtnForDealerSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisCalcDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void validatekpiAnalysisKpiCalculationDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKPIAnalysisCalcDownloadBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void kpiTrendFirstAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiTrendFirstAverageDropdownBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiTrendFirstAverageBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void kpiTrendSecondAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiTrendSecondAverageDropdownBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiTrendSecondAverageBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void kpiTrendFirstAverageSwitchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiTrendFirstAverageSwitchBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void kpiTrendSecondAverageSwitchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiTrendSecondAverageSwitchBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void kpiTrendDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiTrendDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void marketTrendAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnMarketTrendBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiTrendFirstAverageDropdownBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiTrendFirstAverageBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void marketTrendAverageSwitchBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnMarketTrendBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiTrendFirstAverageSwitchBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void marketTrendAverageDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnMarketTrendBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiTrendDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
		
			public void validatekpiTrendFirstAverageSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKpiTrendFirstAverage(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void validatekpiTrendSecondAverageSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKpiTrendSecondAverage(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void validatekpiTrendFirstAverageSwitch(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiTrendFirstAverageSwitchBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}	
			public void validatekpiTrendSecondAverageSwitch(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiTrendSecondAverageSwitchBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void validatekpiTrendDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKpiTrendDownload(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void performanceVariationDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnPerformanceVariationDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void dashboardDealerSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
						objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
						objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void validatePerformanceVariationChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validatePerformanceVariationChart(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void validatePerformanceVariationDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validatePerformanceVariationDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void userSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnUserSettingBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void userImitateField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnUserSettingBtn(objAutomationObjects, objDriver);
						objApplicationSteps.enterUserInImitateField(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnUserImitateOkBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void browserComponentForImitateUser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnSubmissionsDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnDNSSubmitBtn(objAutomationObjects, objDriver);
						//objApplicationSteps.validateCloseDatesBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void removeUserFromImitate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnUserSettingBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnImitateUserRemoveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void validateImitateUserField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateImitateUserField(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void validateUserImitatesSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateuserImitateSuccessfully(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void validateUserOperationThroughImitate(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnDashboardDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnSelectedNetwork(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void validateUserNavigateToBaseUser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						//objApplicationSteps.validatePerformanceVariationDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void PLDispersionMaximizeScreen(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnPLDispersionMaxBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void plDispersionSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnPLDispersionSettingBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void plDispersionDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnPLDispersionDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void plDispersionMaximizeBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnPLDispersionMaxBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void plDispersionMaximizeSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnPLDispersionMaxSettingBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void plDispersionMaxDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnPLDispersionMaxDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void validatePLDispersionChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validatePLDispersionChartLabel(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void PLDispersionSelectAllAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisSelectAllKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void PLDispersionDeSelectAllAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisDeSelectAllKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void PLDispersionSelectDefaultAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisSelectDefaultKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void PLDispersionMaxSelectAllAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisSelectAllKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void PLDispersionMaxDeSelectAllAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisDeSelectAllKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void PLDispersionMaxSelectDefaultAverage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisSelectDefaultKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void validatePLDispersionDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validatePLDispersionDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void validatePLDispersionMaximizeScreen(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validatePLDispersionMaximizeScreen(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void validatePLDispersionMaxDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validatePLDispersionMaxDownlodBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKPIAnalysisItemPageCloseBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void kpiPerformanceSettingBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKPIPerformanceSettingBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void kpiPerformanceDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKPIPerformanceDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void kpiPerformanceDealerDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKPIPerformanceDealerDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void validateKPIPerformanceChart(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKPIPerformanceLabel(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			public void kpiPerformanceSelectAllKpi(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisSelectAllKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void kpiPerformanceDeSelectAllKpi(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisDeSelectAllKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void kpiPerformanceSelectDefaultKpi(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnKpiAnalysisSelectDefaultKpiBtn(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnKpiAnalysisSettingSaveBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			public void validateKpiPerformanceDownloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.validateKPIPerformanceDownloadBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				
				}
			}
			
			
			public void clickonDNSlibrary(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
							if (objGenericFunction.getNormalMethodExecutionFlag()) {
								objApplicationSteps.clickOnDNSLibrarydropdown(objAutomationObjects, objDriver);
								objApplicationSteps.SelectLibrary(objAutomationObjects, objDriver);
								
							} else {
								Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
							}
						} catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception(e);
						}
			}
			 
				
				 public void validateDNSlibrary(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", true);
							if (objGenericFunction.getNormalMethodExecutionFlag()) {
								objApplicationSteps.validateLibraryPage(objAutomationObjects, objDriver);
								
							} else {
								Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
							}
						} catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception(e);
						}
				 }
			 
				 public void dnsLibraryPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", true);
							if (objGenericFunction.getNormalMethodExecutionFlag()) {
								objApplicationSteps.clickOnDNSLibrarydropdown(objAutomationObjects, objDriver);
								objApplicationSteps.SelectLibrary(objAutomationObjects, objDriver);
								
							} else {
								Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
							}
						} catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception(e);
						}
				 }
				 
				 public void alertPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", true);
							if (objGenericFunction.getNormalMethodExecutionFlag()) {
								objApplicationSteps.clickOnAlertButton(objAutomationObjects, objDriver);	
							} else {
								Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
							}
						} catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception(e);
						}
				 }
				
				 public void clickonuploaddocument(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", true);
									if (objGenericFunction.getNormalMethodExecutionFlag()) {
										objApplicationSteps.clickOnLibUploadBtn(objAutomationObjects, objDriver);
										objApplicationSteps.clickOnFolderAddBtn(objAutomationObjects, objDriver);
										objApplicationSteps.addFolderName(objAutomationObjects, objDriver);
										objApplicationSteps.clickOnAddFolderName(objAutomationObjects, objDriver);
										//objApplicationSteps.selectFolderName(objAutomationObjects, objDriver);
										objApplicationSteps.EnterDescription(objAutomationObjects, objDriver);
										objApplicationSteps.Choosefile(objAutomationObjects, objDriver);
										objApplicationSteps.Securitydrpdown(objAutomationObjects, objDriver);
										objApplicationSteps.SelectSecurity(objAutomationObjects, objDriver);
										objApplicationSteps.Networkentitydrpdown(objAutomationObjects, objDriver);
										objApplicationSteps.clickOnLibraryNetwokSearchBtn(objAutomationObjects, objDriver);
										objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
										objApplicationSteps.selectNetworkName(objAutomationObjects, objDriver);
										objApplicationSteps.Savenetworkentity(objAutomationObjects, objDriver);
										
									} else {
										Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
									}
								} catch (Exception e) {
									objAutomationObjects.objLogger.logErrorWithException(e);
									throw new Exception(e);
								}
					}
				
				
				
				 public void validatedocument(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", true);
							if (objGenericFunction.getNormalMethodExecutionFlag()) {
								objApplicationSteps.Savedoc(objAutomationObjects, objDriver);
								
							} else {
								Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
							}
						} catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception(e);
						}
				 }
				
				
				
				
				 public void clickonview(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", true);
									if (objGenericFunction.getNormalMethodExecutionFlag()) {
										objApplicationSteps.clickonfolderdrpdown(objAutomationObjects, objDriver);
										objApplicationSteps.Selectfile(objAutomationObjects, objDriver);
										
									} else {
										Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
									}
								} catch (Exception e) {
									objAutomationObjects.objLogger.logErrorWithException(e);
									throw new Exception(e);
								}
			}
			 
			 
			 
			 
			public void validateview(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
					try {
						objAutomationObjects.objLogger.logInfo("", true);
						if (objGenericFunction.getNormalMethodExecutionFlag()) {
							objApplicationSteps.Selectview(objAutomationObjects, objDriver);
							
						} else {
							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
						}
					} catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
						throw new Exception(e);
					}
			}
			 
			 
			 
			public void clickondelete(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
							if (objGenericFunction.getNormalMethodExecutionFlag()) {
								//objApplicationSteps.clickonfolderdrpdown(objAutomationObjects, objDriver);
								objApplicationSteps.Selectfile(objAutomationObjects, objDriver);
								objApplicationSteps.Selectdelete(objAutomationObjects, objDriver);
								
							} else {
								Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
							}
						} catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception(e);
						}
			}
			 
			 
			public void validatedelete(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.SelectOK(objAutomationObjects, objDriver);
						
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
			public void alertPageButton(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnAlertButton(objAutomationObjects, objDriver);
						
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
        public void alertNameBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnAlertNameBtn(objAutomationObjects, objDriver);
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
          }
        public void alertMarkreadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAlertReadMarkBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void alertMarkFlagBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAlertReadFlagBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void alertMarkCriticalBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAlertCriticalMarkBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void alertMarkDeleteBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAlertDeleteMarkBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void alertMarkUnreadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAlertUnReadBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void alertSearchField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAlertSearchField(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void alertStartUpPagePopUpBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAlertStartUpPopUpBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void validateAlertPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
    			try {
    				objAutomationObjects.objLogger.logInfo("", true);
    				if (objGenericFunction.getNormalMethodExecutionFlag()) {
    					objApplicationSteps.validateAlertPageLabel(objAutomationObjects, objDriver);
    					objApplicationSteps.clickOnAlertPageCloseBtn(objAutomationObjects, objDriver);
    				} else {
    					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
    				}
    			} catch (Exception e) {
    				objAutomationObjects.objLogger.logErrorWithException(e);
    				throw new Exception(e);
    			}
          }
        public void validateAlertMessage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateNewsFlashMessage(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertPageCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void validateAlertMoveToRead(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnReadAlertBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertNameBtn(objAutomationObjects, objDriver);
					objApplicationSteps.validateNewsFlashMessage(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertReadMarkBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertPageCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void validateAlertMoveToFlagged(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFlaggedAlertBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertNameBtn(objAutomationObjects, objDriver);
					objApplicationSteps.validateNewsFlashMessage(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertReadFlagBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertPageCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void validateAlertMoveToCritical(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnCriticalAlertBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertNameBtn(objAutomationObjects, objDriver);
					objApplicationSteps.validateNewsFlashMessage(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertCriticalMarkBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertPageCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void validateAlertMoveToDeleted(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnDeletedAlertBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertNameBtn(objAutomationObjects, objDriver);
					objApplicationSteps.validateNewsFlashMessage(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertDeleteMarkBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertPageCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void validateUnReadAlert(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnUnReadBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertPageCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void validateSearhedAlert(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAlertNameBtn(objAutomationObjects, objDriver);
					objApplicationSteps.validateNewsFlashMessage(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertPageCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void validateAlertAtStartUpPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAlertStartUpPopUpBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAlertPageCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void opportunityAverageSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnOpportunityAverageDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.selectOpportunityAverage(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void validateTotalOpportunityLabel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateTotalOpportunityLabel(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void launchBrowser(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver, String strApplication_URL) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					String xx=objAutomationObjects.objTestData.getTestData("Password");
					objApplicationSteps.launchNewBrowser(objAutomationObjects, objDriver, objAutomationObjects.objTestData.getTestData(strApplication_URL));
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        public void userLogin(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver,String strUserName,String strPassword) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.enterSystemUsername(objAutomationObjects, objDriver,Wave3AutomationObjects.objTestData.getTestData(strUserName));
					objApplicationSteps.enterSystemPassword(objAutomationObjects, objDriver, Wave3AutomationObjects.objTestData.getTestData(strPassword));
					objApplicationSteps.clickOnSystemSignInBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        public void logoutFromApplication(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnUser(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnLogoutBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
			
        public void globalSelectionForPlan(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkTree(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanningAndForecastingDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSPlanBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        public void globalSelectionForForecast(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkTree(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanningAndForecastingDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastToolBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        public void marketSelectionForPlan(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
					objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanningAndForecastingDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSPlanBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        public void marketSelectionForForecast(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
					objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanningAndForecastingDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastToolBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void dealerSelectionForPlan(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterExpandBtnForOpportunity(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdownForKpiPerformance(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
					objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanningAndForecastingDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDNSPlanBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }		
        public void dealerSelectionForForecast(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterExpandBtnForOpportunity(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdownForKpiPerformance(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
					objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPlanningAndForecastingDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastToolBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void forecastDealerAndModelSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterExpandBtnForOpportunity(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdownForKpiPerformance(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
					objApplicationSteps.enterDealerNameForForecast(objAutomationObjects, objDriver);
					objApplicationSteps.selectForecastDealerName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastNetworkDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        public void validateForecastDealerAndModelSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterExpandBtnForOpportunity(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastModelDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnModelListDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.selectModelName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastModelDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnFilterExpandBtnForOpportunity(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
			
        public void userManagementButton(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAdministrationDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserManagementBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }
        
        
        public void userManagementSearchButton(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAdministrationDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserManagementBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserManagementSearchBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterUserInSearchBar(objAutomationObjects, objDriver);
					objApplicationSteps.selectSearchedUser(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void userManagementCreateButton(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAdministrationDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserManagementBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserManagementCreateBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void userManagementCloneButton(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnAdministrationDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserManagementBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterUserInSearchBar(objAutomationObjects, objDriver);
					objApplicationSteps.selectSearchedUser(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserManagementCloneBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void validateUserManagementPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.validateUserManagementPageLabel(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void validateUserManagementSearchOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.UpdateUserName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserSaveChanges(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnSaveCloseBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserRemoveBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void validateUserManagementCreateOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.enterUserNameForCreateUser(objAutomationObjects, objDriver);
					objApplicationSteps.enterUserIdForCreateUser(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAccessChannelDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.selectAccessChannel(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnCountryDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.selectCountry(objAutomationObjects, objDriver);
					objApplicationSteps.enterEmailForCreateUser(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnLanguageDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.selectLanguage(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkAccessBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnLibraryNetwokSearchBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnHomeNetworkEntityDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.selectNetworkEntity(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSaveBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserAppRolesBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnBasicUserRole(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSubmitterRole(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDataRolesBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDataAllRole(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnReportRolesBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnAllDealerReportRole(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserSaveChanges(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnSaveCloseBtn(objAutomationObjects, objDriver);
					
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void validateUserManagementCloneOperations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.enterUserNameForCloneUser(objAutomationObjects, objDriver);
					objApplicationSteps.enterUserIdForCloneUser(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnUserSaveChanges(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnSaveCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        public void forecastSaveAndSaveAsFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnForecastOpenBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastSaveBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSaveOKBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastSaveASBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterForecastNewName(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastNewNameSaveBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        public void forecastResetFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnForecastOpenBtn(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnForecastResetBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void validateForecastSaveAndSaveAsFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnForecastCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        
        public void validateForecastResetFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnForecastCloseBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        public void ForecastPrivateFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnForecastPrivateCheckboxBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        public void ForecastPublishedFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnForecastPublishedCheckboxBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
        public void forecastDeleteFunctionality(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnForecastDeleteBtn(objAutomationObjects, objDriver);
					//objApplicationSteps.clickOnForecastDeleteYesBtn(objAutomationObjects, objDriver);
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
      }	
			
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		//**//                    Anushka's Code Start                       //**//
		
		
        public void NavigateToDashboard(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.Dashboard(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
	}

}
		public void networkSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	 
		}
		
		public void validateNetworkSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.validateNetworkName(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	 
		}
	
		public void BrandSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnBrandDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnBrandListDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.selectBrand(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}

			public void validateBrandSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						//objApplicationSteps.validateBrandName(objAutomationObjects, objDriver);
						
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
		
			}
			
			
			public void AverageSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						//objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnAverageDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnAverageListDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.selectAverageIgnite(objAutomationObjects, objDriver);
						
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
				
			public void validateAverageSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						//objApplicationSteps.validateBrandName(objAutomationObjects, objDriver);
						
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
		
			}
		
			public void LabelNetworkDispersion(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
						objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
						objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
						objApplicationSteps.LabelNetworkDispersionOnGraph(objAutomationObjects, objDriver);
						
						
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
		
			}
				public void DownloadNetworkDispersionGraph(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
					try {
						objAutomationObjects.objLogger.logInfo("", true);
						if (objGenericFunction.getNormalMethodExecutionFlag()) {
							objApplicationSteps.clickOnDownloadGraph(objAutomationObjects, objDriver);
						
						
						} else {
							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
						}
					} catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
						throw new Exception(e);
					}
}
				
				
				
				public void validateGraphDownloaded(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
					try {
						objAutomationObjects.objLogger.logInfo("", true);
						if (objGenericFunction.getNormalMethodExecutionFlag()) {
							//objApplicationSteps.validateGraphDownloaded(objAutomationObjects, objDriver);
							
						} else {
							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
						}
					} catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
						throw new Exception(e);
					}
				}

public void DepartmentDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
try {
	objAutomationObjects.objLogger.logInfo("", true);
	if (objGenericFunction.getNormalMethodExecutionFlag()) {
		//objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
		objApplicationSteps.clickOnDepartmentDropdown(objAutomationObjects, objDriver);
	    objApplicationSteps.clickOnDepartmentListDropdown(objAutomationObjects, objDriver);
		objApplicationSteps.selectdept(objAutomationObjects, objDriver);
			
	} else {
		Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
	}
} catch (Exception e) {
	objAutomationObjects.objLogger.logErrorWithException(e);
	throw new Exception(e);
}
}


	public void ValidateDepartmentName(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
		try {
			objAutomationObjects.objLogger.logInfo("", true);
			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				//objApplicationSteps.validateDepartmentName(objAutomationObjects, objDriver);
				
			} else {
				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
			}
		} catch (Exception e) {
			objAutomationObjects.objLogger.logErrorWithException(e);
			throw new Exception(e);
		}
	}

	
	 public void PeriodDropdown(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnPeriodDropdownAC(objAutomationObjects, objDriver);
				    objApplicationSteps.clickOnPeriodType(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnMonth(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnYearDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.ClickOnSelectedPeriod(objAutomationObjects, objDriver);
						
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		 }

	 
	 
	 public void ValidatePeriod(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.validateDepartmentName(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
	 
	 
	 public void KPISelectionInSettings(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnKPIPerfSettings(objAutomationObjects, objDriver);
					objApplicationSteps.SelectKPICheckbox1(objAutomationObjects, objDriver);
					objApplicationSteps.SelectKPICheckbox2(objAutomationObjects, objDriver);
					objApplicationSteps.SelectKPICheckbox3(objAutomationObjects, objDriver);
					objApplicationSteps.SelectKPICheckbox4(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDashSaveBtn(objAutomationObjects, objDriver);
					
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		 }
	 
	 
	 
	 public void ValidateSelectedKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.validateDepartmentName(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
	 
	 
	 
	 public void DownloadKPIGraph(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnKPIGraphDownload(objAutomationObjects, objDriver);
			
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		 }
	 
	 
	 public void ValidateDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.validateDownloadGraph(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
	 
	 
	 
	 public void DeselectAllKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnKPIPerfSettings(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDelsectAll(objAutomationObjects, objDriver);
			
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		 }
	 

	 
	 
	 public void ValidateDelsection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.validateDownloadGraph(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
		}
	 
	 
	 
	 public void AllselectionKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
					objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
					objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnKPIPerfSettings(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnSelectAll(objAutomationObjects, objDriver);
					objApplicationSteps.clickOnDashSaveBtn(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);}
			}
			
	 
			
			
			public void ValidateAllSelection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						//objApplicationSteps.validateDownloadGraph(objAutomationObjects, objDriver);
						
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);
				}
			}
	
			
			
			 public void SelectDefaultKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
					try {
						objAutomationObjects.objLogger.logInfo("", true);
						if (objGenericFunction.getNormalMethodExecutionFlag()) {
							objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
							objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
							objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnKPIPerfSettings(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnDefaultKPIBTN(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnDashSaveBtn(objAutomationObjects, objDriver);
							
						} else {
							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
						}
					} catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
						throw new Exception(e);}
					}		
			
			
			 public void SelectNewHollandDefaultKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
					try {
						objAutomationObjects.objLogger.logInfo("", true);
						if (objGenericFunction.getNormalMethodExecutionFlag()) {
							objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
							objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
							objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnBrandDropdown(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnBrandListDropdown(objAutomationObjects, objDriver);
							objApplicationSteps.selectBrand(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnKPIPerfSettings(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnDefaultKPIBTN(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnDashSaveBtn(objAutomationObjects, objDriver);
							
						} else {
							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
						}
					} catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
						throw new Exception(e);}
					}					
	
			public void SelectPLKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				try {
					objAutomationObjects.objLogger.logInfo("", true);
					if (objGenericFunction.getNormalMethodExecutionFlag()) {
						objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
						objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
						objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnPLdispersionSettings(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnSelectKPI1(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnSelectKPI2(objAutomationObjects, objDriver);
						objApplicationSteps.clickOnSaveBTN1(objAutomationObjects, objDriver);
						
					} else {
						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
					}
				} catch (Exception e) {
					objAutomationObjects.objLogger.logErrorWithException(e);
					throw new Exception(e);}
				}
		 
			
			 public void DownloadPLGraph(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
					try {
						objAutomationObjects.objLogger.logInfo("", true);
						if (objGenericFunction.getNormalMethodExecutionFlag()) {
							objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
							objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
							objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnPLGraphDownload(objAutomationObjects, objDriver);
					
							
						} else {
							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
						}
					} catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
						throw new Exception(e);
					}
			 }
			 
					
					
					
					public void ValidateAllKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
						try {
							objAutomationObjects.objLogger.logInfo("", true);
							if (objGenericFunction.getNormalMethodExecutionFlag()) {
								//objApplicationSteps.validateDownloadGraph(objAutomationObjects, objDriver);
								
							} else {
								Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
							}
						} catch (Exception e) {
							objAutomationObjects.objLogger.logErrorWithException(e);
							throw new Exception(e);
						}
				 }
			 
		 
			 
			 
	 public void SelectAllKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
						if (objGenericFunction.getNormalMethodExecutionFlag()) {
							objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
							objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
							objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnPLdispersionSettings(objAutomationObjects, objDriver);
							objApplicationSteps.SelectAllKPIbtn(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnSaveBTN1(objAutomationObjects, objDriver);
					
							
						} else {
							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
						}
					} catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
						throw new Exception(e);
					}
			 }
	 
	 
	 
	 public void selectDefaultKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
						if (objGenericFunction.getNormalMethodExecutionFlag()) {
							objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
							objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
							objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnPLdispersionSettings(objAutomationObjects, objDriver);
							objApplicationSteps.ClickOnDefaultKPIbtn(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnSaveBTN1(objAutomationObjects, objDriver);
					
							
						} else {
							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
						}
					} catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
						throw new Exception(e);
					}
			 }
	 
	 
	 public void ValidateDefaultKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.validateDownloadGraph(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	 }
			 
	 
	 
	 public void ClickOnMaxBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
						if (objGenericFunction.getNormalMethodExecutionFlag()) {
							objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
							objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
							objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnPLMaxBtn(objAutomationObjects, objDriver);
							objApplicationSteps.ClickOnDownloadMaxBTN(objAutomationObjects, objDriver);
							
							
						} else {
							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
						}
					} catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
						throw new Exception(e);
					}
			 }
	 
			 
	 
	 
	 public void ValidateMaxPage(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.validateDownloadGraph(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
	 }
	 
	 
	 
	 public void SelectMaxKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
						if (objGenericFunction.getNormalMethodExecutionFlag()) {
							objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
							objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
							objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
							objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);							
							objApplicationSteps.clickOnPLMaxBtn(objAutomationObjects, objDriver);
							objApplicationSteps.ClickOnSettingMaxBTN(objAutomationObjects, objDriver);
							objApplicationSteps.ClickOnCheckbox1(objAutomationObjects, objDriver);
							objApplicationSteps.ClickOnCheckbox2(objAutomationObjects, objDriver);
							objApplicationSteps.ClickOnMaxSaveBtn(objAutomationObjects, objDriver);
							
							
							
						} else {
							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
						}
					} catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
						throw new Exception(e);
					}
			 }
	 
	 
	 public void ValidateMaxKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
			try {
				objAutomationObjects.objLogger.logInfo("", true);
				if (objGenericFunction.getNormalMethodExecutionFlag()) {
					//objApplicationSteps.validateDownloadGraph(objAutomationObjects, objDriver);
					
				} else {
					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				}
			} catch (Exception e) {
				objAutomationObjects.objLogger.logErrorWithException(e);
				throw new Exception(e);
			}
			
			
	 }
	 
			 public void SelectMaxAllKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
					try {
						objAutomationObjects.objLogger.logInfo("", true);
								if (objGenericFunction.getNormalMethodExecutionFlag()) {
									objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
									objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
									objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
									objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
									objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
									objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);							
									objApplicationSteps.clickOnPLMaxBtn(objAutomationObjects, objDriver);
									objApplicationSteps.ClickMaxAllKPI(objAutomationObjects, objDriver);
									objApplicationSteps.ClickOnMaxSaveBtn(objAutomationObjects, objDriver);		
									
								} else {
									Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
								}
							} catch (Exception e) {
								objAutomationObjects.objLogger.logErrorWithException(e);
								throw new Exception(e);
							}
					 }
			 				
			
			 
			 public void SelectDefaultMaxKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
					try {
						objAutomationObjects.objLogger.logInfo("", true);
								if (objGenericFunction.getNormalMethodExecutionFlag()) {
									objApplicationSteps.clickOnFilterDropdown(objAutomationObjects, objDriver);
									objApplicationSteps.clickOnNetworkDropdownAC(objAutomationObjects, objDriver);
									objApplicationSteps.clickOnNetworkListDropdownAC(objAutomationObjects, objDriver);
									objApplicationSteps.clickOnSearchBtn(objAutomationObjects, objDriver);
									objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
									objApplicationSteps.selectNetwork(objAutomationObjects, objDriver);							
									objApplicationSteps.clickOnPLMaxBtn(objAutomationObjects, objDriver);
									objApplicationSteps.ClickOnDefaultKPIMaxbtn(objAutomationObjects, objDriver);
									objApplicationSteps.ClickOnMaxSaveBtn(objAutomationObjects, objDriver);		
									
								} else {
									Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
								}
							} catch (Exception e) {
								objAutomationObjects.objLogger.logErrorWithException(e);
								throw new Exception(e);
							}
					 }	 
			 
			
								
			 public void ValidateDefaultMaxKPI(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
					try {
						objAutomationObjects.objLogger.logInfo("", true);
						if (objGenericFunction.getNormalMethodExecutionFlag()) {
							//objApplicationSteps.validateDownloadGraph(objAutomationObjects, objDriver);
							
						} else {
							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
						}
					} catch (Exception e) {
						objAutomationObjects.objLogger.logErrorWithException(e);
						throw new Exception(e);
					}
			 }

			 
			 
			 
			 
			 //**//                          Anushka's Code End                        //**//    
			 
			 
			 //**                            Geo Generator                              //**//
			 
			 public void OpenGeoGenerator(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 	try {
				 		objAutomationObjects.objLogger.logInfo("", true);
				 				if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 					objApplicationSteps.clickonAdminitration(objAutomationObjects, objDriver);
				 					objApplicationSteps.clickonGeogenerator(objAutomationObjects, objDriver);
				 					
				 				} else {
				 					Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 				}
				 			} catch (Exception e) {
				 				objAutomationObjects.objLogger.logErrorWithException(e);
				 				throw new Exception(e);
				 			}
				 }
				 	
				 	public void verifyGeoGeneratorPageVisible(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 		try {
				 			objAutomationObjects.objLogger.logInfo("", true);
				 			if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 				objApplicationSteps.validateGeoGeneratorPageLabel(objAutomationObjects, objDriver);
				 				
				 			} else {
				 				Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 			}
				 		} catch (Exception e) {
				 			objAutomationObjects.objLogger.logErrorWithException(e);
				 			throw new Exception(e);
				 		}
				 	
				 	}
				 	public void clickFetchGeoLocations(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 		try {
				 			objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.clickonfetchlocations(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 	}
				 	public void verifylatitudelongitude(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 		try {
				 			objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.validateLatAndLongDetails(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 	}
				 	public void verifycoordinatesSaved(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 		try {
				 			objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.validateCoordinateTickBtn(objAutomationObjects, objDriver);
				 						objApplicationSteps.clickonreload(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 	}
					public void verifycoordinatesReloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 		try {
				 			objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.validateDealerReloadBtn(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 	}
				 	
				 	public void dealerCoordinateReloadBtn(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 		try {
				 			objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.clickonreload(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 	}
				 		public void verifySaveEnabled(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 			try {
				 				objAutomationObjects.objLogger.logInfo("", true);
				 						if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 							//objApplicationSteps.clickonAdminitration(objAutomationObjects, objDriver);
						 					//objApplicationSteps.clickonGeogenerator(objAutomationObjects, objDriver);
						 					//objApplicationSteps.clickonfetchlocations(objAutomationObjects, objDriver);
				 							objApplicationSteps.clickonSave(objAutomationObjects, objDriver);
				 							//objApplicationSteps.validatesavepage(objAutomationObjects, objDriver);
				 							//objApplicationSteps.clickonreload(objAutomationObjects, objDriver);
				 							//objApplicationSteps.validatereload(objAutomationObjects, objDriver);
				 							
				 						} else {
				 							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 						}
				 					} catch (Exception e) {
				 						objAutomationObjects.objLogger.logErrorWithException(e);
				 						throw new Exception(e);
				 					}}
				 	 			
	//** //                Quick Reports                                     //**//
	
				 		public void QuickReportsection(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 			try {
				 				objAutomationObjects.objLogger.logInfo("", true);
				 						if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 							objApplicationSteps.clickOnFilterExpandBtnForOpportunity(objAutomationObjects, objDriver);
				 							objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				 							objApplicationSteps.clickOnNetworkListDropdownForKpiPerformance(objAutomationObjects, objDriver);
				 							objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
				 							objApplicationSteps.enterDealerNetworkName(objAutomationObjects, objDriver);
				 							objApplicationSteps.selectDealerName(objAutomationObjects, objDriver);
				 							objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				 							objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				 						//	objApplicationSteps.clickOnPeriodDropdown(objAutomationObjects, objDriver);
				 							objApplicationSteps.scrollondashboard(objAutomationObjects, objDriver);
				 							
				 						} else {
				 							Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 						}
				 					} catch (Exception e) {
				 						objAutomationObjects.objLogger.logErrorWithException(e);
				 						throw new Exception(e);
				 					}
				 		
				 		}
				 			public void ValidateQuickReport(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 							if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 								objApplicationSteps.verifyquickreport(objAutomationObjects, objDriver);
				 								
				 							} else {
				 								Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 							}
				 						} catch (Exception e) {
				 							objAutomationObjects.objLogger.logErrorWithException(e);
				 							throw new Exception(e);
				 						}
				 						}
				 			
				 			
				 				
				 				public void Downloadexcel(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 					try {
				 						objAutomationObjects.objLogger.logInfo("", true);
				 								if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 									objApplicationSteps.clickonexceldownload(objAutomationObjects, objDriver);
				 									
				 								} else {
				 									Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 								}
				 							} catch (Exception e) {
				 								objAutomationObjects.objLogger.logErrorWithException(e);
				 								throw new Exception(e);
				 							}
				 				}
				 				
				 				
				 				public void DownloadPDF(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 					try {
				 						objAutomationObjects.objLogger.logInfo("", true);
				 								if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 									objApplicationSteps.clickonPDFdownload(objAutomationObjects, objDriver);
				 							
				 									
				 								} else {
				 									Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 								}
				 							} catch (Exception e) {
				 								objAutomationObjects.objLogger.logErrorWithException(e);
				 								throw new Exception(e);
				 							}
				 							
				 							}
				 			
				 			
				 			public void validateQuickReportDownload(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 							if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 								objApplicationSteps.verifyQuikReportDownloadBtn(objAutomationObjects, objDriver);
				 								
				 							} else {
				 								Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 							}
				 						} catch (Exception e) {
				 							objAutomationObjects.objLogger.logErrorWithException(e);
				 							throw new Exception(e);
				 						}
				 			}
				
	//**//                    Validation Rule                     //**//
				 			
				 			
				 			
				 			public void selectValidationRuleEditor(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				 						objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				 						objApplicationSteps.clickOnNetworkListDropdown(objAutomationObjects, objDriver);
				 						objApplicationSteps.clickOnNetworkSearch(objAutomationObjects, objDriver);
				 						objApplicationSteps.enterNetworkName(objAutomationObjects, objDriver);
				 						objApplicationSteps.selectName(objAutomationObjects, objDriver);
				 						objApplicationSteps.clickOnNetworkDropdown(objAutomationObjects, objDriver);
				 						objApplicationSteps.clickOnFilterExpandBtn(objAutomationObjects, objDriver);
				 			           objApplicationSteps.clickOnSubmissionManagerDropdown(objAutomationObjects, objDriver);
				 				       objApplicationSteps.ClickOnValidationRuleEditor(objAutomationObjects, objDriver);
				 				     //  objApplicationSteps.ClickonEdit(objAutomationObjects, objDriver);
				 				       
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 			}
				 			 
				 			 
				 			public void ValidationPageOpenSuccessfully(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.ValidationPageshouldBeVisible(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 			}
				 			 
				 			public void SelectEditField(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.clickOnSubmissionsDropdown(objAutomationObjects, objDriver);
				 					    objApplicationSteps.ClickOnValidationRuleEditor(objAutomationObjects, objDriver);
				 					    objApplicationSteps.ClickonEdit(objAutomationObjects, objDriver);
				 					    objApplicationSteps.clickOnMinimumError(objAutomationObjects, objDriver);
				 					    objApplicationSteps.EnterMinimumError(objAutomationObjects, objDriver);
				 					    objApplicationSteps.clickOnMinimumWarning(objAutomationObjects, objDriver);
				 					    objApplicationSteps.EnterMinimumWarning(objAutomationObjects, objDriver);
				 					   // objApplicationSteps.clickOnRule(objAutomationObjects, objDriver);
				 					   // objApplicationSteps.EnterRule(objAutomationObjects, objDriver);
				 					    objApplicationSteps.clickOnMaxWarning(objAutomationObjects, objDriver);
				 					    objApplicationSteps.EnterMaxWarning(objAutomationObjects, objDriver);
				 					    objApplicationSteps.ClickonMaxError(objAutomationObjects, objDriver);
				 					    objApplicationSteps.EnterMaxError(objAutomationObjects, objDriver);
				 					    objApplicationSteps.ClickOnEditHistory(objAutomationObjects, objDriver);
				 					    objApplicationSteps.CloseEditHistory(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 			}
				 			 
				 								
				 			public void  SearchBox(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.clickOnSubmissionsDropdown(objAutomationObjects, objDriver);
				 					    objApplicationSteps.ClickOnValidationRuleEditor(objAutomationObjects, objDriver);
				 						objApplicationSteps.ClickonSearchBox(objAutomationObjects, objDriver);
				 						objApplicationSteps.EnterValidation(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 			}
				 			 
				 			 
				 			public void ValidateSearch(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.ValidateSearchResult(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 			}
				 			 
				 			 
				 			public void DownloadValidationRule(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 			           objApplicationSteps.clickOnSubmissionsDropdown(objAutomationObjects, objDriver);
				 				       objApplicationSteps.ClickOnValidationRuleEditor(objAutomationObjects, objDriver);
				 				       objApplicationSteps.ClickOnDownloadValidation(objAutomationObjects, objDriver);
				 				     
				 				       
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 			}
				 			 
				 			 
				 			public void  SaveValidationRule(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.clickOnSubmissionsDropdown(objAutomationObjects, objDriver);
				 					    objApplicationSteps.ClickOnValidationRuleEditor(objAutomationObjects, objDriver);
				 					    objApplicationSteps.ClickonEdit(objAutomationObjects, objDriver);
				 						objApplicationSteps.ClickoValidationSaveBtn(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 			}
				 			 
				 			 
				 			public void CancelRule(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.clickOnSubmissionsDropdown(objAutomationObjects, objDriver);
				 					    objApplicationSteps.ClickOnValidationRuleEditor(objAutomationObjects, objDriver);
				 					    objApplicationSteps.ClickonEdit(objAutomationObjects, objDriver);
				 						objApplicationSteps.ClickoValidationCancelBtn(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 			}
				 			 
				 			 
				 			public void ValidateCancelRule(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.ValidateCancelRules(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 			 
				 			}
				 			
				 			public void SelectFilter(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.clickOnSubmissionsDropdown(objAutomationObjects, objDriver);
				 					    objApplicationSteps.ClickOnValidationRuleEditor(objAutomationObjects, objDriver);
				 					    objApplicationSteps.ClickonValidationFilter(objAutomationObjects, objDriver);
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 			}
				 			public void ValidationFilter(Wave3AutomationObjects objAutomationObjects, WebDriver objDriver) throws Exception {
				 				try {
				 					objAutomationObjects.objLogger.logInfo("", true);
				 					if (objGenericFunction.getNormalMethodExecutionFlag()) {
				 						objApplicationSteps.ValidateUserAbletoFilter(objAutomationObjects, objDriver);
				 						
				 					} else {
				 						Wave3AutomationObjects.objTestResult.prepareMethodTrace(objGenericFunction.getMethodName());
				 					}
				 				} catch (Exception e) {
				 					objAutomationObjects.objLogger.logErrorWithException(e);
				 					throw new Exception(e);
				 				}
				 			}
				 			
				 		
}