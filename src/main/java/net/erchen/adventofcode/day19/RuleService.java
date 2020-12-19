package net.erchen.adventofcode.day19;

import lombok.Getter;

import java.util.List;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

@Getter
public class RuleService {

    private final RuleProvider ruleProvider = new RuleProvider();

    public void parseRules(List<String> input) {
        input.stream()
                .filter(line -> line.matches("[0-9]+:.*"))
                .forEach(line -> {
                    var idAndRule = line.split(":");
                    ruleProvider.put(new RuleId(parseInt(idAndRule[0])), parseRule(idAndRule[1].trim()));
                });
    }

    private Rule parseRule(String input) {
        if (input.matches("\".+\"")) {
            return new MatchingRule(input.charAt(1));
        }
        if (input.contains("|")) {
            var orRules = input.split("\\|");
            return new OrRule(parseRule(orRules[0]), parseRule(orRules[1]));
        }
        var ruleIds = Stream.of(input.trim().split(" ")).map(Integer::parseInt).map(RuleId::new).collect(toList());
        return new AndRule(ruleIds, ruleProvider);
    }

    public long validLines(List<String> input) {
        var ruleZero = ruleProvider.getRule(new RuleId(0));
        return input.stream()
                .filter(line -> !line.matches("[0-9]+:.*") && !line.isEmpty())
                .filter(line -> {
                    return ruleZero.isValid(line);
                })
                .count();
    }


}
