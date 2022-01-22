package com.chs;

import java.time.LocalDate;

public class Solution507 {

    public boolean checkPerfectNumber(int num) {

        int sum = 1;

        for(int i=2; i< num ; i++){
            if(num % i == 0){
                if(i>num/i){
                    break;
                }
                sum += i + num/i;
                if(sum > num){
                    return false;
                }
            }
        }

        return sum == num;



    }

    

    public static void main(String[] args) {

        System.out.println(LocalDate.now().getDayOfWeek().toString());;

        String res = LocalDate.of(2020,1,3).getDayOfWeek().toString();


      }

    public String dayOfTheWeek(int day, int month, int year) {

        String res = LocalDate.of(year,month,year).getDayOfWeek().toString();

        return res.substring(0,1) + res.substring(1).toLowerCase();

    }
}
