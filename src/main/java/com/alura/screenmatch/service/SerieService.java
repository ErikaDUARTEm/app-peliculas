package com.alura.screenmatch.service;

import com.alura.screenmatch.dto.SerieDTO;
import com.alura.screenmatch.model.Serie;
import com.alura.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {
    @Autowired
    private SerieRepository repositorio;
    public List<SerieDTO> obtenerTodasLasSeries(){
        return convertirDatos(repositorio.findAll());

    }

    public List<SerieDTO> obtenerTop5() {
        return convertirDatos(repositorio.findTop5ByOrderByEvaluacionDesc());

    }
    public List<SerieDTO> obtenerLanzamientosMasRecientes(){
        return convertirDatos(repositorio.lanzamientosMasRecientes());
    }
    public List<SerieDTO> convertirDatos(List<Serie> serie){
        return serie.stream()
                .map(s->new SerieDTO(s.getId(), s.getTitulo(),
                        s.getTotalTemporadas(),
                        s.getEvaluacion(),
                        s.getPoster(),
                        s.getGenero(),
                        s.getActores(),
                        s.getSinopsis()))
                .collect(Collectors.toList());
    }

    public SerieDTO obtenerPorId(Long id) {
        Optional<Serie> serie = repositorio.findById(id);
        if(serie.isPresent()){
            Serie s = serie.get();
            return new SerieDTO(s.getId(), s.getTitulo(),
                    s.getTotalTemporadas(),
                    s.getEvaluacion(),
                    s.getPoster(),
                    s.getGenero(),
                    s.getActores(),
                    s.getSinopsis());
        }
        return null;
    }
}
