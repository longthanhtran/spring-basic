package net.tt1.service;

import net.tt1.model.Document;
import net.tt1.model.Type;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("qa")
public class FileSearchEngineService implements SearchEngine {

    @Override
    public List<Document> findByType(Type documentType) {
        throw new UnsupportedOperationException("QA Environment. Not yet implemented operation.");
    }

    @Override
    public List<Document> listAll() {
        throw new UnsupportedOperationException("QA Environment. Not yet implemented operation");
    }
}
