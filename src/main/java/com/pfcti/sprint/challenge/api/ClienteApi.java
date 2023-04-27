package com.pfcti.sprint.challenge.api;

import com.pfcti.sprint.challenge.dto.ClienteDto;
import com.pfcti.sprint.challenge.dto.DesactivaClienteDto;
import com.pfcti.sprint.challenge.repository.ClienteRepository;
import com.pfcti.sprint.challenge.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteApi {

    @Autowired
    private ClienteService clienteService;


    @GetMapping(value = "/all")
    public List<ClienteDto> buscarTodosClientes(){
        return clienteService.obtenerClientes(); }

    @GetMapping("/{id}")
    public ClienteDto buscarCliente(@PathVariable int id){
        log.info("Busqueda de cliente : {}", id);
        return clienteService.obtenerClientesPorId(id); }

    @PostMapping
    public void guardarCliente(@RequestBody ClienteDto clienteDto){
        log.info("cliente de cliente : {}", clienteDto);
        clienteService.insertarCliente(clienteDto); }

    @PutMapping("/Contact")
    public void actualizarContactoCliente(@RequestBody ClienteDto clienteDto){
        log.info("cliente de cliente : {}", clienteDto);
        clienteService.actualizaContacto(clienteDto); }

    @PutMapping("/Desactivar")
    public void DesactivarCliente(@RequestBody DesactivaClienteDto desactivaClienteDto){
        log.info("cliente de cliente : {}", desactivaClienteDto);
        clienteService.desactivaCliente(desactivaClienteDto.getId()); }
}
