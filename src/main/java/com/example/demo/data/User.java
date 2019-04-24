package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Here you have a User class with three attributes, the id, the firstName, and the lastName.
 * You also have two constructors. The default constructor only exists for the sake of JPA.
 * You won’t use it directly, so it is designated as protected. The other constructor is the
 * one you’ll use to create instances of User to be saved to the database
 *
 * The User class is annotated with @Entity, indicating that it is a JPA entity. For lack of
 * a @Table annotation, it is assumed that this entity will be mapped to a table named User.
 *
 * <p>The User’s id property is annotated with @Id so that JPA will recognize it as the object’s
 * ID. The id property is also annotated with @GeneratedValue to indicate that the ID should be
 * generated automatically.
 *
 * <p>The other two properties, firstName and lastName are left unannotated. It is assumed that
 * they’ll be mapped to columns that share the same name as the properties themselves.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    protected User() {}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
