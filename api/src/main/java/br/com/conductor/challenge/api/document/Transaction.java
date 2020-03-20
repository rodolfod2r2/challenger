package br.com.conductor.challenge.api.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Transaction {

    @Id
    String id;
    String data;
    String name;
    String state;
    String bravely;
    String low;

}
