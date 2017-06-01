//##############################################################################################################################################################
//Framework Version:	BSACoPFramework_Ver3.0
//Date:					10th May 2017
//List of Methods:
	// 1. executeTestSuite
	// 2. readObjectRepository
	// 3. readTestData
	// 4. readTestExecution
	// 5. createDetailedReportsFolder
	// 6. createDetailedReport
	// 7. runTestNGTest
	// 8. getCreateSummary
    // 9. createSummaryReport
	// 10. @Before and @After methods - startBrowser, stopBrowser
	// 11. captureScreenshot
	// 12. logResult
	// 13. getExcelSheet
	// 14. TestData
	// 15. TestData - overridden method of TestData for rownum and colnum
	// 16. sumExecutionTime
	// 17. getElementLocator
	// 18. AppendOR
	// 19. getTestData
	// 20. updateTestDataTimeStamp
	// 21. readExecutionProperties - New method added to read values from Execution Property File
	// 22. sendReportEmail - New method added to send Email attaching reports 
	// 23. sendSummaryReportEmail -New method added to send Email attaching Summary report
	// 24. checkDependency - New method to check test case dependency
	// 25. getSmtpServer - New method to get the excat smtp server for the environment
	// 26. Framework Keywords
			//1. click 
			//2. javascriptClick
			//3. hover
			//4. hoverClick
			//5. deleteCookies
			//6. mandatoryExist	- Modified the method name from mandotoryExist to mandatoryExist
			//7. verifyExist
			//8. verifyNotExist
			//9. waitUntil		- Modified the method name from waitUntill to waitUntil
			//10. elementCount
			//11. getText
			//12. getPropertyValue
			//13. verifyText
			//14. compareStrings
			//15. containsText
			//16. loadUrl
			//17. iFrameSwitch	- Modified the method name from iFrame to iFrameSwitch
			//18. iFrameSwitchVal	- Modified the method name from iFrame to iFrameSwitchVal
			//19. waitAndSwitchToFrame - Modified the method name from waitandswitchFrame to waitAndSwitchToFrame
			//20. exitFrame
			//21. sync
			//22. type
			//23. split
			//24. keyBoardActions
			//25. getWindowId
			//26. getWindowsId
			//27. getCurrentDatenTime
			//**************************************************************************************
			// 13th April 2016 - V1.4
			// Modified @Aftermethod to close Chrome and FireFox browsers
			// Below keywords are added to the framework
			//**************************************************************************************
			//28. clear
			//29. refreshPage
			//30. getURL
			//31. getPageTitle
			//32. alert
			//33. typeonAlert
			//34. switchWindow	
			//**************************************************************************************
			// 2nd May 2016 - V2.0
			// Modified executeTestSuite to include console logs to a log file 
			// and added summary report and changed detailed report
			// Below keywords are added to the framework
			//**************************************************************************************
			//35. getRowCount
			//36. getPropertyValue -over ridden method from GetPropertyValue
			//37. getText - over ridden method from GetText
			//38. getDateDifference
			//39. writeExcel
			//40. readExcel
			//**************************************************************************************
			// 23rd May 2016 - V2.1
			// Modified loadUrl method wait time and updated verifyExist and VerifyNotExist method to return value correctly 
			// updated getWindowsId method return type to array and updated the method
			//**************************************************************************************		
			//41. click - over ridden method from click		
			//**************************************************************************************
			// 10th June 2016 - V2.2
			// Added Ignore Zoom Setting for IE Browser in Before Method
			// readTestData Method - Added TestData handling for different environments using existing sheet
			// Fixed a bug executeTestSuite method to run till last row 
			// Separated javascriptClick method from normal click method
			// Added a overridden method for TestData method
			//**************************************************************************************		
			//42. closeWindow
			//43. addToTestData
			//**************************************************************************************
			// 31st August 2016 - V2.3
			// Updated readTestData method to handle numeric values in TestData sheet
			// Updated readTestExecution method to use one hash map to store all the values
			// updated GetTestData method and updateTestDataTimeStamp
			// Added PageDown Key stroke
			// Branding changes to reports
			// Add Skip Execution to executeTestSuite, readObjectRepository, readTestData and readTestExecution methods
			//**************************************************************************************		
			//44. updateTestData
			//45. isEnabled
			//46. select
			//47. verifyText - over ridden method from verifyText
			//48. logToReport
			//49. browseFile
			//50. waitUntilAjaxCallComplete
			//**************************************************************************************
			// 1st December 2016 - V2.4
			// Removed executeTestSuite method parameters, now they are read through a property file.
			// readExecuteProperties method is added to read the values
			// Updated readTestExecution method to now read the browser as well from the same sheet
			// Updated executeTestSuite to launch browser accordingly based on Test Execution sheet
			// click(index) method is updated to handle any element at runtime
			// loadurl method is updated with Exception to get passed when we see windows components while loading URL
			// sendReportEmail method is added to zip the reports and send an email attaching the reports
			// sendSummaryReportEmail sends an email attaching the summary report as attachment
			// updated waitUntil method with optional parameter to skip the Logs
			// updated VerifyExist method with optional parameter to skip the Logs
			// updated VerifyNotExist method with optional parameter to skip the Logs
			//**************************************************************************************		
			//51. scrollHorizontal
			//**************************************************************************************
			// 16th March 2017 - V2.5
			// Fix for IE browser failing to launch and perform an action on an application 
			// [Error : Unable to find elements on closed window, Unable to get browser]
			// Dev and Int parameters for test data sheet added
			// Added Dependency of test cases in the Execution sheet and as well as the logic
			// Test Output Folder Structure changed
			// Removed unnecessary wait statements
			// sendReportEmail - updated to send email based on environment using smtp while running on servers
			// sendSummaryReportEmail - updated to send email based on environment using smtp while running on servers
			//**************************************************************************************		
			//52. javascriptClick - over ridden method from javascriptClick
			//53. scrollToElement
			//54. scrollToElement - over ridden method from scrollToElement
			//55. checkObjectStatus
			//56. submit
			//57. newFileName
			//58. rewriteFileName
			//59. dragAndDrop
			//60. moveAndClick
			//61. moveAndClickObject
			//62. getListText
			//63. contextMenuClick
			//**************************************************************************************
			// 10th May 2017 - V3.0
			// Supporting selenium 3.4.0 version
			// Fix added for wrong class names and method names
			// Fix added to not to check dependency when the Execution status is 'No'
			// Edge browser added
			// Gecko browser for Firefox 
			//**************************************************************************************
//##############################################################################################################################################################	

package drivers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.zeroturnaround.zip.ZipUtil;

public class WebActions {
	
	WebDriver Driver;
	public static String IEPath;
	public static String strFolderPath;
	public String testCaseName = "";
	public String browserName = "";	
	String TextValue=null;
	public static int iHours=0;
	public static int iMinutes=0;
	public static int iSeconds=0;
	public static int intSNo=1;
	public static String strOverallStatus="";
	public static int intTcsExecutedCount=0;
	public static String strExecutionStatus="";
	public static String strSummaryReportName="";
	public static String strHtml5Application="";
	int cellno;
	public String strSplitValue="";
	public static String strExecutionFolderPath=null;
	public static String strExecutionDate=null;
	String Colvalue = null;
	public String strLogPath="";
	public static StringBuffer sbDetailedReport = new StringBuffer();
	public static boolean detailedreportflag=false;
	
	public static List<String> lstLocators;
	public static List<String> lstExecutionsheet;
	public static List listkeyValue = new ArrayList<>();
	public static Map <String,List<String>> mapObjectRepository = new HashMap<String, List<String>>();
	public static Map <String,String> mapTestData = new HashMap<String, String>();
	public static Map <Integer,List<String>> mapTestExecution = new HashMap<Integer, List<String>>();
	public static Map<String, String> mapTestExecutionStatus = new HashMap<String,String>();
	public static By ElementLocator;
	public static Sheet ExecutionSheet = null;
	public By objLocator;
	public List<WebElement> lstElements;
	public static String strTestDataInput = null, strTestDataInput2 = null;
	public static String strDriverType = null;
	
	public PrintStream orgStream = null;
	public PrintStream fileStream = null;

//##############################################################################################################################################################
//######### 1. Executes the Test cases for all methods which are marked as "Yes" in Execution sheet (TestExecution.xlsx)
//##############################################################################################################################################################	
					
		public void executeTestSuite() throws Exception{
			try{			
				
				System.setProperty("log4j.configurationFile","./Assets/log4j.properties");
				Logger log = LogManager.getLogger("ManualLogger");
				
				//Read the Execution Property File
				String arrExecutionParameters[] = new String[14];
				arrExecutionParameters=readExecutionProperties();
				String strProjectName=arrExecutionParameters[0].trim();
				String strSuiteName=arrExecutionParameters[1].trim();
				String strEnvironmentName=arrExecutionParameters[2].trim();			
				String strSendReportEmail=arrExecutionParameters[3].trim();	
				String strTo=arrExecutionParameters[4].trim();	
				String strCC=arrExecutionParameters[5].trim();	
				String strSendAllReportsEmail=arrExecutionParameters[6].trim();	
				strHtml5Application=arrExecutionParameters[7].trim();	
				String strBatch=arrExecutionParameters[8].trim();	
				String strDev=arrExecutionParameters[9].trim();	
				String strInt=arrExecutionParameters[10].trim();	
				String strQa=arrExecutionParameters[11].trim();	
				String strStg=arrExecutionParameters[12].trim();	
				String strProd=arrExecutionParameters[13].trim();					
				
				//Create Log File
				if(!new File("./TestOutput").isDirectory())
					new File("./TestOutput").mkdirs();
				strFolderPath = getCurrentDatenTime("ddMMMyyyy") + "_"
			 			+ getCurrentDatenTime("HHmmss");
				String strFilePath = "./TestOutput/"+strFolderPath;
				new File(strFilePath).mkdirs();
				
				strLogPath = "./TestOutput/"+strFolderPath+"/Logs_"+ strFolderPath +".txt";
				
				System.setOut(new PrintStream(new FileOutputStream(strLogPath,true),true));
				System.out.println("**********************************************************************************************************");
				System.out.println("Execution Log Report ");
				System.out.println("**********************************************************************************************************");
				System.out.println("Project Name           : "+strProjectName);
				System.out.println("Suite Name             : "+strSuiteName);
				System.out.println("Environment            : "+strEnvironmentName);
				System.out.println("SendReport Email       : "+strSendReportEmail);
				System.out.println("To Email               : "+strTo);
				System.out.println("CC Email               : "+strCC);	
				System.out.println("SendAllReports Email   : "+strSendAllReportsEmail);
				System.out.println("Html5 Application      : "+strHtml5Application);
				System.out.println("Batch Execution        : "+strBatch);	
				System.out.println("Date Timestamp Created : "+ getCurrentDatenTime("dd-MMM-yyyy")+ " " +getCurrentDatenTime("HH:mm:ss"));
				System.out.println("BSA COP Framework Ver  : 3.0");
				System.out.println("**********************************************************************************************************");
				System.out.println();
				System.out.println("Log Path  :"+strLogPath);
				System.out.println();
				
				log.debug("Getting UKUnit value");
				//Read all the input Excel files like ObjectRepository,TestData,TestExecution
				readObjectRepository();
				readTestData(strEnvironmentName);		
				updateTestDataTimeStamp();
				readTestExecution(strSuiteName);
				strExecutionFolderPath=createDetailedReportsFolder();
				strExecutionDate=getCurrentDatenTime("dd-MMM-yyyy");
				
				//System.out.println("Test Execution Map Lengh: "+mapTestExecutionOrder.size());
				//Looping Test Case Execution based on Order for Methods with Status "YES".
				System.out.println("***************************************  Test Execution Started  *****************************************");
				System.out.println();
				for(int i=1;i<=mapTestExecution.size();i++){
					listkeyValue = mapTestExecution.get(i);
					String strClassName = (String) listkeyValue.get(0);
					String strTestCaseName = (String) listkeyValue.get(1);				
					String strTestCaseStatus = (String) listkeyValue.get(2);
					String strBrowserType= (String) listkeyValue.get(3);
					String strDependency= (String) listkeyValue.get(4);
					strDriverType=strBrowserType;
					boolean skipflag=false;
					boolean classflag=false;
					if((strTestCaseStatus).equalsIgnoreCase("yes")){	//Checking for status Yes for the method read from Hashmap "mapTestExecution".
						
						try{
							Class c = Class.forName("testCases."+strClassName);
							if (c.getDeclaredMethod(strTestCaseName, null) != null) {
								classflag=true;
							}
						}catch(Exception e){
							System.out.println("Class/Method not found exception : "+e.getMessage());
							System.out.println("Execution skipped");
							System.out.println("**********************************************************************************************************");
							classflag=false;
						}
						if(classflag){
							if(strDependency.trim().equalsIgnoreCase("")){
								skipflag=false;
							}else{					
								skipflag=checkDependency(strDependency);
							}					
							
							if(skipflag){
								
								intSNo=1;
								strOverallStatus="Blocked";
								String strStartTime=getCurrentDatenTime("dd-MMM-yyyy")+" "+getCurrentDatenTime("HH:mm:ss");
								String strEndTime=getCurrentDatenTime("dd-MMM-yyyy")+" "+getCurrentDatenTime("HH:mm:ss");
								String strExecutionTime=getDateDifference(strStartTime,strEndTime,"dd-MMM-yyyy HH:mm:ss");					
								mapTestExecutionStatus.put(strClassName+"."+strTestCaseName, strOverallStatus);
								logResult(IEPath, "Skip Test Case Execution", "NA", "NA", "NA", "Skiping execution because of dependecy failure",strOverallStatus,"");
								mapTestExecutionStatus.put(strClassName+"."+strTestCaseName, strOverallStatus);
								String strReportPath  = createDetailedReport(strProjectName, strBrowserType, strClassName, strTestCaseName, strExecutionFolderPath, strStartTime, strEndTime, strExecutionTime, sbDetailedReport);
								System.out.println("Detailed report path for testcase : "+strReportPath);
								System.out.println();				
								
							}else{
								intSNo=1;
								strOverallStatus="Pass";
								String strStartTime=getCurrentDatenTime("dd-MMM-yyyy")+" "+getCurrentDatenTime("HH:mm:ss");
								runTestNGTest(strBrowserType,strSuiteName,strClassName,"testCases."+strClassName,strTestCaseName);
								String strEndTime=getCurrentDatenTime("dd-MMM-yyyy")+" "+getCurrentDatenTime("HH:mm:ss");
								String strExecutionTime=getDateDifference(strStartTime,strEndTime,"dd-MMM-yyyy HH:mm:ss");					
								mapTestExecutionStatus.put(strClassName+"."+strTestCaseName, strOverallStatus);
								String strReportPath  = createDetailedReport(strProjectName, strBrowserType, strClassName, strTestCaseName, strExecutionFolderPath, strStartTime, strEndTime, strExecutionTime, sbDetailedReport);
								System.out.println("Detailed report path for testcase : "+strReportPath);
								System.out.println();
							}
						    listkeyValue.clear();
						}
					}
				}				
				
				if(detailedreportflag){
					getCreateSummary(strProjectName, strExecutionFolderPath, strSuiteName, strEnvironmentName); 
					System.out.println("***************************************  Test Execution Completed  ***************************************");			
								
					if(strSendReportEmail.equals("y") || strSendReportEmail.equals("yes")){
						if(intTcsExecutedCount>0){		
							String smtpservername=getSmtpServer(strEnvironmentName,strBatch,strDev,strInt,strQa,strStg,strProd);
							if(strSendAllReportsEmail.equalsIgnoreCase("yes")){
								sendReportEmail(strBatch,smtpservername,strProjectName,strTo,strCC,strExecutionFolderPath,strExecutionStatus);
							}else{
								sendSummaryReportEmail(strBatch,smtpservername,strProjectName,strTo,strCC,strExecutionFolderPath,strExecutionStatus);
							}							
						}
					}
				}
			
			}catch(Exception executeTestSuiteException){				
				System.out.println("executeTestSuite Method Exception Message: "+executeTestSuiteException);
	 			throw new SkipException("Skipping execution - Test Execution Failed");
			}			
		}

//##############################################################################################################################################################
//######### 2. Reads objectRepository.xlsx and stores objects in public HashMap mapObjectRepository
//##############################################################################################################################################################	

		public void readObjectRepository() throws IOException{
			try{
				String excelFilePath = "./Assets/ObjectRepository.xlsx";
			 	FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			 	Workbook workbook = new XSSFWorkbook(inputStream);
			 	//System.out.println("No.of sheets: "+workbook.getNumberOfSheets());
			 	int intSheetcount = workbook.getNumberOfSheets();
			 	//System.out.println("Reading Object Repository Sheet");				 		
			 	System.out.println("***********************************  Reading Object Repository Sheet  ************************************");
				System.out.println();
				int j=1;
			 	for (int i=0;i<intSheetcount;i++){
			 		Sheet Sheets = workbook.getSheetAt(i);
			        System.out.println("Object Repository Sheet" + j++ + " - Row Count: "+Sheets.getLastRowNum());
			        System.out.println();
			        //Iterator<Row> iterator = firstSheet.iterator();
			       
			        for (int rowno=0;rowno<Sheets.getLastRowNum();rowno++) {
			        	Row nextRow = Sheets.getRow(rowno+1);//iterator.next();
			        	//Iterator<Cell> cellIterator = nextRow.cellIterator();
			        	Cell ObjNamecell = nextRow.getCell(0);
			        	String strObjName = ObjNamecell.getStringCellValue();
			        	Cell ObjLocatorType = nextRow.getCell(1);
			        	String strLocatorType = ObjLocatorType.getStringCellValue();
			        	Cell ObjValue = nextRow.getCell(2);
			        	String strValue = ObjValue.getStringCellValue();
			        	System.out.print(strObjName);
			        	System.out.print(" - ");
			        	System.out.print(strLocatorType);
			        	System.out.print(" - ");
			        	System.out.print(strValue);
			        	System.out.print(" - ");
			           
			        	lstLocators = new ArrayList<>();
			        	lstLocators.add(strLocatorType);
			        	lstLocators.add(strValue);
			        	mapObjectRepository.put(strObjName, lstLocators);
			        	//System.out.println(i+" Column Value: "+ParameterValue);
			        	System.out.println("Object Repository Map Value: "+mapObjectRepository.get(strObjName));
			        	System.out.println();
			       }
			 	} 
			 	workbook.close();
			    inputStream.close();
			}catch(Exception readObjectRepositoryException){				
				System.out.println("readObjectRepository Method Exception Message: "+readObjectRepositoryException);
	 			throw new SkipException("Skipping execution - Issue with Object Repository Sheet");
			}	
		}
		 	
//##############################################################################################################################################################
//######### 3. Reads TestData.xlsx and stores objects in public HashMap mapTestData
//##############################################################################################################################################################	
		 	
		public void readTestData(String strEnvName) throws IOException{
			try{
				boolean devsheet=false,intsheet=false,qasheet=false,stagesheet=false,prodsheet=false,chkPerform=false;
				switch(strEnvName.toLowerCase()){
					case "dev":
						devsheet=true;
						intsheet=false;
						qasheet=false;
						stagesheet=false;
						prodsheet=false;
						break;
					case "int":
						devsheet=false;
						intsheet=true;
						qasheet=false;
						stagesheet=false;
						prodsheet=false;
						break;
					case "qa":
						devsheet=false;
						intsheet=false;
						qasheet=true;
						stagesheet=false;
						prodsheet=false;
						break;
					case "stage":
						devsheet=false;
						intsheet=false;
						qasheet=false;
						stagesheet=true;
						prodsheet=false;
						break;
					case "prod":
						devsheet=false;
						intsheet=false;
						qasheet=false;
						stagesheet=false;
						prodsheet=true;
						break;					
				}
				
				String excelFilePath = "./Assets/TestData.xlsx";
				FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			       
				Workbook workbook = new XSSFWorkbook(inputStream);
				//System.out.println("No.of sheets: "+workbook.getNumberOfSheets());
				int intSheetcount = workbook.getNumberOfSheets();
				System.out.println("**************************************  Reading Test Data Sheet  *****************************************");
				System.out.println();
			 	int j=1;			
			    for (int i=0;i<intSheetcount;i++){
			    	String strSheetName=workbook.getSheetName(i);
			    	
			    	if(strSheetName.equalsIgnoreCase(strEnvName)){
			    		chkPerform=true;
			    	}else{
			    		if((strSheetName.equalsIgnoreCase("dev")) && (devsheet==false)){
			    			System.out.println(strSheetName+" Testdata sheet skipped");
			    			System.out.println();
			    			chkPerform=false;
			    		}else if((strSheetName.equalsIgnoreCase("int")) && (intsheet==false)){
			    			System.out.println(strSheetName+" Testdata sheet skipped");
			    			System.out.println();
			    			chkPerform=false;
			    		}else if((strSheetName.equalsIgnoreCase("qa")) && (qasheet==false)){
			    			System.out.println(strSheetName+" Testdata sheet skipped");
			    			System.out.println();
			    			chkPerform=false;
			    		}else if((strSheetName.equalsIgnoreCase("stage")) && (stagesheet==false)){
			    			System.out.println(strSheetName+" Testdata sheet skipped");
			    			System.out.println();
			    			chkPerform=false;
			    		}else if((strSheetName.equalsIgnoreCase("prod")) && (prodsheet==false)){
			    			System.out.println(strSheetName+" Testdata sheet skipped");
			    			System.out.println();
			    			chkPerform=false;
			    		}else{
			    			chkPerform=true;
			    		}
			    	}
			    	
			    	if (chkPerform){
				    	Sheet Sheets = workbook.getSheetAt(i);
				      	System.out.println("Test Data Sheet"+ j++ + " - "+ strSheetName +" - Row Count: "+Sheets.getLastRowNum());
				      	System.out.println();
				      	//Iterator<Row> iterator = firstSheet.iterator();
				      
				      	for (int rowno=0;rowno<Sheets.getLastRowNum();rowno++) {
				      		Row nextRow = Sheets.getRow(rowno+1);//iterator.next();
				      		//Iterator<Cell> cellIterator = nextRow.cellIterator();
				      		Cell ObjTestDataName = nextRow.getCell(0);
				      		String strTestDataName = ObjTestDataName.getStringCellValue();
				      		Cell ObjTestDataValue = nextRow.getCell(1);
				      		String strTestDataValue="";
				      		switch (ObjTestDataValue.getCellType()) {
				      			case Cell.CELL_TYPE_STRING:
				      				strTestDataValue=ObjTestDataValue.getStringCellValue();
				      				break;
				      			case Cell.CELL_TYPE_NUMERIC:
				      				double dTestDataValue = ObjTestDataValue.getNumericCellValue();
				      				strTestDataValue=Double.toString(dTestDataValue);
				      				break;
				      			default :
				      				strTestDataValue=ObjTestDataValue.getStringCellValue();
				      		}
				      		System.out.print(strTestDataName);
				      		System.out.print(" - ");
				      		System.out.print(strTestDataValue);
				      		System.out.print(" - ");
				      		mapTestData.put(strTestDataName, strTestDataValue);
							System.out.println("Test Data Map Value: "+mapTestData.get(strTestDataName));
					    	System.out.println();
				      	}
			    	}
			    	chkPerform=false;
			    } 
			    workbook.close();
			    inputStream.close();
			}catch(Exception readTestDataException){				
				System.out.println("readTestData Method Exception Message: "+readTestDataException);
	 			throw new SkipException("Skipping execution - Issue with Test Data Sheet");
			}	
			
		}
		 			
//##############################################################################################################################################################
//######### 4. Reads TestExecution.xlsx and stores objects in public HashMap mapTestExecutionOrder
//##############################################################################################################################################################	
		 			 	
		public void readTestExecution(String Executiontype) throws IOException{
			try{
				String excelFilePath = "./Assets/TestExecution.xlsx";
			    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			       
			    Workbook workbook = new XSSFWorkbook(inputStream);
			    int intSheetcount = workbook.getNumberOfSheets();
			    System.out.println("************************************  Reading Execution Sheet  *******************************************");
				System.out.println();
				
			 	boolean notfound=true;
			    if (Executiontype.equalsIgnoreCase("smoke")){
			    	for (int k=0;k<intSheetcount;k++){
			    		String strSheetName=workbook.getSheetName(k);
			    		String strLowercase=strSheetName.toLowerCase();
			    		if(strLowercase.contains("smoke")){
			    			ExecutionSheet = workbook.getSheetAt(k);
			    			System.out.println("Execution - Smoke Sheet - Row Count: "+ExecutionSheet.getLastRowNum());
			    			System.out.println();
			    			notfound=false;
			    			break;
			    		}		    		
			    	}
			    }else if(Executiontype.equalsIgnoreCase("regression")){
			    	for (int k=0;k<intSheetcount;k++){
			    		String strSheetName=workbook.getSheetName(k);
			    		String strLowercase=strSheetName.toLowerCase();
			    		if(strLowercase.contains("regression")){
			    			ExecutionSheet = workbook.getSheetAt(k);
					      	System.out.println("Execution - Regression Sheet - Row Count: "+ExecutionSheet.getLastRowNum());
					      	System.out.println();
					      	notfound=false;
					      	break;
			    		}
			    	}		      	
			    }else{
			      	System.out.println("Invalid parameter, please provide sheet value as smoke or regression");
			      	System.out.println();
			    }
			    
			    if(notfound){
			    	System.out.println("Please provide valid sheet names as smoke or regression in Test Execution Sheet");
			      	System.out.println();
			    	
			    }else{
			       
				    for (int rowno=0;rowno<ExecutionSheet.getLastRowNum();rowno++) {
				    	Row nextRow = ExecutionSheet.getRow(rowno+1);
				        Cell order = nextRow.getCell(0);
				        int intOrder = (int) order.getNumericCellValue();
				        Cell className = nextRow.getCell(1);
				        String strclassName = className.getStringCellValue();
				        Cell testcaseName = nextRow.getCell(2);
				        String strtestcaseName = testcaseName.getStringCellValue();
				        Cell Objexecution = nextRow.getCell(3);
				        String strExecution = Objexecution.getStringCellValue();
				        Cell objBrowser = nextRow.getCell(4);
				        String strBrowser = objBrowser.getStringCellValue();
				        Cell objDependency = nextRow.getCell(5);
				        String strDependency = objDependency.getStringCellValue();
				        System.out.print(strtestcaseName);
				        System.out.print(" - ");
				        System.out.print(strExecution);
				        System.out.print(" - ");
				        System.out.print(strBrowser);
				        System.out.print(" - ");
				        System.out.print(strDependency);
				        System.out.print(" - ");
				        lstExecutionsheet = new ArrayList<>();
				        lstExecutionsheet.add(strclassName);
				        lstExecutionsheet.add(strtestcaseName);
				        lstExecutionsheet.add(strExecution);
				        lstExecutionsheet.add(strBrowser);
				        lstExecutionsheet.add(strDependency);
				        mapTestExecution.put(intOrder, lstExecutionsheet);
				        System.out.println(" Execution Map Value: "+mapTestExecution.get(intOrder));
				        System.out.println();
				    }		      
				    workbook.close();
				    inputStream.close();
			    }
			}catch(Exception readTestExecutionException){				
				System.out.println("readTestExecution Method Exception Message: "+readTestExecutionException);
	 			throw new SkipException("Skipping execution - Issue with Test Execution Sheet");
			}	
		}	 	
		 	
//##############################################################################################################################################################
//######### 5. createDetailedReportsFolder (Verifies if there is folder with name Detailed Reports under the project.If No it creates folder with name Detailed Reports. Later it creates
//#########    one folder under it with current date time stamp
//##############################################################################################################################################################
					 
		public String createDetailedReportsFolder(){
			if(!new File("./TestOutput/"+strFolderPath+"/Reports").isDirectory())
				new File("./TestOutput/"+strFolderPath+"/Reports").mkdirs();			
			String strFolder = "./TestOutput/"+strFolderPath+"/Reports";
			return strFolder;
		}
			
//##############################################################################################################################################################
//######### 6. Create Detailed Report Method (Creates a Detailed execution report for each test case with each step execution status Pass or Fail)
//#########    @throws IOException
//##############################################################################################################################################################		 
		
		public String createDetailedReport(String ProjectName, String Browser,String Functionality, String TestCaseName, String strExecutionPath, String strStartTime,String strEndTime, String strExecutionTime,StringBuffer sbTable) throws IOException{
			String resultPath = strExecutionPath + "/"  
		 			+ getCurrentDatenTime("ddMMMyyyy") + "_"
		 			+ getCurrentDatenTime("HHmmss") + "_" + TestCaseName + ".html";  
			
			int year = Calendar.getInstance().get(Calendar.YEAR);
			
			StringBuffer sbReport = new StringBuffer();
			if(strOverallStatus.equalsIgnoreCase("Pass")){
				sbReport.append("<td id='overalltestresult' style='background-color:#43B02A; color:White; font-weight:bold;'>"+strOverallStatus+"</td>");
			}else if(strOverallStatus.equalsIgnoreCase("Blocked")){
				sbReport.append("<td id='overalltestresult' style='background-color:#FFD700; color:White; font-weight:bold;'>"+strOverallStatus+"</td>");
			}else{
				sbReport.append("<td id='overalltestresult' style='background-color:Red; color:White; font-weight:bold;'>"+strOverallStatus+"</td>");
			}
			            
			File file;
			file=new File(resultPath);
			if(!file.exists()){
				file.createNewFile();
				//System.out.println("New file:"+resultPath+ " has been created to the current directory");
				FileWriter fout = new FileWriter(resultPath, true);
				fout.write(
						"<!DOCTYPE html>"
					    +  "<html lang='en'>" 
					    		  + "<head>"	
				                    +"         <META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"
				                    +"         <title>Detailed Execution Report</title>"
				                    +"			<meta name='viewport' content='width=device-width, initial-scale=1'>"
				                    +"			<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>"
				                    +"          </head>"
				                    +"          <body style='padding:5px;'>"
				                    +"		     <div class='container-fluid'>"
				                    +"             <div id='main'>"
				                    +"              <div style='float: left'>"
				                    +"                <img src='data:image/png;base64,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' alt='Logo' style='width:250px;height:55px;'>"     
				                    +"              </div>" 
				                    +"              <div align='right'>"     
				                    +"                <img src='data:image/png;base64,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' alt='Logo' style='height:50px;'>"  
				                    +"                <img src='data:image/png;base64,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' alt='Logo' style='height:50px;'>"    
				                    +"                <img src='data:image/png;base64,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' alt='Logo' style='height:50px;'>"      
				                    +"                <img src='data:image/png;base64,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' alt='Logo' style='height:50px;'>"      
				                    +"                <img src='data:image/png;base64,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' alt='Logo' style='height:50px;'>"      
				                    +"                <img src='data:image/jpg;base64,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' alt='Logo' style='height:50px;' >"     
				                    +"              </div>"                 
				                    +"                          <h2 style=' border-bottom: 3px solid #86BC25;'>"+ProjectName+"</h2>"
					                +"                          <div>"
					                +"							<table id = 'SummaryTable' class='table table-bordered table-responsive' style='border:1.5px solid #86BC25' border='1000px'>"
					                +"							<tbody>"
					                +"							<tr>"
					                +"								<td style='font-weight:bold'>Testcase Name</td>"
									+"								<td id='TestCaseName' colspan=3>"+TestCaseName+"</td>"
					                +"							</tr>"
					                +"							<tr>"
					                +"								<td style='font-weight:bold'>Browser</td>"
					                +"								<td>"+Browser+"</td>"
					                +"								<td style='font-weight:bold'>Functionality</td>"
					                +"								<td>"+Functionality+"</td>"
					                +"							</tr>"
					                +"							<tr>"
					                +"								<td style='font-weight:bold'>Start Time</td>"
					                +"								<td id='StartTime'>"+strStartTime+"</td>"
					                +"								<td style='font-weight:bold'>End Time</td>"
					                +"								<td id='EndTime'>"+strEndTime+"</td>"					             
					                +"							</tr>"
					                +"							<tr>"
					                +"								<td style='font-weight:bold'>Execution Time (HH:MM:SS)</td>"
					                +"								<td id='ExecutionTime'>"+strExecutionTime+"</td>"
					                +"								<td style='font-weight:bold'>Overall Status</td>"
					                +sbReport
					                +"							</tr>"					                
					                +"							</tbody>"
					                +"							</table>"
					                +"                          </div>"
					                +"							<table id = 'ReportTable' class='table table-bordered table-responsive' width='100%'>"
					                +"							<thead style='background-color:#D0D0CE'>"
					                +"                          <tr>"
					                +"                                          <th>SNo</th>"
					                +"                                          <th>Action</th>"
					                +"                                          <th>Object Name</th>"
					                +"                                          <th>Input Value</th>"
					                +"                                          <th>Expected Result</th>"
					                +"                                          <th>Actual Result</th>"
					                +"                                          <th>Status</th>"
					                +"                          </tr>"
					                +"							</thead>"
					                +sbTable
					                +"							</table>"	
					                +"						    <footer id='foot01'></footer>"
					                +"							</div>"
					                +"                          <p>Copyright &copy; "+ year + " BSA Automation CoP. All rights reserved.</p>"
					                +"							</div>"
					                +"							</body>"
					                +"							</html>"		
					     );				                        
				fout.close();
				sbTable.delete(0, sbTable.length());
				sbDetailedReport.delete(0, sbDetailedReport.length());
				detailedreportflag=true;
			}
			else{
				System.out.println("Detailed report file already exists");
			}		
			IEPath=resultPath;
			return resultPath;
		}
		
//##############################################################################################################################################################
//######### 7. RunTestNGTest Method
//##############################################################################################################################################################		 
		
		public void runTestNGTest(String browsernamevalue, String SuiteName, String TestName, String testCasePath,String methodname) {
		
			try{
				//This Map can hold your testing Parameters.
				System.out.println("Browser : "+browsernamevalue);
				System.out.println("Suite : "+SuiteName);
				System.out.println("Test Case : "+testCasePath);
				System.out.println("Method Name: "+methodname);
				Map<String,String> testngParams = new HashMap<String,String> ();
				//Map<String,String> testngParams1 = new HashMap<String,String> ();
				testngParams.put("browsername", browsernamevalue);
				//testngParams1.put("tcname", browsernamevalue);
				//Create an instance on TestNG
				TestNG myTestNG = new TestNG();
				 
				//Create an instance of XML Suite and assign a name for it.
				XmlSuite mySuite = new XmlSuite();
				mySuite.setName(SuiteName);
				 
				//Create an instance of XmlTest and assign a name for it.
				XmlTest myTest = new XmlTest(mySuite);
				myTest.setName(TestName);
				 
				//Add any parameters that you want to set to the Test.
				myTest.setParameters(testngParams);
				//myTest.setParameters(testngParams1);
				 
				//Create a list which can contain the classes that you want to run.
				//List<XmlClass> myClasses = new ArrayList<XmlClass> ();
				//myClasses.add(new XmlClass(testCasePath));
				 
				//methodsToRun
				//setExcludedMethods();
				 
				List<XmlClass> myClasses = new ArrayList<XmlClass> ();
				XmlClass xmlclass = new XmlClass(testCasePath);
	
				List<XmlInclude> includedMethods = new ArrayList<XmlInclude>();
				//List<XmlExclude> excludedMethods = new ArrayList<XmlExclude>();
	
				includedMethods.add(new XmlInclude(methodname));
				//includedMethods.add(new XmlInclude("method2"));
				//includedMethods.add(new XmlInclude("method3"));
				//excludedMethods.add(new XmlInclude("method4"));
				xmlclass.setIncludedMethods(includedMethods);
				//xmlclass.setExcludedMethods(excludedMethods);
	
				myClasses.add(xmlclass);
							
				//Assign that to the XmlTest Object created earlier.
				myTest.setXmlClasses(myClasses);
				 
				//Create a list of XmlTests and add the Xmltest you created earlier to it.
				List<XmlTest> myTests = new ArrayList<XmlTest>();
				myTests.add(myTest);			 
				 
				//add the list of tests to your Suite.
				mySuite.setTests(myTests);
				 
				//Add the suite to the list of suites.
				List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
				mySuites.add(mySuite);
				 
				//Set the list of Suites to the testNG object you created earlier.
				myTestNG.setXmlSuites(mySuites);
				 
				//invoke run() - this will run your class.
				myTestNG.run();
				myClasses.clear();
				includedMethods.clear();
				myTests.clear();
				mySuites.clear();
			}catch(Exception ex){
				System.out.println("RunTestNG exception occured " + ex.getStackTrace());
			}
		}
		
//##############################################################################################################################################################
//######### 8. getCreateSummary method - Gets summary from the Detailed reports created from execution of each test case for creating a summary report
//##############################################################################################################################################################				

        public void getCreateSummary(String ProjectName, String strExecutionPath, String SuiteType, String strEnvironment) throws Exception{
        	System.out.println("Creating summary report...");
        	File directory = new File(strExecutionPath);
        	File[] fList = directory.listFiles();
            int intPassCount=0, intFailCount=0, intBlockCount=0, intExecutionCount=0;
            Document doc = null;
            String flags = null;
            StringBuffer sbHTML = new StringBuffer();
            for (File file : fList){
                String strFileName = file.getName();
                doc = Jsoup.parse(file, "UTF-8");
                Elements elementsStatus = doc.select("td#Status");
                String DetailReportfilePath="./"+strFileName;
                String strStartTime = doc.select("td#StartTime").first().text();
                String strEndTime = doc.select("td#EndTime").first().text();
                String strExecTime = doc.select("td#ExecutionTime").first().text();
                String strTestcaseName = doc.select("td#TestCaseName").first().text();                                  
                String strStatus = doc.select("td#overalltestresult").first().text();
                if(strStatus.equalsIgnoreCase("pass")){
                	flags ="Pass";
                }else if(strStatus.equalsIgnoreCase("blocked")){
                	flags="Blocked";
                    break;
                }else{
                	flags="Fail";
                    break;
                }   
                
                if (flags=="Pass"){
                    intPassCount = intPassCount+1;
                }else if(flags=="Fail"){
                	intFailCount = intFailCount+1;
                }else{
                	intBlockCount = intBlockCount+1;
                }
                
                StringBuffer statusbuffer=new StringBuffer();
                if(flags.equalsIgnoreCase("Pass")){
                	statusbuffer.append("<td style='background-color:#43B02A; color:White;'><a href='"+DetailReportfilePath+"'>"+flags+"</a></td>");
    			}else if(flags.equalsIgnoreCase("Blocked")){
    				statusbuffer.append("<td style='background-color:#FFD700; color:White;'><a href='"+DetailReportfilePath+"'>"+flags+"</a></td>");
    			}else{
    				statusbuffer.append("<td style='background-color:Red; color:White;'><a href='"+DetailReportfilePath+"'>"+flags+"</a></td>");
    			}
                sbHTML.append("    <tr>"
                              +"      <td>1</td>"
                              +"      <td>"+strTestcaseName+"</td>"
                              +"      <td>"+strStartTime+"</td>"
                              +"      <td>"+strEndTime+"</td>"
                              +"      <td>"+strExecTime+"</td>"
                              +statusbuffer
                              +"   </tr>");
                
                sumExecutionTime(strExecTime);                
            }
            intExecutionCount = intPassCount+intFailCount+intBlockCount;

            int[] arrStatus = {intPassCount, intFailCount,intBlockCount, intExecutionCount};
            
            if(intExecutionCount>0){
            	intTcsExecutedCount=intExecutionCount;
            	if(intFailCount>0){
            		strExecutionStatus="FAIL";
            	}else{
            		strExecutionStatus="PASS";
            	}            		
            }
            
            createSummaryReport(ProjectName, SuiteType, strEnvironment, strExecutionPath, sbHTML, arrStatus);
        }
		
//##############################################################################################################################################################
//######### 9. createSummaryReport method - creates summary report of all the test cases executed in the suite
//##############################################################################################################################################################				
				
		public void createSummaryReport(String ProjectName, String SuiteType, String Environment, String strExecutionPath, StringBuffer masterTable, int[] arrStatus) throws IOException{
			String resultPath = strExecutionPath + "/"+ "SummaryReport_"
					+ ProjectName + "_"
					+ strFolderPath + ".html"; 

			int year = Calendar.getInstance().get(Calendar.YEAR);
			
			File file;
			file=new File(resultPath);
			if(!file.exists()){
				file.createNewFile();
				FileWriter fout = new FileWriter(resultPath, true);
	            fout.write("  <!DOCTYPE html>"
	                       +" <html lang='en'>" 
	                       +"  <head>"       
	                       +"         <META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"
	                       +"         <title>Summary Report</title>"
	                       +"         <script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>"
	                       +"		  <style>#main{background-color:#FFF;border-radius:0 0 5px 5px}h1{font-family:Georgia,serif;border-bottom:3px solid #0F0;color:#960;font-size:30px}table{width:100%}table#'ReportTable',td#'ReportTable',th#'ReportTable'{border:1px solid lightblue;border-collapse:collapse;padding:5px}table#'SummaryTable',td#'SummaryTable',th#'SummaryTable'{style=border:10px solid black;background-color:white;border-collapse:collapse;padding:5px;border-style: solid;border-width: 2px 10px 4px 20px;}h4{width:400px}th{text-align:left}#SummaryTable tr:nth-child(even){background-color:#fff}#SummaryTable tr:nth-child(odd){background-color:#fff}#SummaryTable td:nth-child(odd){background-color:#fff}.pass{color:#fff;background-color:#43B02A}.fail{color:#fff;background-color:red} a{color:white !important;text-decoration: underline;}; a:link{color:white !important;text-decoration: underline;} ; a:visited{color:white !important; text-decoration: underline;}; a:hover{color:white !important;text-decoration: underline;}</style>"
	                       +"         <script src='http://code.jquery.com/jquery-1.9.1.js'> </script>"
	                       +"         <meta name='viewport' content='width=device-width, initial-scale=1'>"
	                       +"         <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>"
	                       +"         <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>"                             
	                       +"         <script type='text/javascript'>google.charts.load('current', {'packages':['corechart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = new google.visualization.DataTable();data.addColumn('string', 'Status');data.addColumn('number', 'Count');data.addRow(['Pass', "+arrStatus[0]+"]);data.addRow(['Fail', "+arrStatus[1]+"]);data.addRow(['Blocked', "+arrStatus[2]+"]);var options = {'title':'Execution Summary',colors: ['#43B02A', 'red', '#FFD700']};var chart = new google.visualization.PieChart(document.getElementById('piechart'));chart.draw(data, options);}</script>"
	                       +"  </head>"
	                       +"  <body style='padding:5px;'>"
	                       +"   <div class='container-fluid'>"
	                       +"    <div id='main'>"
	                       +"     <div style='float: left'>"
	                       +"       <img src='data:image/png;base64,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' alt='Logo' style='width:250px;height:55px;'>"     
	                       +"     </div>" 
	                       +"     <div align='right'>"     
	                       +"      <img src='data:image/png;base64,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' alt='Logo' style='height:50px;'>"  
	                       +"      <img src='data:image/png;base64,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' alt='Logo' style='height:50px;'>"    
	                       +"      <img src='data:image/png;base64,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' alt='Logo' style='height:50px;'>"      
	                       +"      <img src='data:image/png;base64,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' alt='Logo' style='height:50px;'>"      
	                       +"      <img src='data:image/png;base64,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' alt='Logo' style='height:50px;'>"      
	                       +"      <img src='data:image/jpg;base64,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' alt='Logo' style='height:50px;' >"     
	                       +"     </div>"                 
	                       +"     <h2 style='border-bottom: 3px solid #86BC25;'>Summary Report</h2>"
	                       +"     <h3>"+ProjectName+"</h3>"
	                       +"     <br/>"
	                       +"     <table style='border:0'><tbody><tr><td align='top' style='vertical-align:top'>" 
	                       +"      <div style='background-color:white;vertical-align:top;'>"                 
	                       +"       <table id = 'SummaryTable' class='table table-bordered table-responsive' style='border:1.5px solid #86BC25' border='1000px'>"
	                       +"        <tbody>"
	                       +"         <tr><td style='font-weight:bold'>Execution Suite </td> <td>"+SuiteType+"</td></tr>"
	                       +"         <tr><td style='font-weight:bold'>Execution Environment </td> <td>"+Environment+"</td></tr>"
	                       +"         <tr><td style='font-weight:bold'>Number of Testcases Executed </td> <td>"+arrStatus[3]+"</td></tr>"
	                       +"         <tr><td style='font-weight:bold'>Testcases Pass Count </td> <td>" + arrStatus[0] +"</td></tr>"
	                       +"         <tr><td style='font-weight:bold'>Testcases Fail Count </td> <td>" + arrStatus[1] +"</td></tr>"
	                       +"         <tr><td style='font-weight:bold'>Testcases Blocked Count </td> <td>" + arrStatus[2] +"</td></tr>"
	                       +"         <tr><td style='font-weight:bold'>Execution Date </td> <td>"+strExecutionDate+"</td></tr>"
	                       +"         <tr><td style='font-weight:bold'>Overall Execution Time (HH:MM:SS)</td> <td>"+iHours+":"+iMinutes+":"+iSeconds+"</td></tr>"
	                       +"        </tbody>"
	                       +"       </table>"
	                       +"      </div>"
	                       +"      </td>"
	                       +"      <td align='right' style='vertical-align:top'>"
	                       +"       <div id='piechart' style='width: 600px; height: 310px;'></div>"
	                       +"      </td></tr></tbody></table>"
	                       +"      <table id = 'ReportTable' class='table table-bordered table-responsive'>"
	                       +"       <thead style='background-color:#D0D0CE'>"
	                       +"        <tr>"
	                       +"         <th>SNo</th>"
	                       +"         <th>Testcase Name</th>"
	                       +"         <th>Start Time</th>"
	                       +"         <th>End Time</th>"
	                       +"         <th>Execution Time (HH:MM:SS)</th>"
	                       +"         <th>Status</th>"
	                       +"        </tr>"
	                       +"       </thead>"+ masterTable+"</table>"            
	                       +"      <footer id='foot01'></footer>"
	                       +"     </div>"	                       
	                       +"     <p>Copyright &copy; "+ year + " BSA Automation CoP. All rights reserved.</p>"
			               +"    </div>"
	                       +"   </body>"
	                       +"  </html>"                             
                          );                                                                                 
	            fout.close();
	           				 
			    System.out.println("Summary Report Path  :"+resultPath);
			    System.out.println();
			    
			    strSummaryReportName=resultPath;
			}
			else{
				System.out.println("Summary Report File already exists");
			}			
		}		
		 
//##############################################################################################################################################################
//######### 10. Invokes DRIVER, Before and After Methods
//##############################################################################################################################################################
		
		@BeforeMethod
		@Parameters ({"browsername"})
		public void startBrowser(String browsername) throws IOException{
			try{
				if(browsername.equalsIgnoreCase("ie")){
					DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
					if(strHtml5Application.equalsIgnoreCase("yes")){
						capab.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://www.google.com");
					}
					capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					capab.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					System.setProperty("webdriver.ie.driver","./Assets/IEDriverServer.exe");
					Driver = new InternetExplorerDriver(capab);		
					Driver.manage().window().maximize();
					Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
				else if(browsername.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver","./Assets/chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
				    options.addArguments("test-type");
				    Driver = new ChromeDriver(options);
				    Driver.manage().window().maximize();
				    Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			    
				}
				else if(browsername.equalsIgnoreCase("firefox")){
					System.setProperty("webdriver.gecko.driver", "./Assets/geckodriver.exe");
					Driver = new FirefoxDriver();		
				    //Driver.manage().window().maximize();
				    Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
				else if(browsername.equalsIgnoreCase("edge")){
					System.setProperty("webdriver.edge.driver", "./Assets/MicrosoftWebDriver.exe");
					Driver = new EdgeDriver();
				    Driver.manage().window().maximize();
				    Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
				else{
					throw new SkipException("Skipping execution - Browser parameter is incorrect - "+browsername);
		    	}
			}catch (Exception driverException){
				System.out.println("Before Method Exception Message: "+driverException);
				logResult(IEPath, "LaunchDriver", "Driver", "NA", "Driver should be launched", "Driver launch Failed", "Fail","");			
			}
		}
				
		@AfterMethod
		public void stopBrowser() throws Exception {
			//Thread.sleep(2000);
			if(strDriverType.equalsIgnoreCase("ie")){
				Driver.quit();
				Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");			
			}else if(strDriverType.equalsIgnoreCase("chrome")){
				Driver.quit();
				Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");			
			}else if(strDriverType.equalsIgnoreCase("firefox")){
				Driver.quit();
				Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");			
			}else if(strDriverType.equalsIgnoreCase("edge")){
				Driver.quit();
				Runtime.getRuntime().exec("taskkill /F /IM MicrosoftEdge.exe");			
			}else{
				Driver.quit();
				Driver.close();
			}
				
		}
				
//##############################################################################################################################################################
//######### 11. CaptureScreenshot method - captures screenshot and returns path of the screenshot location
//##############################################################################################################################################################				
				
		public String captureScreenshot(String strScreenshotName){
			String strScreenshotpath="";
			try{
				if(!new File("./TestOutput/"+strFolderPath+"/Screenshots").isDirectory())
				 new File("./TestOutput/"+strFolderPath+"/Screenshots").mkdirs();
				
				strScreenshotpath = "./TestOutput/"+strFolderPath+"/Screenshots/"+ strScreenshotName +"_"+ getCurrentDatenTime("ddMMMyyyy") + "_"
					 			+ getCurrentDatenTime("HHmmss")+ ".png";  
				
				File file;
				File objFile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
				file=new File(strScreenshotpath);
				strScreenshotpath=file.getAbsolutePath();				
				if(!file.exists()){
					//file.createNewFile();
					FileUtils.copyFile(objFile, file);
				}
				else{
					System.out.println("Screenshot name already exists");
					FileUtils.copyFile(objFile, file);
				}
				
				return strScreenshotpath;	
			}catch(Exception captureScreenshotMethodException){
				System.out.println("Error occured while taking screenshot");
				System.out.println("captureScreenshot Method Exception Messgae : "+captureScreenshotMethodException.getMessage());
				return strScreenshotpath;
			}		
		}


//##############################################################################################################################################################
//######### 12. logResult method (Logs the results to the output report)
//##############################################################################################################################################################
				 	 
		public void logResult(String Path, String Action, String Element, String Value, String ExpectedBehavior, String ActualBehavior, String Result, String strPath) throws IOException{
			sbDetailedReport.append(" <tr>"
						  +"              <td>"+intSNo+"</td>"
			              +"              <td>"+Action+"</td>"
			              +"              <td>"+Element+"</td>"
			              +"              <td>"+Value+"</td>"
			              +"              <td>"+ExpectedBehavior+"</td>"
			              +"              <td>"+ActualBehavior+"</td>"
			);
			
			if(Result.equalsIgnoreCase("Pass")){				
				sbDetailedReport.append("     <td id ='Status' style='background-color:#43B02A; color:White;'>"+Result+"</td>"
			              +"          </tr>"
			    );
			}else if(Result.equalsIgnoreCase("Blocked")){
				sbDetailedReport.append("     <td id ='Status' style='background-color:#FFD700; color:White;'>"+Result+"</td>"
			              +"          </tr>"
			    );
			}else{
				strOverallStatus="Fail";
				if(strPath.equalsIgnoreCase("")){
					sbDetailedReport.append("     <td id ='Status' style='background-color:Red; color:White;'>"+Result+"</td>"
				              +"          </tr>"
				    );					
				}else{
					sbDetailedReport.append("     <td id ='Status' style='background-color:Red;'><a style='color:White;' href='"+strPath+"'><u>"+Result+"</u></a></td>"
				              +"          </tr>"
				    );
				}				
			}
			intSNo=intSNo+1;
		}
					
//##############################################################################################################################################################
//########## 13. getExcelSheet method - To Read Excel file
//##############################################################################################################################################################

		public Sheet getExcelSheet(String sheetName) throws IOException{
			//Create a object of File class to open xlsx file			 
		    File file =    new File("./Assets"+"\\"+"Recursive_TestData.xlsx");		 
		    //Create an object of FileInputStream class to read excel file		 
		    FileInputStream inputStream = new FileInputStream(file);	 
		    //Workbook TestDataWorkbook = null;	
		    Workbook TestDataWorkbook = new XSSFWorkbook(inputStream);
		    Sheet TestDataSheet = TestDataWorkbook.getSheet(sheetName);
		    TestDataWorkbook.close();
			return TestDataSheet; 
		    /*
		    //Find the file extension by spliting file name in substring and getting only extension name	 
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));	 
		    //Check condition if the file is xlsx file	 
		    if(fileExtensionName.equals(".xlsx")){	 
		    	//If it is xlsx file then create object of XSSFWorkbook class	 
		    	TestDataWorkbook = new XSSFWorkbook(inputStream);	 
		    }		 
			//Check condition if the file is xls file
			else if(fileExtensionName.equals(".xls")){
				//If it is xls file then create object of XSSFWorkbook class
			   	TestDataWorkbook = new HSSFWorkbook(inputStream);
			}
			*/
			//Read sheet inside the workbook by its name			      
		}
		
//##############################################################################################################################################################
//########## 14. TestData method
//##############################################################################################################################################################
				
		public String TestData(Sheet TestDataSheet, int rowno , String ColumnName){
			String strCellValue="";
			Row rowheader = TestDataSheet.getRow(0);
			int colCount = rowheader.getLastCellNum();
					    
			for (int j = 0; j < colCount; j++) {
			   	Cell cellValue = rowheader.getCell(j);
		       	cellValue.setCellType(Cell.CELL_TYPE_STRING);
		       	String a1 = cellValue.toString();
		        if (a1.equals(ColumnName)){
		           	cellno = j;
			        Row row = TestDataSheet.getRow(rowno);
			      	Cell cellValue1 = row.getCell(cellno);
	    	       	cellValue1.setCellType(Cell.CELL_TYPE_STRING);
	    	       	strCellValue = cellValue1.toString();
	    	       	break;	
		        }
			}
			return strCellValue;	        
		}

//##############################################################################################################################################################
//########## 15. TestData method - overridden method for row number and column number
//##############################################################################################################################################################
						
		public String TestData(Sheet TestDataSheet, int rowno, int colno){
			String strCellValue="";
			
			Row row = TestDataSheet.getRow(rowno);
			Cell cell = row.getCell(colno);
			strCellValue =cell.getStringCellValue();
			
			return strCellValue;	        
		}
		
//##############################################################################################################################################################
//########## 16. Get total sum of the execution time of individual test case
//##############################################################################################################################################################	
			
		public void sumExecutionTime(String strTime){
			int irem=0;
			int iquo=0;
			if(strTime.trim().length() > 0){
				String[] arrStr=strTime.split(":");
				iHours=iHours+Integer.parseInt(arrStr[0]);
				iMinutes=iMinutes+Integer.parseInt(arrStr[1]);
				iSeconds=iSeconds+Integer.parseInt(arrStr[2]);
				if(iSeconds>60){
					irem=iSeconds%60;
					iquo=iSeconds/60;
					iSeconds=irem;
					iMinutes=iMinutes+iquo;
				}
				
				if(iMinutes>60){
					irem=iMinutes%60;
					iquo=iMinutes/60;
					iMinutes=irem;
					iHours=iHours+iquo;
				}				
			}			 
		}
			
//##############################################################################################################################################################
//########## 17. getElementLocator Method (Locates the object by the given method like xpath etc.)
//##############################################################################################################################################################
			
		public By getElementLocator(String ObjectName) throws IOException{
			List<String> getLocator = mapObjectRepository.get(ObjectName);
			String strLocatorType = getLocator.get(0);
			System.out.println("Selected Locator Type: "+getLocator.get(0));
			System.out.println("Selected Locator Value: "+getLocator.get(1));
			String strLocatorValue=null;
			switch(strLocatorType.toLowerCase()){
					
				case "xpath":
					ElementLocator = By.xpath(getLocator.get(1));
					break;
				case "id":
					ElementLocator = By.id(getLocator.get(1));
					break;
				case "cssselector":
					ElementLocator = By.cssSelector(getLocator.get(1));
					break;
				case "linktext":
					ElementLocator = By.linkText(getLocator.get(1));
					break;
				case "name":
					ElementLocator = By.name(getLocator.get(1));
					break;
				case "tagname":
					ElementLocator = By.tagName(getLocator.get(1));
					break;
				case "partiallinktext":
					ElementLocator = By.partialLinkText(getLocator.get(1));
					break;
				case "classname":
					ElementLocator = By.className(getLocator.get(1));
					break;
				case "xpath+data":
					strLocatorValue = getLocator.get(1);
					ElementLocator = By.xpath(AppendOR(strLocatorValue));
					break;
				case "id+data":
					strLocatorValue = getLocator.get(1);
					ElementLocator = By.id(AppendOR(strLocatorValue));
					break;
				case "cssselector+data":
					strLocatorValue = getLocator.get(1);
					ElementLocator = By.cssSelector(AppendOR(strLocatorValue));
					break;
				case "linktext+data":
					strLocatorValue = getLocator.get(1);
					ElementLocator = By.linkText(AppendOR(strLocatorValue));
					break;
				case "name+data":
					strLocatorValue = getLocator.get(1);
					ElementLocator = By.name(AppendOR(strLocatorValue));
					break;
				case "tagname+data":
					strLocatorValue = getLocator.get(1);
					ElementLocator = By.tagName(AppendOR(strLocatorValue));
					break;
				case "partiallinktext+data":
					ElementLocator = By.partialLinkText(AppendOR(strLocatorValue));
					break;
				case "classname+data":
					strLocatorValue = getLocator.get(1);
					ElementLocator = By.className(getLocator.get(1));
					break;
				default:
					ElementLocator = By.xpath(getLocator.get(1));
			}
			return ElementLocator;
		}
			
//##############################################################################################################################################################
//########## 18. AppendOR Method
//##############################################################################################################################################################
			
		public String AppendOR(String strValue) throws IOException{
			String[] strSplittedValues = strValue.split("%");
			//System.out.println(strSplittedValues.length);
			String strNewLocatorValue = "";
			for(int i=0; i<strSplittedValues.length;i++){			
				if(i%2==0){
					strNewLocatorValue= strNewLocatorValue+strSplittedValues[i];
				}
				else{
					if (mapTestData.containsKey(strSplittedValues[i])){
						strNewLocatorValue = strNewLocatorValue+mapTestData.get(strSplittedValues[i]);
					}
					else{
						strNewLocatorValue= strNewLocatorValue+strSplittedValues[i];
						logResult(IEPath, "ElementLocator", strValue , "NA", "NA", "Unable to find test data referance for locator", "Fail","");
					}
				}
			}		
			//System.out.println(strNewLocatorValue);
			return strNewLocatorValue;
		}
			
//##############################################################################################################################################################
//########## 19. getTestData Method
//##############################################################################################################################################################

		public String getTestData(String TestDataName){
			String strDataValue = mapTestData.get(TestDataName);
			String strNewValue="";
			//System.out.println("Selected Locator: "+mapTestData.get(0));
			//System.out.println("Selected Locator: "+mapTestData.get(1));
			if (strDataValue!=null){
				if(strDataValue.contains("%%")){
			    	String[] strsplitarray=strDataValue.split("%%");
			    	for (int i=0; i<strsplitarray.length; i++)
			    	{
			    		if (mapTestData.containsKey(strsplitarray[i])){
			    			strNewValue = strNewValue+mapTestData.get(strsplitarray[i]);
						}else{
							strNewValue= strNewValue+strsplitarray[i];
						}
			    	}
			    	strDataValue=strNewValue;
			    }
				return strDataValue;
			}
			else{
				return TestDataName;
			}
		}	
		
//##############################################################################################################################################################
//########## 20. updateTestDataTimeStamp Method - Updates the runtime time stamp in test data values  
//##############################################################################################################################################################

		public void updateTestDataTimeStamp() throws Exception{
			for (Map.Entry<String, String> entry : mapTestData.entrySet()) {
			    String strKey = entry.getKey();
			    String strValue = entry.getValue();
			    String strNewValue="";
			    if(strValue.contains("%%")){
			    	System.out.println("**************************************** Updating Test Data TimeStamp **********************************************");					
			    	String[] strsplitarray=strValue.split("%%");
			    	for (int i=0; i<strsplitarray.length; i++)
			    	{
			    		if (mapTestData.containsKey(strsplitarray[i])){
			    			strNewValue = strNewValue+"%%"+strsplitarray[i]+"%%";
						}else{
							if(strsplitarray[i].equalsIgnoreCase("timestamp")){
								String strTime=getCurrentDatenTime("ddMMMyyyy")+ "_"+ getCurrentDatenTime("HHmmss");
								strNewValue = strNewValue+strTime;
							}else{	
								strNewValue= strNewValue+strsplitarray[i];
							}
						}
			    	}
			    	System.out.println("Key : "+ strKey + " - Old Value : " + strValue + " - Updated Value : "+strNewValue);
			    	mapTestData.put(strKey, strNewValue);
			    }			    
			}
			System.out.println();
		}

//##############################################################################################################################################################
//########## 21. readExecutionProperties Method - Read values from Execution Property file and return values to executeTestSuite method
//##############################################################################################################################################################

		public String[] readExecutionProperties() throws Exception{
			try{
				Properties prop = new Properties();
				String execParameters[] = new String[14];
				String fileName = "Assets/Execution.config";            
				InputStream ins = new FileInputStream(fileName);

				if (ins != null){            	
					prop.load(ins);
				    String strProjectName=prop.getProperty("ProjectName");
				    String strSuite=prop.getProperty("Suite");
				    String strEnvironment=prop.getProperty("Environment");
				    String strSendReportEmail=prop.getProperty("SendReportEmail").toLowerCase();
				    String strToEmail=prop.getProperty("To");
				    String strCCEmail=prop.getProperty("CC");
				    String strSendAllReportsEmail=prop.getProperty("SendAllReportsEmail").toLowerCase();
				    String strHtml5Application=prop.getProperty("Html5Application").toLowerCase();
				    String strBatchExecution=prop.getProperty("BatchExecution").toLowerCase();
				    String strDevSMTPServer=prop.getProperty("DevSMTPServer").toLowerCase();
				    String strIntSMTPServer=prop.getProperty("IntSMTPServer").toLowerCase();
				    String strQaSMTPServer=prop.getProperty("QaSMTPServer").toLowerCase();
				    String strStageSMTPServer=prop.getProperty("StageSMTPServer").toLowerCase();
				    String strProdSMTPServer=prop.getProperty("ProdSMTPServer").toLowerCase();
				    
				    if (strProjectName==null || strSuite==null || strEnvironment==null || strSendReportEmail==null || strToEmail==null || strCCEmail==null ||strSendAllReportsEmail==null || strHtml5Application==null || strBatchExecution==null || strDevSMTPServer==null || strIntSMTPServer==null || strQaSMTPServer==null || strStageSMTPServer==null || strProdSMTPServer==null){
				    	
				    	if(strProjectName==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - Project Name Key is missing in Property File");
				    	}
				    	if(strSuite==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - Suite Key is missing in Property File");
			            }
				    	if(strEnvironment==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - Environment Key is missing in Property File");
			            } 
				    	if(strSendReportEmail==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - SendReportEmail Key is missing in Property File");
			            }
				    	if(strToEmail==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - To Key is missing in Property File");
			            }
				    	if(strCCEmail==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - CC Key is missing in Property File");
			            }
				    	if(strSendAllReportsEmail==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - SendAllReportsEmail Key is missing in Property File");
			            }
				    	if(strHtml5Application==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - Html5Application Key is missing in Property File");
			            }
				    	if(strBatchExecution==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - BatchExecution Key is missing in Property File");
			            }
				    	if(strDevSMTPServer==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - DevSMTPServer Key is missing in Property File");
			            }
				    	if(strIntSMTPServer==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - IntSMTPServer Key is missing in Property File");
			            }
				    	if(strQaSMTPServer==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - QaSMTPServer Key is missing in Property File");
			            }
				    	if(strStageSMTPServer==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - StageSMTPServer Key is missing in Property File");
			            }
				    	if(strProdSMTPServer==null){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - ProdSMTPServer Key is missing in Property File");
			            }
			            	
				    }else if(strProjectName.contentEquals("") || strSuite.contentEquals("") || strEnvironment.contentEquals("") || (strSendReportEmail.contentEquals("y") && strToEmail.contentEquals("")) || (strSendReportEmail.contentEquals("yes") && strToEmail.contentEquals(""))){
					        	
				    	if(strProjectName.contentEquals("")){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - Project Name parameter does not contain any value");
				    	}else if(strSuite.contentEquals("")){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - Suite parameter does not contain any value");
				    	}else if(strEnvironment.contentEquals("")){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - Environment parameter does not contain any value");
				    	}else if(strToEmail.contentEquals("")){
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - To parameter does not contain any value");
				    	}else{
				    		throw new SkipException("Skipping execution - Issue with Execution Property File - Parameters does not contain any value");
				    	}    	
			            	
			        }else{           	
			        	execParameters[0] = strProjectName;
			        	execParameters[1] = strSuite;
			        	execParameters[2] = strEnvironment;
			        	execParameters[3] = strSendReportEmail;
			        	execParameters[4] = strToEmail;
			        	execParameters[5] = strCCEmail;
			        	execParameters[6] = strSendAllReportsEmail;
			        	execParameters[7] = strHtml5Application;
			        	execParameters[8] = strBatchExecution;
			        	execParameters[9] = strDevSMTPServer;
			        	execParameters[10]= strIntSMTPServer;
			        	execParameters[11]= strQaSMTPServer;
			        	execParameters[12]= strStageSMTPServer;
			        	execParameters[13]= strProdSMTPServer;
			        }
				}            	
				return execParameters;
		        
			}catch (Exception readExecutionPropertiesException){
				System.out.println("readExecutionProperties Method Exception Message: "+readExecutionPropertiesException);
				throw new SkipException("Skipping execution - Issue with Execution Property File");
			}
		}
		
//##############################################################################################################################################################
//########## 22. sendReportEmail Method - Zip the Generated Reports folder and send an Email along with the attachment
//##############################################################################################################################################################
		
		public void sendReportEmail(String batchExecution,String strServername, String ProjectName, String strTo, String strCC, String strReportPath, String strStatus) throws Exception{
			
			try {	
				String zipFilePath="./TestOutput/"+strFolderPath+"/Reports/";
		    	String zipFileName = "./TestOutput/"+strFolderPath+"/"+strFolderPath + "_Reports.zip";
		    	String zipFilePath1 = new File(zipFileName).getAbsolutePath();
		    	
		    	String LogFilepath="./TestOutput/"+strFolderPath+"/Logs_"+strFolderPath+".txt";
		    	
		    	ZipUtil.pack(new File(zipFilePath), new File(zipFileName));
		    	
				ZipUtil.addEntry(new File(zipFileName), "./Log/Logs_"+strFolderPath+".txt", new File(LogFilepath));
				
				System.out.println("Zip created successfully");
								
				File file1=new File("Assets/SendEmail.vbs");
				String strScriptPath=file1.getAbsolutePath();				
				
				if(strCC.equals("")){
					strCC="None";
				}
				
				if(strStatus.equals("")){
					strStatus="None";
				}
				
				final List<String> commands = new ArrayList<String>();                
		        commands.add("cscript");
		        commands.add("\""+strScriptPath+"\"");
		        commands.add("\""+ProjectName+"\"");
		        commands.add("\""+strStatus+"\"");
		        commands.add("\""+strTo+"\"");
		        commands.add("\""+strCC+"\"");
		        commands.add("\""+zipFilePath1+"\"");
		        commands.add("\""+strServername+"\"");
		        commands.add("\""+batchExecution+"\"");
		        ProcessBuilder builder = new ProcessBuilder(commands);
		    	builder.redirectErrorStream(true);
		    	Process p = builder.start();
		    	BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    	String line;
		    	while (true) {
		    		line = r.readLine();
		    		if (line == null) { break; }
		    		System.out.println(line);
		        }
		    	
		    	System.out.println();
		    	System.out.println("**********************************************************************************************************");
			
			}catch (Exception sendReportEmailException){
				System.out.println("sendReportEmail Method Exception Message: "+sendReportEmailException);
			}
		}

//##############################################################################################################################################################
//########## 23. sendSummaryReportEmail Method - send an Email along with the Summary report as attachment
//##############################################################################################################################################################
				
		public void sendSummaryReportEmail(String batchExecution, String strServername, String ProjectName, String strTo, String strCC, String strReportPath, String strStatus) throws Exception{
					
			try {	
				String filePath = new File(strSummaryReportName).getAbsolutePath();
				    	
				File file1=new File("Assets/SendEmail.vbs");
				String strScriptPath=file1.getAbsolutePath();				
						
				if(strCC.equals("")){
					strCC="None";
				}
						
				if(strStatus.equals("")){
					strStatus="None";
				}
						
				final List<String> commands = new ArrayList<String>();                
				commands.add("cscript");
				commands.add("\""+strScriptPath+"\"");
		        commands.add("\""+ProjectName+"\"");
		        commands.add("\""+strStatus+"\"");
		        commands.add("\""+strTo+"\"");
		        commands.add("\""+strCC+"\"");
				commands.add("\""+filePath+"\"");
				commands.add("\""+strServername+"\"");
				commands.add("\""+batchExecution+"\"");
				ProcessBuilder builder = new ProcessBuilder(commands);
				builder.redirectErrorStream(true);
				Process p = builder.start();
				BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line;
				while (true) {
					line = r.readLine();
					if (line == null) { break; }
						System.out.println(line);
				}
				    	
				System.out.println();
				System.out.println("**********************************************************************************************************");
					
			}catch (Exception sendSummaryReportEmailException){
				System.out.println("sendSummaryReportEmail Method Exception Message: "+sendSummaryReportEmailException);
			}
		}
		
//##############################################################################################################################################################
//########## 24. checkDependency Method - checks dependency of test cases and returns whether to execute or to skip
//##############################################################################################################################################################
						
		public boolean checkDependency(String strDependency){			
			String[] splitArray = null;
			int iLength=0;
			boolean skipflag=false;
			if(strDependency.contains(";")){
				splitArray= strDependency.split(";");
				iLength=splitArray.length;
			}else if (strDependency.contains(",")){
				splitArray = strDependency.split(",");	
				iLength=splitArray.length;
			}else{
				iLength=0;
			}
			
			String strStatus="";
			if(iLength ==1){
				strStatus=mapTestExecutionStatus.get(splitArray[0]);
				System.out.println("Dependent TestCase : "+splitArray[0]+ " - Status : "+strStatus);
				if(strStatus.equalsIgnoreCase("Fail")){
					skipflag=true;				
				}							
			}else if(iLength >0){
				for(int k=0;k<=iLength;k++){
					strStatus=mapTestExecutionStatus.get(splitArray[k]);	
					System.out.println("Dependent TestCase : "+splitArray[k]+ " - Status : "+strStatus);
					if(strStatus.equalsIgnoreCase("Fail")){
						skipflag=true;
						break;							
					}	
				}							
			}else{
				strStatus=mapTestExecutionStatus.get(strDependency);
				System.out.println("Dependent TestCase : "+strDependency+ " - Status : "+strStatus);
				if(strStatus.equalsIgnoreCase("Fail")){
					skipflag=true;				
				}
			}
			return skipflag;
		}
		
		
//##############################################################################################################################################################
//########## 25. getSmtpServer Method - Gets SMTP server based on execution of environment
//##############################################################################################################################################################
								
		public String getSmtpServer(String strEnv, String strBatch, String strDev, String strInt, String strQa, String strStg, String strProd){
			String servername="";
			if(strBatch.equalsIgnoreCase("yes")){
				if(strEnv.equalsIgnoreCase("prod")){ 
					servername=strProd;
				}else if (strEnv.equalsIgnoreCase("stage")){
					servername=strStg;
				}else if (strEnv.equalsIgnoreCase("qa")){
					servername=strQa;
				}else if(strEnv.equalsIgnoreCase("int")){
					servername=strInt;
				}else{
					servername=strDev;
				}
			}else{
				servername=strDev;				
			}
			
			return servername;
		}
					
//##############################################################################################################################################################
//####################################### 	26. Framework Keywords		########################################################################################	 
//##############################################################################################################################################################

//##############################################################################################################################################################
//	1. click Method - Clicks on an Element. Logs Result in Report
//##############################################################################################################################################################
	
	public void click(String ObjectName) throws Exception{
		try{
			WebDriverWait objClickWait = new WebDriverWait(Driver, 120);
			objLocator = getElementLocator(ObjectName);
			objClickWait.until(ExpectedConditions.elementToBeClickable(objLocator));
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				lstElements.get(0).click();	
				logResult(IEPath, "Click", ObjectName , "NA", "User should be able to click on "+ObjectName, "User is able to click on "+ObjectName, "Pass","");
			}else{
				System.out.println(ObjectName+" : Object not found");
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "Click", ObjectName, "NA", "User should be able to click on "+ObjectName, ObjectName+" : Object not found", "Fail",path);
			}
		}catch (Exception clickException){
			System.out.println("Click Method Exception Message: "+clickException);
			String path=captureScreenshot(ObjectName);			
			logResult(IEPath, "Click", ObjectName, "NA", "User should be able to click on "+ObjectName, ObjectName+" : Object not found / Error occured", "Fail",path);
		}finally{
			lstElements.clear();
		}
	}
	
//##############################################################################################################################################################
// 2. javascriptClick Method - Clicks on Element through javascript. Logs Result in Report
//##############################################################################################################################################################

	public void javascriptClick(String ObjectName) throws Exception{
		try{
			WebDriverWait objjavascriptClickWait = new WebDriverWait(Driver, 120);
			objLocator = getElementLocator(ObjectName);
			objjavascriptClickWait.until(ExpectedConditions.elementToBeClickable(objLocator));
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				JavascriptExecutor executor = (JavascriptExecutor)Driver;
				executor.executeScript("arguments[0].click();", lstElements.get(0));
				logResult(IEPath, "Click", ObjectName , "NA", "User should be able to click on "+ObjectName, "User is able to click on "+ObjectName, "Pass","");
 			}else{
 				System.out.println(ObjectName+" : Object not found");
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "Click", ObjectName, "NA", "User should be able to click on "+ObjectName, ObjectName+" : Object not found", "Fail",path);
			}				
		}catch (Exception javascriptClickException){			
			System.out.println("JavascriptClick Method Exception Message: "+javascriptClickException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Click", ObjectName, "NA", "User should be able to click on "+ObjectName, ObjectName+" : Object not found / Error occured", "Fail",path);
		}finally{
			lstElements.clear();
		}
	}

//##############################################################################################################################################################
// 3. Hover Method (Hovers on Element. Logs Result in Report)
//##############################################################################################################################################################
	 	
	public void hover(String ObjectName) throws Exception{
		try{
			objLocator = getElementLocator(ObjectName);
			Actions KeyActions= new Actions(Driver);
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){		    
				KeyActions.moveToElement(lstElements.get(0)).build().perform();
				logResult(IEPath, "Hover", ObjectName, "NA", "User should be able to hover on: "+ObjectName, "User is able to hover on "+ObjectName, "Pass","");
			}else{
				System.out.println("User is not able to hover on Object : " +ObjectName);				
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "Hover", ObjectName, "NA", "User should be able to hover on Object",ObjectName+" : Object not found", "Fail",path);
	 		}
		}catch (Exception hoverException){	 			
			System.out.println("Hover Method Exception Message: "+hoverException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Hover", ObjectName, "NA", "User should be able to hover on Object",ObjectName+" : Object not found / Error occured", "Fail",path);
		}finally{
			lstElements.clear();
		}
	}
 	 
//##############################################################################################################################################################
// 4. Hover and Click Method (Mouse Hover and Click on Element. Logs Result in Report)
//##############################################################################################################################################################
 		 	
	public void hoverClick(String ObjectName) throws Exception{
		try{
			objLocator = getElementLocator(ObjectName);
			Actions KeyActions= new Actions(Driver);
 			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){		    
				KeyActions.moveToElement(lstElements.get(0)).click(lstElements.get(0)).build().perform();
	 			logResult(IEPath, "Hover & Click", ObjectName, "NA", "User should be able to click after hovering on: "+ObjectName, "User is able to click after hovering on "+ObjectName, "Pass","");
			}else{
				System.out.println("User is not able to Hover and click on Object" +ObjectName);
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "Hover & Click", ObjectName, "NA", "User should be able to click after hovering on Object", ObjectName+" : Object not found", "Fail",path);				
 			}
		}catch (Exception hoverClickException) {		
			System.out.println("HoverClick Method Exception Message: "+hoverClickException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Hover & Click", ObjectName, "NA", "User should be able to click after hovering on Object", ObjectName+" : Object not found / Error occured", "Fail",path);			
 		}finally{
			lstElements.clear();
 		}
 	}
 	 
//##############################################################################################################################################################
// 5. Delete Cookies Method  
// @throws IOException 
//##############################################################################################################################################################
 	 
	public void deleteCookies() throws IOException{
		try{
 			 Driver.manage().deleteAllCookies();
 		}catch (Exception deleteCookiesException) {
 			System.out.println("Delete Cookies Method Exception Message: "+deleteCookiesException);
 		}
 	}
 	 
//##############################################################################################################################################################
// 6. Mandatory Exist Method (Skips the execution of the test case / method if it fails to identify the object)
// @throws IOException 
//##############################################################################################################################################################
 	 
	public void mandatoryExist(String ObjectName) throws IOException{
		try{
			WebDriverWait objMandatoryExistWait = new WebDriverWait(Driver, 120);
 			objLocator = getElementLocator(ObjectName);
 			objMandatoryExistWait.until(ExpectedConditions.visibilityOfElementLocated(objLocator));//presenceOfElementLocated 
 			objMandatoryExistWait.until(ExpectedConditions.presenceOfElementLocated(objLocator));
 			logResult(IEPath,"Mandatory Exist",ObjectName, "NA", "Verify existance of "+ObjectName, ObjectName+" exists", "Pass","");
 		}catch (Exception mandatoryExistException) {
 			System.out.println("Mandatory Exist Method Exception Message: "+mandatoryExistException);
 			String path=captureScreenshot(ObjectName);
 			logResult(IEPath,"Mandatory Exist",ObjectName, "NA", "Verify existance of "+ObjectName, ObjectName+" not found", "Fail",path);
 			throw new SkipException("Skipping execution of test case / method");
	 	}
	}

//##############################################################################################################################################################
// 7. verifyExist Method (Verifies Existence of Element to be Visible on the screen. Every 500 msec it checks for the condition till 120 secs)
// Returns True or False. You can use Return type to Script condition based functionalities.
// Logs Results for Pass and Fail scenarios
// @throws IOException 
//##############################################################################################################################################################
 		
	public boolean verifyExist(String ObjectName, String... params) throws IOException{
		boolean verifyExistStatus = false;
		String skipLog = params.length > 0 ? params[0] : "NO" ;
		try{
			WebDriverWait objVerifyExistWait = new WebDriverWait(Driver, 10);
 			objLocator = getElementLocator(ObjectName);
 			objVerifyExistWait.until(ExpectedConditions.visibilityOfElementLocated(objLocator));
 			//objVerifyExistWait.until(ExpectedConditions.presenceOfElementLocated(objLocator));
 			lstElements = Driver.findElements(objLocator);
 			if(lstElements.size()>0){
 				String strText=lstElements.get(0).getText();
 				logResult(IEPath,"Exist",ObjectName, "NA", "Verify existance of "+ObjectName, ObjectName+ " : "+strText+" exists" , "Pass","");
 				verifyExistStatus= true;
	 		}		
		}catch (Exception verifyExistException) {
			System.out.println("VeriftExist Method Exception Message: "+verifyExistException);
            if (skipLog.equalsIgnoreCase("yes")){
                System.out.println("Log skipped for : "+ObjectName);
            }else{
                 String path=captureScreenshot(ObjectName);
                 logResult(IEPath,"Exist",ObjectName, "NA", "Verify existance of "+ObjectName, ObjectName+" not found", "Fail",path); 		
            }
        }
		return verifyExistStatus; 		
	}
 	 
//##############################################################################################################################################################
// 8. Verify Not Exist Method (Waits for Element to be Not Visible on the screen. Every 500 msec it checks for the condition till 120 secs)
// Returns True or False. You can use Return type to Script condition based functionalities.
// Logs Results for Pass and Fail scenarios.
// @throws IOException 
///#############################################################################################################################################################
 	 
	public boolean verifyNotExist(String ObjectName, String... params) throws IOException{
		boolean verifyNotExistStatus = false;		
		String skipLog = params.length > 0 ? params[0] : "NO" ;
		try{ 			 
			WebDriverWait objVerifyNotExistWait = new WebDriverWait(Driver, 10);
 			objLocator = getElementLocator(ObjectName);
 			objVerifyNotExistWait.until(ExpectedConditions.invisibilityOfElementLocated(objLocator));
 			lstElements = Driver.findElements(objLocator);
 			if(lstElements.size()==0){
 				logResult(IEPath,"Not Exist",ObjectName, "NA", "Verify invisibility of "+ObjectName, ObjectName+" Object not present on the page", "Pass","");
 				verifyNotExistStatus= true;
 			}	 			
 		}catch (Exception  verifyNotExistException){
 			System.out.println("VerifyNotExist Method Exception Message: "+verifyNotExistException);
 			if (skipLog.equalsIgnoreCase("yes")){
                System.out.println("Log skipped for : "+ObjectName);
            }else{
            	String path=captureScreenshot(ObjectName);
            	logResult(IEPath,"Not Exist",ObjectName, "NA", "Verify invisibility of"+ObjectName, ObjectName+" found", "Fail",path);
            }
        }
		return verifyNotExistStatus;
	}
 	 
//##############################################################################################################################################################
// 9. WaitUntil Method (Waits for Element to be Visible on the screen. Every 500 msec it checks for the condition till 120 secs)
// Logs Results only for Fail scenarios
// @throws IOException 
//##############################################################################################################################################################
	
	public void waitUntil(String ObjectName,String strWaitType,String... params) throws IOException{
		
		String skipLog = params.length > 0 ? params[0] : "NO" ; 
		try{            
			WebDriverWait objwaitUntilWait = new WebDriverWait(Driver, 120);
 			objLocator = getElementLocator(ObjectName);
 			switch (strWaitType.toLowerCase()){
 				case "exist":
 					objwaitUntilWait.until(ExpectedConditions.visibilityOfElementLocated(objLocator));
 					objwaitUntilWait.until(ExpectedConditions.presenceOfElementLocated(objLocator));
 					System.out.println("Object visible");
 					break;
 				case "notexist": 			 			 
 					objwaitUntilWait.until(ExpectedConditions.invisibilityOfElementLocated(objLocator));//presenceOfElementLocated
 					break;
 				default:
 					objwaitUntilWait.until(ExpectedConditions.visibilityOfElementLocated(objLocator));
 					objwaitUntilWait.until(ExpectedConditions.presenceOfElementLocated(objLocator));
 					break;
 			}
		}catch (Exception waitUntilException) {
			System.out.println("Wait Until Method Exception Message: "+waitUntilException);
			if (skipLog.equalsIgnoreCase("yes")){
                System.out.println("Log skipped for : "+ObjectName);
			}else{
				String path=captureScreenshot(ObjectName);
				logResult(IEPath,"Wait Until "+strWaitType,ObjectName, "NA", ObjectName+" Wait until existance of object on the Page", ObjectName+" not found", "Fail",path); 	
			}
 		}
	}	 

//##############################################################################################################################################################
// 10. Element Count Method (Returns number of elements.)
// @throws IOException 
///#############################################################################################################################################################
 	
	public int elementCount(String ObjectName) throws IOException{
		int iCount=0;
		try{
 			objLocator = getElementLocator(ObjectName);
 			lstElements = Driver.findElements(objLocator);
 	 		iCount=lstElements.size();
 	 		//return iCount;
		}catch (Exception elementCountException) {
			System.out.println("Element Count Method Exception Message: "+elementCountException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath,"Element Count",ObjectName, "NA", ObjectName+" Element count of object on the page", ObjectName+" not found", "Fail",path);
			//return iCount;
 	 	}finally{
			lstElements.clear();
		}
		return iCount;
	} 	 	 

//##############################################################################################################################################################
// 11. GetText Method (Gets the text from the given object)
// @ throws Exception		
//##############################################################################################################################################################
	 		 	 
	public String getText(String ObjectName) throws Exception{
		try{
			objLocator = getElementLocator(ObjectName);
 			lstElements = Driver.findElements(objLocator);
 			if(lstElements.size()>0){
 				TextValue = lstElements.get(0).getText();	
 				if(TextValue.equalsIgnoreCase(""))
 				{
 					TextValue = lstElements.get(0).getAttribute("innerHtml");	
  				}
 				logResult(IEPath, "Get Text", ObjectName, "NA", "Text value of "+ObjectName, "Text value of "+ObjectName +" : " + TextValue , "Pass","");
 	  			//return TextValue;
 			}else{
 				System.out.println(ObjectName+": Element not found");
 				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "Get Text", ObjectName, "NA", "Text value of "+ObjectName, ObjectName +" Object not found", "Fail",path);
			}
		}catch (Exception getTextException) {
			System.out.println("getText Method Exception Message: "+getTextException);
  			String path=captureScreenshot(ObjectName);
  			logResult(IEPath, "Get Text", ObjectName, "NA", "Text value of "+ObjectName, ObjectName + " Object not found", "Fail",path);
  			//return TextValue; 	
 		}finally{
 			lstElements.clear();
 		}	
 		return TextValue; 		 	 
	}
	 		 	 
//##############################################################################################################################################################
// 12. Get Property Value Method (Gets the property value of an object)
// @ throws Exception		
//##############################################################################################################################################################
	 		 		 		 	 
	public String getPropertyValue(String ObjectName, String ValueType) throws Exception{
		try{
			strTestDataInput = getTestData(ValueType);
 			objLocator = getElementLocator(ObjectName);
 			lstElements = Driver.findElements(objLocator);
 			if(lstElements.size()>0){
 				TextValue = lstElements.get(0).getAttribute(strTestDataInput);	
 				//return TextValue;
 			}else{
 				System.out.println(ObjectName+": Object not found");
 				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "Get Property Value", ObjectName, "NA", "Expected Value "+strTestDataInput, ObjectName+" Object not found", "Fail",path);				
 			}
 		}catch (Exception getPropertyValueException){
 			System.out.println("GetPropertyValue Method Exception Message: "+getPropertyValueException);
 			String path=captureScreenshot(ObjectName);
 			logResult(IEPath, "Get Property Value", ObjectName, "NA", "Expected Value "+strTestDataInput, ObjectName+" Object not found", "Fail",path);
 			//return TextValue;
 		}finally{
 			lstElements.clear();
 		}
		return TextValue; 		 
	}

//##############################################################################################################################################################
// 13. Verify Text Value Method (Verifies text of an object with the given text)
// @ throws Exception	
//##############################################################################################################################################################
 		 		 		 		 	 
	public boolean verifyText(String ObjectName, String strInput) throws Exception{
		try{
			strTestDataInput = getTestData(strInput);
 			objLocator = getElementLocator(ObjectName);
 			lstElements = Driver.findElements(objLocator);
 			if(lstElements.size()>0){
 				TextValue = lstElements.get(0).getText();	
 				if (strTestDataInput.equalsIgnoreCase(TextValue)){
 					logResult(IEPath, "Verify Text", ObjectName, "NA", "Expected Value: "+strTestDataInput, "Actual Value: "+TextValue, "Pass","");
 					return true;
 	 			}
 	 			else{
 	 				TextValue = lstElements.get(0).getAttribute("innerHTML");
 	 				if (strTestDataInput.equalsIgnoreCase(TextValue)){
 	 					logResult(IEPath, "Verify Text", ObjectName, "NA", "Expected Value: "+strTestDataInput, "Actual Value: "+TextValue, "Pass","");
 	 					return true;
 	 	 			}
 	 	 			else{
 	 	 				logResult(IEPath, "Verify Text", ObjectName, "NA", "Expected Value: "+strTestDataInput, "Actual Value: "+TextValue, "Fail","");
 	 	 				return false;
 	 	 			}
 	 			} 	
 			}else{
 				System.out.println(ObjectName+": Object not found");
 				String path=captureScreenshot(ObjectName);
 	        	logResult(IEPath, "Verify Text", ObjectName, "NA", "Expected Value: "+strTestDataInput, ObjectName+": Object not found", "Fail",path);
 				return false;
 			}
 		}catch (Exception verifyTextException) {
 			System.out.println("VerifyText Method Exception Message: "+verifyTextException);
 			String path=captureScreenshot(ObjectName);
 			logResult(IEPath, "Verify Text", ObjectName, "NA", "Expected Value: "+strTestDataInput, ObjectName+": Object not found", "Fail",path);
 			return false; 	
 		}
	}

//##############################################################################################################################################################
// 14. compareStrings Method (Method is to verify two strings and Logging result to the report) 
// Verifies Exact match ignoring Case sensitive
// @ throws IOException		
//##############################################################################################################################################################
 	 	
	public boolean compareStrings(String strText1, String strText2) throws IOException{
		try{
			strTestDataInput = getTestData(strText1);
 			strTestDataInput2 = getTestData(strText2);
	 		if (strTestDataInput2.equalsIgnoreCase(strTestDataInput)){
	 			System.out.println("Verify: Pass STRING 1: "+strTestDataInput+"STRING 2: "+strTestDataInput2);
	 			logResult(IEPath, "Compare Strings", "String1 : "+strTestDataInput, "String2 : "+strTestDataInput2, "String1 and String2 should match", "String1 and String2 match", "Pass","");
	 			return true;
		 	}
	 		else{
	 			logResult(IEPath, "Compare Strings", "String1 : "+strTestDataInput, "String2 : "+strTestDataInput2, "String1 and String2 should match", "String1 and String2 do not match", "Fail","");
	 			return false;
	 		}
 	 	}catch (Exception compareStringsException) {
 	 		logResult(IEPath, "Compare Strings", "String1 : "+strTestDataInput, "String2 : "+strTestDataInput2, "String1 and String2 should match", "String1 and String2 do not match", "Fail","");
 	 		System.out.println("Compare Strings Method Exception Message: "+compareStringsException);
 	 		return false;
 	 	}
	}
 	 
//##############################################################################################################################################################
// 15. Contains Text Method (Method is to verify two strings and Logging result to the report) 
// Verifies partial match.
// @ throws IOException	
//##############################################################################################################################################################
 	 	 	
	public boolean containsText(String strText1, String strText2) throws IOException{
		try{
			strTestDataInput = getTestData(strText1);
			strTestDataInput2 = getTestData(strText2);
			if (strTestDataInput2.contains(strTestDataInput)){
				System.out.println("Contains Text: Pass String 1: "+strTestDataInput+" String 2: "+strTestDataInput2);
 				logResult(IEPath, "Contains Text", "String 1 : "+strTestDataInput, " String 2 : "+strTestDataInput2, "String 2 should contain String 1", "String 2 contains String 1", "Pass","");
 				return true;
		 	}
 			else{
 				logResult(IEPath, "Contains Text", "String 1 : "+strTestDataInput, " String 2 : "+strTestDataInput2, "String 2 should contain String 1", "String 2 does not contain String 1", "Fail","");
 				return false;
 			}
 	 	}catch (Exception containsTextException) {
 	 		logResult(IEPath, "Contains Text", "String 1 : "+strTestDataInput, " String 2 : "+strTestDataInput2, "String 2 should contain String 1", "Error occured during comparing text", "Fail","");
 	 		System.out.println("Contains Text Method Exception Message: "+containsTextException);
 	 		return false;
 	 	}
	}

//##############################################################################################################################################################
// 16. Load URL Method (Loads URL to the driver and waits for complete state of the dom)
// @throws IOException @throws Exception 
//##############################################################################################################################################################
	 
	public void loadUrl(String URL) throws IOException, Exception{
		strTestDataInput = getTestData(URL);
 		try{
 			Driver.get(strTestDataInput);
 			//Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 			logResult(IEPath, "Load URL", strDriverType, strTestDataInput, "URL should be loaded", "URL loaded in " + strDriverType + " browser", "Pass","");			
		} catch (Exception loadUrlException) {
			System.out.println("loadUrl Method Exception Message: "+loadUrlException);
			String path=captureScreenshot("loadURL"); 			
			logResult(IEPath, "Load URL", strDriverType, strTestDataInput, "URL should be loaded", "URL doesnot load / Windows Components found", "Pass",path);
		}
	}


//##############################################################################################################################################################
// 17. iFrame Switch Method (Brings Focus to iFrame)
//##############################################################################################################################################################

	public void iFrameSwitch(String ObjectName) throws Exception{
		try{
			objLocator = getElementLocator(ObjectName);
            lstElements = Driver.findElements(objLocator);
            if(lstElements.size()>0){
            	Driver.switchTo().frame(lstElements.get(0));
                logResult(IEPath, "SwitchtoiFrame", ObjectName , "NA", "User should be able to switch to iFrame "+ObjectName, "User is able to Switch to iFrame "+ObjectName, "Pass","");
            }else{
            	System.out.println(ObjectName+": Object not found");
            	String path=captureScreenshot(ObjectName);
            	logResult(IEPath, "SwitchtoiFrame", ObjectName, "NA", "User should be able to switch to iFrame "+ObjectName, ObjectName+": Object not found", "Fail",path);
            }
		}catch (Exception iFrameSwitchException) {			
			System.out.println("iFrameSwitch Method Exception Message: "+iFrameSwitchException);
			String path=captureScreenshot(ObjectName);
        	logResult(IEPath, "SwitchtoiFrame", ObjectName, "NA", "User should be able to switch to iFrame "+ObjectName, ObjectName+": Object not found", "Fail",path);
        }
	}

//##############################################################################################################################################################
// 18. iFrame Focus Method by Index , Text (Brings Focus to IFrame) 
///#############################################################################################################################################################
	 
	public void iFrameSwitchVal(String valueType, String  strValue){
		try{
			switch (valueType.toLowerCase()){
				case "index":
					int index1= Integer.valueOf(strValue);
					Driver.switchTo().frame(index1);
					//Thread.sleep(2000);
					break;
				case "text":
					Driver.switchTo().frame(strValue);
					//Thread.sleep(2000);
					break;		 
			}
		}catch (Exception iFrameSwitchValException) {
			System.out.println("iFrameSwitchValue Method Exception Message: "+iFrameSwitchValException);
		}
	}

//##############################################################################################################################################################
// 19. Wait and Switch to iFrame Method (Waits till 120 sec for IFrame to be available and Switches to it)
//##############################################################################################################################################################
     
	public void waitAndSwitchToFrame(By Locator) throws Exception{
		WebDriverWait objwaitandswitchFrameWait = new WebDriverWait(Driver, 120);
		objwaitandswitchFrameWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Locator));
		//objWait=null;
	}

//##############################################################################################################################################################
// 20. Exit iFrame Method (Exit from iFrame)
//##############################################################################################################################################################
	 
	public void exitFrame() throws Exception{
		Driver.switchTo().defaultContent();
		//Thread.sleep(1000);	 
	}

//##############################################################################################################################################################
// 21. Sync Method (Waits till complete state of the DOM)
// @throws IOException,  @throws Exception 
//##############################################################################################################################################################
	 
	public void sync() throws IOException, Exception{
		WebDriverWait objsyncWait = new WebDriverWait(Driver,120);
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
			 	public Boolean apply(WebDriver Driver1) {
			 		return ((org.openqa.selenium.JavascriptExecutor)Driver1).executeScript("return document.readyState").equals("complete");
			 	}
		};
		objsyncWait.until(pageLoadCondition);
	}
	 
//##############################################################################################################################################################
// 22. Type Method (Type the provided text into the text boxes also used to select value in List boxes)
// @throws IOException 
//##############################################################################################################################################################
	 
	public void type(String ObjectName, String strText) throws IOException{
		try{
			strTestDataInput = getTestData(strText);
			objLocator = getElementLocator(ObjectName);
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){				
				lstElements.get(0).sendKeys(strTestDataInput);
				logResult(IEPath, "Type", ObjectName , strTestDataInput , "User should be able to enter text", "User is able to enter text: "+strTestDataInput, "Pass","");
			}else{
				System.out.println(ObjectName+": Object is not displayed or enabled on the page");
				String path=captureScreenshot(ObjectName);
	        	logResult(IEPath, "Type", ObjectName, strTestDataInput, "User should be able to enter text", ObjectName+": Object not found", "Fail",path);
			}			 
		}catch (Exception typeException) {
			System.out.println("Type Method Exception Message: "+typeException);			
			String path=captureScreenshot(ObjectName);
        	logResult(IEPath, "Type", ObjectName, strTestDataInput, "User should be able to enter text", "Object not found", "Fail",path);
		}
	}


//##############################################################################################################################################################
// 23. Split Method (It will Split string based on the value provided and returns String based on the index selected for the Split Array
// @throws IOException 
//##############################################################################################################################################################
	 		 		 
	public String split(String strText, String strIdentifier, int iIndex) throws IOException{
		try{			
			strTestDataInput = getTestData(strText);
			String[] splitArray = strTestDataInput.split(strIdentifier);
			System.out.println("Split Array Length : " + splitArray.length);
			if(splitArray.length>0)
			{
				strSplitValue = splitArray[iIndex];				
				System.out.println("Split Text value:" +splitArray[iIndex]);
				logResult(IEPath, "Split", strTestDataInput, "NA", "User should be able to split text", "User is able to split text and value is " +splitArray[iIndex], "Pass","");
			}
			else
			{
				logResult(IEPath, "Split", strTestDataInput, "NA", "User should be able to split text", "Exception error occurred/ Split Array Length = " +splitArray.length, "Fail","");
			}
		}catch (Exception splitException) {
			logResult(IEPath, "Split", strTestDataInput, "NA", "User should be able to split text", "Exception error occurred", "Fail","");
			System.out.println("Split Method Exception Message: "+splitException);		
		}
		return strSplitValue;
	}
	 
//##############################################################################################################################################################
// 24. KeyBoard Actions Method (To give inputs via Keyboard)
//##############################################################################################################################################################

	public void keyBoardActions(String KeyBoardKey_Action){
		try{
			Actions KeyActions= new Actions(Driver);
			 
			switch (KeyBoardKey_Action.toLowerCase()){
			 
				case "arrowdown_click":
					KeyActions.sendKeys(Keys.ARROW_DOWN).click().build().perform();
					break;
				case "arrowup_click":
					KeyActions.sendKeys(Keys.ARROW_UP).click().build().perform();
					break;
				case "arrowleft_click":
					KeyActions.sendKeys(Keys.ARROW_LEFT).click().build().perform();
					break;
				case "arrowright_click":
					KeyActions.sendKeys(Keys.ARROW_RIGHT).click().build().perform();
					break;
			    case "backspace_click":
			    	KeyActions.sendKeys(Keys.BACK_SPACE).click().build().perform();
			    	break;
				case "enter_click":
					KeyActions.sendKeys(Keys.ENTER).click().build().perform();
					break;
				case "page_up":
					KeyActions.sendKeys(Keys.PAGE_UP).click().build().perform();
					break;
				case "page_down":
					KeyActions.sendKeys(Keys.PAGE_DOWN).click().build().perform();
					break;
				case "tab":
					KeyActions.sendKeys(Keys.TAB).click().build().perform();
					break;
				case "doubleclick":
					KeyActions.doubleClick().build().perform();
					break;
				default:
					System.out.println("Syntax issue with keyBoardActions method");				
			}				 
		}catch (Exception keyBoardActionsException) {
			System.out.println("KeyBoardActions Method Exception Message :" +keyBoardActionsException);
		}
	}	 

//##############################################################################################################################################################
// 25. Get Window ID Method (Returns Driver id)
// @throws IOException 
///#############################################################################################################################################################

	public String getWindowId() throws IOException{
		String windowid = Driver.getWindowHandle();				
		return windowid;			
	}	 

//##############################################################################################################################################################
// 26. Get Windows ID Method (Returns Driver id's in case more than one Driver)
// @throws IOException 
//##############################################################################################################################################################

	public String[] getWindowsId() throws Exception{
		String[] arrWindowId=null;
		try{			
			int i=0, j=0;
			Set<String> windowsid = Driver.getWindowHandles();	
			for(String wid:windowsid)
	        {
				i=i+1;
	        }
			arrWindowId= new String[i];
			if(i>0){				
				for(String wid1:windowsid)
		        {
					arrWindowId[j]=wid1;
					System.out.println(j+" : "+arrWindowId[j]);
		            j++;
		        }		
			}
		}catch(Exception windowException){
			System.out.println("GetWindow Method Exception Message :" +windowException);
		}
		return arrWindowId;			
	}	

//##############################################################################################################################################################
// 27. GetCurrentDatenTime Method (Returns Current Date and time in the required format)
//##############################################################################################################################################################

	public String getCurrentDatenTime(String format){
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(format);
	    return sdf.format(cal.getTime());
	}

//##############################################################################################################################################################
// 28. Clear Method (Waits for Element to be clickable and Clicks on Element. Logs Result in Report)
//##############################################################################################################################################################
		
	public void clear(String ObjectName) throws Exception{
		try{
			objLocator = getElementLocator(ObjectName);
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				lstElements.get(0).clear();	
				logResult(IEPath, "Clear", ObjectName , "NA", "User should be able to clear text from "+ObjectName, "User is able to clear text from "+ObjectName, "Pass","");
			}else{
				System.out.println(ObjectName+": Object not found");
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "Clear", ObjectName, "NA", "User should be able to clear text from "+ObjectName, ObjectName+": Object not found", "Fail",path);				
			}
		}catch (Exception clearException){
			System.out.println("Clear Method Exception Message: "+clearException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Clear", ObjectName, "NA", "User should be able to clear text from "+ObjectName, ObjectName+": Object not found", "Fail",path);			
		}finally{
			lstElements.clear();
		}
	}
		
//##############################################################################################################################################################
// 29. Refresh Page Method (Refreshes the page)
// @throws IOException @throws Exception 
//##############################################################################################################################################################
		 
	public void refreshPage() throws IOException, Exception{
		Driver.navigate().refresh();
	 }
	 	 
//##############################################################################################################################################################
// 30. Get Current URL Method (Gets current URL loaded on the browser)
// @throws IOException @throws Exception 
//##############################################################################################################################################################
	 		 
	public String getURL() throws IOException, Exception{
		String strGetURL = Driver.getCurrentUrl();
		return strGetURL; 
	 }
	 	 
//##############################################################################################################################################################
// 31. Get Page Title Method (Gets page title of the URL loaded on the browser)
// @throws IOException @throws Exception 
//##############################################################################################################################################################
	 	 		 
	public String getPageTitle() throws IOException, Exception{
		String strgetPageTitle = Driver.getTitle();
		return strgetPageTitle; 
	 }
	
//##############################################################################################################################################################
// 32. Alert Method (Alert handling Method)
//##############################################################################################################################################################
	 
	public String alert(String action){
		String stralerttext = null;
		try{			 	 
			switch (action.toLowerCase()){
				case "accept":
					Driver.switchTo().alert().accept();
					return stralerttext;				 
				case "dismiss":
					Driver.switchTo().alert().dismiss();
					return stralerttext;
				case "wait":
					WebDriverWait Alertwait = new WebDriverWait(Driver, 120);
					Alertwait.ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
					return stralerttext;
				case "gettext":
					stralerttext = Driver.switchTo().alert().getText();
					return stralerttext;				 
				default:
					Driver.switchTo().alert().accept();
					return stralerttext;				
			}				 
		}catch (Exception alertException) {
			System.out.println("Alert Method Exception Message : "+alertException);
		}
		return stralerttext;
	 }	 

//##############################################################################################################################################################
// 33. Type on Alert Method (Used to Sendkeys to ALert)
// @throws IOException 
//##############################################################################################################################################################
	 
	public void typeonAlert(String strText) throws IOException{
		try{
			WebDriverWait objAlertWait = new WebDriverWait(Driver, 120);
			strTestDataInput = getTestData(strText);
			objAlertWait.ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
			Driver.switchTo().alert().sendKeys(strTestDataInput);    
			logResult(IEPath, "Sendkeys to", "Alert",strTestDataInput , "User should be able to enter text on alert :"+strTestDataInput, "User is able to enter text on alert: "+strTestDataInput, "Pass","");
		}catch (Exception typeonAlertException) {
			logResult(IEPath, "Sendkeys to", "Alert", strTestDataInput, "User should be able to enter text on alert:"+strTestDataInput, "Object not found", "Fail","");
			System.out.println("TypeonAlert Method Exception Message : "+typeonAlertException);			
		}
	}

//##############################################################################################################################################################
// 34. Switch Window (Used to switch to a specific window using Windows ID)
// @throws IOException 
//##############################################################################################################################################################

	public void switchWindow(String Windowid) throws IOException{
		try{
			Driver.switchTo().window(Windowid);
		}catch (NoSuchWindowException  switchWindowException){
			System.out.println("SwitchWindow Method Exception Messaege : "+switchWindowException);
			logResult(IEPath, "SwitchWindow", "NA", Windowid, "User should be able to switch to the specified window "+Windowid, "Window not found", "Fail","");
		}
	}
		
//##############################################################################################################################################################
// 35. getRowCount method - Gets the row count of a sheet in an Excel
//##############################################################################################################################################################
				
	public int getRowCount(Sheet SheetName) throws IOException{
		int rowCount = SheetName.getLastRowNum()-SheetName.getFirstRowNum();
		System.out.println("rowCount: "+rowCount);
		return rowCount;			
	}
	
//##############################################################################################################################################################
// 36. Get Property Value Method (Gets the property value of an element in a list) -over ridden method from GetPropertyValue
// @ throws Exception		
//##############################################################################################################################################################
		 		 		 		 	 
	public String getPropertyValue(String ObjectName, String ValueType, int index) throws Exception{
		try{
			boolean bFound=false;
 			strTestDataInput = getTestData(ValueType);
 			List<String> getLocator = mapObjectRepository.get(ObjectName);
 			String strLocatorType=getLocator.get(0);
			String strLocatorOldValue = getLocator.get(1);			
			if(strLocatorOldValue.contains("index")){
				bFound=true;
				String istr=Integer.toString(index);			
				String strLocatorNewValue=strLocatorOldValue.replace("index",istr);
				lstLocators = new ArrayList<>();
				lstLocators.add(strLocatorType);
				lstLocators.add(strLocatorNewValue);
				mapObjectRepository.put(ObjectName, lstLocators);
			}
 			objLocator = getElementLocator(ObjectName);
 			lstElements = Driver.findElements(objLocator);
 			if(lstElements.size()>0){
 				if(bFound){
 					TextValue = lstElements.get(0).getAttribute(strTestDataInput);	
 				}else{
 					TextValue = lstElements.get(index).getAttribute(strTestDataInput);
 				}
 			}else{
 				System.out.println(ObjectName+": Object not found");
 				String path=captureScreenshot(ObjectName);
 				logResult(IEPath, "Get Element Property Value", ObjectName, "NA", "Expected Value "+strTestDataInput, ObjectName+" Object not found", "Fail",path);
			}
 			if(bFound){
 				lstLocators = new ArrayList<>();
 				lstLocators.add(strLocatorType);
 				lstLocators.add(strLocatorOldValue);
 				mapObjectRepository.put(ObjectName, lstLocators);
 			}
			return TextValue;
 		}catch (Exception getElementPropertyValueException){
 			System.out.println("GetElementPropertyValue Method Exception Message: "+getElementPropertyValueException);
 			String path=captureScreenshot(ObjectName);
 			logResult(IEPath, "Get Element Property Value", ObjectName, "NA", "Expected Value "+strTestDataInput, ObjectName+" Object not found", "Fail",path);
 			return TextValue;
 		}finally{
 			lstElements.clear();
 		} 		 
	}
	
//##############################################################################################################################################################
// 37. GetText Method (Gets the text from the given element in a list) - over ridden method from GetText
// @ throws Exception		
//##############################################################################################################################################################
		 		 	 
	public String getText(String ObjectName,int index) throws Exception{
		try{
			boolean bFound=false;
			List<String> getLocator = mapObjectRepository.get(ObjectName);
			String strLocatorType=getLocator.get(0);	
			String strLocatorOldValue = getLocator.get(1);	
			if(strLocatorOldValue.contains("index")){
				bFound=true;
				String istr=Integer.toString(index);
				String strLocatorNewValue=strLocatorOldValue.replace("index",istr);
				lstLocators = new ArrayList<>();
				lstLocators.add(strLocatorType);
				lstLocators.add(strLocatorNewValue);
				mapObjectRepository.put(ObjectName, lstLocators); 			
			}
			objLocator = getElementLocator(ObjectName);
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				if(bFound){
					TextValue = lstElements.get(0).getText();
					if(TextValue.equalsIgnoreCase(""))
	 				{
	 					TextValue = lstElements.get(0).getAttribute("innerHtml");	
	  				}
				}else{
					TextValue = lstElements.get(index).getText();
					if(TextValue.equalsIgnoreCase(""))
	 				{
	 					TextValue = lstElements.get(index).getAttribute("innerHtml");	
	  				}
				}
				logResult(IEPath, "Get Element Text", ObjectName, "NA", "Text value of "+ObjectName, "Text value of "+ObjectName +" : " + TextValue , "Pass","");				
	 		}else{
	 			System.out.println(ObjectName+": Object not found");
	 			String path=captureScreenshot(ObjectName);
	 			logResult(IEPath, "Get Element Text", ObjectName, "NA", "Text value of "+ObjectName, ObjectName +" Object not found", "Fail",path);	 			
	 		}
			if(bFound){
				lstLocators = new ArrayList<>();
				lstLocators.add(strLocatorType);
				lstLocators.add(strLocatorOldValue);
				mapObjectRepository.put(ObjectName, lstLocators);	
			}
			return TextValue;
		}catch (Exception getElementTextException) {
			System.out.println("getElementText Method Exception Message: "+getElementTextException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Get Element Text", ObjectName, "NA", "Text value of "+ObjectName, ObjectName + " Object not found", "Fail",path);
			return TextValue; 	
	 	}finally{
	 		lstElements.clear();
	 	}			 	 
	}
	
//##############################################################################################################################################################
// 38. getDateDifference method - Gets the difference between two date in hours minutes and seconds
// @ throws Exception
//##############################################################################################################################################################
					
	public String getDateDifference(String strDate1, String strDate2, String strDateFormat) throws Exception{
		String strDateDiff=null;
		try{			
			DateFormat format = new SimpleDateFormat(strDateFormat);
			Date date1 = format.parse(strDate1);
		    Date date2 = format.parse(strDate2);	      
			long diff = date2.getTime() - date1.getTime();
		    long diffSeconds = diff / 1000 % 60;
		    long diffMinutes = diff / (60 * 1000) % 60;
		    long diffHours = diff / (60 * 60 * 1000);
		    strDateDiff=diffHours+":"+diffMinutes+":"+diffSeconds;			
		}catch (Exception getDateDifferenceException) {
			System.out.println("getDateDifference Method Exception Message: "+getDateDifferenceException);			
		}
		return strDateDiff;
	}
	
//##############################################################################################################################################################
// 39. Write to Excel file
//##############################################################################################################################################################	
				
	public void writeExcel(String filePath, String excelName, String sheetName,int rowno,int colno, String strValue) throws IOException{
		try {
			String path=filePath+"\\"+excelName;
			
			File file = new File(path);
			
			if(file.exists()){
				FileInputStream inputStream = new FileInputStream(file);
				XSSFWorkbook Workbook1 = new XSSFWorkbook(inputStream);
				//Workbook Workbook1 = WorkbookFactory.create(inputStream); 
			    Sheet sheet = Workbook1.getSheet(sheetName);
			    		    
			    Row row = sheet.createRow(rowno);
			    Cell cell = row.createCell(colno);
			    cell.setCellType(Cell.CELL_TYPE_STRING);
			    cell.setCellValue(strValue);
				//Close input stream
				inputStream.close();
				//Create an object of FileOutputStream class to create write data in excel file
				FileOutputStream outputStream = new FileOutputStream(file);
				//write data in the excel file
				Workbook1.write(outputStream);
				//close output stream
				outputStream.close(); 	
				Workbook1.close();
				System.out.println("Data has been written to excel file");
			}else{
				System.out.println("Error occured while writing to excel file");
			}
		} catch (Exception writeExcelException) {
			System.out.println("writeExcel Method Exception Message: "+writeExcelException);			
		}
	}	
	
//##############################################################################################################################################################
// 40. Read from Excel file
//##############################################################################################################################################################	
					
	public String readExcel(String filePath, String excelName, String sheetName,int rowno,int colno) throws IOException{
		String strExcelValue="";
		try{
			String path=filePath+"\\"+excelName;
				
			File file = new File(path);
				
			if(file.exists()){
				FileInputStream inputStream = new FileInputStream(file);
				XSSFWorkbook Workbook1 = new XSSFWorkbook(inputStream);
				Sheet sheet = Workbook1.getSheet(sheetName);
				    		    
				Row row = sheet.getRow(rowno);
				Cell cell = row.getCell(colno);
				strExcelValue =cell.getStringCellValue();
				 
				//Close input stream
				inputStream.close();	
				Workbook1.close();
				System.out.println("Data has been read from excel file");
			}else{
				System.out.println("Error occured while reading from excel file");
			}
		} catch (Exception readExcelException) {
			System.out.println("readExcel Method Exception Message: "+readExcelException);			
		}
		return strExcelValue;
	}	
	
//##############################################################################################################################################################
// 41. click Method (clicks the given element in a list) - over ridden method from click
// @ throws Exception		
//##############################################################################################################################################################
			 		 	 
	public void click(String ObjectName,int index) throws Exception{
		try{
			boolean bFound=false;
			List<String> getLocator = mapObjectRepository.get(ObjectName);
			String strLocatorType=getLocator.get(0);
			String strLocatorOldValue = getLocator.get(1);	
			if(strLocatorOldValue.contains("index")){
				bFound=true;
				String istr=Integer.toString(index);
				String strLocatorNewValue=strLocatorOldValue.replace("index",istr);
				lstLocators = new ArrayList<>();
				lstLocators.add(strLocatorType);
				lstLocators.add(strLocatorNewValue);
				mapObjectRepository.put(ObjectName, lstLocators); 
			}					
			WebDriverWait objClickWait = new WebDriverWait(Driver, 120);
			objLocator = getElementLocator(ObjectName);
			objClickWait.until(ExpectedConditions.elementToBeClickable(objLocator));
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				if(bFound){
					lstElements.get(0).click();
				}else{
					lstElements.get(index).click();
				}				
				logResult(IEPath, "Click Element", ObjectName, "NA", "User should be able to click on "+ObjectName, "User is able to click on "+ObjectName, "Pass","");				
		 	}else{
		 		System.out.println(ObjectName+": Object not found");
		 		String path=captureScreenshot(ObjectName);
		 		logResult(IEPath, "Click Element", ObjectName, "NA", "User should be able to click on "+ObjectName, ObjectName +" Object not found", "Fail",path);	 			
		 	}
			if(bFound){
				lstLocators = new ArrayList<>();
				lstLocators.add(strLocatorType);
				lstLocators.add(strLocatorOldValue);
				mapObjectRepository.put(ObjectName, lstLocators);	
			}
		}catch (Exception clickElementException) {
			System.out.println("clickElement Method Exception Message: "+clickElementException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Click Element", ObjectName, "NA", "User should be able to click on "+ObjectName, ObjectName + " Object not found", "Fail",path);
		}finally{
			lstElements.clear();
		}			 	 
	}

//##############################################################################################################################################################
// 42. closeWindow Method - closes the window newly opened
//##############################################################################################################################################################
				 		 	 
	public void closeWindow(){
		Driver.close();
	}			


//##############################################################################################################################################################
// 43. addToTestData Method - Add to the Test Data during run time to store a output value and reuse it later  
//##############################################################################################################################################################

	public void addToTestData(String strVariableName, String strVariableValue) throws Exception{
		if(strVariableName.contains(" ")){
			System.out.println("Add to Test Data Failed - Test Data variable name should not contain spaces : " +strVariableName+" - Skipping Execution");
			throw new SkipException("Skipping execution of test case - Test Data variable name should not contain spaces");		 			
		}else{
			if(mapTestData.containsKey(strVariableName)){
				System.out.println("Add to Test Data Failed - Test Data variable name provided is already existing in Test Data : " +strVariableName+" - Skipping Execution");
				throw new SkipException("Skipping execution of test case - Runtime variable name provided is already existing in test data");		 			
			}else{
				mapTestData.put(strVariableName, strVariableValue);
				System.out.println("**************************************** Add Test Data **********************************************");					
				System.out.println("Run Time Test Data Added -  Key : "+ strVariableName + " Value : "+strVariableValue);
				System.out.println("**************************************** Add Test Data **********************************************");					
			}
		}
	}
	
			
//##############################################################################################################################################################
// 44. updateTestData Method - Update the value of a Test Data variable during run time to store a output value and reuse it later  
//##############################################################################################################################################################

	public void updateTestData(String strVariableName, String strVariableValue) throws Exception{
		if(mapTestData.containsKey(strVariableName)){
			mapTestData.put(strVariableName, strVariableValue);
			System.out.println("**************************************** Update Test Data **********************************************");					
	    	System.out.println("Run Time Test Data updated -  Key : "+ strVariableName + " Value : "+strVariableValue);
	    	System.out.println("**************************************** Update Test Data **********************************************");					
		}else{
			System.out.println("Update Test Data Failed - Could not find the key : " +strVariableName+" - Skipping Execution");
	    	throw new SkipException("Skipping execution of test case - Runtime variable name provided is not existing in test data");		 			
		}
	}	
	

//##############################################################################################################################################################
// 45. IsEnabled Method - To check whether an object is enabled or not and returns true if it is enabled  
//##############################################################################################################################################################

	public boolean isEnabled(String ObjectName) throws Exception{
		boolean isEnabledStatus=false;
		try{
			objLocator = getElementLocator(ObjectName);
			lstElements = Driver.findElements(objLocator);
			if(lstElements.get(0).isEnabled()){
				isEnabledStatus=true;
				logResult(IEPath, "Enabled", ObjectName, "NA", ObjectName+" should be enabled", ObjectName + " is enabled", "Pass","");
			}else{
				logResult(IEPath, "Disabled", ObjectName, "NA", ObjectName+" should be disabled", ObjectName + " is disabled", "Pass","");
			}			
		}catch (Exception isEnabledException){
			System.out.println("IsEnabled Method Exception Message: "+isEnabledException);
			String path=captureScreenshot(ObjectName);			
			logResult(IEPath, "Disabled", ObjectName, "NA", ObjectName+" should be disabled", ObjectName + " is disabled", "Pass",path);
		}	
		return isEnabledStatus;				
	}	

//##############################################################################################################################################################
// 46. select Method - To select a value from dropdown using value or text or index 
//##############################################################################################################################################################

	public void select(String ObjectName, String strValue, String strType) throws IOException{
		try{
			objLocator = getElementLocator(ObjectName);
			strTestDataInput = getTestData(strValue);
			
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				Select dropdown = new Select(lstElements.get(0));
				if(strType.equalsIgnoreCase("text")){
					dropdown.selectByVisibleText(strTestDataInput);
				}else if(strType.equalsIgnoreCase("value")){
					dropdown.selectByValue(strTestDataInput);
				}else if(strType.equalsIgnoreCase("index")){
					int iIndex=Integer.parseInt(strTestDataInput);
					dropdown.selectByIndex(iIndex);
				}else{
					dropdown.selectByValue(strTestDataInput);
				}
				logResult(IEPath, "Select", ObjectName , strTestDataInput , "User should be able to select value", "User is able to select value: "+strTestDataInput, "Pass","");
			}else{
				System.out.println(ObjectName+": Object is not displayed or enabled on the page");
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "Select", ObjectName, strTestDataInput, "User should be able to select value", ObjectName+": Object not found", "Fail",path);
			}			 
		}catch (Exception selectException) {
			System.out.println("Select Method Exception Message: "+selectException);			
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Select", ObjectName, strTestDataInput, "User should be able to select value", "Object not found", "Fail",path);
		}
	}
	
//##############################################################################################################################################################
// 47. verifyText Method (Verifies text of an object with the given text) - over ridden method from verifyText
// @ throws Exception		
//##############################################################################################################################################################
				 		 	 
	public boolean verifyText(String ObjectName,String strInput,int index) throws Exception{
		try{
			boolean bFound=false;
			boolean iCheck=false;
			strTestDataInput = getTestData(strInput); 			
			List<String> getLocator = mapObjectRepository.get(ObjectName);
			String strLocatorType=getLocator.get(0);	
			String strLocatorOldValue = getLocator.get(1);	
			if(strLocatorOldValue.contains("index")){
				bFound=true;
				String istr=Integer.toString(index);
				String strLocatorNewValue=strLocatorOldValue.replace("index",istr);
				lstLocators = new ArrayList<>();
				lstLocators.add(strLocatorType);
				lstLocators.add(strLocatorNewValue);
				mapObjectRepository.put(ObjectName, lstLocators); 			
			}
			objLocator = getElementLocator(ObjectName);
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				if(bFound){
					TextValue = lstElements.get(0).getText();	
				}else{
					TextValue = lstElements.get(index).getText();	
				}
				if (strTestDataInput.equalsIgnoreCase(TextValue)){
					iCheck = true;
					logResult(IEPath, "Verify Text", ObjectName, "NA", "Expected Value: "+strTestDataInput, "Actual Value: "+TextValue, "Pass","");
				}
				else{
					if(bFound){
						TextValue = lstElements.get(0).getAttribute("innerHTML");
					}else{
						TextValue = lstElements.get(index).getAttribute("innerHTML");
					}
 	 				if (strTestDataInput.equalsIgnoreCase(TextValue)){
 	 					logResult(IEPath, "Verify Text", ObjectName, "NA", "Expected Value: "+strTestDataInput, "Actual Value: "+TextValue, "Pass","");
 	 					iCheck = true;
 	 	 			}
 	 	 			else{
 	 	 				logResult(IEPath, "Verify Text", ObjectName, "NA", "Expected Value: "+strTestDataInput, "Actual Value: "+TextValue, "Fail","");
 	 	 				iCheck = false;
 	 	 			}
 	 			} 
			}else{
				iCheck = false;
				System.out.println(ObjectName+": Object not found");
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "Verify Text", ObjectName, "NA", "Expected Value: "+strTestDataInput, ObjectName+": Object not found", "Fail",path);
 			}
			if(bFound){
				lstLocators = new ArrayList<>();
				lstLocators.add(strLocatorType);
				lstLocators.add(strLocatorOldValue);
				mapObjectRepository.put(ObjectName, lstLocators);	
			}
			return iCheck;
		}catch (Exception verifyTextException) {
			System.out.println("VerifyText Method Exception Message: "+verifyTextException);
 			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Verify Text", ObjectName, "NA", "Expected Value: "+strTestDataInput, ObjectName+": Object not found", "Fail",path);
			return false;
		}finally{
				lstElements.clear();
		}			 	 
	}
	
//##############################################################################################################################################################
// 48. logToReport method (Logs the results to the detailed report)
//##############################################################################################################################################################
				 	 
	public void logToReport(String Action, String Element, String Value, String ExpectedBehavior, String ActualBehavior, String Result) throws Exception{
		
		if(Result.equalsIgnoreCase("pass")){
			sbDetailedReport.append(" <tr>"
					  +"              <td>"+intSNo+"</td>"
		              +"              <td>"+Action+"</td>"
		              +"              <td>"+Element+"</td>"
		              +"              <td>"+Value+"</td>"
		              +"              <td>"+ExpectedBehavior+"</td>"
		              +"              <td>"+ActualBehavior+"</td>"
					  +"              <td id ='Status' style='background-color:#43B02A; color:White;'>Pass</td>"
		              +"          </tr>"
		    );
			
			intSNo=intSNo+1;
		}else if(Result.equalsIgnoreCase("fail")){
			strOverallStatus="Fail";
			sbDetailedReport.append(" <tr>"
					  +"              <td>"+intSNo+"</td>"
		              +"              <td>"+Action+"</td>"
		              +"              <td>"+Element+"</td>"
		              +"              <td>"+Value+"</td>"
		              +"              <td>"+ExpectedBehavior+"</td>"
		              +"              <td>"+ActualBehavior+"</td>"
			          +"              <td id ='Status' style='background-color:Red; color:White;'>Fail</td>"
			          +"          </tr>"
			);		
			
			intSNo=intSNo+1;
		}else{
			System.out.println("logToReport Failed : Status should be Pass or Fail");
		}
	}
	
//##############################################################################################################################################################
// 49. browseFile method (uploads the file by browsing the file from system)
//##############################################################################################################################################################

	public void browseFile(String ObjectName, String strFileName) throws Exception{
		String strFName="",strPath="",strFileLocation="";
		try{			
			strFName=getTestData(strFileName);
			strPath=new File("./Assets/").getCanonicalPath();
			strFileLocation=strPath+"\\"+strFName;
			
			objLocator = getElementLocator(ObjectName);
 			lstElements = Driver.findElements(objLocator);
 			if(lstElements.size()>0){
 				lstElements.get(0).sendKeys(strFileLocation);
 				logResult(IEPath, "Browse File", "NA", strFName, "User should be able to browse file", "User is able to browse file : "+strFName, "Pass","");
 			}else
 			{
 				String path=captureScreenshot(ObjectName);
 				logResult(IEPath, "Browse File", "NA", strFName, "User should be able to browse file", "Object not found", "Fail",path);
 			}
		}catch(Exception browseFileException){
			System.out.println("browseFile Method Exception Message : " +browseFileException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Browse File", "NA", strFileName, "User should be able to browse file", "Browse file failed", "Fail",path);
		}
	}
	
//##############################################################################################################################################################
// 50. waitUntilAjaxCallComplete Method (Waits for Ajax Element to be Visible on the screen. 
// @throws IOException 
//##############################################################################################################################################################

	public void waitUntilAjaxCallComplete() throws IOException{
		try{
			new WebDriverWait(Driver, 120).until(new ExpectedCondition<Boolean>()
            {
				public Boolean apply(WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					return (Boolean)js.executeScript("return jQuery.active == 0");
            }
            });                                     
		}catch (Exception waitUntilAjaxCallCompleteException) {
			System.out.println("Wait Until Ajax Call Method Exception Message: "+waitUntilAjaxCallCompleteException);
		}           
	}  	

//##############################################################################################################################################################
// 51. Scroll Horizontal Method  - scroll to an Element through java script horizontally. Logs Result in Report)
//##############################################################################################################################################################

	public void scrollHorizontal(String ObjectName) throws Exception{
		try{
			WebDriverWait objjavascriptClickWait = new WebDriverWait(Driver, 120);
			objLocator = getElementLocator(ObjectName);
			objjavascriptClickWait.until(ExpectedConditions.elementToBeClickable(objLocator));
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				JavascriptExecutor executor = (JavascriptExecutor)Driver;
				executor.executeScript("arguments[0].scrollIntoView();", lstElements.get(0));
				logResult(IEPath, "Scroll Horizontal", ObjectName , "NA", "User should be able to Scroll Horizontally ", "User is able to Scroll horizontally", "Pass","");
			}else{
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "Scroll Horizontal", ObjectName , "NA", "User should be able to Scroll Horizontally ", "User is not able to Scroll horizontally", "Fail",path);
			}
		}catch (Exception scrollHorizontalException){                                         
			System.out.println("scrollHorizontal Method Exception Message: "+scrollHorizontalException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Scroll Horizontal", ObjectName , "NA", "User should be able to Scroll Horizontally ", "User is not able to Scroll horizontally", "Fail",path);
		}finally{
			lstElements.clear();
		}
	}

//##############################################################################################################################################################
// 52. javascriptClick Method -Clicks on Element through javascript. Logs Result in Report
//##############################################################################################################################################################

	public void javascriptClick(String ObjectName,int index) throws Exception{
		try{
			boolean bFound=false;
			List<String> getLocator = mapObjectRepository.get(ObjectName);
			String strLocatorType=getLocator.get(0);
			String strLocatorOldValue = getLocator.get(1);	
			if(strLocatorOldValue.contains("index")){
				bFound=true;
				String istr=Integer.toString(index);
				String strLocatorNewValue=strLocatorOldValue.replace("index",istr);
				lstLocators = new ArrayList<>();
				lstLocators.add(strLocatorType);
				lstLocators.add(strLocatorNewValue);
				mapObjectRepository.put(ObjectName, lstLocators); 
			}					
			WebDriverWait objjavascriptClickWait = new WebDriverWait(Driver, 120);
			objLocator = getElementLocator(ObjectName);
			objjavascriptClickWait.until(ExpectedConditions.elementToBeClickable(objLocator));
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				JavascriptExecutor executor = (JavascriptExecutor)Driver;
				if(bFound){
					executor.executeScript("arguments[0].click();", lstElements.get(0));
				}else{
					executor.executeScript("arguments[0].click();", lstElements.get(index));
				}				
				logResult(IEPath, "Click", ObjectName , "NA", "User should be able to click on "+ObjectName, "User is able to click on "+ObjectName, "Pass","");
 			}else{
 				String path=captureScreenshot(ObjectName);
 				logResult(IEPath, "Click", ObjectName, "NA", "User should be able to click on "+ObjectName, ObjectName+": Object not found", "Fail",path);
 			}
			if(bFound){
				lstLocators = new ArrayList<>();
				lstLocators.add(strLocatorType);
				lstLocators.add(strLocatorOldValue);
				mapObjectRepository.put(ObjectName, lstLocators);	
			}
		}catch (Exception javascriptClickException){			
			System.out.println("JavascriptClick Method Exception Message: "+javascriptClickException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Click", ObjectName, "NA", "User should be able to click on "+ObjectName, ObjectName+": Object not found", "Fail",path);
		}finally{
			lstElements.clear();
		}
	}
	

//##############################################################################################################################################################
// 53. scrollToElement Method - scroll to an Element
//##############################################################################################################################################################

	public void scrollToElement(String ObjectName) throws Exception{
		try{
			objLocator = getElementLocator(ObjectName);
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				JavascriptExecutor executor = (JavascriptExecutor)Driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", lstElements.get(0));
				logResult(IEPath, "ScrollToElement", ObjectName , "NA", "User should be able to scroll to object-"+ObjectName, "User is able to scroll to object-"+ObjectName, "Pass","");
 			}else{
 				String path=captureScreenshot(ObjectName);
 				logResult(IEPath, "ScrollToElement", ObjectName , "NA", "User should be able to scroll to object-"+ObjectName, "User is not able to scroll to object-"+ObjectName, "Fail",path);
 	 		}			
		}catch (Exception scrollToElementException){			
			System.out.println("scrollToElement Method Exception Message: "+scrollToElementException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "ScrollToElement", ObjectName, "NA", "User should be able to scroll to object-"+ObjectName, ObjectName+": Object not found", "Fail",path);
		}finally{
			lstElements.clear();
		}
	}
		
//##############################################################################################################################################################
// 54. scrollToElement Method - scroll to an Element of an object
//##############################################################################################################################################################

	public void scrollToElement(String ObjectName,int index) throws Exception{
		try{
			boolean bFound=false;
			List<String> getLocator = mapObjectRepository.get(ObjectName);
			String strLocatorType=getLocator.get(0);
			String strLocatorOldValue = getLocator.get(1);	
			if(strLocatorOldValue.contains("index")){
				bFound=true;
				String istr=Integer.toString(index);
				String strLocatorNewValue=strLocatorOldValue.replace("index",istr);
				lstLocators = new ArrayList<>();
				lstLocators.add(strLocatorType);
				lstLocators.add(strLocatorNewValue);
				mapObjectRepository.put(ObjectName, lstLocators); 
			}		
			objLocator = getElementLocator(ObjectName);
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				JavascriptExecutor executor = (JavascriptExecutor)Driver;
				if(bFound){
					executor.executeScript("arguments[0].scrollIntoView(true);", lstElements.get(0));
				}else{
					executor.executeScript("arguments[0].scrollIntoView(true);", lstElements.get(index));
				}				
				logResult(IEPath, "ScrollToElement", ObjectName , "NA", "User should be able to scroll to object-"+ObjectName, "User is able to scroll to object-"+ObjectName, "Pass","");
 			}else{
 				String path=captureScreenshot(ObjectName);
 				logResult(IEPath, "ScrollToElement", ObjectName , "NA", "User should be able to scroll to object-"+ObjectName, "User is not able to scroll to object-"+ObjectName, "Fail",path);
 	 		}
			if(bFound){
				lstLocators = new ArrayList<>();
				lstLocators.add(strLocatorType);
				lstLocators.add(strLocatorOldValue);
				mapObjectRepository.put(ObjectName, lstLocators);	
			}
		}catch (Exception scrollToElementException){			
			System.out.println("scrollToElement Method Exception Message: "+scrollToElementException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "ScrollToElement", ObjectName, "NA", "User should be able to scroll to object-"+ObjectName, ObjectName+": Object not found", "Fail",path);
		}finally{
			lstElements.clear();
		}
	}	

//##############################################################################################################################################################
// 55. checkObjectStatus Method - checks the object status of an element
//##############################################################################################################################################################

	public boolean checkObjectStatus(String ObjectName, String strType) throws Exception{
	
		boolean checkStatus=false;
		try{
			objLocator = getElementLocator(ObjectName);
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				switch(strType.toLowerCase()){
					case "visible":
						checkStatus=lstElements.get(0).isDisplayed();
					case "present":
						checkStatus=lstElements.size()>0;
					case "enabled":
						checkStatus=lstElements.get(0).isEnabled();
					case "disabled":
						if(lstElements.get(0).isEnabled()){
							checkStatus=false;
						}else{
							checkStatus=true;
						}							
					case "selected":
						checkStatus=lstElements.get(0).isSelected();						
				}
				System.out.println(ObjectName + " Object "+strType+" Status : "+ checkStatus);
				logResult(IEPath, "checkObjectStatus", ObjectName, "NA", ObjectName+" Object Status - "+ strType, ObjectName+" Object Status - " + checkStatus, "Pass","");
			}else{
				checkStatus=false;
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "checkObjectStatus", ObjectName, "NA", "Check object Status", ObjectName+": Object not found", "Fail",path);
			}
		}catch(Exception checkObjectStatusException){			
			checkStatus=false;
			System.out.println("checkObjectStatus Method Exception Message: "+checkObjectStatusException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "checkObjectStatus", ObjectName, "NA", "Check object Status", ObjectName+": Object not found", "Fail",path);
		}
		return checkStatus;
	}
	
//##############################################################################################################################################################
// 56. Submit Method (Submit on an element. Logs Result in Report)
//##############################################################################################################################################################
			
	public void submit(String ObjectName) throws Exception{
		try{
			objLocator = getElementLocator(ObjectName);
			lstElements = Driver.findElements(objLocator);
			if(lstElements.size()>0){
				lstElements.get(0).submit();	
				logResult(IEPath, "Submit", ObjectName , "NA", "User should be able to submit "+ObjectName, "User is able to submit "+ObjectName, "Pass","");
			}else{
				System.out.println(ObjectName+": Object not found");
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "Submit", ObjectName, "NA", "User should be able to submit "+ObjectName, ObjectName+": Object not found", "Fail",path);				
			}
		}catch (Exception submitException){
			System.out.println("Submit Method Exception Message: "+submitException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "Submit", ObjectName, "NA", "User should be able to submit "+ObjectName, ObjectName+": Object not found", "Fail",path);			
		}finally{
			lstElements.clear();
		}
	}
	
//##############################################################################################################################################################
// 57. newFileName Method - Generates new filename and renames the existing file with the new filename
//##############################################################################################################################################################
			
	public String newFileName(String strFileName) throws Exception{
		String newfile="";
		try{
			String strFName=getTestData(strFileName);
			File file = new File("./Assets/"+strFName);
			if(file.exists()) { 
	            System.out.println("File exists : " + strFName);
	            newfile = getCurrentDatenTime("ddMMMyyyy")+"_"+getCurrentDatenTime("HHmmss")+"_"+strFName;
	            System.out.println("New FileName : "+ newfile);
	            File file1 = new File("./Assets/"+newfile);
	            file.renameTo(file1);
	            updateTestData(strFileName, newfile);
	            addToTestData(newfile,strFName);	            
	        }else{
	        	System.out.println("File does not exist in Assets Folder : " + strFName);
	        }			
		}catch (Exception newfilenameException){
			System.out.println("newfilename Method Exception Message: "+newfilenameException);
		}		
		return newfile;
	}
	
//##############################################################################################################################################################
// 58. rewriteFileName Method - Writes back the old filename into Assets folder
//##############################################################################################################################################################
			
	public void rewriteFileName(String strNewFileName) throws Exception{
		try{
			if(strNewFileName.equals("")){
				System.out.println("Please specify proper file name to rewrite");
			}else{
				String strOldFileName=getTestData(strNewFileName);				
				File file = new File("./Assets/"+strNewFileName);
				if(file.exists()) { 
		            System.out.println("File exists : " + strNewFileName);
		            File file1 = new File("./Assets/"+strOldFileName);
		            file.renameTo(file1);	            
		        }else{
		        	System.out.println("File does not exist in Assets Folder : " + strNewFileName);
		        }		
			}
		}catch (Exception newfilenameException){
			System.out.println("newfilename Method Exception Message: "+newfilenameException);
		}
	}
	
//##############################################################################################################################################################
// 59. dragAndDrop Method - Drag and Drop an element 
//##############################################################################################################################################################
				
	public void dragAndDrop(String strSource,String strTarget) throws Exception{
		try{
			objLocator = getElementLocator(strSource);
			By objLocator1 = getElementLocator(strTarget);
			List<WebElement> source = Driver.findElements(objLocator);
			List<WebElement> target = Driver.findElements(objLocator1);
				
			if(source.size()>0 && target.size()>0){
				Actions objActions=new Actions(Driver);				
				objActions.dragAndDrop(source.get(0), target.get(0)).build().perform();
				logResult(IEPath, "DragAndDrop", strSource , "NA", "User should be able to drag and drop", "User is able to drag and drop", "Pass","");
			}else{
				String path="";
				if(source.size()<=0){
					System.out.println(strSource+": Source object not found");
					path=captureScreenshot(strSource);
				}else if(target.size()<=0){
					System.out.println(strTarget+": Target object not found");
					path=captureScreenshot(strTarget);
				}else{
					System.out.println(strSource+": Source object not found");
					System.out.println(strTarget+": Traget object not found");
					path=captureScreenshot(strSource);
				}				
				logResult(IEPath, "DragAndDrop", strSource, "NA", "User should be able to drag and drop", "Object not found", "Fail",path);				
			}
				
		}catch (Exception dragAndDropException){
			System.out.println("DragAndDrop Method Exception Message: "+dragAndDropException);
			String path=captureScreenshot(strSource);
			logResult(IEPath, "DragAndDrop", strSource, "NA", "User should be able to drag and drop", "Exception error occured", "Fail",path);				
		}
	}
	
//##############################################################################################################################################################
// 60. moveAndClick Method - Move and click the Element 
//##############################################################################################################################################################
				
	public void moveAndClick(String ObjectName) throws Exception{
		try{
			objLocator = getElementLocator(ObjectName);
			lstElements = Driver.findElements(objLocator);
				
			if(lstElements.size()>0){
				Actions objActions=new Actions(Driver);				
				objActions.moveToElement(lstElements.get(0)).click().build().perform();
				logResult(IEPath, "MoveAndClick", ObjectName , "NA", "User should be able to move and click", "User is able to move and click", "Pass","");
			}else{
				System.out.println(ObjectName+": object not found");
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "MoveAndClick", ObjectName, "NA", "User should be able to move and click", "Object not found", "Fail",path);				
			}
				
		}catch (Exception MoveAndClickException){
			System.out.println("MoveAndClick Method Exception Message: "+MoveAndClickException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "MoveAndClick", ObjectName, "NA", "User should be able to move and click", "Exception error occured", "Fail",path);				
		}
	}
	
//##############################################################################################################################################################
// 61. moveAndClickObject Method - Move and click a different Element 
//##############################################################################################################################################################
					
	public void moveAndClickObject(String strMove, String strClick) throws Exception{
		try{
			objLocator = getElementLocator(strMove);
			By objLocator1 = getElementLocator(strClick);
			List<WebElement> source = Driver.findElements(objLocator);
			List<WebElement> target = Driver.findElements(objLocator1);
				
			if(source.size()>0 && target.size()>0){
				Actions objActions=new Actions(Driver);				
				objActions.moveToElement(source.get(0)).click(target.get(0)).build().perform();
				logResult(IEPath, "MoveAndClick", strMove , "NA", "User should be able to move and click the object", "User is able to move and click on object", "Pass","");
			}else{
				String path="";
				if(source.size()<=0){
					System.out.println(strMove+": Move object not found");
					path=captureScreenshot(strMove);
				}else if(target.size()<=0){
					System.out.println(strClick+": Click object not found");
					path=captureScreenshot(strClick);
				}else{
					System.out.println(strMove+": Move object not found");
					System.out.println(strClick+": Click object not found");
					path=captureScreenshot(strMove);
				}				
				logResult(IEPath, "MoveAndClick", strMove, "NA", "User should be able to move and click the object", "Object not found", "Fail",path);				
			}
				
		}catch (Exception moveAndClickObjectException){
			System.out.println("MoveAndClickObject Method Exception Message: "+moveAndClickObjectException);
			String path=captureScreenshot(strMove);
			logResult(IEPath, "MoveAndClick", strMove, "NA", "User should be able to move and click", "Exception error occured", "Fail",path);				
		}
	}

//##############################################################################################################################################################
// 62. getListText Method - returns the text of list of elements into an array
//##############################################################################################################################################################
	
	public String[] getListText(String ObjectName) throws Exception{
		String[] arrText=null;
		try{			
			objLocator = getElementLocator(ObjectName);
 			lstElements = Driver.findElements(objLocator);
 			if(lstElements.size()>0){
 				System.out.println("Number of elements : "+lstElements.size());
 				arrText=new String[lstElements.size()];
 				for(int i=0;i<lstElements.size();i++){
	 				arrText[i] = lstElements.get(i).getText();	
	 				if(arrText[i].equalsIgnoreCase(""))
	 				{
	 					arrText[i] = lstElements.get(i).getAttribute("innerHtml");	
	  				}
 				}
 				logResult(IEPath, "GetListText", ObjectName, "NA", "List of text value of "+ObjectName, "List of text value of "+ObjectName +" are retrieved" , "Pass","");
 	  		}else{
 				System.out.println(ObjectName+": Element not found");
 				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "GetListText", ObjectName, "NA", "List of text value of "+ObjectName, ObjectName +" Object not found", "Fail",path);
			}
		}catch (Exception getListTextException) {
			System.out.println("getListText Method Exception Message: "+getListTextException);
  			String path=captureScreenshot(ObjectName);
  			logResult(IEPath, "GetListText", ObjectName, "NA", "List of text value of "+ObjectName, "Exception error occured", "Fail",path);
  		}finally{
 			lstElements.clear();
 		}	
 		return arrText; 		 	 
	}
	
//##############################################################################################################################################################
// 63. contextMenuClick Method - click on the Element context menu
//##############################################################################################################################################################
				
	public void contextMenuClick(String ObjectName) throws Exception{
		try{
			objLocator = getElementLocator(ObjectName);
			lstElements = Driver.findElements(objLocator);
				
			if(lstElements.size()>0){
				Actions objActions=new Actions(Driver);				
				objActions.contextClick(lstElements.get(0)).build().perform();
				logResult(IEPath, "ContextMenuClick", ObjectName , "NA", "User should be able to click on context menu", "User is able to click on context menu", "Pass","");
			}else{
				System.out.println(ObjectName+": object not found");
				String path=captureScreenshot(ObjectName);
				logResult(IEPath, "ContextMenuClick", ObjectName, "NA", "User should be able to click on context menu", "Object not found", "Fail",path);				
			}
				
		}catch (Exception ContextClickException){
			System.out.println("ContextMenuClick Method Exception Message: "+ContextClickException);
			String path=captureScreenshot(ObjectName);
			logResult(IEPath, "ContextMenuClick", ObjectName, "NA", "User should be able to click on context menu", "Exception error occured", "Fail",path);				
		}
	}


}//End of WebActions class