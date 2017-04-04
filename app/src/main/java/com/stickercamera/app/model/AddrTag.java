package com.stickercamera.app.model;

/**
 * Created by imxqd on 17-4-4.
 */

public class AddrTag extends Tag {

    private String addr;

    public AddrTag(String addr) {
        this.addr = addr;
    }

    public AddrTag(String label, String addr) {
        super(label);
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public int getType() {
        return TYPE_ADDR;
    }
}
