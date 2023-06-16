package br.com.divMaster.serviceJwt;

import br.com.divMaster.dto.SignupRequest;
import br.com.divMaster.dto.UsuarioDto;

public interface AuthService {

	UsuarioDto createUser(SignupRequest request);

}
