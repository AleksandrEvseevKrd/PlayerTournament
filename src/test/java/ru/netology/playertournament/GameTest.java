package ru.netology.playertournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Дамир", 100);
    Player player2 = new Player(2, "Евгений", 25);
    Player player3 = new Player(3, "Кристофер", 25);
    Player player4 = new Player(4, "Магомед", 35);
    Player player5 = new Player(5, "Татьяна", 150);
    Player player6 = new Player(6, "Юджин", 350);
    Game game = new Game();

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
    }

    @Test
    public void gameTournamentTestTheFirst() {
        int expected = 2;
        int actual = game.round("Дамир", "Юджин");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void gameTournamentTestTheSecond() {
        int expected = 1;
        int actual = game.round("Татьяна", "Магомед");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void gameTournamentTestTheThird() {
        int expected = 0;
        int actual = game.round("Кристофер", "Евгений");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void gameTournamentTestTheFourth() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Кристофер", "Игорь");
        });
    }

    @Test
    public void gameTournamentTestTheFifth() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Валера", "Магомед");
        });
    }

    @Test
    public void gameTournamentTestTheSixth() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Слава");
        });
    }

    @Test
    public void getIdTestTheSeventh() {
        int expected = 4;
        int actual = player4.getId();
        Assertions.assertEquals(expected, actual);
    }
}