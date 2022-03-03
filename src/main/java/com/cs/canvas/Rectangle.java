package com.cs.canvas;

import java.util.List;
import java.util.regex.Pattern;

public class Rectangle {
    public void draw(char[][] charArray, List<String> params, char[][] fillArray, int w, int h) throws InvalidCommandException {
        validate(params);

        int c1 = Integer.parseInt(params.get(0));
        int r1 = Integer.parseInt(params.get(1));
        int c2 = Integer.parseInt(params.get(2));
        int r2 = Integer.parseInt(params.get(3));

        if (c1 < 1 || c1 > w-2 || c2 < 1 || c2 > w-2) {
            throw new InvalidCommandException("Co-ordinates out of bound");
        }
        if (r1 < 1 || r1 > h || r2 < 1 || r2 > h) {
            throw new InvalidCommandException("Co-ordinates out of bound");
        }

        for (int r = r1; r < r2 + 1; r++) {
            for (int c = c1 - 1; c < c2; c++) {
                if ((r == r1) || (r == r2)) {
                    charArray[r][c] = 'x';
                } else if (c == c1 - 1 || c == c2 - 1) {
                    charArray[r][c] = 'x';
                } else {
                    fillArray[r][c] = '#';
                }
            }
        }
    }

    void validate(List<String> params) throws InvalidCommandException {
        Pattern digits = Pattern.compile("\\d+");
        if (params.size() != 4 || !digits.matcher(params.get(0)).matches()
                || !digits.matcher(params.get(1)).matches() || !digits.matcher(params.get(2)).matches()
                || !digits.matcher(params.get(3)).matches()) {
            throw new InvalidCommandException("Rectangle takes 4 parameters of numbers");
        }
    }
}
