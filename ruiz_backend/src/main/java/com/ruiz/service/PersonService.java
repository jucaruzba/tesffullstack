package com.ruiz.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ruiz.model.dto.PersonDTO;
import com.ruiz.model.dto.PersonSaveDTO;
import com.ruiz.model.dto.ResponseDTO;
import com.ruiz.model.entity.PersonEntity;
import com.ruiz.repository.IPersonRepository;
import com.ruiz.util.GenericasConstantes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonService implements IPersonService {

	@Autowired
	private IPersonRepository iPersonRepository;

	@Override
	public ResponseDTO consultarTodos() {

		ResponseDTO responseDTO = new ResponseDTO();

		try {

			log.info("Consultando todas las personas");

			List<PersonEntity> lista = iPersonRepository.findAll();

			if (lista.isEmpty()) {
				return buildResponse(false, GenericasConstantes.NO_HAY_DATOS, Collections.emptyList());
			}

			return buildResponse(true, GenericasConstantes.CONSULTA_EXITOSA, lista);

		} catch (DataAccessException e) {

			log.error("Error al consultar personas", e);
			return buildResponse(false, GenericasConstantes.ERROR_INTERNO_DEL_SISTEMA, null);
		}
	}

	@Override
	public ResponseDTO consultaPorId(Integer idPerson) {

		try {

			log.info("Consultando persona con id: {}", idPerson);

			Optional<PersonEntity> optional = iPersonRepository.findById(idPerson);

			if (!optional.isPresent()) {
				return buildResponse(false, GenericasConstantes.NO_HAY_DATOS, null);
			}

			return buildResponse(true, GenericasConstantes.CONSULTA_EXITOSA, optional.get());

		} catch (DataAccessException e) {

			log.error("Error al consultar persona por id", e);
			return buildResponse(false, GenericasConstantes.ERROR_INTERNO_DEL_SISTEMA, null);
		}
	}

	@Override
	public ResponseDTO eliminarPorId(Integer idPerson) {

		try {

			log.info("Eliminando persona con id: {}", idPerson);

			if (!iPersonRepository.existsById(idPerson)) {
				return buildResponse(false, GenericasConstantes.NO_HAY_DATOS, null);
			}

			iPersonRepository.deleteById(idPerson);

			return buildResponse(true, GenericasConstantes.BORRADO_EXITOSO, null);

		} catch (DataAccessException e) {

			log.error("Error al eliminar persona", e);
			return buildResponse(false, GenericasConstantes.ERROR_INTERNO_DEL_SISTEMA, null);
		}
	}

	@Override
	public ResponseDTO guardar(PersonSaveDTO personSaveDTO) {

		try {

			log.info("Guardando nueva persona");

			PersonEntity entity = new PersonEntity();
			entity.setNombre(personSaveDTO.getNombre());
			entity.setApellido(personSaveDTO.getApellido());
			entity.setFechaNacimiento(personSaveDTO.getFechaNacimiento());
			entity.setPuesto(personSaveDTO.getPuesto());
			entity.setSueldo(personSaveDTO.getSueldo());

			PersonEntity guardado = iPersonRepository.save(entity);

			return buildResponse(true, GenericasConstantes.ALTA_EXITOSA, guardado);

		} catch (DataAccessException e) {

			log.error("Error al guardar persona", e);
			return buildResponse(false, GenericasConstantes.ERROR_INTERNO_DEL_SISTEMA, null);
		}
	}

	@Override
	public ResponseDTO actualizar(PersonDTO personDTO) {

		try {

			log.info("Actualizando persona con id: {}", personDTO.getId());

			Optional<PersonEntity> optional = iPersonRepository.findById(personDTO.getId());

			if (!optional.isPresent()) {
				return buildResponse(false, GenericasConstantes.NO_HAY_DATOS, null);
			}

			PersonEntity entity = optional.get();
			entity.setNombre(personDTO.getNombre());
			entity.setApellido(personDTO.getApellido());
			entity.setFechaNacimiento(personDTO.getFechaNacimiento());
			entity.setPuesto(personDTO.getPuesto());
			entity.setSueldo(personDTO.getSueldo());

			PersonEntity actualizado = iPersonRepository.save(entity);

			return buildResponse(true, GenericasConstantes.ACTUALIZACION_EXITOSA, actualizado);

		} catch (DataAccessException e) {

			log.error("Error al actualizar persona", e);
			return buildResponse(false, GenericasConstantes.ERROR_INTERNO_DEL_SISTEMA, null);
		}
	}

	/**
	 * Método helper para construir respuestas
	 */
	private ResponseDTO buildResponse(boolean status, String msg, Object data) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setStatus(status);
		responseDTO.setMsg(msg);
		responseDTO.setData(data);
		return responseDTO;
	}
}