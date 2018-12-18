package com.kirylshreyter.smart_dictionary.webapp.models.security;

public class Check {
    private boolean valid;

    public Check(){
    }

    public Check(boolean valid){
        this.valid = valid;
    }

    public boolean getValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
