package net.tt1.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.tt1.data.DocumentDAO;
import net.tt1.data.DocumentRepository;
import net.tt1.model.Document;
import net.tt1.model.Type;
import net.tt1.service.SearchEngine;
import net.tt1.service.SearchEngineService;
import org.springframework.context.annotation.Scope;

import static java.lang.System.out;

@Configuration
public class MyDocumentsContext {

    private static final Logger log = LoggerFactory.getLogger(SearchEngineService.class);

    private Map<String, Document> documents = new HashMap<String, Document>();
    private Map<String, Type> types = new HashMap<String, Type>();

    @Bean
    public Type webType() {
        return getTypeFromMap("web");
    }

    @Bean
    public SearchEngine engine() {
        SearchEngineService engine = new SearchEngineService();
        System.out.println("SearchEngine created: " + engine);
        System.out.println(">> Origin documentDAO: " + documentDAO().getAll());
        engine.setDocumentDAO(documentDAO());
        if (log.isErrorEnabled())
            log.debug("SearchEngine created: " + engine);
        System.out.println(">> The engine: " + engine);
        System.out.println(">> The documentDAO: " + engine.getDocumentDAO());
        return engine;
    }

    public MyDocumentsContext() {
        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");

        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Random/Book Template.pdf");

        documents.put("doc1", document);
        types.put("pdf", type);

        document = new Document();
        document.setName("Sample Contract");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Contracts/Sample Contract.pdf");

        documents.put("doc2", document);

        type = new Type();
        type.setName("NOTE");
        type.setDesc("Text Notes");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");

        documents.put("doc3", document);
        types.put("note", type);

        type = new Type();
        type.setName("WEB");
        type.setDesc("Web Link");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        documents.put("doc4", document);
        types.put("web", type);
    }

    private DocumentDAO documentDAO() {
        DocumentRepository documentDAO = new DocumentRepository();
        ArrayList<Document> docs = new ArrayList<>(); // Be very careful by assigning null as initialization
        try {
            documents.forEach((k, v) -> docs.add(v));
        } catch (Exception e) {
            out.println(e.getStackTrace());
        }
//        out.println(">> After docs created: " + docs);
        documentDAO.setDocuments(docs);
//        out.println(">> Inside documentDAO: " + documentDAO.getDocuments());
        return documentDAO;
    }

    private Document getDocumentFromMap(String documentKey) {
        return documents.get(documentKey);
    }

    private Type getTypeFromMap(String typeKey) {
        return types.get(typeKey);
    }
}
