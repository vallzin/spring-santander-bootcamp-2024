package dio.domain.service.impl;

import dio.domain.model.Task;
import dio.domain.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    @Override
    public List<Task> getAllTasks() {
        return List.of();
    }

    @Override
    public Task getTaskById(Long id) {
        return null;
    }

    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public Task updateTask(Long id, Task taskDetails) {
        return null;
    }

    @Override
    public void deleteTask(Long id) {

    }
}
