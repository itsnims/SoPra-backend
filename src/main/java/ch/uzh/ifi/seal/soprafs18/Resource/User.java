package ch.uzh.ifi.seal.soprafs18.Resource;

public class User {
    private static int clsID;

    private String name;
    private long ID;

    public User(){
        this.ID = ++clsID;
    }

    public User(String name){
        this.name = name;
        this.ID = ++clsID;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public long getID() { return ID; }
}
