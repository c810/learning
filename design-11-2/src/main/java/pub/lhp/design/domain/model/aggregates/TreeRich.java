package pub.lhp.design.domain.model.aggregates;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pub.lhp.design.domain.model.vo.TreeNode;
import pub.lhp.design.domain.model.vo.TreeRoot;

import java.util.Map;

/**
 * @project learning
 * @description  规则树聚合
 * @author lihaopeng
 * @since 2024/10/15 16:58
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreeRich {

    private TreeRoot treeRoot; //树根信息
    private Map<Long, TreeNode> treeNodeMap; //树节点ID -> 子节点

}
