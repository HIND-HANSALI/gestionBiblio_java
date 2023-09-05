package org.example;

public class Emprunteur {
    public int id;
    public String name;

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void emprunterLivre(){}
    public void retournerLivre(){}
}
