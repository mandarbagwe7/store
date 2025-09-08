package com.codewithdevil.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    @ManyToMany
    @JoinTable(
            name = "user_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    private Set<Tag> tags = new HashSet<>();

    public void addTag(String tagName) {
        var tag = Tag.builder().name(tagName).build();
        tags.add(tag);
        tag.getUsers().add(this);
    }

    public void removeTag(String tagName) {
        var tag = Tag.builder().name(tagName).build();
        tags.remove(tag);
        tag.getUsers().remove(this);
    }

    @OneToOne(mappedBy = "user")
    private Profile profile;

    public void addProfile(Profile profile) {
        this.profile = profile;
        profile.setUser(this);
    }

    public void removeProfile(Profile profile) {
        this.profile = null;
        profile.setUser(null);
    }

}
