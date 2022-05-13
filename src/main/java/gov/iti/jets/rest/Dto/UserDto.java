package gov.iti.jets.rest.Dto;

import gov.iti.jets.repositories.entities.User;
import gov.iti.jets.repositories.entities.enums.Role;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;

    public UserDto(int id, String firstName, String lastName, String email, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }
    public UserDto( User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName =  user.getLastName();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
