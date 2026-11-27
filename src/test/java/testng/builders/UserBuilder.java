package testng.builders;

import models.User;

public class UserBuilder {

    private final User user;

    public UserBuilder() {
        this.user = new User();
    }

    public UserBuilder(User user) {
        this.user = user;
    }

    public static UserBuilder from(User user) {
        return new UserBuilder(user);
    }

    public UserBuilder firstName(String firstName) {
        user.setFirstName(firstName);
        return this;
    }

    public UserBuilder lastName(String lastName) {
        user.setLastName(lastName);
        return this;
    }

    public UserBuilder phone(String phone) {
        user.setPhone(phone);
        return this;
    }

    public UserBuilder withUniquePhone() {
        String phone = "9" + String.valueOf(System.currentTimeMillis()).substring(4);
        user.setPhone(phone);
        return this;
    }

    public UserBuilder dob(String dob) {
        user.setDob(dob);
        return this;
    }

    public UserBuilder gender(String gender) {
        user.setGender(gender);
        return this;
    }

    public User build() {
        return user;
    }
}
