package br.org.com.recode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.com.recode.model.Destino;
import br.org.com.recode.repository.DestinoRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DestinoController {

	@Autowired
	private DestinoRepository destinoRepository;
	
	// lista todos os destinos
	@GetMapping("/cadastro-destino")
	public List<Destino> getAllDestinos() {
		return destinoRepository.findAll();
	}
	
	// create destino rest api
	@PostMapping("/cadastro-destino")
	public Destino createDestino(@RequestBody Destino destino) {
		return destinoRepository.save(destino);
	}

	// get destino by id rest api
	@GetMapping("/cadastro-destino/{id}")
	public Destino getDestinoById(@PathVariable Long id) {
		return destinoRepository.findById(id).get();
	}
	
	// update destino rest api
	
	@PutMapping("/cadastro-destino/{id}")
	public Destino updateDestino(@PathVariable Long id, @RequestBody Destino destinoDetails) {
		Destino destino = destinoRepository.findById(id).get();
		
		destino.setDestino(destinoDetails.getDestino());
		destino.setData_ida(destinoDetails.getData_ida());
		destino.setHorario_ida(destinoDetails.getHorario_ida());
		destino.setData_volta(destinoDetails.getData_volta());
		destino.setHorario_volta(destinoDetails.getHorario_volta());
		destino.setCia_aerea(destinoDetails.getCia_aerea());
		destino.setHotel(destinoDetails.getHotel());
		destino.setObservacoes(destinoDetails.getObservacoes());
		destino.setValor(destinoDetails.getValor());
		
		return destinoRepository.save(destino);
	}
	
	// delete destino rest api
	@DeleteMapping("/cadastro-destino/{id}")
	public void deleteDestino(@PathVariable Long id) {
		destinoRepository.deleteById(id);
	}
	
}
