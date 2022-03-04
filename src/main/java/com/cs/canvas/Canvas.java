package com.cs.canvas;

import java.util.List;
import java.util.regex.Pattern;

public class Canvas {
    public void draw(List<String> params,
                     char[][] charArray,
                     int width,
                     int height) throws InvalidCommandException {
        validate(params);

        for (int r = 0; r < height + 2; r++) {
            for (int c = 0; c < width; c++) {
                if ((r == 0) || (r == height + 1)) {
                    charArray[r][c] = '-';
                } else {
                    charArray[r][0] = '|';
                    charArray[r][width - 1] = '|';
                }
            }
        }
    }

    void validate(List<String> params) throws InvalidCommandException {
        Pattern digits = Pattern.compile("\\d+");
        if (params.size() != 2 || !digits.matcher(params.get(0)).matches()
                || !digits.matcher(params.get(1)).matches()) {
            throw new InvalidCommandException("Canvas will take 2 parameters of numbers");
        }
    }
}
