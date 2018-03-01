package net.tt1.model;

public interface TypeDataDAO {
    Type[] getAll();
    Type findById(String id);
}
