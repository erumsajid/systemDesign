package com.system.design.projects.designPattern.structural.FlyWeight;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {

    private static final Map<String,TreeType> treeTypeMap= new HashMap<>();;

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;

        treeTypeMap.putIfAbsent(key, new TreeType(name, color, texture));
        return treeTypeMap.get(key);
    }
}
