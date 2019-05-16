package com.mmc.hellokotlin;

import com.mmc.strings.StringFunctions;

import java.util.ArrayList;
import java.util.List;

class Test {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(StringFunctions.joinToString(list, ",", "(", ")"));
        System.out.println(StringFunctions.lastChar("kotlin"));
    }
}