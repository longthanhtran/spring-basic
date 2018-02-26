package net.tt1.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.tt1.data.DocumentDAO;
import net.tt1.model.Document;
import net.tt1.model.Type;

public class SearchEngineService implements SearchEngine {

    private DocumentDAO documentDAO;

    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();

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
        this.documentDAO = documentDAO;
    }

}
