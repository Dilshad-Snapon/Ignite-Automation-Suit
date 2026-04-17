package stepDefinition.DNSFeatures;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import stepDefinition.Wave3ApplicationFunctionLibrary;
import wave3CoreAutomation.Wave3AutomationBaseClass;
import wave3CoreAutomation.Wave3AutomationObjects;

@SuppressWarnings("static-access")
public class DNSGlueCode extends Wave3AutomationBaseClass {

	Wave3AutomationObjects objAutomationObjects = new Wave3AutomationObjects(strDriveLetter);
	
	public static Wave3ApplicationFunctionLibrary objApplicationFunctionLibrary = new Wave3ApplicationFunctionLibrary();

////////////////////////Given Statements Test Data//////////////////////////////////// 

	@Given("^GM_PrintValidations Test Data as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void gm_PrintValidations_Test_Data_as(String arg1, String arg2, String arg3) throws Throwable {
		String strTestDataSeparator = Wave3AutomationObjects.objAutomationConfig.getConfigValues("TestDataSeparator");
		String strDataElement[] = "TestCondition|Validations|Common".split("\\|");
		String strDataValue[] = (arg1 + strTestDataSeparator + arg2 + strTestDataSeparator + arg3)
				.split(strTestDataSeparator);
		Wave3AutomationObjects.objTestData.addTestData(strDataElement, strDataValue);
	}

	@Given("^GMNA_Authenticate_01 Test data as \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void gmhit_printValidations_navigation_Test_Data_as(String arg1, String arg2, String arg3, String arg4,
			String arg5) throws Throwable {
		String strTestDataSeparator = Wave3AutomationObjects.objAutomationConfig.getConfigValues("TestDataSeparator");
		String strDataElement[] = "TestCondition|UserID|Portal|Account Id|UserRole".split("\\|");
		String strDataValue[] = (arg1 + strTestDataSeparator + arg2 + strTestDataSeparator + arg3 + strTestDataSeparator
				+ arg4 + strTestDataSeparator + arg5).split(strTestDataSeparator);
		Wave3AutomationObjects.objTestData.addTestData(strDataElement, strDataValue);
	}

	@Given("^User is at Home Page$")
	public void user_is_at_Home_Page() throws Throwable {
		objApplicationFunctionLibrary.goToHome(objAutomation, Driver);
	}
	@Given("^User is at Dashboard page$")
	public void user_is_at_Dashboard_page() throws Throwable {
		objApplicationFunctionLibrary.dashboardPage(objAutomation, Driver);
	}
	@Given("^User is at Map page$")
	public void user_is_at_Map_page() throws Throwable {
		objApplicationFunctionLibrary.mapViewPage(objAutomation, Driver);
	}
	@Given("^User is Maximize window screen$")
	public void user_is_Maximize_window_screen() throws Throwable {
	}
	@Given("^User is at Item Drill Down Page$")
	public void user_is_at_Item_Drill_Down_Page() throws Throwable {
		objApplicationFunctionLibrary.KpiAnalysisItemDrill(objAutomation, Driver);
	}
	@Given("^User is at PL Dispersion Maximize window page$")
	public void user_is_at_PL_Dispersion_Maximize_window_page() throws Throwable {
		objApplicationFunctionLibrary.PLDispersionMaximizeScreen(objAutomation, Driver);
	}
	@Given("^User is at DNS Library page$")
	public void user_is_at_DNS_Library_page() throws Throwable {
		objApplicationFunctionLibrary.dnsLibraryPage(objAutomation, Driver);
	}
	@Given("^User is at alert page$")
	public void user_is_at_alert_page() throws Throwable {
		objApplicationFunctionLibrary.alertPage(objAutomation, Driver);
	}

	@Given("^Login Testdata as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void login_Testdata_as(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		String strTestDataSeparator = Wave3AutomationObjects.objAutomationConfig.getConfigValues("TestDataSeparator");
		String strDataElement[] = "TestCondition|Application_URL|UserName|Password".split("\\|");
		String strDataValue[] = (arg1 + strTestDataSeparator + arg2 + strTestDataSeparator + arg3 + strTestDataSeparator + arg4 + strTestDataSeparator).split(strTestDataSeparator);
		Wave3AutomationObjects.objTestData.addTestData(strDataElement, strDataValue);
	
		objAutomationObjects.objTestData.getTestData("Password");
		String mm=objAutomationObjects.objTestData.getTestData("Password");
	}
	
	@Given("^Browser is launched$")
	public void browser_is_launched() throws Throwable {
		objApplicationFunctionLibrary.launchBrowser(objAutomation, Driver, "Application_URL");
		
	}
	
	@When("^User enter login details$")
	public void user_enter_login_details() throws Throwable {
		objApplicationFunctionLibrary.userLogin(objAutomation, Driver, "UserName","Password");
	}
	
	@When("^User Add a Part to Shopping List$")
	public void user_Add_a_Part_to_Shopping_List() throws Throwable {
//		objApplicationFunctionLibrary.userAddPartToShoppingList(objAutomation, Driver);
	}

	@When("^User Log Out from Application$")
	public void user_Log_Out_from_Application() throws Throwable {
		// objApplicationFunctionLibrary.LogOut(objAutomation,Driver);
		objApplicationFunctionLibrary.logout(objAutomation, Driver);
	}

	@When("^User Search The Search Term$")
	public void user_Search_The_Search_Term() throws Throwable {
		objApplicationFunctionLibrary.userPerformSearchAtHomePage(objAutomation, Driver);
	}
	
	@When("^User Exit from Application$")
	public void user_Exit_from_Application() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}
	@When("^User click on help contact button$")
	public void user_click_on_help_contact_button() throws Throwable {
		objApplicationFunctionLibrary.userClickOnHelpBtn(objAutomation, Driver);
	}
	@When("^User move to map view from Global selection$")
	public void user_move_to_map_view_from_Global_selection() throws Throwable {
		objApplicationFunctionLibrary.MapBtn(objAutomation, Driver);
	}
	@When("^User move to map view from market selection$")
	public void user_move_to_map_view_from_market_selection() throws Throwable {
		objApplicationFunctionLibrary.mapForMarketSelection(objAutomation, Driver);
	}
	@When("^User move to map view from dealer selection$")
	public void user_move_to_map_view_from_dealer_selection() throws Throwable {
		objApplicationFunctionLibrary.mapForDealerSelection(objAutomation, Driver);
	}
	@When("^User click on full page map view button$")
	public void user_click_on_full_page_map_view_button() throws Throwable {
		objApplicationFunctionLibrary.fullPageMapView(objAutomation, Driver);
	}
	@When("^User click on department options$")
	public void user_click_on_department_options() throws Throwable {
		objApplicationFunctionLibrary.mapViewdepartments(objAutomation, Driver);
	}
	@When("^User click on department KPI options$")
	public void user_click_on_department_KPI_options() throws Throwable {
		objApplicationFunctionLibrary.mapViewDeptKpi(objAutomation, Driver);
	}
	@When("^User click on any market on map$")
	public void user_click_on_any_market_on_map() throws Throwable {
		objApplicationFunctionLibrary.clickOnMap(objAutomation, Driver);
	}
	@When("^User click on Zoom in and Zoom out Btn$")
	public void user_click_on_Zoom_in_and_Zoom_out_Btn() throws Throwable {
		objApplicationFunctionLibrary.MapZoomInAndOut(objAutomation, Driver);
	}
	@When("^User click on any dealer$")
	public void user_click_on_any_dealer() throws Throwable {
		objApplicationFunctionLibrary.ClickOnDealerMap(objAutomation, Driver);
	}
	@When("^User select Global from network hierarchy$")
	public void user_select_Global_from_network_hierarchy() throws Throwable {
		objApplicationFunctionLibrary.GlobalSelectionInNetwork(objAutomation, Driver);
	}
	@When("^User select Global from network hierarchy for Performance variation chart$")
	public void user_select_Global_from_network_hierarchy_for_Performance_variation_chart() throws Throwable {
		objApplicationFunctionLibrary.GlobalSelectionInNetworkForPerformanceVariationChart(objAutomation, Driver);
	}
	@When("^User select Global from network hierarchy for Network dispersion chart$")
	public void user_select_Global_from_network_hierarchy_for_Network_dispersion_chart() throws Throwable {
		objApplicationFunctionLibrary.GlobalSelectionInNetworkForNetworkDispersionChart(objAutomation, Driver);
	}
	@When("^User select Global from network hierarchy for PL dispersion chart$")
	public void user_select_Global_from_network_hierarchy_for_PL_dispersion_chart() throws Throwable {
		objApplicationFunctionLibrary.GlobalSelectionInNetworkForPlDispersionChart(objAutomation, Driver);
	}
	@When("^User take total dealership sales value for two market$")
	public void user_take_total_dealership_sales_value_for_two_market() throws Throwable {
		objApplicationFunctionLibrary.dealershipValueOfMarket(objAutomation, Driver);
	}
	@When("^User click on zoom In and Zoom out button$")
	public void user_click_on_zoom_In_and_Zoom_out_button() throws Throwable {
		objApplicationFunctionLibrary.networkDispersionZoomInAndZoomOut(objAutomation, Driver);
	}
	@When("^User click on download button$")
	public void user_click_on_download_button() throws Throwable {
		objApplicationFunctionLibrary.networkDispersionDownloadButton(objAutomation, Driver);
	}
	@When("^User select market from network hierarchy$")
	public void user_select_market_from_network_hierarchy() throws Throwable {
		objApplicationFunctionLibrary.dashboardMarketSelection(objAutomation, Driver);
	}
	@When("^User select market from network hierarchy for KPI Performance chart$")
	public void user_select_market_from_network_hierarchy_for_KPI_Performance_chart() throws Throwable {
		objApplicationFunctionLibrary.dashboardMarketSelectionForKpiPerformance(objAutomation, Driver);
	}
	@When("^User select Dealer from network hierarchy selection for KPI Performance chart$")
	public void user_select_Dealer_from_network_hierarchy_selection_for_KPI_Performance_chart() throws Throwable {
		objApplicationFunctionLibrary.dashboardDealerSelectionForKpiPerformance(objAutomation, Driver);
	}
	@When("^User click on market dispersion chart download button$")
	public void user_click_on_market_dispersion_chart_download_button() throws Throwable {
		objApplicationFunctionLibrary.marketDispersionDownloadButton(objAutomation, Driver);
	}
	@When("^User extract chart values$")
	public void user_extract_chart_values() throws Throwable {
		objApplicationFunctionLibrary.readChartValues(objAutomation, Driver);
	}
	@When("^User click on Set Default setting button$")
	public void user_click_on_Set_Default_setting_button() throws Throwable {
		objApplicationFunctionLibrary.validateSetDefaultSetting(objAutomation, Driver);
	}
	@When("^User click on filter hide/unhide button$")
	public void user_click_on_filter_hide_unhide_button() throws Throwable {
		objApplicationFunctionLibrary.validateFixedReportFilterHideBtn(objAutomation, Driver);
	}
	@When("^User click on select all and unselect all option$")
	public void user_click_on_select_all_and_unselect_all_option() throws Throwable {
		objApplicationFunctionLibrary.validatePDFSelectAllOption(objAutomation, Driver);
	}
	@When("^User select KPI Analysis averages$")
	public void user_select_KPI_Analysis_averages() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisAverages(objAutomation, Driver);
	}
	@When("^User click on Average ON and OFF button$")
	public void user_click_on_Average_ON_and_OFF_button() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisAverageSwitch(objAutomation, Driver);
	}
	@When("^User click on KPI analysis setting button$")
	public void user_click_on_KPI_analysis_setting_button() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisSettingBtn(objAutomation, Driver);
	}
	@When("^User click on KPI analysis download button$")
	public void user_click_on_KPI_analysis_download_button() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisDownloadBtn(objAutomation, Driver);
	}
	@When("^User click on KPI analysis Maximize button$")
	public void user_click_on_KPI_analysis_Maximize_button() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisMaximizeBtn(objAutomation, Driver);
	}
	@When("^User select KPI Analysis max window averages$")
	public void user_select_KPI_Analysis_max_window_averages() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisMaximizeAverages(objAutomation, Driver);
	}
	@When("^User click on max window Average ON and OFF button$")
	public void user_click_on_max_window_Average_ON_and_OFF_button() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisMaximizeAverageSwitchBtn(objAutomation, Driver);
	}
	@When("^User click on KPI analysis download button in maxmize window$")
	public void user_click_on_KPI_analysis_download_button_in_maxmize_window() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisMaximizeScreenDownloadBtn(objAutomation, Driver);
	}
	@When("^User click on KPI analysis item from maximize window$")
	public void user_click_on_KPI_analysis_item_from_maximize_window() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisMaximizeScreenItem(objAutomation, Driver);
	}
	@When("^User click on KPI analysis item from dashboard page$")
	public void user_click_on_KPI_analysis_item_from_dashboard_page() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisDashboardItemDrill(objAutomation, Driver);
	}
	@When("^User click on KPI data download button$")
	public void user_click_on_KPI_data_download_button() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisKpiDataDownloadBtn(objAutomation, Driver);
	}
	@When("^User click on KPI calculation download button$")
	public void user_click_on_KPI_calculation_download_button() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisKpiCalculationDownloadBtn(objAutomation, Driver);
	}
	@When("^User click on KPI calculation download button for dealer selection$")
	public void user_click_on_KPI_calculation_download_button_for_dealer_selection() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisKpiCalculationDownloadBtnForDealerSelection(objAutomation, Driver);
	}

	@When("^User select first average for KPI Trend$")
	public void user_select_first_average_for_KPI_Trend() throws Throwable {
		objApplicationFunctionLibrary.kpiTrendFirstAverage(objAutomation, Driver);
	}
	@When("^User select Second average for KPI Trend$")
	public void user_select_Second_average_for_KPI_Trend() throws Throwable {
		objApplicationFunctionLibrary.kpiTrendSecondAverage(objAutomation, Driver);
	}
	@When("^User click on first KPI Trend Average ON and OFF button$")
	public void user_click_on_first_KPI_Trend_Average_ON_and_OFF_button() throws Throwable {
		objApplicationFunctionLibrary.kpiTrendFirstAverageSwitchBtn(objAutomation, Driver);
	}
	@When("^User click on second KPI Trend Average ON and OFF button$")
	public void user_click_on_second_KPI_Trend_Average_ON_and_OFF_button() throws Throwable {
		objApplicationFunctionLibrary.kpiTrendSecondAverageSwitchBtn(objAutomation, Driver);
	}
	@When("^User click on KPI Trend download button$")
	public void user_click_on_KPI_Trend_download_button() throws Throwable {
		objApplicationFunctionLibrary.kpiTrendDownloadBtn(objAutomation, Driver);
	}
	@When("^User select market trend averages$")
	public void user_select_market_trend_averages() throws Throwable {
		objApplicationFunctionLibrary.marketTrendAverage(objAutomation, Driver);
	}
	@When("^User click on market trend Average ON and OFF button$")
	public void user_click_on_market_trend_Average_ON_and_OFF_button() throws Throwable {
		objApplicationFunctionLibrary.marketTrendAverageSwitchBtn(objAutomation, Driver);
	}
	@When("^User click on market Trend download button$")
	public void user_click_on_market_Trend_download_button() throws Throwable {
		objApplicationFunctionLibrary.marketTrendAverageDownloadBtn(objAutomation, Driver);
	}
	@When("^User click on Max screen KPI analysis setting button$")
	public void user_click_on_Max_screen_KPI_analysis_setting_button() throws Throwable {
		objApplicationFunctionLibrary.maxScreenKpiSettingBtn(objAutomation, Driver);
	}
	@When("^User click on download option for Performance variation chart$")
	public void user_click_on_download_option_for_Performance_variation_chart() throws Throwable {
		objApplicationFunctionLibrary.performanceVariationDownloadBtn(objAutomation, Driver);
	}
	@When("^User select daler from network hierarchy$")
	public void user_select_daler_from_network_hierarchy() throws Throwable {
		objApplicationFunctionLibrary.dashboardDealerSelection(objAutomation, Driver);
	}
	@When("^User click on user setting$")
	public void user_click_on_user_setting() throws Throwable {
		objApplicationFunctionLibrary.userSettingBtn(objAutomation, Driver);
	}

    @When("^User enter user for imitate$")
    public void user_enter_user_for_imitate() throws Throwable {
    	objApplicationFunctionLibrary.userImitateField(objAutomation, Driver);
     }
    @When("^User move to component$")
    public void user_move_to_component() throws Throwable {
    	objApplicationFunctionLibrary.browserComponentForImitateUser(objAutomation, Driver);
    }
    @When("^User click on remove user option from imitate$")
    public void user_click_on_remove_user_option_from_imitate() throws Throwable {
    	objApplicationFunctionLibrary.removeUserFromImitate(objAutomation, Driver);
    }
    
    @When("^User click on PL Dispersion setting button$")
    public void user_click_on_PL_Dispersion_setting_button() throws Throwable {
    	objApplicationFunctionLibrary.plDispersionSettingBtn(objAutomation, Driver);
    }
    @When("^User click on PL Dispersion download button$")
    public void user_click_on_PL_Dispersion_download_button() throws Throwable {
    	objApplicationFunctionLibrary.plDispersionDownloadBtn(objAutomation, Driver);
    }
    @When("^User click on PL Dispersion maximize button$")
    public void user_click_on_PL_Dispersion_maximize_button() throws Throwable {
    	objApplicationFunctionLibrary.plDispersionMaximizeBtn(objAutomation, Driver);
    }
    @When("^User click on Maximize PL Dispersion setting button$")
    public void user_click_on_Maximize_PL_Dispersion_setting_button() throws Throwable {
    	objApplicationFunctionLibrary.plDispersionMaximizeSettingBtn(objAutomation, Driver);
    }
    @When("^User click on Maximize PL Dispersion download button$")
    public void user_click_on_Maximize_PL_Dispersion_download_button() throws Throwable {
    	objApplicationFunctionLibrary.plDispersionMaxDownloadBtn(objAutomation, Driver);
    }
    @When("^User click on KPI Performance setting button$")
    public void user_click_on_KPI_Performance_setting_button() throws Throwable {
    	objApplicationFunctionLibrary.kpiPerformanceSettingBtn(objAutomation, Driver);
    }
    @When("^User click on KPI Performance download button$")
    public void user_click_on_KPI_Performance_download_button() throws Throwable {
    	objApplicationFunctionLibrary.kpiPerformanceDownloadBtn(objAutomation, Driver);
    }
    @When("^User click on KPI Performance dealer download button$")
    public void user_click_on_KPI_Performance_dealer_download_button() throws Throwable {
    	objApplicationFunctionLibrary.kpiPerformanceDealerDownloadBtn(objAutomation, Driver);
    }
    @When("^The user click on alert button$")
    public void the_user_click_on_alert_button() throws Throwable {
    	objApplicationFunctionLibrary.alertPageButton(objAutomation, Driver);
    }
    @When("^The user click on alert name$")
    public void the_user_click_on_alert_name() throws Throwable {
    	objApplicationFunctionLibrary.alertNameBtn(objAutomation, Driver);
    }
    @When("^The user mark alert as read$")
    public void the_user_mark_alert_as_read() throws Throwable {
    	objApplicationFunctionLibrary.alertMarkreadBtn(objAutomation, Driver);
    }  
    @When("^The user mark alerts as flagged$")
    public void the_user_mark_alerts_as_flagged() throws Throwable {
    	objApplicationFunctionLibrary.alertMarkFlagBtn(objAutomation, Driver);
    }
    @When("^The user mark alerts as critical$")
    public void the_user_mark_alerts_as_critical() throws Throwable {
    	objApplicationFunctionLibrary.alertMarkCriticalBtn(objAutomation, Driver);
    }
    @When("^The user mark alerts as hide$")
    public void the_user_mark_alerts_as_hide() throws Throwable {
    	objApplicationFunctionLibrary.alertMarkDeleteBtn(objAutomation, Driver);
    }
    @When("^The user click on unread button$")
    public void the_user_click_on_unread_button() throws Throwable {
    	objApplicationFunctionLibrary.alertMarkUnreadBtn(objAutomation, Driver);
    }
    @When("^The user search alert in search bar$")
    public void the_user_search_alert_in_search_bar() throws Throwable {
    	objApplicationFunctionLibrary.alertSearchField(objAutomation, Driver);
    }
    @When("^The user alert startup page enable button$")
    public void the_user_alert_startup_page_enable_button() throws Throwable {
    	objApplicationFunctionLibrary.alertStartUpPagePopUpBtn(objAutomation, Driver);
    } 
    @When("^User click on dasboard page button$")
    public void user_click_on_dasboard_page_button() throws Throwable {
    	objApplicationFunctionLibrary.clickOnDashboardPageBtn(objAutomation, Driver);
    }
    @When("^User click on network selector filter buton$")
    public void user_click_on_network_selector_filter_buton() throws Throwable {
    	objApplicationFunctionLibrary.clickOnDashboardNetworkSelectorBtn(objAutomation, Driver);
    }
    @When("^User click on network selector filter buton for KPI Performance chart$")
    public void user_click_on_network_selector_filter_buton_for_KPI_Performance_chart() throws Throwable {
    	objApplicationFunctionLibrary.clickOnDashboardNetworkSelectorBtnForKPIPerformanceChart(objAutomation, Driver);
    }
    @When("^User select Dealer from network hierarchy for Opportunity$")
    public void user_select_Dealer_from_network_hierarchy_for_Opportunity() throws Throwable {
    	objApplicationFunctionLibrary.dashboardDealerSelectionForKpiPerformance(objAutomation, Driver);
    }
    @When("^User select average for opportunity$")
    public void user_select_average_for_opportunity() throws Throwable {
    	objApplicationFunctionLibrary.opportunityAverageSelection(objAutomation, Driver);
    }
    @When("^User select department for opportunity$")
    public void user_select_department_for_opportunity() throws Throwable {
    	objApplicationFunctionLibrary.dashboardDepartmentSelectionForDealer(objAutomation, Driver);
    }
    @When("^User select period for opportuniy$")
    public void user_select_period_for_opportuniy() throws Throwable {
    	objApplicationFunctionLibrary.dashboardPeriodSelection(objAutomation, Driver);
    }
    @When("^User select dealer and model from forecast page$")
    public void user_select_dealer_and_model_from_forecast_page() throws Throwable {
    	objApplicationFunctionLibrary.forecastDealerAndModelSelection(objAutomation, Driver);
    }
    @When("^User click on save and Save As buttons$")
    public void user_click_on_save_and_Save_As_buttons() throws Throwable {
    	objApplicationFunctionLibrary.forecastSaveAndSaveAsFunctionality(objAutomation, Driver);
    }
    @When("^User click reset button$")
    public void user_click_reset_button() throws Throwable {
    	objApplicationFunctionLibrary.forecastResetFunctionality(objAutomation, Driver);
    }
    @When("^User click on private and Published buttons$")
    public void user_click_on_private_and_Published_buttons() throws Throwable {
    	objApplicationFunctionLibrary.ForecastPrivateFunctionality(objAutomation, Driver);
    	objApplicationFunctionLibrary.ForecastPublishedFunctionality(objAutomation, Driver);
    }
    @When("^User  click on delete button$")
    public void user_click_on_delete_button() throws Throwable {
    	objApplicationFunctionLibrary.forecastDeleteFunctionality(objAutomation, Driver);
    }

	@Then("^All Inactive Jobs get Closed and Saved$")
	public void all_inactive_jobs_get_closed_and_saved() throws Throwable {
//objApplicationFunctionLibrary.validateSavedOthersJobs(objAutomation, Driver);
	}
	@Then("^Forecast should be private and published$")
	public void forecast_should_be_private_and_published() throws Throwable {
		//objApplicationFunctionLibrary.validateForecastPrivatePublishedFunctionality(objAutomation, Driver);
	}
	@Then("^Forecast should be deleted$")
	public void forecast_should_be_deleted() throws Throwable {
		//objApplicationFunctionLibrary.validateForecastDeleteFunctionality(objAutomation, Driver);
	}
	@Then("^Dealer and model should be selected successfully$")
	public void dealer_and_model_should_be_selected_successfully() throws Throwable {
		objApplicationFunctionLibrary.validateForecastDealerAndModelSelection(objAutomation, Driver);
	}
	@Then("^Forecast Should be saved successfully$")
	public void forecast_Should_be_saved_successfully() throws Throwable {
		objApplicationFunctionLibrary.validateForecastSaveAndSaveAsFunctionality(objAutomation, Driver);
	}
	@Then("^Entered Forecast Data shoule be cleared$")
	public void entered_Forecast_Data_shoule_be_cleared() throws Throwable {
		objApplicationFunctionLibrary.validateForecastResetFunctionality(objAutomation, Driver);
	}
	@Then("^Search Result Are Visible$")
	public void search_Result_Are_Visible() throws Throwable {
		objApplicationFunctionLibrary.validatSearchResultAtHomePage(objAutomation, Driver);
	}
	@Then("^Help windown should open$")
	public void help_windown_should_open() throws Throwable {
		objApplicationFunctionLibrary.validateUserAtHelpPage(objAutomation, Driver);
	}
	@Then("^Map should be accessable Global user$")
	public void map_should_be_accessable_Global_user() throws Throwable {
		objApplicationFunctionLibrary.validateUserNavigateToMapViewPage(objAutomation, Driver);
	}
	@Then("^Map should be accessable to Market user$")
	public void map_should_be_accessable_to_Market_user() throws Throwable {
		objApplicationFunctionLibrary.validateUserNavigateToMapViewPage(objAutomation, Driver);
	}
	@Then("^Map should not be accessable to dealer user$")
	public void map_should_not_be_accessable_to_dealer_user() throws Throwable {
		objApplicationFunctionLibrary.validateMapBtnNotAvailableForDealerSelection(objAutomation, Driver);
	}
	@Then("^Map should be view at full page$")
	public void map_should_be_view_at_full_page() throws Throwable {
		objApplicationFunctionLibrary.validateFullPageMapView(objAutomation, Driver);
	}
	@Then("^selected department should visible$")
	public void selected_department_should_visible() throws Throwable {
		objApplicationFunctionLibrary.validateDepartmentSelection(objAutomation, Driver);
	}
	@Then("^selected department kpi should visible$")
	public void selected_department_kpi_should_visible() throws Throwable {
		objApplicationFunctionLibrary.validateDepratmentKpiSelection(objAutomation, Driver);
	}
	@Then("^selected country details should appear on dashboard$")
	public void selected_country_details_should_appear_on_dashboard() throws Throwable {
		objApplicationFunctionLibrary.validateMapSelectionDetails(objAutomation, Driver);
	}
	@Then("^Map size should be changed accordingly$")
	public void map_size_should_be_changed_accordingly() throws Throwable {
		objApplicationFunctionLibrary.validateMapSize(objAutomation, Driver);
	}
	@Then("^selected dealer details should appear on dashboard$")
	public void selected_dealer_details_should_appear_on_dashboard() throws Throwable {
		objApplicationFunctionLibrary.validateMapDealerSelection(objAutomation, Driver);
	}
	@Then("^Network dispersion chart should appear$")
	public void network_dispersion_chart_should_appear() throws Throwable {
		objApplicationFunctionLibrary.validateNetworkDispersionChart(objAutomation, Driver);
	}
	@Then("^Bubble size should be different according to market performance$")
	public void bubble_size_should_be_different_according_to_market_performance() throws Throwable {
		objApplicationFunctionLibrary.bubbleSizeOfMarket(objAutomation, Driver);
	}
	@Then("^Bubble size should change accordingly$")
	public void bubble_size_should_change_accordingly() throws Throwable {
		objApplicationFunctionLibrary.validateBubbleSizeAfterResize(objAutomation, Driver);
	}
	@Then("^Chart details should be downloaded in excel sheet$")
	public void chart_details_should_be_downloaded_in_excel_sheet() throws Throwable {
		objApplicationFunctionLibrary.networkDispersionExcelDownload(objAutomation, Driver);
	}
	@Then("^Market dispersion chart should appear$")
	public void market_dispersion_chart_should_appear() throws Throwable {
		objApplicationFunctionLibrary.validateMarketDispersionChart(objAutomation, Driver);
	}
	@Then("^Market dispersion Chart details should be downloaded in excel sheet$")
	public void market_dispersion_Chart_details_should_be_downloaded_in_excel_sheet() throws Throwable {
		objApplicationFunctionLibrary.marketDispersionExcelDownload(objAutomation, Driver);
	}
	@Then("^Chart values should match with stored values$")
	public void chart_values_should_match_with_stored_values() throws Throwable {
		objApplicationFunctionLibrary.validateChartvalues(objAutomation, Driver);
	}
	@Then("^Reports selection should remain same everytime report page opens$")
	public void reports_selection_should_remain_same_everytime_report_page_opens() throws Throwable {
		objApplicationFunctionLibrary.validateDefaultSelectionAfterReopens(objAutomation, Driver);
	}
	@Then("^Filter hide/unhide as per selection$")
	public void filter_hide_unhide_as_per_selection() throws Throwable {
		objApplicationFunctionLibrary.validateFixedReportFilterShowBtn(objAutomation, Driver);
	}
	@Then("^Reports should get selected and unselected$")
	public void reports_should_get_selected_and_unselected() throws Throwable {
		objApplicationFunctionLibrary.validatePdfUnSelectAllOption(objAutomation, Driver);
	}
	@Then("^KPI Analysis chart should appear$")
	public void kpi_Analysis_chart_should_appear() throws Throwable {
		objApplicationFunctionLibrary.validateKpiAnalysisChart(objAutomation, Driver);
	}
	@Then("^User should be able to select KPI analsysis averages$")
	public void user_should_be_able_to_select_KPI_analsysis_averages() throws Throwable {
		objApplicationFunctionLibrary.validateKpiAnalysisAverages(objAutomation, Driver);
	}
	@Then("^User should be able to turn ON and OFF selected average$")
	public void user_should_be_able_to_turn_ON_and_OFF_selected_average() throws Throwable {
		objApplicationFunctionLibrary.validateKpiAnalysisSwitch(objAutomation, Driver);
	}
	@Then("^User should be able to select all KPI$")
	public void user_should_be_able_to_select_all_KPI() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisSelectAllKpiBtn(objAutomation, Driver);
	}
	@Then("^User should be able to DeSelect all KPI$")
	public void user_should_be_able_to_DeSelect_all_KPI() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisDeSelectAllKpiBtn(objAutomation, Driver);
	}
	@Then("^User should be able to Select Default KPI$")
	public void user_should_be_able_to_Select_Default_KPI() throws Throwable {
		objApplicationFunctionLibrary.kpiAnalysisSelectDefaultKpiBtn(objAutomation, Driver);
	}
	@Then("^KPI anlsyis chart details should be downloaded$")
	public void kpi_anlsyis_chart_details_should_be_downloaded() throws Throwable {
		objApplicationFunctionLibrary.validateKpiAnalysisDownloadBtn(objAutomation, Driver);
	}
	@Then("^User should be able to see KPI anlsysis chart in maximize window$")
	public void user_should_be_able_to_see_KPI_anlsysis_chart_in_maximize_window() throws Throwable {
		objApplicationFunctionLibrary.validateKpiAnalysisMaxScreen(objAutomation, Driver);
	}
	@Then("^User should be able to select KPI analsysis max window averages$")
	public void user_should_be_able_to_select_KPI_analsysis_max_window_averages() throws Throwable {
		objApplicationFunctionLibrary.validateKpiAnalysisMaximizeAverages(objAutomation, Driver);
	}
	@Then("^User should be able to turn ON and OFF selected max screen average$")
	public void user_should_be_able_to_turn_ON_and_OFF_selected_max_screen_average() throws Throwable {
		objApplicationFunctionLibrary.validateKpiAnalysisMaximizeAverageSwitchBtn(objAutomation, Driver);
	}
	@Then("^Max screen KPI analysis chart details should be downloaded$")
	public void max_screen_KPI_analysis_chart_details_should_be_downloaded() throws Throwable {
		objApplicationFunctionLibrary.validateKpiAnalysisMaximizeScreenDownloadBtn(objAutomation, Driver);
	}
	@Then("^User should be able to drill down that item$")
	public void user_should_be_able_to_drill_down_that_item() throws Throwable {
		objApplicationFunctionLibrary.validatekpiAnalysisItemDrillDownFromMaximizeScreen(objAutomation, Driver);
	}
	@Then("^User should be able to drill down that item from Dashboard$")
	public void user_should_be_able_to_drill_down_that_item_from_Dashboard() throws Throwable {
		objApplicationFunctionLibrary.validatekpiAnalysisItemDrillDownFromDashboard(objAutomation, Driver);
	}
	@Then("^User should be able download kpi data details$")
	public void user_should_be_able_download_kpi_data_details() throws Throwable {
		objApplicationFunctionLibrary.validatekpiAnalysisKpiDataDownloadBtn(objAutomation, Driver);
	}
	@Then("^User should be able download kpi calculation details$")
	public void user_should_be_able_download_kpi_calculation_details() throws Throwable {
		objApplicationFunctionLibrary.validatekpiAnalysisKpiCalculationDownloadBtn(objAutomation, Driver);
	}
	@Then("^User should be able to select first average for KPI Trend$")
	public void user_should_be_able_to_select_first_average_for_KPI_Trend() throws Throwable {
		objApplicationFunctionLibrary.validatekpiTrendFirstAverageSelection(objAutomation, Driver);
	}
	@Then("^User should be able to select second average for KPI Trend$")
	public void user_should_be_able_to_select_second_average_for_KPI_Trend() throws Throwable {
		objApplicationFunctionLibrary.validatekpiTrendSecondAverageSelection(objAutomation, Driver);
	}
	@Then("^User should be able to turn ON and OFF first KPI trend selected average$")
	public void user_should_be_able_to_turn_ON_and_OFF_first_KPI_trend_selected_average() throws Throwable {
		objApplicationFunctionLibrary.validatekpiTrendFirstAverageSwitch(objAutomation, Driver);
	}
	@Then("^User should be able to turn ON and OFF second KPI trend selected average$")
	public void user_should_be_able_to_turn_ON_and_OFF_second_KPI_trend_selected_average() throws Throwable {
		objApplicationFunctionLibrary.validatekpiTrendSecondAverageSwitch(objAutomation, Driver);
	}
	@Then("^User should be able download kpi trend details$")
	public void user_should_be_able_download_kpi_trend_details() throws Throwable {
		objApplicationFunctionLibrary.validatekpiTrendDownloadBtn(objAutomation, Driver);
	}
	@Then("^User should be able to select market trend averages$")
	public void user_should_be_able_to_select_market_trend_averages() throws Throwable {
		objApplicationFunctionLibrary.validatekpiTrendFirstAverageSelection(objAutomation, Driver);
	}
	@Then("^User should be able to turn ON and OFF selected market trend average$")
	public void user_should_be_able_to_turn_ON_and_OFF_selected_market_trend_average() throws Throwable {
		objApplicationFunctionLibrary.validatekpiTrendFirstAverageSwitch(objAutomation, Driver);
	}
	@Then("^User should be able download market trend details$")
	public void user_should_be_able_download_market_trend_details() throws Throwable {
		objApplicationFunctionLibrary.validatekpiTrendDownloadBtn(objAutomation, Driver);
	}
	
	@Then("^Performance variation chart should appear$")
	public void performance_variation_chart_should_appear() throws Throwable {
		objApplicationFunctionLibrary.validatePerformanceVariationChart(objAutomation, Driver);
	}
	
	@Then("^Performance variation chart details should download in excel format$")
	public void performance_variation_chart_details_should_download_in_excel_format() throws Throwable {
		objApplicationFunctionLibrary.validatePerformanceVariationDownload(objAutomation, Driver);
	}
	@Then("^User should see imitate option$")
	public void user_should_see_imitate_option() throws Throwable {
		objApplicationFunctionLibrary.validateImitateUserField(objAutomation, Driver);
	}
	@Then("^User should be able to imitate user$")
	public void user_should_be_able_to_imitate_user() throws Throwable {
		objApplicationFunctionLibrary.validateUserImitatesSuccessfully(objAutomation, Driver);
	}
	@Then("^User should be able to perform operation on selected component$")
	public void user_should_be_able_to_perform_operation_on_selected_component() throws Throwable {
		objApplicationFunctionLibrary.validateUserOperationThroughImitate(objAutomation, Driver);
	}
	@Then("^User should be able to navigate back to NSC user$")
	public void user_should_be_able_to_navigate_back_to_NSC_user() throws Throwable {
		objApplicationFunctionLibrary.validateUserNavigateToBaseUser(objAutomation, Driver);
	}
	@Then("^P&L dispersion chart should appear$")
	public void p_L_dispersion_chart_should_appear() throws Throwable {
		objApplicationFunctionLibrary.validatePLDispersionChart(objAutomation, Driver);
	}
	
	@Then("^User should be able to select all average for chart$")
	public void user_should_be_able_to_select_all_average_for_chart() throws Throwable {
		objApplicationFunctionLibrary.PLDispersionSelectAllAverage(objAutomation, Driver);
	}
	@Then("^User should be able to deselect all average for chart$")
	public void user_should_be_able_to_deselect_all_average_for_chart() throws Throwable {
		objApplicationFunctionLibrary.PLDispersionDeSelectAllAverage(objAutomation, Driver);
	}
	@Then("^User should be able to select default average for chart$")
	public void user_should_be_able_to_select_default_average_for_chart() throws Throwable {
		objApplicationFunctionLibrary.PLDispersionSelectDefaultAverage(objAutomation, Driver);
	}
	@Then("^User should be able to download PL dispersion chart$")
	public void user_should_be_able_to_download_PL_dispersion_chart() throws Throwable {
		objApplicationFunctionLibrary.validatePLDispersionDownloadBtn(objAutomation, Driver);
	}
	@Then("^User should be able to see PL dispersion chart in maximize screen$")
	public void user_should_be_able_to_see_PL_dispersion_chart_in_maximize_screen() throws Throwable {
		objApplicationFunctionLibrary.validatePLDispersionMaximizeScreen(objAutomation, Driver);
	}
	@Then("^User should be able to download Maximize PL dispersion chart$")
	public void user_should_be_able_to_download_Maximize_PL_dispersion_chart() throws Throwable {
		objApplicationFunctionLibrary.validatePLDispersionMaxDownloadBtn(objAutomation, Driver);
	}
	@Then("^User should be able to select all average for chart in maximize screen$")
	public void user_should_be_able_to_select_all_average_for_chart_in_maximize_screen() throws Throwable {
		objApplicationFunctionLibrary.PLDispersionMaxSelectAllAverage(objAutomation, Driver);
	}

	@Then("^User should be able to deselect all average for chart in maximize screen$")
	public void user_should_be_able_to_deselect_all_average_for_chart_in_maximize_screen() throws Throwable {
		objApplicationFunctionLibrary.PLDispersionMaxDeSelectAllAverage(objAutomation, Driver);
	}

	@Then("^User should be able to select default average for chart in maximize screen$")
	public void user_should_be_able_to_select_default_average_for_chart_in_maximize_screen() throws Throwable {
		objApplicationFunctionLibrary.PLDispersionMaxSelectDefaultAverage(objAutomation, Driver);
	}
	@Then("^KPI Performance chart should appear$")
	public void kpi_Performance_chart_should_appear() throws Throwable {
		objApplicationFunctionLibrary.validateKPIPerformanceChart(objAutomation, Driver);
	}
	@Then("^User should be able to select all KPI for chart$")
	public void user_should_be_able_to_select_all_KPI_for_chart() throws Throwable {
		objApplicationFunctionLibrary.kpiPerformanceSelectAllKpi(objAutomation, Driver);
	}
	@Then("^User should be able to Deselect all KPI for chart$")
	public void user_should_be_able_to_Deselect_all_KPI_for_chart() throws Throwable {
		objApplicationFunctionLibrary.kpiPerformanceDeSelectAllKpi(objAutomation, Driver);
	}
	@Then("^User should be able to select default KPI for chart$")
	public void user_should_be_able_to_select_default_KPI_for_chart() throws Throwable {
		objApplicationFunctionLibrary.kpiPerformanceSelectDefaultKpi(objAutomation, Driver);
	}
	@Then("^User should be able to download KPI Performance chart details$")
	public void user_should_be_able_to_download_KPI_Performance_chart_details() throws Throwable {
		objApplicationFunctionLibrary.validateKpiPerformanceDownloadBtn(objAutomation, Driver);
	}
	@Then("^User should be able to see alert page$")
	public void user_should_be_able_to_see_alert_page() throws Throwable {
		objApplicationFunctionLibrary.validateAlertPage(objAutomation, Driver);
	}
	@Then("^User should be able to see alert message$")
	public void user_should_be_able_to_see_alert_message() throws Throwable {
		objApplicationFunctionLibrary.validateAlertMessage(objAutomation, Driver);
	}
	@Then("^Alert should move to Read section$")
	public void alert_should_move_to_Read_section() throws Throwable {
		objApplicationFunctionLibrary.validateAlertMoveToRead(objAutomation, Driver);
	}
	@Then("^Alert should move to flagged section$")
	public void alert_should_move_to_flagged_section() throws Throwable {
		objApplicationFunctionLibrary.validateAlertMoveToFlagged(objAutomation, Driver);
	}
	@Then("^Alert should move to critical section$")
	public void alert_should_move_to_critical_section() throws Throwable {
		objApplicationFunctionLibrary.validateAlertMoveToCritical(objAutomation, Driver);
	}
	@Then("^Alert should move to deleted section$")
	public void alert_should_move_to_deleted_section() throws Throwable {
		objApplicationFunctionLibrary.validateAlertMoveToDeleted(objAutomation, Driver);
	}
	@Then("^User should able to see all unread alerts$")
	public void user_should_able_to_see_all_unread_alerts() throws Throwable {
		objApplicationFunctionLibrary.validateUnReadAlert(objAutomation, Driver);
	}
	@Then("^User should able to see searched alert$")
	public void user_should_able_to_see_searched_alert() throws Throwable {
		objApplicationFunctionLibrary.validateSearhedAlert(objAutomation, Driver);
	}
	@Then("^User should able to see alert on startup page$")
	public void user_should_able_to_see_alert_on_startup_page() throws Throwable {
		objApplicationFunctionLibrary.validateAlertAtStartUpPage(objAutomation, Driver);
	}
	@Then("^User should move back to dashboard page$")
	public void user_should_move_back_to_dashboard_page() throws Throwable {
		//objApplicationFunctionLibrary.dashboardPage(objAutomation,
	}
	@Then("^User should be able to close network selector$")
	public void user_should_be_able_to_close_network_selector() throws Throwable {
		objApplicationFunctionLibrary.validateNetworkClose(objAutomation, Driver);
	}
	@Then("^Opportunity should appear for selected dealer$")
	public void opportunity_should_appear_for_selected_dealer() throws Throwable {
		objApplicationFunctionLibrary.validateTotalOpportunityLabel(objAutomation, Driver);
	}
	@Then("^Opportunity should appear for selected average$")
	public void opportunity_should_appear_for_selected_average() throws Throwable {
		objApplicationFunctionLibrary.validateTotalOpportunityLabel(objAutomation, Driver);
	}
	@Then("^Opportunity should appear for selected department$")
	public void opportunity_should_appear_for_selected_department() throws Throwable {
		objApplicationFunctionLibrary.validateTotalOpportunityLabel(objAutomation, Driver);
	}
	@Then("^Opportunity should appear for selected period$")
	public void opportunity_should_appear_for_selected_period() throws Throwable {
		objApplicationFunctionLibrary.validateTotalOpportunityLabel(objAutomation, Driver);
	}
	@Then("^User should able to login and Logout from application$")
	public void user_should_able_to_login_and_Logout_from_application() throws Throwable {
		objApplicationFunctionLibrary.logoutFromApplication(objAutomation, Driver);
	}
	// Existing Components
	
	
	@Given("^User is at Dealer Dashboard page$")
	public void user_is_at_Dealer_Dashboard_page() throws Throwable {
		objApplicationFunctionLibrary.validateUserAtDealerDashboardpage(objAutomation, Driver);
	}
	@Given("^User is at Dealer Submissions page$")
	public void user_is_at_Dealer_Submissions_page() throws Throwable {
		objApplicationFunctionLibrary.validateUserAtDealerSubmissionspage(objAutomation, Driver);
	}
	 @When("^User move to Account maps page$")
	    public void user_move_to_Account_maps_page() throws Throwable {
	    	objApplicationFunctionLibrary.validateUserMoveToAccountMapsPage(objAutomation, Driver);
	    }
	@Given("^User is at Account maps page$")
	public void user_is_at_Account_maps_page() throws Throwable {
		objApplicationFunctionLibrary.validateUserAtAccountMapsPage(objAutomation, Driver);
	}
    @Given("^User is at published report page$")
	public void user_is_at_published_report_page() throws Throwable {
	    objApplicationFunctionLibrary.ValidateUserAtPublishedReportPage(objAutomation, Driver);
    }
	@Given("^User is at Flexible report page$")
	public void user_is_at_Flexible_report_page() throws Throwable {
		objApplicationFunctionLibrary.ValidateUserAtFlexibleReportPage(objAutomation, Driver);
	}
	@Given("^User is at Dns Analysis page$")
	public void user_is_at_Dns_Analysis_page() throws Throwable {
		objApplicationFunctionLibrary.ValidateUserAtDnsAnalysisPage(objAutomation, Driver);
	}
	@Given("^User is at Login page$")
	public void user_is_at_Login_page() throws Throwable {
	}
	@Given("^User is at landing page$")
	public void user_is_at_landing_page() throws Throwable {
	}
	@Given("^User is at Submission Manager page$")
	public void user_is_at_Submission_Manager_page() throws Throwable {
		objApplicationFunctionLibrary.ValidateUserAtSubmissionManagerPage(objAutomation, Driver);
	}
	@Given("^User is at DNS Forecast page$")
	public void user_is_at_DNS_Forecast_page() throws Throwable {
		objApplicationFunctionLibrary.ValidateUserAtDNSForecastPage(objAutomation, Driver);
	}
	@Given("^User is at Dns plan page$")
	public void user_is_at_Dns_plan_page() throws Throwable {
		objApplicationFunctionLibrary.ValidateUserAtDNSPlanPage(objAutomation, Driver);
	}
	@Given("^User is at Ops System selection page$")
	public void user_is_at_Ops_System_selection_page() throws Throwable {
		objApplicationFunctionLibrary.ValidateUserAtSystemSelectionPage(objAutomation, Driver);
	}
	
	@When("^User select dealer from network hierarchy$")
	public void user_select_dealer_from_network_hierarchy() throws Throwable {
		objApplicationFunctionLibrary.enterDealerInNetworkHierarchy(objAutomation, Driver);
		objApplicationFunctionLibrary.selectGivenDealerInNetworkHierarchy(objAutomation, Driver);
	}
	@When("^User select period from period dropdown$")
	public void user_select_period_from_period_dropdown() throws Throwable {
		objApplicationFunctionLibrary.validatePeriodSelector(objAutomation, Driver);
	}

    @When("^User select measure from measure dropdown$")
    public void user_select_measure_from_measure_dropdown() throws Throwable {
	objApplicationFunctionLibrary.validateMeasureSelector(objAutomation, Driver);
    }
   
    @When("^User select kpi from all KPI items$")
    public void user_select_kpi_from_all_KPI_items() throws Throwable {
	objApplicationFunctionLibrary.validateKPISelection(objAutomation, Driver);
    }
   
    @When("^User select Grid option$")
    public void user_select_Grid_option() throws Throwable {
	   objApplicationFunctionLibrary.validateKPIGridSelection(objAutomation, Driver);
    }
    
    @When("^User select KPI in dept overview$")
    public void user_select_KPI_in_dept_overview() throws Throwable {
    	objApplicationFunctionLibrary.validateKPISelectionInDeptOverview(objAutomation, Driver);
    }
    @When("^User select different KPI in dept overview$")
    public void user_select_different_KPI_in_dept_overview() throws Throwable {
    	objApplicationFunctionLibrary.selectKpiInDeptOverview(objAutomation, Driver);
    }
    @When("^User click on calculation Btn$")
    public void user_click_on_calculation_Btn() throws Throwable {
    	objApplicationFunctionLibrary.validateCalculationBtn(objAutomation, Driver);
    }
    @When("^User click on different download option btn$")
    public void user_click_on_different_download_option_btn() throws Throwable {
    	objApplicationFunctionLibrary.validateDownloadOption(objAutomation, Driver);
    }
    @When("^User select market and period$")
    public void user_select_market_and_period() throws Throwable {
    	objApplicationFunctionLibrary.selectMarketAndPeriod(objAutomation, Driver);
    }
    @When("^User select dealer submission manager from menu button$")
    public void user_select_dealer_submission_manager_from_menu_button() throws Throwable {
    	objApplicationFunctionLibrary.selectDealerSubmissionManager(objAutomation, Driver);
    }
    @When("^User create action for dealer$")
    public void user_create_action_for_dealer() throws Throwable {
    	objApplicationFunctionLibrary.actionCreation(objAutomation, Driver);
    }
    @When("^User select Average$")
    public void user_select_Average() throws Throwable {
    	objApplicationFunctionLibrary.averageSelection(objAutomation, Driver);
    }
    @When("^User select chart type$")
    public void user_select_chart_type() throws Throwable {
    	objApplicationFunctionLibrary.GraphTypeSelection(objAutomation, Driver);
    }
    
    @When("^User select average from dropdown$")
    public void user_select_average_from_dropdown() throws Throwable {
    	objApplicationFunctionLibrary.averageSelectionInNscDashboard(objAutomation, Driver);
    }
    @When("^User select Dealer from dropdown$")
    public void user_select_Dealer_from_dropdown() throws Throwable {
    	objApplicationFunctionLibrary.DealerSelectionInNscDashboard(objAutomation, Driver);
    }
    @When("^User select KPIs from dropdown$")
    public void user_select_KPIs_from_dropdown() throws Throwable {
    	objApplicationFunctionLibrary.KPIsSelectionInNscDashboard(objAutomation, Driver);
    }
    @When("^User navigate to DNS submit page$")
    public void user_navigate_to_DNS_submit_page() throws Throwable {
    	objApplicationFunctionLibrary.navigateToDnsSubmitPage(objAutomation, Driver);
    }
    @When("^User select period from period selector$")
    public void user_select_period_from_period_selector() throws Throwable {
    	objApplicationFunctionLibrary.ValidatePeriodVailableInPeriodSelector(objAutomation, Driver);
    }
    @When("^User click on View Close Dates button$")
    public void user_click_on_View_Close_Dates_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidateViewCloseDatesBtn(objAutomation, Driver);
    }
    @When("^User click on input options button$")
    public void user_click_on_input_options_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidateInputOptionsBtn(objAutomation, Driver);
    }
    @When("^User click on Carry forward button$")
    public void user_click_on_Carry_forward_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidateCarrryForwardBtn(objAutomation, Driver);
    }
    @When("^User edit input form for selected period$")
    public void user_edit_input_form_for_selected_period() throws Throwable {
    	objApplicationFunctionLibrary.ValidateEditInputFromBtn(objAutomation, Driver);
    }
    @When("^User select dealer profile from menu button$")
    public void user_select_dealer_profile_from_menu_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDealerProfileBtn(objAutomation, Driver);
    }
    @When("^User edit dealer profile$")
    public void user_edit_dealer_profile() throws Throwable {
    	objApplicationFunctionLibrary.ValidateProfileEditFunctionality(objAutomation, Driver);	
    }
    @When("^User create new charts of accounts$")
    public void user_create_new_charts_of_accounts() throws Throwable {
    	objApplicationFunctionLibrary.ValidateNewChartsOfAccountCreationOperations(objAutomation, Driver);	
    }
    @Given("^User is at DNS submit page$")
    public void user_is_at_DNS_submit_page() throws Throwable {
    	objApplicationFunctionLibrary.ValidateUserAtDnsSubmitPage(objAutomation, Driver);
    }
    @Given("^User is at Dealer profile page$")
    public void user_is_at_Dealer_profile_page() throws Throwable {
    	objApplicationFunctionLibrary.validateUserAtDealerProfilepage(objAutomation, Driver);
    }
    @Given("^User is at Newsflash page$")
    public void user_is_at_Newsflash_page() throws Throwable {
    	objApplicationFunctionLibrary.validateUserAtNewsflashManagerpage(objAutomation, Driver);
    }
    @Given("^User is at Matrix analysis page$")
    public void user_is_at_Matrix_analysis_page() throws Throwable {
    	objApplicationFunctionLibrary.validateUserAtMatrixAnalysispage(objAutomation, Driver);
    }
    @Given("^User is at self assessment tool page$")
    public void user_is_at_self_assessment_tool_page() throws Throwable {
    	objApplicationFunctionLibrary.validateUserAtOverallSummaryPage(objAutomation, Driver);
    }
    @When("^User create new map$")
    public void user_create_new_map() throws Throwable {
    	objApplicationFunctionLibrary.ValidateNewMapsCreationOperations(objAutomation, Driver);	
    }
    @When("^User edit account map$")
    public void user_edit_account_map() throws Throwable {
    	objApplicationFunctionLibrary.ValidateAccountMapEditBtn(objAutomation, Driver);	
    }
    @When("^User download account map$")
    public void user_download_account_map() throws Throwable {
    	objApplicationFunctionLibrary.ValidateAccountMapDownloadBtn(objAutomation, Driver);	
    }
    @When("^User delete account map$")
    public void user_delete_account_map() throws Throwable {
    	objApplicationFunctionLibrary.ValidateAccountMapDeleteBtn(objAutomation, Driver);	
    }
    @When("^User delete Chart of account$")
    public void user_delete_Chart_of_account() throws Throwable {
    	objApplicationFunctionLibrary.ValidateAccountMapDeleteBtn(objAutomation, Driver);	
    }
    @When("^User move to published reports page$")
    public void user_move_to_published_reports_page() throws Throwable {	
    	objApplicationFunctionLibrary.selectMarketFromNetworkHierarchy(objAutomation, Driver);
    	objApplicationFunctionLibrary.ValidatePublishedReportBtn(objAutomation, Driver);
  
    }
    @When("^User click on report dropdown button$")
	public void user_click_on_report_dropdown_button() throws Throwable {
		objApplicationFunctionLibrary.ValidatePublishedReportsTypeDropdown(objAutomation, Driver);
    }
    @When("^User click on period dropdown button$")
    public void user_click_on_period_dropdown_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidatePeriodSelectionDropdown(objAutomation, Driver);
    }
    @When("^User click on pdf and excel button of report$")
    public void user_click_on_pdf_and_excel_button_of_report() throws Throwable {
    	objApplicationFunctionLibrary.ValidatePdfDownloadBtn(objAutomation, Driver);
    }
    @When("^User select few reports$")
    public void user_select_few_reports() throws Throwable {
    	objApplicationFunctionLibrary.ValidatePdfAndExcelReportSelection(objAutomation, Driver);
    }
    @When("^User move to flexible reports page$")
    public void user_move_to_flexible_reports_page() throws Throwable {
    	objApplicationFunctionLibrary.selectMarketFromNetworkHierarchy(objAutomation, Driver);
    	objApplicationFunctionLibrary.ValidateFlexibleReportBtn(objAutomation, Driver);	
    }
    @When("^User click on flexible report dropdown button$")
    public void user_click_on_flexible_report_dropdown_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidateFlexibleReportsTypeDropdown(objAutomation, Driver);
    }
    @When("^User click on  Dealer selection edit btn$")
    public void user_click_on_Dealer_selection_edit_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDealerSelectionEditBtn(objAutomation, Driver);
    }
    @When("^User click on Second Dealer selection edit btn$")
    public void user_click_on_Second_Dealer_selection_edit_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateSecondDealerSelectionEditBtn(objAutomation, Driver);
    }
    @When("^User click on selected Dealer Delete btn$")
    public void user_click_on_selected_Dealer_Delete_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDealerSelectionCancelBtn(objAutomation, Driver);
    }
    @When("^User click on superflex pages$")
    public void user_click_on_superflex_pages() throws Throwable {
    	objApplicationFunctionLibrary.ValidateSuperflexDropdownBtn(objAutomation, Driver);
    }
    @When("^User click on superflex report download btn$")
    public void user_click_on_superflex_report_download_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateSuperflexDownloadBtn(objAutomation, Driver);
    }
    @When("^User move to Dns analysis page$")
    public void user_move_to_Dns_analysis_page() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDnsAnalysisBtn(objAutomation, Driver);
    }
    @When("^User select market from dropdown$")
    public void user_select_market_from_dropdown() throws Throwable {
    	objApplicationFunctionLibrary.ValidateAnalysisMarketDropdown(objAutomation, Driver);
    }
    @When("^User select tools from dropdown$")
    public void user_select_tools_from_dropdown() throws Throwable {
    	objApplicationFunctionLibrary.ValidateAnalysisToolsDropdown(objAutomation, Driver);
    }
    @When("^User select grid for Selection$")
    public void user_select_grid_for_Selection() throws Throwable {
    	objApplicationFunctionLibrary.ValidateAnalysisGridBtn(objAutomation, Driver);
    }
    @When("^User click on item row$")
    public void user_click_on_item_row() throws Throwable {
    	objApplicationFunctionLibrary.ValidateItemRowBtn(objAutomation, Driver);
    }
    @When("^User click on item in report picker$")
    public void user_click_on_item_in_report_picker() throws Throwable {
    	objApplicationFunctionLibrary.ValidateItemSelectionInReportPicker(objAutomation, Driver);
    }
    @When("^User click on period column$")
    public void user_click_on_period_column() throws Throwable {
    	objApplicationFunctionLibrary.ValidatePeriodSelectionForAnalysis(objAutomation, Driver);
    }
    @When("^User click on Network column$")
    public void user_click_on_Network_column() throws Throwable {
    	objApplicationFunctionLibrary.ValidateNetworkSelectionForAnalysis(objAutomation, Driver);
    }
    @When("^User click on Dealer btn$")
    public void user_click_on_Dealer_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDealerSelectionInDataBulk(objAutomation, Driver);
    }
    @When("^User click on Measure column$")
    public void user_click_on_Measure_column() throws Throwable {
    	objApplicationFunctionLibrary.ValidateMeasureSelectionForAnalysis(objAutomation, Driver);
    }
    @When("^User click on excel btn$")
    public void user_click_on_excel_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateGridExcelDownload(objAutomation, Driver);
    }
    @When("^User select custom composite manager$")
    public void user_select_custom_composite_manager() throws Throwable {
    	objApplicationFunctionLibrary.ValidateCustomCompositeTool(objAutomation, Driver);
    }
    @When("^User delete custom composite$")
    public void user_delete_custom_composite() throws Throwable {
    	objApplicationFunctionLibrary.ValidateCustomCompositeDeleteBtn(objAutomation, Driver);
    }
    @When("^User click on tool dropdown btn$")
    public void user_click_on_tool_dropdown_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateAnalysisToolsDropdown(objAutomation, Driver);
    }
    @When("^User click on measure btn$")
    public void user_click_on_measure_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDataBulkMeasure(objAutomation, Driver);
    }
    @When("^User click on Item btn$")
    public void user_click_on_Item_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDataBulkItemBtn(objAutomation, Driver);
    }
    @When("^User click on Period btn$")
    public void user_click_on_Period_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDataBulkPeriodBtn(objAutomation, Driver);
    }
    @When("^User click on Excel file$")
    public void user_click_on_Excel_file() throws Throwable {
    	objApplicationFunctionLibrary.ValidateBulkDataExcelDownload(objAutomation, Driver);
    }
    @When("^User click on BM service option$")
    public void user_click_on_BM_service_option() throws Throwable {
    	objApplicationFunctionLibrary.ValidateBMServiceSelection(objAutomation, Driver);
    }
    @When("^User select submission manager from menu button$")
    public void user_select_submission_manager_from_menu_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidateSubmissionManagerBtnBtn(objAutomation, Driver);
    }
    @When("^User select market from submission manager$")
    public void user_select_market_from_submission_manager() throws Throwable {
    	objApplicationFunctionLibrary.ValidateNSCSubmissionMangerMarketSelection(objAutomation, Driver);
    }
    @When("^User select period from submission manager$")
    public void user_select_period_from_submission_manager() throws Throwable {
    	objApplicationFunctionLibrary.ValidateNSCSubmissionMangerPeriodSelection(objAutomation, Driver);
    }
    @When("^User select dealer for input form download$")
    public void user_select_dealer_for_input_form_download() throws Throwable {
    	objApplicationFunctionLibrary.ValidateNSCSubmissionDealerSelection(objAutomation, Driver);
    }
    @When("^User select Forecast tool$")
    public void user_select_Forecast_tool_from_menu_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDNSForecastBtn(objAutomation, Driver);
    }
    @When("^User create forecast for dealer$")
    public void user_create_forecast_for_dealer() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDNSForecastCreate(objAutomation, Driver);
    }
    @When("^User open forecast for dealer and click on excel btn$")
    public void user_open_forecast_for_dealer_and_click_on_excel_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDNSForecastExcelDownloadBtn(objAutomation, Driver);
    }
    @When("^User open forecast for dealer and click on next year forecast$")
    public void user_open_forecast_for_dealer_and_click_on_next_year_forecast() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDNSForecastCreateNextYearBtn(objAutomation, Driver);
    }
    @When("^User select Dns plan from menu button$")
    public void user_select_Dns_plan_from_menu_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDNSPlanBtn(objAutomation, Driver);
    }
    @When("^User select year for plan$")
    public void user_select_year_for_plan() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDNSPlanYearSelection(objAutomation, Driver);
    }
    @When("^User create new plan$")
    public void user_create_new_plan() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDNSPlanCreation(objAutomation, Driver);
    }
    @When("^User select screen$")
    public void user_select_screen() throws Throwable {
    	objApplicationFunctionLibrary.ValidateScreenSelection(objAutomation, Driver);
    }
    @When("^User click on excel and pdf download option$")
    public void user_click_on_excel_and_pdf_download_option() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDownloadOption(objAutomation, Driver);
    }
    @When("^User click on submit plan$")
    public void user_click_on_submit_plan() throws Throwable {
    	objApplicationFunctionLibrary.ValidatePlanSubmitOption(objAutomation, Driver);
    }
    @When("^User select NewsFlash manager from menu button$")
    public void user_select_NewsFlash_manager_from_menu_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidateNewsflashManagerBtn(objAutomation, Driver);
    }
    @When("^User create new newsflash$")
    public void user_create_new_newsflash() throws Throwable {
    	objApplicationFunctionLibrary.ValidateNewNewsflashCreation(objAutomation, Driver);
    }
    @When("^User click on editing exiting newsflash$")
    public void user_click_on_editing_exiting_newsflash() throws Throwable {
    	objApplicationFunctionLibrary.ValidateNewflashEditOption(objAutomation, Driver);
    }
    @When("^User click on delete exiting newsflash$")
    public void user_click_on_delete_exiting_newsflash() throws Throwable {
    	objApplicationFunctionLibrary.ValidateNewflashDeleteOption(objAutomation, Driver);
    }
    @When("^User click on report page expand btn$")
    public void user_click_on_report_page_expand_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidatePageExpandBtn(objAutomation, Driver);
    }
    @When("^User click on save user setting btn$")
    public void user_click_on_save_user_setting_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateSaveUserSettingBtn(objAutomation, Driver);
    }
    @When("^User perform suppression operations$")
    public void user_perform_suppression_operations() throws Throwable {
    	objApplicationFunctionLibrary.userPerformSuppressionOperation(objAutomation, Driver);
    }
    @When("^User select ops system and market$")
    public void user_select_ops_system_and_market() throws Throwable {
    	objApplicationFunctionLibrary.selectSystemAndMarket(objAutomation, Driver);
    }
    @When("^User select Matrix analysis from menu button$")
    public void user_select_Matrix_analysis_from_menu_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidateMatrixAnalysisBtn(objAutomation, Driver);
    }
    @When("^User perform matrix anslysis operations$")
    public void user_perform_matrix_anslysis_operations() throws Throwable {
    	objApplicationFunctionLibrary.ValidateMatrixAnalysisOperations(objAutomation, Driver);
    }
    @When("^User select self assessment tool from menu button$")
    public void user_select_self_assessment_tool_from_menu_button() throws Throwable {
    	objApplicationFunctionLibrary.ValidateSATBtn(objAutomation, Driver);
    }
    @When("^User select Dealer, period and average$")
    public void user_select_Dealer_period_and_average() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDealer_PeriodAndAverageForSAT(objAutomation, Driver);
    }
    @When("^User click on download btn$")
    public void user_click_on_download_btn() throws Throwable {
    	objApplicationFunctionLibrary.ValidateChartDownloadForSAT(objAutomation, Driver);
    }
    @When("^User click on department view$")
    public void user_click_on_department_view() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDeptView(objAutomation, Driver);
    }
    @When("^User click on detailed view$")
    public void user_click_on_detailed_view() throws Throwable {
    	objApplicationFunctionLibrary.ValidateDeptDeatiledView(objAutomation, Driver);
    }
    @When("^User stored items value$")
    public void user_stored_items_value() throws Throwable {
    	objApplicationFunctionLibrary.validateStoredItemsValue(objAutomation, Driver);
    }
    @When("^User read values from excel$")
    public void user_read_values_from_excel() throws Throwable {
    	objApplicationFunctionLibrary.readExcelSheet(objAutomation, Driver);
    }
	
    @When("^User click on report save option$")
    public void user_click_on_report_save_option() throws Throwable {
    	objApplicationFunctionLibrary.validateFlexibleReportSaveOption(objAutomation, Driver);
    }
    @When("^User click on Report zoom In and Zoom Out Option$")
    public void user_click_on_Report_zoom_In_and_Zoom_Out_Option() throws Throwable {
    	objApplicationFunctionLibrary.validateFlexibleReportZoomOptions(objAutomation, Driver);
    }
    @When("^User select Dealer from network hierarchy selection$")
    public void user_select_Dealer_from_network_hierarchy_selection() throws Throwable {
    	objApplicationFunctionLibrary.dealerSelectionInNetworkHierarchy(objAutomation, Driver);
    }
    @When("^User click on Net operating chart legends$")
    public void user_click_on_Net_operating_chart_legends() throws Throwable {
    	objApplicationFunctionLibrary.netOperatingChartLegends(objAutomation, Driver);
    }
    @When("^User click on Net sales chart legend$")
    public void user_click_on_Net_sales_chart_legend() throws Throwable {
    	objApplicationFunctionLibrary.netSalesChartLegends(objAutomation, Driver);
    }
    @When("^User click on Net operating profit chart download button$")
    public void user_click_on_Net_operating_profit_chart_download_button() throws Throwable {
    	objApplicationFunctionLibrary.netProfitDownloadButton(objAutomation, Driver);
    }
    @When("^User click on Net sales chart download button$")
    public void user_click_on_Net_sales_chart_download_button() throws Throwable {
    	objApplicationFunctionLibrary.netSalesDownloadButton(objAutomation, Driver);
    }
    @When("^User select different department$")
    public void user_select_different_department() throws Throwable {
    	objApplicationFunctionLibrary.dashboardDepartmentSelection(objAutomation, Driver);
    }
    @When("^User select different average$")
    public void user_select_different_average() throws Throwable {
    	objApplicationFunctionLibrary.dashboardAverageSelection(objAutomation, Driver);
    }   
    @When("^User select different period$")
    public void user_select_different_period() throws Throwable {
    	objApplicationFunctionLibrary.dashboardPeriodSelection(objAutomation, Driver);
    }
    
    @When("^The user click on DNSLibrary dropdown$")
    public void the_user_click_on_DNSLibrary_dropdown() throws Throwable {
    	objApplicationFunctionLibrary.clickonDNSlibrary(objAutomation, Driver);
    }
    @When("^The user click on upload document$")
    public void the_user_click_on_upload_document() throws Throwable {
    	objApplicationFunctionLibrary.clickonuploaddocument(objAutomation, Driver);
    }
     
    @When("^The user click on document to view$")
    public void the_user_click_on_document_to_view() throws Throwable {
    	objApplicationFunctionLibrary.clickonview(objAutomation, Driver);
    } 
    @When("^The user click on document to delete$")
    public void the_user_click_on_document_to_delete() throws Throwable {
    	objApplicationFunctionLibrary.clickondelete(objAutomation, Driver);
    }
    @When("^User select global from network hierarchy for DNS Plan$")
    public void user_select_global_from_network_hierarchy_for_DNS_Plan() throws Throwable {
    	objApplicationFunctionLibrary.globalSelectionForPlan(objAutomation, Driver);
    }
    @When("^User select global from network hierarchy for Forecast$")
    public void user_select_global_from_network_hierarchy_for_Forecast() throws Throwable {
    	objApplicationFunctionLibrary.globalSelectionForForecast(objAutomation, Driver);
    }

    @When("^User select market from network hierarchy for DNS Plan$")
    public void user_select_market_from_network_hierarchy_for_DNS_Plan() throws Throwable {
    	objApplicationFunctionLibrary.marketSelectionForPlan(objAutomation, Driver);
    }
    
    @When("^User select market from network hierarchy for Forecast$")
    public void user_select_market_from_network_hierarchy_for_Forecast() throws Throwable {
    	objApplicationFunctionLibrary.marketSelectionForForecast(objAutomation, Driver);
    }

    @When("^User select dealer from network hierarchy for DNS Plan$")
    public void user_select_dealer_from_network_hierarchy_for_DNS_Plan() throws Throwable {
    	objApplicationFunctionLibrary.dealerSelectionForPlan(objAutomation, Driver);
    }
    @When("^User select dealer from network hierarchy for Forecast$")
    public void user_select_dealer_from_network_hierarchy_for_Forecast() throws Throwable {
    	objApplicationFunctionLibrary.dealerSelectionForPlan(objAutomation, Driver);
    }
    @When("^User select User Management from admin dropdown$")
    public void user_select_User_Management_from_admin_dropdown() throws Throwable {
    	objApplicationFunctionLibrary.userManagementButton(objAutomation, Driver);
    }
    @When("^User search existing user$")
    public void user_search_existing_user() throws Throwable {
    	objApplicationFunctionLibrary.userManagementSearchButton(objAutomation, Driver);
    }
    @When("^User click on create user button$")
    public void user_click_on_create_user_button() throws Throwable {
    	objApplicationFunctionLibrary.userManagementCreateButton(objAutomation, Driver);
    }
    @When("^User click on Clone button$")
    public void user_click_on_Clone_button() throws Throwable {
    	objApplicationFunctionLibrary.userManagementCloneButton(objAutomation, Driver);
    }
	@Then("^Selected Dealer should be appearing on dashboard$")
	public void selected_Dealer_should_be_appearing_on_dashboard() throws Throwable {
		objApplicationFunctionLibrary.validateUserAtDealerDashboard(objAutomation, Driver);
	}
	@Then("^Selected period should be visible on dashboard$")
	public void selected_period_should_be_visible_on_dashboard() throws Throwable {
		objApplicationFunctionLibrary.validateSelectedPeriodOnDashboard(objAutomation, Driver);
	}
	@Then("^Selected measure should be visible on dashboard$")
	public void selected_measure_should_be_visible_on_dashboard() throws Throwable {
		objApplicationFunctionLibrary.validateSelectedMeasureOnDashboard(objAutomation, Driver);
	}
	@Then("^Selected KPI should be visible on dashboard$")
	public void selected_KPI_should_be_visible_on_dashboard() throws Throwable {
		objApplicationFunctionLibrary.validateKPIOnSlider(objAutomation, Driver);
	}
	@Then("^KPI should be visible in Grid View$")
	public void kpi_should_be_visible_in_Grid_View() throws Throwable {
		objApplicationFunctionLibrary.validateKPIInGridView(objAutomation, Driver);
	}
	@Then("^Selected KPI should be visible in dept view$")
	public void selected_KPI_should_be_visible_in_dept_view() throws Throwable {
		objApplicationFunctionLibrary.validateKPIInDeptOverView(objAutomation, Driver);
	}
	@Then("^Selected KPI should be represented in Bar Graph$")
	public void selected_KPI_should_be_represented_in_Bar_Graph(String DefaultDeptKPIName, String AlternateDefaultDeptKPIName,String SecondDeptKPIName, String SecondAlternateDeptKPIName) throws Throwable {
		objApplicationFunctionLibrary.validateKPIGraph(objAutomation, Driver,DefaultDeptKPIName,AlternateDefaultDeptKPIName,SecondDeptKPIName,SecondAlternateDeptKPIName );
	}
	@Then("^KPI calculation should be visible$")
	public void kpi_calculation_should_be_visible() throws Throwable {
		objApplicationFunctionLibrary.validateCalculationOpens(objAutomation, Driver);
	}
	@Then("^Download option should work fine$")
	public void download_option_should_work_fine() throws Throwable {
		//objApplicationFunctionLibrary.validateReportPdfDownloadOption(objAutomation, Driver);
	}
	@Then("^Nsc dashboard should be appearing with selected Market and period$")
	public void nsc_dashboard_should_be_appearing_with_selected_Market_and_period() throws Throwable {
		objApplicationFunctionLibrary.validateNscDashboard(objAutomation, Driver);
	}
	@Then("^Dealer input form should be visible and downloaded$")
	public void dealer_input_form_should_be_visible_and_downloaded() throws Throwable {
		objApplicationFunctionLibrary.validateDealerInputDownload(objAutomation, Driver);
	}
	@Then("^Action should be able to edit$")
	public void action_should_be_able_to_edit() throws Throwable {
		objApplicationFunctionLibrary.actionEdit(objAutomation, Driver);
	}
	@Then("^selected average available on dashboard$")
	public void selected_average_available_on_dashboard() throws Throwable {
		objApplicationFunctionLibrary.validateAvailableOnDashboard(objAutomation, Driver);
	}
	@Then("^chart type selection should available$")
	public void chart_type_selection_should_available() throws Throwable {
		objApplicationFunctionLibrary.validateChartSelectionAvailable(objAutomation, Driver);
	}
	@Then("^selected  average shoule be visible in KPI table$")
	public void selected_average_shoule_be_visible_in_KPI_table() throws Throwable {
		objApplicationFunctionLibrary.SingleAverageSelectionInKPITable(objAutomation, Driver);
	}
	@Then("^selected  Dealer shoule be visible in KPI table$")
	public void selected_Dealer_shoule_be_visible_in_KPI_table() throws Throwable {
		objApplicationFunctionLibrary.SingleDealerSelectionInKPITable(objAutomation, Driver);
	}
	@Then("^selected  KPIs shoule be visible in KPI table$")
	public void selected_KPIs_shoule_be_visible_in_KPI_table() throws Throwable {
		objApplicationFunctionLibrary.SingleKPISelectionInKPITable(objAutomation, Driver);
	}
	@Then("^DNS submit page open successfully$")
	public void dns_submit_page_open_successfully() throws Throwable {
		objApplicationFunctionLibrary.validateDnsSubmitPage(objAutomation, Driver);
	}
	@Then("^User should be able select period$")
	public void user_should_be_able_select_period() throws Throwable {
		objApplicationFunctionLibrary.validateSelectedPeriod(objAutomation, Driver);
	}
	@Then("^User should be able see and close it$")
	public void user_should_be_able_see_and_close_it() throws Throwable {
		objApplicationFunctionLibrary.ValidateCloseViewDates(objAutomation, Driver);
	}
	@Then("^User should be able perform all input options functionality$")
	public void user_should_be_able_perform_all_input_options_functionality() throws Throwable {
		objApplicationFunctionLibrary.ValidateInputOptionsFunctionality(objAutomation, Driver);
	}
	@Then("^User should be able perform Carry forward scenarios$")
	public void user_should_be_able_perform_Carry_forward_scenarios() throws Throwable {
		objApplicationFunctionLibrary.ValidateCarryForwardScenarios(objAutomation, Driver);
	}
	@Then("^User should be able perform input form operations$")
	public void user_should_be_able_perform_input_form_operations() throws Throwable {
		objApplicationFunctionLibrary.ValidateInputFormOperations(objAutomation, Driver);
	}
	@Then("^User profile shoule be open successfully$")
	public void user_profile_shoule_be_open_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateDealerProfile(objAutomation, Driver);
	}
	@Then("^User profile shoule be save successfully$")
	public void user_profile_shoule_be_save_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateSaveProfileEditFunctionality(objAutomation, Driver);
	}
	@Then("^account maps page should open successfully$")
	public void account_maps_page_should_open_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateAccountMapsOpenSUccessfully(objAutomation, Driver);
}
	@Then("^charts of accounts created successfully$")
	public void charts_of_accounts_created_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateNewChartsOfAccountCreatedSuccessfully(objAutomation, Driver);
	}
	@Then("^new map created successfully$")
	public void new_map_created_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateNewMapsCreatedSuccessfully(objAutomation, Driver);
	}
	@Then("^account map shoud be edit and close successfully$")
	public void account_map_shoud_be_edit_and_close_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateAccountMapEditCloseBtn(objAutomation, Driver);
}
	@Then("^account map should be downloaded$")
	public void account_map_should_be_downloaded() throws Throwable {
		objApplicationFunctionLibrary.ValidateAccountMapShouldDownloadSuccessfully(objAutomation, Driver);
	}
	@Then("^account map should be deleted$")
	public void account_map_should_be_deleted() throws Throwable {
		objApplicationFunctionLibrary.ValidateAccountMapShouldDeletedSuccessfully(objAutomation, Driver);
	}
	@Then("^Chart of account should be deleted$")
	public void chart_of_account_should_be_deleted() throws Throwable {
		objApplicationFunctionLibrary.ValidateAccountMapShouldDeletedSuccessfully(objAutomation, Driver);
	}
	@Then("^published reports page should open successfully$")
	public void published_reports_page_should_open_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidatePublishedReportPageOpenSuccessfully(objAutomation, Driver);
	}
	@Then("^user should be able to select any report type$")
	public void user_should_be_able_to_select_any_report_type() throws Throwable {
		objApplicationFunctionLibrary.ValidateReportsSelection(objAutomation, Driver);
	}
	@Then("^user should be able to select any period$")
	public void user_should_be_able_to_select_any_period() throws Throwable {
		objApplicationFunctionLibrary.ValidatePeriodSelection(objAutomation, Driver);
	}
	@Then("^pdf and exl version of report should be downloaded$")
	public void pdf_and_exl_version_of_report_should_be_downloaded() throws Throwable {
		objApplicationFunctionLibrary.ValidateExcelDownloadBtn(objAutomation, Driver);
	}
	@Then("^Selected reports zip file should be downloaded$")
	public void selected_reports_zip_file_should_be_downloaded() throws Throwable {
		objApplicationFunctionLibrary.ValidateZipDownloadBtn(objAutomation, Driver);
	}
	@Then("^Flexible reports page should open successfully$")
	public void flexible_reports_page_should_open_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateFlexibleReportPageOpenSuccessfully(objAutomation, Driver);
	}
	@Then("^user should be able to select flexible report type$")
	public void user_should_be_able_to_select_flexible_report_type() throws Throwable {
		objApplicationFunctionLibrary.ValidateFlexibleReportsSelection(objAutomation, Driver);
	}
	@Then("^user should be able to select dealer$")
	public void user_should_be_able_to_select_dealer() throws Throwable {
		objApplicationFunctionLibrary.ValidateSuperflexDealerSelectionOperations(objAutomation, Driver);
	}
	@Then("^user should be able to select Second dealer$")
	public void user_should_be_able_to_select_Second_dealer() throws Throwable {
		objApplicationFunctionLibrary.ValidateSecondSuperflexDealerSelectionOperations(objAutomation, Driver);
	}
	@Then("^user should be able to remove dealer$")
	public void user_should_be_able_to_remove_dealer() throws Throwable {
		objApplicationFunctionLibrary.ValidateBlankDealerColumn(objAutomation, Driver);
	}
	@Then("^user should be able to select pages$")
	public void user_should_be_able_to_select_pages() throws Throwable {
		objApplicationFunctionLibrary.ValidateSuperflexDeptSelection(objAutomation, Driver);
	}
	@Then("^Report should be downloaded successfully$")
	public void report_should_be_downloaded_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateSuperflexReportDownloaded(objAutomation, Driver);
	}
	@Then("^Dns Analysis should open successfully$")
	public void dns_Analysis_should_open_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateDnsAnalysisPagLabel(objAutomation, Driver);
	}
	@Then("^Market should be selected successfully$")
	public void market_should_be_selected_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateMarketSelectSuccessfully(objAutomation, Driver);
	}
	@Then("^Tools should be selected successfully$")
	public void tools_should_be_selected_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateToolsSelectSuccessfully(objAutomation, Driver);
	}
	@Then("^Grid should be selected successfully$")
	public void grid_should_be_selected_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateGridSelectSuccessfully(objAutomation, Driver);
	}
	@Then("^Item should be added into grid$")
	public void item_should_be_added_into_grid() throws Throwable {
		objApplicationFunctionLibrary.ValidateItemAdditionIntoGrid(objAutomation, Driver);
	}
	@Then("^Item should be added into grid from report picker$")
	public void item_should_be_added_into_grid_from_report_picker() throws Throwable {
		objApplicationFunctionLibrary.ValidateItemSelectionFromPickerIntoGrid(objAutomation, Driver);
	}
	@Then("^user should be able to select Analysis period$")
	public void user_should_be_able_to_select_Analysis_period() throws Throwable {
		objApplicationFunctionLibrary.ValidatePeriodSelectionType(objAutomation, Driver);
	}
	@Then("^user should be able to select network$")
	public void user_should_be_able_to_select_network() throws Throwable {
		objApplicationFunctionLibrary.ValidateNetworkSelectionType(objAutomation, Driver);
	}
	@Then("^user should be able to select Measure$")
	public void user_should_be_able_to_select_Measure() throws Throwable {
		objApplicationFunctionLibrary.ValidateMeasureSelectionType(objAutomation, Driver);
	}
	@Then("^Excel should be downloaded successfully$")
	public void excel_should_be_downloaded_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateExcelFileDwnloadedSuccessfully(objAutomation, Driver);
	}
	@Then("^User should be able to create custom composite$")
	public void user_should_be_able_to_create_custom_composite() throws Throwable {
		objApplicationFunctionLibrary.ValidateCustomCompositeOperations(objAutomation, Driver);
	}
	@Then("^User should be able to delete custom composite$")
	public void user_should_be_able_to_delete_custom_composite() throws Throwable {
		objApplicationFunctionLibrary.ValidateCustomCompositeDeletedSuccessfully(objAutomation, Driver);
	}
	@Then("^User should be able to select Bulk data dump tool$")
	public void user_should_be_able_to_select_Bulk_data_dump_tool() throws Throwable {
		objApplicationFunctionLibrary.ValidateDataBulkDumpTool(objAutomation, Driver);
	}
	@Then("^User should be able to select measure$")
	public void user_should_be_able_to_select_measure() throws Throwable {
		objApplicationFunctionLibrary.ValidateMeasureSelectionType(objAutomation, Driver);
	}
	@Then("^User should be able to select Dealer for Bulk data$")
	public void user_should_be_able_to_select_Dealer_for_bulk_data() throws Throwable {
		objApplicationFunctionLibrary.ValidateDealerSelectionOperations(objAutomation, Driver);
	}
	@Then("^User should be able to select Item$")
	public void user_should_be_able_to_select_Item() throws Throwable {
		objApplicationFunctionLibrary.ValidateItemSelectionOperations(objAutomation, Driver);
	}
	@Then("^User should be able to select Period$")
	public void user_should_be_able_to_select_Period() throws Throwable {
		objApplicationFunctionLibrary.ValidatePeriodSelectionOperations(objAutomation, Driver);
	}
	@Then("^User should be able to download file$")
	public void user_should_be_able_to_download_file() throws Throwable {
		objApplicationFunctionLibrary.ValidateExcelFileDwnloadedSuccessfully(objAutomation, Driver);
	}
	@Then("^User should be able to see dashboard$")
	public void user_should_be_able_to_see_dashboard() throws Throwable {
		objApplicationFunctionLibrary.validateUserLoginIntoLandingPage(objAutomation, Driver);
	}
	@Then("^Submission Manager page should be open succesfully$")
	public void Submission_Manager_page_should_be_open_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateSubmisionManagerPage(objAutomation, Driver);
	}
	@Then("^Selected market should appear$")
	public void selected_market_should_appear() throws Throwable {
		objApplicationFunctionLibrary.ValidateMarketSelectedSuccessfully(objAutomation, Driver);
	}
	@Then("^Selected period should appear$")
	public void selected_period_should_appear() throws Throwable {
		objApplicationFunctionLibrary.ValidatePeriodSelectedSuccessfully(objAutomation, Driver);
	}
	@Then("^Selected dealer input form should downloaded$")
	public void selected_dealer_input_form_should_downloaded() throws Throwable {
		objApplicationFunctionLibrary.ValidateInputFormDownloadedSuccessfully(objAutomation, Driver);
	}
	@Then("^Forecast page should be open succesfully$")
	public void forecast_page_should_be_open_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateDNSForecastPage(objAutomation, Driver);
	}
	@Then("^Forecast should created successfully$")
	public void forecast_should_created_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateDNSForecastCreatedSuccessfully(objAutomation, Driver);
	}
	@Then("^Excel report should downloaded successfully$")
	public void excel_report_should_downloaded_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateDNSForecastDownloadedSuccessfully(objAutomation, Driver);
	}
	@Then("^Next year forecast should created successfully$")
	public void next_year_forecast_should_created_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateDNSForecastNextYearCreatedSuccessfully(objAutomation, Driver);
	}
	@Then("^Dns Plan page should be open succesfully$")
	public void dns_Plan_page_should_be_open_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateDNSPlanPageOpenSuccessfully(objAutomation, Driver);
	}
	@Then("^Selected year plan should be available$")
	public void selected_year_plan_should_be_available() throws Throwable {
		objApplicationFunctionLibrary.ValidateDNSPlanYearSelectSuccessfully(objAutomation, Driver);
	}
	@Then("^New Plan should be created succesfully$")
	public void new_Plan_should_be_created_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateDNSPlanYCreatedSuccessfully(objAutomation, Driver);
	}
	@Then("^Screen should be selected succesfully$")
	public void screen_should_be_selected_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateScreenSelectedSuccessfully(objAutomation, Driver);
	}
	@Then("^Plan should be downloaded succesfully$")
	public void plan_should_be_downloaded_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidatePlanDownloadSuccessfully(objAutomation, Driver);
	}
	@Then("^Plan should be submit succesfully$")
	public void plan_should_be_submit_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidatePlanSubmitSuccessfully(objAutomation, Driver);
	}
	@Then("^NewsFlash Manager page should be open succesfully$")
	public void newsflash_Manager_page_should_be_open_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateNewflashPageOpenSuccessfully(objAutomation, Driver);
	}
	@Then("^NewsFlash should be created succesfully$")
	public void newsflash_should_be_created_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateNewflashCreatedSuccessfully(objAutomation, Driver);
	}
	@Then("^NewsFlash should be edited succesfully$")
	public void newsflash_should_be_edited_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateNewflashEditedSuccessfully(objAutomation, Driver);
	}
	@Then("^NewsFlash should be deleted succesfully$")
	public void newsflash_should_be_deleted_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateNewflashDeletedSuccessfully(objAutomation, Driver);
	}
	@Then("^Report page color and logo should remain same$")
	public void report_page_color_and_logo_should_remain_same() throws Throwable {
		objApplicationFunctionLibrary.ValidateReportPageColorAndLogo(objAutomation, Driver);
	}
	@Then("^User should be able to add, reload and delete user settings$")
	public void user_should_be_able_to_add_reload_and_delete_user_settings() throws Throwable {
		objApplicationFunctionLibrary.ValidateUserSavedSettingOperations(objAutomation, Driver);
	}
	@Then("^User should be able to perform dealers suppression$")
	public void user_should_be_able_to_perform_dealers_suppression() throws Throwable {
		objApplicationFunctionLibrary.ValidateSuppressionOperations(objAutomation, Driver);
	}
	@Then("^User should be able to select system and market$")
	public void user_should_be_able_to_select_system_and_market() throws Throwable {
		objApplicationFunctionLibrary.ValidateSystemAndMarketSelection(objAutomation, Driver);
	}
	@Then("^Matrix analysis page should be open$")
	public void matrix_analysis_page_should_be_open() throws Throwable {
		objApplicationFunctionLibrary.ValidateMatrixAnalysisPageOpenSuccessfully(objAutomation, Driver);
	}
	@Then("^User should should be able to perform succesfully$")
	public void user_should_should_be_able_to_perform_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateMatrixAnalysisOperationsPerformSuccessfully(objAutomation, Driver);
	}
	@Then("^Self assessment tool page should be open succesfully$")
	public void self_assessment_tool_page_should_be_open_succesfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateSATOpensSuccessfully(objAutomation, Driver);
	}
	@Then("^selection should be visible to dealer$")
	public void selection_should_be_visible_to_dealer() throws Throwable {
		objApplicationFunctionLibrary.ValidateDealer_PeriodAndAverageForSATselectedSuccessfully(objAutomation, Driver);
	}
	@Then("^Chart should be downloaded successfully$")
	public void chart_should_be_downloaded_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateSATchartDownloadedSuccessfully(objAutomation, Driver);
	}
	@Then("^User should be able to view and perform department view operations$")
	public void user_should_be_able_to_view_and_perform_department_view_operations() throws Throwable {
		objApplicationFunctionLibrary.ValidateDeptViewOperations(objAutomation, Driver);
	}
	@Then("^User should be able to view and perform detailed view operations$")
	public void user_should_be_able_to_view_and_perform_detailed_view_operations() throws Throwable {
		objApplicationFunctionLibrary.ValidateDeptDetailedViewOperations(objAutomation, Driver);
	}
	@Then("^items value should matched with stored value$")
	public void items_value_should_matched_with_stored_value() throws Throwable {
		objApplicationFunctionLibrary.ValidateStoredItemsValue(objAutomation, Driver);
	}
	@Then("^items value should matched with excelsheet$")
	public void items_value_should_matched_with_excelsheet() throws Throwable {
		objApplicationFunctionLibrary.ValidateStoredItemsValueWithExelValues(objAutomation, Driver);
	}
	
	@When("^User click on assign button$")
	public void user_click_on_assign_button() throws Throwable {
		objApplicationFunctionLibrary.AccountMapAssignFunctionality(objAutomation, Driver);
	}
	

   @Then("^account map assign details should open$")
   public void account_map_assign_details_should_open() throws Throwable {
	objApplicationFunctionLibrary.ValidateAccountMapAssignFunctionality(objAutomation, Driver);
    }
	

  @Then("^User profile shoule be open succesfully$")
   public void user_profile_shoule_be_open_succesfully() throws Throwable {
	objApplicationFunctionLibrary.ValidateDnsProfilePageopenSuccessfully(objAutomation, Driver);
    }
	
  @Then("^Report should be saved successfully$")
  public void report_should_be_saved_successfully() throws Throwable {
		objApplicationFunctionLibrary.ValidateFlexibleReportSavedSuccessfully(objAutomation, Driver);
  }

  @Then("^Report size should be changing accordingly$")
  public void report_size_should_be_changing_accordingly() throws Throwable {
		objApplicationFunctionLibrary.ValidateReportPageSizeChangesAccordingly(objAutomation, Driver);
  }
	
  @Then("^Net profit and Net sales charts should appear$")
  public void net_profit_and_Net_sales_charts_should_appear() throws Throwable {
	  objApplicationFunctionLibrary.ValidateNetOperatingChartVisibility(objAutomation, Driver);
  }
  @Then("^Net Operating pie chart appear as per selection$")
  public void net_Operating_pie_chart_appear_as_per_selection() throws Throwable {
	  objApplicationFunctionLibrary.ValidateNetOperatingLegendsSelection(objAutomation, Driver);
  }
  @Then("^Net sales chart should appear as per selection$")
  public void net_sales_chart_should_appear_as_per_selection() throws Throwable {
	  objApplicationFunctionLibrary.ValidateNetSalesLegendsSelection(objAutomation, Driver);
  }
  @Then("^Net operating profit chart should downloaded$")
  public void net_operating_profit_chart_should_downloaded() throws Throwable {
	  objApplicationFunctionLibrary.ValidateNetOperatingChartDownloadOption(objAutomation, Driver);
  }
  @Then("^Net sales chart should downloaded$")
  public void net_sales_chart_should_downloaded() throws Throwable {
	  objApplicationFunctionLibrary.ValidateNetSalesChartDownloadOption(objAutomation, Driver);
  }
  @Then("^User should be able to see DNSLibrary$")
  public void user_should_be_able_to_see_DNSLibrary() throws Throwable {
		objApplicationFunctionLibrary.validateDNSlibrary(objAutomation, Driver);
  }
	
  @Then("^User should be able to upload document successfully$")
  public void user_should_be_able_to_upload_document_successfully() throws Throwable {
    objApplicationFunctionLibrary.validatedocument(objAutomation, Driver);
  	}	
  @Then("^Document should be open$")
  public void document_should_be_open() throws Throwable {
	  objApplicationFunctionLibrary.validateview(objAutomation, Driver);
  }
  @Then("^Document should be deleted$")
  public void document_should_be_deleted() throws Throwable {
	  objApplicationFunctionLibrary.validatedelete(objAutomation, Driver);
  }
  @Then("^User Management page should be open succesfully$")
  public void user_Management_page_should_be_open_succesfully() throws Throwable {
	  objApplicationFunctionLibrary.validateUserManagementPage(objAutomation, Driver);
  }
  @Then("^User should be able to edit searched user$")
  public void user_should_be_able_to_edit_searched_user() throws Throwable {
	  objApplicationFunctionLibrary.validateUserManagementSearchOperations(objAutomation, Driver);
  }
  @Then("^User should be able to create user$")
  public void user_should_be_able_to_create_user() throws Throwable {
	  objApplicationFunctionLibrary.validateUserManagementCreateOperations(objAutomation, Driver);
  }
  @Then("^User should be able to clone user$")
  public void user_should_be_able_to_clone_user() throws Throwable {
	  objApplicationFunctionLibrary.validateUserManagementCloneOperations(objAutomation, Driver);
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//**//                                   Anushka's Code Start                             //**//
	
	

@Given("^The user navigates to the Dashboard page$")
public void the_user_navigates_to_the_Dashboard_page() throws Throwable {
	objApplicationFunctionLibrary.NavigateToDashboard(objAutomation, Driver);
}


@When("^the user selects Global from the Network dropdown$")
public void the_user_selects_Global_from_the_Network_dropdown() throws Throwable {
	objApplicationFunctionLibrary.networkSelection(objAutomation, Driver);
}

@Then("^User should be able to see selected Network$")
public void user_should_be_able_to_see_selected_Network() throws Throwable {
	objApplicationFunctionLibrary.validateNetworkSelection(objAutomation, Driver);
}

@When("^the user selects Case IH from the Brand dropdown$")
public void the_user_selects_Case_IH_from_the_Brand_dropdown() throws Throwable {
	objApplicationFunctionLibrary.BrandSelection(objAutomation, Driver);
	}

@Then("^User should be able to see selected Brand$")
public void user_should_be_able_to_see_selected_Brand() throws Throwable {
	objApplicationFunctionLibrary.validateBrandSelection(objAutomation, Driver);
	}

@When("^the user selects European Average from the Average dropdown$")
public void the_user_selects_European_Average_from_the_Average_dropdown() throws Throwable {
	objApplicationFunctionLibrary.AverageSelection(objAutomation, Driver);
}

@Then("^User should be able to see selected Average$")
public void user_should_be_able_to_see_selected_Average() throws Throwable {
	objApplicationFunctionLibrary.validateAverageSelection(objAutomation, Driver);
}

@When("^The user should be able to see Network Dispersion Label on Graph$")
public void the_user_should_be_able_to_see_Network_Dispersion_Label_on_Graph() throws Throwable {
	objApplicationFunctionLibrary.LabelNetworkDispersion(objAutomation, Driver);
	}

@When("^The user should be able to download Network Dispersion Graph$")
public void the_user_should_be_able_to_download_Network_Dispersion_Graph() throws Throwable {
	objApplicationFunctionLibrary.DownloadNetworkDispersionGraph(objAutomation, Driver);
	}

@Then("^Graph should be download$")
public void graph_should_be_download() throws Throwable {
	objApplicationFunctionLibrary.validateGraphDownloaded(objAutomation, Driver);
	}
@When("^the user selects department from the department dropdown$")
public void the_user_selects_department_from_the_department_dropdown() throws Throwable {
	objApplicationFunctionLibrary.DepartmentDropdown(objAutomation, Driver);
}

@Then("^User should be able to see selected Average Department$")
public void user_should_be_able_to_see_selected_Average_Department() throws Throwable {
	objApplicationFunctionLibrary.ValidateDepartmentName(objAutomation, Driver);
}
@When("^the user selects Period from the Peiod dropdown$")
public void the_user_selects_Period_from_the_Peiod_dropdown() throws Throwable {
	objApplicationFunctionLibrary.PeriodDropdown(objAutomation, Driver);
}

@Then("^User should be able to see selected Period$")
public void user_should_be_able_to_see_selected_Period() throws Throwable {
	objApplicationFunctionLibrary.ValidatePeriod(objAutomation, Driver);
}


//KPIGraph

@When("^The user should be able to go to settings for KPI Selection on KPI Performance Graph$")
public void the_user_should_be_able_to_go_to_settings_for_KPI_Selection_on_KPI_Performance_Graph() throws Throwable {
	objApplicationFunctionLibrary.KPISelectionInSettings(objAutomation, Driver);
	}

@Then("^Selected KPI should be saved$")
public void selected_KPI_should_be_saved() throws Throwable {
	objApplicationFunctionLibrary.ValidateSelectedKPI(objAutomation, Driver);
	}

@When("^The user should be able to Download KPI Performance Graph$")
public void the_user_should_be_able_to_Download_KPI_Performance_Graph() throws Throwable {
	objApplicationFunctionLibrary.DownloadKPIGraph(objAutomation, Driver);
}

@Then("^Graph Should go to Downloads$")
public void graph_Should_go_to_Downloads() throws Throwable {
	objApplicationFunctionLibrary.ValidateDownload(objAutomation, Driver);
}

@When("^The user should be able to Deselect All KPI on Performance Graph$")
public void the_user_should_be_able_to_Deselect_All_KPI_on_Performance_Graph() throws Throwable {
	objApplicationFunctionLibrary.DeselectAllKPI(objAutomation, Driver);
	}

@Then("^Graph Should be saved$")
public void graph_Should_be_saved() throws Throwable {
	objApplicationFunctionLibrary.ValidateDelsection(objAutomation, Driver);
	}

@When("^The user should be able to select All KPI on Performance Graph$")
public void the_user_should_be_able_to_select_All_KPI_on_Performance_Graph() throws Throwable {
	objApplicationFunctionLibrary.AllselectionKPI(objAutomation, Driver);
}

@Then("^All selected KPI Should be saved$")
public void all_selected_KPI_Should_be_saved() throws Throwable {
	objApplicationFunctionLibrary.ValidateAllSelection(objAutomation, Driver);
}

@When("^The user should be able to Default KPI on Performance Graph$")
public void the_user_should_be_able_to_Default_KPI_on_Performance_Graph() throws Throwable {
	objApplicationFunctionLibrary.SelectDefaultKPI(objAutomation, Driver);
}

@When("^The user should be able to Default KPI on Performance Graph of New Holland$")
public void the_user_should_be_able_to_Default_KPI_on_Performance_Graph_of_New_Holland() throws Throwable {
	objApplicationFunctionLibrary.SelectNewHollandDefaultKPI(objAutomation, Driver);
}


//PL Graph

@When("^The user should be able to go to settings for KPI selection on PL Graph$")
public void the_user_should_be_able_to_go_to_settings_for_KPI_selection_on_PL_Graph() throws Throwable {
	objApplicationFunctionLibrary.SelectPLKPI(objAutomation, Driver);
	}

@Then("^Selected KPI Should be saved$")
public void selected_KPI_Should_be_saved() throws Throwable {
	objApplicationFunctionLibrary.ValidateSelectedKPI(objAutomation, Driver);
	}

@When("^The user should be able to Download PL Dispersion Graph$")
public void the_user_should_be_able_to_Download_PL_Dispersion_Graph() throws Throwable {
	objApplicationFunctionLibrary.DownloadPLGraph(objAutomation, Driver);
}

@When("^The user should be able to go to settings on PL Graph to Select All KPI on PL Graph$")
public void the_user_should_be_able_to_go_to_settings_on_P_L_Graph_to_Select_All_KPI_on_PL_Graph() throws Throwable {
	objApplicationFunctionLibrary.SelectAllKPI(objAutomation, Driver);
	}

@Then("^All KPI Should be saved$")
public void all_KPI_Should_be_saved() throws Throwable {
	objApplicationFunctionLibrary.ValidateAllKPI(objAutomation, Driver);
	}

@When("^The user should be able to go to settings on PL Graph to Select Default KPI on PL Graph$")
public void the_user_should_be_able_to_go_to_settings_on_P_L_Graph_to_Select_Default_KPI_on_PL_Graph() throws Throwable {
	objApplicationFunctionLibrary.selectDefaultKPI(objAutomation, Driver);
	}

@Then("^All Default KPI Should be saved$")
public void all_Default_KPI_Should_be_saved() throws Throwable {
	objApplicationFunctionLibrary.ValidateDefaultKPI(objAutomation, Driver);
	}

@When("^The user should be able to cick Max on PL Graph$")
public void the_user_should_be_able_to_cick_Max_on_PL_Graph() throws Throwable {
	objApplicationFunctionLibrary.ClickOnMaxBtn(objAutomation, Driver);
}

@Then("^Dispersion Max should openn and download$")
public void dispersion_Max_should_openn_and_download() throws Throwable {
	objApplicationFunctionLibrary.ValidateMaxPage(objAutomation, Driver);
}

@When("^The user should be able to select KPI Max on PL Graph$")
public void the_user_should_be_able_to_select_KPI_Max_on_PL_Graph() throws Throwable {
	objApplicationFunctionLibrary.SelectMaxKPI(objAutomation, Driver);
	}

@Then("^Slected Max KPI should be saved$")
public void slected_Max_KPI_should_be_saved() throws Throwable {
	objApplicationFunctionLibrary.ValidateMaxKPI(objAutomation, Driver);
	}

@When("^The user should be able to select All KPI Max on PL Graph$")
public void the_user_should_be_able_to_select_All_KPI_Max_on_PL_Graph() throws Throwable {
	objApplicationFunctionLibrary.SelectMaxAllKPI(objAutomation, Driver);
}

@When("^The user should be able to Deafult KPI Max on PL Graph$")
public void the_user_should_be_able_to_Deafult_KPI_Max_on_PL_Graph() throws Throwable {
	objApplicationFunctionLibrary.SelectDefaultMaxKPI(objAutomation, Driver);
	}
@Then("^Selected Default KPI should be saved$")
public void selected_Default_KPI_should_be_saved() throws Throwable {
	objApplicationFunctionLibrary.ValidateDefaultMaxKPI(objAutomation, Driver);
	}

       //**//                           Anushka's Code End                           //**//


// **                                Geo generator                                   //**//


@Given("^User is at Dashboard page as NSC$")
public void user_is_at_Dashboard_page_as_NSC() throws Throwable {
	objApplicationFunctionLibrary.dashboardPage(objAutomation, Driver);
	}


@When("^User selects Administration and goes to Geo Generator$")
public void user_selects_Administration_and_goes_to_Geo_Generator() throws Throwable {
	objApplicationFunctionLibrary.OpenGeoGenerator(objAutomation, Driver);
	}


@Then("^Geo Generator should appear$")
public void geo_Generator_should_appear() throws Throwable {
	objApplicationFunctionLibrary.verifyGeoGeneratorPageVisible(objAutomation, Driver);
	}

@Given("^User is at Dashboard page as NON_ADMIN$")
public void user_is_at_Dashboard_page_as_NON_ADMIN() throws Throwable {
	//objApplicationFunctionLibrary.ValidateDefaultMaxKPI(objAutomation, Driver);
	}


@When("^User looks for Geo Generator option in Administration$")
public void user_looks_for_Geo_Generator_option_in_Administration() throws Throwable {
	//objApplicationFunctionLibrary.ValidateDefaultMaxKPI(objAutomation, Driver);
	}

@Then("^Geo Generator menu should not be visible$")
public void geo_Generator_menu_should_not_be_visible() throws Throwable {
	//objApplicationFunctionLibrary.ValidateDefaultMaxKPI(objAutomation, Driver);
	}

@When("^User opens Geo Generator via direct URL$")
public void user_opens_Geo_Generator_via_direct_URL() throws Throwable {
	//objApplicationFunctionLibrary.ValidateDefaultMaxKPI(objAutomation, Driver);
	}

@Then("^Authorization error or redirect should appear$")
public void authorization_error_or_redirect_should_appear() throws Throwable {
	//objApplicationFunctionLibrary.ValidateDefaultMaxKPI(objAutomation, Driver);
	}

@When("^User selects Administration and fetch Geo Generator locations$")
public void user_selects_Administration_and_fetch_Geo_Generator_locations() throws Throwable {
	objApplicationFunctionLibrary.OpenGeoGenerator(objAutomation, Driver);
	objApplicationFunctionLibrary.clickFetchGeoLocations(objAutomation, Driver);
	}

@Then("^Latitude and Longitude should be populated for each row$")
public void latitude_and_Longitude_should_be_populated_for_each_row() throws Throwable {
	objApplicationFunctionLibrary.verifylatitudelongitude(objAutomation, Driver);
	}
@Then("^Coordinates should be saved successfully$")
public void coordinates_should_be_saved_successfully() throws Throwable {
	objApplicationFunctionLibrary.verifycoordinatesSaved(objAutomation, Driver);
}
@When("^User clicks Reload$")
public void user_clicks_Reload() throws Throwable {
	objApplicationFunctionLibrary.OpenGeoGenerator(objAutomation, Driver);
	objApplicationFunctionLibrary.dealerCoordinateReloadBtn(objAutomation, Driver);
}
@Then("^Grid should refresh and show zero records if all resolved$")
public void grid_should_refresh_and_show_zero_records_if_all_resolved() throws Throwable {
	objApplicationFunctionLibrary.verifycoordinatesReloadBtn(objAutomation, Driver);
}

@When("^User clicks Save$")
public void user_clicks_Save() throws Throwable {
	objApplicationFunctionLibrary.OpenGeoGenerator(objAutomation, Driver);
	objApplicationFunctionLibrary.clickFetchGeoLocations(objAutomation, Driver);
	objApplicationFunctionLibrary.verifySaveEnabled(objAutomation, Driver);
	}

//**                        Quick Reports                     //**//

@Given("^User is at Dashboard Page$")
public void user_is_at_Dashboard_Page() throws Throwable {
	objApplicationFunctionLibrary.dashboardPage(objAutomation, Driver);
}
 
 
@When("^User navigates to Dashboard and scrolls to Quick Reports$")
public void user_navigates_to_Dashboard_and_scrolls_to_Quick_Reports() throws Throwable {
	objApplicationFunctionLibrary.QuickReportsection(objAutomation, Driver);
}
 
@Then("^Quick Reports panel should be visible for Dealer$")
public void quick_Reports_panel_should_be_visible_for_Dealer() throws Throwable {
	objApplicationFunctionLibrary.ValidateQuickReport(objAutomation, Driver);
}
 
@When("^User go to Quick reports and download excel$")
public void user_go_to_Quick_reports_and_download_excel() throws Throwable {
	objApplicationFunctionLibrary.Downloadexcel(objAutomation, Driver);
}
 
@Then("^Quick Reports should be download in excel$")
public void quick_Reports_should_be_download_in_excel() throws Throwable {
	objApplicationFunctionLibrary.validateQuickReportDownload(objAutomation, Driver);
}
 
@When("^User go to Quick reports and download pdf$")
public void user_go_to_Quick_reports_and_download_pdf() throws Throwable {
	objApplicationFunctionLibrary.DownloadPDF(objAutomation, Driver);
}
 
@Then("^Quick Reports should be download in pdf$")
public void quick_Reports_should_be_download_in_pdf() throws Throwable {
	objApplicationFunctionLibrary.validateQuickReportDownload(objAutomation, Driver);
}
 
//**                              Validation Rule                        //**//


 
 
 
@When("^User move to Validation Rule Editor page$")
public void user_move_to_Validation_Rule_Editor_page() throws Throwable {
    objApplicationFunctionLibrary.selectValidationRuleEditor(objAutomation, Driver);
}
 
 
@Then("^Validation Rule Editor page should open successfully$")
public void validation_Rule_Editor_page_should_open_successfully() throws Throwable {
	objApplicationFunctionLibrary.ValidationPageOpenSuccessfully(objAutomation, Driver);
	}	
 
@When("^User edit validation rule$")
public void user_edit_validation_rule() throws Throwable {
	objApplicationFunctionLibrary.SelectEditField(objAutomation, Driver);
}	
 
 
 
@Then("^User should be able to edit rule$")
public void user_should_be_able_to_edit_rule() throws Throwable {
	//objApplicationFunctionLibrary.ValidateEditField(objAutomation, Driver);
}
 
 
@When("^User Search Validation$")
public void user_Search_Validation() throws Throwable {
	objApplicationFunctionLibrary.SearchBox(objAutomation, Driver);
	}	
 
 
@Then("^User should be able to search$")
public void user_should_be_able_to_search() throws Throwable {
     objApplicationFunctionLibrary.ValidateSearch(objAutomation, Driver);
}	
 
@When("^User Downlaod Validation$")
public void user_Downlaod_Validation() throws Throwable {
	objApplicationFunctionLibrary.DownloadValidationRule(objAutomation, Driver);
}	
 	
@Then("^User should be able to Download Vaidation$")
public void user_should_be_able_to_Download_Vaidation() throws Throwable {
	//objApplicationFunctionLibrary.ValidateDownloadValidation(objAutomation, Driver);
}
@When("^User Save Validation$")
public void user_Save_Validation() throws Throwable {
   objApplicationFunctionLibrary.SaveValidationRule(objAutomation, Driver);
}	
@Then("^User should be able to Save Validation$")
public void user_should_be_able_to_Save_Validation() throws Throwable {
	//objApplicationFunctionLibrary.ValidateSaveRule(objAutomation, Driver);
}
@When("^User Cancel Validation$")
public void user_Cancel_Validation() throws Throwable {
	objApplicationFunctionLibrary.CancelRule(objAutomation, Driver);
}
 
 
@Then("^User should be able to Cancel Validation$")
public void user_should_be_able_to_Cancel_Validation() throws Throwable {
	//objApplicationFunctionLibrary.ValidateCancelRule(objAutomation, Driver);
	}
 
@When("^User Filter Validation Rule$")
public void user_Filter_Validation_Rule() throws Throwable {
	objApplicationFunctionLibrary.SelectFilter(objAutomation, Driver);
}
 

@Then("^User should be able to Filter Validation Rule$")
public void user_should_be_able_to_Filter_Validation_Rule() throws Throwable {
	objApplicationFunctionLibrary.ValidationFilter(objAutomation, Driver);
	}
 
 

}