package com.devsuperior_cli.dscommerce_cli.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.devsuperior_cli.dscommerce_cli.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ClientDTO {
	
	
	
	private Long id;
	
	@NotBlank(message = "Campo requerido")
	private String name;
	private String cpf;
	private Double income;
	@PastOrPresent(message ="Data nao pode ser futura")
	private LocalDate birthDate;
	private Integer children;
	public ClientDTO() {
		
	}

	
	public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	public ClientDTO(Client entity) {
		
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		income = entity.getIncome();
		birthDate = entity.getBirthDate();
		children = entity.getChildren();
	}
	
	
	
	
	
	
	

	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getCpf() {
		return cpf;
	}


	public Double getIncome() {
		return income;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public Integer getChildren() {
		return children;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientDTO other = (ClientDTO) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	
	
	
	
	
	
}
