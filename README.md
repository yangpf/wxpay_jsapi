# wxpay_jsapi
Java实现JsApi方式的微信支付。进行JsApi支付，需要先通过https://api.mch.weixin.qq.com/pay/unifiedorder    获得一个prepay_id

```java
UnifiedOrderReqData reqData = new UnifiedOrderReqData.UnifiedOrderReqDataBuilder("appid", "mch_id",
                "body", "out_trade_no", 1, 
                "spbill_create_ip", "notify_url", "JSAPI")
                .setOpenid("openid").build();
Map<String, Object> resultMap = WxPayApi.UnifiedOrder(reqData);
```
return_code 和result_code都为SUCCESS的时候，可以得到我们需要的prepay_id，然后通过微信中内置的jsapi进行支付即可；

支付成功之后，微信会对指定的notify_url进行调用我们从request中获得传回来的xml之后，可以调用
```java
String responseXml = new PayNotifyTemplate(requestXml).execute(new PaySuccessCallBack() {
    @Override
    public void onSuccess(PayNotifyData payNotifyData) {
      //进行业务处理

      //如果处理失败，抛出异常
    }
});
```
然后把responseXml 写到response中。
