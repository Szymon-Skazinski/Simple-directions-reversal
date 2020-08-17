package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //    String[] arr = {"Begin on Road A", "Right on Road B", "Right on Road C", "Left on Road D"};

        String[] arr = {"Begin on 9th Dr", "Right on First Road", "Left on 3rd Blvd"};
        Solution.solve(arr);

    }
}


class Solution {
    public static String[] solve(String[] arr) {
        String[][] invertedDirectionRoadArray = new String[arr.length][2];

        for (int i = arr.length - 1; i >= 0; i--) {
            int j = Math.abs(i - arr.length + 1);

            String step = arr[i];

            String[] stepWordsArray = step.split(" ");
            String direction = stepWordsArray[0];

            String[] roadNameArray = Arrays.copyOfRange(stepWordsArray,2, stepWordsArray.length);
            String roadName = String.join(" ",roadNameArray);

            invertedDirectionRoadArray[j][0] = direction;
            invertedDirectionRoadArray[j][1] = roadName;
        }

        String[] resolve = new String[arr.length];

        for ( int i = 0; i < invertedDirectionRoadArray.length ; i++) {

            String direction = "";

            if (i > 0){
                direction = invertedDirectionRoadArray[i-1][0];
            }

            if (i == 0){
                resolve[0] = "Begin on " + invertedDirectionRoadArray[i][1];
            } else if (direction.equalsIgnoreCase("Left")){
                resolve[i] = "Right on " + invertedDirectionRoadArray[i][1];
            } else {
                resolve[i] = "Left on " + invertedDirectionRoadArray[i][1];
            }

        }

        System.out.println(resolve);
        return resolve;

    }
}

