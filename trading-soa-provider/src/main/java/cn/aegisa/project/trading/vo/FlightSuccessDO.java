package cn.aegisa.project.trading.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018/6/21 10:54
 */
@Data
public class FlightSuccessDO implements Serializable {
    private String orderNo;
    private LocalDateTime createTime;
    private LocalDateTime payTime;
    private String departCityName;
    private String arrCityName;
    private String code;
    private String carrierName;
    private String peopleCount;
    private String totalPrice;
    private String departDate;
}
