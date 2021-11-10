package model.bean;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "descricao", nullable = false, length = 30)
    private String descricao;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private StatusAtivo statusAtivo;
    @Column(name = "preco", nullable = false)
    private BigDecimal preco;
    @Column(name = "qtd", nullable = false)
    private Integer qtd;
    @Column(name = "dtInclusao", nullable = false, updatable = false, insertable = false)
    @CreationTimestamp
    private Timestamp dtInclusao;
}
