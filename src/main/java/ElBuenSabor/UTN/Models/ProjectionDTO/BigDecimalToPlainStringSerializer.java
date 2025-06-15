package ElBuenSabor.UTN.Models.ProjectionDTO;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalToPlainStringSerializer extends StdSerializer<BigDecimal> {

    public BigDecimalToPlainStringSerializer() {
        super(BigDecimal.class);
    }

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toPlainString());
    }
}
