package com.alura.screenmatch;

import com.alura.screenmatch.model.DatosEpisodio;
import com.alura.screenmatch.model.DatosTemporadas;
import com.alura.screenmatch.principal.Principal;
import com.alura.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alura.screenmatch.model.DatosSerie;
import com.alura.screenmatch.service.ConsumoApi;
import com.alura.screenmatch.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ScreenmatchApplication  implements CommandLineRunner {

	@Autowired
	private SerieRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraElMenu();

	}
}
