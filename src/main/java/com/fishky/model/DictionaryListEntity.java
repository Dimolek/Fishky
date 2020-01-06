package com.fishky.model;

import javax.persistence.*;

@Entity
@Table(name = "dictionary_list", schema = "Xx2w786u23", catalog = "")
@IdClass(DictionaryListEntityPK.class)
public class DictionaryListEntity {
    private int idDictionaryList;
    private String name;
    private String language;
    private int userIdUser;

    @Id
    @Column(name = "id_dictionary_list")
    public int getIdDictionaryList() {
        return idDictionaryList;
    }

    public void setIdDictionaryList(int idDictionaryList) {
        this.idDictionaryList = idDictionaryList;
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

    @Id
    @Column(name = "user_id_user")
    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictionaryListEntity that = (DictionaryListEntity) o;

        if (idDictionaryList != that.idDictionaryList) return false;
        if (userIdUser != that.userIdUser) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDictionaryList;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + userIdUser;
        return result;
    }
}
