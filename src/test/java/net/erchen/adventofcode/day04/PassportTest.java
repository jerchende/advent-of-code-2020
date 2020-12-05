package net.erchen.adventofcode.day04;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

class PassportTest {

    @Test
    void shouldParseSinglePassport() {
        var passport = Passport.parseSinglePassport("""
                ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
                byr:1937 iyr:2017 cid:147 hgt:183cm
                """);

        assertThat(passport.getBirthYear()).isEqualTo(Year.of(1937));
        assertThat(passport.getIssueYear()).isEqualTo(Year.of(2017));
        assertThat(passport.getExpirationYear()).isEqualTo(Year.of(2020));
        assertThat(passport.getHeight()).isEqualTo("183cm");
        assertThat(passport.getHairColor()).isEqualTo("#fffffd");
        assertThat(passport.getEyeColor()).isEqualTo("gry");
        assertThat(passport.getPassportId()).isEqualTo("860033327");
        assertThat(passport.getCountryId()).isEqualTo("147");
    }

    @Test
    void shouldParseMultiplePassport() {
        var passports = Passport.parsePassports("""                           
                ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
                byr:1937 iyr:2017 cid:147 hgt:183cm
                                
                iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
                hcl:#cfa07d byr:1929
                                
                hcl:#ae17e1 iyr:2013
                eyr:2024
                ecl:brn pid:760753108 byr:1931
                hgt:179cm
                                
                hcl:#cfa07d eyr:2025 pid:166559648
                iyr:2011 ecl:brn hgt:59in""");

        assertThat(passports).hasSize(4);
    }
}