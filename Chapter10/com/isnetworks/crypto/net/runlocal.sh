#!/bin/sh

java -Djavax.net.ssl.keyStore -Djavax.net.ssl.keyStorePassword=password -Djavax.net.ssl.trustStore=keystore com.isnetworks.crypto.net.TunnelServer  anago 5432 6543 local
