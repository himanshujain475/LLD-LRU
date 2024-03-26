package com.example.LRU.command;

import com.example.LRU.exception.KeyNotFoundException;
import com.example.LRU.model.LinkedListModel;

public class BasicImpl<T,U> implements  CacheCommand{

    private LinkedListModel model;

    private  int currentCapicity =0;

    public  BasicImpl(){
        this.model = new LinkedListModel();
    }
    public  BasicImpl(int currentCapcity){
        this.model = new LinkedListModel();
        this.currentCapicity = currentCapcity;
    }
    @Override
    public void put(Object key, Object value) {
        if(currentCapicity == this.model.getSize()){
            this.model.removeHeadValue();
        }
        this.model.put(key,value);

    }

    @Override
    public U get(Object key) {
        try{
            U value= (U) this.model.get(key);
            //Now pop the element
            this.model.remove(key);
            this.model.put(key,value);
            return value;
        }
        catch(KeyNotFoundException keyNotFoundException) {
            System.out.println("Key Not found Exception");
            return null;
        }
    }
}
