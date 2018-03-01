package net.tt1;

import net.tt1.model.Document;
import net.tt1.model.Type;
import net.tt1.service.SearchEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class MyDocumentsMoreAnnotationsTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsMoreAnnotationsTest.class);

    @Autowired
    private SearchEngine engine;

    @Autowired
    private Type webType;

    @Timed(millis = 2000)
    @Test
    public void testUsingSpringTimedAnnotationTest() {
        log.debug("Using Spring Test fixtures: ");

        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(),documents.get(0).getType().getName());
        assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
        documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }

    @Repeat(10)
    @Test
    public void testUsingSpringRepeatedAnnotationTest() {
        log.debug("This message should be printed 10 times...");
    }

}
