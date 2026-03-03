package com.ruiz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruiz.model.dto.PersonDTO;
import com.ruiz.model.dto.PersonSaveDTO;
import com.ruiz.model.dto.ResponseDTO;
import com.ruiz.service.IPersonService;

import lombok.extern.slf4j.Slf4j;

/**
 * CONTROLLER PERSON
 * 
 * @author Juan Carlos Ruiz
 */
@Slf4j
@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private IPersonService iPersonService;

	/**
	 * CONSULTAR TODOS
	 */
	@GetMapping(value = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> consultarTodos() {

		log.info("INICIA CONSULTA TODAS LAS PERSONAS");

		ResponseDTO responseDTO = iPersonService.consultarTodos();

		log.info("TERMINA CONSULTA TODAS LAS PERSONAS");

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	/**
	 * CONSULTAR POR ID
	 */
	@GetMapping(value = "/consultar/{idPerson}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> consultaPorId(@PathVariable Integer idPerson) {

		log.info("INICIA CONSULTA PERSONA POR ID: {}", idPerson);

		ResponseDTO responseDTO = iPersonService.consultaPorId(idPerson);

		log.info("TERMINA CONSULTA PERSONA POR ID");

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	/**
	 * GUARDAR PERSONA
	 */
	@PostMapping(value = "/guardar",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> guardar(@RequestBody PersonSaveDTO personSaveDTO) {

		log.info("INICIA GUARDADO DE PERSONA");

		ResponseDTO responseDTO = iPersonService.guardar(personSaveDTO);

		log.info("TERMINA GUARDADO DE PERSONA");

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	/**
	 * ACTUALIZAR PERSONA
	 */
	@PutMapping(value = "/actualizar",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> actualizar(@RequestBody PersonDTO personDTO) {

		log.info("INICIA ACTUALIZACION DE PERSONA");

		ResponseDTO responseDTO = iPersonService.actualizar(personDTO);

		log.info("TERMINA ACTUALIZACION DE PERSONA");

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	/**
	 * ELIMINAR PERSONA
	 */
	@DeleteMapping(value = "/eliminar/{idPerson}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> eliminarPorId(@PathVariable Integer idPerson) {

		log.info("INICIA ELIMINACION DE PERSONA CON ID: {}", idPerson);

		ResponseDTO responseDTO = iPersonService.eliminarPorId(idPerson);

		log.info("TERMINA ELIMINACION DE PERSONA");

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
}