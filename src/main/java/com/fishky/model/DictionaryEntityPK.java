package com.fishky.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DictionaryEntityPK implements Serializable {
    private int idDictionary;
    private int dictionaryListIdDictionaryList;

    @Column(name = "id_dictionary")
    @Id
    public int getIdDictionary() {
        return idDictionary;
    }

    public void setIdDictionary(int idDictionary) {
        this.idDictionary = idDictionary;
    }

    @Column(name = "dictionary_list_id_dictionary_list")
    @Id
    public int getDictionaryListIdDictionaryList() {
        return dictionaryListIdDictionaryList;
    }

    public void setDictionaryListIdDictionaryList(int dictionaryListIdDictionaryList) {
        this.dictionaryListIdDictionaryList = dictionaryListIdDictionaryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictionaryEntityPK that = (DictionaryEntityPK) o;

        if (idDictionary != that.idDictionary) return false;
        if (dictionaryListIdDictionaryList != that.dictionaryListIdDictionaryList) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDictionary;
        result = 31 * result + dictionaryListIdDictionaryList;
        return result;
    }
}
