package Statistics;

import java.util.ArrayList;

import Models.Diagnostic;
import Models.ResponseDiagnostic;

public class GeneralPrediction extends PredictionDecorator {
    public GeneralPrediction(StatisticalPrediction stp) {
        super(stp);
    }

    @Override
    public ResponseDiagnostic makeAPrediction(ArrayList<Diagnostic> diagnosticArrayList) {
        ResponseDiagnostic rd=  this.stp.makeAPrediction(diagnosticArrayList);
        // extend functionallity...

        return rd;

    }
}
