package sample;

import bean.StudentInfo;
import bean.StudentInfoManagementSystem;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class    Controller implements Initializable {

    @FXML
    private TextArea viewContext;
    @FXML
    private TextArea id_input;
    @FXML
    private TextArea name_input;
    @FXML
    private TextArea age_input;
    @FXML
    private TextArea score1_input;
    @FXML
    private TextArea score2_input;
    @FXML
    private TextArea score3_input;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button search;
    @FXML
    private Button modify;
    @FXML
    private Button allInfo;

    private StudentInfoManagementSystem studentInfoManagementSystem = new StudentInfoManagementSystem(new ArrayList<StudentInfo>());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void add(ActionEvent event){
        String id = id_input.getText().isEmpty() ? null : id_input.getText();
        String name = name_input.getText().isEmpty() ? null : name_input.getText();
        Integer age = null;
        if(!age_input.getText().isEmpty()){
            age = Integer.valueOf(age_input.getText());
        }

        Map<String,Double> scores = null;
        if(!score1_input.getText().isEmpty() && !score2_input.getText().isEmpty() && !score3_input.getText().isEmpty()){
            scores = new HashMap<>();
            scores.put("score1",Double.valueOf(score1_input.getText()));
            scores.put("score2",Double.valueOf(score2_input.getText()));
            scores.put("score3",Double.valueOf(score3_input.getText()));
        }
        StudentInfo studentInfo = new StudentInfo(id,name,age,scores);
        boolean flag = studentInfoManagementSystem.add(studentInfo);
        if(flag) viewContext.appendText("成功增加学生信息!\n");
        else viewContext.appendText("增加失败！\n");
        clear();
    }

    public void delete(ActionEvent event){
        if(id_input.getText().isEmpty()){
            viewContext.appendText("删除失败\n");
            return;
        }
        String id = id_input.getText();
        StudentInfo studentInfo = new StudentInfo(id,null,0,null);
        List<StudentInfo> studentInfos = studentInfoManagementSystem.search(studentInfo);
        if(studentInfos.isEmpty()){
            viewContext.appendText("删除失败\n");
            return;
        }
        studentInfoManagementSystem.delete(studentInfos.get(0));
        viewContext.appendText("删除成功！\n");
        clear();
    }

    public void search(ActionEvent event){
        if(id_input.getText().isEmpty()){
            viewContext.appendText("查询失败\n");
            return;
        }
        String id = id_input.getText();
        StudentInfo studentInfo = new StudentInfo(id,null,0,null);
        List<StudentInfo> studentInfos = studentInfoManagementSystem.search(studentInfo);
        if(studentInfos.isEmpty()){
            viewContext.appendText("查询失败\n");
            return;
        }
        viewContext.appendText("所查询的学生信息：\n");
        viewContext.appendText("学号：" + studentInfos.get(0).getId() + "\n");
        viewContext.appendText("姓名：" + studentInfos.get(0).getName() + "\n");
        viewContext.appendText("年龄：" + studentInfos.get(0).getAge() + "\n");
        viewContext.appendText("第一门课成绩：" + studentInfos.get(0).getScores().get("score1") + "\n");
        viewContext.appendText("第二门课成绩：" + studentInfos.get(0).getScores().get("score2") + "\n");
        viewContext.appendText("第三门课成绩：" + studentInfos.get(0).getScores().get("score3") + "\n");
        clear();
    }

    public void modify(ActionEvent event){
        if(id_input.getText().isEmpty()){
            viewContext.appendText("修改失败\n");
            return;
        }
        String id = id_input.getText();
        String name = name_input.getText().isEmpty() ? null : name_input.getText();
        Integer age = null;
        if(!age_input.getText().isEmpty()){
            age = Integer.valueOf(age_input.getText());
        }

        Map<String,Double> scores = null;
        if(!score1_input.getText().isEmpty() && !score2_input.getText().isEmpty() && !score3_input.getText().isEmpty()){
            scores = new HashMap<>();
            scores.put("score1",Double.valueOf(score1_input.getText()));
            scores.put("score2",Double.valueOf(score2_input.getText()));
            scores.put("score3",Double.valueOf(score3_input.getText()));
        }
        StudentInfo studentInfo = new StudentInfo(id,name,age,scores);
        studentInfoManagementSystem.modify(studentInfo);
        viewContext.appendText("修改成功\n");
        clear();
    }

        /**
         * 清空所有输入框信息
         */
        public void clear(){
            name_input.clear();
            age_input.clear();
            id_input.clear();
            score1_input.clear();
            score2_input.clear();
            score3_input.clear();
        }

    public void getAllInfo(){
        Iterator<StudentInfo> iter = studentInfoManagementSystem.getStudentInfos().iterator();
        viewContext.appendText("所有学生信息：\n");
        while (iter.hasNext()){
            StudentInfo studentInfo = iter.next();
            viewContext.appendText("学号：" + studentInfo.getId() + "\n");
            viewContext.appendText("姓名：" + studentInfo.getName() + "\n");
            viewContext.appendText("年龄：" + studentInfo.getAge() + "\n");
            viewContext.appendText("第一门课成绩：" + studentInfo.getScores().get("score1") + "\n");
            viewContext.appendText("第二门课成绩：" + studentInfo.getScores().get("score2") + "\n");
            viewContext.appendText("第三门课成绩：" + studentInfo.getScores().get("score3") + "\n");
            viewContext.appendText("----------------------------------------\n");
        }
    }

}
