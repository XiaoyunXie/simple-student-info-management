package bean;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 学生信息管理系统
 */
public class StudentInfoManagementSystem {
    private List<StudentInfo> studentInfos;//学生信息

    /**
     * 增加一项学生信息
     * @param studentInfo 需要新增的学生信息
     * @return 是否增加成功
     */
    public boolean add(StudentInfo studentInfo){
        //检查学生信息是否已存在
        if(studentInfos.stream().filter((ele) -> ele.getId().equals(studentInfo.getId())).count()!=0) return false;
        if(studentInfo.getId() == null || studentInfo.getName() == null || studentInfo.getAge() == null
            ||studentInfo.getScores() == null) {
            return false;
        }
        studentInfos.add(studentInfo);
        return true;
    }

    /**
     * 删除一项学生信息
     * @param studentInfo 包含学生id的学生信息
     */
    public void delete(StudentInfo studentInfo){
        StudentInfo studentInfo1 = new StudentInfo(studentInfo.getId(),null,null,null);
        studentInfos.removeAll(search(studentInfo1));
    }

    /**
     * 根据学生id查找学生信息
     * @param studentInfo 包含学生id的学生信息
     * @return 学生信息对象
     */
    public List<StudentInfo> search(StudentInfo studentInfo){
        String id = studentInfo.getId();
        return studentInfos.stream().filter((ele) -> ele.getId().equals(id)).collect(Collectors.toList());
    }

    /**
     * 根据传入参数修改学生信息
     * @param studentInfo 包含修改项的学生信息
     */
    public void modify(StudentInfo studentInfo){
        List<StudentInfo> studentInfos1 = search(studentInfo);
        if(studentInfo.getId() != null){
            studentInfos1.get(0).setId(studentInfo.getId());
        }
        if(studentInfo.getAge() != null){
            studentInfos1.get(0).setAge(studentInfo.getAge());
        }
        if(studentInfo.getName() != null){
            studentInfos1.get(0).setName(studentInfo.getName());
        }
        if(studentInfo.getScores() != null){
            studentInfos1.get(0).setScores(studentInfo.getScores());
        }
    }
    public StudentInfoManagementSystem(List<StudentInfo> studentInfos) {
        this.studentInfos = studentInfos;
    }

    public List<StudentInfo> getStudentInfos() {
        return studentInfos;
    }

    public void setStudentInfos(List<StudentInfo> studentInfos) {
        this.studentInfos = studentInfos;
    }

    @Override
    public String toString() {
        return "StudentInfoManagementSystem{" +
                "studentInfos=" + studentInfos +
                '}';
    }
}
