package com;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Administrator on 2021/2/23.
 */
public class leixingzhuanhuan {
    int i=1;
    Integer i1=i;
    byte b=1;

    public static void main(String[] args) {
       /* int a1 = 10;
        int b1 = ++a1;
        System.out.println("a1 = " + a1 + ",b1 = " + b1);
        int a2 = 10;
        int b2 = a2++;
        System.out.println("a2 = " + a2 + ",b2 = " + b2);
        int a3 = 10;
        ++a3;//a3++;
        int b3 = a3;
        System.out.println(b3);
*//*
        int a4 = 10;
        int b4 = a4--;//int b4 = --a4;
        System.out.println("a4 = " + a4 + ",b4 = " + b4);*//*

        boolean b4 = false;
        b4 = true;
        int num4 = -10;
        if(b4 || (num4++ > 0)){
            System.out.println("我现在在北京");
        }else{
            System.out.println("我现在在南京");
        }
        System.out.println("num4 = " + num4);*/
        
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的体重");
        int kg = sc.nextInt();
        System.out.println("请输入您的身高");
        double m = sc.nextDouble();

        double BMI=(double)kg/(m*m);
        if(BMI<18.5){
            System.out.println("过轻");
        }else  if(BMI>=18.5&&BMI<=25){
            System.out.println("正常");
        }else  if(BMI>25&&BMI<28){
            System.out.println("过重");
        }else  if(BMI>=28&&BMI<=32){
            System.out.println("肥胖");
        }else {
            System.out.println("非常肥胖");
        }
    }
    @Test
    public void test1(){
        Integer[] numbers={8,2,7,1,4,9,5};
        System.out.println("最大值为："+ Collections.max(Arrays.asList(numbers)));
        System.out.println("最小值为："+Collections.min(Arrays.asList(numbers)));
/*
        ArrayList<String> numbers1=new ArrayList<String>();
        numbers1.add("8");
        numbers1.add("2");
        numbers1.add("7");
        numbers1.add("1");
        numbers1.add("4");
        numbers1.add("9");
        numbers1.add("5");
        System.out.println(Collections.min(numbers1));
        System.out.println(Collections.max(numbers1));*/

    }
    @Test
    public void test2(){
        int [] arr={12,32,4,1,11,23};
        int max=arr[0];
        int min=arr[0];
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        int sum=0;
        int avg=0;
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
        }
        avg=sum/arr.length;
        System.out.println("最大值是："+max);
        System.out.println("最小值是："+min);
        System.out.println("总和："+sum);
        System.out.println("平均值："+avg);
    }

    @Test
    public void test3(){

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.println(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
    @Test
    public void test4() throws ParseException {
        int []arr={5,4,3,2,12};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j]>arr[j+1]){
                    int a =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=a;

                }
            }
        }
        System.out.println("从小到大的顺序是：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("从小到大的顺序是："+Arrays.toString(arr));

        int i=10;
        Integer in = new Integer(i);
        System.out.println(in);

        String s = in.toString();
        System.out.println(s);

        int i1 = new Integer(s);
        System.out.println(i1);

        //String转换为Int
        int i2 = Integer.parseInt(s);

        //int转化为String
        String s1 = String.valueOf(i2);

        String s2 = Integer.toString(i2);

        //Obj转化为int
        Object os=s;
        int i3 = Integer.parseInt((String) s);

        //obj转化为String
        String s3 = String.valueOf(os);


        //报错
        //obj转date
       /* SimpleDateFormat sim=new SimpleDateFormat("yyyy-mm-dd");
        Date date = new Date();
        String string = new String();
        //String转
        Date parse = sim.parse(string);
        System.out.println(parse);
        //date转
        String format;
        format = sim.format(date);
        System.out.println(format);*/
    }
    @Test
    public void test5(){



    }



}
