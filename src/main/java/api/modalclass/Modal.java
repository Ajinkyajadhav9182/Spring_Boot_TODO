package api.modalclass;

public class Modal {
    private int taskId;
    private String taskName;
    private int priority;
    private String description;
    private String progress;

    public Modal() {

    }

    public Modal(int taskId, String taskName, int priority, String description, String progress) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.description = description;
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Modal{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", progress='" + progress + '\'' +
                '}';
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}