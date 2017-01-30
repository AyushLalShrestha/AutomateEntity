package com.leapfrog.util;

import java.io.IOException;

public class CodeGenerator {

    public static String generateBasicCode(String line) throws IOException {
        String basicCode = "public class " + line + " { \r\n";
        return basicCode;
    }

    public static String generateDefineCode(String line) throws IOException {
        String definition = "";
        String[] dataTypes = line.split("%");
        for (String d : dataTypes) {
            String[] datas = d.split(":");
            definition = definition + "    private " + datas[1] + " " + datas[0] + ";\r\n";
        }
        return definition;

    }

    public static String createGetterAndSetter(String dataType, String[] varNames) throws IOException {
        String getterAndSetter = "";
        for (String s : varNames) {
            getterAndSetter = getterAndSetter + "\npublic void set" + s + "(" + dataType + " d ) { \r\n";
            getterAndSetter = getterAndSetter + "      this." + s + " = d ; \r\n";
            getterAndSetter = getterAndSetter + "} \r\n";

            getterAndSetter = getterAndSetter + "\npublic " + dataType + " get" + s + "() { \r\n";
            getterAndSetter = getterAndSetter + "       return this." + s + "; \r\n";
            getterAndSetter = getterAndSetter + "} \r\n";
        }

        return getterAndSetter;
    }

}
