package com.study.springboot.jpa.domin;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Table(name = "t_user")
@Entity
@Data
public class UserDO extends BaseDO implements Serializable {
    private static final long serialVersionUID = -7725172630743537933L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "address")
    private String address;


    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
