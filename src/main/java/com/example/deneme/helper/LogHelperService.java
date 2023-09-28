package com.example.deneme.helper;

import lombok.extern.slf4j.Slf4j;

import static com.example.deneme.converter.LogMapper.mapToJsonString;

@Slf4j
public class LogHelperService {
    private static void logMessage(String className, String methodName, String logMessage) {
        log.info("ProductManager::{}::{} {}", className, methodName, logMessage);
    }

    public static void errorLogger(String className, String methodName, String logMessage) {
        log.error("ProductManager::{}::{} {}", className, methodName, logMessage);
    }

    public static String getMethodName(Throwable throwable) {
        return throwable.getStackTrace()[0].getMethodName();
    }

    public static void startLogger(String name, String methodName) {
        logMessage(name, methodName, "started");
    }

    public static void listLogger(String name, String methodName, int size) {
        logMessage(name, methodName, "list returned with size: " + size);
    }

    public static void objectLogger(String className, String methodName, Object o) {
        logMessage(className, methodName, "Object: " + mapToJsonString(o));
    }

    public static void finishLogger(String name, String methodName) {
        logMessage(name, methodName, "finished");
    }
}
