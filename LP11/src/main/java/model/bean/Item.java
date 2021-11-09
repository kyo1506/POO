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
@Table(name = "item")
public class Item implements Serializable {
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class ItemId implements Serializable{
        private Long idItem;
        private Long idPedido;
        private Long idProduto;
    }
    @EmbeddedId
    private ItemId id;
    private Integer quantidade;
    @Column(name = "dtInclusao", nullable = false, updatable = false, insertable = false)
    @CreationTimestamp
    private Timestamp dtInclusao;
}
