package com.exec;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: Test if working :p
public class ReportAuth {
 
    
    public static Boolean check(String a, String b, String c){
        ProcessBuilder processBuilder = new ProcessBuilder();


 
        try {
 
            FileWriter fWritera = new FileWriter(
                "./a.txt");
				FileWriter fWriterb = new FileWriter(
					"./b.txt");
					FileWriter fWriterc = new FileWriter(
                "./c.txt");
 
            
            fWritera.write(a);
 
            System.out.println(a);
 
            fWritera.close();

			fWriterb.write(b);
 
            System.out.println(b);
 
            fWriterb.close();

			fWriterc.write(c);
 
            System.out.println(c);
 
            fWriterc.close();
 
 
         }
 
        catch (IOException e) {
 
            System.out.print(e.getMessage());
        }
    


	processBuilder.command("node ./check.js ");


	try {

		Process process = processBuilder.start();

		StringBuilder output = new StringBuilder();

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null) {
			output.append(line + "\n");
		}
        var ab =output.toString();
        

		int exitVal = process.waitFor();
		if (exitVal == 0 && ab.equals("True")) {
			System.out.println("Success!");
			System.out.println(output);
            return true;
			// System.exit(0);
		} else {
            return false;
			//abnormal...
		}

	} catch (IOException e) {
        
		e.printStackTrace();
        return false;
	} catch (InterruptedException e) {
		e.printStackTrace();
        return false;
	}

    }}
