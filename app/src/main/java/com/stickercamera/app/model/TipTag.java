package com.stickercamera.app.model;

/**
 * Created by imxqd on 17-4-4.
 */

public class TipTag extends Tag {

    private String text;

    public TipTag(String text) {
        this.text = text;
    }

    public TipTag(String label, String text) {
        super(label);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getType() {
        return TYPE_TIP;
    }
}
