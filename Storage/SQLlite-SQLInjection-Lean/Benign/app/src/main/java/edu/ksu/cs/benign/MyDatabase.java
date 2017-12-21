package edu.ksu.cs.benign;

import android.provider.BaseColumns;

/**
 * Created by Joy on 9/6/17.
 */

public final class MyDatabase {

    private MyDatabase(){};

    public static class Table1 implements BaseColumns{
        public static String TABLE_NAME = "table1";
        public static String COLUMN_NAME_USER = "username";
        public static String COLUMN_NAME_PASS = "password";
    }
}
