package Statistics;

import java.util.ArrayList;

import Models.Diagnostic;
import Models.ResponseDiagnostic;

public class PredictionDecorator implements StatisticalPrediction {
     StatisticalPrediction stp;

    public PredictionDecorator(StatisticalPrediction stp) {
        this.stp = stp;
    }

    @Override
    public ResponseDiagnostic makeAPrediction(ArrayList<Diagnostic> diagnosticArrayList) {
           return  this.stp.makeAPrediction(diagnosticArrayList);
    }
}
