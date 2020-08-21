package com.lagelanren.lottery.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by admin on 2017/1/10.
 * 双色球机选实现
 */
public class Ssq {

    public static void main(String[] args) {

        int arrayNums = 5; //机选5组
        for(int i=0;i<arrayNums;i++){
            String hm = getYZHM("2 5 15",0.7);
            System.out.println(hm);
        }
    }

    /**
     * 产生一组双色球选号
     * @return 一注号码
     */
    public static String getYZHM(String luckNum,Double threshold){
       //33选6
        int[] exist = new int[6]; //默认全0
        for(int i=0;i<6;i++){
            int ball = getABall(33,exist);
            exist[i] = ball; //暂存已选的球
        }
        luck(exist,luckNum,threshold);
        sort(exist); //排序
        //16选1
        int specialBall = getABall(16,null);

        //拼接字符串
        String hm = "";
        for(int i=0;i<6;i++){
            String num = exist[i] < 10 ? "0"+exist[i] : ""+ exist[i];
            if(i==0){
                hm+= num;
            }else{
                hm+= ","+ num;
            }
        }
        hm += ","+(specialBall<10? "0"+specialBall:""+specialBall);
        return hm;
    }

    /**
     * 摇出一个号码
     * @param total 球总数
     * @param exist 已经选出的球
     * @return 一个新号码
     */
    private static int getABall(int total,int[] exist){
        Random random = new Random();
        int ball = random.nextInt(total)+1;
        while(true){
            if(contains(exist,ball)){
                ball = random.nextInt(total)+1;
            }else{
                break; //取到了新球，结束
            }
        }
        return ball;
    }

    /**
     * 判断数组是否包含某个元素
     * @param array 数组
     * @param value 元素
     * @return 是否存在
     */
    private static boolean contains(int[] array,int value){
        boolean c = false;
        if(array == null){
            return false;
        }
        for(int i=0;i<array.length;i++){
            if(array[i] == value){
                c = true;
                break;
            }
        }
        return c;
    }

    /**
     * 排序
     * @param array 数组
     */
    private static void sort(int[] array){
        for(int i=0;i< array.length-1;i++){ //比多少次
            for(int j= i+1;j<array.length;j++){ //每次循环，将最小数提前
                if(array[i]>array[j]){ //小数冒泡
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
    
    /**
     * 概率知否中
     */
    private static boolean ifThreshold(Double threshold) {
    	Random random = new Random();
    	if(threshold >= random.nextDouble()) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * 幸运球
     * @param array 数组
     */
    private static void luck(int[] exist, String luckNum,Double threshold) {
    	String[] luckNumList = luckNum.split(" ");
    	for(int i = 0;i<luckNumList.length;i++) {
    		if(ifThreshold(threshold) == true) {
    			int luckItemNum = Integer.parseInt(luckNumList[i]);
    			if(contains(exist,luckItemNum)==false) {
    				exist[i] = luckItemNum;
    			}
    		}
    	}
    }

}
