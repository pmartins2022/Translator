import java.util.Scanner;

public class MenuTranslator
{
    public static void Iniciar()
    {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            System.out.println("Operacoes:");
            System.out.println("[0] SAIR");
            System.out.println("[1] Configurar idiomas da tabela");
            System.out.println("[2] Adicionar nova palavra");
            System.out.println("[3] UC3");
            System.out.println("[4] UC4");

            int esc = sc.nextInt();

            switch (esc)
            {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }
}
