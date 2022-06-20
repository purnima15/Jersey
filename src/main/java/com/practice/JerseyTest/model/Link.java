
package com.practice.JerseyTest.model;

public class Link
{
    private String link;
    private String rel;
    
    public Link() {
    }
    
    public Link(final String link, final String rel) {
        this.link = link;
        this.rel = rel;
    }
    
    public String getLink() {
        return this.link;
    }
    
    public void setLink(final String link) {
        this.link = link;
    }
    
    public String getRel() {
        return this.rel;
    }
    
    public void setRel(final String rel) {
        this.rel = rel;
    }
}