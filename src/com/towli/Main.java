package com.towli;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import java.io.FileReader;
import java.util.Arrays;

public class Main {

    private static final String trainingFilePath = "assets/Arsenal_TRAIN.arff";
    private static final String testingFilePath = "assets/Arsenal_TEST.arff";
    private static final String divider = "----------------";

    public static void main(String[] args) throws Exception {

        Instances trainingInstances = readData(trainingFilePath);
        Instances testingInstances = readData(testingFilePath);
        int wins;

        /* Print characteristics & information of data sets */
        System.out.println("# instances in training data: " + trainingInstances.numInstances());
        System.out.println("# attributes in training data: " + trainingInstances.numAttributes());
        wins = findOccurrencesOfValue(3, 2.0, trainingInstances);
        System.out.println("# wins in training data: " + wins);
        System.out.println("Printing all instances of training data: ");
        System.out.println(trainingInstances.toString());
        System.out.println(divider);

        System.out.println("# instances in testing data: " + testingInstances.numInstances());
        System.out.println("# attributes in testing data: " + testingInstances.numAttributes());
        wins = findOccurrencesOfValue(3, 2.0, testingInstances);
        System.out.println("# wins in testing data: " + wins);
        double[] instance = testingInstances.get(4).toDoubleArray();
        System.out.println("5th instance of testing data: " + Arrays.toString(instance));

        /* Set which attribute is the class value (the thing we want to predict) */
        trainingInstances.setClassIndex(trainingInstances.numAttributes()-1);
        /* Build NaiveBayes classifier with training data */
        NaiveBayes naiveBayes = new NaiveBayes();
        naiveBayes.buildClassifier(trainingInstances);

        /* Iterate over test data classifying each instance, summing the amount of accurate classifications */
        int counts = 0;
        for (int i = 0; i < testingInstances.numInstances(); i++) {
            // todo
        }
        System.out.println("Num of accurate classifications: " + counts);

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
