package com.zzerrgg.imageInAscii;

import java.util.ArrayList;
import java.util.Arrays;

public record AsciiGallows(ArrayList<String> stage) {

    public AsciiGallows() {
        this(new ArrayList<>(Arrays.asList(" +|-----+\n  |     |\n        |\n        |\n        |\n        |\n===========",
                " +|-----+\n  |     |\n  O     |\n        |\n        |\n        |\n===========",
                " +|-----+\n  |     |\n  O     |\n  |     |\n        |\n        |\n===========",
                " +|-----+\n  |     |\n  O     |\n /|     |\n        |\n        |\n===========",
                " +|-----+\n  |     |\n  O     |\n /|\\    |\n        |\n        |\n===========",
                " +|-----+\n  |     |\n  O     |\n /|\\    |\n /      |\n        |\n===========",
                " +|-----+\n  |     |\n  O     |\n /|\\    |\n / \\    |\n        |\n===========")));
    }
}
