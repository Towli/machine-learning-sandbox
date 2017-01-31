package com.towli;

import weka.core.Instances;
import java.io.FileReader;

public class Main {

    private static final String trainingFilePath = "assets/Arsenal_TRAIN.arff";
    private static final String testingFilePath = "assets/Arsenal_TEST.arff";
    private static final String divider = "----------------";

    public static void main(String[] args) {

        Instances trainingInstances = readData(trainingFilePath);
        Instances testingInstances = readData(testingFilePath);
        int wins = 0;

        System.out.println("# instances in training data: " + trainingInstances.numInstances());
        System.out.println("# attributes in training data: " + trainingInstances.numAttributes());
        wins = findOccurrencesOfValue(3, 2.0, trainingInstances);
        System.out.println("# wins in training data: " + wins);

        System.out.println(divider);

        System.out.println("# instances in testing data: " + testingInstances.numInstances());
        System.out.println("# attributes in testing data: " + testingInstances.numAttributes());
        wins = findOccurrencesOfValue(3, 2.0, testingInstances);
        System.out.println("# wins in testing data: " + wins);

    }

    /**
     * Iterates over Instances in a dataset counting the occurrences of a value
     * of a particular attribute.
     * @param attributeIndex
     * @param targetValue
     * @param dataSet
     * @return occurrences
     */
    public static int findOccurrencesOfValue(int attributeIndex, double targetValue,
                                                Instances dataSet) {
        int count = 0;
        for (int i = 0; i < dataSet.numInstances(); i++)
            if (dataSet.instance(i).value(attributeIndex) == targetValue)
                count++;
        return count;
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
