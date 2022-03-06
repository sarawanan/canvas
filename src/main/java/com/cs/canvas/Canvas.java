package com.cs.canvas;

import java.util.List;
import java.util.regex.Pattern;

public class Canvas implements Shape {
    @Override
    public String draw(List<String> params) throws InvalidCommandException {
        validate(params);

        Singleton singleton = Singleton.getInstance();
        singleton.width = Integer.parseInt(params.get(0));
        singleton.height = Integer.parseInt(params.get(1));
        singleton.charArray = new char[singleton.height + 2][singleton.width];
        singleton.fillArray = new char[singleton.height + 2][singleton.width];

        for (int r = 0; r < singleton.height + 2; r++) {
            for (int c = 0; c < singleton.width; c++) {
                if ((r == 0) || (r == singleton.height + 1)) {
                    singleton.charArray[r][c] = '-';
                } else {
                    singleton.charArray[r][0] = '|';
                    singleton.charArray[r][singleton.width - 1] = '|';
                }
            }
        }
        return Utils.getCharArrayAsString(singleton.charArray);
    }

    @Override
    public void validate(List<String> params) throws InvalidCommandException {
        Pattern digits = Pattern.compile("\\d+");
        if (params.size() != 2 || !digits.matcher(params.get(0)).matches()
                || !digits.matcher(params.get(1)).matches()) {
            throw new InvalidCommandException("Canvas will take 2 parameters of numbers");
        }
    }
}
