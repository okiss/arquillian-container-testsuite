package org.jboss.arquillian.container.testsuite;

import java.io.File;

import javax.inject.Inject;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.as.quickstarts.helloworld.HelloService;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class CDITest {

    @Inject
    HelloService service;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.createFromZipFile(WebArchive.class, new File("../package-cdi-war/target/test.war"));
    }

    @Test
    public void cdiTest() {
        Assert.assertNotNull(service);
        Assert.assertEquals("Hello World!", service.createHelloMessage("World"));
    }
}
