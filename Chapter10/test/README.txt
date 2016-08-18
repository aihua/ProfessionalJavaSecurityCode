To test the secure driver:

1. Edit SecureClient.policy and replace the IP address with the machine running the JDBC driver.
2. Start MySQL. You must have a database called projava with a table called credit_card. Refer to Appendix C to see how to do this.
3. Run StartRMIRegistry.bat. Wait a few seconds.
4. Run SecureDriver.bat. Wait about 30 seconds.
5. Run SecureClient.bat. This will actually contact the database and display a success message if it is able to connect.
