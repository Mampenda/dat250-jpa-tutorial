package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pincode;
    private String code;
    private Integer count;

    //Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    public Pincode getPincode() { return this; }
//    public void setPincode(Integer pincode) { this.pincode = pincode; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Integer getCount() { return count; }
    public void setCount(Integer count) { this.count = count; }

}
