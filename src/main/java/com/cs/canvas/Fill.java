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

    public void draw(char[][] charArray, List<String> params) throws InvalidCommandException {
        validate(params);
    }
}
