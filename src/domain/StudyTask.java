package domain;

public class StudyTask extends Task {
  private String subject;

  public StudyTask(String description, String status, String subject) {
    super(description, status);
    this.subject = subject;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("StudyTask{");
    sb.append("id=").append(id);
    sb.append(", subject='").append(subject).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", status='").append(status).append('\'');
    sb.append('}');
    return sb.toString();
  }

  @Override
  public StudyTask clone() throws CloneNotSupportedException {
    return (StudyTask) super.clone();
  }
}
