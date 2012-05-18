package org.jboss.arquillian.container.testsuite;

import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.as.quickstarts.helloworld.HelloService;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.File;

@RunWith(Arquillian.class)
public class ResourceTest {

    @Resource(mappedName = "java:jboss/datasources/ExampleDS")
    DataSource ds;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.createFromZipFile(WebArchive.class, new File("../package-ejb-war/target/test.war"));
    }

    @Test
    public void resourceTest() {
        Assert.assertNotNull(ds);
    }
}
