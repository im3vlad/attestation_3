CREATE TABLE IF NOT EXISTS UserEntity (
                                          id UUID PRIMARY KEY,
                                          username VARCHAR(255) NOT NULL,
                                          login VARCHAR(255) NOT NULL,
                                          password VARCHAR(255) NOT NULL,
                                          birth_date DATE,
                                          number_phone INTEGER,
                                          order_number INTEGER
);

CREATE TABLE IF NOT EXISTS OrderEntity (
                                           id BIGINT PRIMARY KEY,
                                           order_id UUID NOT NULL,
                                           user_id UUID NOT NULL,
                                           order_number INTEGER NOT NULL,
                                           total_price DECIMAL(10, 2) NOT NULL,
                                           CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES UserEntity (id)
);
