package com.ruiz.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 *DTO  PERSON DTO 
 * 
 * @author Juan Carlos Ruiz
 * 
 */
@Getter
@Setter
public class PersonDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Integer id;

    private String nombre;
    private String apellido;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fechaNacimiento;

    private String puesto;
    private BigDecimal sueldo;

}
