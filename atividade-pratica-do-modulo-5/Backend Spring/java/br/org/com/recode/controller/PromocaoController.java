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

import br.org.com.recode.model.Promocao;
import br.org.com.recode.repository.PromocaoRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PromocaoController {

	@Autowired
	private PromocaoRepository promocaoRepository;
	
	// lista todos as promoções
	@GetMapping("/cadastro-promocao")
	public List<Promocao> getAllPromocoes() {
		return promocaoRepository.findAll();
	}
	
	// create promocao rest api
	@PostMapping("/cadastro-promocao")
	public Promocao createPromocao(@RequestBody Promocao promocao) {
		return promocaoRepository.save(promocao);
	}

	// get promocao by id rest api
	@GetMapping("/cadastro-promocao/{id}")
	public Promocao getPromocaoById(@PathVariable Long id) {
		return promocaoRepository.findById(id).get();
	}
	
	// update promocao rest api
	
	@PutMapping("/cadastro-promocao/{id}")
	public Promocao updatePromocao(@PathVariable Long id, @RequestBody Promocao promocaoDetails) {
		Promocao promocao = promocaoRepository.findById(id).get();
		
		promocao.setDestino(promocaoDetails.getDestino());
		promocao.setData_ida(promocaoDetails.getData_ida());
		promocao.setHorario_ida(promocaoDetails.getHorario_ida());
		promocao.setData_volta(promocaoDetails.getData_volta());
		promocao.setHorario_volta(promocaoDetails.getHorario_volta());
		promocao.setCia_aerea(promocaoDetails.getCia_aerea());
		promocao.setHotel(promocaoDetails.getHotel());
		promocao.setObservacoes(promocaoDetails.getObservacoes());
		promocao.setValor(promocaoDetails.getValor());
		promocao.setValor_promocional(promocaoDetails.getValor_promocional());
		
		return promocaoRepository.save(promocao);
	}
	
	// delete destino rest api
	@DeleteMapping("/cadastro-promocao/{id}")
	public void deletePromocao(@PathVariable Long id) {
		promocaoRepository.deleteById(id);
	}
	
}