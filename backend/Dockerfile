# Use a imagem oficial do MySQL como base
FROM mysql:latest

# Defina as variáveis de ambiente para o MySQL
ENV MYSQL_ROOT_PASSWORD=admin
ENV MYSQL_DATABASE=ahoy_database
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=admin

# Copie o arquivo SQL de inicialização para a pasta de inicialização do MySQL
COPY ./init.sql /docker-entrypoint-initdb.d/

# Porta em que o MySQL estará disponível (opcional, o padrão é 3306)
# EXPOSE 3306
