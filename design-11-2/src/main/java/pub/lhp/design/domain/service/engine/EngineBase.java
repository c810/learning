package pub.lhp.design.domain.service.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pub.lhp.design.domain.model.aggregates.TreeRich;
import pub.lhp.design.domain.model.vo.EngineResult;
import pub.lhp.design.domain.model.vo.TreeNode;
import pub.lhp.design.domain.model.vo.TreeRoot;
import pub.lhp.design.domain.service.logic.LogicFilter;

import java.util.Map;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description
 * @since 2024/10/15 17:03
 */
public abstract class EngineBase extends EngineConfig implements IEngine {

    private Logger logger = LoggerFactory.getLogger(EngineBase.class);

    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);

    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId, Map<String, String> decisionMatter) {
        TreeRoot treeRoot = treeRich.getTreeRoot();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        // 规则树根ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNodeInfo = treeNodeMap.get(rootNodeId);
        // 节点类型[NodeType]；1子叶、2果实
        while (treeNodeInfo.getNodeType().equals(1)) {
            String ruleKey = treeNodeInfo.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLinkList());
            treeNodeInfo = treeNodeMap.get(nextNode);
            logger.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), userId, treeId, treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }
        return treeNodeInfo;
    }

}
