package com.example.shamithhshetty.userprofile_android.Model;


public class CardItem {

    private String tname1,name1,tname2,name2,tittle;
    private int id1,id2;


    public CardItem(String tname1, String name1, String tname2, String name2, String tittle, int id1, int id2) {
            this.tname1=tname1;
            this.tittle=tittle;
            this.name1=name1;
            this.tname2=tname2;
            this.name2=name2;
            this.id1=id1;
            this.id2=id2;
    }

    public String getTittle() {
        return tittle;
    }
    public String getTname1() {
        return tname1;
    }
    public int getId1() {
        return id1;
    }
    public int getId2() {
        return id2;
    }

    public String getName1() {
        return name1;
    }
    public String getTname2() {
        return tname2;
    }

    public String getName2() {
        return name2;
    }
}
