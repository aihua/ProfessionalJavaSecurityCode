To run this example, you need to do the following:

1. Install the JSSE and a cryptography provider (Bouncy Castle works well).

2. Go to http://www.thawte.com and get a free email certificate. You'll need it to log in to the application later.

3. Install MySQL and create a database with the username "projava" and the password "sasquatch" (see MySQL commands.txt for these instructions). Make sure MySQL is running before you attempt to run the rest of the application.

4. Edit each of the policy files, making sure to set the IP addresses and hostnames and passwords accordingly:
	SecureDriverClient.policy
	BankInit.policy
	tomcat.policy	

5. Download tomcat from jakarta.apache.org and install it. Copy tomcat.policy and server.xml into the %TOMCAT_HOME%/conf directory. Then copy tomcat.bat into %TOMCAT_HOME%/bin You will be overwriting an existing files. Copy jakartaKeyStore into %TOMCAT_HOME%. Finally, copy the directory bankapp into %TOMCAT_HOME%/webapps.

6. Run StartRmiRegistry.bat.

7. Run SecureDriver.bat. Wait until the message 'Secure Driver Registered' appears on screen.

8. Run BankInit.bat. Wait 30 seconds.

9. Run the following command from the ../tomcat/bin directory:
	startup.bat -security
   Wait 30 seconds.

10. Attach to your webserver on port 8443 (the URL should be something like https://localhost:8443). Register an account.

11. Run CreditCardClient.bat. The password is "creditcard". Your account should be displayed.

Please be aware that we have included some code in this download that is subject to licensing restrictions (see xerces license.txt for more information).