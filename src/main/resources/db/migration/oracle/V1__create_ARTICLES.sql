CREATE TABLE article
(
    id           NUMBER GENERATED ALWAYS AS IDENTITY,
    source_id    VARCHAR2(1000),
    source_name  VARCHAR2(1000),
    author       VARCHAR2(1000),
    title        VARCHAR2(1000),
    description  VARCHAR2(1000),
    url          VARCHAR2(1000),
    url_to_image VARCHAR2(1000),
    published_at TIMESTAMP,
    content      VARCHAR2(1000),
    CONSTRAINT pk_article PRIMARY KEY (id)
);