package com.polytech.LBChess.model;

public class NullUser extends User {
    @Override
    public boolean isNull() {
        return true;
    }
}
