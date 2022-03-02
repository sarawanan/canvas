package com.cs.canvas;

public class Canvas {
    Canvas(char[][] charArray, int x, int y) {
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
}
