package org.jboss.arquillian.container.testsuite;

import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.as.quickstarts.helloworld.HelloService;
import org.jboss.as.quickstarts.helloworld.HelloWorldServlet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.Asset;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import java.io.File;
import java.net.URL;

@RunWith(Arquillian.class)
public class ArquillianResourceTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.createFromZipFile(WebArchive.class, new File("../package-cdi-war/target/test.war"));
    }

    @Test
    @RunAsClient
    public void cdiTest(@ArquillianResource URL url) {
        Assert.assertNotNull(url);
    }
}
