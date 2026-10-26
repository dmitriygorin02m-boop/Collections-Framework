package ru.netology.Collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    // Получение ID игрока
    @Test
    public void shouldReturnPlayerId() {
        Player player = new Player(90, "Oleg", 55);

        assertEquals(90, player.getId());
    }

    // Победа первого игрока
    @Test
    public void shouldReturnOneWhenFirstPlayerIsStronger() {
        Game game = new Game();

        Player player1 = new Player(10, "Dmitry", 90);
        Player player2 = new Player(20, "Sergey", 40);

        game.register(player1);
        game.register(player2);

        assertEquals(1, game.round("Dmitry", "Sergey"));
    }

    // Победа второго игрока
    @Test
    public void shouldReturnTwoWhenSecondPlayerIsStronger() {
        Game game = new Game();

        Player player1 = new Player(30, "Dmitry", 25);
        Player player2 = new Player(40, "Sergey", 75);

        game.register(player1);
        game.register(player2);

        assertEquals(2, game.round("Dmitry", "Sergey"));
    }

    // Ничья при одинаковой силе
    @Test
    public void shouldReturnZeroWhenPlayersHaveEqualStrength() {
        Game game = new Game();

        Player player1 = new Player(50, "Oleg", 60);
        Player player2 = new Player(60, "Nikolay", 60);

        game.register(player1);
        game.register(player2);

        assertEquals(0, game.round("Oleg", "Nikolay"));
    }

    // Если оба игрока не зарегистрированы
    @Test
    public void shouldThrowExceptionWhenNoPlayersAreRegistered() {
        Game game = new Game();

        assertThrows(
                NotRegisteredException.class,
                () -> game.round("Oleg", "Nikolay")
        );
    }

    // Если первый игрок не зарегистрирован
    @Test
    public void shouldThrowExceptionWhenFirstPlayerIsNotRegistered() {
        Game game = new Game();

        game.register(new Player(70, "Nikolay", 85));

        assertThrows(
                NotRegisteredException.class,
                () -> game.round("Oleg", "Nikolay")
        );
    }

    // Если второй игрок не зарегистрирован
    @Test
    public void shouldThrowExceptionWhenSecondPlayerIsNotRegistered() {
        Game game = new Game();

        game.register(new Player(80, "Oleg", 95));

        assertThrows(
                NotRegisteredException.class,
                () -> game.round("Oleg", "Nikolay")
        );
    }
}

