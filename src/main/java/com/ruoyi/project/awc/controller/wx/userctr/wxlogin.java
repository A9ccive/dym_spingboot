//package com.ruoyi.project.userInfo.controller;
//
////import net.sf.json.JSONObject;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.ruoyi.common.utils.http.HttpUtils;
//
//public class wxlogin {
//    /**
//     * 根据用户CODE换取OpenID
//     * code 小程序传来的code
//     * appid 当前小程序appid
//     * appsecret 小程序密钥
//     * 返回 openid和unid
//     */
//    public static JSONObject GetOpenid(String code, String appid, String appSecret) {
//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=authorization_code";
//        String fh = HttpUtils.sendGet(url, null);
//        JSONObject shuju= JSON.parseObject(fh);
////        String openid=shuju.getString("openid");
////        String unionid=shuju.getString("unionid");
//        return shuju;
//    }
//}
