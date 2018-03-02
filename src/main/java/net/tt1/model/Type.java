package net.tt1.model;

public class Type {

    private String typeId;

    @Override
    public String toString() {
        return "Type{" +
                "typeId='" + typeId + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }

    public Type(String name, String extension) {
        this.name = name;
        this.extension = extension;
    }

    public Type() {}

    private String name;
    private String desc;
    private String extension;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
