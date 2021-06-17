package com.summer.springvuedemo.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.summer.springvuedemo.demo.dao.MainDataDao;
import com.summer.springvuedemo.demo.entity.Maindata;
import com.summer.springvuedemo.demo.service.DataProcessService;
import com.summer.springvuedemo.demo.utils.RequestUtil;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
@Service
public class DataProcess implements DataProcessService {
    @Resource
    private MainDataDao mainDataDao;
    public String fromTencentApi() throws IOException {
        RequestUtil request = new RequestUtil();
        String response = request.get("https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5");
        JSONObject obj = JSON.parseObject(response);
        System.out.println(obj.get("data"));


        String lastUpdateTime = obj.getJSONObject("data").getString("lastUpdateTime");
        String year=lastUpdateTime.substring(0,4);
        String month = lastUpdateTime.substring(5, 7);
        String day = lastUpdateTime.substring(8, 10);

        System.out.println(year + month + day);
        Maindata data1 = mainDataDao.getDataById(1);
        System.out.println(data1);


        JSONObject chinaTotal = obj.getJSONObject("chinaTotal");
        JSONObject chinaAdd = obj.getJSONObject("chinaAdd");

        Integer confirm_cn = chinaTotal.getInteger("confirm");//累计确诊
        Integer heal_cn = chinaTotal.getInteger("heal");//累计治愈，没有现存
        Integer dead_cn = chinaTotal.getInteger("dead");//累计死亡，没有现存
        Integer nowConfirm_cn = chinaTotal.getInteger("nowConfirm");//现存确诊
        Integer suspect_cn = chinaTotal.getInteger("suspect");//疑似，没有累计
        Integer nowSevere_cn = chinaTotal.getInteger("nowSevere");//现有危重，没有累计
        Integer importedCase_cn = chinaTotal.getInteger("importedCase");//输入，没有现存
        Integer noInfect_cn = chinaTotal.getInteger("noInfect");//无症状


        Integer confirm_a_cn = chinaAdd.getInteger("confirm");//累计确诊增加
        Integer heal_a_cn = chinaAdd.getInteger("heal");
        Integer dead_a_cn = chinaAdd.getInteger("dead");
        Integer nowConfirm_a_cn = chinaAdd.getInteger("nowConfirm");//现存确诊增加
        Integer suspect_a_cn = chinaAdd.getInteger("suspect");
        Integer nowSevere_a_cn = chinaAdd.getInteger("nowSevere");
        Integer importedCase_a_cn = chinaAdd.getInteger("importedCase");
        Integer noInfect_a_cn = chinaAdd.getInteger("noInfect");

        Maindata data=new Maindata();
        if(year!=null){
            data.setYear(Integer.valueOf(year));
        }
        if(month!=null){
            data.setMonth(Integer.valueOf(month));
        }
        if(day!=null){
            data.setDay(Integer.valueOf(day));
        }
        data.setAreaId(86);
        data.setAreaName("中国");
        data.setNowConfirm(nowConfirm_cn);
        data.setNowConfirmAdd(nowConfirm_a_cn);
        data.setNoInfect(noInfect_cn);
        data.setNoInfectAdd(noInfect_a_cn);
        data.setSuspect(suspect_cn);
        data.setNoInfectAdd(suspect_a_cn);
        data.setNowSevere(nowSevere_cn);
        data.setNowSevereAdd(nowSevere_a_cn);
        data.setTotalConfirm(confirm_cn);
        data.setTotalConfirmAdd(confirm_a_cn);
        data.setImported(importedCase_cn);
        data.setImportedAdd(importedCase_a_cn);
        data.setHeal(heal_cn);
        data.setHealAdd(heal_a_cn);
        data.setDead(dead_cn);
        data.setDeadAdd(dead_a_cn);

//        mainDataDao.addRecord(data);
        return obj.getString("data");

//        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String,Object> jsonMap = objectMapper.readValue(response,new TypeReference<Map <String,Object >>(){});
//        //获取json数据，然后要把里面的内容拆出来
//        String res= StringEscapeUtils.unescapeJavaScript(jsonMap.get("data").toString());

    }

}
