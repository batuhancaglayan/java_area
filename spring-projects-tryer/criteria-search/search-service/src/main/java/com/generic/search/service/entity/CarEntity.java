package com.generic.search.service.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity(name = "car")
@Data
public class CarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@NotBlank(message = "Model is mandatory")
	private String model;
	
	private Date date;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "deneme_id", referencedColumnName = "id")
//	private Deneme deneme;
	
	@Enumerated(EnumType.STRING)
	private Dale dale;
}
