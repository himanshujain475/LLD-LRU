package com.example.LRU.command;

public interface CacheCommand<T,U> {

    public void put(T key,U value);

    public U get(T key);


}
