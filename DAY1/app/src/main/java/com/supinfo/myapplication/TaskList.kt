package com.supinfo.myapplication

class TaskList {
    val tasks = mutableListOf<Task>()

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun markTaskAsDone(taskIndex: Int) {
        tasks[taskIndex].isDone = true
    }

    fun removeTask(task: Task) {
        tasks.removeAt(task)
    }

    fun editTask(taskIndex: Task, newTask: Task) {
        tasks[taskIndex] = newTask
    }

    fun filterTasks(isDone: Boolean): List<Task> {
        return if (isDone) {
            tasks.filter { it.isDone }
        } else {
            tasks.filterNot { it.isDone }
        }
    }

    fun displayTasks() {
        for ((index, task) in tasks.withIndex()) {
            println("Task ${index + 1}: ${task.title} - ${task.description} (Done: ${task.isDone})")
        }
    }
}

private operator fun <E> MutableList<E>.set(taskIndex: E, value: E) {

}

private fun <E> MutableList<E>.removeAt(index: E) {
}
