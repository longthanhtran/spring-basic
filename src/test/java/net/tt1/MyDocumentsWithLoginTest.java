package net.tt1;

import net.tt1.service.Login;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class MyDocumentsWithLoginTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithLoginTest.class);
    private static final String EMAIL = "test@mydocuments.com";
    private static final String PASS = "test123";

    private static final String SUCCESS = "This user is authorized";
    private static final String FAILURE = "WARNING! This user is not authorized!";

    private ClassPathXmlApplicationContext context;

    @Before
    public void  setup() {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-login-context.xml");
    }

    @Test
    public void testLogin() {
        log.debug("Login test.");
        Login login = context.getBean(Login.class);

        assertNotNull(login);

        if (login.isAuthorized(EMAIL, PASS))
            System.out.println(SUCCESS);
        else
            System.out.println(FAILURE);
    }
}
