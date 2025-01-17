package pub.lhp.design.impl;

import pub.lhp.design.AuthInfo;
import pub.lhp.design.AuthLink;
import pub.lhp.design.AuthService;

import java.util.Date;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description 三级负责人
 * @since 2024/10/16 10:47
 */
public class Level3AuthLink extends AuthLink {

    public Level3AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待三级审批负责人 ", levelUserName);
        }
        AuthLink next = super.getNext();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：一级审批完成负责人", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }

}
