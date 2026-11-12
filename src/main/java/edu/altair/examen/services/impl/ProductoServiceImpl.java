package edu.altair.examen.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.altair.examen.dtos.ProductoRequestDto;
import edu.altair.examen.dtos.ProductoResponseDto;
import edu.altair.examen.entities.Producto;
import edu.altair.examen.exceptions.ResourceNotFoundException;
import edu.altair.examen.repositories.ProductoRepository;
import edu.altair.examen.services.ProductoService;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

	private ProductoRepository productoRepository;

	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	private ProductoResponseDto toDto(Producto p) {
		return new ProductoResponseDto(p.getId(), p.getCodigoSKU(), p.getNombre(), p.getDescripcion(), p.getPrecio(),
				p.getStock(), p.getFechaAlta());
	}

	private void mapToEntity(ProductoRequestDto dto, Producto p) {
		p.setNombre(dto.nombre());
		p.setDescripcion(dto.descripcion());
		p.setCodigoSKU(dto.codigoSKU());
		p.setFechaAlta(dto.fechaAlta());
		p.setStock(dto.stock());
		p.setPrecio(dto.precio());

	}

	@Override
	public List<ProductoResponseDto> obtenerTodos() {
		return productoRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
	}

	@Override
	public ProductoResponseDto crear(ProductoRequestDto RequestDto) {
		Producto p = new Producto();
		mapToEntity(RequestDto, p);

		return toDto(productoRepository.save(p));
	}

	@Override
	public ProductoResponseDto actualizarPorCodigo(String codigoSKU, ProductoRequestDto RequestDto) {
		Producto p = productoRepository.actualizarPorCodigo(codigoSKU)
				.orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con producto: " + codigoSKU));
		mapToEntity(RequestDto, p);
		return toDto(productoRepository.save(p));

	}

	@Override
	public void borrarPorCodigo(String codigoSKU) {
		if (productoRepository.borrarPorCodigo(codigoSKU))
			throw new ResourceNotFoundException("Producto no borrado con codigo: " + codigoSKU);
		productoRepository.borrarPorCodigo(codigoSKU);
	}

}
