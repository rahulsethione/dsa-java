package packages.entities;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private List<String> privileges;

    public Admin(int id, String name, String email, String phone) {
        super(id, name, email, phone);
        this.privileges = new ArrayList<>();
    }

    public Admin(int id, String name, String email, String phone, List<String> privileges) {
        super(id, name, email, phone);
        this.privileges = privileges;
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    protected void setPrivileges(List<String> privileges) {
        this.privileges = privileges;
    }

    public void setUserId(int id) {
        /**
         * Extended class can access protected member of base class
         */
        this.setId(id);
    }

    public void addAsset(Asset asset) {
        /**
         * A Class can access protected member of another class in the same package
         */
        asset.setId(getId() + 1);
    }

    public void reassign(User user) {
        /**
         * Extended class in the same package only can access member of base class with 'default' access modifier
         */
        refresh(user.getName(), user.getEmail(), user.getPhone());
    }
}
