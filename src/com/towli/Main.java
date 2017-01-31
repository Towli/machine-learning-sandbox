package com.towli;

import weka.core.Instances;

import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        String filePath = "assets/Arsenal_TRAIN.arff";
        System.out.println(readData(filePath));
    }

    /**
     * Read data from arff file
     * @return Instances
     */
    public static Instances readData(String filePath) {
        Instances instances = null;
        try {
            FileReader reader = new FileReader(filePath);
            instances = new Instances(reader);
        } catch(Exception e) {
            System.out.println("Exception caught: "+e);
        }
        return instances;
    }

}
