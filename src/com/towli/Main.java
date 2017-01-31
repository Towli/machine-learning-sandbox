package com.towli;

import weka.core.Instances;

import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        String file = "";
        Instances train;

        try {
            FileReader reader = new FileReader(file);
        } catch(Exception e) {
            System.out.println("Exception caught: "+e);
        }

    }
}
