package alipay;

@Configuration
@PropertySource("classpath:pay.properties")
public class ALiPayProperties {
	 /**
     * 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/
     * pidAndKey.htm
     */
    @Value("${ALiPay.partner}")
    private String partner;
    // 回调地址
    @Value("${ALiPay.notifyUrl}")
    private String notifyUrl;
    // 支付宝公钥
    @Value("${ALiPay.publicKey}")
    private String publicKey;
    // 支付宝私钥
    @Value("${ALiPay.privateKey}")
    private String privateKey;
    @Value("${AliPay.aliPublicKey}")
    private String aliPublicKey;
    // 支付宝appId
    @Value("${ALiPay.appId}")
    private String appId;
    // 加密方式
    private String encryptionMethod = "RSA2";
    // 超时时间
    private String overTime = "30m";
    // 支付宝网关
    private String aLiUrl = "https://openapi.alipay.com/gateway.do";
    // private String aLiUrl = " https://openapi.alipaydev.com/gateway.do";

    /**
     * 支付宝消息验证地址
     */
    public final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

    /**
     * 失败返回
     */
    public final String FAIL_CODE = "fail";

    /**
     * 成功返回
     */
    public final String SUCCESS_CODE = "success";

    /**
     * @return the notifyUrl
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    public String getAliPublicKey() {
        return aliPublicKey;
    }

    public void setAliPublicKey(String aliPublicKey) {
        this.aliPublicKey = aliPublicKey;
    }

    /**
     * @param notifyUrl the notifyUrl to set
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    /**
     * @return the publicKey
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * @param publicKey the publicKey to set
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    /**
     * @return the privateKey
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * @param privateKey the privateKey to set
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * @return the appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId the appId to set
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return the encryptionMethod
     */
    public String getEncryptionMethod() {
        return encryptionMethod;
    }

    /**
     * @param encryptionMethod the encryptionMethod to set
     */
    public void setEncryptionMethod(String encryptionMethod) {
        this.encryptionMethod = encryptionMethod;
    }

    /**
     * @return the overTime
     */
    public String getOverTime() {
        return overTime;
    }

    /**
     * @param overTime the overTime to set
     */
    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    /**
     * @return the aLiUrl
     */
    public String getaLiUrl() {
        return aLiUrl;
    }

    /**
     * @param aLiUrl the aLiUrl to set
     */
    public void setaLiUrl(String aLiUrl) {
        this.aLiUrl = aLiUrl;
    }

}
