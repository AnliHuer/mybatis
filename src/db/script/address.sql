CREATE TABLE account
(
      account_id SERIAL PRIMARY KEY,
      account_name CHARACTER VARYING(255) NOT NULL,
      address_id BIGINT
);

CREATE TABLE address 
(
      address_id SERIAL PRIMARY KEY,
      street_name CHARACTER VARYING(255) NOT NULL
);

INSERT INTO 
address(street_name)
VALUES
('chengdu');

INSERT INTO 
address(street_name)
VALUES
('pune');


INSERT INTO
account(account_name, address_id)
VALUES
('yang', 1);