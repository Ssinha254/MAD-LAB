package com.example.lab7_q1;

public class AppItem {
    public String name;
    public String packageName;
    public android.graphics.drawable.Drawable icon;
    public boolean isSystemApp;
    public AppItem(String name, String packageName ,android.graphics.drawable.Drawable icon, boolean isSystemApp){
        this.name = name;
        this.packageName = packageName;
        this.icon = icon;
        this.isSystemApp = isSystemApp;
    }
}
