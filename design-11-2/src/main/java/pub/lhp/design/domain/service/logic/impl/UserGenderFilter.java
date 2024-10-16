package pub.lhp.design.domain.service.logic.impl;

import pub.lhp.design.domain.service.logic.BaseLogic;

import java.util.Map;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description
 * @since 2024/10/15 17:02
 */
public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }

}
