package com.cs.canvas;

import java.util.List;
import java.util.regex.Pattern;

public class Fill {
    public void draw(List<String> params,
                     char[][] charArray,
                     int width,
                     int height,
                     char[][] fillArray) throws InvalidCommandException {
        validate(params);

        int c1 = Integer.parseInt(params.get(0));
        int r1 = Integer.parseInt(params.get(1));

        if (c1 < 1 || c1 > width - 2) {
            throw new InvalidCommandException("Co-ordinates out of bound");
        }
        if (r1 < 1 || r1 > height) {
            throw new InvalidCommandException("Co-ordinates out of bound");
        }

        char fill = params.get(2).charAt(0);
        for (int r = 1; r < height + 1; r++) {
            for (int c = 1; c < width - 1; c++) {
                if (charArray[r][c] != 'x') {
                    if (fillArray[r][c] != '#') {
                        charArray[r][c] = fill;
                    }
                }
            }
        }
    }

    void validate(List<String> params) throws InvalidCommandException {
        Pattern digits = Pattern.compile("\\d+");
        if (params.size() != 3 || !digits.matcher(params.get(0)).matches()
                || !digits.matcher(params.get(1)).matches()
                || params.get(2).length() != 1) {
            throw new InvalidCommandException("Solid fill take 2 parameters of numbers and last param of any char");
        }
    }
}
