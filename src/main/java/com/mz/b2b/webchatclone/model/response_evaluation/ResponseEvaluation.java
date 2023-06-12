package com.mz.b2b.webchatclone.model.response_evaluation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Response_evaluation")
public class ResponseEvaluation implements Serializable {

    private static final long serialVersionUID = -5714483426111465L;

    @Id
    private String uuid;

    private String collection_name;

    private String original_message;

    private String bot_message;

    private int value;

}
