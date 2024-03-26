package com.example.LRU.model;

import com.example.LRU.exception.KeyNotFoundException;
import com.example.LRU.exception.KeyValueException;

public class LinkedListModel<T,U> {

    private  int totalNodes=0;

    Node head;

    Node tail;
    class Node<T,U>{
        T key;
        U value;

        Node previous;

        Node next;
    }

    public LinkedListModel(){

    }

    public void put(T key, U value){
        this.totalNodes++;
        if(key == null || value == null){
            throw  new KeyValueException();
        }
        Node<T,U> node = new Node<>();
        node.key = key;
        node.value = value;

        if(head == null){
            head= node;
            tail = node;
        }
        else{
            tail = node;
        }
    }

    public U get(T key){
        if(tail == null){
            throw  new KeyNotFoundException();
        }
        else{
            Node current = head;
            while(current != null){
                  if(current.key == key){
                      return (U) current.value;
                  }else{
                      current= current.next;
                  }
            }
           throw new KeyNotFoundException();
        }
    }

    public void remove(T key){
        Node current = head;
        Node previous= head;
        if(head == null){
            throw  new KeyNotFoundException();
        }
        if(head.key == key){
            head = current.next;
            current.next = null;
            head.previous = null;
        }
        current = current.next;
        while(current != null){
            if(current.key == key){
                this.totalNodes--;
                current= current.next;
                previous.next = current;
                current.previous = current;
                break;
            }
            previous = current;
            current = current.next;

        }

        throw new KeyNotFoundException();

    }

    public void removeHeadValue(){
        Node current = head;
        if(head == null){
            throw  new KeyNotFoundException();
        }

        head = current.next;
        current.next = null;
        head.previous = null;
       this.totalNodes--;
    }

    public int getSize(){
        return  this.totalNodes;
    }


}
