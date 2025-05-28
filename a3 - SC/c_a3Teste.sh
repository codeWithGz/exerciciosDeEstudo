#!/bin/bash
op=0

function Screen(){

	clear

	echo -ne "\n\t\t\t      Menu\n\n"

	echo -ne "1) Contar Arquivos com String      6)  Exibir Informacoes do Sistema\n"

	echo -ne "2) Cadastrar Um Novo Usuario       7)  Exibir detalhes de Arquivo\n"

	echo -ne "3) Buscar Usuarios com String      8)  Exibir Total de Grupos Cadastrados\n"

	echo -ne "4) Buscar Grupos com String        9)  Gerenciar Organizacao\n"

	echo -ne "5) Verificar se IP esta Ativo      10) livre\n"

	echo -ne "\n11) Sair do Programa\n\n"

	echo -ne "Digite a Sua Opcao: \n"

}

#1
function countFiles(){

  read -p "Digite o caminho absoluto do diretório: " dir

  if [[ ! -d "$dir" ]]; then
    echo "Erro: O caminho informado não é um diretório válido."
    return 1
  fi

  read -p "Digite a string a ser buscada nos nomes dos arquivos: " string
  arquivos=$(find "$dir" -maxdepth 1 -type f -iname "*$string*")
  count=$(echo "$arquivos" | grep -c .)

  echo "---------------------------------------------------------------------"
  echo "Total de arquivos que contêm '$string' no nome: $count"

  if [[ $count -gt 0 ]]; then
    echo "Arquivos encontrados:"
    echo "$arquivos"
  fi

  read -p "Pressione ENTER para continuar..."
  clear

}

#2

function addUsers(){

    read -p "Digite o login do usuário: " login

    # Verifica se o usuário já existe no sistema
    if id "$login" &>/dev/null; then
        # Se o usuário já existir, exibe a mensagem
        echo "O usuário '$login' já está cadastrado no sistema."
	read -p "Pressione ENTER para continuar..."
    else
        # Se o usuário não existir, realiza o cadastro
        adduser "$login"
        # Mensagem de sucesso
        echo "O usuário '$login' foi cadastrado com sucesso."
        read -p "Pressione ENTER para continuar..."
    fi

}

#3

function searchUser(){

    read -p "Digite o login do usuário: " login

	if id "$login" &>/dev/null; then
	    # Se o usuário já existir, exibe a mensagem
	    echo "Usuario(os) Encontrado(os) "
	    cat /etc/passwd | grep "$login"
	    read -p "Pressione ENTER para continuar..."
	else
	    echo "Usuario(os) NAO Encontrado(os)"
	    read -p "Pressione ENTER para continuar..."
	fi

}

#4
function searchGroup(){

  read -p "Digite a string a ser buscada nos nomes dos arquivos: " string

  # Procura a string no arquivo /etc/group
  grupos_encontrados=$(grep "$string" /etc/group)

  if [[ -n "$grupos_encontrados" ]]; then
      echo "Grupo(s) Encontrado(s):"
      echo "$grupos_encontrados"
  else
      echo "Grupo(s) NÃO Encontrado(s)."
  fi

  read -p "Pressione ENTER para continuar..."

}

#5
function verifyIP(){

	# Solicita o IP a ser verificado
	read -p "Digite o IP para verificar: " ip
	# Verifica se o IP está ativo usando o comando ping
	ping -c 4 "$ip" &>/dev/null
	# Verifica o código de retorno do comando ping

	if [ $? -eq 0 ]; then
	    echo "IP Ativo"
	else
	    echo "IP Inativo"
	fi

}

#6
function sysInfo(){

	echo "=== INFORMAÇÕES DO SISTEMA ==="

	# Memória RAM livre
	echo -e "\nMemória RAM livre:"
	free | awk '/Mem:/ {print $4 " livres de " $2}'

	# Tipo de CPU (modelo)
	echo -e "\nModelo da CPU:"
	grep -m 1 "model name" /proc/cpuinfo | cut -d: -f2 | sed 's/^ //'

	# Espaço livre no disco rígido (HD)
	echo -e "\nEspaço livre no HD:"
	df -h / | awk 'NR==2 {print $4 " livres de " $2 " em " $1}'

	read -p "Pressione ENTER para continuar..."

}

#7
function fileInfo(){

	# Solicita o caminho absoluto e o nome do arquivo
	read -p "Digite o caminho absoluto do diretório: " caminho
	read -p "Digite o nome do arquivo: " arquivo

	# Concatena caminho e nome do arquivo
	caminho_completo="$caminho/$arquivo"

	# Verifica se o arquivo existe
	if [ -f "$caminho_completo" ]; then
	    echo "O arquivo existe. Atributos:"
	    ls -lh "$caminho_completo"
	    read -p "Pressione ENTER para continuar..."
	else
	    echo "Arquivo não existe em: $caminho_completo"
	    read -p "Pressione ENTER para continuar..."
	fi

}

#8
function showGroups(){

	# Contar número total de usuários (linhas no /etc/passwd)
	num_usuarios=$(cut -d: -f1 /etc/passwd | wc -l)

	# Contar número total de grupos (linhas no /etc/group)
	num_grupos=$(cut -d: -f1 /etc/group | wc -l)

	# Exibir resultados
	echo "Número total de usuários cadastrados: $num_usuarios"
	echo "Número total de grupos cadastrados: $num_grupos"

	# Perguntar ao usuário se deseja exibir os nomes
	read -p "Deseja exibir os grupos e usuários? (y/n): " resposta

	# Verificar resposta (aceita y ou Y)
	if [[ "$resposta" =~ ^[Yy]$ ]]; then
	    echo -e "\nUsuários:"
	    cut -d: -f1 /etc/passwd
	    echo -e "\nGrupos:"
	    cut -d: -f1 /etc/group
	    read -p "Pressione ENTER para continuar..."
	else
	    echo "Ok, pressione ENTER para continuar..."
	fi

}

#9
function manageOrg() {
	clear
	echo -e "O que deseja Gerenciar? \n"
	read -p "1) Usuario(s)      2) Grupo(s): " opt

	if [ "$opt" -eq 1 ]; then
		clear
		echo -e "O que deseja Fazer? \n"
		read -p "1) Consultar  2) Alterar  3) Remover: " uop

		if [ "$uop" -eq 1 ]; then
			echo -e "\nUsuários cadastrados:"
			cut -d: -f1 /etc/passwd
			read -p "Pressione ENTER para continuar..."
		fi

		if [ "$uop" -eq 2 ]; then
		    read -p "Digite o login do usuário que deseja alterar: " login
		    if id "$login" &>/dev/null; then
				read -p "Digite o novo nome de usuário: " novo_login
				usermod -l "$novo_login" "$login"
				echo "Nome de usuário alterado de '$login' para '$novo_login'."
		    else
				echo "O usuário '$login' não está cadastrado no sistema."
		    fi
		    read -p "Pressione ENTER para continuar..."
		fi

		if [ "$uop" -eq 3 ]; then
			read -p "Digite o login do usuário: " login
			if id "$login" &>/dev/null; then
				userdel -r "$login"
				echo "O usuário '$login' foi removido com sucesso."
			else
				echo "O usuário '$login' não está cadastrado no sistema."
			fi
			read -p "Pressione ENTER para continuar..."
		fi
	fi

	if [ "$opt" -eq 2 ]; then
		clear
		echo -e "O que deseja Fazer com grupos? \n"
		read -p "1) Consultar  2) Alterar  3) Remover: " gop

		if [ "$gop" -eq 1 ]; then
			echo -e "\nGrupos cadastrados:"
			cut -d: -f1 /etc/group
			read -p "Pressione ENTER para continuar..."
		fi

		if [ "$gop" -eq 2 ]; then
			read -p "Digite o nome do grupo que deseja alterar: " grupo
			if getent group "$grupo" &>/dev/null; then
				read -p "Digite o novo nome para o grupo: " novo_grupo
				groupmod -n "$novo_grupo" "$grupo"
				echo "Grupo '$grupo' renomeado para '$novo_grupo'."
			else
				echo "O grupo '$grupo' não existe."
			fi
			read -p "Pressione ENTER para continuar..."
		fi

		if [ "$gop" -eq 3 ]; then
			read -p "Digite o nome do grupo que deseja remover: " grupo
			if getent group "$grupo" &>/dev/null; then
				groupdel "$grupo"
				echo "Grupo '$grupo' removido com sucesso."
			else
				echo "O grupo '$grupo' não existe."
			fi
			read -p "Pressione ENTER para continuar..."
		fi
	fi
}

#10
function scheduleTask() {
    clear
    echo "=== Agendamento de Backup Semanal ==="

    # Solicita ao usuário os diretórios de origem e destino
    read -p "Digite o caminho absoluto da pasta a ser copiada (origem): " origem
    read -p "Digite o caminho absoluto da pasta onde o backup será salvo (destino): " destino

    # Valida os caminhos
    if [[ ! -d "$origem" ]]; then
        echo "Erro: Diretório de origem não existe."
        read -p "Pressione ENTER para continuar..."
        return
    fi

    if [[ ! -d "$destino" ]]; then
        echo "Destino não existe. Criando..."
        mkdir -p "$destino"
    fi

    # Cria o script de backup
    script_backup="$HOME/backup_semanal.sh"

    echo "#!/bin/bash" > "$script_backup"
    echo "timestamp=\$(date +\"%Y-%m-%d_%H-%M\")" >> "$script_backup"
    echo "destino_final=\"$destino/backup_\$timestamp.tar.gz\"" >> "$script_backup"
    echo "tar -czf \"\$destino_final\" -C \"$origem\" . " >> "$script_backup"
    echo "echo \"Backup realizado com sucesso em \$destino_final\"" >> "$script_backup"

    chmod +x "$script_backup"

    # Define o agendamento: Segunda-feira (1), 21:45
    agendamento="45 21 * * 1 $script_backup"

    # Adiciona ao crontab
    (crontab -l 2>/dev/null; echo "$agendamento") | crontab -

    echo -e "\nBackup agendado com sucesso!"
    echo "O backup da pasta '$origem' será salvo em '$destino' toda segunda-feira às 21:45."
    echo "Script criado: $script_backup"

    read -p "Pressione ENTER para continuar..."
}

while true; do
    Screen
    read op

    case $op in
        1) countFiles ;;
        2) addUsers ;;
        3) searchUser ;;
        4) searchGroup ;;
        5) verifyIP ;;
        6) sysInfo ;;
        7) fileInfo ;;
        8) showGroups ;;
        9) manageOrg ;;
        10) scheduleTask ;;
        11) echo "Saindo..." ; exit 0 ;;
        *) echo "Opcao invalida. Por favor, digite um numero de 1 a 11." ; read -p "Pressione ENTER para continuar..." ;;
    esac

done
