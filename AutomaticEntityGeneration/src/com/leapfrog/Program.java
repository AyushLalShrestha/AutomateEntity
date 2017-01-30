package com.leapfrog;

import com.leapfrog.util.CodeGenerator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    
    public static void main(String[] args) {
        String srcPath = "D:\\Java Projects\\AutomateEntity\\Definition.txt";
        String destPath = "D:\\Java Projects\\AutomateEntity\\Destination";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(srcPath));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(";");
                FileWriter writer = new FileWriter(destPath + "\\" + tokens[0] + ".txt");
                writer.write(CodeGenerator.generateBasicCode(tokens[0]));
                writer.write(CodeGenerator.generateDefineCode(tokens[1]));
                
                String[] dataTypes = tokens[1].split("%");
                for (String s : dataTypes) {
                    String[] colonSplit = s.split(":");
                    writer.write(CodeGenerator.createGetterAndSetter(colonSplit[1], colonSplit[0].split(",")));
                }
                
                writer.write("\n }");
                writer.close();
            }
            
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        
    }
    
}
