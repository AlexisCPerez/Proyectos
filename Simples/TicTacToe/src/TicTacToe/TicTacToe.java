
package TicTacToe;

import java.util.Scanner;

public final class TicTacToe {
    private final char[][] tablero;
    private char jugador;
    

    public TicTacToe() {
        tablero = new char[3][3];
        jugador = 'X';
        IniciarTablero();
    }

    public void IniciarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    public void imprimirTablero() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean tableroCompleto() {
        boolean lleno = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') {
                    lleno = false;
                }
            }
        }

        return lleno;
    }

    public boolean revisarGanador() {
        return (revisarFilasGanador() || revisarColumnasGanador() || revisarDiagonalesGanador());
    }

    private boolean revisarFilasGanador() {
        for (int i = 0; i < 3; i++) {
            if (revisarFilasyColumnas(tablero[i][0], tablero[i][1], tablero[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean revisarColumnasGanador() {
        for (int i = 0; i < 3; i++) {
            if (revisarFilasyColumnas(tablero[0][i], tablero[1][i], tablero[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean revisarDiagonalesGanador() {
        return ((revisarFilasyColumnas(tablero[0][0], tablero[1][1], tablero[2][2]) == true) || (revisarFilasyColumnas(tablero[0][2], tablero[1][1], tablero[2][0]) == true));
    }

    private boolean revisarFilasyColumnas(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    public void cambiarJugador() {
        if (jugador == 'X') {
            jugador = 'O';
        } else {
            jugador = 'X';
        }
    }

    public boolean colocarMarca(int fila, int columna) {
        if ((fila >= 0) && (fila < 3)) {
            if ((columna >= 0) && (columna < 3)) {
                if (tablero[fila][columna] == '-') {
                    tablero[fila][columna] = jugador;
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TicTacToe juego = new TicTacToe();

        System.out.println("Tic Tac Toe");
        juego.imprimirTablero();

        while (true) {
            System.out.println("Jugador " + juego.jugador + ", ingrese fila y columna para marcar: ");

            int fila = input.nextInt();
            int columna = input.nextInt();

        if (juego.colocarMarca(fila, columna)) {
            juego.imprimirTablero();

            if (juego.revisarGanador()) {
                System.out.println("Jugador " + juego.jugador + " gana!");
                break;
            } else if (juego.tableroCompleto()) {
                System.out.println("Empate!");
                break;
            } else {
                juego.cambiarJugador();
            }
        } else {
            System.out.println("Movimiento invalido. Intenta nuevamente");
        }
    }
    }
}