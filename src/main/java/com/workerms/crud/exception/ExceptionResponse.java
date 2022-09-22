package com.workerms.crud.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 75272025816552410L;

	private LocalDateTime dtimestamp;
	private String message;
	private String details;

}
