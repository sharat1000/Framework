package businessFunctions;

import drivers.WebActions;

public class ReusableFunctions extends WebActions {
	
	public void appCenterLaunch(String strUrl) throws Exception {		
		loadUrl(strUrl);//AppCenter_STAGE_URL
		System.out.println("App Center Launched");
	}
}
