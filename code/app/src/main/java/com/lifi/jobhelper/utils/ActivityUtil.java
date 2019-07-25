package com.lifi.jobhelper.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityUtil {
    private static List<Activity> activityList = new ArrayList<>();
    private static ActivityUtil instance;

    public static synchronized ActivityUtil getInstance() {
        if (instance == null) {
            instance = new ActivityUtil();
        }
        return instance;
    }

    public static void addActivityToList(Activity activity) {
        if (activityList == null) {
            activityList = new ArrayList<>();
        }
        activityList.add(activity);
    }

    public static void removeActivityFromList(Activity activity) {
        if (activityList != null) {
            activityList.remove(activity);
        }
    }

    public static void exitSystem() {
        for (Activity activity:activityList) {
            if (activity != null) {
                activity.finish();
            }
        }
        activityList.clear();
    }
}
