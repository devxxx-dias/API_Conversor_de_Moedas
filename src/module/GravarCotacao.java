package module;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GravarCotacao {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapterFactory(new CustomizarMoedaConvertida())
            .create();
    private ArrayList<MoedaConvertida> historico = new ArrayList<>();
    FileWriter writer;

    private MoedaConvertida arquivo;


    public GravarCotacao(MoedaConvertida arquivo) throws IOException {
        this.writer = new FileWriter("historico.json");
        this.arquivo = arquivo;
        this.historico.add(arquivo);
       }

    public void grave() throws IOException {
        historico.forEach(intem ->
        {
            try {
                writer.write(gson.toJson(intem));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        writer.close();
        //Imprimir resultado
        System.out.println(arquivo);
    }

}
