package bean;


import java.util.Map;

/**
 * 学生信息
 */
public class StudentInfo {
    private String id;//学号，作为学生的唯一标识
    private String name;//姓名
    private Integer age;//年龄
    private Map<String,Double> scores;//成绩

    public StudentInfo(String id, String name, Integer age, Map<String, Double> scores) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.scores = scores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, Double> getScores() {
        return scores;
    }

    public void setScores(Map<String, Double> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", scores=" + scores +
                '}';
    }
}
