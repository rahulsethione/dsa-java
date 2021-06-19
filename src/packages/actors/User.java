package packages.actors;

public class User extends packages.entities.User {
    public User(int id, String name, String email, String phone) {
        super(id, name, email, phone);
    }

    public User(packages.entities.User user) {
        super(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }

    public void setUserId(int id) {
        /**
         * Extended class can access protected member of base class
         */
        this.setId(id);
    }

    public void resetUserInfo(String name, String email, String phone) {
        /**
         * Extended class declared in a different package cannot access member of the base class with 'default' access modifier
         */
        // this.refresh(name, email, phone);
        // super.refresh(name, email, phone);
    }
}
