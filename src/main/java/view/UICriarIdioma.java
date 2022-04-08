package view;

import controller.ControllerCriarIdioma;
import model.Idioma;
import model.Translator;

import java.util.Scanner;

public class UICriarIdioma {

    private ControllerCriarIdioma myController;
    private String nome;
    public UICriarIdioma() {this.myController = new ControllerCriarIdioma();}


    public void run()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduza o nome do Idioma pretendido: ");

        String nome = sc.nextLine();

        myController.criarIdioma(nome);

        if (myController.criarIdioma(nome)==true){
            System.out.println("Idioma criado com sucesso.");
        }else{
            System.out.println("Idioma não criado.");
        }

    }



}
