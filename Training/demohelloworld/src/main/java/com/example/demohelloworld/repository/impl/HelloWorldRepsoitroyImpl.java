package com.example.demohelloworld.repository.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.example.demohelloworld.repository.HelloWorldRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldRepsoitroyImpl implements HelloWorldRepository {

    String[] list ={"Hi", "KD", "How", "the", "Hell", "Are", "You", "Hmmmmm", "????", "Ahaaannnn"};
    //additional
    List<String> stringList =  new ArrayList<>();

    Random rand = new Random();

    @Override
    public String getMessage(){
        stringList.add("Bye");
        stringList.add("KD");
        stringList.add("See");
        stringList.add("You");
        stringList.add("Soon");
        stringList.add("Baad");
        stringList.add("Mein");
        stringList.add("Kya");
        stringList.add("Hoga");
        stringList.add("Hmmmm");
        stringList.add("??");
        return list[rand.nextInt(10)] + " " + stringList.get(rand.nextInt(10));
    }
}
