package com.ruiz.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *DTO  Response DTO 
 * 
 * @author Juan Carlos Ruiz
 * 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private boolean status;
    private String msg;
    private Object data;

}
