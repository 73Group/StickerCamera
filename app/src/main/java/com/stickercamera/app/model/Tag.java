package com.stickercamera.app.model;

import java.io.Serializable;

/**
 * Created by imxqd on 17-4-4.
 */

public abstract class Tag implements ITag , Serializable{
    private static final long serialVersionUID = 2685507991821634905L;
    private long              id;
    private String            name;
    private double            x                = -1;
    private double            y                = -1;

    private int recordCount;
    private boolean           left             = true;


    public boolean isLeft() {
        return left;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public Tag() {

    }

    public Tag(String label) {
        this.name = label;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
