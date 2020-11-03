package com.example.myapplication;

abstract class User implements Cloneable{
    protected String colorName;

    abstract void addUser();

    public Object clone()
    {
        Object clone = null;
        try
        {
            clone = super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return clone;
    }
}
