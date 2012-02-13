Arquillian Container Testsuite
==============================

Exercises Arquillian + Container functionality

Currently, following containers are supported

* JBoss AS7 

Executing testsuite
===================

*Note: You have to use `package` phase, as ShrinkWrap will be using zipped artifacts as test archives*


JBoss AS7
---------
    
    export JBOSS_HOME=/path/to/jboss/home
    mvn clean package -Parq-jbossas-managed

