package org.example;

public class Bibliothecaire {
    public int id;
    public String name;
    public String email;

    public Bibliothecaire(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public Bibliothecaire(int id, String name) {
        this.id = id;
        this.name = name;

    }

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
