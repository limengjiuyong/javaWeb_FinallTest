package com.example.demo.Enity;

public class RoleInfos {
    private Integer rid;

    private String rname;

    private String rnamezh;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public String getRnamezh() {
        return rnamezh;
    }

    public void setRnamezh(String rnamezh) {
        this.rnamezh = rnamezh == null ? null : rnamezh.trim();
    }
}