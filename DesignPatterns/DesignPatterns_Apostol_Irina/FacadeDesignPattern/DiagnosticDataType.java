package FacadeDesignPattern;

public class DiagnosticDataType {
    Integer BeepPerMinute;
    Integer BloodPresure;
    Boolean AnalysisStatus;

    public DiagnosticDataType(Integer beepPerMinute, Integer bloodPresure, Boolean analysisStatus) {
        BeepPerMinute = beepPerMinute;
        BloodPresure = bloodPresure;
        AnalysisStatus = analysisStatus;
    }

    public Integer getBeepPerMinute() {
        return BeepPerMinute;
    }

    public void setBeepPerMinute(Integer beepPerMinute) {
        BeepPerMinute = beepPerMinute;
    }

    public Integer getBloodPresure() {
        return BloodPresure;
    }

    public void setBloodPresure(Integer bloodPresure) {
        BloodPresure = bloodPresure;
    }

    public Boolean getAnalysisStatus() {
        return AnalysisStatus;
    }

    public void setAnalysisStatus(Boolean analysisStatus) {
        AnalysisStatus = analysisStatus;
    }


}
