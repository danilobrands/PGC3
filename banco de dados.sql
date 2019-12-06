create database gamehateos;

create user 'hateos'@'localhost' identified by 'hate0s';

grant all privileges on hateos.* to 'hateos'@'localhost';

  use gamehateos;

  create table tb_skin(
    idSkin    int not null auto_increment,
    nome      varchar(20),
    imagem    varchar(100),

    constraint pk_skin primary key (idSkin)
  );

  create table tb_usuario(
    idUsuario   int not null auto_increment,
    nome        varchar(100),
    email       varchar(100),
    senha       varchar(20),

    constraint pk_usuario primary key (idUsuario)
  );

  create table tb_personagem(
    idPersonagem  int not null auto_increment,
    nick          varchar(20),
    forca         int,
    agilidade     int,
    idUsuario     int not null,

    constraint pk_personagem primary key (idPersonagem),
    constraint fk_usuario foreign key (idUsuario) references tb_usuario(idUsuario)
  );

  create table tb_skin_personagem(
    idSkin        int not null,
    idPersonagem  int not null,

    constraint pk_sp primary key (idSkin,idPersonagem),
    constraint fk_sk foreign key (idSkin) references tb_skin(idSkin),
    constraint fk_pe foreign key (idPersonagem) references tb_personagem(idPersonagem)
  );


  insert into tb_usuario values (null, 'Danilo', 'danilobrands@hotmail.com', '123');
  insert into tb_usuario values (null, 'test', 'test@gmail.com', '123');
  insert into tb_usuario values (null, 'Monalisa', 'mona@ouotlook.com', '123');




  private int id;
  private String nick;
  private int forca;
  private int agilidade;
  private List<Skin> skins;

  private int id;
  private String image;

  private int id;
  private String nome;
  private String email;
  private String senha;
  private List<Personagem> personagens;
