package org.example.enums;

public enum Colors {

    RED("#f0a9a1"),BLUE("#a1d6f0"),
    BEIGE("#f0dfa1"),GREY("#c9c8c1");

    public String value;

    Colors(String s) {
        this.value=s;
    }

    public String getValue() {
        return this.value;
    }

    public static Colors byValue(String value) {
        switch (value) {
            case "#f0a9a1":
                return RED;
            case "#a1d6f0":
                return BLUE;
            case "#f0dfa1":
                return BEIGE;
            case "#c9c8c1":
                return GREY;
            default: return null;
        }
    }
}
