package ElBuenSabor.UTN.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;

@Configuration
public class JacksonHibernateConfig {

    @Bean
    public Module hibernate6Module() {
        Hibernate6Module module = new Hibernate6Module();
        // (Opcional) Si no quieres que Jackson inicialice colecciones LAZY automáticamente,
        // puedes deshabilitarlo con:
        // module.disable(Hibernate6Module.Feature.FORCE_LAZY_LOADING);
        return module;
    }
}