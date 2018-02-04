package alipay;

@Controller
@RequestMapping("/alipay")
public class ALiPayController {

    private static Logger LOG = Logger.getLogger(ALiPayController.class);
    @Autowired
    private ALiPayService aLiPayService;
    @Autowired
    //订单核心业务
    private ShortRentOrderService ShortRentOrderService;
    @Autowired
    private PayService payService;

    /**
     * createOrder app统一下单
     * @param billNo String 订单编号
     * @return
     */
    @RequestMapping("/app/createOrder")
    public @ResponseBody Result createAppOrder(String tradeNo, HttpServletResponse response) {
        // 获取订单详情
        ShortRentOrderDto dto = ShortRentOrderService.getShortRentOrderDetail(tradeNo);
        // 生成带时间戳的订单号，否则无法重复调起支付。
        String newbillNo = payService.createNewOrderNo(tradeNo);
        // 保存请求参数，回调时根据带时间戳的订单号获取到相应的真实订单号
        payService.savePayRequest(newbillNo, dto, PayTypeEnums.ALIPAY.getIndex(), SourceTypeEnums.ANDROID.getIndex());
        // 向支付宝发送请求
        Result result = aLiPayService.createAppOrder(newbillNo, dto.getModelName(), dto.getModelName(),
                dto.getOrderTotalPrice());
        if (result.getCode() == Constants.FAILURE_CODE) {
            return result;
        }
        return new Result(Constants.SUCCESS_CODE, "", result.getData());
    }

    /**
     * createOrder h5统一下单
     * @param billNo String 订单编号
     * @return
     */
    @RequestMapping("/h5/createOrder")
    public @ResponseBody Result createH5Order(String tradeNo, HttpServletResponse response) {
        // 获取订单详情
        ShortRentOrderDto dto = ShortRentOrderService.getShortRentOrderDetail(tradeNo);
        // 生成带时间戳的订单号，否则无法重复调起支付
        String newbillNo = payService.createNewOrderNo(tradeNo);
        // 保存请求参数
        payService.savePayRequest(newbillNo, dto, PayTypeEnums.ALIPAY.getIndex(), SourceTypeEnums.H5.getIndex());
        // 向支付宝发送请求
        Result result = aLiPayService.createH5Order(newbillNo, dto.getModelName(), dto.getModelName(),
                dto.getOrderTotalPrice());
        if (result.getCode() == Constants.FAILURE_CODE) {
            return result;
        }
        return new Result(Constants.SUCCESS_CODE, "", result.getData());
    }

    @RequestMapping("/orderQuery")
    public Result orderQuery(String erpOrderId, String aliOrderId) {
        // 向支付宝发送查询请求
        return aLiPayService.orderQuery(erpOrderId, aliOrderId);
    }

    @RequestMapping(value = "/notify-url", method = { RequestMethod.POST })
    public @ResponseBody String notifyUrl(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> params = HttpUtils.getRequestParamMap(request);
        // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)
        return aLiPayService.payNotify(params);
    }
}
