package net.erchen.adventofcode.day22;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;
import static net.erchen.adventofcode.day22.Player.Player1;
import static net.erchen.adventofcode.day22.Player.Player2;

@Getter
public class Combat {

    private final Queue<Card> player1 = new LinkedList<>();
    private final Queue<Card> player2 = new LinkedList<>();


    public static Combat fromInput(List<String> input) {
        var combat = new Combat();

        Queue<Card> currentPlayer = combat.player1;
        for (String line : input) {
            switch (line) {
                case "Player 1:" -> currentPlayer = combat.player1;
                case "Player 2:" -> currentPlayer = combat.player2;
                case "" -> {
                }
                default -> currentPlayer.add(Card.fromString(line));
            }
        }
        return combat;
    }

    public GameResults playCombat() {
        return playCombat(new GameDeck(player1, player2), false);
    }

    public GameResults playRecursiveCombat() {
        return playCombat(new GameDeck(player1, player2), true);
    }

    @SuppressWarnings("ConstantConditions")
    private static GameResults playCombat(GameDeck gameDeck, boolean recursive) {
        HashSet<GameDeck> playedGames = new LinkedHashSet<>();

        while (gameDeck.player1.size() > 0 && gameDeck.player2.size() > 0) {

            if (recursive && playedGames.contains(gameDeck)) {
                return GameResults.builder().winner(Player1).build();
            }
            playedGames.add(gameDeck);

            var p1Card = gameDeck.player1.poll();
            var p2Card = gameDeck.player2.poll();

            Player winner;

            if (recursive && (gameDeck.player1.size() >= p1Card.cardValue() && gameDeck.player2.size() >= p2Card.cardValue())) {
                winner = playCombat(new GameDeck(slice(gameDeck.player1, p1Card.cardValue()), slice(gameDeck.player2, p2Card.cardValue())), true).getWinner();
            } else {
                winner = getWinnerByCardValue(p1Card, p2Card);
            }

            if (winner == Player1) {
                gameDeck.player1.add(p1Card);
                gameDeck.player1.add(p2Card);
            } else {
                gameDeck.player2.add(p2Card);
                gameDeck.player2.add(p1Card);
            }
        }

        if (gameDeck.player1.size() > 0) {
            return GameResults.builder().winner(Player1).winningCards(new LinkedList<>(gameDeck.player1)).build();
        } else {
            return GameResults.builder().winner(Player2).winningCards(new LinkedList<>(gameDeck.player2)).build();
        }
    }

    static Queue<Card> slice(Queue<Card> cards, int maxCards) {
        AtomicInteger index = new AtomicInteger(0);
        return cards.stream().filter(card -> index.getAndIncrement() < maxCards).collect(toCollection(LinkedList::new));
    }


    @EqualsAndHashCode
    private static class GameDeck {
        private final Queue<Card> player1;
        private final Queue<Card> player2;

        public GameDeck(Queue<Card> player1, Queue<Card> player2) {
            this.player1 = new LinkedList<>(player1);
            this.player2 = new LinkedList<>(player2);
        }

        @Override
        public String toString() {
            return player1.stream().map(Card::cardValue).map(String::valueOf).collect(joining(",")) + "#" + player2.stream().map(Card::cardValue).map(String::valueOf).collect(joining(","));
        }
    }

    private static Player getWinnerByCardValue(Card p1Card, Card p2Card) {
        return p1Card.compareTo(p2Card) > 0 ? Player1 : Player2;
    }
}
