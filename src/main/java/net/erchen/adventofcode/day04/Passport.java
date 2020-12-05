package net.erchen.adventofcode.day04;

import lombok.Builder;
import lombok.Data;
import net.erchen.adventofcode.day04.validation.ValidHeight;
import net.erchen.adventofcode.day04.validation.ValidYear;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Data
@Builder
public class Passport {


    @ValidYear(minYear = 1920, maxYear = 2002, groups = Part2ValidationGroup.class)
    @NotEmpty(groups = {Part1ValidationGroup.class, Part2ValidationGroup.class})
    private final String birthYear;

    @ValidYear(minYear = 2010, maxYear = 2020, groups = Part2ValidationGroup.class)
    @NotEmpty(groups = {Part1ValidationGroup.class, Part2ValidationGroup.class})
    private final String issueYear;

    @ValidYear(minYear = 2020, maxYear = 2030, groups = Part2ValidationGroup.class)
    @NotEmpty(groups = {Part1ValidationGroup.class, Part2ValidationGroup.class})
    private final String expirationYear;

    @ValidHeight(groups = Part2ValidationGroup.class)
    @NotEmpty(groups = {Part1ValidationGroup.class, Part2ValidationGroup.class})
    private final String height;

    @Pattern(regexp = "#[0-9a-f]{6}", groups = Part2ValidationGroup.class)
    @NotEmpty(groups = {Part1ValidationGroup.class, Part2ValidationGroup.class})
    private final String hairColor;

    @Pattern(regexp = "(amb|blu|brn|gry|grn|hzl|oth)", groups = Part2ValidationGroup.class)
    @NotEmpty(groups = {Part1ValidationGroup.class, Part2ValidationGroup.class})
    private final String eyeColor;

    @Pattern(regexp = "[0-9]{9}", groups = Part2ValidationGroup.class)
    @NotEmpty(groups = {Part1ValidationGroup.class, Part2ValidationGroup.class})
    private final String passportId;

    private final String countryId;

    public static List<Passport> parsePassports(String scannerOutput) {
        return Stream.of(scannerOutput.split("\n\n"))
                .map(Passport::parseSinglePassport)
                .collect(toList());
    }

    static Passport parseSinglePassport(String scannerPassportLine) {
        var entries = readValuesAsMap(new StringTokenizer(normalizeInput(scannerPassportLine), " "));

        return Passport.builder()
                .birthYear(entries.get("byr"))
                .issueYear(entries.get("iyr"))
                .expirationYear(entries.get("eyr"))
                .height(entries.get("hgt"))
                .hairColor(entries.get("hcl"))
                .eyeColor(entries.get("ecl"))
                .passportId(entries.get("pid"))
                .countryId(entries.get("cid"))
                .build();
    }

    private static String normalizeInput(String scannerOutput) {
        return scannerOutput.replaceAll("\\s+", " ");
    }

    private static Map<String, String> readValuesAsMap(StringTokenizer input) {
        return Collections.list(input).stream()
                .map(entry -> ((String) entry).split(":"))
                .collect(toMap(part -> part[0], part -> part[1]));
    }
}
