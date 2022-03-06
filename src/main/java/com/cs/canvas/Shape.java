package com.cs.canvas;

import java.util.List;

interface Shape {
    void validate(List<String> params) throws InvalidCommandException;

    String draw(List<String> params) throws InvalidCommandException;
}
