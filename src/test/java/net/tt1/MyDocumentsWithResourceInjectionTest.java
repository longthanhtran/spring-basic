package net.tt1;

import net.tt1.views.Menu;
import net.tt1.views.ResourceLoaderMenu;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class MyDocumentsWithResourceInjectionTest {

    private static final Logger log =
            LoggerFactory.getLogger(MyDocumentsWithResourceInjectionTest.class);

    private ClassPathXmlApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-resource-injection-context.xml");
    }

    @Test
    public void testMenu() {
        log.debug("Calling the Menu as Resource Injection: ");
        Menu menu = context.getBean(Menu.class);

        assertNotNull(menu);
        menu.printMenu();
    }

    @Test
    public void testResourceLoaderMenu() {
        log.debug("Calling the Menu as ResourceLoader Injection: ");

        ResourceLoaderMenu menu = context.getBean(ResourceLoaderMenu.class);
        assertNotNull(menu);
        menu.printMenu("classpath:META-INF/data/menu.txt");
    }
}
