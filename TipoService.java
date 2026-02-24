package com.petshop.demo.Service;

import java.util.List;
import java.util.Optional;
import com.petshop.demo.Entity.Tipo;
import com.petshop.demo.Repository.TipoRepository;
import jakarta.persistence.Entity;

@Entity
public class TipoService {
	
	private final TipoRepository tipoRepository;
	
	public TipoService(TipoRepository tipoRepository) {
		this.tipoRepository = tipoRepository;
	}
	
	public Tipo saveTipo(Tipo tipo) {
		return tipoRepository.save(tipo);
		
	}
	public Tipo getTipoById(Long id) {
		return tipoRepository.findById(id).orElse(null);
		
	}
	
	public List<Tipo> getAllChip() {
		return tipoRepository.findAll();
	}
	
	public Tipo alteraTipo(Long id, Tipo alteraTipo) {
		Optional<Tipo> existeTipo = tipoRepository.findById(id);
		if (existeTipo.isPresent()) {
			alteraTipo.setId(id);
			return tipoRepository.save(alteraTipo);
		}else {
			return null;
			
		}
	}
	
	public boolean deleteTipo(Long id) {
		Optional<Tipo> existeTipo = tipoRepository.findById(id);
		if (existeTipo.isPresent()) {
			tipoRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
		
	}
	

}


