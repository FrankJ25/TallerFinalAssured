package helper;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Report {

    public static void main (String[] args){
        String ruta=  new File("").getAbsolutePath()+"/build/reports/cucumber/";

        File report= new File(ruta+"TallerFinal");

        List<String> jsons=  new ArrayList<>();
        jsons.add(ruta+"report.json");

        Configuration configuration= new Configuration(report,"Frank");
        configuration.setBuildNumber("0001");
        configuration.addClassifications("Env","Todo.ly");
        configuration.addClassifications("SO","Windows");
        configuration.addClassifications("Owner","Eynar");

        ReportBuilder reportBuilder = new ReportBuilder(jsons,configuration);
        reportBuilder.generateReports();

    }

}
