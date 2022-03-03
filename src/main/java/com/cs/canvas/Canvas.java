package com.cs.canvas;

import java.util.List;
import java.util.regex.Pattern;

public class Canvas {
    public void draw(char[][] charArray, int x, int y) {
        for (int i = 0; i < y + 2; i++) {
            for (int j = 0; j < x; j++) {
                if ((i == 0) || (i == y + 1)) {
                    charArray[i][j] = '-';
                } else {
                    charArray[i][0] = '|';
                    charArray[i][x - 1] = '|';
                }
            }
        }
    }

    public boolean validate(List<String> params) throws InvalidCommandException {
        Pattern digits = Pattern.compile("\\d+");
        if (params.size() != 2 || !digits.matcher(params.get(0)).matches()
                || !digits.matcher(params.get(1)).matches()) {
            throw new InvalidCommandException("Canvas will take 2 parameters of numbers");
        }
        return true;
    }
}
