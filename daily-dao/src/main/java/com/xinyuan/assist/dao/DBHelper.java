package com.xinyuan.assist.dao;

import java.util.concurrent.ConcurrentMap;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBHelper {

    private static String DB_FILE_NAME = "daily.db";

    private static String DB_VISIT_CNT = "visitCnt";

    private static Logger logger = LoggerFactory.getLogger(DBHelper.class);

    public static boolean saveKV(String key, Object val) {
        try {
            DB db = DBMaker.fileDB(DB_FILE_NAME).make();
            ConcurrentMap map = db.hashMap(DB_VISIT_CNT).createOrOpen();
            map.put(key, val);
            db.close();
            return true;
        } catch (Exception e) {
            logger.error("", e);
        }
        return false;
    }

    public static Object getByK(String key) {
        try {
            DB db = DBMaker.fileDB(DB_FILE_NAME).make();
            ConcurrentMap map = db.hashMap(DB_VISIT_CNT).createOrOpen();
            Object val = map.get(key);
            db.close();
            return val;
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }

    public static void main(String[] args) {
        saveKV("hello", "word");
        System.out.println(getByK("hello"));
    }
}
