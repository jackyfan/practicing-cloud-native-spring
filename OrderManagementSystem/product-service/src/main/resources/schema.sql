
DROP TABLE IF EXISTS product;
CREATE TABLE product (
  id                  BIGSERIAL PRIMARY KEY NOT NULL,
  sku                varchar(255) UNIQUE NOT NULL,
  price               float8 NOT NULL,
  name               varchar(255) NOT NULL,
  created_date        timestamp NOT NULL,
  last_modified_date  timestamp NOT NULL,
  version             integer NOT NULL

);