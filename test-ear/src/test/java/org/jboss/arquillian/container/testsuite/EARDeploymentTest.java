package org.jboss.arquillian.container.testsuite;

import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.net.URL;

@RunWith(Arquillian.class)
@RunAsClient
public class EARDeploymentTest {

    @ArquillianResource
    URL url;

    @Deployment
    public static EnterpriseArchive createDeployment() {
        return ShrinkWrap.createFromZipFile(EnterpriseArchive.class, new File("../package-cdi-ear/ear/target/test.ear"));
    }

    @Test
    public void earDeploymentTest() {
        Assert.assertNotNull(url);
    }
}
