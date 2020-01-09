package com.fishky.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dictionary", schema = "Xx2w786u23", catalog = "")
@NoArgsConstructor
public class DictionaryEntity {
    private long idDictionary;
    private String name;
    private String language;
    private UserEntity user;
    private Set<TranslationEntity> translations = new HashSet<>();

    @Id
    @Column(name = "id_dictionary")
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

    @OneToMany(mappedBy = "dictionary")
    public Set<TranslationEntity> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<TranslationEntity> translations) {
        this.translations = translations;
    }

    public DictionaryEntity(int idDictionary, String language, String name, UserEntity user) {
        this.idDictionary = idDictionary;
        this.language = language;
        this.name = name;
        this.user = user;
    }

    public DictionaryEntity(String language, String name, UserEntity user) {
        this.language = language;
        this.name = name;
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
