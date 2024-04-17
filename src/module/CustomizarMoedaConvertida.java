package module;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class CustomizarMoedaConvertida implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        TypeAdapter<T> defaultAdapter = gson.getDelegateAdapter(this, typeToken);

        return new TypeAdapter<>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                out.beginObject();

                out.name("Moeda base: ").value(((MoedaConvertida) value).base_code());
                out.name("Moeda convertida: ").value(((MoedaConvertida) value).target_code());
                out.name("Taxa de Câmbio: ").value(((MoedaConvertida) value).conversion_rate());
                out.name("Valor convertido: ").value(((MoedaConvertida) value).conversion_result());
                out.name("Data e hora da consulta:").value(((MoedaConvertida) value).time_last_update_utc().substring(0,17));
                out.endObject();
            }

            @Override
            public T read(JsonReader in) throws IOException {
                return defaultAdapter.read(in);
            }
        };
    }
}


