package pub.lhp.design.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description 树根
 * @since 2024/10/15 16:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreeRoot {

    private Long treeId; //规则树ID
    private Long treeRootNodeId; //规则树根ID
    private String treeName; //规则树名称

}
