package org.diplomado.pixup.usuario.service.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.diplomado.pixup.usuario.domain.Artista;
import org.diplomado.pixup.usuario.domain.Disco;
import org.diplomado.pixup.usuario.domain.Disquera;
import org.diplomado.pixup.usuario.domain.GeneroMusical;
import org.diplomado.pixup.usuario.domain.ex.*;
import org.diplomado.pixup.usuario.respository.ArtistaRepository;
import org.diplomado.pixup.usuario.respository.DiscoRepository;
import org.diplomado.pixup.usuario.respository.DisqueraRepository;
import org.diplomado.pixup.usuario.respository.GeneroMusicalRepository;
import org.diplomado.pixup.usuario.service.DiscoService;

import java.util.Optional;

@Stateless
public class DiscoServiceImpl implements DiscoService {

    @Inject
    private DiscoRepository discoRepository;
    @Inject
    private ArtistaRepository  artistaRepository;
    @Inject
    private GeneroMusicalRepository generoMusicalRepository;
    @Inject
    private DisqueraRepository disqueraRepository;


    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Disco registrarDisco(Disco disco) {
        Optional<Artista> artistaExistente = artistaRepository.findById(disco.getArtista().getId());
        if(artistaExistente.isEmpty()){
            throw new ArtistaNotFoundException(disco.getArtista().getId());
        }
        Optional<Disquera> disqueraExistente = disqueraRepository.findById(disco.getDisquera().getId());
        if(disqueraExistente.isEmpty()){
            throw new DisqueraNotFoundException(disco.getDisquera().getId());
        }
        Optional<GeneroMusical> generoMusicalExistente = generoMusicalRepository.findById(disco.getGeneroMusical().getId());
        if(generoMusicalExistente.isEmpty()){
            throw new GeneroMusicalNotFoundException(disco.getGeneroMusical().getId());
        }
        Optional<Disco> discoExistente = discoRepository.findByTituloAndArtista(disco.getTitulo(), disco.getArtista().getId());
        if(discoExistente.isPresent()){
            throw new DiscoAlreadyExistsException(disco.getTitulo(), disco.getArtista().getId());
        }
        Optional<Disco> discoImagenExistente = discoRepository.findByImagen(disco.getImagen());
        if(discoImagenExistente.isPresent()){
            throw new DiscoImagenAlreadyExistsException(discoImagenExistente.get().getImagen());
        }
        disco.setArtista(artistaExistente.get());
        disco.setDisquera(disqueraExistente.get());
        disco.setGeneroMusical(generoMusicalExistente.get());
        discoRepository.save(disco);
        return disco;
    }
}
