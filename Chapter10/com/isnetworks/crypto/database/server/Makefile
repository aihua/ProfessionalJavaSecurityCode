PACKAGE= com.isnetworks.crypto.database.server
CLASSES= SecureConnectionServerImpl.class SecureConnectionServerMain.class \
	SecureConnectionServerImpl_Stub.class ConfigurationParser.class \
	ConfigurationException.class DatasourceManager.class \
	SimpleDatasourceManager.class

JOPTS=-g

ADDITIONAL_CLASSPATH=$(CRYPTO_PROJECT_ROOT)/lib/xerces.jar

#include the environment definitions
include $(CRYPTO_PROJECT_ROOT)/env/Makedefs

make test: SecureConnectionServerMain.class
	java com.isnetworks.crypto.database.server.SecureConnectionServerMain \
		$(CRYPTO_PROJECT_ROOT)/doc/ExampleDBConfig.xml
