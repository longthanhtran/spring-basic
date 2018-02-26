package net.tt1.model;

public interface TypeDataDAO {
    public Type[] getAll();
    public Type findById(String id);
}
