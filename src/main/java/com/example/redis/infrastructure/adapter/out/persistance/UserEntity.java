package com.example.redis.infrastructure.adapter.out.persistance;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@Entity
@Table(
        name = "users",
        indexes = {
                @Index(name = "idx_users_dni", columnList = "dni")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, unique = true, length = 20)
    private String dni;

    @Column(name = "date_created", nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @Column(name = "last_update", nullable = false)
    private OffsetDateTime lastUpdate;

    @PrePersist
    protected void onCreate() {
        OffsetDateTime now = OffsetDateTime.now(ZoneId.of("UTC"));
        this.dateCreated = now;
        this.lastUpdate = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdate = OffsetDateTime.now(ZoneId.of("UTC"));
    }
}