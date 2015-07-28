package com.unstoppedable.protocol;



import com.unstoppedable.common.Configure;
import com.unstoppedable.common.HttpService;
import com.unstoppedable.common.RandomStringGenerator;
import com.unstoppedable.common.Signature;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class UnifiedOrderReqData {

    private String appid;
    private String mch_id;
    private String device_info;
    private String nonce_str;
    private String sign;
    private String body;
    private String detail;
    private String attach;
    private String out_trade_no;
    private String fee_type;
    private int total_fee;
    private String spbill_create_ip;
    private String time_start;
    private String time_expire;
    private String goods_tag;
    private String notify_url;
    private String trade_type;
    private String product_id;
    private String limit_pay;
    private String openid;

    private UnifiedOrderReqData(UnifiedOrderReqDataBuilder builder) {
        this.appid = builder.appid;
        this.mch_id = builder.mch_id;
        this.device_info = builder.device_info;
        this.nonce_str = RandomStringGenerator.getRandomStringByLength(32);
        this.body = builder.body;
        this.detail = builder.detail;
        this.attach = builder.attach;
        this.out_trade_no = builder.out_trade_no;
        this.fee_type = builder.fee_type;
        this.total_fee = builder.total_fee;
        this.spbill_create_ip = builder.spbill_create_ip;
        this.time_start = builder.time_start;
        this.time_expire = builder.time_expire;
        this.goods_tag = builder.goods_tag;
        this.notify_url = builder.notify_url;
        this.trade_type = builder.trade_type;
        this.product_id = builder.product_id;
        this.limit_pay = builder.limit_pay;
        this.openid = builder.openid;
        this.sign = Signature.getSign(toMap());
    }


    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if (obj != null) {
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }


    public static class UnifiedOrderReqDataBuilder {
        private String appid;
        private String mch_id;
        private String device_info;
        private String body;
        private String detail;
        private String attach;
        private String out_trade_no;
        private String fee_type;
        private int total_fee;
        private String spbill_create_ip;
        private String time_start;
        private String time_expire;
        private String goods_tag;
        private String notify_url;
        private String trade_type;
        private String product_id;
        private String limit_pay;
        private String openid;

        public UnifiedOrderReqDataBuilder(String appid, String mch_id, String body, String out_trade_no, Integer total_fee,
                                          String spbill_create_ip, String notify_url, String trade_type) {
            if (appid == null) {
                throw new IllegalArgumentException("传入参数appid不能为null");
            }
            if (mch_id == null) {
                throw new IllegalArgumentException("传入参数mch_id不能为null");
            }
            if (body == null) {
                throw new IllegalArgumentException("传入参数body不能为null");
            }
            if (out_trade_no == null) {
                throw new IllegalArgumentException("传入参数out_trade_no不能为null");
            }
            if (total_fee == null) {
                throw new IllegalArgumentException("传入参数total_fee不能为null");
            }
            if (spbill_create_ip == null) {
                throw new IllegalArgumentException("传入参数spbill_create_ip不能为null");
            }
            if (notify_url == null) {
                throw new IllegalArgumentException("传入参数notify_url不能为null");
            }
            if (trade_type == null) {
                throw new IllegalArgumentException("传入参数trade_type不能为null");
            }
            this.appid = appid;
            this.mch_id = mch_id;
            this.body = body;
            this.out_trade_no = out_trade_no;
            this.total_fee = total_fee;
            this.spbill_create_ip = spbill_create_ip;
            this.notify_url = notify_url;
            this.trade_type = trade_type;
        }

        public UnifiedOrderReqDataBuilder setDevice_info(String device_info) {
            this.device_info = device_info;
            return this;
        }

        public UnifiedOrderReqDataBuilder setDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public UnifiedOrderReqDataBuilder setAttach(String attach) {
            this.attach = attach;
            return this;
        }

        public UnifiedOrderReqDataBuilder setFee_type(String fee_type) {
            this.fee_type = fee_type;
            return this;
        }

        public UnifiedOrderReqDataBuilder setTime_start(String time_start) {
            this.time_start = time_start;
            return this;
        }

        public UnifiedOrderReqDataBuilder setTime_expire(String time_expire) {
            this.time_expire = time_expire;
            return this;
        }

        public UnifiedOrderReqDataBuilder setGoods_tag(String goods_tag) {
            this.goods_tag = goods_tag;
            return this;
        }

        public UnifiedOrderReqDataBuilder setProduct_id(String product_id) {
            this.product_id = product_id;
            return this;
        }

        public UnifiedOrderReqDataBuilder setLimit_pay(String limit_pay) {
            this.limit_pay = limit_pay;
            return this;
        }

        public UnifiedOrderReqDataBuilder setOpenid(String openid) {
            this.openid = openid;
            return this;
        }


        public UnifiedOrderReqData build() {

            if("JSAPI".equals(this.trade_type) && this.openid == null) {
                throw new IllegalArgumentException("当传入trade_type为JSAPI时，openid为必填参数");
            }
            if("NATIVE".equals(this.trade_type) && this.product_id == null) {
                throw new IllegalArgumentException("当传入trade_type为NATIVE时，product_id为必填参数");
            }
            return new UnifiedOrderReqData(this);
        }
    }



}
