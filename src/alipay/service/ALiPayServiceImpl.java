package alipay.service;

@Service
public class ALiPayServiceImpl implements ALiPayService{
	 private static Logger LOG = Logger.getLogger(ALiPayServiceImpl.class);
	    // 实例化客户端
	    private AlipayClient alipayClient = null;
	    @Autowired
	    private ALiPayProperties aliProperties;
	    @Autowired
	    private PayService payService;

	    @Override
	    public Result createAppOrder(String billNo, String subject, String body, BigDecimal totalAmount) {
	        // 实例化客户端
	        initClient();

	        // 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
	        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
	        //
	        // SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
	        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
	        model.setBody(body);
	        model.setSubject(subject);
	        model.setOutTradeNo(billNo);
	        model.setTimeoutExpress(aliProperties.getOverTime());
	        model.setTotalAmount(String.valueOf(totalAmount.setScale(2, RoundingMode.HALF_EVEN)));
	        model.setProductCode("QUICK_MSECURITY_PAY");
	        request.setBizModel(model);
	        request.setNotifyUrl(aliProperties.getNotifyUrl());
	        try {
	            // 这里和普通的接口调用不同，使用的是sdkExecute
	            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
	            return new Result(Constants.SUCCESS_CODE, "", response.getBody());
	            // 就是orderString 可以直接给客户端请求，无需再做处理。
	        } catch (AlipayApiException e) {
	            LOG.info(e.toString());
	            return new Result(Constants.FAILURE_CODE, ErrorMsg.UNKNOWN_EXCEPTION);
	        }
	    }

	    @Override
	    public Result orderQuery(String erpOrderId, String aliOrderId) {
	         initClient();
	        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();// 创建API对应的request类
	        request.setBizContent(
	                "{" + "\"out_trade_no\":\"" + payService.getNewOrderNoByOrderNo(erpOrderId) + "\"" + "  }");// 设置业务参数
	        try {
	            // 通过alipayClient调用API，获得对应的response类
	            AlipayTradeQueryResponse response = alipayClient.execute(request);
	            if (response.isSuccess()) {
	                return new Result(Constants.SUCCESS_CODE, "",
	                        AliPayOrderStatus.findNameByIndex(response.getTradeStatus()));
	            }
	        } catch (AlipayApiException e) {
	            e.printStackTrace();
	        }
	        return new Result(Constants.FAILURE_CODE, ErrorMsg.UNKNOWN_EXCEPTION);
	    }

	    @Override
	    public Result createH5Order(String billNo, String subject, String body, BigDecimal totalAmount) {
	        initClient();
	        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();// 创建API对应的request
	        alipayRequest.setReturnUrl("http://returnUrl.com/");
	        alipayRequest.setNotifyUrl(aliProperties.getNotifyUrl());// 在公共参数中设置回跳和通知地址
	        alipayRequest.setBizContent("{" + "    \"out_trade_no\":\"" + billNo + "\"," + "    \"total_amount\":"
	                + totalAmount.setScale(2, RoundingMode.HALF_EVEN) + "," + "    \"subject\":\"" + subject + "\","
	                + "    \"seller_id\":\"" + aliProperties.getPartner() + "\"," + "    \"product_code\":\"QUICK_WAP_WAY\""
	                + "  }");// 填充业务参数
	        try {
	            // 调用SDK生成表单
	            AlipayTradeWapPayResponse response = alipayClient.pageExecute(alipayRequest);
	            String form = response.getBody();
	            return new Result(Constants.SUCCESS_CODE, "", form);
	        } catch (AlipayApiException e) {
	            LOG.info(e.toString());
	            return new Result(Constants.FAILURE_CODE, ErrorMsg.UNKNOWN_EXCEPTION);
	        }

	    }

	    private void initClient() {
	        if (alipayClient == null) {
	            alipayClient = new DefaultAlipayClient(aliProperties.getaLiUrl(), aliProperties.getAppId(),
	                    aliProperties.getPrivateKey(), "json", "utf-8", aliProperties.getAliPublicKey(),
	                    aliProperties.getEncryptionMethod());
	        }
	    }

	    @Override
	    public String payNotify(Map<String, String> params) {
	        boolean isValidate = validatePayNotify(params);
	        if (!isValidate) {
	            return aliProperties.FAIL_CODE;
	        }
	        // 商户订单号
	        String out_trade_no = params.get("out_trade_no");
	        // 异步通知ID
	        BigDecimal fee = new BigDecimal(params.get("total_amount"));
	        try {
	            // 验证支付结果状态
	            if (params.get("trade_status").equals("TRADE_FINISHED")
	                    || params.get("trade_status").equals("TRADE_SUCCESS")) {

	                /* 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	                 * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	                 * 3、校验通知中的seller_id（或者seller_email)是否为out_trade_no这笔单据的对应的操作方（
	                 * 有的时候，一个商户可能有多个seller_id/seller_email）， 4、验证app_id是否为该商户本身。 */
	                // 实际业务处理
	                boolean isUpdate = payService.handlePayMsg(out_trade_no, fee, params.get("trade_no"),
	                        DateUtils.stringToDate(params.get("gmt_payment")), 7, 0);
	                if (isUpdate) {
	                    return aliProperties.SUCCESS_CODE;
	                }
	            }
	        } catch (Exception e) {
	            LOG.info("支付宝回调发生错误：" + e.toString());
	        }
	        return aliProperties.FAIL_CODE;
	    }

	    private boolean validatePayNotify(Map<String, String> params) {
	        // 使用支付宝公钥验签
	        try {
	            boolean isSignTrue = AlipaySignature.rsaCheckV1(params, aliProperties.getAliPublicKey(), "UTF-8", "RSA2");
	            if (!isSignTrue) {
	                return false;
	            }
	        } catch (AlipayApiException e1) {
	            LOG.info("支付宝公钥验签发生错误：" + e1.toString());
	            e1.printStackTrace();
	            return false;
	        }

	        String notify_id = params.get("notify_id");
	        // 验证
	        if (StringUtils.isEmpty(notify_id)) {
	            return false;
	        }
	        // 判断成功之后使用getResponse方法判断是否是支付宝发来的异步通知。
	        if (!verifyResponse(notify_id).equals("true")) {
	            // 验证是否来自支付宝的通知失败
	            return false;
	        }
	        if (!params.get("app_id").equals(aliProperties.getAppId())) {
	            return false;
	        }
	        return true;
	    }

	    /**
	     * 获取远程服务器ATN结果,验证返回URL
	     * @param notify_id 通知校验ID
	     * @return 服务器ATN结果 验证结果集： invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 true
	     *         返回正确信息 false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	     */
	    public String verifyResponse(String notify_id) {
	        // 获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求

	        String partner = aliProperties.getPartner();
	        String veryfy_url = aliProperties.HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;

	        return checkUrl(veryfy_url);
	    }

	    /**
	     * 获取远程服务器ATN结果
	     * @param urlvalue 指定URL路径地址
	     * @return 服务器ATN结果 验证结果集： invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 true
	     *         返回正确信息 false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	     */
	    public static String checkUrl(String urlvalue) {
	        String inputLine = "";

	        try {
	            URL url = new URL(urlvalue);
	            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	            inputLine = in.readLine().toString();
	        } catch (Exception e) {
	            LOG.info("检查通知时发生错误：" + e.toString());
	            inputLine = "";
	        }

	        return inputLine;
	    }
}
