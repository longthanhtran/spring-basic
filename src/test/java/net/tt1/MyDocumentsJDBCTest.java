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
@ContextConfiguration("classpath:META-INF/spring/mydocuments-jdbc-context.xml")
public class MyDocumentsJDBCTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsJDBCTest.class);

    @Autowired
    private SearchEngine engine;

    private Type webType = new Type("WEB", ".url");

    @Test
    public void testUsingSpringJDBC() {
        log.debug("Using Spring JDBC..");

        List<Document> documents = engine.listAll();

        assertNotNull(documents);
        assertTrue(documents.size() == 4);

        documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());

        log.debug("Found WEB Document: {}", documents.get(0));
    }
}
