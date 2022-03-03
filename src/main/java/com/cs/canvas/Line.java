package com.cs.canvas;

import java.util.List;
import java.util.regex.Pattern;

public class Line {
    private void validate(List<String> params) throws InvalidCommandException {
        Pattern digits = Pattern.compile("\\d+");
        if (params.size() != 4 || !digits.matcher(params.get(0)).matches()
                || !digits.matcher(params.get(1)).matches() || !digits.matcher(params.get(2)).matches()
                || !digits.matcher(params.get(3)).matches()) {
            throw new InvalidCommandException("Line takes 4 parameters of numbers");
        }
    }

    public void draw(char[][] charArray, List<String> params) throws InvalidCommandException {
        validate(params);

        int x1 = Integer.parseInt(params.get(0));
        int y1 = Integer.parseInt(params.get(1));
        int x2 = Integer.parseInt(params.get(2));
        int y2 = Integer.parseInt(params.get(3));

        if (y1 == y2) {
            for (int i = x1; i < x2 + 1; i++) {
                charArray[y1][i] = 'x';
            }
        }
        if (x1 == x2) {
            for (int i = y1; i < y2 + 1; i++) {
                charArray[i][x1] = 'x';
            }
        }
    }
}
