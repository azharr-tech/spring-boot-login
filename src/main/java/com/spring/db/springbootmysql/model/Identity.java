package com.spring.db.springbootmysql.model;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Audited
@Entity
@Table(name = "Identity")
public class Identity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,unique = true)
    private int id;
    @Column(name = "is_active",nullable = false)
    private int isActive;
    @Column(name = "user_name",nullable = false)
    private String userName;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "email",nullable = false)
    private String email ;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "id"),inverseJoinColumns =@JoinColumn(name="role_id") )
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Set<Roles> roles;

    public Identity() {
    }

    public Identity(Identity identity) {
        this.id = identity.id;
        this.isActive = identity.isActive;
        this.userName = identity.userName;
        this.password = identity.password;
        this.email = identity.email;
        this.roles = identity.roles;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
