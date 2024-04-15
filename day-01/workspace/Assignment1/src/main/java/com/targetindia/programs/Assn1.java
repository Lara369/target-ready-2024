package com.targetindia.programs;

import com.targetindia.util.KeyboardUtil;

public class Assn1 {

    public static int firstDay(int month,int year){
        int[] MonthCode = {0,3,3,6,1,4,6,2,5,0,3,5};
        int day=1;
        int century = (year - (year%100))%4;
        int centuryCode=0;
        if(century == 0){
            centuryCode+=6;
        }
        else if(century == 1){
            centuryCode+=4;
        }
        else if(century==2){
            centuryCode+=2;
        }
        else {
            centuryCode+=0;
        }
        int yearCode = ((year%100) + ((year%100)/4))%7 ;
        int sum = day + MonthCode[month-1] + centuryCode+ yearCode;
        int leapYear =0;
        if(year%4 == 0){
            if(month==1 || month==2){
                leapYear=1;
            }

        }
        sum = sum -leapYear;
        sum = sum%7;
        return sum;
    }

    public static void calendar(int month, int year){
        if(month > 12 || month < 1){
            System.out.println("Please enter valid input");
            return;
        }
        if(year<1600){
            System.out.println("Please enter a valid year");
            return;
        }
        int day1is = firstDay(month, year);
        int[] numberOfDays= {31,28,31,30,31,30,31,31,30,31,30,31};
        if(year%4==0){
            numberOfDays[1]=29;
        }
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int totaldays = numberOfDays[month-1];
        String[] calen = new String[totaldays+1];
        calen[1]=days[day1is];
        for(int i=0;i<7;i++){
            System.out.print(days[i] + "    ");
        }
        System.out.println();
        for(int i=0;i<day1is;i++){
            System.out.print("       ");
        }
        System.out.print(1);
        int till= 1 + (6 - day1is);

        for(int i=2;i<=till;i++){
            System.out.print("      ");
            System.out.print(i);
        }
        System.out.println();
        int count=0;
        for(int i=till+1;i<=totaldays;i++){

            if(count==7){
                count=0;
                System.out.println();
            }
            System.out.print(i);
            if(i<10){
                System.out.print("      ");
            }
            else{
                System.out.print("     ");
            }
            count++;
        }

    }

    public static void main(String[] args) {
        int month = KeyboardUtil.getInt("Enter month: ");
        int year = KeyboardUtil.getInt("Enter year: ");
        calendar(month,year);
    }
}