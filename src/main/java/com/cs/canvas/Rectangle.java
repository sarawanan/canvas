package com.cs.canvas;

public class Rectangle {
    Rectangle(char[][] charArray, int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2 + 1; i++) {
            for (int j = x1 - 1; j < x2; j++) {
                if ((i == y1) || (i == y2)) {
                    charArray[i][j] = 'x';
                } else {
                    charArray[i][x1 - 1] = 'x';
                    charArray[i][x2 - 1] = 'x';
                }
            }
        }
    }
}
