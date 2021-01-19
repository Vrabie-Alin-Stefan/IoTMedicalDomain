/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.example.authentification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Forecast {
    HashMap<Integer, Integer> f = new HashMap();

    public int forecatsMyData(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); ++i) {
            int n = arrayList.get(i) / 10;
            if (this.f.containsKey((Object)n)) {
                this.f.put(n, (1 + f.get((Object)n)));
                continue;
            }
            this.f.put(n, 1);
        }
        int n = (Integer)Collections.max((Collection)this.f.values());
        int n2 = 0;
        for (Map.Entry entry : this.f.entrySet()) {
            if ((Integer)entry.getValue() != n) continue;
            n2 = (Integer)entry.getKey();
        }
        return 5 + n2 * 10;
    }
}

