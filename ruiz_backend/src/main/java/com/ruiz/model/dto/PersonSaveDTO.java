package com.ruiz.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *DTO  PERSON SAVE DTO 
 * 
 * @author Juan Carlos Ruiz
 * 
 */
@Getter
@Setter
public class PersonSaveDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellido;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fechaNacimiento;

    private String puesto;
    private BigDecimal sueldo;

}
