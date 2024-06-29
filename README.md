# Publicando Sua API REST na Nuvem Usando Spring Boot 3, Java 17 e Railway

Projeto básico de API REST para gerenciamento de tarefas fornece uma base sólida para você começar a explorar e expandir suas habilidades em desenvolvimento de APIs usando Spring Boot.

## Passos para criar o projeto:

1. Configuração do Projeto
   
     Criando um projeto Spring Boot usando o Spring Initializr (https://start.spring.io/).

3. Dependências
   
     Spring Web (Spring MVC):
   
     Permite construir aplicações web RESTful usando Spring MVC. Inclui um servidor Apache Tomcat incorporado por padrão.
   
     Spring Data JPA:
   
     Facilita a persistência de dados em bancos de dados relacionais usando JPA (Java Persistence API) com o auxílio do Hibernate
   
     H2 Database:
   
     Banco de dados em memória que suporta acesso via JDBC e R2DBC, com uma aplicação de console baseada em navegador para gerenciamento.
   
     PostgreSQL Driver:
   
     Driver JDBC e R2DBC que permite a conexão de programas Java a bancos de dados PostgreSQL usando código Java independente do banco de dados.

#
```mermaid
classDiagram
    class Task {
        <<Entity>>
        + Long id
        + String title
        + boolean completed
        --
        + getters/setters
    }

    class TaskController {
        <<RestController>>
        + List<Task> getAllTasks()
        + Task createTask(Task task)
        + Task getTaskById(Long id)
        + Task updateTask(Long id, Task taskDetails)
        + void deleteTask(Long id)
    }

    class TaskRepository {
        <<JpaRepository>>
        --
        + Task save(Task task)
        + List<Task> findAll()
        + Optional<Task> findById(Long id)
        + void delete(Task task)
    }

    Task -- TaskController : uses
    TaskController -- TaskRepository : uses

```


#Explicação Detalhada

**1. Modelo (Task):**

- Representa uma tarefa.

- Anotada com @Entity para ser gerenciada pelo JPA.
```java
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
```
**2. Repositório (TaskRepository):**

- Interface que estende JpaRepository, fornecendo métodos para operações CRUD.

- Anotada com @Repository.
```java
    @Repository
    public interface TaskRepository extends JpaRepository<Task, Long> {
    }
```
**3. Serviço (TaskService e TaskServiceImpl):**

- TaskService define métodos de negócio.

- TaskServiceImpl implementa TaskService e realiza operações usando TaskRepository.

- Anotada com @Service.
```java
public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task createTask(Task task);
    Task updateTask(Long id, Task taskDetails);
    void deleteTask(Long id);
}
@Service
public class TaskServiceImpl implements TaskService {}
```
**4. Controlador (TaskController):**

- Define endpoints REST para operações CRUD.

- Anotada com @RestController e @RequestMapping.

- Injeção de dependência do TaskService usando @Autowired.
```java
@RestController
@RequestMapping("/tasks")
public class TaskController {}
```

**5. Configuração do Banco de Dados:**

- H2 para desenvolvimento, PostgreSQL para produção (descomentar e configurar conforme necessário)

