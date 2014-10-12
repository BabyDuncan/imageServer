package com.babyduncan;

import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.io.IOException;

/**
 * User: guohaozhao (guohaozhao116008@sohu-inc.com)
 * Date: 10/12/14 13:08
 */
public final class LogInitUtil {

    private LogInitUtil() {

    }

    private final static String[] locations = {".", "classes", "bin", "target/classes", "target/test-classes"};

    private static String getFilePath(File f) {
        try {
            return f.getCanonicalPath();
        } catch (IOException e) {
            return f.getAbsolutePath();
        }
    }

    /**
     * 配置并监听log4j
     */
    public static boolean configureAndWatch() {
        for (String location : locations) {
            File f = new File(location, "log4j.xml");
            if (f.exists()) {
                System.out.println("[log4j] configureAndWatch " + getFilePath(f));
                DOMConfigurator.configureAndWatch(f.getAbsolutePath());
                return true;
            }
        }
        return false;
    }

    /**
     * 初始化
     */
    public void init() {
        LogInitUtil.configureAndWatch();
    }

}
