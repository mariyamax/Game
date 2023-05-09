package org.example.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.enums.Colors;

@Data
@RequiredArgsConstructor
public class Card {
    private int id;
    private String value;
    private Colors color;


    public Card(int id, String value,Colors color) {
        this.id =id;
        this.value=value;
        this.color=color;
    }
}
