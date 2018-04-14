package ch.uzh.ifi.seal.soprafs18.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long Id;

    @Column(unique = true)
    private String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public long getID() { return Id; }
}
