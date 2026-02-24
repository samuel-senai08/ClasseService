package com.petshop.demo.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.petshop.demo.Entity.Tutor;
import com.petshop.demo.Repository.TutorRepository;



@Service
public class TutorService {
	private final TutorRepository tutorRepository;

	public TutorService(TutorRepository tutorRepository) {
	this.tutorRepository = tutorRepository;
	}
	
	public Tutor saveTutor (Tutor tutor) {
		return tutorRepository.save(tutor);
	}
	
	public Tutor getTutorById(Long id) {
		return tutorRepository.findById(id).orElse(null);
	}
	public List<Tutor> getAllTutor() {
		return tutorRepository.findAll();
	}
	public Tutor alteraTutor(Long id, Tutor alteraTutor) {
		Optional<Tutor> existeTutor = tutorRepository.findById(id);
		if (existeTutor.isPresent()) {
			alteraTutor.setId(id);
			return tutorRepository.save(alteraTutor);
		}
		else {
			return null;
		}
	}
	public boolean deleteTutor(Long id) {
		Optional<Tutor> existeTutor = tutorRepository.findById(id);
		if (existeTutor.isPresent()) {
			tutorRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
}

	
