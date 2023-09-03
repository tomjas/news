CREATE TABLE article
(
    id           INT NOT NULL,
    source_id    VARCHAR(1000),
    source_name  VARCHAR(1000),
    author       VARCHAR(1000),
    title        VARCHAR(1000),
    description  VARCHAR(1000),
    url          VARCHAR(1000),
    url_to_image VARCHAR(1000),
    published_at TIMESTAMP,
    content      VARCHAR(1000),
    PRIMARY KEY (id)
);