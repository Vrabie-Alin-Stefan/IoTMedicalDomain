package Statistics;

import java.util.ArrayList;

import Models.Diagnostic;
import Models.ResponseDiagnostic;

public interface StatisticalPrediction {
    ResponseDiagnostic makeAPrediction(ArrayList<Diagnostic> diagnosticArrayList);
}
