package com.example.LRU.controller;

import com.example.LRU.command.BasicImpl;
import com.example.LRU.command.CacheCommand;
import com.example.LRU.command.CacheImplFactory;

public class CacheController<T,U> {
    CacheCommand cacheCommand;

    CacheImplFactory cacheImplFactory;
    CacheController(int capacity,String impl){
        cacheImplFactory = new CacheImplFactory();
         cacheCommand = cacheImplFactory.getImpl(impl);

    }

    public void put(T key,U value){
        cacheCommand.put(key,value);
    }

    public U get(T key){
      return (U) cacheCommand.get(key);
    }
}
