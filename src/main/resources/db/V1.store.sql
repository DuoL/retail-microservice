CREATE TABLE store
(
  store_id      BIGINT(20)      NOT NULL    AUTO_INCREMENT  COMMENT 'Auto increment generated',
  store_name    VARCHAR (128)   NOT NULL                    COMMENT 'Store name',
  PRIMARY KEY(store_id)
)

CREATE TABLE product
(
  product_id    BIGINT(20)      NOT NULL    AUTO_INCREMENT  COMMENT 'Auto increment generated',
  product_name  VARCHAR (128)   NOT NULL                    COMMENT 'Product name',
  description   VARCHAR (1024)  DEFAULT NULL                COMMENT 'The description of a product',
  sku           VARCHAR(128)    DEFAULT ''                  COMMENT 'sku',
  price         INT(20)         NOT NULL                    COMMENT 'price',
  order_id      BIGINT(20)      NOT NULL                    COMMENT 'Foreign Key',
  store_id      BIGINT(20)      NOT NULL                    COMMENT 'Foreign Key',
  PRIMARY KEY(product_id)
)

CREATE TABLE stock
(
  stock_id      BIGINT(20)      NOT NULL    AUTO_INCREMENT  COMMENT 'Auto increment generated',
  product_id    BIGINT(20)      NOT NULL                    COMMENT 'Foreign key',
  store_id      BIGINT(20)      NOT NULL                    COMMENT 'Foreign key',
  count         BIGINT(20)      DEFAULT '0'                 COMMENT 'count',
  PRIMARY KEY(stock_id)
)

CREATE TABLE order
(
  order_id      BIGINT(20)      NOT NULL    AUTO_INCREMENT  COMMENT 'Auto increment generated',
  store_id      BIGINT(20)      NOT NULL                    COMMENT 'Foreign key',
  order_date    DATETIME        NOT NULL                    DEFAULT CURRENT_TIMESTAMP COMMENT 'order date',
  first_name    VARCHAR(128)    NOT NULL                    COMMENT 'first name',
  last_name     VARCHAR(128)    NOT NULL                    COMMENT 'last name',
  email         VARCHAR(128)    NOT NULL                    COMMENT 'email',
  phone         VARCHAR(128)    NOT NULL                    COMMENT 'phone',
  PRIMARY KEY(order_id)
)