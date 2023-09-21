package PlayerGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Player slava = new Player(1, "Слава", 100);
        Player yasha = new Player(2, "Яша", 120);

        Game game = new Game();

        game.register(slava);
        game.register(yasha);
        int actual = game.round("Яша", "Слава");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNoExist() {
        Player slava = new Player(1, "Слава", 100);
        Player yasha = new Player(2, "Яша", 120);

        Game game = new Game();

        game.register(slava);
        game.register(yasha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Коля", "Слава")
        );
    }
    @Test
    public void testWhenTwoPlayerWin() {
        Player slava = new Player(1, "Слава", 120);
        Player yasha = new Player(2, "Яша", 100);

        Game game = new Game();

        game.register(slava);
        game.register(yasha);
        int actual = game.round("Яша", "Слава");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenDrawPlayers() {
        Player slava = new Player(1, "Слава", 100);
        Player yasha = new Player(2, "Яша", 100);

        Game game = new Game();

        game.register(slava);
        game.register(yasha);
        int actual = game.round("Яша", "Слава");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenTwoPlayerNoExist() {
        Player slava = new Player(1, "Слава", 100);
        Player yasha = new Player(2, "Яша", 120);

        Game game = new Game();

        game.register(slava);
        game.register(yasha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Яша", "Дима")
        );
    }
    @Test
    public void testWhenBothPlayersNoExist() {
        Player slava = new Player(1, "Слава", 100);
        Player yasha = new Player(2, "Яша", 120);

        Game game = new Game();

        game.register(slava);
        game.register(yasha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Коля", "Дима")
        );
    }
}
