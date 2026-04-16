package com.example.startertemplate;

/**
 * Small model used by StarterActivity to prepare output text.
 */
public class StarterFormData {

    private final String inputText;
    private final boolean checked;
    private final String selectedRadio;
    private final boolean switchOn;
    private final int seekValue;
    private final String spinnerValue;

    public StarterFormData(
            String inputText,
            boolean checked,
            String selectedRadio,
            boolean switchOn,
            int seekValue,
            String spinnerValue
    ) {
        this.inputText = inputText;
        this.checked = checked;
        this.selectedRadio = selectedRadio;
        this.switchOn = switchOn;
        this.seekValue = seekValue;
        this.spinnerValue = spinnerValue;
    }

    public String toDisplayText() {
        return "Input: " + inputText
                + "\nChecked: " + checked
                + "\nRadio: " + selectedRadio
                + "\nSwitch: " + switchOn
                + "\nSeek: " + seekValue
                + "\nSpinner: " + spinnerValue;
    }
}
