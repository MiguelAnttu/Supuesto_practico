package edu.altair.examen.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.examen.dtos.ProductoRequestDto;
import edu.altair.examen.dtos.ProductoResponseDto;
import edu.altair.examen.services.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	private final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@GetMapping
	public ResponseEntity<List<ProductoResponseDto>> obtenerTodos() {
		return ResponseEntity.ok(productoService.obtenerTodos());
	}

	@PostMapping
	public ResponseEntity<ProductoResponseDto> crear(@RequestBody ProductoRequestDto requestDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.crear(requestDto));
	}

	@PutMapping("/codigo_sku/{codigo_sku}")
	public ResponseEntity<ProductoResponseDto> actualizarPorDni(@PathVariable String codigoSKU,
			@RequestBody ProductoRequestDto requestDto) {
		return ResponseEntity.ok(productoService.actualizarPorCodigo(codigoSKU, requestDto));
	}

	@DeleteMapping("/codigo_sku/{codigo_sku}")
	public ResponseEntity<Void> eliminarPorNumeroSS(@PathVariable String codigo_sku) {
		productoService.borrarPorCodigo(codigo_sku);
		return ResponseEntity.noContent().build();
	}
}
