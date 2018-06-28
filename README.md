# Grules-Main-Server
Servidor principal de aplicação, responsável pela manipulação de dados e acesso ao banco e exposição dos métodos para as outras aplicações (PHP,C# e JAVA).

# grules-lib
Projeto onde estão presentes todas as classes utilizadas no sistema (Aluno, Apresentação, Evento), bem como seus atributos e métodos get/set.

# grules-soap-services
Projeto responsável pela camada de acesso ao banco de dados, nele estão as classes DAO (AlunoDAO, ApresentacaoDAO, EventoDAO) bem como todos os seus métodos de CRUD e métodos adicionais que foram utilizados pelas aplicações.

# grules-soap-server
Projeto que contém a persistência e a conexão com o banco de dados, bem como o Serviço Web SOAP que é responsável por expor todos os métodos para as outras aplicações utilizarem.
