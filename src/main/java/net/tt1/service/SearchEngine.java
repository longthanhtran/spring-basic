package net.tt1.service;

import java.util.List;

import net.tt1.model.Document;
import net.tt1.model.Type;

public interface SearchEngine {

    List<Document> findByType(Type documentType);

    List<Document> listAll();

    List<Document> findByLocation(String location);
}
