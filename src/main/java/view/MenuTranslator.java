package view;

import model.Translator;
import view.UI_AdicionarPalavra;

import java.util.Scanner;

public class MenuTranslator
{
    public static void Iniciar()
    {
        Scanner sc = new Scanner(System.in);

        int esc = -1;

        while (esc != 0)
        {
            System.out.println("Operacoes:");
            System.out.println("[0] SAIR");
            System.out.println("[1] Configurar idiomas da tabela");
            System.out.println("[2] Adicionar nova palavra");
            System.out.println("[3] Quantas palavras Portuguesas têm tradução");
            System.out.println("[4] Listar todas as palavras portuguesas e respetivas traduções");

            esc = sc.nextInt();

            switch (esc)
            {
                case 0:

                    break;
                case 1:

                    break;
                case 2:
                    UI_AdicionarPalavra u = new UI_AdicionarPalavra();
                    u.run();
                    break;
                case 3:
                    UIContarPalavras ui = new UIContarPalavras();
                    System.out.println(ui.contarPalavras());

                    break;
                case 4:
                    UIMostrarPalavras ui1 = new UIMostrarPalavras();
                    System.out.println(ui1.mostrarPalavras());
                    break;
            }
        }

        Translator.getInstance().closeDBConnection();
    }
}
