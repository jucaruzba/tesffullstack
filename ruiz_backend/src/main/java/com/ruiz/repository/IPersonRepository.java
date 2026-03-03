package com.ruiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ruiz.model.entity.PersonEntity;

/**
 *Interface Repository
 * 
 * @author Juan Carlos Ruiz
 * 
 */
public interface IPersonRepository extends JpaRepository<PersonEntity, Integer> {

}
