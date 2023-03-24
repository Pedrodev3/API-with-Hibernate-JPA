package br.com.fiap.smartcities.test;

import br.com.fiap.smartcities.entities.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/* Esse teste é para a consulta/busca de uma coluna de uma entidade, por exemplo. 
 * 
 * Não é necessário utilizar um método de transação pois não há nenhuma mudança feita
 * no banco, apenas consulta.
 * */
public class TesteBusca {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("smartcities");
		EntityManager em = fabrica.createEntityManager();
		
		// Cliente cliente = em.find(Cliente.class, 1);
		
		Cliente cliente = new Cliente(1, "Thiago");
		
		System.out.println(cliente.getId() + "" + cliente.getNome());
		
		em.merge(cliente);
	
		
		// Para o update
		// cliente.setNome("Henrique");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
