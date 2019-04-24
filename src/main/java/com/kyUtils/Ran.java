package com.kyUtils;


import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 随机生成字母和数字的组合
 */
public class Ran {


    public static String getItemID() {
        int n=6;
        String val = "";
        Random random = new Random();
        for ( int i = 0; i < n; i++ ) {
            String str = random.nextInt( 2 ) % 2 == 0 ? "num" : "char";
            if ( "char".equalsIgnoreCase( str ) )
            { // 产生字母
                int nextInt = random.nextInt( 2 ) % 2 == 0 ? 65 : 97;
                // System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
                val += (char) (int)(26*(Math.random())+65);
            }
            else if ( "num".equalsIgnoreCase( str ) )
            { // 产生数字
                val += String.valueOf( random.nextInt( 10 ) );
            }
        }
        return val;
    }

}
