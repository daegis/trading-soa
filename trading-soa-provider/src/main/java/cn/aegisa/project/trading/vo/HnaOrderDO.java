package cn.aegisa.project.trading.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018/6/21 16:56
 */
@Data
public class HnaOrderDO {
    private String orderNo;
    private String productName;
    private String totalPrice;
    private String paidPrice;
    private LocalDateTime orderTime;
    private String orderType;
    private String mobile;
    private String userId;
    private String employeeStatus;
}
