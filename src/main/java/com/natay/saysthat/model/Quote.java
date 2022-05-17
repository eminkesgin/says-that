package com.natay.saysthat.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Quote")
public class Quote {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long quoteId;

    @Column(name = "QuoteId")
    private Long id;
    private String source;
    private String quote;

    @CreatedDate
    private Instant createdDate;

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", quoteId=" + quoteId +
                ", source='" + source + '\'' +
                ", quote='" + quote + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
