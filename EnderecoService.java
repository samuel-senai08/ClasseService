package com.petshop.demo.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.petshop.demo.Entity.Endereco;
import com.petshop.demo.Repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	private final EnderecoRepository enderecoRepository;
	
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	public Endereco saveEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public Endereco getEnderecoById(Long id) {
		return enderecoRepository.findById(id).orElse(null);
	}
	
	public List<Endereco> getAllChip() {
		return enderecoRepository.findAll();
	}
	
	public Endereco alteraEndereco(Long id, Endereco alteraEndereco) {
		Optional<Endereco> existeEndereco = enderecoRepository.findById(id);
		if (existeEndereco.isPresent()) {
			alteraEndereco.setId(id);
			return enderecoRepository.save(alteraEndereco);
		}else {
			return null;
		}
	}
	public boolean deleteEndereco(Long id) {
		Optional<Endereco> existeEndereco = enderecoRepository.findById(id);
		if (existeEndereco.isPresent()) {
			enderecoRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	

}

