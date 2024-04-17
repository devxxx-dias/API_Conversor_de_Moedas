package module;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    public Scanner scanner = new Scanner(System.in);

    private String menuInicial;
    public String opcao;
    public String moedaParaConverter;
    public String moedaConvertida;
    public double valor;

    public Menu() {
    }

    public Menu(String opcao, String moedaParaConverter, String moedaConvertida, double valor) {
        this.opcao = opcao;
        this.moedaParaConverter = moedaParaConverter;
        this.moedaConvertida = moedaConvertida;
        this.valor = valor;
    }

    public Menu displayMenu() throws FileNotFoundException {
        this.menuInicial = """
                 *******************************************************************************
                 Seja bem-vindo(a) ao Conversor de Moedas = ) !
                                \s
                 1)  Real Brasileiro =>> Dólar
                 2)  Dólar =>> Real Brasileiro
                 3)  Real Brasileiro =>> Euro
                 4)  Euro =>> Real Brasileiro
                 5)  Real Brasileiro =>> Yuan
                 6)  Yuan =>> Real Brasileiro
                 7)  Consultar histórico
                 8) Sair
                                \s
                 Escolha uma opção válida:
                                \s
                                 \s
                 *******************************************************************************
                \s""";

        System.out.println(menuInicial);
        System.out.println("Digite o número da sua opção");
        opcao = scanner.next();

//If para o trecho que nao necessita colocar o valor
        if (opcao.equals("7")) {
            System.out.println("Resultado das suas consultas prévias; ");
            LeitorDoHistorico leitorDoHistorico = new LeitorDoHistorico();
            leitorDoHistorico.lerArquivo();
            System.exit(0);
        }

        if (opcao.equals("8")) {
            System.out.println("Obrigado por utilizar o nosso Conversor! ; )");
            System.exit(0);
        }

        System.out.println("Digite o valor que deseja converter:");
        valor = scanner.nextInt();
        System.out.println("Resultado:");


        switch (opcao) {
            case "1":
                this.moedaParaConverter = "BRL";
                this.moedaConvertida = "USD";
                break;
            case "2":
                this.moedaParaConverter = "USD";
                this.moedaConvertida = "BRL";
                break;
            case "3":
                this.moedaParaConverter = "BRL";
                this.moedaConvertida = "EUR";
                break;
            case "4":
                this.moedaParaConverter = "EUR";
                this.moedaConvertida = "BRL";
                break;
            case "5":
                this.moedaParaConverter = "BRL";
                this.moedaConvertida = "CNY";
                break;
            case "6":
                this.moedaParaConverter = "CNY";
                this.moedaConvertida = "BRL";
                break;
            default:
                System.out.println("Escolha uma das opções do menu para realizar a sua conversão.");
        }

        Menu menu = new Menu(opcao, moedaParaConverter, moedaConvertida, valor);
        return menu;
    }

}
