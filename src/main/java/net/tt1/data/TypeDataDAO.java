package net.tt1.data;

import net.tt1.model.Type;

public interface TypeDataDAO {
    public Type[] getAll();
    public Type findById(String id);
}
