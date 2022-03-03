package com.cs.canvas;

import java.util.List;
import java.util.regex.Pattern;

public class Fill {
    private void validate(List<String> params) throws InvalidCommandException {
        Pattern digits = Pattern.compile("\\d+");
        if (params.size() != 3 || !digits.matcher(params.get(0)).matches()
                || !digits.matcher(params.get(1)).matches()
                || params.get(2).length() != 1) {
            throw new InvalidCommandException("Solid fill take 2 parameters of numbers and last param of any char");
        }
    }

    public void draw(char[][] charArray, List<String> params, int height, int width, char[][] fillArray) throws InvalidCommandException {
        validate(params);
        int x = Integer.parseInt(params.get(0));
        int y = Integer.parseInt(params.get(1));

        char fill = params.get(2).charAt(0);
        for (int i = 1; i < height + 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                if (charArray[i][j] != 'x') {
                    if (fillArray[i][j] != '#') {
                        charArray[i][j] = fill;
                    }
                }
            }
        }
    }
}
