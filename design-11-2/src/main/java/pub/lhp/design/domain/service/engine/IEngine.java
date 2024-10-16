package pub.lhp.design.domain.service.engine;

import pub.lhp.design.domain.model.aggregates.TreeRich;
import pub.lhp.design.domain.model.vo.EngineResult;

import java.util.Map;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description
 * @since 2024/10/15 17:02
 */
public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}
