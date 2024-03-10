package com.teste.pratico.agendamento.exceptions;

public class VagaNaoEncontradaException extends Exception {

    public VagaNaoEncontradaException(String message) {
        super(message);
    }

    public VagaNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }
}
