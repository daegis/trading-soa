package cn.aegisa.project.trading.model;

import java.io.Serializable;


/**
 * OrderMain Entity.
 */
public class OrderMain implements Serializable{
	
	//列信息
	private Long orderId;
	
	private String orderNo;
	
	private Short orderCategory;
	
	private String originalOrderNo;
	
	private String thirdOrderNo;
	
	private String thirdTradeNo;
	
	private String orderType;
	
	private String orderSource;
	
	private String orderPlatform;
	
	private String channelCode;
	
	private Short delFlag;
	
	private Long userId;
	
	private String userName;
	
	private Integer orderStatus;
	
	private String thridOrderStatus;
	
	private String showStatusName;
	
	private Integer payStatus;
	
	private String payTypeCode;
	
	private String payPlatform;
	
	private String payPlatformChannel;
	
	private Double payChannelFee;
	
	private String deviceType;
	
	private java.util.Date payTime;
	
	private java.util.Date orderTime;
	
	private java.util.Date createTime;
	
	private java.util.Date lastModityTime;
	
	private String userRemark;
	
	private Double originalTotalPrice;
	
	private Double totalPrice;
	
	private Double needPayPrice;
	
	private Double paidPrice;
	
	private Double activePrice;
	
	private Double couponPrice;
	
	private Double integralPrice;
	
	private Integer integralCount;
	
	private Long cardPrice;
	
	private Double otherPrice;
	
	private Double totalCost;
	
	private Double invoiceMailMoney;
	
	private Integer exceptionStatus;
	
	private Integer refundStatus;
	
	private String refundReason;
	
	private Integer supplierStatus;
	
	private String sign;
	
	private String productName;
	
	private Long productId;
	
	private Short airLineType;
	
	private Short tripType;
	
	private String arrCity;
	
	private String arrCityName;
	
	private String departCity;
	
	private String departCityName;
	
	private String departAddr;
	
	private String arrAddr;
	
	private String departDate;
	
	private String arrTime;
	
	private String code;
	
	private String terminal;
	
	private String orderSecondType;
	
	private String deviceId;
	
	private Integer commentStatus;
	
	private Short integralStatus;
	
	private Integer integralReturnCount;
	
	private String cardNo;
	
	private java.util.Date deliveryTime;
	
	private java.util.Date receiveTime;
	
	private String ip;
	
	private Double fee;
	
	private String rightOrderNo;
	
	private String customerSessionId;
	
	private String refDocumentId;
	

		
	public void setOrderId(Long value) {
		this.orderId = value;
	}
	
	public Long getOrderId() {
		return this.orderId;
	}
		
		
	public void setOrderNo(String value) {
		this.orderNo = value;
	}
	
	public String getOrderNo() {
		return this.orderNo;
	}
		
		
	public void setOrderCategory(Short value) {
		this.orderCategory = value;
	}
	
	public Short getOrderCategory() {
		return this.orderCategory;
	}
		
		
	public void setOriginalOrderNo(String value) {
		this.originalOrderNo = value;
	}
	
	public String getOriginalOrderNo() {
		return this.originalOrderNo;
	}
		
		
	public void setThirdOrderNo(String value) {
		this.thirdOrderNo = value;
	}
	
	public String getThirdOrderNo() {
		return this.thirdOrderNo;
	}
		
		
	public void setThirdTradeNo(String value) {
		this.thirdTradeNo = value;
	}
	
	public String getThirdTradeNo() {
		return this.thirdTradeNo;
	}
		
		
	public void setOrderType(String value) {
		this.orderType = value;
	}
	
	public String getOrderType() {
		return this.orderType;
	}
		
		
	public void setOrderSource(String value) {
		this.orderSource = value;
	}
	
	public String getOrderSource() {
		return this.orderSource;
	}
		
		
	public void setOrderPlatform(String value) {
		this.orderPlatform = value;
	}
	
	public String getOrderPlatform() {
		return this.orderPlatform;
	}
		
		
	public void setChannelCode(String value) {
		this.channelCode = value;
	}
	
	public String getChannelCode() {
		return this.channelCode;
	}
		
		
	public void setDelFlag(Short value) {
		this.delFlag = value;
	}
	
	public Short getDelFlag() {
		return this.delFlag;
	}
		
		
	public void setUserId(Long value) {
		this.userId = value;
	}
	
	public Long getUserId() {
		return this.userId;
	}
		
		
	public void setUserName(String value) {
		this.userName = value;
	}
	
	public String getUserName() {
		return this.userName;
	}
		
		
	public void setOrderStatus(Integer value) {
		this.orderStatus = value;
	}
	
	public Integer getOrderStatus() {
		return this.orderStatus;
	}
		
		
	public void setThridOrderStatus(String value) {
		this.thridOrderStatus = value;
	}
	
	public String getThridOrderStatus() {
		return this.thridOrderStatus;
	}
		
		
	public void setShowStatusName(String value) {
		this.showStatusName = value;
	}
	
	public String getShowStatusName() {
		return this.showStatusName;
	}
		
		
	public void setPayStatus(Integer value) {
		this.payStatus = value;
	}
	
	public Integer getPayStatus() {
		return this.payStatus;
	}
		
		
	public void setPayTypeCode(String value) {
		this.payTypeCode = value;
	}
	
	public String getPayTypeCode() {
		return this.payTypeCode;
	}
		
		
	public void setPayPlatform(String value) {
		this.payPlatform = value;
	}
	
	public String getPayPlatform() {
		return this.payPlatform;
	}
		
		
	public void setPayPlatformChannel(String value) {
		this.payPlatformChannel = value;
	}
	
	public String getPayPlatformChannel() {
		return this.payPlatformChannel;
	}
		
		
	public void setPayChannelFee(Double value) {
		this.payChannelFee = value;
	}
	
	public Double getPayChannelFee() {
		return this.payChannelFee;
	}
		
		
	public void setDeviceType(String value) {
		this.deviceType = value;
	}
	
	public String getDeviceType() {
		return this.deviceType;
	}
		
		
	public void setPayTime(java.util.Date value) {
		this.payTime = value;
	}
	
	public java.util.Date getPayTime() {
		return this.payTime;
	}
		
		
	public void setOrderTime(java.util.Date value) {
		this.orderTime = value;
	}
	
	public java.util.Date getOrderTime() {
		return this.orderTime;
	}
		
		
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
		
		
	public void setLastModityTime(java.util.Date value) {
		this.lastModityTime = value;
	}
	
	public java.util.Date getLastModityTime() {
		return this.lastModityTime;
	}
		
		
	public void setUserRemark(String value) {
		this.userRemark = value;
	}
	
	public String getUserRemark() {
		return this.userRemark;
	}
		
		
	public void setOriginalTotalPrice(Double value) {
		this.originalTotalPrice = value;
	}
	
	public Double getOriginalTotalPrice() {
		return this.originalTotalPrice;
	}
		
		
	public void setTotalPrice(Double value) {
		this.totalPrice = value;
	}
	
	public Double getTotalPrice() {
		return this.totalPrice;
	}
		
		
	public void setNeedPayPrice(Double value) {
		this.needPayPrice = value;
	}
	
	public Double getNeedPayPrice() {
		return this.needPayPrice;
	}
		
		
	public void setPaidPrice(Double value) {
		this.paidPrice = value;
	}
	
	public Double getPaidPrice() {
		return this.paidPrice;
	}
		
		
	public void setActivePrice(Double value) {
		this.activePrice = value;
	}
	
	public Double getActivePrice() {
		return this.activePrice;
	}
		
		
	public void setCouponPrice(Double value) {
		this.couponPrice = value;
	}
	
	public Double getCouponPrice() {
		return this.couponPrice;
	}
		
		
	public void setIntegralPrice(Double value) {
		this.integralPrice = value;
	}
	
	public Double getIntegralPrice() {
		return this.integralPrice;
	}
		
		
	public void setIntegralCount(Integer value) {
		this.integralCount = value;
	}
	
	public Integer getIntegralCount() {
		return this.integralCount;
	}
		
		
	public void setCardPrice(Long value) {
		this.cardPrice = value;
	}
	
	public Long getCardPrice() {
		return this.cardPrice;
	}
		
		
	public void setOtherPrice(Double value) {
		this.otherPrice = value;
	}
	
	public Double getOtherPrice() {
		return this.otherPrice;
	}
		
		
	public void setTotalCost(Double value) {
		this.totalCost = value;
	}
	
	public Double getTotalCost() {
		return this.totalCost;
	}
		
		
	public void setInvoiceMailMoney(Double value) {
		this.invoiceMailMoney = value;
	}
	
	public Double getInvoiceMailMoney() {
		return this.invoiceMailMoney;
	}
		
		
	public void setExceptionStatus(Integer value) {
		this.exceptionStatus = value;
	}
	
	public Integer getExceptionStatus() {
		return this.exceptionStatus;
	}
		
		
	public void setRefundStatus(Integer value) {
		this.refundStatus = value;
	}
	
	public Integer getRefundStatus() {
		return this.refundStatus;
	}
		
		
	public void setRefundReason(String value) {
		this.refundReason = value;
	}
	
	public String getRefundReason() {
		return this.refundReason;
	}
		
		
	public void setSupplierStatus(Integer value) {
		this.supplierStatus = value;
	}
	
	public Integer getSupplierStatus() {
		return this.supplierStatus;
	}
		
		
	public void setSign(String value) {
		this.sign = value;
	}
	
	public String getSign() {
		return this.sign;
	}
		
		
	public void setProductName(String value) {
		this.productName = value;
	}
	
	public String getProductName() {
		return this.productName;
	}
		
		
	public void setProductId(Long value) {
		this.productId = value;
	}
	
	public Long getProductId() {
		return this.productId;
	}
		
		
	public void setAirLineType(Short value) {
		this.airLineType = value;
	}
	
	public Short getAirLineType() {
		return this.airLineType;
	}
		
		
	public void setTripType(Short value) {
		this.tripType = value;
	}
	
	public Short getTripType() {
		return this.tripType;
	}
		
		
	public void setArrCity(String value) {
		this.arrCity = value;
	}
	
	public String getArrCity() {
		return this.arrCity;
	}
		
		
	public void setArrCityName(String value) {
		this.arrCityName = value;
	}
	
	public String getArrCityName() {
		return this.arrCityName;
	}
		
		
	public void setDepartCity(String value) {
		this.departCity = value;
	}
	
	public String getDepartCity() {
		return this.departCity;
	}
		
		
	public void setDepartCityName(String value) {
		this.departCityName = value;
	}
	
	public String getDepartCityName() {
		return this.departCityName;
	}
		
		
	public void setDepartAddr(String value) {
		this.departAddr = value;
	}
	
	public String getDepartAddr() {
		return this.departAddr;
	}
		
		
	public void setArrAddr(String value) {
		this.arrAddr = value;
	}
	
	public String getArrAddr() {
		return this.arrAddr;
	}
		
		
	public void setDepartDate(String value) {
		this.departDate = value;
	}
	
	public String getDepartDate() {
		return this.departDate;
	}
		
		
	public void setArrTime(String value) {
		this.arrTime = value;
	}
	
	public String getArrTime() {
		return this.arrTime;
	}
		
		
	public void setCode(String value) {
		this.code = value;
	}
	
	public String getCode() {
		return this.code;
	}
		
		
	public void setTerminal(String value) {
		this.terminal = value;
	}
	
	public String getTerminal() {
		return this.terminal;
	}
		
		
	public void setOrderSecondType(String value) {
		this.orderSecondType = value;
	}
	
	public String getOrderSecondType() {
		return this.orderSecondType;
	}
		
		
	public void setDeviceId(String value) {
		this.deviceId = value;
	}
	
	public String getDeviceId() {
		return this.deviceId;
	}
		
		
	public void setCommentStatus(Integer value) {
		this.commentStatus = value;
	}
	
	public Integer getCommentStatus() {
		return this.commentStatus;
	}
		
		
	public void setIntegralStatus(Short value) {
		this.integralStatus = value;
	}
	
	public Short getIntegralStatus() {
		return this.integralStatus;
	}
		
		
	public void setIntegralReturnCount(Integer value) {
		this.integralReturnCount = value;
	}
	
	public Integer getIntegralReturnCount() {
		return this.integralReturnCount;
	}
		
		
	public void setCardNo(String value) {
		this.cardNo = value;
	}
	
	public String getCardNo() {
		return this.cardNo;
	}
		
		
	public void setDeliveryTime(java.util.Date value) {
		this.deliveryTime = value;
	}
	
	public java.util.Date getDeliveryTime() {
		return this.deliveryTime;
	}
		
		
	public void setReceiveTime(java.util.Date value) {
		this.receiveTime = value;
	}
	
	public java.util.Date getReceiveTime() {
		return this.receiveTime;
	}
		
		
	public void setIp(String value) {
		this.ip = value;
	}
	
	public String getIp() {
		return this.ip;
	}
		
		
	public void setFee(Double value) {
		this.fee = value;
	}
	
	public Double getFee() {
		return this.fee;
	}
		
		
	public void setRightOrderNo(String value) {
		this.rightOrderNo = value;
	}
	
	public String getRightOrderNo() {
		return this.rightOrderNo;
	}
		
		
	public void setCustomerSessionId(String value) {
		this.customerSessionId = value;
	}
	
	public String getCustomerSessionId() {
		return this.customerSessionId;
	}
		
		
	public void setRefDocumentId(String value) {
		this.refDocumentId = value;
	}
	
	public String getRefDocumentId() {
		return this.refDocumentId;
	}
		
}

