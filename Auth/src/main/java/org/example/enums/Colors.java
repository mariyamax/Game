package org.example.enums;

public enum Colors {

    RED("#f0a9a1"),BLUE("#a1d6f0"),
    BEIGE("#f0dfa1"),GREY("#c9c8c1");

    public String value;

    Colors(String s) {
        this.value=s;
    }
}
