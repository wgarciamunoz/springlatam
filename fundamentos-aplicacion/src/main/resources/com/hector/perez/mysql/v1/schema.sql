DROP TABLE IF EXISTS libro;
CREATE TABLE libro
(
    id                 int auto_increment not null,
    titulo             varchar(70)        not null,
    isbn               varchar(17)        not null,
    edicion            int                not null,
    fecha_publicacion date               not null,
    capitulos          int                not null,
    paginas            int                not null,
    PRIMARY KEY (id)
) ENGINE = Innodb;
