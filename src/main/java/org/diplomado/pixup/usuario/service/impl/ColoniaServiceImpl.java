package org.diplomado.pixup.usuario.service.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.diplomado.pixup.usuario.domain.Colonia;
import org.diplomado.pixup.usuario.domain.Municipio;
import org.diplomado.pixup.usuario.domain.ex.ColoniaAlreadyExistsException;
import org.diplomado.pixup.usuario.domain.ex.ColoniaNotFoundException;
import org.diplomado.pixup.usuario.domain.ex.MunicipioNotFoundException;
import org.diplomado.pixup.usuario.respository.ColoniaRepository;
import org.diplomado.pixup.usuario.respository.MunicipioRepository;
import org.diplomado.pixup.usuario.service.ColoniaService;

import java.util.Optional;

@Stateless
public class ColoniaServiceImpl implements ColoniaService {

    @Inject
    private ColoniaRepository coloniaRepository;
    @Inject
    private MunicipioRepository municipioRepository;

    @Override
    public Colonia obtenerColoniaPorId(Integer id) {
        Optional<Colonia> colonia = coloniaRepository.findById(id);
        if(colonia.isPresent()){
            return colonia.get();
        }
        throw new ColoniaNotFoundException(id);
    }

    @Override
    public Colonia crearColonia(Colonia colonia) {
        Optional<Colonia> coloniaExistente = coloniaRepository.findByCpAndNombre(colonia.getCp(), colonia.getNombre());
        if(coloniaExistente.isEmpty()){
            Optional<Municipio> municipioExistente = municipioRepository.findById(colonia.getMunicipio().getId());
            if(municipioExistente.isEmpty()){
                throw new MunicipioNotFoundException(colonia.getMunicipio().getId());
            }
            colonia.setMunicipio(municipioExistente.get());
            return coloniaRepository.saveOrUpdate(colonia);
        }
        throw new ColoniaAlreadyExistsException(colonia.getCp(), colonia.getNombre());
    }

    @Override
    public void eliminarColoniaPorId(Integer id) {
        coloniaRepository.findById(id).ifPresent(
                colonia -> coloniaRepository.delete(colonia)
        );
    }
}
