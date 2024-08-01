package com.gg.domain;

public class Status {

    private int index;

    private String status;

    public Status(int index, String status) {
        this.index = index;
        this.status = status;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
