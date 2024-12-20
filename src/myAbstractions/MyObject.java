package myAbstractions;
public abstract class MyObject {
    private final String name;
    protected final String description;

    public MyObject(String nm) {
        this(nm, "");
    }

    public MyObject(String nm, String description){
        this.description = description;
        name = nm;
    }

    public String getName(){ return name;}

    public String getDescription(){ return description;}

    @Override
    public String toString(){return name + (description.isEmpty() ? "": ": " + description);}

    @Override
    public int hashCode() {

        return name.hashCode() + description.hashCode(); // Генерация хэш-кода
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof MyObject) {
            if ((((MyObject) obj).getName()).equals(this.getName())) {
                return true;
            }
            return false;
        }
        else {
            return obj != null;
        }
    }

}
