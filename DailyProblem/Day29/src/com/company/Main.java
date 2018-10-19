package com.company;

/*
This problem was asked by Amazon.

Run-length encoding is a fast and simple method of encoding strings.
The basic idea is to represent repeated successive characters as a single count and character.
For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have
no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.

*/

public class Main {

    public static void main(String[] args) {
        String encoded = encode("AAAABBBCCDAA");
        System.out.println(encoded);
        String decoded = decode(encoded);
        System.out.println(decoded);
    }

    public static String encode (String input){
        StringBuilder stringBuilder = new StringBuilder();
        int currentCount = 1;
        char charBeingCounted = input.charAt(0);

        for (int i=1; i < input.length(); i++){

            char current = input.charAt(i);

            if (current != charBeingCounted){
                stringBuilder.append(currentCount);
                stringBuilder.append(charBeingCounted);
                charBeingCounted = current;
                currentCount = 1;
            } else {
                currentCount++;
            }

            if (i == input.length() - 1){
                stringBuilder.append(currentCount);
                stringBuilder.append(current);
            }
        }

        return stringBuilder.toString();
    }

    public static String decode (String input){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<input.length(); i+=2){
            for (int j=0; j < Character.getNumericValue(input.charAt(i)); j++){
                stringBuilder.append(input.charAt(i+1));
            }
        }

        return stringBuilder.toString();
    }
}
