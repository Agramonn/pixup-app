package org.diplomado.pixup.usuario.api.dto.mapper;

import jakarta.inject.Singleton;
import org.diplomado.pixup.usuario.api.dto.DiscoRequestDTO;
import org.diplomado.pixup.usuario.api.dto.DiscoResponseDTO;
import org.diplomado.pixup.usuario.domain.Disco;

@Singleton
public class DiscoMapper {

    public DiscoResponseDTO toDto(Disco disco){
        return new DiscoResponseDTO(
                disco.getId(),
                disco.getTitulo(),
                disco.getArtista().getNombre(),
                disco.getDisquera().getNombre(),
                disco.getGeneroMusical().getDescripcion());
    }

    public Disco toDisco(DiscoRequestDTO discoRequestDTO){
        return new Disco(
                discoRequestDTO.getTitulo(),
                discoRequestDTO.getPrecio(),
                discoRequestDTO.getExistencia(),
                discoRequestDTO.getDescuento(),
                discoRequestDTO.getFechaLanzamiento(),
                discoRequestDTO.getImagen(),
                discoRequestDTO.getArtista(),
                discoRequestDTO.getDisquera(),
                discoRequestDTO.getGeneroMusical());
    }
}
