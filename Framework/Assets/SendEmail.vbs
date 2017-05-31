Set args = Wscript.Arguments

If args.Length > 0 Then
    strProjName= args(0)
    strStatus= args(1)	
    strToEmail = args(2)
    strCCEmail = args(3)
    strAttachLocation = args(4)   
    strServerName = args(5)
    strbatchExec = args(6)    
    
    If StrComp(strbatchExec , "yes", vbTextCompare) = 0 Then
	Wscript.Echo strProjName + " " + strStatus + " " + strToEmail + " " + strCCEmail + " " + strAttachLocation + " " + strServerName + " " + strbatchExec
    	Set oEmail = CreateObject("CDO.Message")

   	oEmail.From = "Automation Reports (Do Not Reply)<BSACOP@deloitte.com>"
    	oEmail.To = strToEmail
    	If strCCEmail <> "None" Then
        	oEmail.Cc = strCCEmail
    	End If 	
    	oEmail.Subject = strStatus & " - Automation Execution Reports - " & Date & " - " & strProjName
    	oEmail.Textbody = "Hi," & vbNewLine & vbNewLine & "Automation Execution is completed successfully. Please find attached Automation Execution reports." & vbNewLine & vbNewLine & "Thanks," & vbNewLine & "BSACOP Automation Team"
 
    	oEmail.AddAttachment strAttachLocation
	
    	oEmail.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/sendusing") = 2
    	oEmail.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/smtpserver") = strServerName
    	oEmail.Configuration.Fields.Update

    	oEmail.Send
    	Set oEmail = Nothing
	Wscript.Echo "Email Sent successfully"  

    Else
	Wscript.Echo strProjName + " " + strStatus + " " + strToEmail + " " + strCCEmail + " " + strAttachLocation + " " + strbatchExec
	Set outobj = CreateObject("Outlook.Application")
    	Set mailobj = outobj.CreateItem(0)
    	With mailobj
    	.To = strToEmail  
       	If strCCEmail <> "None" Then
        .CC = strCCEmail
        End If  	
    	.Subject = "Automation Execution Reports - " & Date & " - " & strProjName & " - Overall Status : " & strStatus
    	.Body = "Hi," & vbNewLine & vbNewLine & "Automation Execution is completed successfully. Please find attached Automation Execution reports." & vbNewLine & vbNewLine & "Thanks," & vbNewLine & "BSACOP Automation Team"
    	.Attachments.Add strAttachLocation
    	.Send
    	End With
    
    	Wscript.Echo "Email Sent successfully"
    
    	'Clear the memory
    	Set outobj = Nothing
    	Set mailobj = Nothing

    End If
Else
    Wscript.Echo "No arguements were paased to SendEmailReports"
End If
