package net.tt1.data;

import net.tt1.model.Type;

import java.util.Map;

public class TypeDataRepository implements TypeDataDAO {

    private Map<String, Type> types = null;

    public Map<String, Type> getTypes() {
        return types;
    }

    public void setTypes(Map<String, Type> types) {
        this.types = types;
    }

    @Override
    public Type[] getAll() {
        return types.values().toArray(new Type[types.values().size()]);
    }

    @Override
    public Type findById(String id) {
        Type type = types.get(id);
        return type;
    }
}
