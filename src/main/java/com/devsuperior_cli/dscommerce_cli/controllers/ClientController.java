package com.devsuperior_cli.dscommerce_cli.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior_cli.dscommerce_cli.dto.ClientDTO;
import com.devsuperior_cli.dscommerce_cli.services.ClientService;

import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	@Autowired
	private ClientService service;
	
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable  Long id) {
		ClientDTO dto = service.findById(id);
		return  ResponseEntity.ok(dto);
	}
		
	
	@GetMapping()
	public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
		Page<ClientDTO> dto = service.findAll(pageable);
		return ResponseEntity.ok(dto);
	}
	
	
	@PostMapping()
	public ResponseEntity<ClientDTO> insert(@Valid  @RequestBody  ClientDTO dto) {
		dto = service.insert(dto) ;
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update( @PathVariable  Long id,@Valid  @RequestBody  ClientDTO dto) {
		dto = service.update(id, dto);
		return  ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable  Long id) {
		service.delete(id);
		return  ResponseEntity.noContent().build();
	
	}
	
	
	
	
	
	

}
