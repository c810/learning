package pub.lhp.design.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description 规则树节点信息
 * @since 2024/10/15 16:54
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {

    private Long treeId; //规则树ID
    private Long treeNodeId; //规则树节点ID
    private Integer nodeType; //节点类型；1子叶、2果实
    private String nodeValue; //节点值[nodeType=2]；果实值
    private String ruleKey; //规则Key
    private String ruleDesc; //规则描述
    private List<TreeNodeLink> treeNodeLinkList; //节点链路

}
