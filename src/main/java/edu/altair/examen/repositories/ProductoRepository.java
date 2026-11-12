package edu.altair.examen.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.examen.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	Optional<Producto> actualizarPorCodigo(String codigoSKU);

	boolean borrarPorCodigo(String codigoSKU);

}
