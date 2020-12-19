package net.erchen.adventofcode.day19;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MatchingRule implements Rule {

    private final char matchingChar;

    @Override
    public String consume(String data) throws NotValidException {
        if (data.length() < 1 || data.charAt(0) != matchingChar) {
            throw new NotValidException();
        }
        return data.substring(1);
    }
}
