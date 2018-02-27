package net.tt1.data;

import net.tt1.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DocumentRepository implements DocumentDAO {

    private static final Logger log = LoggerFactory.getLogger(DocumentRepository.class);
    private List<Document> documents = null;

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Document[] getAll() {
        if (log.isDebugEnabled())
            log.debug("Start <getAll> Params: ");
        System.out.println(">> Documents: " + documents);
        Document[] result = documents.toArray(new Document[documents.size()]);

        if (log.isDebugEnabled())
            log.debug("End <getAll> Result: " + result);
        return result;
    }

}
