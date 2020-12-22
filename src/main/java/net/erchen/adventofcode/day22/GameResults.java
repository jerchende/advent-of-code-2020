package net.erchen.adventofcode.day22;

import lombok.Builder;
import lombok.Data;

import java.util.Queue;

@Data
@Builder
public class GameResults {
    private final Player winner;
    private final Queue<Card> winningCards;

    public long getWinningPlayerScore() {
        long winningScore = 0L;
        int position = 0;
        final int cardCount = winningCards.size();

        for (Card winningCard : winningCards) {
            winningScore += winningCard.cardValue() * (cardCount - position++);
        }

        return winningScore;
    }
}
