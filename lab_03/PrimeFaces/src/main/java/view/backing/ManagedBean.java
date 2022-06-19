/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import static java.lang.Math.cos;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

//with lineChart but not for iexplorer 
//import org.primefaces.model.charts.ChartData;
//import org.primefaces.model.charts.line.LineChartDataSet;
//import org.primefaces.model.charts.line.LineChartModel;

//with chart type="line" for iexplorer
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Sky
 */
@Named(value = "managedBean")
@RequestScoped
public class ManagedBean {
    
    private int num1 = 0;
    private int num2 = 0;
    private String num_sum = "0";
    
    private List<Student> students;
    
    private LineChartModel lineModel;
    
    public String curr_date() {
        String timeStamp = new SimpleDateFormat("yyyy:MM:dd-HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }
    
    public void sum() {
        int res = num1 + num2;
        num_sum = Integer.toString(res);
        FacesContext.getCurrentInstance().addMessage("op_done",
                new FacesMessage(Integer.toString(num1) + " + " + Integer.toString(num2) + " = " + num_sum));
    }

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student("Aaa", "Xxx", 2.0));
        students.add(new Student("Bbb", "Yyy", 3.0));
        students.add(new Student("Ccc", "Zzz", 5.0));
        
        lineModel = new LineChartModel();
        
        //reverse comments
//        ChartData data = new ChartData();
//        LineChartDataSet dataSet = new LineChartDataSet();
        LineChartSeries series = new LineChartSeries();
        series.setLabel("cos(x)");
//        List<Object> ys = new ArrayList<>();
//        List<Object> xs = new ArrayList<>();
        for(int i=0; i<360; i++) {
//            ys.add(cos(Math.toRadians(i)));
//            xs.add("");
            series.set(i, cos(Math.toRadians(i)));
        }
//        dataSet.setData(ys);
//        dataSet.setLabel("cos(x)");
//        data.addChartDataSet(dataSet);
//        data.setLabels(xs);
//        lineModel.setData(data);
        lineModel.addSeries(series);
        lineModel.setLegendPosition("e");
        lineModel.setZoom(true);
        
    }
    
    /**
     * Creates a new instance of ManagedBean
     */
    public ManagedBean() {
        
    }

    /**
     * @return the num1
     */
    public int getNum1() {
        return num1;
    }

    /**
     * @param num1 the num1 to set
     */
    public void setNum1(int num1) {
        this.num1 = num1;
    }

    /**
     * @return the num2
     */
    public int getNum2() {
        return num2;
    }

    /**
     * @param num2 the num2 to set
     */
    public void setNum2(int num2) {
        this.num2 = num2;
    }

    /**
     * @return the num_sum
     */
    public String getNum_sum() {
        return num_sum;
    }

    /**
     * @param num_sum the num_sum to set
     */
    public void setNum_sum(String num_sum) {
        this.num_sum = num_sum;
    }

    public static class Student {
        
        public String frs_name;
        public String sur_name;
        public double mean;

        public Student(String f_name, String s_name, double mn) {
            frs_name = f_name;
            sur_name = s_name;
            mean = mn;
        }

        /**
         * @return the frs_name
         */
        public String getFrs_name() {
            return frs_name;
        }

        /**
         * @param frs_name the frs_name to set
         */
        public void setFrs_name(String frs_name) {
            this.frs_name = frs_name;
        }

        /**
         * @return the sur_name
         */
        public String getSur_name() {
            return sur_name;
        }

        /**
         * @param sur_name the sur_name to set
         */
        public void setSur_name(String sur_name) {
            this.sur_name = sur_name;
        }

        /**
         * @return the mean
         */
        public double getMean() {
            return mean;
        }

        /**
         * @param mean the mean to set
         */
        public void setMean(double mean) {
            this.mean = mean;
        }
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * @return the lineModel
     */
    public LineChartModel getLineModel() {
        return lineModel;
    }

    /**
     * @param lineModel the lineModel to set
     */
    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }
    
}
