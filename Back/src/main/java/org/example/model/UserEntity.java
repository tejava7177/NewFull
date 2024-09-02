package org.example.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // 데이터베이스의 'users' 테이블과 매핑
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성되는 ID (Primary Key)
    private Long id;

    @Column(nullable = false, unique = true) // 유니크한 'username' 컬럼 (Null 불가)
    private String username;

    @Column(nullable = false, unique = true) // 유니크한 'email' 컬럼 (Null 불가)
    private String email;

    @Column(nullable = false) // 비밀번호 컬럼 (Null 불가)
    private String password;

    // 기본 생성자
    public UserEntity() {
    }

    // 모든 필드를 사용하는 생성자
    public UserEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
