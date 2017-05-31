package testCases;

import org.testng.annotations.Test;

import businessFunctions.ReusableFunctions;

public class AppCenterWeb extends ReusableFunctions { 
	
	@Test
	public void verify_HomePage_AppImageCarousel() throws Exception {
		//loadUrl("Url");
		//type("SiteTitle","Recommended_App");
		String str=newFileName("TestFile");
		System.out.println("New File name : "+str);		
        appCenterLaunch("AppCenter_URL");
        waitUntil("Menu_Button","exist");
        click("Menu_Button");
        waitUntil("Login_Name","exist");
		verifyText("Login_Name","Login_Name_Value");	
		click("Menu_Button");
        click("Home_LeftArrow");
        click("Home_LeftArrow");
        click("Home_RightArrow");   
        waitUntil("Yammer","exist");
        click("Yammer");
        verifyText("App_Title","Featured_Image_App_Title");  
        rewriteFileName(str);
    }
	
	@Test
	public void verify_HomePage_RecommendedApps() throws Exception {
		appCenterLaunch("AppCenter_URL");
        click("Menu_Button");
		waitUntil("App_Name","exist");
		javascriptClick("App_Name");		
		waitUntil("Launch_Button","exist");
		verifyText("App_Title","Recommended_App");
		click("Launch_Button");
		waitUntil("Back_Button","exist");
        click("Back_Button");
      
	}
	
	@Test
	public void verify_HomePage_RecommendedApps_SeeAll() throws Exception {
		appCenterLaunch("AppCenter_URL");
		waitUntil("RecommendedApp_SeeAll","exist");
		/*javascriptClick("RecommendedApp_SeeAll");
		waitUntil("Recommended_Link","exist");
		verifyText("Recommended_Link", "Recommended_Link_Title");
		String str = getPropertyValue("Recommended_Link_Active","class");	
	    if (str.equalsIgnoreCase("active")){
        	System.out.println("Recommended Tab is the Default Tab");
        }else{
//        	System.out.println("Recommended Tab is not the Default Tab");
        }*/
	}
	
	@Test
	public void verify_Apps_Tabs() throws Exception{
		appCenterLaunch("AppCenter_URL");
		click("Menu_Button");
		//click("Apps_Link");
		/*verifyText("All_Link","All_Link_Title");
		click("All_Link");
		verifyText("Recommended_Link","Recommended_Link_Title");
		click("Recommended_Link");
		verifyText("New_Link","New_Link_Title");
		click("New_Link");
		verifyText("Top_Link","Top_Link_Title");
		click("Top_Link");*/
	}

	@Test
	public void verify_AppDetails_Comments() throws Exception {
		appCenterLaunch("AppCenter_URL");
		waitUntil("App_Name","exist");
		javascriptClick("App_Name");
		waitUntil("App_Date","exist");
		String Appdate = getText("App_Date");
		System.out.println("AppDetails");
		System.out.println("App Published Date : "+Appdate);
		waitUntil("App_Date","exist");
		String AppVersion = getText("App_Version");
		System.out.println("App Version : "+AppVersion);
		waitUntil("App_Support_Dev","exist");
		String AppSupportDevices = getText("App_Support_Dev");
		System.out.println("App Supporting Devices: "+AppSupportDevices);
		type("Feedback_Comments","Feedback_Comments");
		waitUntil("Review_Star3","exist");
		click("Review_Star3");
		waitUntil("Feedback_Submit_Button","exist");
		click("Feedback_Submit_Button");
		Thread.sleep(5000);
		waitUntil("Review_Check","exist");
		verifyText("Review_Check","Feedback_Comments");
		type("Feedback_Comments","Feedback_Comments_Updated");
		waitUntil("Review_Star5","exist");
		click("Review_Star5");
		waitUntil("Feedback_Submit_Button","exist");
		click("Feedback_Submit_Button");
		Thread.sleep(5000);
		waitUntil("Review_Check","exist");
		verifyText("Review_Check","Feedback_Comments_Updated");
		String str = getPropertyValue("Rating_Stars","style");
		System.out.println(str);
		String str1 = split(str, "%", 0);
		System.out.println(str1);
		switch (str1)
		{
			case "width: 20":
					System.out.println("Rating 1");
					break;
			case "width: 40":
					System.out.println("Rating 2");
					break;
			case "width: 60":
					System.out.println("Rating 3");
					break;
			case "width: 80":
					System.out.println("Rating 4");
					break;	
			case "width: 100":
					System.out.println("Rating 5");
					break;	
			default :
					System.out.println("No Rating");
					break;
		}			
	}
	
	@Test
	public void verify_Apps_Back() throws Exception {
		appCenterLaunch("AppCenter_URL");
		waitUntil("Menu_Button","exist");
		click("Menu_Button");
		waitUntil("Apps_Link","exist");
		click("Apps_Link");
		waitUntil("App_Name","exist");
		javascriptClick("App_Name");
		waitUntil("Back_Button","exist");
		click("Back_Button");
		waitUntil("Recommended_Link_Active","exist");
		String str = getPropertyValue("Recommended_Link_Active","class");	
	    if (str.equalsIgnoreCase("active"))
        {
        	System.out.println("You are in the Recommended Tab");
        }
        waitUntil("All_Link","exist");
		click("All_Link");
		waitUntil("Apps_All_App","exist");
		javascriptClick("Apps_All_App");
		waitUntil("Back_Button","exist");
		click("Back_Button");
		waitUntil("All_Link_Active","exist");
		String str1 = getPropertyValue("All_Link_Active","class");	
	    if (str1.equalsIgnoreCase("active"))
        {
        	System.out.println("You are in the All Tab");
        }
        waitUntil("New_Link","exist");
		click("New_Link");
		waitUntil("Apps_New_App","exist");
		javascriptClick("Apps_New_App");
		waitUntil("Back_Button","exist");
		click("Back_Button");
		waitUntil("New_Link_Active","exist");
		String str2 = getPropertyValue("New_Link_Active","class");	
	    if (str2.equalsIgnoreCase("active"))
        {
        	System.out.println("You are in the New Tab");
        }
		waitUntil("Top_Link","exist");
		click("Top_Link");
		waitUntil("Apps_Top_App","exist");
		javascriptClick("Apps_Top_App");
		waitUntil("Back_Button","exist");
		click("Back_Button");
		waitUntil("Top_Link_Active","exist");
		String str3 = getPropertyValue("Top_Link_Active","class");	
	    if (str3.equalsIgnoreCase("active"))
        {
        	System.out.println("You are in the Top Tab");
        }
	}
	
	@Test
	public void verify_View_Presentation_Button() throws Exception{
		appCenterLaunch("AppCenter_URL");
        waitUntil("Search_Box","exist");
 		type("Search_Box","View_Presentation_Button_App");
 		keyBoardActions("Enter_Click");
 		waitUntil("Search_Results","exist");
 		waitUntil("View_Presentation_Button_App","exist");
		javascriptClick("View_Presentation_Button_App");
		waitUntil("View_Presentation_Button","exist");
		verifyExist("View_Presentation_Button");
		click("View_Presentation_Button");
		
	}
	
	@Test
	public void verify_Search() throws Exception{
		appCenterLaunch("AppCenter_URL");
        waitUntil("Search_Box","exist");
		type("Search_Box","Search_Box_Value");
		keyBoardActions("Enter_Click");
		waitUntil("Search_Results","exist");
		String searchRes = getText("Search_Results");
		System.out.println(searchRes);
		waitUntil("Search_App","exist");
		javascriptClick("Search_App");
		verifyText("App_Title","Search_Box_Value");
	}
	
	@Test
	public void verify_Share_Yammer() throws Exception{
		appCenterLaunch("AppCenter_URL");
		click("Menu_Button");
		waitUntil("Learning_Link","exist");
		click("Learning_Link");
		waitUntil("PDF_App","exist");
		javascriptClick("PDF_App");
		waitUntil("Share_Button","exist");
		javascriptClick("Share_Button");
		javascriptClick("Share_Yammer");
	}	
		
	@Test
	public void verify_Learning_Content() throws Exception{
		appCenterLaunch("AppCenter_URL");
		waitUntil("Menu_Button","exist");
		click("Menu_Button");
		waitUntil("Learning_Link","exist");
		click("Learning_Link");
		waitUntil("PDF_App","exist");
		javascriptClick("PDF_App");
		waitUntil("Launch_Button","exist");
		click("Launch_Button");
	}
	
	@Test
	public void verify_Presentation_Files_Download() throws Exception{
		appCenterLaunch("AppCenter_URL");
		waitUntil("Search_Box","exist");
		type("Search_Box","Presentation_App");
		keyBoardActions("Enter_Click");
		waitUntil("Search_Results","exist");
		waitUntil("Presentation_App","exist");
		javascriptClick("Presentation_App");
		waitUntil("Launch_Button","exist");
		click("Launch_Button");
	}
		
	@Test
	public void verify_Learning_SeeAll() throws Exception {
		appCenterLaunch("AppCenter_URL");
		waitUntil("Learn_SeeAll","exist");
		javascriptClick("Learn_SeeAll");
		waitUntil("Featured_Link","exist");
		verifyText("Featured_Link", "Featured_Link_Title");
		String str = getPropertyValue("Featured_Link_Active","class");
		if (str.equalsIgnoreCase("active")){
        	System.out.println("Featured Tab is the Default Tab");
        }else{
        	System.out.println("Featured Tab is not the Default Tab");
        }
	}
	
	@Test
	public void verify_Learning_Back() throws Exception {
		appCenterLaunch("AppCenter_URL");
		waitUntil("Menu_Button","exist");
		click("Menu_Button");
		waitUntil("Learning_Link","exist");
		click("Learning_Link");
		waitUntil("Featured_Link","exist");
		verifyText("Featured_Link", "Featured_Link_Title");
		waitUntil("Learning_Featured_App","exist");
		javascriptClick("Learning_Featured_App");
		waitUntil("Back_Button","exist");
		click("Back_Button");
		waitUntil("Featured_Link_Active","exist");
		String str = getPropertyValue("Featured_Link_Active","class");	
	    if (str.equalsIgnoreCase("active"))
        {
        	System.out.println("You are in the Learning Featured Tab");
        }
        waitUntil("All_Link","exist");
        verifyText("All_Link", "All_Link_Title");
		click("All_Link");
		waitUntil("Learning_All_App","exist");
		javascriptClick("Learning_All_App");
		waitUntil("Back_Button","exist");
		click("Back_Button");
		waitUntil("All_Link_Active","exist");
		String str1 = getPropertyValue("All_Link_Active","class");	
	    if (str1.equalsIgnoreCase("active"))
        {
        	System.out.println("You are in the Learning All Tab");
        }
        waitUntil("New_Link","exist");
        verifyText("New_Link", "New_Link_Title");
		click("New_Link");
		waitUntil("Learning_New_App","exist");
		javascriptClick("Learning_New_App");
		waitUntil("Back_Button","exist");
		click("Back_Button");
		waitUntil("New_Link_Active","exist");
		String str2 = getPropertyValue("New_Link_Active","class");	
	    if (str2.equalsIgnoreCase("active"))
        {
        	System.out.println("You are in the Learning New Tab");
        }
	}	
	
	@Test
	public void verify_MyPlaylist_AddingApp() throws Exception{
		appCenterLaunch("AppCenter_URL");
        waitUntil("Learn_SeeAll","exist");
		javascriptClick("Learn_SeeAll");
		waitUntil("New_Link","exist");
		click("New_Link");
		waitUntil("Learning_New_App","exist");
		javascriptClick("Learning_New_App");
		waitUntil("AddToPlaylist_Button","exist");
		click("AddToPlaylist_Button");
		Thread.sleep(5000);
		String str1 = getText("RemoveFromPlaylist_Button");
		System.out.println(str1);
		compareStrings("Remove from playlist",str1);
		waitUntil("Back_Button","exist");
		click("Back_Button");
		waitUntil("Menu_Button","exist");
		click("Menu_Button");
		waitUntil("MyPlaylist_Link","exist");
		javascriptClick("MyPlaylist_Link");
		verifyExist("Learning_New_App");
		
	}
	
	@Test
	public void verify_MyPlaylist_RemovingApp() throws Exception{
		appCenterLaunch("AppCenter_URL");
        click("Menu_Button");
		waitUntil("MyPlaylist_Link","exist");
		click("MyPlaylist_Link");
		waitUntil("Learning_New_App","exist");
		javascriptClick("Learning_New_App");
		waitUntil("RemoveFromPlaylist_Button","exist");
		click("RemoveFromPlaylist_Button");
		Thread.sleep(5000);
		String str1 = getText("AddToPlaylist_Button");
		System.out.println(str1);
		compareStrings("Add to playlist",str1);
		waitUntil("Back_Button","exist");
		click("Back_Button");
		click("Menu_Button");
		waitUntil("MyPlaylist_Link","exist");
		javascriptClick("MyPlaylist_Link");
		verifyNotExist("Learning_New_App");
	}
	
	@Test
	public void verify_MyPlaylist_Edit() throws Exception{
		appCenterLaunch("AppCenter_URL");
		waitUntil("Learn_SeeAll","exist");
		javascriptClick("Learn_SeeAll");
		Thread.sleep(6000);
		waitUntil("Learning_Featured_App","exist");
		javascriptClick("Learning_Featured_App");
		waitUntil("AddToPlaylist_Button","exist");
		click("AddToPlaylist_Button");
		waitUntil("Back_Button","exist");
		click("Back_Button");
		waitUntil("Menu_Button","exist");
		click("Menu_Button");
		waitUntil("MyPlaylist_Link","exist");
		click("MyPlaylist_Link");
		waitUntil("MyPlaylist_Edit","exist");
		click("MyPlaylist_Edit");
		verifyExist("Learning_Featured_App");
		waitUntil("App_Delete_Icon","exist");
		click("App_Delete_Icon");
		waitUntil("MyPlaylist_Done","exist");
		click("MyPlaylist_Done");
		verifyNotExist("Learning_Featured_App");
	}
	
	@Test
	public void verify_HiddentItems() throws Exception{
		appCenterLaunch("AppCenter_URL");
        waitUntil("Menu_Button","exist");
		click("Menu_Button");
		waitUntil("Learning_Link","exist");
		click("Learning_Link");
		waitUntil("Hidden_App","exist");
		waitUntil("Hide_Options_Icon","exist");
		click("Hide_Options_Icon");
		javascriptClick("Hide_Option");
		verifyNotExist("Hidden_App");
		waitUntil("Menu_Button","exist");
		click("Menu_Button");
		waitUntil("HiddenItems_Link","exist");
		click("HiddenItems_Link");
		verifyExist("Hidden_App");
		waitUntil("Hide_Options_Icon1","exist");
		click("Hide_Options_Icon1");
		javascriptClick("Unhide_Option");
		verifyNotExist("Hidden_App");
		click("Menu_Button");
		waitUntil("Learning_Link","exist");
		click("Learning_Link");
		verifyExist("Hidden_App");
	}
	
	@Test
	public void verify_Language() throws Exception{
		appCenterLaunch("AppCenter_URL");
        click("Menu_Button");
		waitUntil("Language_Link","exist");
		click("Language_Link");
		waitUntil("English_Check","exist");
		String strCheck=getPropertyValue("English_Check","checked");
		boolean bchk=Boolean.parseBoolean(strCheck);
		if (bchk){
			System.out.println("English language is selected by default");
		}
		verifyText("Language_Chinese","Language_Option1");
		verifyText("Language_English","Language_Option2");
		verifyText("Language_French","Language_Option3");
		verifyText("Language_German","Language_Option4");
		verifyText("Language_Portuguese","Language_Option5");
		verifyText("Language_Russian","Language_Option6");
		verifyText("Language_Spanish","Language_Option7");
		
		click("English_Check");
		waitUntil("Save_Button","exist");
		click("Save_Button");
		click("English_Check");
		waitUntil("Save_Button","exist");
		click("Save_Button");		
		waitUntil("Language_Error","exist");
		verifyText("Language_Error","Language_Error_Msg");
		click("English_Check");
		waitUntil("Save_Button","exist");
		click("Save_Button");
	}
	
	@Test
	public void verify_About() throws Exception{
		appCenterLaunch("AppCenter_URL");
	    click("Menu_Button");
		waitUntil("About_Link","exist");
		click("About_Link");
		waitUntil("Terms","exist");
		click("Terms");
		String strEnv = getTestData("AppCenter_Env");
		if (strEnv.equalsIgnoreCase("qa")){
			verifyText("AppCenter_Version","AppCenter_Version");
			verifyText("AppCenter_QA_Env","AppCenter_Env");
			verifyText("Terms_Header_QA","AppCenter_Terms");	
			waitUntil("Privacy","exist");
			click("Privacy");
			verifyText("AppCenter_Version","AppCenter_Version");
			verifyText("Privacy_Header_QA","AppCenter_Privacy");		
		}else if (strEnv.equalsIgnoreCase("Staging")){
			verifyText("AppCenter_Version","AppCenter_Version");
			verifyText("AppCenter_STAGE_Env","AppCenter_Env");
			verifyText("Terms_Header","AppCenter_Terms",3);	
			waitUntil("Privacy","exist");
			click("Privacy");
			verifyText("AppCenter_Version","AppCenter_Version");
			verifyText("Privacy_Header","AppCenter_Privacy");		
		}else{
			verifyText("AppCenter_Version","AppCenter_Version");
			verifyText("Terms_Header","AppCenter_Terms",2);	
			waitUntil("Privacy","exist");
			click("Privacy");
			verifyText("AppCenter_Version","AppCenter_Version");
			verifyText("Privacy_Header","AppCenter_Privacy");		
		}
		verifyExist("About");
	}
	
	@Test
	public void createNewInnovationBestPractice()throws Exception{            
        waitUntil("CMS_CreateNew_Button","exist");
        Thread.sleep(2000);
        
        javascriptClick("CMS_CreateNew_Button");          
        Thread.sleep(2000);
        
        String CMSTitle=getTestData("ICH_CreateNew_Title_Value");
        System.out.println(CMSTitle);
        updateTestData("CMSTitle",CMSTitle);
        
        type("CMS_CreateNew_Title",CMSTitle);
        Thread.sleep(2000);
        
        iFrameSwitch("ICH_CreateNew_Description_Iframe");
        Thread.sleep(3000);
        javascriptClick("ICH_CreateNew_Description");
        type("ICH_CreateNew_Description","ICH_CreateNew_Title_Value");
        exitFrame();                        
        
        scrollToElement("CMS_CreateNew_Category");
        javascriptClick("CMS_CreateNew_Category");
        click("CMS_CreateNew_Category_BestPractice");      
        
        
        scrollToElement("CMS_CreateNew_Country(s)");
        javascriptClick("CMS_CreateNew_Country(s)");
        type("CMS_CreateNew_Country(s)","CMS_CreateNew_Country(s)_value");
        waitUntil("CMS_CreateNew_Country(s)_India","exists");
        click("CMS_CreateNew_Country(s)_India");
                                                                    
        scrollToElement("CMS_CreateNew_Function");
        select("CMS_CreateNew_Function","CMS_CreateNew_Function_value1","text");      
              
        javascriptClick("CMS_CreateNew_Industry(s)");
        Thread.sleep(2000);
        waitUntil("CMS_CreateNew_Industry(s)_value","exists");
        select("CMS_CreateNew_Industry(s)_value","CMS_CreateNew_Industry_value","text");
        
        javascriptClick("CMS_CreateNew_Sector(s)");
        Thread.sleep(2000);
        waitUntil("CMS_CreateNew_Sector(s)_value","exists");
        select("CMS_CreateNew_Sector(s)_value","CMS_CreateNew_Sector(s)_value","text");
        
              
        javascriptClick("CMS_CreateNew_Technologies");
        Thread.sleep(2000);
        waitUntil("CMS_CreateNew_Technologies_value","exists");
        select("CMS_CreateNew_Technologies_value","CMS_CreateNew_Technologies_value","text");
        
        browseFile("CMS_CreateNew_Thumbnail","Thumbnail_File");
        Thread.sleep(2000);
        
        type("CMS_CreateNew_Owner","ICH_CreateNew_SelectOwner_Value");
        Thread.sleep(5000);
        waitUntil("CMS_CreateNew_Owner_Bala","exists");
        click("CMS_CreateNew_Owner_Bala");        
        
        
      scrollToElement("CMS_CreateNew_Attachments");
        javascriptClick("CMS_CreateNew_Attachments");
        browseFile("CMS_CreateNew_Attachments_Attachfile","Thumbnail_File");
        submit("CMS_CreateNew_Attachments_Attachfile_Upload");
        Thread.sleep(5000);
        click("CMS_CreateNew_Attachments_Attachfile_Close");
              
        scrollToElement("CMS_CreateNew_PreviewItems");
        javascriptClick("CMS_CreateNew_PreviewItems");
        browseFile("CMS_CreateNew_Attachments_PreviewItem_Image","PreviewItem_Image_File");
        submit("CMS_CreateNew_Attachments_PreviewItem_Image_Upload");
              
        javascriptClick("CMS_CreateNew_Attachments_PreviewItem_Videooption");
        
        type("CMS_CreateNew_Attachments_PreviewItem_Videooption_Videolink","ICH_CreateNew_VideoURL_Text");
        browseFile("CMS_CreateNew_Attachments_PreviewItem_Videoption_Image","PreviewItem_Image_File");
        submit("CMS_CreateNew_Attachments_PreviewItem_Image_Upload");
        Thread.sleep(5000);
        click("CMS_CreateNew_Attachments_PreviewItem_Image_Close");
        
        scrollToElement("CMS_CreateNew_Ipramification");
        select("CMS_CreateNew_Ipramification","CMS_CreateNew_Ipramification_value","text");
        Thread.sleep(2000);
        
        scrollToElement("CMS_CreateNew_Save");
        javascriptClick("CMS_CreateNew_Save");
        Thread.sleep(10000);        
        
  }

}

