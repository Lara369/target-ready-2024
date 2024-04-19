package com.targetindia.programs;

import com.targetindia.util.KeyboardUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Assn2 {

    public static void LongestLine(ArrayList<String> lines){
        if(lines.isEmpty()){
            System.out.println("the file is empty!");
            return;
        }
        ArrayList<Integer> lengths = new ArrayList<Integer>();
        for(String line : lines){
            int len = line.length();
            lengths.add(len);
        }
        int maxLen = Collections.max(lengths);
        int c=0;
        for(String line:lines){
            c++;
            int len = line.length();
            if(len == maxLen){
                System.out.printf("Line %d : %s",c,line);
                return;
            }
        }
    }
    public static void shortestLine(ArrayList<String> lines){
        if(lines.isEmpty()){
            System.out.println("the file is empty!");
            return;
        }
        ArrayList<Integer> lengths = new ArrayList<Integer>();
        for(String line : lines){
            int len = line.length();
            lengths.add(len);
        }
        int minLen = Collections.min(lengths);
        int c=0;
        for(String line:lines){
            c++;
            int len = line.length();
            if(len == minLen){
                System.out.printf("Line %d : %s",c,line);
                return;
            }
        }
    }

    public static int words(String line){
        int n=line.length();
        int cnt=0;
        int ind=0;
        for(int i=0;i<n;i++){
            if(line.charAt(i)!=' '){
                ind = i;
                break;
            }
        }
        for (int i = ind; i < n; i++) {
            if (line.charAt(i) == ' ') {
                cnt++;
            }
        }
        return cnt+1;
    }

    public static void sortedCount(ArrayList<Integer> count){
        Collections.sort(count);
        int n=count.size();
        for(int i=n-1;i>=0;i--){
            System.out.printf("%d words \n",count.get(i));
        }
    }
    public static void countWords(ArrayList<String> lines){
        if(lines.isEmpty()){
            System.out.println("the file is empty!");
            return;
        }
        ArrayList<Integer> count = new ArrayList<Integer>();
        for(String line : lines){
            count.add(Assn2.words(line));
        }
        int ind=1;
        for(int c:count){
            System.out.printf("Line %d : %d words \n",ind,c);
            ind++;
        }
        Assn2.sortedCount(count);
    }
    public static void main(String[] args) {
        String filePath = KeyboardUtil.getString("please enter the file name: ");
        File file = new File(filePath);
        ArrayList<String> lines = new ArrayList<>();
        try{
            if(file.exists()){
                Scanner reader = new Scanner(file);
                System.out.println("Contents of the file:");
                while (reader.hasNextLine()){
                    String line = reader.nextLine();
                    System.out.println(line);
                    lines.add(line);
                }
                if(lines.size()==0){
                    System.out.println("the file is empty!");
                }
            }
            else{
                System.out.println("The file name you entered does not exist");
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println("Longest line:");
        Assn2.LongestLine(lines);
        System.out.println();
        System.out.println("Shortest line:");
        Assn2.shortestLine(lines);
        System.out.println();
        System.out.println("Word count of each line:");
        Assn2.countWords(lines);
    }
}
