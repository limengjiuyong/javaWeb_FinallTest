package com.example.demo.Enity;

public class DptInfo {
    private Integer dpid;

    private String dpname;

    public Integer getDpid() {
        return dpid;
    }

    public void setDpid(Integer dpid) {
        this.dpid = dpid;
    }

    public String getDpname() {
        return dpname;
    }

    public void setDpname(String dpname) {
        this.dpname = dpname == null ? null : dpname.trim();
    }
}