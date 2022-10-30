package com.novare.natflix.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "OSCAR_WON")
    private Integer numberOfoscar;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(foreignKey = @ForeignKey(name = "MOVIE_CAT_ID"), name = "CATEGORY_ID", referencedColumnName = "ID")
    private ContentCategory category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(foreignKey = @ForeignKey(name = "MOVIE_CONT_ID"), name = "CONTENT_ID", referencedColumnName = "ID")
    private Content content;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "MOVIE_ADD_ID"), name = "ADDITIONAL_ID", referencedColumnName = "ID")
    private AdditionalDetails additional;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public AdditionalDetails getAdditional() {
        return additional;
    }

    public void setAdditional(AdditionalDetails additional) {
        this.additional = additional;
    }

    public Integer getNumberOfoscar() {
        return numberOfoscar;
    }

    public void setNumberOfoscar(Integer numberOfoscar) {
        this.numberOfoscar = numberOfoscar;
    }

    public ContentCategory getCategory() {
        return category;
    }

    public void setCategory(ContentCategory category) {
        this.category = category;
    }
}
