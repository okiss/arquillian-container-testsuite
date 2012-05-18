package org.jboss.arquillian.container.testsuite;

import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.as.quickstarts.helloworld.HelloService;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.io.File;

@RunWith(Arquillian.class)
public class EJBTest {

    @EJB
    HelloService service;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.createFromZipFile(WebArchive.class, new File("../package-ejb-war/target/test.war"));
    }

    @Test
    public void ejbTest() {
        Assert.assertNotNull(service);
        Assert.assertEquals("Hello World!", service.createHelloMessage("World"));
    }
}
