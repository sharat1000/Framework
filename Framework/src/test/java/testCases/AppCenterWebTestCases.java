package testCases;

import org.testng.annotations.Test;

import businessFunctions.ReusableFunctions;

public class AppCenterWebTestCases extends ReusableFunctions { 
	
		@Test
		public void testCase1() throws Exception {
			appCenterLaunch("AppCenter_STAGE_URL");
			System.out.println("App Center Entered");
			System.out.println("testcase 1");	
			String str=getTestData("Testdata1");
			String str1=getTestData("Testdata2");
			System.out.println(str);
			System.out.println(str1);
			//click("Review_Star2");
			
			//waitUntil("Top_Menu_Button", "exists");
			//click("Top_Menu_Button");
			//click("Review_Star2");
			//System.out.println("testcase 1+1");
			/*waitUntil("Home_LeftArrow","exists");
			click("Home_LeftArrow");
			waitUntil("Home_RightArrow","exists");
			click("Home_RightArrow");
			waitUntil("DPN_Mobile_Home_Img","exists");
			click("DPN_Mobile_Home_Img");
			waitUntil("Home_Img_Back_Button","exists");
			click("Home_Img_Back_Button");
			waitUntil("Home_RightArrow","exists");
			click("Home_RightArrow");
			waitUntil("Access_Mobile_Home_Img","exists");
			click("Access_Mobile_Home_Img");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Home_Link","exists");
			click("Home_Link");*/
			
		}
		
		@Test
		public void testCase2() throws Exception {
			
			appCenterLaunch("AppCenter_STAGE_URL");
			System.out.println("testcase 2");
			//String pathh="C:\\Users\\sutla\\Desktop";
			//writeExcel(pathh,"Test.xlsx","Sheet1",2,3,"Sharat");
			//String str1=readExcel(pathh,"Test.xlsx","Sheet1",2,3);
			//System.out.println("Cell value: "+str1);
			/*waitUntil("RecommendedApp_Deloitte_EVM","exists");
			click("RecommendedApp_Deloitte_EVM");
			waitUntil("Feedback_Comments","exists");
			type("Feedback_Comments","Feedback");
			waitUntil("Review_Star1","exists");
			click("Review_Star1");
			waitUntil("Review_Star2","exists");
			click("Review_Star2");
			waitUntil("Review_Star3","exists");
			click("Review_Star3");
			waitUntil("Feedback_Submit_Button","exists");
			click("Feedback_Submit_Button");
            waitUntil("Home_Img_VersionDetails","exists");
			click("Home_Img_VersionDetails");
			waitUntil("Home_Img_Launch_Button","exists");
			click("Home_Img_Launch_Button");
			*/
		}
		/*
		@Test
		public void testCase13_14() throws Exception {
			appCenterLaunch("AppCenter_STAGE_URL");
			waitUntil("RecommendedApp_SeeAll","exists");
			click("RecommendedApp_SeeAll");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Home_Link","exists");
			click("Home_Link");
			waitUntil("FeaturedLearn_SeeAll","exists");
			click("FeaturedLearn_SeeAll");
			System.out.println("App Center Launched");	
			
		}
		@Test
		public void testCase7() throws Exception {
			appCenterLaunch("AppCenter_STAGE_URL");
			waitUntil("RecommendedApp_Deloitte_EVM","exists");
			click("RecommendedApp_Deloitte_EVM");
			waitUntil("App_Date_Version","exists");
			String dateVersionDetails = getText("App_Date_Version");
			System.out.println(dateVersionDetails);
		}
		@Test
public void testCase8_16() throws Exception {
			
			appCenterLaunch("AppCenter_STAGE_URL");
			waitUntil("RecommendedApp_Deloitte_EVM","exists");
			click("RecommendedApp_Deloitte_EVM");
			waitUntil("Feedback_Comments","exists");
			type("Feedback_Comments","Feedback updated");
			waitUntil("Review_Star1","exists");
			click("Review_Star1");
			waitUntil("Review_Star2","exists");
			click("Review_Star2");
			waitUntil("Review_Star3","exists");
			click("Review_Star3");
			waitUntil("Feedback_Submit_Button","exists");
			click("Feedback_Submit_Button");
			waitUntil("Review_Check","exists");
			//verifyText("AppVersion_Review_Check","HTML");
			String comments1 = getText("Review_Check");
			System.out.println(comments1);
			
		}
		@Test
public void testCase11() throws Exception {
	
	appCenterLaunch("AppCenter_STAGE_URL");
	waitUntil("RecommendedApp_Deloitte_EVM","exists");
	click("RecommendedApp_Deloitte_EVM");
	waitUntil("Review_Star1","exists");
	click("Review_Star1");
	waitUntil("Review_Star2","exists");
	click("Review_Star2");
	//waitUntil("Review_Star3","exists");
	//click("Review_Star3");
	//waitUntil("Review_Star4","exists");
	//click("Review_Star4");
	waitUntil("Feedback_Submit_Button","exists");
	click("Feedback_Submit_Button");
	waitUntil("Review_Check","exists");
	//verifyText("AppVersion_Review_Check","HTML");
	String comments1 = getText("Review_Check");
	System.out.println(comments1);
	
}
		@Test
		public void appCenterApps() throws Exception{
			System.out.println("App Center Apps Link");
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Apps_Link","exists");
			click("Apps_Link");
			waitUntil("Apps_All","exists");
			click("Apps_All");
			waitUntil("Apps_Recommended","exists");
			click("Apps_Recommended");
			waitUntil("Apps_New","exists");
			click("Apps_New");
			waitUntil("Apps_Top","exists");
			click("Apps_Top");
			waitUntil("Apps_Filter","exists");
			click("Apps_Filter");
			waitUntil("Apps_SelectAll","exists");
			click("Apps_SelectAll");
			waitUntil("Apps_Apply","exists");
			click("Apps_Apply");
			waitUntil("Apps_loader","exists");
			//verifyExist("Apps_loader");
			verifyNotExist("Apps_loader");
			waitUntil("Apps_Filter","exists");
			click("Apps_Filter");
			waitUntil("Apps_Reset","exists");
			click("Apps_Reset");
			waitUntil("Apps_Apply","exists");
			click("Apps_Apply");
			waitUntil("Apps_loader","exists");
			verifyExist("Apps_loader");
			verifyNotExist("Apps_loader");
			waitUntil("Apps_Filter","exists");
			click("Apps_Filter");
			waitUntil("Filter_Platforms","exists");
			click("Filter_Platforms");
			waitUntil("Apps_SelectAll","exists");
			click("Apps_SelectAll");
			waitUntil("Apps_Apply","exists");
			click("Apps_Apply");
			waitUntil("Apps_loader","exists");
			verifyExist("Apps_loader");
			verifyNotExist("Apps_loader");
			waitUntil("Apps_Filter","exists");
			click("Apps_Filter");
			waitUntil("Apps_Reset","exists");
			click("Apps_Reset");
			waitUntil("Apps_Apply","exists");
			click("Apps_Apply");
				
		}
		@Test
		public void appCenterLearning() throws Exception{
			
			loadUrl("AppCenter_STAGE_URL");
			System.out.println("App Center MyApps Link");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("MyApps_Link","exists");
			click("MyApps_Link");
			System.out.println("App Center Learning Link");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Learning_Link","exists");
			click("Learning_Link");
			waitUntil("Learning_All","exists");
			click("Learning_All");
			waitUntil("Learning_New","exists");
			click("Learning_New");
			waitUntil("Learning_Filters","exists");
			click("Learning_Filters");
			waitUntil("Learning_SelectAll","exists");
			click("Learning_SelectAll");
			waitUntil("Learning_Apply","exists");
			click("Learning_Apply");
			waitUntil("Apps_loader","exists");
			verifyExist("Apps_loader");
			verifyNotExist("Apps_loader");
			waitUntil("Learning_Filters","exists");
			click("Learning_Filters");
			waitUntil("Learning_Reset","exists");
			click("Learning_Reset");
			waitUntil("Learning_Apply","exists");
			click("Learning_Apply");
			waitUntil("Apps_loader","exists");
			verifyExist("Apps_loader");
			verifyNotExist("Apps_loader");
			waitUntil("Learning_Filters","exists");
			click("Learning_Filters");
			waitUntil("Learning_Media","exists");
			click("Learning_Media");
			waitUntil("Learning_SelectAll","exists");
			click("Learning_SelectAll");
			waitUntil("Learning_Apply","exists");
			click("Learning_Apply");
			waitUntil("Apps_loader","exists");
			verifyExist("Apps_loader");
			verifyNotExist("Apps_loader");
			waitUntil("Learning_Filters","exists");
			click("Learning_Filters");
			waitUntil("Learning_Reset","exists");
			click("Learning_Reset");
			waitUntil("Learning_Apply","exists");
			click("Learning_Apply");
					
		}
		@Test
		public void appCenterMyPlayList() throws Exception{
			
			loadUrl("AppCenter_STAGE_URL");
			System.out.println("App Center MyPlayList Link");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("MyPlaylist_Link","exists");
			click("MyPlaylist_Link");
			waitUntil("MyPlaylist_Edit","exists");
			click("MyPlaylist_Edit");
		}
		@Test
		public void appCenterLanguage() throws Exception{
			
			loadUrl("AppCenter_STAGE_URL");
			System.out.println("App Center Hidden Link");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("HiddenItems_Link","exists");
			click("HiddenItems_Link");
			System.out.println("App Center Language Link");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Language_Link","exists");
			click("Language_Link");
			System.out.println("Selecting Languages");
			verifyExist("Chinese_Check");
			click("Chinese_Check");
			verifyExist("English_Check");
			click("English_Check");
			waitUntil("Save_Button","exists");
			click("Save_Button");
			
			}
		@Test
		public void appCenterAbout() throws Exception{
			loadUrl("AppCenter_STAGE_URL");
			System.out.println("App Center Hidden Link");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("About_Link","exists");
			click("About_Link");
			waitUntil("About_Terms","exists");
			click("About_Terms");
			waitUntil("About_Privacy","exists");
			click("About_Privacy");
			waitUntil("About_About","exists");
			click("About_About");
			
		}
		@Test
		public void testcase47() throws Exception{
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Login_Name","exists");
			String loginName = getText("Login_Name");
			System.out.println(loginName);
		}
		@Test
		public void testcase46() throws Exception{
			
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Search_Box","exists");
			type("Search_Box","Call Center");
			keyBoardActions("Enter_Click");
			waitUntil("Search_Results","exists");
			String searchRes = getText("Search_Results");
			System.out.println(searchRes);
			verifyText("Search_Results","Call Center - DERP");
		}
		@Test
		public void testcase45() throws Exception{
			
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Learning_Link","exists");
			click("Learning_Link");
			waitUntil("Learning_New","exists");
			click("Learning_New");
			waitUntil("Presentation_File","exists");
			click("Presentation_File");
		}
		@Test
		public void appLearning_Presentation_Download() throws Exception{
			
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Learning_Link","exists");
			click("Learning_Link");
			waitUntil("Learning_New","exists");
			click("Learning_New");
			waitUntil("Presentation_File_App","exists");
			click("Presentation_File_App");
			waitUntil("Learning_Launch_Button","exists");
			click("Learning_Launch_Button");
		}
		@Test
		public void appLearning_PDF_Download() throws Exception{
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Learning_Link","exists");
			click("Learning_Link");
			waitUntil("Learning_New","exists");
			click("Learning_New");
			waitUntil("PDF_File_App","exists");
			click("PDF_File_App");
			waitUntil("Learning_Launch_Button","exists");
			click("Learning_Launch_Button");
		}
		@Test
		public void appLearning_Email() throws Exception{
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Learning_Link","exists");
			click("Learning_Link");
			waitUntil("Learning_New","exists");
			click("Learning_New");
			waitUntil("PDF_File_App","exists");
			click("PDF_File_App");
			waitUntil("Learning_Share_Button","exists");
			click("Learning_Share_Button");
			waitUntil("Learning_Share_Email","exists");
			click("Learning_Share_Email");
			
		}
		
		@Test
		public void appLearning_Yammer() throws Exception{
			
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Learning_Link","exists");
			click("Learning_Link");
			waitUntil("Learning_New","exists");
			click("Learning_New");
			waitUntil("Presentation_File_App","exists");
			click("Presentation_File_App");
			waitUntil("Learning_Share_Button","exists");
			click("Learning_Share_Button");
			waitUntil("Learning_Share_Yammer","exists");
			click("Learning_Share_Yammer");
		}
		@Test
		public void appLearning_All_Download() throws Exception{
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Learning_Link","exists");
			click("Learning_Link");
			waitUntil("Learning_All","exists");
			click("Learning_All");
			waitUntil("Learning_All_App","exists");
			click("Learning_All_App");
			waitUntil("Learning_Launch_Button","exists");
			click("Learning_Launch_Button");
		}
		
		@Test
		public void appLearning_Featured_Download() throws Exception{
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Learning_Link","exists");
			click("Learning_Link");
			waitUntil("Learning_Featured","exists");
			click("Learning_Featured");
			waitUntil("Learning_Featured_App","exists");
			click("Learning_Featured_App");
			waitUntil("Learning_Launch_Button","exists");
			click("Learning_Launch_Button");
		}
		
		@Test
		public void apps_Recommended_Download() throws Exception{
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Apps_Link","exists");
			click("Apps_Link");
			waitUntil("Apps_Recommended_App","exists");
			click("Apps_Recommended_App");
			waitUntil("Apps_Launch_Button","exists");
			click("Apps_Launch_Button");
		}
		
		@Test
		public void apps_All_Download() throws Exception{
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Apps_Link","exists");
			click("Apps_Link");
			waitUntil("Apps_All","exists");
			click("Apps_All");
			waitUntil("Apps_All_App","exists");
			click("Apps_All_App");
			waitUntil("Apps_Launch_Button","exists");
			click("Apps_Launch_Button");
		}
		
		@Test
		public void apps_New_Download() throws Exception{
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Apps_Link","exists");
			click("Apps_Link");
			waitUntil("Apps_New","exists");
			click("Apps_New");
			waitUntil("Apps_New_App","exists");
			click("Apps_New_App");
			waitUntil("Apps_Launch_Button","exists");
			click("Apps_Launch_Button");
		}
		@Test
		public void apps_Top_Download() throws Exception{
			loadUrl("AppCenter_STAGE_URL");
			waitUntil("Top_Menu_Button","exists");
			click("Top_Menu_Button");
			waitUntil("Apps_Link","exists");
			click("Apps_Link");
			waitUntil("Apps_Top","exists");
			click("Apps_Top");
			waitUntil("Apps_Top_App","exists");
			click("Apps_Top_App");
			waitUntil("Apps_Launch_Button","exists");
			click("Apps_Launch_Button");
		}
*/
}
