package domain;

public class Task implements Cloneable {
  private static Integer serial = 0;
  protected Integer id;
  protected String description;
  protected String status;

  public Task(String description, String status) {
    this();
    this.description = description;
    this.status = status;
  }

  public Task() {
    this.id = ++serial;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  @Override
  public Task clone() throws CloneNotSupportedException {
    return (Task) super.clone();
  }
}
