package net.tt1.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.tt1.data.DocumentDAO;
import net.tt1.model.Document;
import net.tt1.model.Type;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class SearchEngineService implements SearchEngine {

    private static final Logger log = LoggerFactory.getLogger(SearchEngineService.class);

    private DocumentDAO documentDAO;

    public SearchEngineService() {
        if (log.isDebugEnabled())
            log.debug("ServiceEngineService created: " + this);
        System.out.println(">> SearchEngineService created " + this);
    }

    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();
        System.out.println(">> documentType: " + documentType);
        System.out.println(">> documentDAO: " + documentDAO.getAll()[0]);
        for (Document doc : listAll()) {
            if (doc.getType().getName().equals(documentType.getName()))
                result.add(doc);
        }

        return result;
    }

    public List<Document> listAll() {
        return Arrays.asList(documentDAO.getAll());
    }

    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        if (log.isDebugEnabled())
            log.debug("Document DAO set: " + documentDAO);
        this.documentDAO = documentDAO;
    }

}
