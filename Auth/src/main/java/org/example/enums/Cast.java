package org.example.enums;

public enum Cast {

    BLUE("BLUE"), RED("RED"), CAPTAINB("CAPTAINB"),CAPTAINR("CAPTAINR");

    private String value;

    private Cast(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static Cast fromString(String value) {
        if (value != null) {
            for (Cast cast : Cast.values()) {
                if (value.equalsIgnoreCase(cast.value)) {
                    return cast;
                }
            }
        }
        return null;
    }
}
