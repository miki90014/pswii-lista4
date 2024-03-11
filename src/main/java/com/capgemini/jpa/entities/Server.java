package com.capgemini.jpa.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Server {

    @Id
    @SequenceGenerator(name = "SERVER_ID_GENERATOR", sequenceName = "SERVER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERVER_ID_GENERATOR")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ip;

    @Version
    @Column
    private Long version;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime lastUpdateDate;

    @Column(name = "is_active")
    private Boolean isActive = true;

    public Server(String name, String ip) {
        super();
        this.name = name;
        this.ip = ip;
        this.createdDate = LocalDateTime.now();
        this.lastUpdateDate = createdDate;
        this.isActive = true;
    }

    public Long getVersion(){
        return version;
    }

    public LocalDateTime getCreatedDate(){
        return createdDate;
    }

    public LocalDateTime getLastUpdateDate(){
        return lastUpdateDate;
    }

    @PostUpdate
    public void setLastUpdateDate() {
        lastUpdateDate = LocalDateTime.now();
    }
}
