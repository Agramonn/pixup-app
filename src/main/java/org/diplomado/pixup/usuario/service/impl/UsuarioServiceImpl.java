package org.diplomado.pixup.usuario.service.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.diplomado.pixup.usuario.domain.Colonia;
import org.diplomado.pixup.usuario.domain.Domicilio;
import org.diplomado.pixup.usuario.domain.TipoDomicilio;
import org.diplomado.pixup.usuario.domain.Usuario;
import org.diplomado.pixup.usuario.domain.ex.TipoDomicilioNotFoundException;
import org.diplomado.pixup.usuario.domain.ex.UsuarioAlreadyExistsException;
import org.diplomado.pixup.usuario.respository.DomicilioRepository;
import org.diplomado.pixup.usuario.respository.TipoDomicilioRepository;
import org.diplomado.pixup.usuario.respository.UsuarioRepository;
import org.diplomado.pixup.usuario.service.ColoniaService;
import org.diplomado.pixup.usuario.service.UsuarioService;

import java.util.Optional;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;
    @Inject
    private DomicilioRepository domicilioRepository;
    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;
    @Inject
    private ColoniaService coloniaService;



    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Usuario registrarUsuario(Usuario usuario, Domicilio domicilio) {
        // validacion usuario duplicado
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if(usuarioExistente.isPresent()){
            throw new UsuarioAlreadyExistsException(usuario.getEmail());
        }
        // validacion existencia colonia
        Colonia colonia = coloniaService.obtenerColoniaPorId(domicilio.getColonia().getId());
        domicilio.setColonia(colonia);

        // validacion existencia tipoDomicilio
        Optional<TipoDomicilio> tipoDomicilioExistente = tipoDomicilioRepository.findById(domicilio.getTipoDomicilio().getId());
        if(tipoDomicilioExistente.isEmpty()){
            throw new TipoDomicilioNotFoundException(domicilio.getTipoDomicilio().getId());
        }
        domicilio.setTipoDomicilio(tipoDomicilioExistente.get());

        // persistencia/guradado entidades
        // BEGIN TRANSACTION
        usuarioRepository.save(usuario);
        domicilio.setUsuario(usuario);
        domicilioRepository.save(domicilio);
        // COMMIT TRANSACTION
        return usuario;
    }
}
