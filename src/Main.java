import module.ConsultarMoeda;
import module.GravarCotacao;
import module.Menu;

public class Main {
    public static void main(String[] args) {

        try {
            Menu menu = new Menu();

            do {
                menu.displayMenu();
                ConsultarMoeda consultarMoeda = new ConsultarMoeda(menu);
                GravarCotacao lancamento = new GravarCotacao(consultarMoeda.converta());
                lancamento.grave();

            } while (!menu.opcao.equals("8"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
//Todo implementar o historico usando o list , gravar o arquivos!