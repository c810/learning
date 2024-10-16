package pub.lhp.design.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description 决策结果
 * @since 2024/10/15 16:55
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EngineResult {

    private boolean isSuccess; //执行结果
    private String userId; //用户ID
    private Long treeId; //规则树ID
    private Long nodeId; //果实节点ID
    private String nodeValue; //果实节点值

    public EngineResult(String userId, Long treeId, Long treeNodeId, String nodeValue) {
        this.userId = userId;
        this.treeId = treeId;
        this.nodeId = treeNodeId;
        this.nodeValue = nodeValue;
    }
}
