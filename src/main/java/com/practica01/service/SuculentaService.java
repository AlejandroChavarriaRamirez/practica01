package com.practica01.service;

import com.practica01.domain.Suculenta;
import com.practica01.repository.SuculentaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SuculentaService {

    private final SuculentaRepository suculentaRepository;

    @Transactional(readOnly = true)
    public List<Suculenta> listarSuculentas() {
        return suculentaRepository.findAll();
    }

    // Si trae id actualiza, si no inserta
    @Transactional
    public void guardar(Suculenta suculenta) {
        suculentaRepository.save(suculenta);
    }

    // Devuelve false si no existe
    @Transactional
    public boolean eliminar(Integer idSuculenta) {
        if (!suculentaRepository.existsById(idSuculenta)) {
            return false;
        }
        suculentaRepository.deleteById(idSuculenta);
        return true;
    }
}
