package com.ruiz.service;

import com.ruiz.model.dto.PersonDTO;
import com.ruiz.model.dto.PersonSaveDTO;
import com.ruiz.model.dto.ResponseDTO;

/**
 * INTERFACE DE SERVICE DE PERSON
 * 
 * @author Juan Carlos Ruiz
 */
public interface IPersonService {
	
	/**
	 * Consultar todos
	 * 
	 * @return ResponseDTO
	 */
	public ResponseDTO  consultarTodos();
	
	/**
	 * Consultar todos
	 * 
	 * @return ResponseDTO
	 */
	public ResponseDTO consultaPorId(Integer idPerson);
	
	/**
	 * Delete por ID.
	 * 
	 * @param id
	 * @return ResponseDTO
	 */
	public ResponseDTO eliminarPorId(Integer idPerson);

	/**
	 * Alta
	 * 
	 * @param entity
	 * @return ResponseDTO
	 */
	public ResponseDTO guardar( PersonSaveDTO personSaveDTO);

	/**
	 * Actualiza
	 * 
	 * @param entity
	 * @return ResponseDTO
	 */
	public ResponseDTO actualizar(PersonDTO personDTO);

}
