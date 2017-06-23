package br.com.irrfweb.dao;

import br.com.irrfweb.model.Calculo;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CalculoDAO {

    private final EntityManager manager;

    public CalculoDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IRRFWebPU");
        this.manager = emf.createEntityManager();
    }

    public boolean gravar(Calculo calculo) throws Exception {
        try {
            manager.getTransaction().begin();
            manager.persist(calculo);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("==>"+e.getMessage());
            manager.getTransaction().rollback();
            throw new Exception("Erro ao Gravar "+e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<Calculo> getCalculosDia(Date data) {
        return manager.createQuery("from Calculo c where c.dataCalculo = :ano")
                .setParameter("ano", data)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Calculo> getAllCalculos() {
        return manager.createQuery("from Calculo").getResultList();
    }

    @SuppressWarnings("unchecked")
    public Long getQTDECalculo() {
        return (Long) manager.createQuery("select count(c) from Calculo c").getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public int limpaHistorico() {
        return (int) manager.createNativeQuery("delete from Calculo").executeUpdate();
    }

   
}
