package com.fishky.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "translation", schema = "Xx2w786u23", catalog = "")
@NoArgsConstructor
public class TranslationEntity {
    private long idTranslation;
    private String word;
    private String translated;
    private DictionaryEntity dictionary;

    @Id
    @Column(name = "id_translation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdTranslation() {
        return idTranslation;
    }

    public void setIdTranslation(long idTranslation) {
        this.idTranslation = idTranslation;
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
    @Column(name = "translated")
    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }

    @ManyToOne
    @JoinColumn(name = "dictionary_id_dictionary", nullable = false)
    public DictionaryEntity getDictionary() {
        return dictionary;
    }

    public void setDictionary(DictionaryEntity dictionary) {
        this.dictionary = dictionary;
    }

    public TranslationEntity(long idTranslation, String word, String translated, DictionaryEntity dictionary) {
        this.idTranslation = idTranslation;
        this.word = word;
        this.translated = translated;
        this.dictionary = dictionary;
    }

    public TranslationEntity(String word, String translated, DictionaryEntity dictionary) {
        this.word = word;
        this.translated = translated;
        this.dictionary = dictionary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TranslationEntity that = (TranslationEntity) o;

        if (idTranslation != that.idTranslation) return false;
        if (word != null ? !word.equals(that.word) : that.word != null) return false;
        if (translated != null ? !translated.equals(that.translated) : that.translated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idTranslation;
        result = 31 * result + (word != null ? word.hashCode() : 0);
        result = 31 * result + (translated != null ? translated.hashCode() : 0);
        return result;
    }
}
