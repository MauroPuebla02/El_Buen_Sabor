package ElBuenSabor.UTN;

//import ElBuenSabor.UTN.Models.Model.Categoria;
import ElBuenSabor.UTN.Models.Model.Categoria;
import ElBuenSabor.UTN.Repository.CategoriaRepository;
import ElBuenSabor.UTN.Service.Implements.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ElBuenSaborApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElBuenSaborApplication.class, args);
		System.out.println("HOLA MUNDO !!!! :D XD");
	}
/*
	@Bean
	public CommandLineRunner cargarCategorias(CategoriaRepository repo) {
		return args -> {
			Categoria hijo1 = Categoria.builder().denominacion("Hijo 1").build();
			Categoria hijo2 = Categoria.builder().denominacion("Hijo 2").build();
			Categoria padre = Categoria.builder()
					.denominacion("Padre")
					.categorias_hijas(List.of(hijo1, hijo2))
					.build();
			repo.save(padre);
			System.out.println("Categoría guardada: " + padre);
		};
	}
*/
}
