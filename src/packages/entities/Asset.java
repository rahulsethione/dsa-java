package packages.entities;

public class Asset {
    private int id;

    private class Registry {

    }

    public Asset(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }
}
