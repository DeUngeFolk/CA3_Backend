package dtos;

public class FoxFactDTO {

    private String[] data;
    private String foxFact;

    public FoxFactDTO(FoxFactDTO foxFactDTO) {
        this.foxFact = foxFactDTO.getData()[0];
    }

    public FoxFactDTO(String foxFact) {
        this.foxFact = foxFact;
    }

    public String getFact() {
        return foxFact;
    }

    public void setFact(String fact) {
        this.foxFact = fact;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
