package com.netcracker.model;

import org.springframework.beans.factory.annotation.Autowired;

public class UserForSearch {

    private String name;

    private String family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
