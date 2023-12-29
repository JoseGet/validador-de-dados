CREATE TABLE credito (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   credit_code UUID NOT NULL,
   credit_value DECIMAL NOT NULL,
   day_first_installment date NOT NULL,
   number_of_installments INT NOT NULL,
   status SMALLINT,
   customer_id BIGINT,
   CONSTRAINT pk_credito PRIMARY KEY (id)
);

ALTER TABLE credito ADD CONSTRAINT uc_credito_credit_code UNIQUE (credit_code);

ALTER TABLE credito ADD CONSTRAINT FK_CREDITO_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES cliente (id);