package org.jboss.arquillian.container.testsuite;

import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.as.quickstarts.helloworld.HelloService;
import org.jboss.as.quickstarts.helloworld.HelloWorldServlet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;

@RunWith(Arquillian.class)
@RunAsClient
public class EARDeploymentTest {

    @ArquillianResource
    URL url;

    @Deployment
    public static EnterpriseArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClass(HelloService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war")
                .addClass(HelloWorldServlet.class);

        return ShrinkWrap.create(EnterpriseArchive.class, "test.ear").addAsModule(jar).addAsModule(war);
    }

    @Test
    public void earDeploymentTest() {
        Assert.assertNotNull(url);
    }
}
