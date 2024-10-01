package org.acme.services;

import java.util.List;

import org.acme.entities.Client;
import org.acme.repositories.ClientRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClientService {

	@Inject 
	private ClientRepository repository;
	
	public List<Client> findAll() {
		List<Client> list = repository.findAll().list();
		return list;
	}
	
	public Client findById(Long id) {
		Client client = repository.findById(id);
		return client;
	}
	
	@Transactional
	public void insert(Client obj) {
		 repository.persist(obj);
	}
	
	@Transactional
	public void update(Client obj, Long id) {
		Client client = repository.findById(id);
		client.setName(obj.getName());
		repository.persist(client);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
