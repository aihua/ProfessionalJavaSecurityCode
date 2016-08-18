PACKAGE= 
CLASSES= SniffTest.class

#include the environment definitions
include $(CRYPTO_PROJECT_ROOT)/env/Makedefs

test: SniffTest.class
	java -classpath $(CLASSPATH):. SniffTest jdbc:postgresql:crypto crypto crypto
