package com.practica01.service;

import com.practica01.domain.Suculenta;
import com.practica01.repository.SuculentaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SuculentaService {

    //Se enlaza con el repositorio por medio de SuculentaRepository
    private final SuculentaRepository suculentaRepository;

    @Transactional(readOnly = true)
    public List<Suculenta> getSuculentas() {
        return suculentaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Suculenta> getSuculenta(Integer idSuculenta) {
        return suculentaRepository.findById(idSuculenta);
    }

    //Si idSuculenta tiene valor se hace un update, si no tiene valor se hace un insert
    public void save(Suculenta suculenta) {
        suculentaRepository.save(suculenta);
    }

    //Se valida si la suculenta existe y luego se elimina
    public void delete(Integer idSuculenta) {
        if (!suculentaRepository.existsById(idSuculenta)) {
            throw new IllegalArgumentException("La suculenta no existe: " + idSuculenta);
        }
        suculentaRepository.deleteById(idSuculenta);
    }
}
