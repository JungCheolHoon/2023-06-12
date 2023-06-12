package com.mz.b2b.webchatclone.model.vectordb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class vectordb implements Serializable {

    private static final long serialVersionUID = -5714482763426116365L;

    @Id
    private String uuid;

    private String collection_name;

    private String file_name;

    private String source_file_path;

    @Temporal(TemporalType.TIMESTAMP)
    private Date create_time;

}
