package com.chuang.model;

import java.util.Date;
import javax.persistence.*;

public class Testmbg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String aa;

    private Integer bb;

    private Date cc;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return aa
     */
    public String getAa() {
        return aa;
    }

    /**
     * @param aa
     */
    public void setAa(String aa) {
        this.aa = aa;
    }

    /**
     * @return bb
     */
    public Integer getBb() {
        return bb;
    }

    /**
     * @param bb
     */
    public void setBb(Integer bb) {
        this.bb = bb;
    }

    /**
     * @return cc
     */
    public Date getCc() {
        return cc;
    }

    /**
     * @param cc
     */
    public void setCc(Date cc) {
        this.cc = cc;
    }

    
    
	public Testmbg(String name, String aa, Integer bb, Date cc) {
		super();
		this.name = name;
		this.aa = aa;
		this.bb = bb;
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "Testmbg [id=" + id + ", name=" + name + ", aa=" + aa + ", bb=" + bb + ", cc=" + cc + "]";
	}
	
    
    
}