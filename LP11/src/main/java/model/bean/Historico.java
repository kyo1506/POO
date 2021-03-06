package model.bean;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "historico")
public class Historico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @ManyToOne(targetEntity = Produto.class, optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private Produto produto;
    @Column(name = "qtdSolicitada", nullable = false)
    private Integer qtdSolicitada;
    @Column(name = "qtdAtual", nullable = false)
    private Integer qtdAtual;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private StatusHistorico statusHistorico;
    @Column(name = "dtInclusao", nullable = false, updatable = false, insertable = false)
    @CreationTimestamp
    private Timestamp dtInclusao;

    public Historico(Produto produto, Integer qtdSolicitada, Integer qtdAtual, StatusHistorico status) {
        this.produto = produto;
        this.qtdSolicitada = qtdSolicitada;
        this.qtdAtual = qtdAtual;
        this.statusHistorico = status;
    }
}
