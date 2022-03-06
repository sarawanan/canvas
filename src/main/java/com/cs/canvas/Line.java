package com.cs.canvas;

import java.util.List;
import java.util.regex.Pattern;

public class Line implements Shape {
    @Override
    public String draw(List<String> params) throws InvalidCommandException {
        validate(params);
        Singleton singleton = Singleton.getInstance();

        int c1 = Integer.parseInt(params.get(0));
        int r1 = Integer.parseInt(params.get(1));
        int c2 = Integer.parseInt(params.get(2));
        int r2 = Integer.parseInt(params.get(3));

        if (c1 < 1 || c1 > singleton.width - 2 || c2 < 1 || c2 > singleton.width - 2) {
            throw new InvalidCommandException("Co-ordinates out of bound");
        }
        if (r1 < 1 || r1 > singleton.height || r2 < 1 || r2 > singleton.height) {
            throw new InvalidCommandException("Co-ordinates out of bound");
        }

        if (r1 == r2) {
            for (int i = c1; i < c2 + 1; i++) {
                singleton.charArray[r1][i] = 'x';
            }
        }
        if (c1 == c2) {
            for (int i = r1; i < r2 + 1; i++) {
                singleton.charArray[i][c1] = 'x';
            }
        }
        return Utils.getCharArrayAsString(singleton.charArray);
    }

    @Override
    public void validate(List<String> params) throws InvalidCommandException {
        Pattern digits = Pattern.compile("\\d+");
        if (params.size() != 4 || !digits.matcher(params.get(0)).matches()
                || !digits.matcher(params.get(1)).matches() || !digits.matcher(params.get(2)).matches()
                || !digits.matcher(params.get(3)).matches()) {
            throw new InvalidCommandException("Line takes 4 parameters of numbers");
        }
    }
}
