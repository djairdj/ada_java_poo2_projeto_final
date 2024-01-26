package domain;

import java.util.UUID;

public class Task {
  protected UUID id;
  protected String description;
  protected String status;

  public Task(String description, String status) {
    this.description = description;
    this.status = status;
  }

  public Task() {
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Task{");
    sb.append("id=").append(id);
    sb.append(", description='").append(description).append('\'');
    sb.append(", status='").append(status).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
