package com.fishky.model;

import javax.persistence.*;

@Entity
@Table(name = "dictionary", schema = "Xx2w786u23", catalog = "")
@IdClass(DictionaryEntityPK.class)
public class DictionaryEntity {
    private int idDictionary;
    private String word;
    private String translation;
    private int dictionaryListIdDictionaryList;

    @Id
    @Column(name = "id_dictionary")
    public int getIdDictionary() {
        return idDictionary;
    }

    public void setIdDictionary(int idDictionary) {
        this.idDictionary = idDictionary;
    }

    @Basic
    @Column(name = "word")
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Basic
    @Column(name = "translation")
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Id
    @Column(name = "dictionary_list_id_dictionary_list")
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

        DictionaryEntity that = (DictionaryEntity) o;

        if (idDictionary != that.idDictionary) return false;
        if (dictionaryListIdDictionaryList != that.dictionaryListIdDictionaryList) return false;
        if (word != null ? !word.equals(that.word) : that.word != null) return false;
        if (translation != null ? !translation.equals(that.translation) : that.translation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDictionary;
        result = 31 * result + (word != null ? word.hashCode() : 0);
        result = 31 * result + (translation != null ? translation.hashCode() : 0);
        result = 31 * result + dictionaryListIdDictionaryList;
        return result;
    }
}
