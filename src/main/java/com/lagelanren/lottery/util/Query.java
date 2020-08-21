package com.lagelanren.lottery.util;
 

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
 
public class Query {
 
    public static final String APPKEY = "你的appkey";// 你的appkey
    public static final String URL = "https://api.jisuapi.com/caipiao/query";
    public static final String caipiaoid = "11";
 
    public static String Get(String issueno) {
        String result = null;
        Map<String,String> params = new HashMap();	
        params.put("appkey", APPKEY);
        params.put("caipiaoid",caipiaoid);
        params.put("issueno",issueno);
        
        try {
            result = HttpUtil.sendPost(URL, params);
            JSONObject json = JSONObject.fromObject(result);
            if (json.getInt("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONObject resultarr = json.optJSONObject("result");
                String caipiaoid = resultarr.getString("caipiaoid");
                String issueno1 = resultarr.getString("issueno");
                String number = resultarr.getString("number");
                String refernumber = resultarr.getString("refernumber");
                String opendate = resultarr.getString("opendate");
                String deadline = resultarr.getString("deadline");
                String saleamount = resultarr.getString("saleamount");
                System.out.println(caipiaoid + " " + issueno1 + " " + number + " " + refernumber + " " + opendate + " "
                        + deadline + " " + saleamount);
                System.out.println(number + " " + refernumber);
                return number + " " + refernumber;
//                if (resultarr.opt("prize") != null) {
//                    JSONArray prize = resultarr.optJSONArray("prize");
//                    for (int i = 0; i < prize.size(); i++) {
//                        JSONObject obj = (JSONObject) prize.opt(i);
//                        String prizename = obj.getString("prizename");
//                        String require = obj.getString("require");
//                        String num = obj.getString("num");
//                        String singlebonus = obj.getString("singlebonus");
//                        System.out.println(prizename + " " + require + " " + num + " " + singlebonus);
//                        return num;
//                    }
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[]args) {
    	Get("2020079");
    }
    
}