package com.summer.springvuedemo.demo.utils;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R extends HashMap<String, Object> {

    public R() {
        put("code", 0);
        put("msg", "success");
    }
    //参数为空，创建HashMap新对象，并通过构造方法放入code、msg的默认值
    public static R ok() {
        return new R();
    }

    //参数为字符串，自动存放为msg键值对
    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }
    //参数为map，将map追加进R
    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }


    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
