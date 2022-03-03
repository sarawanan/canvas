package com.cs.canvas;

import java.util.List;
import java.util.regex.Pattern;

public class Rectangle {
    public void draw(char[][] charArray, List<String> params, char[][] fillArray) throws InvalidCommandException {
        validate(params);

        int x1 = Integer.parseInt(params.get(0));
        int y1 = Integer.parseInt(params.get(1));
        int x2 = Integer.parseInt(params.get(2));
        int y2 = Integer.parseInt(params.get(3));

        for (int i = y1; i < y2 + 1; i++) {
            for (int j = x1 - 1; j < x2; j++) {
                if ((i == y1) || (i == y2)) {
                    charArray[i][j] = 'x';
                } else if (j == x1 - 1 || j == x2 - 1) {
                    charArray[i][j] = 'x';
                } else {
                    fillArray[i][j] = '#';
                }
            }
        }
    }

    private void validate(List<String> params) throws InvalidCommandException {
        Pattern digits = Pattern.compile("\\d+");
        if (params.size() != 4 || !digits.matcher(params.get(0)).matches()
                || !digits.matcher(params.get(1)).matches() || !digits.matcher(params.get(2)).matches()
                || !digits.matcher(params.get(3)).matches()) {
            throw new InvalidCommandException("Rectangle takes 4 parameters of numbers");
        }
    }
}
