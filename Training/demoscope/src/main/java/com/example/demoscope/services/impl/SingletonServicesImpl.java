package com.example.demoscope.services.impl;

import com.example.demoscope.repository.SingletonRepo;
import com.example.demoscope.services.SingletonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope (value = "prototype")
public class SingletonServicesImpl implements SingletonServices {

    //@Autowired
    SingletonRepo singletonRepo;

    public SingletonServicesImpl() {
        System.out.println("Inside Services");
    }

    @Autowired
    public void setSingletonRepo3(SingletonRepo singletonRepo){
        System.out.println("Seetter for Repo333333 Injection!!");
        this.singletonRepo = singletonRepo;
    }
    @Autowired
    public void setSingletonRepo2(SingletonRepo singletonRepo){
        System.out.println("Seetter for Repo22222 Injection!!");
        this.singletonRepo = singletonRepo;
    }
    @Override
    public String getMessage(){
        return "SingleTon Service";
    }
}