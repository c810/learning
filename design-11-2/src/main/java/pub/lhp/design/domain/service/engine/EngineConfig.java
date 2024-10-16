package pub.lhp.design.domain.service.engine;

import pub.lhp.design.domain.service.logic.LogicFilter;
import pub.lhp.design.domain.service.logic.impl.UserAgeFilter;
import pub.lhp.design.domain.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lihaopeng
 * @version 1.0
 * @project learning
 * @description
 * @since 2024/10/15 17:03
 */
public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        this.logicFilterMap = logicFilterMap;
    }

}
