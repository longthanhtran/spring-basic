package net.tt1.service;

import java.util.List;

import net.tt1.model.Document;
import net.tt1.model.Type;

public interface SearchEngine {

    public List<Document> findByType(Type documentType);

    public List<Document> listAll();

    public List<Document> findByLocation(String location);
}
