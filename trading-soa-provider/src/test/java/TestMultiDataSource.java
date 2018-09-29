import cn.aegisa.project.trading.model.UserBaseInfo;
import cn.aegisa.project.trading.vo.HnaOrderDO;
import cn.aegisa.selext.dao.service.ICommonService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018/6/21 14:11
 */
public class TestMultiDataSource extends BaseJunit4Test {

    @Autowired
    @Qualifier("hireportCommonService")
    private ICommonService hireportCommonService;

    @Test
    public void test01() {
        UserBaseInfo userBaseInfo = hireportCommonService.get(7L, UserBaseInfo.class);
        System.out.println(JSON.toJSONString(userBaseInfo));
    }

    @Test
    public void test02() {
        List<HnaOrderDO> hnaOrderList = hireportCommonService.getListBySqlId(UserBaseInfo.class, "selectHnaOrder",
                "startTime", "2018-06-20 00:00:00", "endTime", "2018-06-21 00:00:00");
        for (HnaOrderDO orderDO : hnaOrderList) {
            System.out.println(JSON.toJSONString(orderDO));
        }
    }
}
