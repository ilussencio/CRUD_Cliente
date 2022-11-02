package com.ilussencio.CRUD_Cliente.services;

import com.ilussencio.CRUD_Cliente.dto.ClientDto;
import com.ilussencio.CRUD_Cliente.entities.Client;
import com.ilussencio.CRUD_Cliente.repositories.ClientRepository;
import com.ilussencio.CRUD_Cliente.services.exceptions.DatabaseException;
import com.ilussencio.CRUD_Cliente.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Transactional(readOnly = true)
    public Page<ClientDto> findAllPaged(PageRequest pageRequest){
        Page<Client> list = repository.findAll(pageRequest);
        return list.map(x -> new ClientDto(x));
    }
    @Transactional(readOnly = true)
    public ClientDto findById(Long id){
        Optional<Client> opt = repository.findById(id);
        Client entity = opt.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));
        return new ClientDto(entity);
    }
    @Transactional
    public ClientDto insert(ClientDto dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDto(entity);
    }
    public void copyDtoToEntity(ClientDto dto, Client entity){
        entity.setChildren(dto.getChildren());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setName(dto.getName());
        entity.setBirthDate(dto.getBirthDate());
    }
    @Transactional
    public ClientDto update(Long id, ClientDto dto) {
        try{
            Client entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDto(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Cliente com o id "+id+" não encontrado!");
        }
    }
    public void delete(Long id) {
        try{
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Cliente com o id "+id+" não encontrado!");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade do banco de dados");
        }
    }

}
