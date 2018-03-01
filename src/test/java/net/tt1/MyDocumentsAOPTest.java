package net.tt1;

import net.tt1.model.Document;
import net.tt1.model.Type;

import net.tt1.service.SearchEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-aop-context.xml")
public class MyDocumentsAOPTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsAOPTest.class);

    @Autowired
    private SearchEngine engineProxy;

    @Autowired
    private Type webType;

    @Test
    public void testUsingSpringAOP() {
        log.debug("Using Spring AOP: ");

        List<Document> documents = engineProxy.findByType(webType);
        assertNotNull(documents);

        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(),documents.get(0).getType().getName());
        assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
        documents = engineProxy.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);

        try {
            engineProxy.findByLocation("/some/path");
        } catch (Exception e) {
            log.error("" + e.getStackTrace());
        }
    }

    @Test
    public void testUsingSpringAOPCaching() {
//        TODO Check debug mode with JUnit
        log.debug("Testing  Caching Module...");

        List<Document> documents = engineProxy.findByType(webType);
        assertNotNull(documents);
        int count = documents.size();

        log.debug("It should be now cached!");
        documents = engineProxy.findByType(webType);
        assertNotNull(documents);
        assertEquals(count, documents.size());
    }
}
