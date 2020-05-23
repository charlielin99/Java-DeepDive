package com.company;

/*
This problem was asked by Google.

The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

Hint: The basic equation of a circle is x2 + y2 = r2.
*/

import java.util.Random;
import java.lang.Math;

public class Main {
    public static void main(String[] args){
        Random r = new Random(System.currentTimeMillis());
        int num_points = 10000000;
        int inside_circle = 0;
        int inside_square = 0;

        int min = -1;
        int max = 1;
        for (int x = 0; x<num_points; x++){
            double new_x = min + (max-min)*r.nextDouble();
            double new_y = min + (max-min)*r.nextDouble();

            double val = Math.sqrt((Math.pow(new_x,2)) + Math.pow(new_y,2));
            if (val <=1){
                inside_circle++;
            }
            inside_square++;
        }
        System.out.println(4*(double)inside_circle/inside_square);
    }
}
