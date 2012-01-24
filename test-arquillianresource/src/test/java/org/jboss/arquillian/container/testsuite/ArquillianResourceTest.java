package org.jboss.arquillian.container.testsuite;

import java.io.File;
import java.net.URL;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ArquillianResourceTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.createFromZipFile(WebArchive.class, new File("../package-cdi-war/target/test.war"));
    }

    @Test
    @RunAsClient
    public void urlTest(@ArquillianResource URL url) {
        Assert.assertNotNull(url);
    }

    @Test
    public void deployerTest(@ArquillianResource Deployer deployer) {
        Assert.assertNotNull(deployer);
    }

    @Test
    @RunAsClient
    public void clientDeployerTest(@ArquillianResource Deployer deployer) {
        Assert.assertNotNull(deployer);
    }
}
