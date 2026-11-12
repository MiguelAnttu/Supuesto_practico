package edu.altair.examen.dtos;

import java.time.LocalDate;

public record ProductoResponseDto(Long id, String codigoSKU, String nombre, String descripcion, float precio, int stock,
		LocalDate fechaAlta) {

}
