package com.company;

import java.util.Arrays;

class Solution {
    public static String[] solve(String[] arr) {
        String[][] invertedStepsArray = stepsInversion(arr);

        String[] resolve = directionInversion(arr, invertedStepsArray);

        System.out.println(resolve);
        return resolve;
    }

    private static String[] directionInversion(String[] arr, String[][] invertedStepsArray) {
        String[] resolve = new String[arr.length];

        for (int i = 0; i < invertedStepsArray.length; i++) {

            String direction = "";

            if (i > 0) {
                direction = invertedStepsArray[i - 1][0];
            }

            if (i == 0) {
                resolve[0] = "Begin on " + invertedStepsArray[i][1];
            } else if (direction.equalsIgnoreCase("Left")) {
                resolve[i] = "Right on " + invertedStepsArray[i][1];
            } else {
                resolve[i] = "Left on " + invertedStepsArray[i][1];
            }

        }
        return resolve;
    }

    private static String[][] stepsInversion(String[] arr) {
        String[][] invertedStepsArray = new String[arr.length][2];

        for (int i = arr.length - 1; i >= 0; i--) {
            int j = Math.abs(i - arr.length + 1);

            String step = arr[i];

            String[] stepWordsArray = step.split(" ");
            String direction = stepWordsArray[0];

            String[] roadNameArray = Arrays.copyOfRange(stepWordsArray, 2, stepWordsArray.length);
            String roadName = String.join(" ", roadNameArray);

            invertedStepsArray[j][0] = direction;
            invertedStepsArray[j][1] = roadName;
        }
        return invertedStepsArray;
    }
}
