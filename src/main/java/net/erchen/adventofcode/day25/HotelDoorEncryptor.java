package net.erchen.adventofcode.day25;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

import static java.lang.Math.floorDiv;

@Slf4j
public class HotelDoorEncryptor {

    static final int MAGIC_NUMBER = 20_201_227;
    static final int MAX_NUMBER = MAGIC_NUMBER * 7;

    private static int doTheMagic(int number, int subjectNumber) {
        return (int) (((long) number * subjectNumber) % MAGIC_NUMBER);
    }

    public static int publicKey(int loopSize) {
        return transformSubjectNumber(loopSize, 7);
    }

    public static int transformSubjectNumber(int loopSize, int subjectNumber) {
        int result = 1;
        for (int i = 0; i < loopSize; i++) {
            result = doTheMagic(result, subjectNumber);
        }
        return result;
    }

    public static int loopSize(int publicKey) {
        int loopSize = 0;
        while (true) {
            switch (publicKey) {
            case 7 -> {
                return loopSize + 1;
            }
            case 49 -> {
                return loopSize + 2;
            }
            case 343 -> {
                return loopSize + 3;
            }
            case 2_401 -> {
                return loopSize + 4;
            }
            case 16_807 -> {
                return loopSize + 5;
            }
            case 117_649 -> {
                return loopSize + 6;
            }
            case 823_543 -> {
                return loopSize + 7;
            }
            case 5_764_801 -> {
                return loopSize + 8;
            }
            default -> {
                loopSize++;
                int finalPublicKey = publicKey;
                publicKey = IntStream.range(0, 7)
                        .map(i -> i * MAGIC_NUMBER + finalPublicKey)
                        .filter(i -> i < MAX_NUMBER)
                        .filter(i -> i % 7 == 0)
                        .map(i -> floorDiv(i, 7))
                        .findAny()
                        .orElseThrow();
            }
            }
        }
    }
}
