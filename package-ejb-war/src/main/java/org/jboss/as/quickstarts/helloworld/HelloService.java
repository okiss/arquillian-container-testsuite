package org.jboss.as.quickstarts.helloworld;

import javax.ejb.Stateless;

/**
 * A simple CDI service which is able to say hello to someone
 *
 * @author Pete Muir
 */
@Stateless
public class HelloService {

    public String createHelloMessage(String name) {
        return "Hello " + name + "!";
    }

}
