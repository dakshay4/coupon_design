package com.dakshay.CommonUtility;

import java.util.Random;

/**
 * Created by Dakshay on 11/19/2018.
 */
public class RandomNumber {
    public static String getAlphaNumericWord(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while(salt.length()<5){
            int index = (int)(rnd.nextFloat()*SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public static void main(String[] args) {
        System.out.println(RandomNumber.getAlphaNumericWord());
    }
}
