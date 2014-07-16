package models;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Juarez on 15/07/2014.
 */
@Entity
@Table(name="visitantes")
public class VisitanteEntity extends BasicEntity<VisitanteEntity> implements Serializable {

    @Id
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="pais")
    private String pais;
    @Column(name="num_visitante")
    private Integer num_visitante;
    @Column(name="online")
    private Integer online;
    @Column(name="page_views")
    private Integer page_views;

    public VisitanteEntity() {
        super(VisitanteEntity.class);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getNum_visitante() {
        return num_visitante;
    }

    public void setNum_visitante(Integer num_visitante) {
        this.num_visitante = num_visitante;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getPage_views() {
        return page_views;
    }

    public void setPage_views(Integer page_views) {
        this.page_views = page_views;
    }



}
