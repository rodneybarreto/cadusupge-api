insert into funcao(nome) values('ADMINISTRADOR');
insert into funcao(nome) values('USUARIO_COMUM');

insert into papel(descricao,funcao_id) values('Lider de equipe',1);
insert into papel(descricao,funcao_id) values('Analista de negócio',1);
insert into papel(descricao,funcao_id) values('Consultor',1);
insert into papel(descricao,funcao_id) values('Atendimento ao público',2);
insert into papel(descricao,funcao_id) values('Técnico de suporte TI',2);

insert into usuario(nome,cpf,data_nascimento,genero,funcao_id) values('Rodney Barreto','72116005353','1976-07-13','MASCULINO',1);
insert into usuario(nome,cpf,data_nascimento,genero,funcao_id) values('Barreto Rodney','22893527051','1980-02-25','MASCULINO',2);
