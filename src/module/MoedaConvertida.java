package module;

import java.util.Date;

public record MoedaConvertida(String base_code, String target_code, double conversion_rate, double conversion_result, String time_last_update_utc) {


    @Override
    public String toString() {
        return "Valor: "
                + Math.round(conversion_result / conversion_rate)
                + " "
                + "["
                + base_code +
                "] com a taxa de conversão de "
                +conversion_rate
                +" corresponde ao valor final de =>>> "
                + conversion_result
                + " ["
                + target_code
                + "]"
                +" data: "
                + new Date()
                ;
    }
}




