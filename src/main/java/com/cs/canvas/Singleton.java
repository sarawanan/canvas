package com.cs.canvas;

class Singleton {
    private static Singleton singleton = null;
    public int width;
    public int height;
    public char[][] charArray;
    public char[][] fillArray;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
