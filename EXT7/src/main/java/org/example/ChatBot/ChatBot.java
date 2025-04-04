package org.example.ChatBot;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatBot {

    static Scanner entry = new Scanner(System.in);
    static final Map<String, String> chatbot = new LinkedHashMap<>();

    public static void main(String[] args) {

        addRespuesta("hola","Hola, ¿En que te puedo ayudar?");
        addRespuesta("¿como estas?","Estoy listo para ayudarte!");
        addRespuesta("adios","Hasta luego!");
        addRespuesta("gracias","De nada! Que tengas un buen día");
        addRespuesta("salir","Adios!!");

        System.out.println("ChatBot: Bienvenido! Escribe salir cuando quieras acabar la conversación...");
        String usuario;
        do {
            usuario = entry.nextLine();
            recorrerMap(usuario);

        }while (!usuario.equalsIgnoreCase("salir"));

    }

    public static void addRespuesta(String origen, String mensaje){
        chatbot.put(origen,mensaje);
    }

    public static void recorrerMap(String usuario){
        for (Map.Entry<String , String> line : chatbot.entrySet()){
            if (line.getKey().equalsIgnoreCase(usuario)){
                System.out.println("ChatBot: " + line.getValue());
                return;
            }
        }
        System.out.println("ChatBot: No te entiendo :(");
    }
}
