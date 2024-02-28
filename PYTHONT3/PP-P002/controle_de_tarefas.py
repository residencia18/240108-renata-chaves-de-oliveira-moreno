import os
import json

class ToDoList:
    def __init__(self, filename="tasks.json"):
        self.filename = filename
        self.tasks = self.load_tasks()

    def load_tasks(self):
        # Carrega as tarefas a partir do arquivo JSON se o arquivo existir
        if os.path.exists(self.filename):
            with open(self.filename, 'r') as file:
                tasks = json.load(file)
            return tasks
        else:
            return []

    def save_tasks(self):
        # Salva as tarefas no arquivo JSON
        with open(self.filename, 'w') as file:
            json.dump(self.tasks, file, indent=2)

    def list_tasks(self):
        print("\nLista de Tarefas:")
        for task in self.tasks:
            print(f"{task['id']}. {task['description']} {task['status']}")

    def add_task(self, description):
        # Verifica se a descrição da tarefa começa com maiúscula
        if not description[0].isupper():
            print("A descrição da tarefa deve começar com maiúscula.")
            return

        task_id = len(self.tasks) + 1
        new_task = {'id': task_id, 'description': description, 'status': '[ ]'}
        self.tasks.append(new_task)
        # Salva as tarefas após adicionar uma nova tarefa
        self.save_tasks()
        print("Tarefa registrada!!!")

    def mark_as_done(self, task_id):
        for task in self.tasks:
            if task['id'] == task_id:
                task['status'] = '[x]'
                self.tasks.remove(task)
                self.tasks.insert(0, task)
                # Salva as tarefas após marcar uma tarefa como realizada
                self.save_tasks()
                print("Tarefa marcada como realizada!!!")
                return
        print("Tarefa não encontrada ou já realizada.")

    def edit_task(self, task_id, new_description):
        for task in self.tasks:
            if task['id'] == task_id:
                task['description'] = new_description
                # Salva as tarefas após editar uma tarefa
                self.save_tasks()
                print("Tarefa editada!!!")
                return
        print("Tarefa não encontrada.")

# Título do aplicativo
print("##### Controle de Tarefas #####")

# Exemplo de uso do aplicativo
todo_list = ToDoList()

while True:
    print("\nOpções:")
    print("1. Listar tarefas")
    print("2. Adicionar nova tarefa")
    print("3. Marcar tarefa como realizada")
    print("4. Editar tarefa")
    print("0. Sair")

    choice = input("Escolha uma opção: ")

    if choice == '1':
        todo_list.list_tasks()
    elif choice == '2':
        description = input("Digite a descrição da tarefa: ")
        todo_list.add_task(description)
    elif choice == '3':
        task_id = int(input("Digite o ID da tarefa a ser marcada como realizada: "))
        todo_list.mark_as_done(task_id)
    elif choice == '4':
        task_id = int(input("Digite o ID da tarefa a ser editada: "))
        new_description = input("Digite a nova descrição da tarefa: ")
        todo_list.edit_task(task_id, new_description)
    elif choice == '0':
        print("Saindo do aplicativo. Até logo!")
        break
    else:
        print("Opção inválida. Tente novamente.")
