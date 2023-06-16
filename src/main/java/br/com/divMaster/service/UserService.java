package br.com.divMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.divMaster.model.Usuarios;
import br.com.divMaster.repository.UserRepository;
import br.com.divMasterException.unsupportedMathOperatioExceptio;
@Service
public class UserService{

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Autowired
	private UserRepository repository;

	
	public List<Usuarios> findAll() {
		return repository.findAll();
	}
	
	public Usuarios findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("Categoria Com idNão Encontrado"));
				}

				public Usuarios criate(Usuarios user) {
					
					// verifica se o nome do usuário foi preenchido
					if(!StringUtils.hasText(user.getNome())) {
						throw new unsupportedMathOperatioExceptio("Informe O Nome do Usuário ");
					}
					
				
					// verifica se o e-mail já existe
					if(repository.existsByEmail(user.getEmail())) {
						throw new unsupportedMathOperatioExceptio(" E-mail Já Existe ");
					}
					// verifica se o e-mail foipreenchido
					if(user.getEmail() == null) {
						throw new unsupportedMathOperatioExceptio("Informe O E-mail ");
					}

					
					user.setPassword(passwordEncoder.encode(user.getPassword()));
					
					return repository.save(user);
				}

				public Usuarios updade(Usuarios user) {
					var entity = repository.findById(user.getId())
							.orElseThrow(() -> new unsupportedMathOperatioExceptio("Categoria Não Encontrada"));

					entity.setNome(user.getNome());
					entity.setPassword(user.getPassword());
					entity.setEmail(user.getEmail());
					entity.setEndereco(user.getEndereco());
					entity.setTelefone(user.getTelefone());
					entity.setAtivo(user.getAtivo());
					user.setPassword(passwordEncoder.encode(user.getPassword()));
					
					return repository.save(user);
				}

				public void delete(Long id) {
					repository.deleteById(id);
				}

	
}
