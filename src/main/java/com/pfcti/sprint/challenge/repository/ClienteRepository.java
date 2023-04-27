package com.pfcti.sprint.challenge.repository;

import com.pfcti.sprint.challenge.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {

    Cliente findClientesById(int id);

    @Modifying
    @Query(value = "update Cliente c set c.paisRecidencia =:paisRecidencia, c.direccion =:direccion, c.telefono =:telefono  where c.id =:id")
    void actualizaContactoCliente(String paisRecidencia, String direccion, String telefono, int id);

    @Modifying
    @Query(value = "update Cliente c set c.estado =:estado where c.id =:id")
    void desactivaCliente(Boolean estado, int id);
}
