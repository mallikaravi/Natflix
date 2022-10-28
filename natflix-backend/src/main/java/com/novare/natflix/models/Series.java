package com.novare.natflix.models;

import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(foreignKey = @ForeignKey(name = "SERIES_CAT_ID"), name = "CATEGORY_ID", referencedColumnName = "ID")
    private ContentCategory category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "SERIES_ADD_ID"), name = "ADDITIONAL_ID", referencedColumnName = "ID")
    private AdditionalDetails additional;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "SER_CONTENT_ID"), name = "CONTENT_ID", referencedColumnName = "ID")
    private Content content;

    @OneToMany(mappedBy = "series", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Seasons> seasons;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AdditionalDetails getAdditional() {
        return additional;
    }

    public void setAdditional(AdditionalDetails additional) {
        this.additional = additional;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Set<Seasons> getSeasons() {
        return seasons;
    }

    public void setSeasons(Set<Seasons> seasons) {
        this.seasons = seasons;
    }

    public ContentCategory getCategory() {
        return category;
    }

    public void setCategory(ContentCategory category) {
        this.category = category;
    }
}
