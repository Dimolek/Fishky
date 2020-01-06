package com.fishky.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DictionaryListEntityPK implements Serializable {
    private int idDictionaryList;
    private int userIdUser;

    @Column(name = "id_dictionary_list")
    @Id
    public int getIdDictionaryList() {
        return idDictionaryList;
    }

    public void setIdDictionaryList(int idDictionaryList) {
        this.idDictionaryList = idDictionaryList;
    }

    @Column(name = "user_id_user")
    @Id
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

        DictionaryListEntityPK that = (DictionaryListEntityPK) o;

        if (idDictionaryList != that.idDictionaryList) return false;
        if (userIdUser != that.userIdUser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDictionaryList;
        result = 31 * result + userIdUser;
        return result;
    }
}
