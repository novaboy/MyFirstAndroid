package com.example.myapplication.model.entity;

public class Cryptocurrency {

    int id;
    String name;
    String abbr;
    String launch;
    String circulateSupply;
    String maxSupply;
    String netwokrk;
    String blockTime;
    int monitorFlag;

    public Cryptocurrency(int id, String name, String abbr, String launch, String circulateSupply, String maxSupply, String netwokrk, String blockTime, int monitorFlag) {
        this.id = id;
        this.name = name;
        this.abbr = abbr;
        this.launch = launch;
        this.circulateSupply = circulateSupply;
        this.maxSupply = maxSupply;
        this.netwokrk = netwokrk;
        this.blockTime = blockTime;
        this.monitorFlag = monitorFlag;
    }

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

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getLaunch() {
        return launch;
    }

    public void setLaunch(String launch) {
        this.launch = launch;
    }

    public String getCirculateSupply() {
        return circulateSupply;
    }

    public void setCirculateSupply(String circulateSupply) {
        this.circulateSupply = circulateSupply;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(String maxSupply) {
        this.maxSupply = maxSupply;
    }

    public String getNetwokrk() {
        return netwokrk;
    }

    public void setNetwokrk(String netwokrk) {
        this.netwokrk = netwokrk;
    }

    public String getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(String blockTime) {
        this.blockTime = blockTime;
    }

    public int isMonitorFlag() {
        return monitorFlag;
    }

    public void setMonitorFlag(int monitorFlag) {
        this.monitorFlag = monitorFlag;
    }
}
