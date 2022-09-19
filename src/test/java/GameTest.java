import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Alex", 500);
    Player player2 = new Player(2, "Sam", 600);
    Player player3 = new Player(3, "Luke", 300);
    Player player4 = new Player(4, "Jane", 700);
    Player player5 = new Player(5, "Mila", 600);

    @Test
    public void shouldTestStrengthIfFirstWins() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 1;
        int actual = game.round("Jane", "Mila");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestStrengthIfSecondWins() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 2;
        int actual = game.round("Luke", "Sam");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestStrengthIfADraw() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 0;
        int actual = game.round("Sam", "Mila");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfNotRegisteredPlayer1() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Kim", "Jane");
        });
    }

    @Test
    public void shouldThrowExceptionIfNotRegisteredPlayer2() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Jane", "John");
        });
    }
}
