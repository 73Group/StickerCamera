package com.stickercamera.app.model;

/**
 * Created by imxqd on 17-4-4.
 */

public class LinkTag extends Tag {

    private String link;

    public LinkTag(String link) {
        this.link = link;
    }

    public LinkTag(String label, String link) {
        super(label);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int getType() {
        return TYPE_LINK;
    }
}
