package com.kaduAnimacao.clinicaKadu.infra;

import com.kaduAnimacao.clinicaKadu.models.Usuario;
import com.kaduAnimacao.clinicaKadu.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseSemed implements CommandLineRunner {


    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public void run(String... args) throws Exception {
        var usuario = new Usuario(null,"Iamanca","$2y$10$UiWiYCeW2U0rGlRHWije.eCi8t6DtUOrg444v3HD1GXCnfXP2bXUi");
        var usuario2= new Usuario(null,"Ura","$2y$10$nhzY2X.X2ENonSKiJiFgO.JaNkbRxsVblrB7I0mlX/XUkN1CKe7Z2");
        usuarioRepository.save(usuario);
        usuarioRepository.save(usuario2);
    }
}
