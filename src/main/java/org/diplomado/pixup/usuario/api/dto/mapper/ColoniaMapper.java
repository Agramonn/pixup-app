package org.diplomado.pixup.usuario.api.dto.mapper;

import jakarta.inject.Singleton;
import org.diplomado.pixup.usuario.api.dto.ColoniaDTO;
import org.diplomado.pixup.usuario.domain.Colonia;

@Singleton
public class ColoniaMapper {

    public ColoniaDTO toDto(Colonia colonia){
        return new ColoniaDTO(
                colonia.getId(), colonia.getNombre(),
                colonia.getCp(),
                colonia.getMunicipio().getNombre(),
                colonia.getMunicipio().getEstado().getNombre()
        );
    }

    public Colonia toColonia(ColoniaDTO coloniaDTO){
        //ToDo
        return null;
    }

}
