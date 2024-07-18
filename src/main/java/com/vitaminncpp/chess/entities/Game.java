package com.vitaminncpp.chess.entities;

import com.vitaminncpp.chess.model.enums.ChessResult;
import com.vitaminncpp.chess.model.enums.Player;
import lombok.*;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "games", uniqueConstraints = @UniqueConstraint(columnNames = "id"))

public class Game {
    @Id
    @Column(name = "id", table = "games")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "player_w", referencedColumnName = "id", nullable = false)
    private User playerW;

    @ManyToOne()
    @JoinColumn(name = "player_b", referencedColumnName = "id", nullable = false)
    private User playerB;

    @Column(name = "start_time", table = "games")
    private Instant startTime;

    @Column(name = "end_time", table = "games")
    private Instant endTime;

    @Column(name = "result", table = "games")
    @Enumerated(EnumType.STRING)
    private ChessResult result;

    @Column(name = "winner", table = "games")
    @Enumerated(EnumType.STRING)
    private Player winner;

    @OneToMany(targetEntity = Move.class, mappedBy = "game", cascade = CascadeType.ALL)
    private List<Move> moves;
}