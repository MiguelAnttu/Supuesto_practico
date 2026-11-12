package edu.altair.examen.services;

import java.util.List;

import edu.altair.examen.dtos.ProductoRequestDto;
import edu.altair.examen.dtos.ProductoResponseDto;

public interface ProductoService {

	List<ProductoResponseDto> obtenerTodos();

	ProductoResponseDto crear(ProductoRequestDto RequestDto);

	ProductoResponseDto actualizarPorCodigo(String codigoSKU, ProductoRequestDto RequestDto);

	void borrarPorCodigo(String codigoSKU);
}
