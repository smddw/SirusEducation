

package util;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;


public class ToolTP {
    
    private TextField textField;
    private ComboBox<?> comboBox;
    private TextArea textArea;
    private DatePicker datePicker;
    private String toolTipStyle = "-fx-background-radius: 7 7 7 7;-fx-background-color:  linear-gradient(red, orangered );";
    
    public ToolTP(TextField textField, Tooltip tooltip){
        this.textField = textField;
        if (tooltip != null) {
            tooltip.setStyle(toolTipStyle);
        }
        this.textField.setTooltip(tooltip);
    }
    
    public ToolTP(ComboBox<?> comboBox, Tooltip tooltip){
        this.comboBox = comboBox;
        if (tooltip != null) {
            tooltip.setStyle(toolTipStyle);
        }
        this.comboBox.setTooltip(tooltip);
    }
    
    public ToolTP(TextArea textArea, Tooltip tooltip){
        this.textArea = textArea;
        if (tooltip != null) {
            tooltip.setStyle(toolTipStyle);
        }
        this.textArea.setTooltip(tooltip);
    }    
    
    public ToolTP(DatePicker datePicker, Tooltip tooltip){
        this.datePicker = datePicker;
        if (tooltip != null) {
            tooltip.setStyle(toolTipStyle);
        }
        this.datePicker.setTooltip(tooltip);
    }    
}
