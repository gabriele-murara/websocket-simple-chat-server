/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.murara.chatserver;

/**
 *
 * @author gabriele
 */
public class Main {
    
    public static void main(String[] args) {
        new ChatServer(9001).start();
    }
}
