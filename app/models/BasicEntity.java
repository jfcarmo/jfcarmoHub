package models;

import play.db.jpa.JPA;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Vidmar on 04/07/2014.
 */
public class BasicEntity<T> {

    private Class<T> tipo;

    protected BasicEntity(Class<T> tipo) {
        this.tipo = tipo;
    }

    public void save(){

        JPA.em().merge(this);

        JPA.em().flush();




    }

    public T findById(Object id){
        return JPA.em().find(tipo ,id);
    }

    public T executeSingleResQuery(String name, Object... params) {

        Query q = JPA.em().createNamedQuery(name);

        for (int i = 0; i < params.length; i = i + 2) {

            q.setParameter((String) params[i], params[i + 1]);

        }

        List<T> resposta = q.getResultList();

        if (resposta != null && resposta.size() > 0) {

            return resposta.get(0);

        } else {

            return null;

        }

    }

    public List<T> findAll() {

        Query q = JPA.em().createQuery("from " + tipo.getName());
        return q.getResultList();

    }
}
