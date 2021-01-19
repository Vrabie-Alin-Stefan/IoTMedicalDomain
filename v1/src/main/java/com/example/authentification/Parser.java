/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package com.example.authentification;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class Parser {
    static ArrayList<Integer> oxigen_list;
    static ArrayList<Integer> pulse_list;

    public static void parseObj(String string2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < string2.length() - 1; ++i) {
            char c = string2.charAt(i);
            if (c != '{' && c != '}') continue;
            arrayList.add((Object)i);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i += 2) {
            arrayList2.add((Object)string2.substring(1 + (Integer)arrayList.get(i), ((Integer)arrayList.get(i + 1)).intValue()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("parseObj: ");
        stringBuilder.append((Object)arrayList2);
        Log.d((String)"ddddddd", (String)stringBuilder.toString());
        ArrayList[] arrarrayList = new ArrayList[3];
        for (int i = 0; i < arrarrayList.length; ++i) {
            arrarrayList[i] = new ArrayList();
        }
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            String[] arrstring = ((String)iterator.next()).split(", ");
            for (int i = 0; i < arrstring.length; ++i) {
                arrarrayList[0].add((Object)Integer.parseInt((String)arrstring[0].split("=")[1]));
            }
            arrarrayList[1].add((Object)Integer.parseInt((String)arrstring[1].split("=")[1]));
        }
        pulse_list = arrarrayList[1];
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("parseObj: ");
        stringBuilder2.append(pulse_list);
        Log.d((String)"fffffffyyyyyy", (String)stringBuilder2.toString());
        oxigen_list = arrarrayList[0];
    }
}

