package com.fg.archive.tool.destination.service.helper;

import com.fg.archive.tool.common.model.SourceDBTableSchema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArchiveDBTableManipulationServiceHelper {

    @Value("${arch.tool.federate.link}")
    private String federateLink;

    public String createTableScriptGeneratingHelper(String sourceTableName,String destinationTableName, String engine, List<SourceDBTableSchema> schemaList){

        String sqlColumn = "";
        String keyColumn = "";
        String federate = ";";
        String sqlString = ";";

        if(engine.equals("FEDERATED")){
            federate = " CONNECTION='"+this.federateLink+sourceTableName+"';";
        }

        for(SourceDBTableSchema column: schemaList){

            if(column.getKey().equals("PRI")){
                keyColumn = column.getField();
            }

            sqlColumn = sqlColumn + "`"+column.getField()+"` "+column.getType()+", ";

        }

       sqlString = "CREATE TABLE IF NOT EXISTS `"+destinationTableName+"` " +
                "(" +sqlColumn+"" +
                "PRIMARY KEY (`"+keyColumn+"`)) " +
                "ENGINE="+engine+ federate;
        System.out.println(sqlString);
        return sqlString;
    }

}
