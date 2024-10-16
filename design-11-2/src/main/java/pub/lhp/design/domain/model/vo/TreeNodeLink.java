package pub.lhp.design.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description 规则树线信息
 * @since 2024/10/15 16:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreeNodeLink {

    private Long nodeIdFrom; //节点From
    private Long nodeIdTo; //节点To
    private Integer ruleLimitType; //限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围]
    private String ruleLimitValue; //限定值
}
