package com.cosumer.producer.thread.tryer;

import java.util.ArrayList;
import java.util.List;

import com.cosumer.producer.thread.tryer.worker.CosumerRunnable;
import com.cosumer.producer.thread.tryer.worker.ProducerRunnable;

public class App 
{
    public static void main( String[] args )
    {
    	List<Integer> sharedList = new ArrayList<>();
        Thread consumerThread = new Thread(new CosumerRunnable(sharedList));
        Thread producerThread = new Thread(new ProducerRunnable(sharedList, 7));
        
        producerThread.start();
        consumerThread.start();
        
        System.out.println("aq");
    }
}
