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
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private StatusAtivo statusAtivo;
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name = "senha", nullable = false, length = 100)
    private String senha;
    @Column(name = "endereco", nullable = false, length = 25)
    private String endereco;
    @Column(name = "bairro", nullable = false, length = 20)
    private String bairro;
    @Column(name = "cidade", nullable = false, length = 20)
    private String cidade;
    @Column(name = "cep", nullable = false, length = 9)
    private String cep;
    @Column(name = "uf", nullable = false, length = 2)
    private String uf;
    @Column(name = "telefone", length = 13)
    private String telefone;
    @Column(name = "celular", length = 14)
    private String celular;
    @Column(name = "dtInclusao", nullable = false, updatable = false, insertable = false)
    @CreationTimestamp
    private Timestamp dtInclusao;
}
