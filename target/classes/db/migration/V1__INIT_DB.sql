CREATE TABLE client (
        id BIGSERIAL PRIMARY KEY,
        username VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL
);

CREATE TABLE note (
      id BIGSERIAL PRIMARY KEY,
      title VARCHAR(255),
      content TEXT,
      client BIGINT,
      FOREIGN KEY (client) REFERENCES client(id) ON DELETE CASCADE
);
