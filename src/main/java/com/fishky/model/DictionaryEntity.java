package com.fishky.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dictionary")
@NoArgsConstructor
public class DictionaryEntity {
    private long idDictionary;
    private String name;
    private String language;
    private UserEntity user;
    private Set<TranslationEntity> translations;

    @Id
    @Column(name = "id_dictionary")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdDictionary() {
        return idDictionary;
    }

    public void setIdDictionary(long idDictionary) {
        this.idDictionary = idDictionary;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @ManyToOne
    @JoinColumn(name = "user_id_user", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "dictionary", cascade = CascadeType.ALL)
    public Set<TranslationEntity> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<TranslationEntity> translations) {
        this.translations = translations;
    }

    public DictionaryEntity(long idDictionary, String name, String language, UserEntity user) {
        this.idDictionary = idDictionary;
        this.name = name;
        this.language = language;
        this.user = user;
    }

    public DictionaryEntity(String name, String language, UserEntity user) {
        this.name = name;
        this.language = language;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictionaryEntity that = (DictionaryEntity) o;

        if (idDictionary != that.idDictionary) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idDictionary;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
