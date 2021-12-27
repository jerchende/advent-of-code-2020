package net.erchen.adventofcode.day25;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HotelDoorEncryptorTest {

    @Test
    void shouldEncodePublicKey() {
        assertThat(HotelDoorEncryptor.publicKey(11)).isEqualTo(17807724);
        assertThat(HotelDoorEncryptor.publicKey(8)).isEqualTo(5764801);

        assertThat(HotelDoorEncryptor.publicKey(597630)).isEqualTo(14012298);
        assertThat(HotelDoorEncryptor.publicKey(5888191)).isEqualTo(74241);
    }

    @Test
    void shouldFindLoopSize() {
        assertThat(HotelDoorEncryptor.loopSize(5764801)).isEqualTo(8);
        assertThat(HotelDoorEncryptor.loopSize(17807724)).isEqualTo(11);

        assertThat(HotelDoorEncryptor.loopSize(14012298)).isEqualTo(597630);
        assertThat(HotelDoorEncryptor.loopSize(74241)).isEqualTo(5888191);
    }

    @Test
    void shouldEncodeEncryptionKey() {
        assertThat(HotelDoorEncryptor.transformSubjectNumber(8, 17807724)).isEqualTo(14897079);
        assertThat(HotelDoorEncryptor.transformSubjectNumber(11, 5764801)).isEqualTo(14897079);

        assertThat(HotelDoorEncryptor.transformSubjectNumber(5888191, 14012298)).isEqualTo(18608573);
        assertThat(HotelDoorEncryptor.transformSubjectNumber(597630, 74241)).isEqualTo(18608573);
    }

}