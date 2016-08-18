PACKAGE= com.isnetworks.test.jdbc
CLASSES= SniffTest.class

#include the environment definitions
include $(CRYPTO_PROJECT_ROOT)/env/Makedefs

test: SniffTest.class
	java com.isnetworks.test.jdbc.SniffTest jdbc:postgresql:crypto crypto
