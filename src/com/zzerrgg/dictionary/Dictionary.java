package com.zzerrgg.dictionary;

import java.util.ArrayList;
import java.util.Arrays;

public record Dictionary(ArrayList<String> words) {
    public Dictionary() {
        this(new ArrayList<>(Arrays.asList("абажур", "аббатство", "аббревиатура", "абитуриент", "абонемент")));
    }

}
