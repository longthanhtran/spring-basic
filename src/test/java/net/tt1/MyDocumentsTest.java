package net.tt1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.tt1.model.Document;
import net.tt1.model.Type;
import net.tt1.service.SearchEngine;
import org.springframework.core.io.Resource;

public class MyDocumentsTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
    private ClassPathXmlApplicationContext context;
    private SearchEngine engine;
    private Type webType;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-context.xml");
//        engine = context.getBean(SearchEngine.class);
//        webType = context.getBean("webType", Type.class);
    }

    @Test
    @Ignore
    public void testFindByType() {

        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());
    }

    @Test
    @Ignore
    public void testListAll() {
        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }

    @Test
    public void testMenu() {
        log.debug("About to read the Resource file: menu.txt");
        Resource resource = context.getResource("classpath:META-INF/data/menu.txt");

        try {
            InputStream stream = resource.getInputStream();
            Scanner scanner = new Scanner(stream);

            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void testAll() {
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean("webType", Type.class);

        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());

        engine = context.getBean(SearchEngine.class);

        documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }

}
