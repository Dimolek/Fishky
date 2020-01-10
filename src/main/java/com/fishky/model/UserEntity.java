package com.fishky.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "Xx2w786u23", catalog = "")
@NoArgsConstructor
public class UserEntity {
    private long idUser;
    private String username;
    private String password;
    private Timestamp createTime;
    private Set<DictionaryEntity> dictionaries = new HashSet<>();

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<DictionaryEntity> getDictionaries() {
        return dictionaries;
    }

    public void setDictionaries(Set<DictionaryEntity> dictionaries) {
        this.dictionaries = dictionaries;
    }

    public UserEntity(long idUser, String username, String password, Timestamp createTime) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
    }

    public UserEntity(String username, String password, Timestamp createTime) {
        this.username = username;
        this.password = password;
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (idUser != that.idUser) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idUser;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
