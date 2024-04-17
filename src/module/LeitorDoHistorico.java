package module;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorDoHistorico {

    private File arquivo;
    private Scanner scanner;

    public  LeitorDoHistorico() throws FileNotFoundException {
        this.arquivo =  new File("historico.json");
        this.scanner  = new Scanner(this.arquivo);
    }

  public void lerArquivo (){
        while (this.scanner.hasNextLine()){
            String linha = scanner.nextLine();
            System.out.println(linha);
        }
  }

}
