package Statistics;


import java.util.ArrayList;

import Models.Diagnostic;
import Models.ResponseDiagnostic;

public class LocalPrediction extends  PredictionDecorator {

    public LocalPrediction(StatisticalPrediction stp) {
        super(stp);
    }

    @Override
    public ResponseDiagnostic makeAPrediction(ArrayList<Diagnostic> diagnosticArrayList) {
        ResponseDiagnostic rd=  this.stp.makeAPrediction(diagnosticArrayList);
        // extend functionallity...
        rd=averagre(lagrangeInterpolation(diagnosticArrayList),rd);
        return rd;

    }

   public ResponseDiagnostic lagrangeInterpolation(ArrayList<Diagnostic> diagnosticArrayList){return  null;}
    public ResponseDiagnostic averagre(ResponseDiagnostic rd1,ResponseDiagnostic rd2){ return  null;}


}
