package br.com.divMaster.serviceJwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.divMaster.dto.SignupRequest;
import br.com.divMaster.dto.UsuarioDto;
import br.com.divMaster.model.Usuarios;
import br.com.divMaster.repository.UserRepository;
import br.com.divMasterException.unsupportedMathOperatioExceptio;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository repository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UsuarioDto createUser(SignupRequest request) {
    	// verifica se o nome do usuário foi preenchido
		if(!StringUtils.hasText(request.getNome())) {
			throw new unsupportedMathOperatioExceptio("Informe O Nome do Usuário ");
		}
		
	
		// verifica se o e-mail já existe
		if(repository.existsByEmail(request.getEmail())) {
			throw new unsupportedMathOperatioExceptio(" E-mail Já Existe ");
		}
		// verifica se o e-mail foipreenchido
		if(request.getEmail() == null) {
			throw new unsupportedMathOperatioExceptio("Informe O E-mail ");
		}
		
        Usuarios user = new Usuarios();
        user.setId(request.getId());
        user.setNome(request.getNome());
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setEndereco(request.getEndereco());
        user.setTelefone(request.getTelefone());
        Usuarios created = repository.save(user);

        UsuarioDto usuarioDto = new UsuarioDto();
        
        usuarioDto.setId(created.getId());
        usuarioDto.setEmail(created.getEmail());
        usuarioDto.setNome(created.getNome());
        usuarioDto.setPassword(created.getPassword());
        usuarioDto.setEndereco(created.getEndereco());
        usuarioDto.setTelefone(created.getTelefone());
        return usuarioDto;
    }

}
