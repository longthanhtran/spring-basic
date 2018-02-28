package net.tt1.annotated.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import net.tt1.data.DocumentDAO;
import net.tt1.model.Document;
import net.tt1.model.Type;
import net.tt1.service.SearchEngine;

@Service("engine")
@Scope("prototype")
public class AnnotatedSearchEngine implements SearchEngine {

    @Autowired
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

    @Override
    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("findByLocation not yet implemented");
    }

}
