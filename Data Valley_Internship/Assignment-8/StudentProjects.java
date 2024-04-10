import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Project {
    String studentName;
    String projectName;
    String completionStatus;
    int completionTime;

    public Project(String studentName, String projectName, String completionStatus, int completionTime) {
        this.studentName = studentName;
        this.projectName = projectName;
        this.completionStatus = completionStatus;
        this.completionTime = completionTime;
    }
}

public class StudentProjects {

    public static void main(String[] args) {
        List<Project> studentProjects = new ArrayList<>();

        studentProjects.add(new Project("Student1", "Project1", "on time", 10));
        studentProjects.add(new Project("Student1", "Project2", "late", 12));
        studentProjects.add(new Project("Student1", "Project3", "early", 8));
        studentProjects.add(new Project("Student2", "Project1", "on time", 11));
        studentProjects.add(new Project("Student2", "Project2", "late", 15));
        studentProjects.add(new Project("Student3", "Project1", "early", 7));

        Map<String, List<Project>> studentWiseProjects = new HashMap<>();

        for (Project project : studentProjects) {
            if (!studentWiseProjects.containsKey(project.studentName)) {
                studentWiseProjects.put(project.studentName, new ArrayList<>());
            }
            studentWiseProjects.get(project.studentName).add(project);
        }

        int totalProjects = studentProjects.size();
        int onTime = 0, late = 0, early = 0;
        long totalTime = 0;

        for (Map.Entry<String, List<Project>> entry : studentWiseProjects.entrySet()) {
            int studentOnTime = 0, studentLate = 0, studentEarly = 0;
            long studentTotalTime = 0;
            for (Project project : entry.getValue()) {
                if (project.completionStatus.equalsIgnoreCase("on time")) {
                    onTime++;
                } else if (project.completionStatus.equalsIgnoreCase("late")) {
                    late++;
                } else if (project.completionStatus.equalsIgnoreCase("early")) {
                    early++;
                }
                studentTotalTime += project.completionTime;
                studentTotalTime = studentTotalTime % 24 * 60 + studentTotalTime / 60; // Convert to minutes

                if (project.completionStatus.equalsIgnoreCase("on time")) {
                    studentOnTime++;
                } else if (project.completionStatus.equalsIgnoreCase("late")) {
                    studentLate++;
                } else if (project.completionStatus.equalsIgnoreCase("early")) {
                    studentEarly++;
                }
            }

            System.out.printf("%s: on time %d, late %d, early %d, average time %d minutes%n",
                    entry.getKey(), studentOnTime, studentLate, studentEarly, studentTotalTime / entry.getValue().size());

            totalTime += studentTotalTime;
        }

        System.out.printf("Total: on time %d, late %d, early %d, average time %d minutes%n", onTime, late, early, totalTime / totalProjects);
    }
}