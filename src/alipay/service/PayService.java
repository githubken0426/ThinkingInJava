package alipay.service;

import java.math.BigDecimal;
import java.util.Date;

import alipay.entity.Order;

public interface PayService {
	/**
     * 处理支付信息
     * @param billNo erp订单号
     * @param fee 总费用
     * @param outBillNo 外部订单号
     * @param payTime 支付时间
     * @param payType 支付类型 8微信 9支付宝
     * @param devType 设备类型 0 小程序 1App 2H5
     * @return
     */
    public boolean handlePayMsg(String billNo, BigDecimal fee, String outBillNo, Date payTime, int payType,
            int devType);

    /**
     * 根据支付单号查找订单编号
     * @param orderNo 支付单号
     * @return
     */
    public String getOrderNoByNewOrderNo(String orderNo);

    /**
     * 根据带时间戳支付单号查找系统的订单编号
     * @param orderNo 支付单号
     * @return 订单编号
     */
    public String getNewOrderNoByOrderNo(String orderNo);

    /**
     * 根据订单号生成带时间戳的支付单号
     * @param orderNo 订单号
     * @return 订单号+时间戳
     */
    public String createNewOrderNo(String orderNo);

    /**
     * 保存发起支付请求
     * @param newOrderNo 支付编号编号
     * @param order 订单
     * @param type 支付方式
     * @param source 端号
     * @return
     */
    public boolean savePayRequest(String newOrderNo, Order order, int type, int source);

    /**
     * 支付后更新支付请求信息(保存流水号)
     * @param newOrderNo 新订单编号
     * @param amount 支付金额
     * @param transactionCode 支付单号
     * @return
     */
   public boolean updatePayRequest(String newOrderNo, BigDecimal amount, String transactionCode);

}
