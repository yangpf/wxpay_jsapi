package com.unstoppedable.service;

import com.unstoppedable.common.Configure;
import com.unstoppedable.common.HttpService;
import com.unstoppedable.common.JsonUtil;
import com.unstoppedable.common.XMLParser;
import com.unstoppedable.protocol.UnifiedOrderReqData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hupeng on 2015/7/28.
 */
public class WxPayApi {

    private static Log logger = LogFactory.getLog(WxPayApi.class);

    public static Map<String, Object> UnifiedOrder(UnifiedOrderReqData reqData) throws IOException, SAXException, ParserConfigurationException {
        String res = HttpService.doPost(Configure.UNIFIED_ORDER_API, reqData);
        logger.debug("UnifiedOrder get response:" + res);
        return XMLParser.getMapFromXML(res);
    }

    public static String getOpenid(String appid, String appSecret, String code) throws Exception {
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                + appid
                + "&secret="
                + appSecret
                + "&code=" + code + "&grant_type=authorization_code";
        String res = HttpService.doGet(requestUrl);
        System.out.println(res);
        Map<String, Object> resultMap = JsonUtil.fromJson(res, HashMap.class);
        if (resultMap.get("openid") == null) {
            return null;
        }

        return resultMap.get("openid").toString();
    }

    public static void main(String[] args) throws Exception {
        UnifiedOrderReqData reqData = new UnifiedOrderReqData.UnifiedOrderReqDataBuilder("appid", "mch_id",
                "body", "out_trade_no", 1, "spbill_create_ip", "notify_url", "JSAPI").setOpenid("openid").build();
        System.out.println(UnifiedOrder(reqData));


    }
}
