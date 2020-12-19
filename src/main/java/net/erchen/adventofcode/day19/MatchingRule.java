package net.erchen.adventofcode.day19;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class MatchingRule implements Rule {

    private final char matchingChar;

    @Override
    public List<String> consume(String data) throws InvalidException {
        if (data.length() < 1 || data.charAt(0) != matchingChar) {
            throw new InvalidException();
        }
        return List.of(data.substring(1));
    }
}
