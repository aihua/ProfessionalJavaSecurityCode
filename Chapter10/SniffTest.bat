javac SniffTest.java
java -classpath %CLASSPATH%;%CRYPTO_PROJECT_ROOT%/lib/postgresql.jar;. SniffTest jdbc:postgresql://unagi/crypto crypto my_password
pause