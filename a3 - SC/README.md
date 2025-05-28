# 🖥️ Script Bash de Administração do Sistema

Este script em **Bash** oferece um menu interativo com várias funcionalidades administrativas para sistemas baseados em Linux. É voltado para **gestores de sistema**, **usuários avançados** ou **estudantes de administração de sistemas**.

## 📋 Funcionalidades

### Menu Principal
O usuário é apresentado a um menu com 11 opções, cada uma executando uma função específica do sistema:

```
1) Contar Arquivos com String         6) Exibir Informações do Sistema
2) Cadastrar Um Novo Usuário          7) Exibir Detalhes de Arquivo
3) Buscar Usuários com String         8) Exibir Total de Grupos Cadastrados
4) Buscar Grupos com String           9) Gerenciar Organização (Usuários e Grupos)
5) Verificar se IP está Ativo         10) Agendar Backup Semanal
                                       
11) Sair do Programa
```

## 🔧 Detalhamento das Funções

### 1. `countFiles`
Conta e lista os arquivos em um diretório cujo nome contém uma determinada string.

### 2. `addUsers`
Cadastra um novo usuário no sistema usando `adduser`. Verifica se o login já existe antes.

### 3. `searchUser`
Busca usuários cujo nome contenha uma string informada, consultando `/etc/passwd`.

### 4. `searchGroup`
Busca grupos com nomes que contenham uma string, verificando o arquivo `/etc/group`.

### 5. `verifyIP`
Verifica se um IP está ativo usando o comando `ping`.

### 6. `sysInfo`
Exibe:
- Memória RAM livre
- Modelo da CPU
- Espaço livre em disco

### 7. `fileInfo`
Mostra os atributos (permissões, tamanho, data) de um arquivo específico informado pelo usuário.

### 8. `showGroups`
Exibe a quantidade total de usuários e grupos cadastrados no sistema. O usuário pode optar por listar todos os nomes.

### 9. `manageOrg`
Permite consultar, alterar ou remover:
- Usuários (via `usermod`, `userdel`)
- Grupos (via `groupmod`, `groupdel`)

### 10. `scheduleTask` – Agendamento de Backup
Agenda um **backup automático semanal** com `crontab`:
- Solicita diretórios de origem e destino.
- Cria um script `backup_semanal.sh` no diretório pessoal do usuário.
- O backup é realizado **toda segunda-feira às 21:45**.
- Gera um arquivo `.tar.gz` com timestamp no nome.

### 11. Sair
Encerra o script.

---

## ▶️ Como Usar

1. Salve o script em um arquivo, por exemplo: `sistema.sh`
2. Torne-o executável:

```bash
chmod +x sistema.sh
```

3. Execute com permissões adequadas (algumas funções requerem `sudo`):

```bash
./sistema.sh
```

---

## ⚠️ Requisitos

- Shell Bash
- Permissões de root para ações como:
  - Criação/remoção de usuários e grupos
  - Agendamento via `crontab`
  - Uso de `adduser`, `usermod`, `userdel`, `groupmod`, `groupdel`

---

## 📂 Exemplo de Script de Backup Criado

```bash
#!/bin/bash
timestamp=$(date +"%Y-%m-%d_%H-%M")
destino_final="/caminho/do/destino/backup_$timestamp.tar.gz"
tar -czf "$destino_final" -C "/caminho/da/origem" .
echo "Backup realizado com sucesso em $destino_final"
```

---

## 🧠 Sugestões de Melhoria Futuras

- Adicionar logs em arquivo
- Suporte a interface de menu em `dialog`/`whiptail`
- Validação de IPs e caminhos mais robusta
- Adicionar opção para restaurar backups

---

## 📜 Licença

Este script é de uso livre para fins educacionais e administrativos. Não há garantia de estabilidade em ambientes de produção. Use com cautela.
