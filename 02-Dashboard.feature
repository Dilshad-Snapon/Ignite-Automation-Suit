#Author: your.email@your.domain.com

Feature: Dashboard


##                    KPI Analysis Scenarios                     ##

 @Run2A
  Scenario: KPI Analysis chart is appearing for Global user
    Given User is at Dashboard page
    When User select Global from network hierarchy
    Then KPI Analysis chart should appear
    
    @Run2A
  Scenario: KPI Analysis Averages are appearing for selection
    Given User is at Dashboard page
    When User select KPI Analysis averages
    Then User should be able to select KPI analsysis averages
    
     @Run2A
  Scenario: KPI Analysis Averages ON and OFF button
    Given User is at Dashboard page
    When User click on Average ON and OFF button
    Then User should be able to turn ON and OFF selected average
    
    @Run2A
  Scenario: Select all KPI from setting button for KPI analysis chart
    Given User is at Dashboard page
    When User click on KPI analysis setting button
    Then User should be able to select all KPI
    
     @Run2A
  Scenario: DeSelect all KPI from setting button for KPI analysis chart
    Given User is at Dashboard page
    When User click on KPI analysis setting button
    Then User should be able to DeSelect all KPI
    
    @Run2A
  Scenario: Select Default KPI from setting button for KPI analysis chart
    Given User is at Dashboard page
    When User click on KPI analysis setting button
    Then User should be able to Select Default KPI
    
    @Run2A
  Scenario: Download button for KPI analysis chart
    Given User is at Dashboard page
    When User click on KPI analysis download button
    Then KPI anlsyis chart details should be downloaded
    
     @Run2A
  Scenario: KPI Analysis Maximize screen option
    Given User is at Dashboard page
    When User click on KPI analysis Maximize button
    Then User should be able to see KPI anlsysis chart in maximize window
    
     @Run2A
  Scenario: KPI Analysis Averages are appearing for selection in maximize window
    Given User is at Dashboard page
    When User select KPI Analysis max window averages
    Then User should be able to select KPI analsysis max window averages
    
     @Run2A
  Scenario: KPI Analysis Averages ON and OFF button for maximize window
    Given User is at Dashboard page
    When User click on max window Average ON and OFF button
    Then User should be able to turn ON and OFF selected max screen average
    
     @Run2A
  Scenario: Select all KPI from setting button for KPI analysis maximize screen
    Given User is Maximize window screen
    When User click on Max screen KPI analysis setting button
    Then User should be able to select all KPI
    
     @Run2A
  Scenario: DeSelect all KPI from setting button for KPI analysis maximize screen
    Given User is Maximize window screen
    When User click on Max screen KPI analysis setting button
    Then User should be able to DeSelect all KPI
    
    @Run2A
  Scenario: Select Default KPI from setting button for KPI analysis maximize screen
    Given User is Maximize window screen
    When User click on Max screen KPI analysis setting button
    Then User should be able to Select Default KPI
    
    @Run2A
  Scenario: Download button for KPI analysis Maximize window
    Given User is Maximize window screen
    When User click on KPI analysis download button in maxmize window
    Then Max screen KPI analysis chart details should be downloaded
    
    @Run2A
  Scenario: KPI Analysis item drill down from maximize window
    Given User is at Dashboard page
    When User click on KPI analysis item from maximize window
    Then User should be able to drill down that item
    
      @Run2A
  Scenario: KPI Analysis item drill down from dashboard page
    Given User is at Dashboard page
    When User click on KPI analysis item from dashboard page
    Then User should be able to drill down that item from Dashboard
    
     @Run2A
  Scenario: KPI Data download option in item drill down
    Given User is at Item Drill Down Page
    When User click on KPI data download button
    Then User should be able download kpi data details
    
     @Run2A
  Scenario: KPI calculation download option in item drill down
    Given User is at Item Drill Down Page
    When User click on KPI calculation download button
    Then User should be able download kpi calculation details
    
    @Run2A!
  Scenario: First average selection for KPI Trend in item drill down
    Given User is at Item Drill Down Page
    When User select first average for KPI Trend
    Then User should be able to select first average for KPI Trend
    
     @Run2A!
  Scenario: Second average selection for KPI Trend in item drill down
    Given User is at Item Drill Down Page
    When User select Second average for KPI Trend
    Then User should be able to select second average for KPI Trend
    
    @Run2A!
  Scenario: KPI Trend First Averages ON and OFF button 
    Given User is at Item Drill Down Page
    When User click on first KPI Trend Average ON and OFF button
    Then User should be able to turn ON and OFF first KPI trend selected average
    
    @Run2A!
  Scenario: KPI Trend Second Averages ON and OFF button 
    Given User is at Item Drill Down Page
    When User click on second KPI Trend Average ON and OFF button
    Then User should be able to turn ON and OFF second KPI trend selected average
    
    @Run2A!
  Scenario: KPI Trend download option in item drill down
    Given User is at Item Drill Down Page
    When User click on KPI Trend download button
    Then User should be able download kpi trend details
    
     @Run2A!
  Scenario: Market Trend Averages selection
    Given User is at Item Drill Down Page
    When User select market trend averages
    Then User should be able to select market trend averages
    
     @Run2A!
  Scenario: Market Trend download option in item drill down
    Given User is at Item Drill Down Page
    When User click on market Trend download button
    Then User should be able download market trend details
    
    @Run2A
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton
    Then User should be able to close network selector
    
     @Run2
  Scenario: KPI Analysis chart is appearing for market 
    Given User is at Dashboard page
    When User select market from network hierarchy
    Then KPI Analysis chart should appear
    
    @Run2
  Scenario: KPI Analysis Averages are appearing for Market
    Given User is at Dashboard page
    When User select KPI Analysis averages
    Then User should be able to select KPI analsysis averages
    
     @Run2
  Scenario: KPI Analysis Averages ON and OFF button for market
    Given User is at Dashboard page
    When User click on Average ON and OFF button
    Then User should be able to turn ON and OFF selected average
    
    @Run2
  Scenario: Select all KPI from setting button for KPI analysis chart for market
    Given User is at Dashboard page
    When User click on KPI analysis setting button
    Then User should be able to select all KPI
    
     @Run2
  Scenario: DeSelect all KPI from setting button for KPI analysis chart for market
    Given User is at Dashboard page
    When User click on KPI analysis setting button
    Then User should be able to DeSelect all KPI
    
    @Run2
  Scenario: Select Default KPI from setting button for KPI analysis chart for market
    Given User is at Dashboard page
    When User click on KPI analysis setting button
    Then User should be able to Select Default KPI
    
    @Run2
  Scenario: Download button for KPI analysis chart for market
    Given User is at Dashboard page
    When User click on KPI analysis download button
    Then KPI anlsyis chart details should be downloaded
    
     @Run2
  Scenario: KPI Analysis Maximize screen option for market 
    Given User is at Dashboard page
    When User click on KPI analysis Maximize button
    Then User should be able to see KPI anlsysis chart in maximize window
    
     @Run2
  Scenario: KPI Analysis Averages are appearing for selection in maximize window for market
    Given User is at Dashboard page
    When User select KPI Analysis max window averages
    Then User should be able to select KPI analsysis max window averages
    
     @Run2
  Scenario: KPI Analysis Averages ON and OFF button for maximize window for market
    Given User is at Dashboard page
    When User click on max window Average ON and OFF button
    Then User should be able to turn ON and OFF selected max screen average
    
     @Run2
  Scenario: Select all KPI from setting button for KPI analysis maximize screen for market
    Given User is Maximize window screen
    When User click on Max screen KPI analysis setting button
    Then User should be able to select all KPI
    
     @Run2
  Scenario: DeSelect all KPI from setting button for KPI analysis maximize screen for market
    Given User is Maximize window screen
    When User click on Max screen KPI analysis setting button
    Then User should be able to DeSelect all KPI
    
    @Run2
  Scenario: Select Default KPI from setting button for KPI analysis maximize screen for market
    Given User is Maximize window screen
    When User click on Max screen KPI analysis setting button
    Then User should be able to Select Default KPI
    
    @Run2
  Scenario: Download button for KPI analysis Maximize window for market
    Given User is Maximize window screen
    When User click on KPI analysis download button in maxmize window
    Then Max screen KPI analysis chart details should be downloaded
    
    @Run2
  Scenario: KPI Analysis item drill down from maximize window for market
    Given User is at Dashboard page
    When User click on KPI analysis item from maximize window
    Then User should be able to drill down that item
    
      @Run2
  Scenario: KPI Analysis item drill down from dashboard page for market
    Given User is at Dashboard page
    When User click on KPI analysis item from dashboard page
    Then User should be able to drill down that item from Dashboard
    
     @Run2
  Scenario: KPI Data download option in item drill down for market
    Given User is at Item Drill Down Page
    When User click on KPI data download button
    Then User should be able download kpi data details
    
     @Run2
  Scenario: KPI calculation download option in item drill down for market
    Given User is at Item Drill Down Page
    When User click on KPI calculation download button
    Then User should be able download kpi calculation details
    
    @Run2!
  Scenario: First average selection for KPI Trend in item drill down for market
    Given User is at Item Drill Down Page
    When User select first average for KPI Trend
    Then User should be able to select first average for KPI Trend
    
     @Run2!
  Scenario: Second average selection for KPI Trend in item drill down for market
    Given User is at Item Drill Down Page
    When User select Second average for KPI Trend
    Then User should be able to select second average for KPI Trend
    
    @Run2!
  Scenario: KPI Trend First Averages ON and OFF button for market
    Given User is at Item Drill Down Page
    When User click on first KPI Trend Average ON and OFF button
    Then User should be able to turn ON and OFF first KPI trend selected average
    
    @Run2!
  Scenario: KPI Trend Second Averages ON and OFF button for market
    Given User is at Item Drill Down Page
    When User click on second KPI Trend Average ON and OFF button
    Then User should be able to turn ON and OFF second KPI trend selected average
    
    @Run2!
  Scenario: KPI Trend download option in item drill down for market
    Given User is at Item Drill Down Page
    When User click on KPI Trend download button
    Then User should be able download kpi trend details
    
    @Run2
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton
    Then User should be able to close network selector
    
         @Run2
  Scenario: KPI Analysis chart is appearing for dealer 
    Given User is at Dashboard page
    When User select Dealer from network hierarchy selection
    Then KPI Analysis chart should appear
    
    @Run2
  Scenario: KPI Analysis Averages are appearing for dealer
    Given User is at Dashboard page
    When User select KPI Analysis averages
    Then User should be able to select KPI analsysis averages
    
     @Run2
  Scenario: KPI Analysis Averages ON and OFF button for dealer
    Given User is at Dashboard page
    When User click on Average ON and OFF button
    Then User should be able to turn ON and OFF selected average
    
    @Run2
  Scenario: Select all KPI from setting button for KPI analysis chart for dealer
    Given User is at Dashboard page
    When User click on KPI analysis setting button
    Then User should be able to select all KPI
    
     @Run2
  Scenario: DeSelect all KPI from setting button for KPI analysis chart for dealer
    Given User is at Dashboard page
    When User click on KPI analysis setting button
    Then User should be able to DeSelect all KPI
    
    @Run2
  Scenario: Select Default KPI from setting button for KPI analysis chart for dealer
    Given User is at Dashboard page
    When User click on KPI analysis setting button
    Then User should be able to Select Default KPI
    
    @Run2
  Scenario: Download button for KPI analysis chart for dealer
    Given User is at Dashboard page
    When User click on KPI analysis download button
    Then KPI anlsyis chart details should be downloaded
    
     @Run2
  Scenario: KPI Analysis Maximize screen option for dealer
    Given User is at Dashboard page
    When User click on KPI analysis Maximize button
    Then User should be able to see KPI anlsysis chart in maximize window
    
     @Run2
  Scenario: KPI Analysis Averages are appearing for selection in maximize window for dealer
    Given User is at Dashboard page
    When User select KPI Analysis max window averages
    Then User should be able to select KPI analsysis max window averages
    
     @Run2
  Scenario: KPI Analysis Averages ON and OFF button for maximize window for dealer
    Given User is at Dashboard page
    When User click on max window Average ON and OFF button
    Then User should be able to turn ON and OFF selected max screen average
    
     @Run2
  Scenario: Select all KPI from setting button for KPI analysis maximize screen for dealer
    Given User is Maximize window screen
    When User click on Max screen KPI analysis setting button
    Then User should be able to select all KPI
    
     @Run2
  Scenario: DeSelect all KPI from setting button for KPI analysis maximize screen for dealer
    Given User is Maximize window screen
    When User click on Max screen KPI analysis setting button
    Then User should be able to DeSelect all KPI
    
    @Run2
  Scenario: Select Default KPI from setting button for KPI analysis maximize screen for dealer
    Given User is Maximize window screen
    When User click on Max screen KPI analysis setting button
    Then User should be able to Select Default KPI
    
    @Run2
  Scenario: Download button for KPI analysis Maximize window for dealer
    Given User is Maximize window screen
    When User click on KPI analysis download button in maxmize window
    Then Max screen KPI analysis chart details should be downloaded
    
    @Run2
  Scenario: KPI Analysis item drill down from maximize window for dealer
    Given User is at Dashboard page
    When User click on KPI analysis item from maximize window
    Then User should be able to drill down that item
    
      @Run2
  Scenario: KPI Analysis item drill down from dashboard page for dealer
    Given User is at Dashboard page
    When User click on KPI analysis item from dashboard page
    Then User should be able to drill down that item from Dashboard
    
     @Run2
  Scenario: KPI Data download option in item drill down for dealer
    Given User is at Item Drill Down Page
    When User click on KPI data download button
    Then User should be able download kpi data details
    
     @Run2
  Scenario: KPI calculation download option in item drill down for dealer
    Given User is at Item Drill Down Page
    When User click on KPI calculation download button for dealer selection
    Then User should be able download kpi calculation details
    
    @Run2!
  Scenario: First average selection for KPI Trend in item drill down for dealer
    Given User is at Item Drill Down Page
    When User select first average for KPI Trend
    Then User should be able to select first average for KPI Trend
    
     @Run2!
  Scenario: Second average selection for KPI Trend in item drill down for dealer
    Given User is at Item Drill Down Page
    When User select Second average for KPI Trend
    Then User should be able to select second average for KPI Trend
    
    @Run2!
  Scenario: KPI Trend First Averages ON and OFF button for dealer
    Given User is at Item Drill Down Page
    When User click on first KPI Trend Average ON and OFF button
    Then User should be able to turn ON and OFF first KPI trend selected average
    
    @Run2!
  Scenario: KPI Trend Second Averages ON and OFF button for dealer
    Given User is at Item Drill Down Page
    When User click on second KPI Trend Average ON and OFF button
    Then User should be able to turn ON and OFF second KPI trend selected average
    
    @Run2!
  Scenario: KPI Trend download option in item drill down for dealer
    Given User is at Item Drill Down Page
    When User click on KPI Trend download button
    Then User should be able download kpi trend details
    
     @Run2
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton
    Then User should be able to close network selector
    
    ##                     Performance Variation                          ##
    
    
     @Run2A
  Scenario: Performance variation chart is appearing for Gloabl user
    Given User is at Dashboard page
    When User select Global from network hierarchy for Performance variation chart
    Then Performance variation chart should appear
    
       @Run2A
  Scenario: Performance variation chart download for Gloabl user
    Given User is at Dashboard page
    When User click on download option for Performance variation chart
    Then Performance variation chart details should download in excel format
    
     @Run2A
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton
    Then User should be able to close network selector
    
     @Run2
  Scenario: Performance variation chart is appearing for Market user
    Given User is at Dashboard page
    When User select market from network hierarchy
    Then Performance variation chart should appear
    
         @Run2
  Scenario: Performance variation chart download for market user
    Given User is at Dashboard page
    When User click on download option for Performance variation chart
    Then Performance variation chart details should download in excel format
    
     @Run2
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton
    Then User should be able to close network selector
    
     @Run2
  Scenario: Performance variation chart is appearing for Dealer user
    Given User is at Dashboard page
    When User select Dealer from network hierarchy selection
    Then Performance variation chart should appear
    
       @Run2
  Scenario: Performance variation chart download for dealer user
    Given User is at Dashboard page
    When User click on download option for Performance variation chart
    Then Performance variation chart details should download in excel format
    
     @Run2
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton
    Then User should be able to close network selector
    
    

##                    Network Dispersion Scenarios                     ##

  @Run2A
  Scenario: Network dispersion chart is accessable for Gloabl user
    Given User is at Dashboard page
    When User select Global from network hierarchy for Network dispersion chart
    Then Network dispersion chart should appear
    
     @Run#
  Scenario: Compare bubble size of two market in network dispersion chart
    Given User is at Dashboard page
    When User take total dealership sales value for two market
    Then Bubble size should be different according to market performance
    
       @Run#
  Scenario: Validate Network dispersion chart data
    Given User is at Dashboard page
    When User extract chart values
    Then Chart values should match with stored values
    
      @Run2A
  Scenario: Validate ZommIn and ZoomOut option for network dispersion chart 
    Given User is at Dashboard page
    When User click on zoom In and Zoom out button
    Then Bubble size should change accordingly
    
      @Run2A
  Scenario: Validate Download option for network dispersion chart 
    Given User is at Dashboard page
    When User click on download button
    Then Chart details should be downloaded in excel sheet
    
     @Run2A
  Scenario: Validate Network dispersion chart for different department 
    Given User is at Dashboard page
    When User select different department
    Then Chart details should be downloaded in excel sheet
    
    @Run2A
  Scenario: Validate Network dispersion chart for different Average selection 
    Given User is at Dashboard page
    When User select different average
    Then Chart details should be downloaded in excel sheet
    
    @Run2A
  Scenario: Validate Network dispersion chart for different period selection 
    Given User is at Dashboard page
    When User select different period
    Then Chart details should be downloaded in excel sheet
    
    @Run2A
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton
    Then User should be able to close network selector
    
    
    
    ##                     Market Dispersion                        ##
    
    @Run2
  Scenario: Market dispersion chart is accessable for market user
    Given User is at Dashboard page
    When User select market from network hierarchy
    Then Market dispersion chart should appear
    
     @Run2
  Scenario: Download for Market dispersion chart 
    Given User is at Dashboard page
    When User click on market dispersion chart download button
    Then Market dispersion Chart details should be downloaded in excel sheet
    
     @Run2
  Scenario: Validate Market dispersion chart for different Average selection 
    Given User is at Dashboard page
    When User select different average
    Then Market dispersion Chart details should be downloaded in excel sheet
    
     @Run2
  Scenario: Validate Market dispersion chart for different department 
    Given User is at Dashboard page
    When User select different department
    Then Market dispersion Chart details should be downloaded in excel sheet
    
     @Run2
  Scenario: Validate Market dispersion chart for different period selection 
    Given User is at Dashboard page
    When User select different period
    Then Market dispersion Chart details should be downloaded in excel sheet
    
     @Run2
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton
    Then User should be able to close network selector
    
    @Run#
  Scenario Outline: Validate KPI Values
    Given Login Testdata as "<TestCondition>""<F_Name>""<Surname>""<C_Name>""<AddressOne>""<AddressTwo>""<City>""<Country>""<PostCode>""<MobilePhone>""<Email>"
    Given User is on Daily dairy page
    When user enter customer details
    Then User navigate to overview page

    Examples: 
      | TestCondtion   | MAP First KPI   | MAP Second KPI | MAP Third KPI    |
      | TestCondition1 | Map First | Map Second   | Map Third | 
      
      
      
      ##   NetSales and NetProfit Pie Chart Scenarios   ##
      
   @Run2AB
  Scenario: Net Profit and Net Sales pie charts appear for Dealer User selection 
    Given User is at Dashboard page
    When User select Dealer from network hierarchy selection
    Then Net profit and Net sales charts should appear
    
    @Run#
  Scenario: Net Sales pie chart appear for Dealer User selection 
    Given User is at Dashboard page
    When User select Dealer from network hierarchy selection
    Then Net sales chart should appear
    
     
    @Run2AB
  Scenario: Net Operating Profit pie chart Legend ON and OFF 
    Given User is at Dashboard page
    When User click on Net operating chart legends
    Then Net Operating pie chart appear as per selection
    
    
    @Run2AB
  Scenario: Net Sales pie chart Legend ON and OFF 
    Given User is at Dashboard page
    When User click on Net sales chart legend
    Then Net sales chart should appear as per selection
    
    
    @Run2AB
  Scenario: Net Operating profit Chart download button 
    Given User is at Dashboard page
    When User click on Net operating profit chart download button
    Then Net operating profit chart should downloaded
    
    @Run2AB
  Scenario: Net sales Chart download button 
    Given User is at Dashboard page
    When User click on Net sales chart download button
    Then Net sales chart should downloaded
      
      
      @Run2AB
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton
    Then User should be able to close network selector
      
   
##                                P&L Dispersion Chart                                  ##

 @Run2A
  Scenario: P&L Dispersion chart is appearing for Gloabl user
    Given User is at Dashboard page
    When User select Global from network hierarchy for PL dispersion chart
    Then P&L dispersion chart should appear
    
     @Run2A
  Scenario: Select all average for PL dispersion chart from average selector setting
    Given User is at Dashboard page
    When User click on PL Dispersion setting button
    Then User should be able to select all average for chart
    
     @Run2A
  Scenario: De Select all average for PL dispersion chart from average selector setting
    Given User is at Dashboard page
    When User click on PL Dispersion setting button
    Then User should be able to deselect all average for chart

 
     @Run2A
  Scenario: Select default average for PL dispersion chart from average selector setting
    Given User is at Dashboard page
    When User click on PL Dispersion setting button
    Then User should be able to select default average for chart
    
      @Run2A
  Scenario: Download PL dispersion chart
    Given User is at Dashboard page
    When User click on PL Dispersion download button
    Then User should be able to download PL dispersion chart
    
    @Run2A
  Scenario: PL Dispersion Chart maximize view
    Given User is at Dashboard page
    When User click on PL Dispersion maximize button
    Then User should be able to see PL dispersion chart in maximize screen
    
        @Run2A
  Scenario: Select all average for PL dispersion chart from average selector setting in maximize window
    Given User is at PL Dispersion Maximize window page
    When User click on Maximize PL Dispersion setting button
    Then User should be able to select all average for chart in maximize screen
    
     @Run2A
  Scenario: De Select all average for PL dispersion chart from average selector setting in maximize window
   Given User is at PL Dispersion Maximize window page
    When User click on Maximize PL Dispersion setting button
    Then User should be able to deselect all average for chart in maximize screen

 
     @Run2A
  Scenario: Select default average for PL dispersion chart from average selector setting in maximize window
    Given User is at PL Dispersion Maximize window page
    When User click on Maximize PL Dispersion setting button
    Then User should be able to select default average for chart in maximize screen
    
      @Run2A
  Scenario: Download PL dispersion chart in maximize window
    Given User is at PL Dispersion Maximize window page
    When User click on Maximize PL Dispersion download button
    Then User should be able to download Maximize PL dispersion chart
    
    @Run2A
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton for KPI Performance chart
    Then User should be able to close network selector
    
    
    ##                             KPI Performance                                  ##
    
     @Run2
  Scenario: KPI Performance chart is appearing for market dealer
    Given User is at Dashboard page
    When User select market from network hierarchy for KPI Performance chart
    Then KPI Performance chart should appear
    
     @Run2
  Scenario: Select all KPI for KPI performance chart from setting button for market selection
    Given User is at Dashboard page
    When User click on KPI Performance setting button
    Then User should be able to select all KPI for chart
    
     @Run2
  Scenario: DeSelect all KPI for KPI performance chart from setting button for market selection
    Given User is at Dashboard page
    When User click on KPI Performance setting button
    Then User should be able to Deselect all KPI for chart
    
      @Run2
  Scenario: Select default KPI for KPI performance chart from setting button for market selection
    Given User is at Dashboard page
    When User click on KPI Performance setting button
    Then User should be able to select default KPI for chart
    
     @Run2
  Scenario: Download KPI performance chart for market selection
    Given User is at Dashboard page
    When User click on KPI Performance download button
    Then User should be able to download KPI Performance chart details
    
     @Run2
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton for KPI Performance chart
    Then User should be able to close network selector
    
       @Run2
  Scenario: KPI Performance chart is appearing for dealer
    Given User is at Dashboard page
    When User select Dealer from network hierarchy selection for KPI Performance chart
    Then KPI Performance chart should appear
    
     @Run2
  Scenario: Select all KPI for KPI performance chart from setting button for dealer
    Given User is at Dashboard page
    When User click on KPI Performance setting button
    Then User should be able to select all KPI for chart
    
     @Run2
  Scenario: DeSelect all KPI for KPI performance chart from setting button for dealer
    Given User is at Dashboard page
    When User click on KPI Performance setting button
    Then User should be able to Deselect all KPI for chart
    
      @Run2
  Scenario: Select default KPI for KPI performance chart from setting button for dealer
    Given User is at Dashboard page
    When User click on KPI Performance setting button
    Then User should be able to select default KPI for chart
    
     @Run2
  Scenario: Download KPI performance chart for dealer
    Given User is at Dashboard page
    When User click on KPI Performance dealer download button
    Then User should be able to download KPI Performance chart details

     @Run2
  Scenario: Close network selector dropdown
    Given User is at Dashboard page
    When User click on network selector filter buton for KPI Performance chart
    Then User should be able to close network selector