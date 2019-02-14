package com.rpg.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionPlayer {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private Session session;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private Player player;
}


