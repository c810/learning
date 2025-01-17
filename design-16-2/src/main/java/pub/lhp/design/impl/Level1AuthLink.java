package pub.lhp.design.impl;

import pub.lhp.design.AuthInfo;
import pub.lhp.design.AuthLink;
import pub.lhp.design.AuthService;

import java.text.ParseException;
import java.util.Date;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description 一级负责人
 * @since 2024/10/16 10:46
 */
public class Level1AuthLink extends AuthLink {

    private Date beginDate = f.parse("2020-06-11 00:00:00");
    private Date endDate = f.parse("2020-06-20 23:59:59");

    public Level1AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待一级审批负责人 ", levelUserName);
        }
        AuthLink next = super.getNext();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：三级审批负责人完成", " 时间：", f.format(date), " 审批人：", levelUserName);
        }
        if (authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：三级审批负责人完成", " 时间：", f.format(date), " 审批人：", levelUserName);
        }
        return next.doAuth(uId, orderId, authDate);
    }

}
