package pub.lhp.design;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description 模拟审核服务
 * @since 2024/10/16 10:51
 */
public class AuthService {

    private static Map<String, Date> authMap = new ConcurrentHashMap<String, Date>();

    /**
     * 查询审核信息（时间）
     * @param uId
     * @param orderId
     * @return
     */
    public static Date queryAuthInfo(String uId, String orderId) {
        return authMap.get(uId.concat(orderId));
    }

    /**
     * 进行审核，并记录审核信息
     *
     * @param uId
     * @param orderId
     */
    public static void auth(String uId, String orderId) {
        authMap.put(uId.concat(orderId), new Date());
    }

}
