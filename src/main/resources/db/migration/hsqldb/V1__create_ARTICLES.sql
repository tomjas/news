CREATE TABLE article
(
    id           INT NOT NULL,
    source_id    VARCHAR(200),
    source_name  VARCHAR(200),
    author       VARCHAR(200),
    title        VARCHAR(200),
    description  VARCHAR(200),
    url          VARCHAR(200),
    url_to_image VARCHAR(200),
    published_at TIMESTAMP,
    content      VARCHAR(200),
    PRIMARY KEY (id)
);