package com.example.bartek.marcin.listViewClasses;

/**
 * Created by Bartek on 26.04.2016.
 */
public class TemplatesDataListProvider {
    private String dataField;
    private String inputField;

    public String getDataField() {
        return dataField;
    }

    public void setDataField(String dataField) {
        this.dataField = dataField;
    }

    public String getInputField() {
        return inputField;
    }

    public void setInputField(String inputField) {
        this.inputField = inputField;
    }

    public TemplatesDataListProvider(String dataField, String inputField){
        this.setDataField(dataField);
        this.setInputField(inputField);
    }
}
