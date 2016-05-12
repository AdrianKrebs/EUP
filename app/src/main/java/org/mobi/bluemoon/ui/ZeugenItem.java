package org.mobi.bluemoon.ui;

/**
 * Created by Adrian on 5/12/2016.
 */
public class ZeugenItem {

    private String title;
    private String description;

    public ZeugenItem(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
