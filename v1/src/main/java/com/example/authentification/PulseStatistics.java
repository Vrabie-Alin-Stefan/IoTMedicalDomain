package com.example.authentification;

import android.util.Log;

import java.text.NumberFormat;

public class PulseStatistics {

    public int value;

    public PulseStatistics(int val) {
        this.value = val;
    }

    public String statisticByAge(int age) {

        if (this.value < 50) {
            return "Too Low!";
        }

        if (age >= 18 && age <= 25) {
            if (this.value > 56 && this.value < 83) {
                return "Normal";
            }
        }

        if (age >= 26 && age <= 35) {
            if (this.value > 55 && this.value < 84) {
                return "Normal";
            }
        }

        if (age >= 36 && age <= 45) {
            if (this.value > 57 && this.value < 85) {
                return "Normal";
            }
        }

        if (age >= 46 && age <= 55) {
            if (this.value > 58 && this.value < 86) {
                return "Normal";
            }
        }
        if (age >= 56 && age <= 65) {
            if (this.value > 57 && this.value < 85) {
                return "Normal";
            }
        }
        if (age >= 66) {
            if (this.value > 56 && this.value < 83) {
                return "Normal";
            }
        }

        if (this.value >= 100) {
            return "Too High!";
        }

        return "Not normal";
    }

    public int statisticByGender(String gender) {
        if (gender.equals("female")) {
            if (this.value <= 90) {
                return 1;
            }
        } else {
            if (this.value <= 85) {
                return 1;
            }
        }
        return 0;
    }

    public double calculateBMI(int weight, int height) {

        double heighT = (double) height / 100;

        return weight / (heighT * heighT);

    }

    public String evaluateBMI(int weight, int height) {

        double bmi = calculateBMI(weight, height);

        if (bmi <= 16) {
            return "Severe Thinness";
        } else if (bmi > 16 && bmi <= 17) {
            return "Moderate Thinness";
        } else if (bmi > 17 && bmi <= 18.5) {
            return "Mild Thinness";
        } else if (bmi > 18.5 && bmi <= 25) {
            return "Normal";
        } else if (bmi > 25 && bmi <= 30) {
            return "Overweight";
        } else if (bmi > 30 && bmi <= 35) {
            return "Obese Class I";
        } else if (bmi > 35 && bmi <= 40) {
            return "Obese Class II";
        } else if (bmi > 40) {
            return "Obese Class III";
        }

        return null;
    }

    public int statisticsByBMI(int weight, int height) {

        double bmi = calculateBMI(weight, height);

        if (bmi > 30) {
            if (this.value > 60 && this.value <= 110) {
                return 1;
            }
        } else if (bmi < 30) {
            if (this.value > 52 && this.value < 90) {
                return 1;
            }
        }

        return 0;
    }


}
