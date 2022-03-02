package com.cs.canvas;

public class Line {
    Line (char[][] charArray, int x1, int y1, int x2, int y2) {
        if (y1 == y2) {
            for (int i = x1; i<x2+1; i++) {
                charArray[y1][i] = 'x';
            }
        }
        if (x1 == x2) {
            for (int i = y1; i<y2+1; i++) {
                charArray[i][x1] = 'x';
            }
        }
    }
}
