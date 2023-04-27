package com.pfcti.sprint.challenge.service;

import com.pfcti.sprint.challenge.dto.ClienteDto;
import com.pfcti.sprint.challenge.model.Cliente;
import com.pfcti.sprint.challenge.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;


    public List<ClienteDto> obtenerClientes() {
        List<ClienteDto> clienteDtoList = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findAll();

        clientes.forEach(cliente -> {
            clienteDtoList.add(fromClientetoClienteTdo(cliente));
        });

        return clienteDtoList;
    }

    public ClienteDto obtenerClientesPorId(int id) {
        Cliente cliente = clienteRepository.findClientesById(id);
        return fromClientetoClienteTdo(cliente);
    }


    public void insertarCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setNombres(clienteDto.getNombres());
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setEstado(clienteDto.getEstado());
        cliente.setIdentificacion(clienteDto.getIdentificacion());
        cliente.setPaisNacimiento(clienteDto.getPaisNacimiento());
        cliente.setPaisRecidencia(clienteDto.getPaisRecidencia());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);
    }

    public void actualizaContacto(ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.findById(clienteDto.getId())
                .orElseThrow(() -> {
                            throw new RuntimeException("NO Existe el cliente");
                        }
                );
        clienteRepository.actualizaContactoCliente(clienteDto.getPaisRecidencia(), clienteDto.getDireccion(),clienteDto.getTelefono(),clienteDto.getId());
    }

    public void desactivaCliente(int id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> {
                            throw new RuntimeException("NO Existe el cliente");
                        }
                );
        clienteRepository.desactivaCliente(false,id);
    }

    private ClienteDto fromClientetoClienteTdo(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }
}
