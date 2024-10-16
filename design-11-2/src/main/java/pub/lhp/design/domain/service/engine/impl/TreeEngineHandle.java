package pub.lhp.design.domain.service.engine.impl;

import pub.lhp.design.domain.model.aggregates.TreeRich;
import pub.lhp.design.domain.model.vo.EngineResult;
import pub.lhp.design.domain.model.vo.TreeNode;
import pub.lhp.design.domain.service.engine.EngineBase;

import java.util.Map;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description
 * @since 2024/10/15 17:04
 */
public class TreeEngineHandle extends EngineBase {

    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }

}
