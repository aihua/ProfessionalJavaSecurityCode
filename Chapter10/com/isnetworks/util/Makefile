PACKAGE= com.isnetworks.util
CLASSES= Debug.class NestedException.class XMLProperties.class
JOPTS=-g

#include the environment definitions
include $(CRYPTO_PROJECT_ROOT)/env/Makedefs

test: XMLProperties.class
	java com.isnetworks.util.XMLProperties $(CRYPTO_PROJECT_ROOT)/doc/ExampleDBConfig.xml
