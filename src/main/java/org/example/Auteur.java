package org.example;

public class Auteur {
    public int id;
    public String name;
    public Auteur(int id, String name) {
        this.id = id;
        this.name = name;

    }
    public Auteur(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
