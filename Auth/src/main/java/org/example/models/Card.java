package org.example.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.enums.Colors;

@Data
@RequiredArgsConstructor
public class Card {

    private int id;
    private String value;
    private String color;

    public Card(int id, String value,String color) {
        this.id =id;
        this.value=value;
        this.color=color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
