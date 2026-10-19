package com.practica01.service;

import com.practica01.domain.Suculenta;
import com.practica01.repository.SuculentaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * Logica del catalogo. El controlador nunca usa el repositorio directamente,
 * siempre pasa por esta clase.
 */
@Service
@RequiredArgsConstructor
public class SuculentaService {

    private final SuculentaRepository suculentaRepository;

    // Devuelve todas las suculentas registradas
    @Transactional(readOnly = true)
    public List<Suculenta> listarSuculentas() {
        return suculentaRepository.findAll();
    }

    // Cuando la suculenta trae id, JPA actualiza ese registro; si no trae, inserta uno nuevo
    @Transactional
    public void guardar(Suculenta suculenta) {
        suculentaRepository.save(suculenta);
    }

    // Retorna false si el id no existe, asi el controlador sabe que mensaje mostrar
    @Transactional
    public boolean eliminar(Integer idSuculenta) {
        if (!suculentaRepository.existsById(idSuculenta)) {
            return false;
        }
        suculentaRepository.deleteById(idSuculenta);
        return true;
    }
}
