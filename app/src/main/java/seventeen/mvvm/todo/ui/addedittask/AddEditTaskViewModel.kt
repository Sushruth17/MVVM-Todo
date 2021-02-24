package seventeen.mvvm.todo.ui.addedittask

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import seventeen.mvvm.todo.data.Task
import seventeen.mvvm.todo.data.TaskDao

class AddEditTaskViewModel @ViewModelInject constructor(
        private val taskDao: TaskDao,
        @Assisted private val state: SavedStateHandle
): ViewModel() {

    val task = state.get<Task>("task")

    var taskName = state.get<String>("taskName") ?: task?.name ?: ""
        set(value) {
            field = value
            state.set("taskName", value)
        }

    var taskImportance = state.get<Boolean>("taskImportance") ?: task?.important ?: false
        set(value) {
            field = value
            state.set("taskImportance", value)
        }
}