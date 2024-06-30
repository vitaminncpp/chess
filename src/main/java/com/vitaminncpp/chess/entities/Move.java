package com.vitaminncpp.chess.entities;

import com.vitaminncpp.chess.model.enums.ChessPiece;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;


@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "moves", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Move {
    @Id
    @Column(name = "id", unique = true, nullable = false, table = "moves")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(targetEntity = Game.class)
    @JoinColumn(name = "game", referencedColumnName = "id", nullable = false)
    private Game game;

    @Column(name = "name", table = "moves", nullable = false)
    private String name;

    @Column(name = "src_x", nullable = false, table = "moves")
    private int srcX;

    @Column(name = "src_y", nullable = false, table = "moves")
    private int srcY;
    @Column(name = "dest_x", nullable = false, table = "moves")
    private int destX;
    @Column(name = "dest_y", nullable = false, table = "moves")
    private int destY;

    @Column(name = "turn", nullable = false, table = "moves")
    private boolean turn;
    @Column(name = "piece", nullable = false, table = "moves")
    private ChessPiece piece;
    @Column(name = "start_time", nullable = false, table = "moves")
    private Instant startTime;
    @Column(name = "end_time", nullable = false, table = "moves")
    private ChessPiece endTime;
    @Column(name = "duration", nullable = false, table = "moves")
    private long duration;
}