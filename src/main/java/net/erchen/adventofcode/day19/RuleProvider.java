package net.erchen.adventofcode.day19;

import java.util.HashMap;

public class RuleProvider extends HashMap<RuleId, Rule> {

    public Rule getRule(RuleId id) {
        return super.get(id);
    }
}
