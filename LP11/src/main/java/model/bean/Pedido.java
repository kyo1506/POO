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
@Table(name = "pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @ManyToOne(targetEntity = Cliente.class, optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private Cliente cliente;
<<<<<<< HEAD
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private StatusPedido statusPedido;
=======
>>>>>>> origin/main
    @Column(name = "dtInclusao", nullable = false, updatable = false, insertable = false)
    @CreationTimestamp
    private Timestamp dtInclusao;
}
