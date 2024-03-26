package com.example.LRU.command;

import java.util.HashMap;

public class CacheImplFactory {

    public HashMap<String,CacheCommand> maps;

    public CacheImplFactory cacheImplFactory;

    public CacheImplFactory(){
        maps.put("LRU",new BasicImpl());
    }

   public CacheCommand getImpl(String impl){
       return maps.get(impl);
    }
}
