package com.revature.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


    private String firstName;


    private String lastName;

    @Email
    @Column(nullable = false, unique = true)
    private String email;


    @NotNull
    @Column(nullable = false)
    private String state;

    @NotNull
    @Column(nullable = false)
    private String city;


    @Column()
    private int authorizationLevel;

    @Transient
    private List<Role> roles = new ArrayList<>();

    public User(){
        super();
        this.roles.add(Role.BASIC_USER);
        authorizationLevel = 2;
    }

    public User(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles.add(Role.BASIC_USER);
        authorizationLevel = 2;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles.add(Role.BASIC_USER);
        authorizationLevel = 2;
    }

    public User(String username, String password, String firstName, String lastName, String email, String state, String city) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.state = state;
        this.city = city;
        this.roles.add(Role.BASIC_USER);
        authorizationLevel = 2;
    }

    public User(int id, String username, String password, String firstName, String lastName, String email, String state, String city, int authorizationLevel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.state = state;
        this.city = city;
        this.authorizationLevel = authorizationLevel;
        setAuthorizationLevel(authorizationLevel);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        authorizationLevel = Role.valueOf(roles);
        this.roles = Role.getRole(authorizationLevel);

    }
    public void setAuthorizationLevel(int authorization) {
        authorizationLevel = authorization;
        this.roles = Role.getRole(authorizationLevel);

    }
}
