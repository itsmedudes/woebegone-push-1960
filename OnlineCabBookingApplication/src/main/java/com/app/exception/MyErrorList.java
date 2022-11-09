package com.app.exception;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorList {
	private LocalDateTime localDateTime;
	private String message;
	private String details;
}
